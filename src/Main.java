
//Coding Pronto Robot by Alex Huang
import java.util.Scanner;

public class Main {
	private static final int ORIGIN_X = 0; // origin x and y initalise doesn't change
	private static final int ORIGIN_Y = 0;
	private static int coordX = 0; // current x and y of robot
	private static int coordY = 0;
	private static int farFromHome = 0; // initalise how many units from home
	private static String[] directionArray = { "NORTH", "EAST", "SOUTH", "WEST" }; // directional array
	private static int currentDirection = 0; // initialise north direction
	private static String commandType; // forward, backward, right or left
	private static String nextMove; // next move command
	private static int iterationCount = 0; // iteration count based on parasing user input

	static Scanner keyboard = new Scanner(System.in);

	// ensure each command is valid
	private static boolean commandValidator(String[] commands) {
		for (int i = 0; i < commands.length; i++) {
			if (commands[i].length() < 2 || Character.isLetter(commands[i].charAt(0)) == false) {
				return false;
			}
			for (int j = 1; j < commands[i].length(); j++) {
				if (Character.isDigit(commands[i].charAt(j)) == false) {
					return false;
				}
			}
		}
		return true;

	}

	private static void runCommands(String[] commands) {
		for (int i = 0; i < commands.length; i++) {
			nextMove = commands[i];
			commandType = nextMove.substring(0, 1);
			iterationCount = Integer.valueOf(nextMove.substring(1));
			switch (commandType) {
			// move forward in current direction for specified iterations
			case "f":
				for (int j = 0; j < iterationCount; j++) {
					switch (directionArray[currentDirection]) {
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
					switch (directionArray[currentDirection]) {
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
					if (currentDirection == directionArray.length - 1) {
						currentDirection = 0;
					} else {
						currentDirection++;
					}
				}
				break;
			// left turn 90 degrees for specified iterations
			case "l":
				for (int j = 0; j < iterationCount; j++) {
					if (currentDirection == 0) {
						currentDirection = directionArray.length - 1;
					} else {
						currentDirection--;
					}
				}
				break;

			default:
				System.out.println("invalid");
				break;
			}
		}
		farFromHome = Math.abs(ORIGIN_X - coordX) + Math.abs(ORIGIN_Y - coordY);
	}

	public static void main(String args[]) {
		System.out.println("Robo-mover Test");
		while (true) {
			System.out.println("enter a list of commands: ");
			String myMoves = keyboard.next();
			String[] commands = myMoves.split(",");
			if (commandValidator(commands) == false) {
				System.out.println("Invalid Entries, Please Re-enter List of Commands");
				continue;
			}
			runCommands(commands);
			System.out.printf("Current robot coordinate is %s,%s \n", coordX, coordY);
			System.out.printf("Robot is facing %s \n", directionArray[currentDirection]);
			System.out.printf("Robot is %d units from origin \n", farFromHome);
		}
	}
}
