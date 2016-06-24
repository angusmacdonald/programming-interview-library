package nyc.angus.algo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.math.BigInteger;
import java.util.List;
import java.util.Set;

import org.junit.Test;

/**
 * Tests of {@link Primes}.
 */
public class PrimesTest {

	@Test
	public void testForSmallPrimes() {
		final Set<Integer> result = Primes.getSetOfAllPrimesBelowN(20);

		final int[] primes = { 2, 3, 5, 7, 11, 13, 17, 19 };

		for (final int p : primes) {
			assertTrue(result.contains(p));
		}

		assertEquals(primes.length, result.size());
	}

	@Test
	public void testListAndSetMatch() {
		final Set<Integer> set = Primes.getSetOfAllPrimesBelowN(1000);
		final List<Integer> list = Primes.getListOfAllPrimesBelowN(1000);

		assertTrue(set.containsAll(list));
		assertTrue(list.containsAll(set));
	}

	@Test
	public void testLargerAccuracy() {
		final List<Integer> list = Primes.getListOfAllPrimesBelowN(100000);
		assertEquals(0L, list.stream().filter(i -> !BigInteger.valueOf(i).isProbablePrime(50)).count());
	}

}
