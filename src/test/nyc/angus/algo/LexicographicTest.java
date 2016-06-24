package nyc.angus.algo;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Tests of {@link Lexicographic}.
 */
public class LexicographicTest {

	@Test
	public void isLexicographicSortPossibleTrue() {
		final char[][] arr = new char[5][0];

		arr[0] = "ebacd".toCharArray();
		arr[1] = "fghij".toCharArray();
		arr[2] = "olmkn".toCharArray();
		arr[3] = "trpqs".toCharArray();
		arr[4] = "xywuv".toCharArray();

		assertTrue(Lexicographic.isLexicographicSortPossible(arr));
	}

	@Test
	public void isLexicographicSortPossibleFalse() {
		final char[][] arr = new char[3][0];

		arr[0] = "uxf".toCharArray();
		arr[1] = "vof".toCharArray();
		arr[2] = "hmp".toCharArray();

		assertFalse(Lexicographic.isLexicographicSortPossible(arr));
	}
}
