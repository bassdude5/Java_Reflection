//---------------------------------------------------------------------
package reflection.serDeser;
//---------------------------------------------------------------------
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.util.Vector;
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
	}	

	/**
	*	This method deserializes a file and creates
	*	 the objects from the data file
	*
	*	@return Returns an array of objects that was
	*		 constructed from the input file
	**/
	public Vector<Class> DeserializeFile() throws FileNotFoundException
	{
		Vector<Class> objectsVector = new Vector<Class>();
		String type;
		String methodName;

		String lineIn = " ";
		while(lineIn != null)
		{
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
						objectsVector.add(Class.forName(lineIn));
					}
					catch(ClassNotFoundException e)
					{
						System.out.println("ERROR: Class unable"
						+ " to be initialized!");
						System.exit(errorVal);
					}

					//System.out.println(lineIn);

					lineIn = br.readLine();
					
					//Read a new line as long as it isent the end
					// of the object in the XML file
					while(!lineIn.equals(" </complexType>"))
					{
						type = parseValue(lineIn, startTypeRegex,
							endTypeRegex);
						methodName = parseValue(lineIn,
							startMemberNameRegex, endMemberNameRegex);
						System.out.println(methodName + " has type: " + type);
						lineIn = br.readLine();
					}

					//Reads the end tag
					lineIn = br.readLine();
				}				


			}
			catch(Exception e)
			{
				System.out.println("ERROR: Unable to read"
					+ " line from input file!");
				System.exit(errorVal);
			}
		}

		//System.out.println(objectsVector.size());
	
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
		String result = "";
		int begIndex = -1;
		int endIndex = -1;

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

		return result;
	}

}//End of class Deserialize
//---------------------------------------------------------------------
