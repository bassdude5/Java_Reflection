//---------------------------------------------------------------------
package reflection.serDeser;
//---------------------------------------------------------------------
import java.util.regex.Matcher;
import java.util.regex.Pattern;
//---------------------------------------------------------------------
import reflection.util.Debug;
//---------------------------------------------------------------------
public class DeserializeTypes
{
	private final int errorVal = 3;
	
	private Debug debugClass;
	private Pattern pat;
	private Matcher match;
	private String	begRegex = "<.*\">";
	private String	endRegex = "</.*>";
	private int begIndex;
	private int endIndex;
	private String result;

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
		result = "-1";
		begIndex = -1;
		endIndex = -1;

		try
		{
			//Beginning tag parsing
			pat = Pattern.compile(begRegex);
			match = pat.matcher(intIn);
			if(match.find())
			{
				begIndex = match.end();
			}

			//End tag parsing
			pat = Pattern.compile(endRegex);
			match = pat.matcher(intIn);
			
			if(match.find())
			{
				endIndex = match.start();
			}	
		}
		catch(Exception e)
		{
			System.out.println("ERROR: attempted parse of" 
				+ "string: \"" + intIn +"\"" +
				" failed!");
			System.exit(errorVal);
		}
		
		//Checks to ensure there actually was a value
		if(begIndex < endIndex && begIndex > 0)
		{
			result = intIn.substring(begIndex,endIndex);
		}

		return Integer.parseInt(result);
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
