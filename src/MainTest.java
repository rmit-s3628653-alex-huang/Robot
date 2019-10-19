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

}
