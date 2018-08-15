package studentCoursePlanner.state;

import java.util.ArrayList;

public class ScheduleProcessor {

	// Set graduation requirement check variables to false
		private boolean longProg = false; // Long Programming and Design
		private boolean dataStruct = false; // Data Structures and Algorithms
		private boolean hardware = false; // Hardware Sequence
		private boolean dataAnalysis = false; // Data Analytics
		private boolean electives = false; // Electives

		private ArrayList<Character> waitlist = new ArrayList<Character>();
		private ArrayList<Character> schedule = new ArrayList<Character>();

		private String bNum;
		private String courses;

	/**
	* Constructor creates a Schedule Processor instance and sets the B-Number and courses variables
	*/
	public ScheduleProcessor(String line) {
		String[] tokens = line.split(":");
		bNum = tokens[0];
		courses = tokens[1];	
	}

	public boolean checkSchedule() {
		System.out.println(bNum + courses);
		boolean gradCheck = false;
		char[] waitlist;
		for (int i = 0; i < courses.length(); i++) {
			if (i % 2 == 0) { // Skip whitespace 
				char currentCourse = courses.charAt(i);
				if (currentCourse <= 'A' && currentCourse >= 'D') {

				} else if (currentCourse <= 'E' && currentCourse >= 'H') {

				} else if (currentCourse <= 'I' && currentCourse >= 'L') {

				} else if (currentCourse <= 'M' && currentCourse >= 'P') {

				}
			}
		}

		return gradCheck;
	}

	public String toString() {
		return bNum; // Returns students B-number
	}

}