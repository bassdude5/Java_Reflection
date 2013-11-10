//---------------------------------------------------------------------
package reflection.util;
//---------------------------------------------------------------------
import java.io.BufferedWriter;
import java.io.IOException;
//---------------------------------------------------------------------
import reflection.util.Debug;
//---------------------------------------------------------------------
public class MyAllTypesFirst
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
	public MyAllTypesFirst(Debug debugVal)
	{
		this.debugVal = debugVal;
	}
	
	@Override
	public String toString()
	{
		return myClassName + ": myInt = " + myInt + ", myString = "
			+ myString + ", myDouble = " + myDouble + ", myLong = "
			+ myLong + ", myChar = " + myChar + ".";
	}

	
	/**
	*	Code partially taken from:
	*	http://users.csc.calpoly.edu/~kmammen/documents/java/howToOverrideEquals.html
	**/
	public boolean equals(Object passedObj)
	{
		//Checks if the object exists
		if (passedObj == null)
		{
			return false;
		}

		//Checks if the classes are instances of the same class
		if (this.getClass() != passedObj.getClass())
		{
			return false;
		}

		/*if (this.myInt != passedObj.getMyInt()) ||
		/*this.myString != ((Simple)passedObj).myString ||
		this.myDouble != ((Simple)passedObj).myDouble ||
		this.myLong != ((Simple)passedObj).myLong ||
		this.myChar != ((Simple)passedObj).myChar)
		{
			return false;
		}*/

		return true;
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
}
//---------------------------------------------------------------------
