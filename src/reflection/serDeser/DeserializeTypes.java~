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
	*	@return returns the integer value from the string
	**/
	public int DeserializeInt(String intIn)
	{


		return Integer.parseInt(intIn);
	}

	/**
	*	This method is used to deserialize a long 
	*	 from its string format
	*
	*	@return 
	**/
	public long DeserializeLong(String longIn)
	{
		//  <myLong xsi:type="xsd:long">1212121</myLong>
	/*
		
	*/
		return 0;
	}

	/**
	*	This method is used to deserialize a double 
	*	 from its string format
	*
	*	@return 
	**/
	public double DeserializeDouble(String doubleIn)
	{
		//  <myDouble xsi:type="xsd:double">3.14</myDouble>
		return 0;
	}

	/**
	*	This method is used to deserialize a string
	*	 from its string format
	*
	*	@return 
	**/
	public String DeserializeString(String stringIn)
	{
		//  <myString xsi:type="xsd:string">Design Patterns</myString>
		return null;
	}

	/**
	*	This method is used to deserialize a char
	*	 from its string format
	*
	*	@return 
	**/
	public char DeserializeChar(String charIn)
	{
		//  <myChar xsi:type="xsd:char">D</myChar>
		return ' ';
	}

	/**
	*	This method is used to deserialize a float
	*	 from its string format
	*
	*	@return 
	**/
	public float DeserializeFloat(String floatIn)
	{
		//  <myFloatS xsi:type="xsd:float">314</myFloatS>
		return 0;
	}

	/**
	*	This method is used to deserialize a short
	*	 from its string format
	*
	*	@return 
	**/
	public short DeserializeShort(String shortInt)
	{
		//  <myShortS xsi:type="xsd:short">19</myShortS>
		return 0;
	}
}
