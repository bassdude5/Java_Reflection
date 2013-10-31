//---------------------------------------------------------------------
package reflection.driver;
//---------------------------------------------------------------------
import java.io.FileNotFoundException;
import reflection.util.Debug;
import reflection.serDeser.Deserialize;
import reflection.serDeser.Serialize;
//---------------------------------------------------------------------
public class Driver
{
	private static String inputFilename;
	private static String outputFilename;

	private int debug_val;

	//Sets the exit value for errors
	private static final int error_val = 1;
	

	public static void main(String[] args) throws FileNotFoundException
	{
		//If there were not enough args passed from the command
		// line, the code will exit
		if(args.length != 3)
		{
			System.out.println("ERROR: Invalid number of"
				+ " command line arguments!");
			System.exit(error_val);	
		}

		//Initializes the debug class
		Debug debug = new Debug();
		debug.setDebugVal(Integer.parseInt(args[2]));	

		//Sets the input filename
		inputFilename = args[0];
		//Open input file and error check
		Deserialize d1 = new Deserialize(inputFilename);
		d1.DeserializeFile();
	
		//Sets the output filename
		outputFilename = args[1];
		//Open output file and error check
		
		System.out.println("Driver finished execution");

		//FIXME: Add an interface for both of the types?
		//
		//FIXME: Add toString() methods to all
		
	}
}//End of class driver
//---------------------------------------------------------------------
