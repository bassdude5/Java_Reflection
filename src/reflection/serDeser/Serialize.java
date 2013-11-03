//---------------------------------------------------------------------
package reflection.serDeser;
//---------------------------------------------------------------------
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
//---------------------------------------------------------------------
public class Serialize
{
	private Object[] objects;
	private BufferedWriter out;

	/**
	* Serialize class constructor
	**/
	public Serialize(Object[] objects, String outputFilename) throws IOException
	{
		this.objects = objects;
		out = new BufferedWriter(
			new FileWriter(outputFilename));		
	}

	/**
	* This method calls the serObj method on all the objects in
	*  the objects array
	*
	*@return Returns false if one or more objects were unable to 
	* be parsed correctly
	**/
	public Boolean	SerializeAll() throws IOException
	{
		Boolean status = true;

		for(int i = 0; i < objects.length; i++)
		{
			if(serObj(objects[i]) == false)
			{
				//Only returns false if all the objects 
				// were not parsed correctly
				//i = objects.length;
	
				//Sets the method to return false
				status = false;
			}
		}		

		return status;
	}

	/**
	* This method is used to serialize one specific object
	*
	*@return Returns false if the object was unable to be
	* serialized properly, else returns true
	**/
	private Boolean serObj(Object obj) throws IOException
	{
		Boolean status = true;

		//Write the object out to the text file		
		//return false if unable to serialize

		//First serialized line of an object that always
		// needs written, reguardless of object type
		out.write("<DPSerialization> ");

		//Should call methods from the serialize types class
	
		//Final two lines of an object that need to be written
		out.write(" </complexType>");
		out.write("</DPSerialization>");

		return status;
	}
}
//---------------------------------------------------------------------
