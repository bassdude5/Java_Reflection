//---------------------------------------------------------------------
package reflection.serDeser;
//---------------------------------------------------------------------
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Vector;
import java.util.HashMap;
import java.lang.reflect.Method;
//---------------------------------------------------------------------
import reflection.util.MyAllTypesFirst;
import reflection.util.MyAllTypesSecond;
import reflection.serDeser.SerializeTypes;
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
	private SerializeTypes sTypes;

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
		sTypes = new SerializeTypes(debugClass);	
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
		String getMetName = null;
		String serMethodName = null;
		Class retType;
		//First serialized line of an object that always
		// needs written, reguardless of object type
		out.write("<DPSerialization>\n");

		//Creates an array of all the methods in the passed object
		Class cls = obj.getClass();
		Method[] methods = cls.getMethods();
		Method serMeth;
		Object serParams;
		Class serClass = sTypes.getClass();

		//Iterates through all the methods found,
		// only calling the neccesary getters
		for (Method method:methods)
		{
			String mname = method.getName();
			if(mname.equals("getClassName"))
			{
				try
				{
					out.write(sTypes.SerializeClassName((String)method.invoke(obj, (Object[])null)));	
				}
				catch(Exception e)
				{
					System.out.println("ERROR: Unable to write class" +
					 "link to output file!");
					System.exit(errorVal);
				}
			}
			else if(mname.startsWith("get") && !(mname.equals("getClass")) 
				&& !(mname.equals("getClassName")))

			{
				//Reformats the variable name to the proper output
				// format
				getMetName = mname.substring(3,4).toLowerCase() 
					+ mname.substring(4);

				//Finds the return type of the getter method 
				// so the code can reflexively call the appropriate
				// SerializeTypes method
				retType = method.getReturnType();

				serMethodName = retType.toString();

				if(serMethodName.equals("class java.lang.String"))
				{
					serMethodName = "String";
				}
				serMethodName = "Serialize" + 
					serMethodName.substring(0,1).toUpperCase()
					+ serMethodName.substring(1);
		
				try
				{
					serMeth = serClass.getDeclaredMethod(serMethodName, new Class[] {String.class, retType});
					out.write(serMeth.invoke(sTypes, getMetName, method.invoke(obj, (Object[])null)).toString());

				}
				catch(NoSuchMethodException e)
				{
					System.out.println("ERROR: Method for type does not exist" + 
						" in SerializeTypes class!");
					System.exit(errorVal);
				}
				catch(Exception e)
				{
					System.out.println("ERROR: unable to call method!");
					System.exit(errorVal);
				}
			}
		}
	
		//Final two lines of an object that need to be written
		out.write(" </complexType>\n");
		out.write("</DPSerialization>\n");

	}
}
//---------------------------------------------------------------------
