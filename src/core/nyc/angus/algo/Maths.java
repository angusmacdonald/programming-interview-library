package nyc.angus.algo;

/**
 * Math utilities.
 */
public class Maths {

	/**
	 * Return the number of squares between low and high.
	 */
	public static int countSquares(final int low, final int high) {
		final int start = (int) Math.floor(Math.sqrt(low));
		final int end = (int) Math.ceil(Math.sqrt(high));

		int count = 0;

		for (int i = start; i <= end; i++) {
			final int square = i * i;

			count += square >= low && square <= high ? 1 : 0;
		}

		return count;
	}
}
