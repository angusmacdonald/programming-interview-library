package nyc.angus.algo;

/**
 * Bit operations.
 */
public class Bits {

	/**
	 * Get the number of bits that would need to be flipped for the two numbers to match.
	 */
	public static int numBitsToFlip(final int a, final int b) {

		int different = a ^ b;

		int numDifferences = 0;

		while (different > 0) {
			final int previous = different;

			different = different >> 1;

			if (previous % 2 == 1) {
				numDifferences++;
			}
		}

		return numDifferences;
	}

	/**
	 * Put one number into another in binary, starting at position i and ending at j.
	 */
	public static int placeInto(final int larger, final int smaller, final int i, final int j) {

		final int largerCleared = clearRangeInNum(larger, i, j);

		final int smallerMovedUp = moveNumNPositions(smaller, i);

		return smallerMovedUp + largerCleared;
	}

	private static int moveNumNPositions(final int smaller, final int i) {
		return smaller << i;
	}

	private static int clearRangeInNum(final int larger, final int i, final int j) {
		int mask = 1 << i; // mask set at position i.

		int largerCleared = larger;
		for (int x = i; x < j; x++) {
			largerCleared = largerCleared & ~mask;
			mask = mask << 1;
		}
		return largerCleared;
	}
}
