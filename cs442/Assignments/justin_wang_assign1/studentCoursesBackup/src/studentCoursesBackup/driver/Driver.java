package studentCoursesBackup.driver;

import studentCoursesBackup.util.FileProcessor;
import studentCoursesBackup.myTree.TreeBuilder;
import studentCoursesBackup.util.Results;

/**
* Driver class contains the main method and runs the whole program
* @author Justin Wang
*/

public class Driver {
	/**
	* Main method creates a tree with 2 observers using multiple files.
	* After generating the trees it stores the results in the 
	* specified output files.
	* @return nothing
	*/
	public static void main(String[] args) {

		/*
		 * As the build.xml specifies the arguments as argX, in case the
		 * argument value is not given java takes the default value specified in
		 * build.xml. To avoid that, below condition is used
		 */
		if (args.length != 5 || args[0].equals("${arg0}") || args[1].equals("${arg1}") || args[2].equals("${arg2}")
				|| args[3].equals("${arg3}") || args[4].equals("${arg4}")) {

			System.err.println("Error: Incorrect number of arguments. Program accepts 5 argumnets.");
			System.exit(0);
		}

		// Create file processor instance for input and delete files
		FileProcessor fp1 = new FileProcessor(args[0]);
		FileProcessor fp2 = new FileProcessor(args[1]);

		// Create trees
		TreeBuilder myTree = new TreeBuilder(fp1, fp2);

		// Generate results
		Results r1 = new Results(myTree.getRoot());
		Results r2 = new Results(myTree.getObserver1());
		Results r3 = new Results(myTree.getObserver2());

		// Print results to output files
		myTree.printNodes(r1, args[2]);
		myTree.printNodes(r2, args[3]);
		myTree.printNodes(r3, args[4]);
	}
}
