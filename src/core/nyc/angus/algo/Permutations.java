package nyc.angus.algo;

import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.Predicate;

/**
 * Utility for getting permutations of a given string.
 */
public class Permutations {

	/**
	 * Get all permutations of the string that match the given predicate.
	 */
	public static Set<String> getPermutationsMatchingPredicate(final String str, final Predicate<String> addTest) {
		if (str == null || str.length() == 0) {
			return Collections.emptySet();
		}

		final Set<String> results = new TreeSet<>();
		getPermutations("", str, results, addTest);
		return results;
	}

	/**
	 * Get all permutations of the string.
	 */
	public static Set<String> getAllPermutations(final String str) {
		return getPermutationsMatchingPredicate(str, s -> true);
	}

	private static void getPermutations(final String prefix, final String current, final Set<String> results,
			final Predicate<String> addTest) {
		if (current.length() == 0) {
			if (addTest.test(prefix)) {
				results.add(prefix);
			}
			return;
		}

		for (int i = 0; i < current.length(); i++) {
			getPermutations(prefix + current.charAt(i), removeCurrentChar(current, i), results, addTest);
		}
	}

	private static String removeCurrentChar(final String current, final int i) {
		return current.substring(0, i) + current.substring(i + 1);
	}
}
