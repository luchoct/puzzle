package com.luisgal.puzzle.util;


public class StringBuilderUtilities {

  protected static final String SPACE = " ";

  /**
   * It appends a word to the given builder, adding a space if needed.
   * @param builder The builder to modify.
   * @param word The word to add.
   */
  public static void appendWord(final StringBuilder builder, final String word) {
    if (builder.length() > 0) {
      builder.append(StringBuilderUtilities.SPACE);
    }
    builder.append(word);
  }

}
