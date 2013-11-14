//---------------------------------------------------------------------
package reflection.util;
//---------------------------------------------------------------------
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.Serializable;
//---------------------------------------------------------------------
import reflection.util.Debug;
//---------------------------------------------------------------------
public class MyAllTypesFirst implements Serializable
{
	private int myInt;
	private String myString;
	private double myDouble;
	private long myLong;
	private char myChar;

	private Debug debugVal;

	private String myClassName = "MyAllTypesFirst";

	/**
	*	The class constructor
	**/
	public MyAllTypesFirst()
	{

	}
	
	/**
	*	Overridden toString method
	*	@return Returns a string describing the class
	**/
	@Override
	public String toString()
	{
		return myClassName + ": myInt = " + myInt + ", myString = "
			+ myString + ", myDouble = " + myDouble + ", myLong = "
			+ myLong + ", myChar = " + myChar + ".";
	}

	
	/**
	*	This is the overidden equals method
	**/
	public boolean equals(Object passedObj)
	{
		//Checks if the object exists
		if (passedObj == null)
		{
			return false;
		}

		//Checks to ensure the class is an instance of this class
		if(!(passedObj instanceof MyAllTypesFirst))
		{
			return false;	
		}

		if(passedObj == this)
		{
			return true;
		}

		
		MyAllTypesFirst cls = (MyAllTypesFirst)passedObj;

		if((this.myChar == cls.getMyChar()) && 
			(this.myInt == cls.getMyInt()) &&
			(this.myString.equals(cls.getMyString())) &&
			(this.myDouble == cls.getMyDouble()) &&
			(this.myLong == cls.getMyLong()))
		{
			return true;
		}

		return false;
	}

	/**
	*	This method is used to set the debug value
	**/
	public void setDebugVal(Debug debugVal)
	{
		this.debugVal = debugVal;
	}

	/**
	*	This method is used to set the variable myInt
	**/
	public void setMyInt(int myInt)
	{
		this.myInt = myInt;
	}
	
	/**
	*	This method is used to set the variable myString
	**/
	public void setMyString(String myString)
	{
		this.myString = myString;
	}

	/**
	*	This method is used to set the variable myDouble
	**/
	public void setMyDouble(double myDouble)
	{
		this.myDouble = myDouble;
	}

	/**
	*	This method is used to set the variable myLong
	**/
	public void setMyLong(long myLong)
	{
		this.myLong = myLong;
	}

	/**
	*	This method is used to set the variable myChar
	**/
	public void setMyChar(char myChar)
	{
		this.myChar = myChar;
	}

	/**
	*	This method is used to get the variable myInt
	*	@return returns the int "myInt"
	**/
	public int getMyInt()
	{
		return myInt;
	}

	/**
	*	This method is used to get the variable myString
	*	@return returns the String object "myString"
	**/
	public String getMyString()
	{
		return myString;
	}

	/**
	*	This method is used to get the variable myDouble
	*	@return returns the double "myDouble"
	**/
	public double getMyDouble()
	{
		return myDouble;
	}

	/**
	*	This method is used to get the variable myLong
	*	@return returns the long "myLong"
	**/
	public long getMyLong()
	{
		return myLong;	
	}
	
	/**
	*	This method is used to get the variable myChar 
	*	@return returns the character "myChar"
	**/
	public char getMyChar()
	{	
		return myChar;
	}

	/**
	*	This method is used to get the class name
	*	@return returns the class name
	**/
	public String getClassName()
	{	
		return myClassName;
	}	
}
//---------------------------------------------------------------------
