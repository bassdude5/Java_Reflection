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

	/**
	*	The null class constructor
	**/
	public MyAllTypesSecond()
	{

	}

	/**
	*	This method prints an instance of this object to the 
	*	 passed BufferedWriter.
	**/
	public void serialize(BufferedWriter outFile) throws IOException
	{
		/*outFile.write("");
		outFile.write("");*/
	
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
