
//Coding Pronto Robot by Alex Huang
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	private static final int ORIGIN_X = 0; // origin x and y initalise doesn't change
	private static final int ORIGIN_Y = 0;
	private static final String[] directionArray = { "NORTH", "EAST", "SOUTH", "WEST" }; // directional array
	private static final String[] validCommands = { "f", "b", "r", "l" }; // array of valid commands

	static Scanner keyboard = new Scanner(System.in);

	public static void main(String args[]) {
		// separate command line ui and core logic for better modularity
		System.out.println("Robot Command Line Application for Pronto by Alex Huang");
		Robot robot1 = new Robot(0, 0, 0, 0); // initialise robot at origin facing north
		// continuous loop to add more commands until termination
		while (true) {
			System.out.println("Enter a list of commands\n(a letter f (forward), b(backward), l(left 90 degrees), "
					+ "r(right 90 degrees) followed by the number of times to repeat the command\nexample: f2,r1,l2,b2 )\nor n to start from the origin again or\ne to exit: ");
			String myMoves = keyboard.next();
			if (myMoves.toLowerCase().equals("e")) {
				System.out.println("Program Terminated");
				break;
			}
			if (myMoves.toLowerCase().equals("n")) {
				robot1 = new Robot(0, 0, 0, 0);
				System.out.println("New Robot Initiated");
				continue;
			}
			String[] commands = myMoves.split(",");
			if (commandValidator(commands) == false) {
				System.out.println("Invalid Entries, Please Re-enter List of Commands");
				continue;
			}
			runCommands(commands, robot1);

			System.out.printf("Current robot coordinate is %s,%s \n", robot1.getCoordX(), robot1.getCoordY());
			System.out.printf("Robot is currently facing %s \n", directionArray[robot1.getCurrentDirection()]);
			System.out.printf("Robot is currently %d units from origin \n", robot1.getUnitsFromHome());
		}
	}

	// ensure each command is valid
	public static boolean commandValidator(String[] commands) {
		for (int i = 0; i < commands.length; i++) {
			// make sure command is at least two inputs long and that it contains a valid
			// letter command
			if (commands[i].length() < 2 || Arrays.asList(validCommands)
					.contains(Character.toString(commands[i].charAt(0)).toLowerCase()) == false) {
				return false;
			}
			// make sure all input after the letter command is numeric
			for (int j = 1; j < commands[i].length(); j++) {
				if (Character.isDigit(commands[i].charAt(j)) == false) {
					return false;
				}
			}
		}
		return true;

	}

	// run commands list
	public static void runCommands(String[] commands, Robot robot) {
		int coordX = robot.getCoordX();
		int coordY = robot.getCoordY();
		int direction = robot.getCurrentDirection();
		int iterationCount = 0;
		String nextMove;
		String commandType;
		for (int i = 0; i < commands.length; i++) {
			nextMove = commands[i];
			commandType = nextMove.substring(0, 1);
			iterationCount = Integer.valueOf(nextMove.substring(1));
			switch (commandType.toLowerCase()) {
			// move forward in current direction for specified iterations
			case "f":
				for (int j = 0; j < iterationCount; j++) {
					switch (directionArray[direction]) {
					case "NORTH":
						coordY++;
						break;
					case "EAST":
						coordX++;
						break;
					case "SOUTH":
						coordY--;
						break;
					case "WEST":
						coordX--;
						break;
					}
				}
				break;
			// move backwards in current direction for specified iterations
			case "b":
				for (int j = 0; j < iterationCount; j++) {
					switch (directionArray[direction]) {
					case "NORTH":
						coordY--;
						break;
					case "EAST":
						coordX--;
						break;
					case "SOUTH":
						coordY++;
						break;
					case "WEST":
						coordX++;
						break;
					}
				}
				break;
			// right turn 90 degrees for specified iterations
			case "r":
				for (int j = 0; j < iterationCount; j++) {
					if (direction == directionArray.length - 1) {
						direction = 0;
					} else {
						direction++;
					}
				}
				break;
			// left turn 90 degrees for specified iterations
			case "l":
				for (int j = 0; j < iterationCount; j++) {
					if (direction == 0) {
						direction = directionArray.length - 1;
					} else {
						direction--;
					}
				}
				break;
			}
		}
		robot.setCoordX(coordX);
		robot.setCoordY(coordY);
		robot.setCurrentDirection(direction);
		// absolute distance calculation to account for negative coordinates
		robot.setUnitsFromHome(Math.abs(ORIGIN_X - coordX) + Math.abs(ORIGIN_Y - coordY));

	}

}
