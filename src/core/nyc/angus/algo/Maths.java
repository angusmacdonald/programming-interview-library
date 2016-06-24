package nyc.angus.algo;

import java.util.stream.IntStream;
import java.util.stream.LongStream;

/**
 * Math utilities.
 */
public class Maths {

	/**
	 * Return the number of squares between low and high.
	 */
	public static long countSquares(final int low, final int high) {
		final int start = (int) Math.floor(Math.sqrt(low));
		final int end = (int) Math.ceil(Math.sqrt(high));

		return IntStream.range(start, end + 1).map(i -> i * i).filter(s -> s >= low && s <= high).count();
	}

	/**
	 * Get the factorial of n.
	 */
	public static long factorial(final int n) {
		return LongStream.range(2, n + 1).reduce(1L, (sum, a) -> sum * a);
	}

	/**
	 * Reverse the provided number.
	 */
	public static long reverse(long in) {
		long out = 0L;

		while (in != 0) {
			final long next = in % 10;

			out *= 10;
			out += next;

			in /= 10;
		}

		return out;
	}

}
