package studentCoursesBackup.myTree;

import java.util.ArrayList;

/**
* Class contains all node info and relevant methods to operate on a node.
* Implements the observer pattern.
* Observer pattern concepts from: https://www.tutorialspoint.com/design_pattern/observer_pattern.htm
*/
public class Node implements SubjectI, ObserverI {
	private int key;
	private ArrayList<String> courses = new ArrayList<String>(); // Array list only increases by 50% with each new element
	private ArrayList<Node> observers = new ArrayList<Node>(); // List of observers
	private Node left, right;

	/**
	* Constructor creates a node and sets the key value and initializes
	* left and right nodes.
	*/
	public Node(int bNum) {
		key = bNum;
		left = null;
		right = null;
	}

	/**
	* Method creates a string holding the B-Number and associated 
	* courses
	* @return String returns string containing B-Number and course list 
	*/
	public String toString() {
		String retVal = "B-number: " + key + "\nCourses: ";
		for (int i = 0; i < courses.size(); i++) {
			retVal += (", " + courses.get(i));
		}
		return retVal;
	}

	/**
	* Getter method to get B-Number
	* @return int returns key value
	*/
	public int getKey() {
		return key;
	}

	/**
	* Getter method to get left node reference
	* @return Node returns reference to current node's left node
	*/
	public Node getLeft() {
		return left;
	}

	/**
	* Getter method to get right node reference
	* @return Node returns reference to current node's right node
	*/
	public Node getRight() {
		return right;
	}

	/**
	* Getter method to get size of observer list
	* @return int returns number of observers 
	*/
	public int getObserverSize() {
		return observers.size();
	}

	/**
	* Getter method to get observer at specified index
	* @return Node returns reference to observer or null if no observer 
	* found
	*/
	public Node getObserver(int index) {
		Node retVal;
		if (index < observers.size()) {
			retVal = observers.get(index);
		} else {
			retVal = null;
		}

		return retVal;
	}

	/**
	* Setter method to set key value
	* @return nothing
	*/
	public void setKey(int sIn) {
		key = sIn;
	}

	/**
	* Setter method to set left node
	* @return nothing
	*/
	public void setLeft(Node nIn) {
		left = nIn;
	}

	/**
	* Setter method to set right node
	* @return nothing
	*/
	public void setRight(Node nIn) {
		right = nIn;
	}

	/**
	* Method adds given course name to courses list
	* @return nothing
	*/
	public void addCourse(String courseName) {
		courses.add(courseName);
	}

	/**
	* Method looks for specified course in course list
	* @return int returns index of course or -1 if not found
	*/
	public int findCourse(String courseName) {
		int retVal = -1;
		int i = 0;
		// Look through courses for matching course name
		while (courses.get(i) != courseName && i < courses.size()) {
			i++;
		}

		if (courses.get(i) == courseName) // Course found in array list
			retVal = i;

		return retVal;
	}

	/**
	* Method removes specified course from course list if found
	* @return nothing
	*/
	public void removeCourse(String courseName) {
		int courseIndex = findCourse(courseName);
		if (courseIndex >= 0) { // Check if course was found
			courses.remove(courseIndex);
		} else {
			System.out.println("Course '" + courseName + "' not found.\n");
		}
	}

	/**
	* Method adds specified observer to observer list
	* @return nothing
	*/
	public void addObserver(Node observer) {
		observers.add(observer);
	}

	/**
	* Notfies all observers of a change to the node
	* @return nothing
	*/
	public void notify(String courseName, String alertType) {
		// For each observer call update()
		for (Node observer : observers) { 
			observer.update(courseName, alertType);
		}
	}

	/**
	* Updates observer nodes based on specified behavior
	* @return nothing
	*/
	public void update(String courseName, String alertType) {
		for (Node observer : observers) {
			if (alertType == "insert") {
				observer.addCourse(courseName);
			} else if (alertType == "delete") {
				observer.removeCourse(courseName);
			} else {
				System.err.println("Error: Unexpected value for variable alertType in \nClass: Node,\nMethod: update,\n Value:" + alertType);
			}
		}
	}
}
