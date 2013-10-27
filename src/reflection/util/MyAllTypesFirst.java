import java.io.BufferedWriter;
import java.io.IOException;

public class MyAllTypesFirst
{
	private int myInt;
	private String myString;
	private double myDouble;
	private long myLong;
	private char myChar;

	public MyAllTypesFirst()
	{
		
	}
	
	public void serialize(BufferedWriter outFile) throws IOException
	{
		outFile.write("<DPSerialization>");
		outFile.write("<complexType xsi:type=\"reflection.util.MyAllTypesFirst\">");
	
	}

	public void setMyInt(int myInt)
	{
		this.myInt = myInt;
	}
	
	public void setMyString(String myString)
	{
		this.myString = myString;
	}

	public void setMyDouble(double myDouble)
	{
		this.myDouble = myDouble;
	}
	
	public void setMyLong(long myLong)
	{
		this.myLong = myLong;
	}

	public void setMyChar(char myChar)
	{
		this.myChar = myChar;
	}

	public int getMyInt()
	{
		return myInt;
	}

	public String getMyString()
	{
		return myString;
	}

	public double getMyDouble()
	{
		return myDouble;
	}

	public long getMyLong()
	{
		return myLong;	
	}
	
	public char getMyChar()
	{	
		return myChar;
	}	
}
