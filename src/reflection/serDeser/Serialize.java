//---------------------------------------------------------------------
package reflection.serDeser;
//---------------------------------------------------------------------
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Vector;
//---------------------------------------------------------------------
import reflection.util.MyAllTypesFirst;
import reflection.util.MyAllTypesSecond;
//---------------------------------------------------------------------
import reflection.util.Debug;
//---------------------------------------------------------------------
public class Serialize
{
	private BufferedWriter out;
	private Vector<Object> objectsVector;

	/**
	* Serialize class constructor
	**/
	public Serialize(Debug debugClass, String outputFilename, 
		Vector<Object> objectsVector) throws IOException
	{
		out = new BufferedWriter(
			new FileWriter(outputFilename));	

		this.objectsVector = objectsVector;	
	}

	/**
	* This method calls the serObj method on all the objects in
	*  the objects array
	*
	*@return Returns false if one or more objects were unable to 
	* be parsed correctly
	**/
	public Boolean SerializeAll() throws IOException
	{
		Boolean status = true;

		for(int i = 0; i < objectsVector.size(); i++)
		{
			/*if(serObj(objectVector.at(i)) == false)
			{
				//Only returns false if all the objects 
				// were not parsed correctly

				//Sets the method to return false
				status = false;
			}*/
		}	

		return status;
	}

	/**
	* This method is used to serialize one specific object
	*
	*@return Returns false if the object was unable to be
	* serialized properly, else returns true
	**/
	private Boolean serializeObject(Object obj) throws IOException
	{	
		Class cls;
		Boolean status = true;

		//First serialized line of an object that always
		// needs written, reguardless of object type
		out.write("<DPSerialization> ");
		
		
		
		//cls = Class.forName(obj.getClassName());

		/*Method[] methods = cls.getMethods();*/
				




	
		//Final two lines of an object that need to be written
		out.write(" </complexType>");
		out.write("</DPSerialization>");

		return status;
	}
}
//---------------------------------------------------------------------
