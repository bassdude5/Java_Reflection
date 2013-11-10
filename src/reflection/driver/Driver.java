//---------------------------------------------------------------------
package reflection.driver;
//---------------------------------------------------------------------
import reflection.driver.Process;
//---------------------------------------------------------------------
import java.io.FileNotFoundException;
import java.io.IOException;
//---------------------------------------------------------------------
public class Driver
{
	public static void main(String[] args) throws FileNotFoundException,
		IOException
	{
		Process p1 = new Process(args);
		p1.runProgram();

		//Open output file and error check
		
		System.out.println("Driver finished execution");

	}
}//End of class driver
//---------------------------------------------------------------------
