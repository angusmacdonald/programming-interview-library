package nyc.angus.algo;

import java.util.Arrays;

public class Intervals {

	/**
	 * Find the maximum number of intervals that can co-exist such that no three intervals overlap.
	 */
	public static int findMaxSet(final Interval[] intervals) {

		if (intervals.length < 3) {
			return intervals.length;
		}

		Arrays.sort(intervals);

		Interval prev2 = intervals[0];
		Interval prev = intervals[1];

		int count = 2;
		int doublePos = -1;

		if (prev2.end >= prev.start) {
			doublePos = prev2.end;
		}

		for (int i = 2; i < intervals.length; i++) {
			final Interval now = intervals[i];

			if (now.start > doublePos) {
				count++;

				prev2 = prev;
				prev = now;

				if (prev2.end >= prev.start) {
					doublePos = prev2.end;
				}
			}
		}

		return count;
	}

	public static class Interval implements Comparable<Interval> {
		int start;
		int end;

		public Interval(final int start, final int end) {
			this.start = start;
			this.end = end;
		}

		@Override
		public int compareTo(final Interval that) {
			if (this.end != that.end) {
				return this.end - that.end;
			} else {
				return this.start - that.start;
			}
		}
	}
}
