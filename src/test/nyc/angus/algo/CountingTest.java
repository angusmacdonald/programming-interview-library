package nyc.angus.algo;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Tests of {@link Counting}.
 */
public class CountingTest {

	@Test
	public void testCounting() {
		final int[] values = { 1, 2, 3 };
		assertEquals(4, Counting.getNumberOfWaysToReachGoal(4, values));
	}

	@Test
	public void testCounting2() {
		final int[] values = { 2, 5, 3, 6 };
		assertEquals(5, Counting.getNumberOfWaysToReachGoal(10, values));
	}
}
