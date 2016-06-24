package nyc.angus.algo;

/**
 * Utilities that require counting or summing values.
 */
public class Counting {

	/**
	 * For a given set of values, how many ways can those values be repeatedly added to reach the given goal amount.
	 */
	public static long getNumberOfWaysToReachGoal(final int goal, final int[] vals) {
		final long[] memo = new long[goal + 1];

		memo[0] = 1;

		for (final int val : vals) {
			for (int i = val; i < memo.length; i++) {
				memo[i] += memo[i - val];
			}
		}

		return memo[goal];
	}
}
