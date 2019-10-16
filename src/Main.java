
public class Main {
	private static int ORIGIN_X = 0;
	private static int ORIGIN_Y = 0;
	private static int coordX = 0;
	private static int coordY = 0;
	private static int farFromHome = 0;
	
	public static void main(String args[])
	   {
		System.out.println("Robo-mover Test");
		coordX += 2;
		coordY =- 2;
		farFromHome = Math.abs(ORIGIN_X - coordX) + Math.abs(ORIGIN_Y - coordY);
		System.out.println(farFromHome);
	   }
}
