//---------------------------------------------------------------------
package reflection.util;
//---------------------------------------------------------------------
import java.io.BufferedWriter;
import java.io.IOException;
//---------------------------------------------------------------------
public class MyAllTypesFirst
{
	private int myInt;
	private String myString;
	private double myDouble;
	private long myLong;
	private char myChar;

	private String myClassName = "MyAllTypesFirst";

	/**
	*	The null class constructor
	**/
	public MyAllTypesFirst()
	{
		
	}
	
	/**
	*	This method prints an instance of this object to the 
	*	 passed BufferedWriter.
	**/
	public void serialize(BufferedWriter outFile) throws IOException
	{
		outFile.write("<DPSerialization>");
		outFile.write(" <complexType xsi:type=\"reflection.util.MyAllTypesFirst\">");
		outFile.write("  <myInt xsi:type=\"xsd:int\">" + myInt + "</myInt>");
		outFile.write("  <myString xsi:type=\"xsd:string\">" + myString + "</myString>");
		outFile.write("  <myDouble xsi:type=\"xsd:double\">" + myDouble + "</myDouble>");
		outFile.write("  <myLong xsi:type=\"xsd:long\">" + myLong + "</myLong>");
		outFile.write("  <myChar xsi:type=\"xsd:char\">" + myChar + "</myChar>");
		outFile.write(" </complexType>");
		outFile.write("</DPSerialization>");
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
