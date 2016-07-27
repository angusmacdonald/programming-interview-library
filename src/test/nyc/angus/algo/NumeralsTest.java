package nyc.angus.algo;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Tests of {@link Numerals}.
 */
public class NumeralsTest {

	@Test
	public void validateTest() {
		assertEquals("V", Numerals.validateRomanNumeral("IIIII"));
	}

	@Test
	public void integerToRoman() {
		assertEquals("V", Numerals.integerToRomanNumeral(5));
		assertEquals("MMXVII", Numerals.integerToRomanNumeral(2017));
		assertEquals("MDCCCLXXXVIII", Numerals.integerToRomanNumeral(1888));
		assertEquals("MMDCCCLXXXVIII", Numerals.integerToRomanNumeral(2888));
	}

	@Test
	public void romanToInteger() {
		assertEquals(5, Numerals.romanNumeralToInteger("V"));
		assertEquals(6, Numerals.romanNumeralToInteger("VI"));
		assertEquals(2017, Numerals.romanNumeralToInteger("MMXVII"));
		assertEquals(1888, Numerals.romanNumeralToInteger("MDCCCLXXXVIII"));
		assertEquals(2888, Numerals.romanNumeralToInteger("MMDCCCLXXXVIII"));
	}
}
