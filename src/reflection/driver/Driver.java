//---------------------------------------------------------------------
package reflection.driver;
//---------------------------------------------------------------------
import reflection.driver.Process;
//---------------------------------------------------------------------
import java.io.FileNotFoundException;
//---------------------------------------------------------------------
public class Driver
{
	public static void main(String[] args) throws FileNotFoundException
	{
		Process p1 = new Process(args);
		

		//Open output file and error check
		
		System.out.println("Driver finished execution");

	}
}//End of class driver
//---------------------------------------------------------------------
