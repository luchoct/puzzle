package com.luchoct.puzzle.util;

public final class StringBuilderUtilities {

	protected static final String SPACE = " ";

	private StringBuilderUtilities() {
	}

	/**
	 * It appends a word to the given builder, adding a space if needed.
	 *
	 * @param builder The builder to modify.
	 * @param word    The word to add.
	 */
	public static void appendWord(final StringBuilder builder, final String word) {
		if (builder.length() > 0) {
			builder.append(StringBuilderUtilities.SPACE);
		}
		builder.append(word);
	}

}
