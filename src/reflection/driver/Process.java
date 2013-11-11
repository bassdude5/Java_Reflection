//---------------------------------------------------------------------
package reflection.driver;
//---------------------------------------------------------------------
import java.io.FileNotFoundException;
import java.io.IOException;
import reflection.serDeser.Deserialize;
import reflection.serDeser.Serialize;
import java.util.Vector;
//---------------------------------------------------------------------
import reflection.util.MyAllTypesFirst;
import reflection.util.MyAllTypesSecond;
//---------------------------------------------------------------------
import reflection.util.Debug;
//---------------------------------------------------------------------
public class Process
{
	private static String inputFilename;
	private static String outputFilename;

	private int debug_val;

	//Sets the exit value for errors
	private static final int error_val = 1;

	private Debug debug;
	private Deserialize deSerFile;
	private Serialize serFile;
	private Vector<Object> objectsVector;

	/**
	*	Class constructor that parses all input and sets
	*	 class variables
	**/
	public Process(String[] args) throws FileNotFoundException, IOException
	{
		//If there were not enough args passed from the command
		// line, the code will exit
		if(args.length != 3)
		{
			System.out.println("ERROR: Invalid number of"
				+ " command line arguments!");
			System.exit(error_val);	
		}

		//Sets the input filename
		inputFilename = args[0];

		//Sets the output filename
		outputFilename = args[1];

		//Initializes the debug class
		debug = new Debug();
		debug.setDebugVal(Integer.parseInt(args[2]));	

		//Open input file and error check
		deSerFile = new Deserialize(debug, inputFilename);
	}

	/**
	*	This method is used to run the program
	*	@return Returns true if the program executed correctly
	**/
	public Boolean runProgram() throws FileNotFoundException,
		IOException
	{
		//Deserializes the file
		objectsVector = deSerFile.DeserializeFile();
		
		//Count the number of each object
		if(debug.getDebugVal() == 0)
		{
			//Check & display unique # of class instances
		}
		
		//Open output file and error check
		serFile = new Serialize(debug, outputFilename, 
			objectsVector);

		if(serFile.SerializeAll() != true)
		{
			System.out.println("ERROR: Some objects may" +
				" not have been serialized succesfully!");
		}		

		return true;
	}
}
