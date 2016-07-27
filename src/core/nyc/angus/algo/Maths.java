package nyc.angus.algo;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

/**
 * Math utilities.
 */
public class Maths {

	/**
	 * Check whether the input is a number in the fibonacci sequence.
	 */
	public static boolean isFibonacciNumber(final long input) {
		long val = 0;
		long prev = 1;

		// Loop until past number or overflow:
		while (val <= input && val >= 0) {
			if (val == input) {
				return true;
			}

			final long temp = val;
			val = val + prev;
			prev = temp;
		}

		return false;
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

	/**
	 * For an array containing pairs of numbers, but for one number, find that one number.
	 */
	public static int findLonelyInteger(final int[] a) {
		int tmp = 0;

		for (final int element : a) {
			tmp ^= element;
		}

		return tmp;
	}

	/**
	 * Find the median by balancing data between a min heap and a max heap.
	 */
	public static double findMedian(final int[] data) {
		final PriorityQueue<Integer> minHeap = new PriorityQueue<>();
		final PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(10, Collections.<Integer> reverseOrder());

		// Populate heaps:
		for (final int val : data) {
			if (!minHeap.isEmpty() && minHeap.peek() < val) {
				minHeap.add(val);
			} else {
				maxHeap.add(val);
			}

			if (minHeap.size() > (maxHeap.size() + 1)) {
				maxHeap.add(minHeap.poll());
			} else if (maxHeap.size() > (minHeap.size() + 1)) {
				minHeap.add(maxHeap.poll());
			}
		}

		// Select median:
		if (maxHeap.size() == minHeap.size()) {
			return ((double) maxHeap.peek() + minHeap.peek()) / 2;
		} else if (maxHeap.size() > minHeap.size()) {
			return (maxHeap.peek());
		} else {
			return (minHeap.peek());
		}
	}

	/**
	 * Return the number of squares between low and high.
	 */
	public static long countSquares(final int low, final int high) {
		final int start = (int) Math.floor(Math.sqrt(low));
		final int end = (int) Math.ceil(Math.sqrt(high));

		return IntStream.range(start, end + 1).map(i -> i * i).filter(s -> s >= low && s <= high).count();
	}
}
