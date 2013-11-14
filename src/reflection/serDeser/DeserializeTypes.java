//---------------------------------------------------------------------
package reflection.serDeser;
//---------------------------------------------------------------------
import reflection.util.Debug;
//---------------------------------------------------------------------
public class DeserializeTypes
{
	private final int errorVal = 3;
	private Debug debugClass;

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
		int returnVal = 0;
		try
		{
			returnVal = Integer.parseInt(intIn);
		}
		catch(Exception e)
		{
			System.out.println("ERROR: Unable to parse int!");
			System.exit(errorVal);
		}
		return returnVal;
	}

	/**
	*	This method is used to deserialize a long 
	*	 from its string format
	*
	*	@return Returns the parsed long value
	**/
	public long DeserializeLong(String longIn)
	{
		long returnVal = 0;
		try
		{
			returnVal = Long.valueOf(longIn);
		}
		catch(Exception e)
		{
			System.out.println("ERROR: Unable to parse long!");
			System.exit(errorVal);
		}
		return returnVal;
	}

	/**
	*	This method is used to deserialize a double 
	*	 from its string format
	*
	*	@return Returns the parsed double value
	**/
	public double DeserializeDouble(String doubleIn)
	{		
		double returnVal = 0;
		try
		{
			returnVal = Double.parseDouble(doubleIn);
		}
		catch(Exception e)
		{
			System.out.println("ERROR: Unable to parse double!");
			System.exit(errorVal);
		}
		return returnVal;
	}

	/**
	*	This method is used to deserialize a string
	*	 from its string format
	*
	*	@return Returns the trimmed string
	**/
	public String DeserializeString(String stringIn)
	{
		String returnVal = null;
		try
		{
			returnVal = stringIn.trim();
		}
		catch(Exception e)
		{
			System.out.println("ERROR: Unable to parse String!");
			System.exit(errorVal);
		}
		return returnVal;
	}

	/**
	*	This method is used to deserialize a char
	*	 from its string format
	*
	*	@return Returns the parsed character value
	**/
	public char DeserializeChar(String charIn)
	{
		char returnVal = 0;
		try
		{
			returnVal = charIn.charAt(0);
		}
		catch(Exception e)
		{
			System.out.println("ERROR: Unable to parse char!");
			System.exit(errorVal);
		}
		return returnVal;
	}

	/**
	*	This method is used to deserialize a float
	*	 from its string format
	*
	*	@return Returns the parsed float value
	**/
	public float DeserializeFloat(String floatIn)
	{
		float returnVal = 0;
		try
		{
			returnVal = Float.valueOf(floatIn.trim()).floatValue();
		}
		catch(Exception e)
		{
			System.out.println("ERROR: Unable to parse float!");
			System.exit(errorVal);
		}
		return returnVal;

	}

	/**
	*	This method is used to deserialize a short
	*	 from its string format
	*
	*	@return Returns the parsed short value
	**/
	public short DeserializeShort(String shortIn)
	{
		short returnVal = 0;
		try
		{
			returnVal = Short.parseShort(shortIn);
		}
		catch(Exception e)
		{
			System.out.println("ERROR: Unable to parse short!");
			System.exit(errorVal);
		}
		return returnVal;
	}
}
