package nyc.angus.algo;

/**
 * Operations performed over matrices.
 */
public class Matrix {

	/**
	 * Determine if <tt>search</tt> can be found within <tt>input</tt>.
	 */
	public static boolean search(final int[][] input, final int[][] search) {
		for (int y = 0; y < input.length; y++) {
			for (int x = 0; x < input[0].length; x++) {
				final boolean found = find(input, search, x, y);

				if (found) {
					return true;
				}
			}
		}

		return false;
	}

	private static boolean find(final int[][] input, final int[][] search, final int iX, final int iY) {
		int posY = iY;

		for (final int[] element : search) {

			int posX = iX;

			for (int x = 0; x < search[0].length; x++) {

				if (posY >= input.length || posX >= input[0].length) {
					return false;
				}

				if (element[x] == input[posY][posX]) {
					posX++;
				} else {
					return false;
				}

			}

			posY++;
		}

		return true;
	}
}
