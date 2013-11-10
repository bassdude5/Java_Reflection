//---------------------------------------------------------------------
package reflection.serDeser;
//---------------------------------------------------------------------
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import reflection.serDeser.DeserializeTypes;
//---------------------------------------------------------------------
import reflection.util.Debug;
//---------------------------------------------------------------------
public class Deserialize
{
	private final int errorVal = 2;

	private Debug debugClass;
	private BufferedReader br;
	private DeserializeTypes dTypes;

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
	public Object[] DeserializeFile() throws FileNotFoundException
	{
		String lineIn = " ";
		int i = 0;
		int intVal = 0;

		while(lineIn != null)
		{
			try
			{
				lineIn = br.readLine();
				
				if(lineIn != null)
				{
					if(i == 2)
					{
						intVal = dTypes.DeserializeInt(lineIn);	
					}
					else
					{
						//System.out.println(lineIn);
					}				
				}
			}
			catch(Exception e)
			{
				System.out.println("ERROR: Unable to read"
					+ " line from input file!");
				System.exit(errorVal);
			}
			i++;
		}
	
		System.out.println("intVal value: " + intVal);

		return null;
	}

	/**
	*	This method is used to parse a string and return 
	*	 the string found based on the regular expression
	*	 values passed.
	*
	*	@return Returns the value found as a string
	**/
	public String parseValue(String inLine, String regex1, 
		String regex2)
	{
		return null;
	}

}//End of class Deserialize
//---------------------------------------------------------------------
