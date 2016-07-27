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

	@Test
	public void factorialTest() {
		final int fiveFact = 5 * 4 * 3 * 2 * 1;

		assertEquals(fiveFact, Maths.factorial(5));
	}

	@Test
	public void factorialTestZero() {
		assertEquals(1, Maths.factorial(0));
	}

	@Test
	public void reverseNumber() {
		assertEquals(12345, Maths.reverse(54321));
		assertEquals(5, Maths.reverse(500));
		assertEquals(77, Maths.reverse(77));
	}

	@Test
	public void findLonelyInteger() {
		final int[] arr = { 1, 2, 4, 2, 1 };
		assertEquals(4, Maths.findLonelyInteger(arr));

		final int[] arr2 = { 1, 2, 4, 2, 4 };
		assertEquals(1, Maths.findLonelyInteger(arr2));
	}

}
