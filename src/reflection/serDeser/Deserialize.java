//---------------------------------------------------------------------
package reflection.serDeser;
//---------------------------------------------------------------------
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.util.Vector;
import java.util.HashMap;
import java.lang.reflect.Method;
import reflection.serDeser.DeserializeTypes;
//---------------------------------------------------------------------
import java.util.regex.Matcher;
import java.util.regex.Pattern;
//---------------------------------------------------------------------
import reflection.util.Debug;
//---------------------------------------------------------------------
public class Deserialize
{
	private final int errorVal = 2;
	private Debug debugClass;
	private BufferedReader br;
	private DeserializeTypes dTypes;

	private HashMap<String,Class> map1;

	//Regular expressions to get the class name
	private final String startClassRegex = "<complexType xsi:type=\"";
	private final String endClassRegex = "\">";
	//Regular expressions to get the class member name
	private final String startMemberNameRegex = "<";
	private final String endMemberNameRegex = " xsi:type.*>.*</.*>";
	//Regular expressions to get the type of the value
	private final String startTypeRegex = "<.*xsi:type=\"xsd:";
	private final String endTypeRegex = "\">.*</.*>";
	//Regular expressions to get the value as a string
	private final String startValueRegex = "<.*\">";
	private final String endValueRegex = "</.*>";


	/**
	*	Class constructor
	**/
	public	Deserialize(Debug debugClass, String inputFilename) 
		throws FileNotFoundException
	{
		//Sets the debug class variable 
		this.debugClass = debugClass;

		//Sets up the DeserializeTypes class
		dTypes = new DeserializeTypes(debugClass);
				
		//Attempts to open the buffered reader
		try
		{
			br = new BufferedReader(new FileReader(inputFilename));
		}
		catch(FileNotFoundException e)
		{
			//Print the exception and the errorVal
			System.out.println("ERROR: Unable to open input file: \"" 
				+ inputFilename + "\"");
			System.exit(errorVal);	
		}
		finally
		{
			//Empty
		}

		//Creates a new hashmap that is used in the DeserializeFile
		// method.
		map1 = new HashMap<String, Class>();
		map1.put("int", int.class);
		map1.put("String", String.class);
		map1.put("string", String.class);
		map1.put("double", double.class);
		map1.put("long", long.class);
		map1.put("char", char.class);
		map1.put("float", float.class);
		map1.put("short", short.class);
	}	

	/**
	*	This method deserializes a file and creates
	*	 the objects from the data file
	*
	*	@return Returns a vector of objects that was
	*		 constructed from the input file
	**/
	public Vector<Object> DeserializeFile() throws FileNotFoundException
	{
		Vector<Object> objectsVector = new Vector<Object>();
		Method dMet;
		Method fMet;
		Class cls;
		Object obj;
		String type;
		String dTypeName;
		String methodName;
		String value;
		String lineIn = " ";

		Class dT = dTypes.getClass();

		//Keeps parsing objects so long as the file is not null
		while(lineIn != null)
		{
			dMet = null;
			fMet = null;
			cls = null;
			obj = null;

			try
			{
				lineIn = br.readLine();

				//Checks for start of object
				if(lineIn != null)
				{
					//Skip the first line of the object
					// since it is <DPSerialization>
					lineIn = br.readLine();

					lineIn = parseValue(lineIn, startClassRegex,
						endClassRegex);
					try
					{
						cls = Class.forName(lineIn);
						obj = cls.newInstance();
					}
					catch(ClassNotFoundException e)
					{
						System.out.println("ERROR: Class unable"
						+ " to be initialized!");
						System.exit(errorVal);
					}

					lineIn = br.readLine();
					
					//Read a new line as long as it isent the end
					// of the object in the XML file
					while(!lineIn.equals(" </complexType>"))
					{
						type = parseValue(lineIn, startTypeRegex,
							endTypeRegex);
						//Formats the type string for the method name
						// in DeserializeTypes
						dTypeName = "Deserialize" +
						 type.substring(0,1).toUpperCase() +
						 type.substring(1);

						methodName = parseValue(lineIn,
							startMemberNameRegex, endMemberNameRegex);
						methodName = "set" + 
						 methodName.substring(0,1).toUpperCase() +
						 methodName.substring(1);

						value = parseValue(lineIn, startValueRegex, 
							endValueRegex);

						//Tries to get the method declared in 
						// the DeserializeTypes class
						try
						{
							dMet = dT.getDeclaredMethod(dTypeName,
								map1.get("String"));
						}
						catch(NoSuchMethodException e)
						{
							System.out.println("ERROR: Type not defined" 
								+ " in DeserializeTypes class");
							System.exit(errorVal);
						}

						//Tries to get the declared method
						try
						{
							fMet = cls.getDeclaredMethod(methodName, map1.get(type));	
						}
						catch(NoSuchMethodException e)
						{
							System.out.println("ERROR: method for"
								+ " variable not intialized or"
								+ " declared! ");
							System.exit(errorVal);
						}

						try
						{
							fMet.invoke(obj, dMet.invoke(dTypes, value));
						}
						catch(Exception e)
						{
							System.out.println("ERROR: unable to invoke"
							+ " method!");
							System.exit(errorVal);
						}

						lineIn = br.readLine();
					}

					//Reads the end tag
					lineIn = br.readLine();
					objectsVector.add(obj);
				}				

			}
			catch(Exception e)
			{
				System.out.println("ERROR: Unable to read"
					+ " line from input file!");
				System.exit(errorVal);
			}
		}

		try
		{
			br.close();
		}
		catch(Exception e)
		{
			System.out.println("ERROR: Unable to close input file!");
			System.exit(errorVal);
		}
		
		return objectsVector;
	}

	/**
	*	This method is used to parse a string and return 
	*	 the string found based on the regular expression
	*	 values passed.
	*
	*	@return Returns the value found as a string
	**/
	public String parseValue(String lineIn, String regex1, 
		String regex2)
	{
		Pattern pat;
		Matcher match;
		String result = null;
		int begIndex = -1;
		int endIndex = -1;
		if(lineIn != null)
		{
			try
			{
				//Beginning tag parsing
				pat = Pattern.compile(regex1);
				match = pat.matcher(lineIn);
				if(match.find())
				{
					begIndex = match.end();
				}

				//End tag parsing
				pat = Pattern.compile(regex2);
				match = pat.matcher(lineIn);
			
				if(match.find())
				{
					endIndex = match.start();
				}	
			}
			catch(Exception e)
			{
				System.out.println("ERROR: attempted parse of" 
					+ "string: \"" + lineIn +"\"" +
					" failed!");
				System.exit(errorVal);
			}
		
			//Checks to ensure there actually was a value
			if(begIndex < endIndex && begIndex > 0)
			{
				result = lineIn.substring(begIndex,endIndex);
			}
		}
		return result;
	}

}//End of class Deserialize
//---------------------------------------------------------------------
