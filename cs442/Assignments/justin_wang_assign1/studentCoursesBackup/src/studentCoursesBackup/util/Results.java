package studentCoursesBackup.util;

import java.util.ArrayList;
import java.io.IOException;
import java.io.PrintWriter;

import studentCoursesBackup.myTree.Node;

/**
* Results gathers data from a tree and stores it in order in either 
* a file or to stdout
*
* @author Justin Wang
*/
public class Results implements FileDisplayInterface, StdoutDisplayInterface {

	private ArrayList<Node> results = new ArrayList<Node>();

	/**
	* Thsi constructer will generate results given a root node
	*/
	public Results(Node source) {
		inorder(source);
	}

	/**
	* This method traverses a BST given a source node
	* Citation: https://www.geeksforgeeks.org/binary-search-tree-set-1-search-and-insertion/
	* @return nothing
	*/
	public void inorder(Node source)  {
       inorderRec(source);
    }
 
 	/**
	* A utility function to do inorder traversal of BST
	* Citation: https://www.geeksforgeeks.org/binary-search-tree-set-1-search-and-insertion/
	* @return nothing
	*/
    public void inorderRec(Node source) {
        if (source != null) {
            inorderRec(source.getLeft());
            results.add(source);
            inorderRec(source.getRight());
        }
    }

    /**
	* Given a file name, print results to file
	* @return nothing
	*/
	public void printResults(String fileName) {
		try {
			PrintWriter writer = new PrintWriter(fileName, "UTF-8");
			for (int i = 0; i < results.size(); i++) {
				writer.println(results.get(i).toString());
			}

			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
			System.err.println("Error while writing to output file");
		} finally {
			/*try {
				writer.close();
			} catch (IOException e) {
				e.printStackTrace();
				System.err.println("Error while reading input file");
			}*/
		}		
	}

	/**
	* Prints results to stdout
	* @return nothing
	*/
	public void printToStdout() {
		for (int i = 0; i < results.size(); i++) {
			System.out.println(results.get(i).toString());
		}
	}
}
