package nyc.angus.algo;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Utilities for finding and searching subsequences in arrays.
 */
public class Subsequence {
	public static String findLongestCommonSubsequence(final String a, final String b) {
		return findLongestCommonSubsequence(a.toCharArray(), b.toCharArray());
	}

	public static String findLongestCommonSubsequence(final char[] a, final char[] b) {
		final int[][] memo = new int[a.length + 1][b.length + 1];

		for (int y = 1; y < memo.length; y++) {
			for (int x = 1; x < memo[0].length; x++) {
				if (a[y - 1] == b[x - 1]) {
					memo[y][x] = memo[y - 1][x - 1] + 1;
				} else {
					memo[y][x] = Math.max(memo[y][x - 1], memo[y - 1][x]);
				}
			}
		}

		final StringBuilder result = new StringBuilder();

		int y = memo.length - 1;
		int x = memo[0].length - 1;

		while (x > 0 && y > 0) {
			if (a[y - 1] == b[x - 1]) {
				result.append(a[y - 1]);
				y--;
				x--;
			} else if (memo[y][x - 1] > memo[y - 1][x]) {
				x--;
			} else {
				y--;
			}
		}

		return result.reverse().toString();
	}

	/**
	 * Use a patience sort to find the length of the longest increasing subsequence in the array.
	 */
	public static int getLengthOfLongestIncreasingSubsequence(final int[] data) {
		final ArrayList<Stack<Integer>> piles = new ArrayList<>(data.length);

		for (final int i : data) {

			Stack<Integer> pile = findPile(i, piles, 0, piles.size());

			if (pile == null) {
				pile = new Stack<>();
				piles.add(pile);
			}

			pile.add(i);
		}

		return piles.size();
	}

	/**
	 * Use a binary search to find the appropriate pile to add the next value to.
	 */
	private static Stack<Integer> findPile(final int i, final ArrayList<Stack<Integer>> piles, final int start, final int end) {
		if (piles.isEmpty() || start == end) {
			return null;
		}

		final int midpoint = Math.min(piles.size() - 1, start + ((end - start) / 2));
		final Stack<Integer> mid = piles.get(midpoint);

		if (i <= mid.peek()) {
			// Look left as far as possible.
			if (midpoint == 0 || piles.get(midpoint - 1).peek() < i) {
				return mid;
			} else {
				return findPile(i, piles, start, midpoint);
			}
		} else {
			// Look right for better candidate.
			return findPile(i, piles, midpoint + 1, end);
		}
	}
}
