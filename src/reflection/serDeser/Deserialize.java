package reflection.serDeser;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;

public class Deserialize
{
	private final int error_val = 2;

	public	Deserialize()
	{

	}	

	public Object[] DeserializeFile(String fileName) throws FileNotFoundException
	{
		BufferedReader br = new BufferedReader(new FileReader(fileName));
		
		String lineIn = " ";

		while(lineIn != null)
		{
			try
			{
				lineIn = br.readLine();
			}
			catch(Exception e)
			{
				System.exit(error_val);
			}
			if(lineIn != null)
			{

			}
			//if statements with pattern matching
			//Only check for neccesary input, ignore everything else
		}
	
		return null;
	}

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
}
