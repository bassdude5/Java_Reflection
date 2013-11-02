//---------------------------------------------------------------------
package reflection.driver;
//---------------------------------------------------------------------
import java.io.FileNotFoundException;
import reflection.util.Debug;
import reflection.serDeser.Deserialize;
import reflection.serDeser.Serialize;
//---------------------------------------------------------------------
public class Process
{
	private static String inputFilename;
	private static String outputFilename;

	private int debug_val;

	//Sets the exit value for errors
	private static final int error_val = 1;

	Debug debug;
	Deserialize deSerFile;
	Serialize serFile;


	/**
	*	Class constructor
	**/
	public Process(String[] args) throws FileNotFoundException
	{
		//If there were not enough args passed from the command
		// line, the code will exit
		if(args.length != 3)
		{
			System.out.println("ERROR: Invalid number of"
				+ " command line arguments!");
			System.exit(error_val);	
		}

		//Sets the output filename
		outputFilename = args[1];

		//Sets the input filename
		inputFilename = args[0];

		//Initializes the debug class
		debug = new Debug();
		debug.setDebugVal(Integer.parseInt(args[2]));	

		//Open input file and error check
		deSerFile = new Deserialize(debug, inputFilename);

		//Open output file and error check
		//serFile = new Serialize(debug, outputFilename);
		

		//FIXME: Add an interface for both of the types?
		//FIXME: Add toString() methods to all


	}

	//Run the 
	public Boolean runProgram() throws FileNotFoundException
	{
		deSerFile.DeserializeFile();

		return true;
	}
}
