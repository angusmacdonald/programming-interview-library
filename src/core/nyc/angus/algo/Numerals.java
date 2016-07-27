package nyc.angus.algo;

import java.util.HashMap;
import java.util.Map;

/**
 * Utilities for converting number representations.
 */
public class Numerals {

	/**
	 * Convert a roman numeral to an integer.
	 */
	public static long romanNumeralToInteger(final String roman) {
		return romanNumeralToInteger(roman.toCharArray());
	}

	/**
	 * Convert an integer to a roman numeral.
	 */
	public static String integerToRomanNumeral(final long num) {
		final StringBuilder sb = new StringBuilder();

		integerToRomanNumeralInner(num, sb);

		return sb.toString();
	}

	/**
	 * Take a roman numeral and return it in a valid form.
	 * <p>
	 * There is only a single correct representation for every number, so (for example) IIIII is not a valid
	 * representation of 5, but V is. This method performs this correction.
	 */
	public static String validateRomanNumeral(final String roman) {
		return integerToRomanNumeral(romanNumeralToInteger(roman));
	}

	private static long romanNumeralToInteger(final char[] roman) {
		final Map<Character, Integer> values = getValues();

		final long prev = values.get(roman[0]);

		long sum = prev;

		for (int i = 1; i < roman.length; i++) {
			final int curr = values.get(roman[i]);

			if (curr > prev) {
				sum -= prev;
				sum += curr - prev;
			} else {
				sum += curr;
			}
		}

		return sum;
	}

	private static void integerToRomanNumeralInner(long num, final StringBuilder sb) {
		while (num > 0) {
			if (num >= 1000) {
				sb.append('M');
				num -= 1000;
			} else if (num >= 900) {
				sb.append("CM");
				num -= 900;
			} else if (num >= 500) {
				sb.append('D');
				num -= 500;
			} else if (num >= 400) {
				sb.append("CD");
				num -= 400;
			} else if (num >= 100) {
				sb.append('C');
				num -= 100;
			} else if (num >= 90) {
				sb.append("XC");
				num -= 90;
			} else if (num >= 50) {
				sb.append('L');
				num -= 50;
			} else if (num >= 40) {
				sb.append("XL");
				num -= 40;
			} else if (num >= 10) {
				sb.append('X');
				num -= 10;
			} else if (num >= 9) {
				sb.append("IX");
				num -= 9;
			} else if (num >= 5) {
				sb.append('V');
				num -= 5;
			} else if (num == 4) {
				sb.append("IV");
				num -= 4;
			} else if (num > 0) {
				sb.append('I');
				num -= 1;
			}
		}
	}

	private static Map<Character, Integer> getValues() {
		final Map<Character, Integer> values = new HashMap<>();
		values.put('I', 1);
		values.put('V', 5);
		values.put('X', 10);
		values.put('L', 50);
		values.put('C', 100);
		values.put('D', 500);
		values.put('M', 1000);

		return values;
	}
}
