package studentCoursePlanner.driver;

import studentCoursePlanner.util.FileProcessor;
import studentCoursePlanner.util.Results;
import studentCoursePlanner.state.Student;

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
		if (args.length != 2 || args[0].equals("${arg0}") || args[1].equals("${arg1}")) {

			System.err.println("Error: Incorrect number of arguments. Program accepts 2 argumnets.");
			System.exit(0);
		}

		// Get input file name
		String fIn = args[0];

		// Create new file processor instance
		FileProcessor fp1 = new FileProcessor(fIn);
		// Read line from input file
		String line = fp1.readLine();
		// Create new Schedule Processor instance
		Student student = new Student();
		boolean gradStatus = student.processStudent(line);

		String output = args[1];
		Results results = new Results(output);
		String schedule = student.getSchedule();
		if (gradStatus == true) {
			int semesters = student.getNumSemesters(); // Get number of semesters needed to graduate
			String semestersString = Integer.toString(semesters); // Convert int to string
			schedule = schedule + " Number of semesters: " + semestersString; // Append number of semesters taken to graduate
		} else {
			schedule = schedule + " Student did not graduate.";
		}

		System.out.println(gradStatus);

		results.writeLine(schedule);
	}
}