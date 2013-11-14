//---------------------------------------------------------------------
package reflection.util;
//---------------------------------------------------------------------
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.Serializable;
//---------------------------------------------------------------------
import reflection.util.Debug;
//---------------------------------------------------------------------
public class MyAllTypesSecond implements Serializable
{
	private int myIntS;
	private String myStringS;
	private float myFloatS;
	private short myShortS;
	private char myCharS;
	private Debug debugVal;

	private String myClassName = "MyAllTypesSecond";

	/**
	*	The class constructor
	**/
	public MyAllTypesSecond()
	{

	}

	/**
	*	Overridden toString method
	*	@return Returns a string describing the class
	**/
	@Override
	public String toString()
	{
		return myClassName + ": myIntS = " + myIntS + ", myStringS = "
			+ myStringS + ", myFloatS = " + myFloatS + ", myShortS = "
			+ myShortS + ", myCharS = " + myCharS + ".";
	}

	/**
	*	This method is used to set the debug value
	**/
	public void setDebugVal(Debug debugVal)
	{
		this.debugVal = debugVal;
	}

	/**
	*	This method is used to set the variable myIntS
	**/
	public void setMyIntS(int myIntS)
	{
		this.myIntS = myIntS;
	}
	
	/**
	*	This method is used to set the variable myStringS
	**/
	public void setMyStringS(String myStringS)
	{
		this.myStringS = myStringS;
	}

	/**
	*	This method is used to set the variable myFloatS
	**/
	public void setMyFloatS(float myFloatS)
	{
		this.myFloatS = myFloatS;
	}

	/**
	*	This method is used to set the variable myShortS
	**/
	public void setMyShortS(short myShortS)
	{
		this.myShortS = myShortS;
	}

	/**
	*	This method is used to set the variable myChar
	**/
	public void setMyCharS(char myCharS)
	{
		this.myCharS = myCharS;
	}

	/**
	*	This method is used to get the variable myIntS
	*	@return returns the int "myIntS"
	**/
	public int getMyIntS()
	{
		return myIntS;
	}

	/**
	*	This method is used to get the variable myStringS
	*	@return returns the String "myStringS"
	**/
	public String getMyStringS()
	{
		return myStringS;
	}
	
	/**
	*	This method is used to get the variable myFloatS
	*	@return returns the float "myFloatS"
	**/
	public float getMyFloatS()
	{
		return myFloatS;
	}

	/**
	*	This method is used to get the variable myShortS
	*	@return returns the short "myShortS"
	**/
	public short getMyShortS()
	{
		return myShortS;
	}

	/**
	*	This method is used to get the variable myChar
	*	@return returns the char "myChar"
	**/
	public char getMyCharS()
	{
		return myCharS;
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
