
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MainTest {

	@Test
	void testValidator() {
		String[] testArray = {"f1", "f2", "r1", "l1","f4","b4"}; //valid set of inputs
		String[] testArray2 = {"e1", "f2"}; //invalid input - invalid letter
		String[] testArray3 = {"e1", "f2"}; //invalid input - invalid length
		boolean testValid = Main.commandValidator(testArray);
		boolean testValid2 = Main.commandValidator(testArray2);
		boolean testValid3 = Main.commandValidator(testArray3);
		assertEquals(true, testValid);
		assertEquals(false, testValid2);
		assertEquals(false, testValid3);
	}
	
	@Test
	void testRobot() {
		// test creation of a new robot
		Robot robo1 = new Robot(0,0,0,0);
		assertEquals(robo1.getCoordX(),0);
		assertEquals(robo1.getCoordY(),0);
		assertEquals(robo1.getCurrentDirection(),0);
		assertEquals(robo1.getUnitsFromHome(),0);
	}
	
	@Test
	void testFull() {
		// test all parts of application together
		Robot robo1 = new Robot(0,0,0,0);
		String[] testArray = {"f2", "r1", "f2", "b4", "l2"};
		boolean testValid = Main.commandValidator(testArray);
		assertEquals(true, testValid);
		Main.runCommands(testArray,robo1);
		// test coordinates, units from origin and direction should be -2,2 4 units from home, facing 3 (aka west)
		assertEquals(robo1.getCoordX(), -2);
		assertEquals(robo1.getCoordY(), 2);
		assertEquals(robo1.getUnitsFromHome(), 4);
		assertEquals(robo1.getCurrentDirection(), 3);
	}

}
