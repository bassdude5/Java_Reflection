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
		//Create a new instance of a process class
		Process p1 = new Process(args);

		//Run the process instance
		p1.runProgram();

		System.out.println("Driver finished execution");

	}
}//End of class driver
//---------------------------------------------------------------------
