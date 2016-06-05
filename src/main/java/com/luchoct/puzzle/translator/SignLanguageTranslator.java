package com.luchoct.puzzle.translator;

public interface SignLanguageTranslator {

	/**
	 * It translates the sign of the given value.
	 *
	 * @param value The value to check.
	 * @return the British translation of the sign or empty string if there is not
	 * translation.
	 */
	String translate(final String value);
}
