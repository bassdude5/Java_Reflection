//---------------------------------------------------------------------
package reflection.serDeser;
//---------------------------------------------------------------------
import reflection.util.Debug;
//---------------------------------------------------------------------
public class DeserializeTypes
{
	private final int errorVal = 3;
	private Debug debugClass;
	private String	begRegex = "<.*\">";
	private String	endRegex = "</.*>";

	/**
	*	This is the class constructor
	**/
	public DeserializeTypes(Debug debugClass)
	{
		this.debugClass = debugClass;
	}

	/**
	*	This method is used to deserialize a int
	*	 from its string format
	*
	*	@return Returns the integer value from the string
	**/
	public int DeserializeInt(String intIn)
	{


		return Integer.parseInt(intIn);
	}

	/**
	*	This method is used to deserialize a long 
	*	 from its string format
	*
	*	@return Returns the parsed long value
	**/
	public long DeserializeLong(String longIn)
	{
		return Long.valueOf(longIn);
	}

	/**
	*	This method is used to deserialize a double 
	*	 from its string format
	*
	*	@return Returns the parsed double value
	**/
	public double DeserializeDouble(String doubleIn)
	{
		return Double.parseDouble(doubleIn);
	}

	/**
	*	This method is used to deserialize a string
	*	 from its string format
	*
	*	@return Returns the trimmed string
	**/
	public String DeserializeString(String stringIn)
	{
		return stringIn.trim();
	}

	/**
	*	This method is used to deserialize a char
	*	 from its string format
	*
	*	@return Returns the parsed character value
	**/
	public char DeserializeChar(String charIn)
	{
		return charIn.charAt(0);
	}

	/**
	*	This method is used to deserialize a float
	*	 from its string format
	*
	*	@return Returns the parsed float value
	**/
	public float DeserializeFloat(String floatIn)
	{
		return Float.valueOf(floatIn.trim()).floatValue();
	}

	/**
	*	This method is used to deserialize a short
	*	 from its string format
	*
	*	@return Returns the parsed short value
	**/
	public short DeserializeShort(String shortIn)
	{
		return Short.parseShort(shortIn);
	}
}
