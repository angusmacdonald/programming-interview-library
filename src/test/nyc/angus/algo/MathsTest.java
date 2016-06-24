package nyc.angus.algo;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Tests of {@link Maths}.
 */
public class MathsTest {

	@Test
	public void countSquares() {
		assertEquals(2, Maths.countSquares(3, 9));
		assertEquals(0, Maths.countSquares(17, 24));
	}

}
