//---------------------------------------------------------------------
package reflection.util;
//---------------------------------------------------------------------
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;

public class Parse 
{
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
	public String[] getObjectArray()
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
}
