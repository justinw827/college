# CSX42: Assignment 2
## Name: Justin Wang

-----------------------------------------------------------------------
-----------------------------------------------------------------------


Following are the commands and the instructions to run ANT on your project.
#### Note: build.xml is present in studentCoursePlanner/src folder.

-----------------------------------------------------------------------
## Instruction to clean:

####Command: ant -buildfile studentCoursePlanner/src/build.xml clean

Description: It cleans up all the .class files that were generated when you
compiled your code.

-----------------------------------------------------------------------
## Instruction to compile:

####Command: ant -buildfile studentCoursePlanner/src/build.xml all

Description: Compiles your code and generates .class files inside the BUILD folder.

-----------------------------------------------------------------------
## Instruction to run:

####Command: ant -buildfile studentCoursePlanner/src/build.xml run -Darg0=<input_file.txt> -Darg1=<output_file.txt>

Note: Arguments accept the absolute path of the files.


-----------------------------------------------------------------------
## Description:

Each category of courses is its own state, and the behavior of how the course is process is dependent on which category the course fits in. If a course cannot be taken it is added to the waitlist, but courses are not taken off the waitlist in this implementation.

Currently file IO does not work properly, but if you pass in the string manually on line 35 in Driver.main and the code will run properly 

-----------------------------------------------------------------------
## Citations:

No code taken from outside sources

-----------------------------------------------------------------------
### Academic Honesty statement:
-----------------------------------------------------------------------

"I have done this assignment completely on my own. I have not copied
it, nor have I given my solution to anyone else. I understand that if
I am involved in plagiarism or cheating I will have to sign an
official form that I have cheated and that this form will be stored in
my official university record. I also understand that I will receive a
grade of 0 for the involved assignment for my first offense and that I
will receive a grade of F for the course for any additional
offense.""

Date: -- 3/13/18


