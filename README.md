## Instructions

Make sure you have JDK or JRE installed: https://www.oracle.com/technetwork/java/javase/downloads/index.html

### To run jar file via command line:

* Download Robot.zip release @ https://github.com/rmit-s3628653-alex-huang/Robot/releases
* Unzip Robot.zip
* Run RunRobot.bat

### To run via eclipse console:

* Download and install eclipse for java: https://www.eclipse.org/downloads/packages/installer
* Clone/download and import this project @ https://github.com/rmit-s3628653-alex-huang/Robot
* Browse and click on src, then click run to start project in terminal or
* Click on Main.java to run program in eclipse console.
* Click on MainTest.java to run junit tests.

### To run via command line such as cmd.exe:

* Clone/download and import this project @ https://github.com/rmit-s3628653-alex-huang/Robot
* Via command line go to directory with source files
* run command without parentheses "javac Main.java Robot.java"
* run command without parentheses "java Main"
* If javac/java commands are unable to be run follow this to fix pathing: https://javatutorial.net/set-java-home-windows-10
* If command line cannot run commands/write file, try restarting command line as administrator


## Design Explanations

* Command Line application which takes in keyboard input and allows the user to continue to enter new commands from the point where the robot has arrived or restart at the origin, for better usability.
* Allows termination in-program (which also includes a exit confirmation so the user doesn't accidentally close the application) instead of having to close the window or force close, for cleaner interaction.
* Created a robot class object to facilitate extensibility (maybe multiple robots running on the same field).
* Separated console printing and input from internal methods to allow better modularity (such as replacing the console ui with a proper gui in the future).
* Junit for easy regression testing if more features are to be added.
*
*
*
## Woven graduate coding test

Your task is to write a CLI application to parse commands and display the result.

Suppose you have a robot that can receive commands in order to move it.  These commands will tell the robot to go forwards or backwards, and turn left or right.  These commands will be  in the format <command><number>.  For example 'L1' means 'turn left by 90 degrees once'.  'B2' would mean go backwards 2 units.

### Available commands:
* `F` - move forward 1 unit
* `B` - move backward 1 unit
* `R` - turn right 90 degrees
* `L` - turn left 90 degrees

### Your task
Write a program that receives a string of commands and will output the robot's distance from it's starting point.  This distance will be the minimum amount of units the robot will need to traverse in order to get back to it's starting point.  Remember, the robot can only turn 90 degrees at a time, so it cannot go directly back home, it must go in north, south, east, west directions.

Inputs: - a string of comma-separated commands eg `F1,R1,B2,L1,B3`
Output: - the minimum amount of distance to get back to the starting point (`4` in this case)

The specifics and implementation of this code is completely up to you!  The input could be a string, a filename with the commands as contents or anything else.

### What we are looking for:
* We are a Ruby house, however feel free to pick the language you feel you are strongest in.
* Code that is well thought out and tested
* Clean and readable code
* Extensibility should be considered
* A git commit-history would be preferred, with small changes committed often so we can see your approach

Please include a readme with any additional information you would like to include, including instructions on how to test and execute your code.  You may wish to use it to explain any design decisions.

Despite this being a small command line app, please approach this as you would a production problem using whatever approach to coding and testing you feel appropriate.
