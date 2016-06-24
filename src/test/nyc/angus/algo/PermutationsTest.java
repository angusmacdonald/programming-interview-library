package nyc.angus.algo;

import static org.junit.Assert.assertTrue;

import java.util.Set;

import org.junit.Test;

/**
 * Tests of {@link Permutations}.
 */
public class PermutationsTest {

	@Test
	public void nullPerm() {
		assertTrue(Permutations.getAllPermutations(null).isEmpty());
	}

	@Test
	public void nonNullPerm() {
		assertTrue(Permutations.getAllPermutations("ab").size() == 2);
	}

	@Test
	public void matching() {
		final Set<String> matches = Permutations.getPermutationsMatchingPredicate("ab", s -> s.equals("ba"));
		assertTrue(matches.size() == 1);
	}
}
