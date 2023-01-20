package input.components.point;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PointNodeTest {

	@Test
	void equalsSimpleTest() {
		
		assertTrue(new PointNode(0.0, 1.0).equals(new PointNode(0.0, 1.0)));
		
		assertFalse(new PointNode(0.1, 1.0).equals(new PointNode(0.0, 1.0)));
		
	}
	
	@Test
	void equalsRemoveLessEpsilonTest() {
		
		assertTrue(new PointNode(Math.sqrt(10), Math.sqrt(11)).
				equals(new PointNode(Math.sqrt(10), Math.sqrt(11))));
		
		assertFalse(new PointNode(Math.sqrt(11), Math.sqrt(11)).
				equals(new PointNode(Math.sqrt(10.9), Math.sqrt(11))));
		
		assertTrue(new PointNode(Math.sqrt(Math.PI), Math.sqrt(Math.PI)).
				equals(new PointNode(Math.sqrt(Math.PI), Math.sqrt(Math.PI))));
		
	}

}
