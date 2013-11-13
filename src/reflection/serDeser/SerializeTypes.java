//---------------------------------------------------------------------
package reflection.serDeser;
//---------------------------------------------------------------------
import reflection.util.Debug;
//---------------------------------------------------------------------
public class SerializeTypes
{
	private Debug debugVal;

	/**
	*	This is the class constructor
	**/
	public SerializeTypes(Debug debugVal)
	{
		this.debugVal = debugVal;
	}

	/**
	*	This method is used to serialize the class name
	*	NOTE: This method assumes the proper class name
	*		is passed to this method and does NO
	*			checking on the value
	*
	*	@return This method returns the serialized classe3
	**/
	public String SerializeClassName(String className)
	{
		return " <complexType xsi:type=\"reflection.util." +
		 className + "\">\n";
	}
	
	/**
	*	This method is used to serialize an int into
	*	 a formatted string.	
	*
	*	@return This method returns the serialized int
	**/
	public String SerializeInt(String name, int intIn)
	{
		return "  <"+ name + " xsi:type=\"xsd:int\">" +
		 intIn + "</" + name + ">\n";
	}
	
	/**
	*	This method is used to serialize a long into
	*	 a formatted string
	*
	*	@return This method returns the serialized long
	**/
	public String SerializeLong(String name, long longIn)
	{
		return "  <"+ name + " xsi:type=\"xsd:long\">" +
		 longIn + "</" + name + ">\n";
	}

	/**
	*	This method is used to serialize a double into
	*	 a formatted string
	*
	*	@return This method returns the serialized double
	**/
	public String SerializeDouble(String name, double doubleIn)
	{
		return "  <"+ name + " xsi:type=\"xsd:double\">" +
		 doubleIn + "</" + name + ">\n";
	}

	/**
	*	This method is used to serialize a string into
	*	 a formatted string
	*
	*	@return This method returns the serialized String
	**/
	public String SerializeString(String name, String stringIn)
	{
		return "  <"+ name + " xsi:type=\"xsd:string\">" +
		 stringIn + "</" + name + ">\n";
	}

	/**
	*	This method is used to serialize a char into
	*	 a formatted string
	*
	*	@return This method returns the serialized char
	**/
	public String SerializeChar(String name, char charIn)
	{
		return "  <"+ name + " xsi:type=\"xsd:char\">" +
		 charIn + "</" + name + ">\n";
	}

	/**
	*	This method is used to serialize a float into
	*	 a formatted string
	*
	*	@return This method returns the serialized float
	**/
	public String SerializeFloat(String name, float floatIn)
	{
		return "  <"+ name + " xsi:type=\"xsd:float\">" +
		 floatIn + "</" + name + ">\n";
	}

	/**
	*	This method is used to serialize a short into
	*	 a formatted string
	*
	*	@return This method returns the serialized short
	**/
	public String SerializeShort(String name, short shortIn)
	{
		return "  <"+ name + " xsi:type=\"xsd:short\">" +
		 shortIn + "</" + name + ">\n";
	}

}
