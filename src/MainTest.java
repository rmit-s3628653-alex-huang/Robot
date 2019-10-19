
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MainTest {

	@Test
	void testValidator() {
		String[] arrayValid = { "f1", "f2", "r1", "l1", "f4", "b4" }; // valid set of inputs
		String[] testArray2 = { "e1", "f2" }; // invalid input - invalid letter
		String[] arrayLength = { "e1", "f2" }; // invalid input - invalid length
		String[] arrayNegative = { "e1", "f-2" }; // invalid input - negative input
		String[] arrayNumber = { "e1", "22" }; // invalid input - numbers input only
		String[] arrayDecimal = { "e1", "e2.2" }; // invalid input - numbers input only
		boolean testValid = Main.commandValidator(arrayValid);
		boolean testLetter = Main.commandValidator(testArray2);
		boolean testLength = Main.commandValidator(arrayLength);
		boolean testNegative = Main.commandValidator(arrayNegative);
		boolean testNumber = Main.commandValidator(arrayNumber);
		boolean testDecimal = Main.commandValidator(arrayDecimal);
		assertEquals(true, testValid);
		assertEquals(false, testLetter);
		assertEquals(false, testLength);
		assertEquals(false, testNegative);
		assertEquals(false, testNumber);
		assertEquals(false, testDecimal);
	}

	@Test
	void testRobot() {
		// test creation of a new robot
		Robot robo1 = new Robot(0, 0, 0, 0);
		assertEquals(robo1.getCoordX(), 0);
		assertEquals(robo1.getCoordY(), 0);
		assertEquals(robo1.getCurrentDirection(), 0);
		assertEquals(robo1.getUnitsFromHome(), 0);
	}

	@Test
	void testFull() {
		// test all parts of application together
		Robot robo1 = new Robot(0, 0, 0, 0);
		String[] testArray = { "f2", "r1", "f2", "b4", "l2" };
		boolean testValid = Main.commandValidator(testArray);
		assertEquals(true, testValid);
		Main.runCommands(testArray, robo1);
		// test coordinates, units from origin and direction should be -2,2 4 units from
		// home, facing 3 (aka west)
		assertEquals(robo1.getCoordX(), -2);
		assertEquals(robo1.getCoordY(), 2);
		assertEquals(robo1.getUnitsFromHome(), 4);
		assertEquals(robo1.getCurrentDirection(), 3);
	}

}
