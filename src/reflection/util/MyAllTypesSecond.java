//---------------------------------------------------------------------
package reflection.util;
//---------------------------------------------------------------------
import java.io.BufferedWriter;
import java.io.IOException;
//---------------------------------------------------------------------
public class MyAllTypesSecond
{
	private int myIntS;
	private String myStringS;
	private float myFloatS;
	private short myShortS;
	private char myChar;

	private String myClassName = "MyAllTypesSecond";

	/**
	*	The null class constructor
	**/
	public MyAllTypesSecond()
	{

	}

	@Override
	public String toString()
	{
		return myClassName + ": myIntS = " + myIntS + ", myStringS = "
			+ myStringS + ", myFloatS = " + myFloatS + ", myShortS = "
			+ myShortS + ", myChar = " + myChar + ".";
	}

	public void setMyIntS(int myIntS)
	{
		this.myIntS = myIntS;
	}
	
	public void setMyStringS(String myStringS)
	{
		this.myStringS = myStringS;
	}
	public void setMyFloatS(float myFloatS)
	{
		this.myFloatS = myFloatS;
	}

	public void setMyShortS(short myShortS)
	{
		this.myShortS = myShortS;
	}

	public void setMyChar(char myChar)
	{
		this.myChar = myChar;
	}

	public int getMyIntS()
	{
		return myIntS;
	}

	public String getMyStringS()
	{
		return myStringS;
	}
	
	public float getMyFLoatS()
	{
		return myFloatS;
	}

	public short getMyShortS()
	{
		return myShortS;
	}

	public char getMyChar()
	{
		return myChar;
	}
}
//---------------------------------------------------------------------
