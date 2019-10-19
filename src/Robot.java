
public class Robot {
	private int coordX;
	private int coordY;
	private int currentDirection;
	private int unitsFromHome;
	
	public Robot(int coordX, int coordY, int currentDirection, int unitsFromHome) {
		this.coordX = coordX;
		this.coordY = coordY;
		this.unitsFromHome  = unitsFromHome;
		this.currentDirection = currentDirection;
	}
	
	public void setCoordX(int coordX) {
		this.coordX = coordX;
	}
	
	public int getCoordX() {
		return this.coordX;
	}
	
	public void setCoordY(int coordY) {
		this.coordY = coordY;
	}
	
	public int getCoordY() {
		return this.coordY;
	}
	
	public void setUnitsFromHome(int unitsFromHome) {
		this.unitsFromHome = unitsFromHome;
	}
	
	public int getUnitsFromHome() {
		return this.unitsFromHome;
	}
	
	public void setCurrentDirection(int currentDirection) {
		this.currentDirection = currentDirection;
	}
	
	public int getCurrentDirection() {
		return this.currentDirection;
	}
}
