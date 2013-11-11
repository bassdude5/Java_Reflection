//---------------------------------------------------------------------
package reflection.serDeser;
//---------------------------------------------------------------------
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Vector;
import java.lang.reflect.Method;
//---------------------------------------------------------------------
import reflection.util.MyAllTypesFirst;
import reflection.util.MyAllTypesSecond;
import java.util.HashMap;
//---------------------------------------------------------------------
import reflection.util.Debug;
//---------------------------------------------------------------------
public class Serialize
{
	private final int errorVal = 4;

	private File file;
	private BufferedWriter out;
	private Vector<Object> objectsVector;
	private HashMap<String,Class> map1;

	/**
	* Serialize class constructor
	**/
	public Serialize(Debug debugClass, String outputFilename, 
		Vector<Object> objectsVector) throws IOException
	{
		try
		{
			file = new File(outputFilename);
			file.createNewFile();

			out = new BufferedWriter(
				new FileWriter(file));	
		}
		catch(IOException e)
		{
			System.out.println("ERROR: Unable to create " +
			 	"output file!");
			System.exit(errorVal);
		}

		this.objectsVector = objectsVector;	

		//Creates a new hashmap that is used in the DeserializeFile
		// method.
		map1 = new HashMap<String, Class>();
		map1.put("int", int.class);
		map1.put("string", String.class);
		map1.put("double", double.class);
		map1.put("long", long.class);
		map1.put("char", char.class);
		map1.put("float", float.class);
		map1.put("short", short.class);
	}

	/**
	* This method calls the serObj method on all the objects in
	*  the objects array
	*
	*@return Returns false if one or more objects were unable to 
	* be parsed correctly
	**/
	public void SerializeAll() throws IOException
	{
		Boolean status = true;

		for(int i = 0; i < objectsVector.size(); i++)
		{
			serializeObject(objectsVector.elementAt(i));
		}
		//Flush and close the output file
		out.flush();
		out.close();	
	}

	/**
	* This method is used to serialize one specific object
	*
	*@return Returns false if the object was unable to be
	* serialized properly, else returns true
	**/
	private void serializeObject(Object obj) throws IOException
	{	
		Method met = null;
		String tmp = null;
		//First serialized line of an object that always
		// needs written, reguardless of object type
		out.write("<DPSerialization>\n");

		//Creates an array of all the methods in the passed object
		Method[] methods = (obj.getClass()).getMethods();

		//Iterates through all the methods found,
		// only calling the neccesary getters
		for (Method method:methods)
		{
			String mname = method.getName();
			if(mname.startsWith("get") && !(mname.equals("getClass")) 
				&& !(mname.equals("getClassName")))

			{
				Class cls = obj.getClass();
				
				//System.out.println(method.getReturnType().toString());
				
				tmp = method.getReturnType().toString();
				if(tmp.equals("class java.lang.String"))
				{
					tmp = "string";
				}

				//System.out.println(map1.get(tmp));	
			
				/*try
				{
					met = cls.getDeclaredMethod(mname, map1.get(tmp));	
				}
				catch(NoSuchMethodException e)
				{
					System.out.println("ERROR: get method for"
						+ " variable not intialized or"
						+ " declared! ");
					System.exit(errorVal);
				}*/

				//Call method
				/*try
				{
					System.out.println(method.invoke(null));
				}
				catch(IllegalAccessException e)
				{
					System.out.println("ERROR: Invalid method!");
					System.exit(errorVal);
				}
				catch(InvocationTargetException e)
				{
					System.exit(errorVal);
				}*/
			}
		}
	
		//Final two lines of an object that need to be written
		out.write(" </complexType>\n");
		out.write("</DPSerialization>\n");

	}
}
//---------------------------------------------------------------------
