package studentCoursesBackup.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.FileInputStream;
import java.io.IOException;

/**
* Class stores the file name given. Supposed to process files,
* but functionality is broken.
*/
public class FileProcessor {
	private String fileName;

	/**
	* Constructor creates a FileProcessor instance and sets the fileName
	*/
	public FileProcessor(String fIn) {
		fileName = fIn;
	}

/*	public void readFile(String fileName) {
		// Outline of readFile code found here: https://www.programcreek.com/2011/03/java-read-a-file-line-by-line-code-example/
		try {
			FileInputStream fis = new FileInputStream(fileName);

			// Construct BufferedReader from InputStreamReader
			BufferedReader br = new BufferedReader(new InputStreamReader(fis));
		} catch (IOException e) {
			e.printStackTrace();
			System.err.println("Error while reading input file");
		} finally {
			try {
				br.close();
				fis.close();
			} catch (IOException e) {
				e.printStackTrace();
				System.err.println("Error while closing input file");
			}
		}
	}

	public String nextLine(BufferedReader br) {
		String line = null;
		line = br.readLine();

		try {
			line = br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
			System.err.println("Error reading input file");
		} finally {
			br.close();
		}

	}*/

	/*public void writeToFile() {

	}*/

	/**
	* Simple method to get the file name
	* @return String returns the file name
	*/
	public String toString() {
		return fileName;
	}
}
