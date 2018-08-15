package studentCoursePlanner.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.File;

/**
* Class stores the file name given. Supposed to process files,
* but functionality is broken.
*/
public class FileProcessor {
	private String fileName;
	private FileReader fr;
	private BufferedReader br;
	private File file;

	/**
	* Constructor creates a FileProcessor instance and sets the fileName
	*/
	public FileProcessor(String fIn) {
		fileName = fIn;
		file = new File(fileName);
		try {
			fr = new FileReader(file);
			br = new BufferedReader(fr);
		} catch (FileNotFoundException e) {
			System.err.println("Error opening file.");
			e.printStackTrace();
		}
	}

	public void closeFile() {
		try {
			br.close();
			fr.close();
		} catch (IOException e) {
			e.printStackTrace();
			System.err.println("Error while closing file");
		}
	}

	public String readLine() {
		String line = null;
		try {
			// Read one line from buffer
			if ((line = br.readLine()) != null) {
				// Line read properly
			}
		} catch (IOException e) {
			e.printStackTrace();
			System.err.println("Error reading input file");
		}
		return line;
	}

	public void writeLine(String lineIn) {

	}

	/**
	* Simple method to get the file name
	* @return String returns the file name
	*/
	public String toString() {
		return fileName;
	}

}