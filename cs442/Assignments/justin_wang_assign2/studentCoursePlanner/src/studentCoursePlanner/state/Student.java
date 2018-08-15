package studentCoursePlanner.state;

// Context class
public class Student {
	private CoursePlannerStateI currentState;
	private String schedule = null;
	private String waitlist = null;

	private CoursePlannerStateI LPD = new LPD();
	private CoursePlannerStateI DSA = new DSA();
	private CoursePlannerStateI HS = new HS();
	private CoursePlannerStateI DA = new DA();
	private CoursePlannerStateI Elect = new Elect();

	public Student() {
		currentState = null;
	}

	public boolean processStudent(String line) {
		boolean gradStatus = false;

		String[] tokens = line.split(":");
		String bNum = tokens[0]; // Get B-number
		String courses = tokens[1]; // Get course list
		courses = courses.substring(1); // Remove first whitespace

		int gradReqs = 0; // Graduation requirement counter

		while (courses.length() > 1 && gradStatus == false) { // While there are courses still in the list
			char courseNameC = courses.charAt(0);
			String courseName = Character.toString(courseNameC); // Convert to string

			// Check course category
			if (courseName.compareTo("A") >= 0 && courseName.compareTo("D") <= 0) { // Long Programming and Design
				currentState = LPD;
			} else if (courseName.compareTo("E") >= 0 && courseName.compareTo("H") <= 0) { // Data Structures and Algorithms
				currentState = DSA;
			} else if (courseName.compareTo("I") >= 0 && courseName.compareTo("L") <= 0) { // Hardware Sequence
				currentState = HS;
			} else if (courseName.compareTo("M") >= 0 && courseName.compareTo("P") <= 0) { // Data Analytics
				currentState = DA;
			} else if (courseName.compareTo("Q") >= 0 && courseName.compareTo("Z") <= 0) { // Elective
				currentState = Elect;
			} else { // Character not in range A-Z
				System.out.println("Unexpected character read.");
			}

			if (currentState.processCourse(courseNameC) == true) { // Check the first course in the list
				if (schedule == null) { // Schedule is empty
					schedule = courseName;
				} else {
					schedule += courseName;
				}
			} else {
				// Add course to waitlist
				if (waitlist == null) { // Waitlist is empty
					waitlist = courseName;
				} else {
					waitlist += courseName;
				}
			}
			if (courses.length() > 2) {
				courses = courses.substring(2); // Remove first courses and whitespace from list
			}

			// Check if graduation requirements met yet
			currentState = LPD;
			if (currentState.getReqs() >= 2 && currentState.getReqsMet() == false) { 
				gradReqs++;
				currentState.setReqsMet(true);
			}

			currentState = DSA;
			if (currentState.getReqs() >= 2 && currentState.getReqsMet() == false) {
				gradReqs++;
				currentState.setReqsMet(true);
			}

			currentState = HS;
			if (currentState.getReqs() >= 2 && currentState.getReqsMet() == false) {
				gradReqs++;
				currentState.setReqsMet(true);
			}

			currentState = DA;
			if (currentState.getReqs() >= 2 && currentState.getReqsMet() == false) {
				gradReqs++;
				currentState.setReqsMet(true);
			}

			currentState = Elect;
			if (currentState.getReqs() >= 2 && currentState.getReqsMet() == false) {
				gradReqs++;
				currentState.setReqsMet(true);
			}

			if (gradReqs == 5) {
				gradStatus = true;
			}
		}

		return gradStatus;
	}

	public void setState(CoursePlannerStateI stateIn) {
		currentState = stateIn;
	}

	public int getNumSemesters() {
		int courseNum = schedule.length();
		int total = courseNum / 3;
		if (courseNum % 3 > 0) // Final semester has fewer than 3 classes
			total++;
		return total;
	}

	public String getSchedule() {
		return schedule;
	}

}