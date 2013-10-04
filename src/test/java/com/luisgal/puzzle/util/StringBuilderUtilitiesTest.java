package com.luisgal.puzzle.util;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class StringBuilderUtilitiesTest {

  @Test
  public void testAppendAWordToEmptyBuilder() {
    final StringBuilder builder = new StringBuilder(5);
    final String word = "word";
    StringBuilderUtilities.appendWord(builder, word);
    assertEquals(word, builder.toString());
  }

  @Test
  public void testAppendAWordToUsedBuilder() {
    final StringBuilder builder = new StringBuilder("a");
    final String word = "word";
    StringBuilderUtilities.appendWord(builder, word);
    assertEquals("a word", builder.toString());
  }
}
