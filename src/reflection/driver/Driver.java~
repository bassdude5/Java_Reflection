//---------------------------------------------------------------------
package reflection.driver;
//---------------------------------------------------------------------
import java.io.FileNotFoundException;
import reflection.util.Parse;
import reflection.util.Debug;
//---------------------------------------------------------------------
public class Driver
{
	private static String input_filename;
	private static String output_filename;

	private int debug_val;

	//Sets the exit value for errors
	private static final int exit_val = 1;
	

	public static void main(String[] args) throws FileNotFoundException
	{
		//If there were not enough args passed from the command
		// line, the code will exit
		if(args.length != 3)
		{
			System.out.println("ERROR: Invalid number of"
				+ " command line arguments!");
			System.exit(exit_val);	
		}
	

		input_filename = args[0];
		//Open input file and error check
	
		output_filename = args[1];
		//Open output file and error check
		
		//Initializes the debug class
		Debug debug = new Debug();
		debug.setDebugVal(Integer.parseInt(args[3]));
				

		Parse p1 = new Parse(input_filename);
		System.out.println("Driver finished execution");

		//FIXME: Add an interface for both of the types?
		
	}
}//End of class driver
//---------------------------------------------------------------------
