========================================================================
Design Patterns, Assignment #3
Team members: Michael Welte
========================================================================
Compilation and running:
========================================================================
To compile this, navigate to the parent directory and run
"ant compile" in the terminal.

Modify the build.xml file at the bottom in the "arg value" tag to change
the debug value, (see below for debug value details) and the input and
output file names. To run the program, run the command "ant run"
in the terminal.

========================================================================
Debug Values:
========================================================================
This program uses the following debug value scheme:
0 - Prints out the results from the class equality check
1 - Prints to stdout when a constructor is called
2 - Prints all the objects read from the file to stdout
========================================================================
Error Values:
========================================================================
The following are the possible (non-standard) error values that can
be returned from this program:

1 - Process class error
2 - Deserialize class error
3 - DeserializeTypes error
4 - Serialize class error
5 - SerailizeTypes class error

========================================================================
Approach and Justifications:
========================================================================

I decided that there was no logical reason to use an interface for the
types classes since they only share 1 to 2 common methods, and it 
really would not enforce much of a pattern.

The process class I added, just to make the driver class super short 
and basic. In addition this would mean that if you truely wanted to
spawn more processes or threads you could simply implement a more 
driver and then use the process class.

I created a method that uses regular expressions to parse the data in
the Deserialize class, and then used the DeserializeTypes class as a
parsing class that will take in a string argument and just output 
the parsed value. All the method calling was done with Reflection,
and the classes were created using reflection as well.

========================================================================
Slack days:
========================================================================
The number of slack days I have used so far is: 3

========================================================================
Contributions:
========================================================================
Michael Welte:
	-Entire projects

========================================================================
