/**
 *
 */
package com.luchoct.puzzle.translator.british;

/**
 * Enum with the British representations of the one digits.
 *
 * @author Luis
 */
public enum BritishOneDigitEnum {
	ZERO('0'), ONE('1'), TWO('2'), THREE('3'), FOUR('4'), FIVE('5'), SIX('6'), SEVEN('7'), EIGHT('8'), NINE('9');

	private final char oneDigit;

	private BritishOneDigitEnum(final char anOneDigit) {
		oneDigit = anOneDigit;
	}

	/**
	 * It returns the enumeration which represent the given one digit.
	 *
	 * @param anOneDigit The one digit to match.
	 * @return The enumeration that matches the given digit.
	 * @throws IllegalArgumentException The exception when the digit doesn't match
	 *                                  any OneEnum.
	 */
	public static BritishOneDigitEnum valueOfOneDigit(final char anOneDigit) {
		for (final BritishOneDigitEnum currentOneEnum : BritishOneDigitEnum.values()) {
			if (currentOneEnum.getOneDigit() == anOneDigit) {
				return currentOneEnum;
			}
		}
		throw new IllegalArgumentException("No BritishOneDigitEnum matches the given one digit");
	}

	public char getOneDigit() {
		return oneDigit;
	}

	public String getBritishRepresentation() {
		return toString().toLowerCase();
	}
}
