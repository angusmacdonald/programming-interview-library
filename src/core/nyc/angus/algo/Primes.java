package nyc.angus.algo;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Utilities for generating prime numbers.
 */
public class Primes {

	/**
	 * Creates a prime sieve to find all prime numbers below n.
	 */
	public static Set<Integer> getSetOfAllPrimesBelowN(final int n) {
		return convertToStream(createSieve(n)).collect(Collectors.toSet());
	}

	/**
	 * Creates a prime sieve to find all prime numbers below n.
	 */
	public static List<Integer> getListOfAllPrimesBelowN(final int n) {
		return convertToStream(createSieve(n)).collect(Collectors.toList());
	}

	/**
	 * Create a prime sieve for all numbers from 1-n inclusive.
	 */
	private static boolean[] createSieve(final int n) {
		final boolean[] primes = new boolean[n + 1];

		// Set all potential prime elements to true:
		for (int i = 2; i < primes.length; i++) {
			primes[i] = true;
		}

		// Eliminate composite numbers:
		for (int i = 2; i * i <= n; i++) {
			if (primes[i]) {
				for (int j = i; i * j <= n; j++) {
					primes[i * j] = false;
				}
			}
		}

		return primes;
	}

	private static Stream<Integer> convertToStream(final boolean[] primes) {
		return IntStream.range(2, primes.length - 1).filter(i -> primes[i]).boxed();
	}

	/**
	 * Check if a given number is prime.
	 */
	public static boolean isPrime(final long n) {
		if (n % 2 == 0) {
			return n == 2;
		}
		if (n % 3 == 0) {
			return n == 3;
		}

		int step = 4; // 6k +- 1, to remove numbers divisible by 2 and 3, alternate between jumping 4 and 2.
		for (int i = 5; i < Math.sqrt(n) + 1; step = 6 - step, i += step) {

			if (n % i == 0) {
				return false;
			}
		}

		return true;
	}
}
