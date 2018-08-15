# CS428: Assignment 4
## Justin Wang

-----------------------------------------------------------------------
-----------------------------------------------------------------------


Following are the commands and the instructions to run ANT on your project.
#### Note: build.xml is present in dijkstras/src folder.
#### Note: These commands are executed from the dijkstras/src directory

-----------------------------------------------------------------------
## Instruction to clean:

#### Command: ant -buildfile build.xml clean

Description: It cleans up all the .class files that were generated when you compiled your code.
Also cleans any tar.gz file that may have been generated, also deletes javadocs

-----------------------------------------------------------------------
## Instruction to compile:

#### Command: ant -buildfile build.xml all

Description: Compiles your code and generates .class files inside the BUILD folder.

-----------------------------------------------------------------------
## Instruction to run:

#### Command: ant -buildfile build.xml run 

Description:	Will output to the command line the result of processing the hard coded graphs
				using Dijkstra's Algorithm

-----------------------------------------------------------------------
## Instruction to generate javadocs:

#### Command: ant -buildfile build.xml javadocs

Description: Generates javadocs using ant, creates javadocs folder in campusTour/src/BUILD folder

-----------------------------------------------------------------------
## Instruction to generate tar.gz:

#### Command: ant -buildfile build.xml tar

Description: Generates jwang138_p4.tar.gz file using ant in directory that contains jwang138_p4

## Design decisions

Description: I implemeted a very simple version of Dijkstra's algorithm reading a graph stored
			 stored in a 2D array.

-----------------------------------------------------------------------
References: https://www.geeksforgeeks.org/greedy-algorithms-set-6-dijkstras-shortest-path-algorithm/ and notes from class

-----------------------------------------------------------------------