package studentCoursePlanner.util;

import java.io.PrintWriter;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

/**
* 
*
* @author Justin Wang
*/
public class Results implements FileDisplayInterface, StdoutDisplayInterface {
	private PrintWriter writer;

	/**
	* This constructer will generate results given a string
	*/
	public Results(String fileName) {
		try {
			writer = new PrintWriter(fileName, "UTF-8");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.err.println("Error while writing to output file");
		} catch (UnsupportedEncodingException e2) {
			e2.printStackTrace();
			System.err.println("Error while writing to output file");
		}
		
	}

    /**
	* Given a file name, print results to file
	* @return nothing
	*/
	public void printResults(String fileName) {
		
	}

	/**
	* Prints results to stdout
	* @return nothing
	*/
	public void printToStdout(String lineIn) {
		System.out.println(lineIn);
	}

	public void writeLine(String lineIn) {
			writer.println(lineIn);
			writer.close();
	}

	public String readLine() {
		return "empty";
	}

	public void closeFile() {

	}
}
