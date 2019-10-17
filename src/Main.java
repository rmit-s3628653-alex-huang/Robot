
//Coding Pronto Robot by Alex Huang
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
	private static int ORIGIN_X = 0; //origin x and y initalise doesn't change
	private static int ORIGIN_Y = 0;
	private static int coordX = 0; //current x and y of robot
	private static int coordY = 0;
	private static int farFromHome = 0; // initalise how many units from home
	private static String[] directionArray = { "NORTH", "EAST", "SOUTH", "WEST" }; //directional array
	private static int currentDirection = 0; // initialise north direction
	private static int iterationCount = 0; //iteration count based on parasing user input

	static Scanner keyboard = new Scanner(System.in);

	public static void main(String args[]) {
		System.out.println("Robo-mover Test");
		while (true) {
			System.out.println("enter a list of commands: ");
			String myMoves = keyboard.next();
			StringTokenizer token = new StringTokenizer(myMoves, ",");
			while (token.hasMoreElements()) {
				String nextMove = token.nextElement().toString();
				if (nextMove.length() != 2 || Character.isLetter(nextMove.charAt(0)) == false
						|| Character.isDigit(nextMove.charAt(1)) == false) {
					System.out.println("invalid entry, please re-enter value");
					break;
				}
				iterationCount = Character.getNumericValue(nextMove.charAt(1));
//				System.out.println(iterationCount);
				switch (nextMove.charAt(0)) {
				// move forward in current direction for specified iterations
				case 'f':
					for (int i = 0; i < iterationCount; i++) {
						switch (currentDirection) {
						case 0:
							coordY++;
							break;
						case 1:
							coordX++;
							break;
						case 2:
							coordY--;
						case 3:
							coordX--;
							break;
						}
					}
					break;
				// move backwards in current direction for specified iterations
				case 'b':
					for (int i = 0; i < iterationCount; i++) {
						switch (currentDirection) {
						case 0:
							coordY--;
							break;
						case 1:
							coordX--;
							break;
						case 2:
							coordY++;
						case 3:
							coordX++;
							break;
						}
					}
					break;
				// right turn 90 degrees for specified iterations
				case 'r':
					for (int i = 0; i < iterationCount; i++) {
						if (currentDirection == directionArray.length - 1) {
							currentDirection = 0;
						} else {
							currentDirection++;
						}
//						System.out.println(directionArray[currentDirection]);
					}
					break;
				// left turn 90 degrees for specified iterations
				case 'l':
					for (int i = 0; i < iterationCount; i++) {
						if (currentDirection == 0) {
							currentDirection = directionArray.length - 1;
						} else {
							currentDirection--;
						}
//						System.out.println(directionArray[currentDirection]);
					}
					break;

				default:
					System.out.println("invalid");
					break;
				}
			}
			farFromHome = Math.abs(ORIGIN_X - coordX) + Math.abs(ORIGIN_Y - coordY);
			System.out.printf("Robot is facing %s \n", directionArray[currentDirection]);
			System.out.printf("Robot is %d units from origin \n",farFromHome);
		}
	}
}
