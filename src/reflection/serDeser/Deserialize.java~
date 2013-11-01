//---------------------------------------------------------------------
package reflection.serDeser;
//---------------------------------------------------------------------
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
//---------------------------------------------------------------------
import reflection.util.Debug;
//---------------------------------------------------------------------
public class Deserialize
{
	private final int errorVal = 2;

	Debug debugClass;
	BufferedReader br;

	/**
	*	Class constructor
	**/
	public	Deserialize(Debug debugClass, String inputFilename) 
		throws FileNotFoundException
	{
		//Sets the debug class variable 
		this.debugClass = debugClass;

		//Attempts to open the buffered reader
		try
		{
			br = new BufferedReader(new FileReader(inputFilename));
		}
		catch(FileNotFoundException e)
		{
			//Print the exception and the errorVal
			System.out.println("ERROR: Unable to open file!");
			System.exit(errorVal);	
		}
		finally
		{
			//Empty
		}
	}	

	/**
	*	This method deserializes a file and creates
	*	 the corrisponding objects
	*
	*	@return Returns an array of objects that was
	*		 constructed from the input file
	**/
	public Object[] DeserializeFile() throws FileNotFoundException
	{
		String lineIn = " ";

		while(lineIn != null)
		{
			try
			{
				lineIn = br.readLine();
				if(lineIn != null)
				{
					System.out.println(lineIn);
					
					//Parse the file
				}
			}
			catch(Exception e)
			{
				System.out.println("ERROR: Unable to read line from input file!");
				System.exit(errorVal);
			}
			if(lineIn != null)
			{

			}
			//if statements with pattern matching
			//Only check for neccesary input, ignore everything else
		}
	
		return null;
	}

	/**
	*	This method deserializes a single object from
	*	 the string array that is passed
	*	
	*	@return Returns an object that was constructed 
	*		 from the string array
	**/
	public Object DeserializeObj(String[] objectString)
	{
		//Use regular expressions in here to parse input

		return null;	
	}

	/*************************************************************
		BufferedReader inputFile;

	public Parse(String filename) throws FileNotFoundException
	{
		try
		{
			//Opens the file
			inputFile = new BufferedReader(new FileReader(filename));
		}
		catch(FileNotFoundException e)
		{
			throw new FileNotFoundException("\nERROR: File not found!\n"
			 + e.toString());
		}		
	}

	public Boolean parseAll()
	{
		
		return true;
	}

	/**
	*	This method gets the next object from the 
	*	 text file and returns the object as a String
	*	 array.
	*	@return Returns a String array with a object
	*	 as defined in the XML format (unparsed raw text)
	**/
	/*public String[] getObjectArray()
	{
		//Read <DPSerialization> 
		//Read the object type and path
		//Read all variables for object and initalize
		//read </complexType>
		//read </DPSerialization>

		//put "good input" into array, just ignore bad imput

		//increment counter for number of objects

		return null;

	}
	*************************************************************/	
}//End of class Deserialize
//---------------------------------------------------------------------
