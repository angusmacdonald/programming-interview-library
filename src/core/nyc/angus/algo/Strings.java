package nyc.angus.algo;

/**
 * Utilities for working with and comparing strings.
 */
public class Strings {

	/**
	 * Get the Levenshtein distance between two strings.
	 */
	public static int getEditDistance(final String a, final String b) {
		return getEditDistance(a.toCharArray(), b.toCharArray());
	}

	/**
	 * Get the Levenshtein distance between two strings in char arrays.
	 */
	public static int getEditDistance(final char[] a, final char[] b) {
		final int[][] memo = new int[a.length + 1][b.length + 1];

		/*
		 * Set up initial 0 x and y axis elements. THe premise of the setup is that (for the first row/column) each step
		 * takes one string i steps away from the other string (i.e. it would take i deletions to get to the other
		 * string which has one character at this point).
		 */
		for (int i = 0; i <= a.length; i++) {
			memo[i][0] = i;
		}

		for (int i = 0; i <= b.length; i++) {
			memo[0][i] = i;
		}

		// Calculate for remaining elements:
		for (int y = 1; y <= a.length; y++) {
			for (int x = 1; x <= b.length; x++) {
				if (a[y - 1] == b[x - 1]) {
					memo[y][x] = memo[y - 1][x - 1];

				} else {
					memo[y][x] = Math.min(memo[y - 1][x], Math.min(memo[y][x - 1], memo[y - 1][x - 1])) + 1;

				}
			}
		}

		// Return min edit distance.
		return memo[a.length][b.length];
	}
}
