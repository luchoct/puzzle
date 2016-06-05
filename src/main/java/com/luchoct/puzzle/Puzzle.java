/**
 *
 */
package com.luchoct.puzzle;

import com.luchoct.puzzle.translator.SignLanguageTranslator;
import com.luchoct.puzzle.translator.british.BritishNineDigitsTranslator;
import com.luchoct.puzzle.translator.IntegerLanguageTranslator;
import com.luchoct.puzzle.translator.british.BritishSignTranslator;
import com.luchoct.puzzle.translator.british.BritishThreeDigitsTranslator;
import com.luchoct.puzzle.util.StringBuilderUtilities;

/**
 * This class is the Command Line Interface of Puzzle One. It translates the
 * first argument into the British words translation.
 *
 * @author Luis.
 */
public class Puzzle {

	private final SignLanguageTranslator signTranslator;
	private final IntegerLanguageTranslator integerTranslator;

	/**
	 * It creates a new instance that will use the given language translator.
	 *
	 * @param aSignTranslator     The translator to use to translate the sign.
	 * @param anIntegerTranslator The translator to use to translate the integer.
	 */
	public Puzzle(final SignLanguageTranslator aSignTranslator, final IntegerLanguageTranslator anIntegerTranslator) {
		signTranslator = aSignTranslator;
		integerTranslator = anIntegerTranslator;
	}

	/**
	 * It translate the given value.
	 *
	 * @param value The value to translate.
	 * @return The translation.
	 * @throws IllegalArgumentException In case the
	 */
	public String translate(final String value) {

		String absoluteValue = getAbsoluteValue(value);
		integerTranslator.validateValue(absoluteValue);

		final StringBuilder translation = new StringBuilder(signTranslator.translate(value));
		StringBuilderUtilities.appendWord(translation, integerTranslator.translate(absoluteValue));
		return translation.toString();
	}

	/**
	 * It returns the absolute of an integer value.
	 *
	 * @param value A string with an integer value.
	 * @return The absolute value.
	 */
	String getAbsoluteValue(final String value) {
		if (value.startsWith("-")) {
			return value.substring(1);
		} else {
			return value;
		}
	}

	/**
	 * It translates the first argument into the British words translation.
	 *
	 * @param args The argument must satisfy the validation of the translator.
	 * @see BritishNineDigitsTranslator
	 */
	public static void main(final String[] args) {
		if (args.length != 1) {
			System.err.println("Expected one argument. Input the integer to translate.");
		} else {
			final BritishNineDigitsTranslator integerTranslator = new BritishNineDigitsTranslator(
					new BritishThreeDigitsTranslator());
			final SignLanguageTranslator signTranslator = BritishSignTranslator.getInstance();
			final Puzzle puzzle = new Puzzle(signTranslator, integerTranslator);
			try {
				String valueWithoutCommas = args[0].replaceAll(",", "");
				// I've removed the commas outside the Puzzle class or
				// LanguageTranslators as it's not clearly defined in requirements
				// whether the argument could contain miles separators or not.
				// As it's not clear, I've not implemented it inside BritishTranslators

				System.out.println(puzzle.translate(valueWithoutCommas));
			} catch (IllegalArgumentException e) {
				System.err.println(e.getMessage());
			}
		}
	}
}
