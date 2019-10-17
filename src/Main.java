//Coding Pronto Robot by Alex Huang
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
	private static int ORIGIN_X = 0;
	private static int ORIGIN_Y = 0;
	private static int coordX = 0;
	private static int coordY = 0;
	private static int farFromHome = 0;
	
	static Scanner keyboard = new Scanner(System.in);
	
	public static void main(String args[])
	   {
		System.out.println("Robo-mover Test");
		System.out.println("enter an integer");
		String myMoves = keyboard.next();
		StringTokenizer token = new StringTokenizer(myMoves, ",");

		while (token.hasMoreElements()) {
			String nextMove = token.nextElement().toString();
			if (Character.isLetter(nextMove.charAt(0))) {
				if(Character.isDigit(nextMove.charAt(1))) {
					System.out.println("yes");
					switch(nextMove.charAt(0)) {
						case 'f':
						System.out.println("f");
						case 'b':
						System.out.println("b");
						case 'r':
						System.out.println("r");
						case 'l':
						System.out.println("l");
						
						default:
							System.out.println("invalid");
							break;
					}
				}
			}
			System.out.println(nextMove);
		}
//		System.out.println(myint);
		coordX += 2;
		coordY =- 2;
		farFromHome = Math.abs(ORIGIN_X - coordX) + Math.abs(ORIGIN_Y - coordY);
		System.out.println(farFromHome);
	   }
}
