package nyc.angus.algo;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Tests of {@link Subsequence}.
 */
public class SubsequenceTest {

	@Test
	public void longestCommonSubsequence() {
		assertEquals("NHA", Subsequence.findLongestCommonSubsequence("SHINCHAN", "NOHARAAA"));
		assertEquals("", Subsequence.findLongestCommonSubsequence("ABC", "XYZ"));
	}

}
