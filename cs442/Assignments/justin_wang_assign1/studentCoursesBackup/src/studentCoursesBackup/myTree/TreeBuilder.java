package studentCoursesBackup.myTree;

import java.io.IOException;
import java.util.ArrayList;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.FileInputStream;
import studentCoursesBackup.util.FileProcessor;
import studentCoursesBackup.util.Results;

	/**
	* Class builds a BST using 2 specified files
	*/
public class TreeBuilder {
	private Node root; // Main tree
	private Node oRoot1; // 1st Observer
	private Node oRoot2; // 2nd Observer

	private ArrayList<Node> orderedNodes = new ArrayList<Node>();

	/**
	* Constructor builds main tree and 2 observers of main tree
	*/
	public TreeBuilder(FileProcessor fp1, FileProcessor fp2) {
		root = null;
		oRoot1 = null;
		oRoot2 = null;


		// Outline of readFile code found here: https://www.programcreek.com/2011/03/java-read-a-file-line-by-line-code-example/
		try {
			FileInputStream fis = new FileInputStream(fp1.toString());

			// Construct BufferedReader from InputStreamReader
			BufferedReader br = new BufferedReader(new InputStreamReader(fis));

			// Process input fule
			String line = "empty";
			while (line != null) {
				line = br.readLine();
				if (line != null) {
					insert(line);
				}
			}

			br.close();
			fis.close();

			FileInputStream fis2 = new FileInputStream(fp2.toString());

			// Construct BufferedReader from InputStreamReader
			BufferedReader br2 = new BufferedReader(new InputStreamReader(fis2));

			// Process delete file
			String line2 = "empty";
			while (line2 != null) {
				line2 = br2.readLine();
				if (line2 != null) {
					delete(line2);
				}				
			}

			br2.close();
			fis2.close();

		} catch (IOException e) {
			e.printStackTrace();
			System.err.println("Error while reading input file");
		} finally {
			/*try {
				br.close();
				fis.close();
				br2.close();
				fis2.close();
			} catch (IOException e) {
				e.printStackTrace();
				System.err.println("Error while closing input file");
			}
*/		}
	}

	/**
	* Getter method returns reference to main root node
	* @return Node returns main root node
	*/
	public Node getRoot() {
		return root;
	}

	/**
	* Getter method returns reference to 1st observer root node
	* @return Node returns 1st observer's root node
	*/
	public Node getObserver1() {
		return oRoot1;
	}

	/**
	* Getter method returns reference to 2nd observer root node
	* @return Node returns 2nd observer's root node
	*/
	public Node getObserver2() {
		return oRoot2;
	}

	/**
	* Method inserts a new node into the tree if the B-Number doesn't
	* exist yet. or adds course to existing node. Identical changes 
	* performed on observers
	* @return nothing
	*/
	public void insert(String line) {
		// Parse line read from file
		String bNum2 = line.substring(0,3); // Get B-number
		int bNum = Integer.parseInt(bNum2); // Convert bNum to int

		String courseName = line.substring(5); // Get course name

		Node student = search(root, bNum); // Check if B-number exists
		if (student == null) { // B-number not found, create new node
			Node newNode = insertRec(root, bNum);
			newNode.addCourse(courseName); // Add course to new node

			// Add node to first observer
			Node ob1 = insertRec(oRoot1, bNum);
			ob1.addCourse(courseName);
			newNode.addObserver(ob1);

			// Add node to second observer
			Node ob2 = insertRec(oRoot2, bNum);
			ob2.addCourse(courseName);
			newNode.addObserver(ob2);
		} else { // B-number found, add course to array list
			student.addCourse(courseName); // Add course to main node (student)
			student.notify(courseName, "insert"); // notify observers of change
		}
	}

	/**
	* helper function for insert to insert node into proper place
	* of the tree following BST rules
	* Code found here: insertRec code found here: https://www.geeksforgeeks.org/binary-search-tree-set-1-search-and-insertion/
	* @return Node returns refernece to either left or right node
	*/
	public Node insertRec(Node root, int key) {
		/* If the tree is empty, return a new node */
        if (root == null) {
            root = new Node(key);
            return root;
        }
 
        /* Otherwise, recur down the tree */
        if (key < root.getKey())
            root.setLeft(insertRec(root.getLeft(), key));
        else if (key > root.getKey())
            root.setRight(insertRec(root.getRight(), key));
 
        /* return the (unchanged) node pointer */
        return root;
	}

	/**
	* Searches BST for specified key and returns the Node if found
	* Code found here: search code found here: https://www.geeksforgeeks.org/binary-search-tree-set-1-search-and-insertion/
	* @return Node returns refernece to Node with given key value if 
	* found, or null if not found
	*/
	public Node search(Node root, int key) {
		 // Base Cases: root is null or key is present at root
	    if (root == null || root.getKey() == key)
	        return root;
	 
	    // val is greater than root's key
	    if (root.getKey() > key)
	        return search(root.getLeft(), key);
	 
	    // val is less than root's key
	    return search(root.getRight(), key);
	}

	/**
	* Deletes given course from the given B-Number if it exists, nothing 
	* if not found
	* @return nothing
	*/
	public void delete(String line) {
		// Parse line read from file
		String bNum2 = line.substring(0,3); // Get B-number
		int bNum = Integer.parseInt(bNum2); // Convert bNum to int

		String courseName = line.substring(5); // Get course name

		Node student = search(root, bNum);
		if (student != null) { // Chec if b-number was found
			student.removeCourse(courseName); // Delete course from main tree
			student.notify(courseName, "delete"); // Notify observers of change
		}
	}

	/**
	* initiates storing of nodes to a results instance
	* @return nothing
	*/
	public void printNodes(Results r, String fileName) {
		r.printResults(fileName);
	}
}