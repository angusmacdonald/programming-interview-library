package nyc.angus.algo;

public class Sorting {

	/**
	 * Counting sort of the given <tt>items</tt> with indices based on <tt>indices</tt>.
	 */
	public static String[] countingSort(final int[] indices, final String[] items) {
		// Count occurrences
		final int[] occurrences = new int[100];

		for (int i = 0; i < indices.length; i++) {
			occurrences[indices[i]]++;
		}

		// Tally numbers before current entry.
		for (int i = 1; i < occurrences.length; i++) {
			occurrences[i] += occurrences[i - 1];
		}

		final String[] sortedResult = new String[indices.length];

		for (int i = sortedResult.length - 1; i >= sortedResult.length / 2; i--) {
			final int p = indices[i];
			final int outputPos = occurrences[p] - 1;

			sortedResult[outputPos] = items[i];

			occurrences[p]--;
		}

		return sortedResult;
	}

	/**
	 * In-place quicksort of the given array.
	 */
	public static void quickSort(final int[] arr) {
		if (arr.length <= 1) {
			return;
		}

		quickSort(arr, 0, arr.length - 1);
	}

	private static void quickSort(final int[] arr, final int start, final int end) {
		if (start >= end || end - start == 1) {
			return;
		}

		final int pivot = arr[end];

		int forward = start;
		int back = end - 1;

		while (forward <= back) {
			// Loop until a value in the wrong position is found:
			while (arr[forward] < pivot) {
				forward++;
			}

			while (arr[back] > pivot) {
				back--;
			}

			if (forward <= back) {
				swap(arr, forward, back);
				forward++;
				back--;
			}
		}

		swap(arr, back + 1, end); // move pivot to middle.

		if (start < back) {
			quickSort(arr, start, back);
		}

		if (end > forward) {
			quickSort(arr, forward, end);
		}

	}

	private static void swap(final int[] arr, final int forward, final int back) {
		final int temp = arr[forward];
		arr[forward] = arr[back];
		arr[back] = temp;
	}
}
