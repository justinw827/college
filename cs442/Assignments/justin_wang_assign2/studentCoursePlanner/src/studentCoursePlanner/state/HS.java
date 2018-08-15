package studentCoursePlanner.state;

import java.util.ArrayList;

/**
* The HS class implements the State Pattern for the Hardware Sequence 
* courses. It takes in a course name and does the proper
*  checks to see if the course can be added to the schedule.
* @author Justin Wang
*/
public class HS implements CoursePlannerStateI {
	private String takenCourses = ""; // List of taken courses
	private String courseList = "IJKL"; // Available courses
	private boolean reqsMet = false;

	/**
	* This method takes a course name and calls the necessary methods
	* to check if the given course is valid.
	* @param courseIn - The name of the course being checked
	* @return boolean - Returns true if course was valid, false if invalid
	*/
	public boolean processCourse(char courseIn) {
		boolean courseAdded = false; // True if course added successfully 

		char courseName = courseIn; // Get next course 
		boolean checkReq = checkCourse(courseName); // Check if desired course meets pre-requisites 
		if (checkReq == true) { // Prereqs met
			addCourse(courseName); // Add course to taken list
			courseAdded = true;
		} else {
			// Add course to waitlist
			courseAdded = false;
		}

		return courseAdded;
	}

	/**
	* This method will add the given course to the taken courses list and
	* and remove it from the eligible courses for this category.
	* @param courseIn - Name of course to be added
	* @return Nothing.
	*/
	public void addCourse(char courseIn) {
		// Add course to taken courses
		if (takenCourses == null) { // No courses taken yet
			takenCourses = Character.toString(courseIn);
		} else {
			takenCourses += Character.toString(courseIn);
		}

		// Remove current course from its list
		courseList.replace(courseIn, ' ');
	}

	/**
	* This method will check if the given course has the proper
	* prerequisites. 
	* @param courseIn - Name of course being checked
	* @return boolean - Returns true if prerequisites were met, else false
	*/
	public boolean checkCourse(char courseIn) {
		boolean prereqs = false;
		String courseNameIn = Character.toString(courseIn);
		if (takenCourses.length() > 0) {
			for (int i = 0; i < takenCourses.length(); i++) {
				String courseName = Character.toString(takenCourses.charAt(i)); // Convert from char to string
				if (courseNameIn.compareTo(courseName) > 0) { // Check if course is higher in alphabetic order than taken courses
					prereqs = true;
				} else {
					prereqs = false;
				}
			}
		} else { // Taken course list empty
			prereqs = true;
		}

		return prereqs;
	}

	/**
	* This method returns the number of courses taken for this category.
	* @return int - Returns number of courses taken for this category
	*/
	public int getReqs() {
		return takenCourses.length();
	}

	public void setReqsMet(boolean val) {
		reqsMet = val;
	}

	public boolean getReqsMet() {
		return reqsMet;
	}

	/**
	* This method returns the name of the state.
	* return String - Returns the name of the state.
	*/
	public String toString() {
		return "HS";
	}
}