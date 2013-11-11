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

	private int debugVal;

	//Sets the exit value for errors
	private static final int errorVal = 1;

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
			System.exit(errorVal);	
		}

		//Sets the input filename
		inputFilename = args[0];

		//Sets the output filename
		outputFilename = args[1];
		
		debugVal = Integer.parseInt(args[2]);
		
		if(debugVal < 0 || debugVal > 5)
		{
			System.out.println("ERROR: Debug value passed to"
			+ "program is out of range!");
			System.exit(errorVal);
		}
		
		//Initializes the debug class
		debug = new Debug();
		debug.setDebugVal(debugVal);	

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
			int numType1 = 0;
			int numType2 = 0;

			//Check & display unique # of class instances
			for(int i = 0; i < objectsVector.size(); i++)
			{
				for(int j = 0; j < objectsVector.size(); j++)
				{
					if(objectsVector.get(i) == objectsVector.get(j)
					&& i != j) 
//&& objectsVector.get(i).getClassName().equals(objectsVector.get(j).getClassName()))
					{
						
					} 					
				}
			}
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
