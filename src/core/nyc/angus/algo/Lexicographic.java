package nyc.angus.algo;

import java.util.Arrays;

/**
 * Lexicographic operations.
 */
public class Lexicographic {

	/**
	 * Determines whether it is possible to lexicographically sort the array on both rows and columns.
	 * <p>
	 * The input array is modified.
	 */
	public static boolean isLexicographicSortPossible(final char[][] data) {
		for (final char[] element : data) {
			Arrays.sort(element);
		}

		for (int x = 0; x < data[0].length; x++) {
			final int prev = data[0][x];
			for (int y = 1; y < data.length; y++) {
				if (data[y][x] < prev) {
					return false;
				}
			}
		}

		return true;
	}
}
