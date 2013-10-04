package com.luisgal.puzzle;

import static org.junit.Assert.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.anyString;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.Test;

import com.luisgal.puzzle.translator.IntegerLanguageTranslator;
import com.luisgal.puzzle.translator.SignLanguageTranslator;
import com.luisgal.puzzle.translator.british.BritishNineDigitsTranslator;
import com.luisgal.puzzle.translator.british.BritishSignTranslator;
import com.luisgal.puzzle.translator.british.BritishThreeDigitsTranslator;

public final class PuzzleTest {

  @Test(expected = IllegalArgumentException.class)
  public void testTranslateDoesNotTranslateOnRetrievingValidationErrors() {
    final IntegerLanguageTranslator integerTranslator = mock(BritishNineDigitsTranslator.class);
    final SignLanguageTranslator signTranslator = mock(BritishSignTranslator.class);
    final Puzzle mockedPuzzle = new Puzzle(signTranslator, integerTranslator);

    doThrow(IllegalArgumentException.class).when(integerTranslator).validateValue(anyString());

    mockedPuzzle.translate("test");
  }

  @Test
  public void testTranslateWithoutValidationError() {
    final IntegerLanguageTranslator integerTranslator = mock(BritishNineDigitsTranslator.class);
    final SignLanguageTranslator signTranslator = mock(BritishSignTranslator.class);
    final Puzzle mockedPuzzle = new Puzzle(signTranslator, integerTranslator);

    final String inputValue = "-123";
    final String absoluteValue = mockedPuzzle.getAbsoluteValue(inputValue);

    doNothing().when(integerTranslator).validateValue(anyString());
    given(signTranslator.translate(eq(inputValue))).willReturn("a sign");
    given(integerTranslator.translate(eq(absoluteValue))).willReturn("a translation");

    final String translation = mockedPuzzle.translate(inputValue);

    verify(integerTranslator).validateValue(eq(inputValue));
    verify(integerTranslator).translate(eq(absoluteValue));

    assertEquals("a sign a translation", translation);
  }

  private Puzzle puzzle = new Puzzle(BritishSignTranslator.getInstance(), new BritishNineDigitsTranslator(
      new BritishThreeDigitsTranslator()));

  @Test
  public void testGetAbsoluteValueWithNegativeNumber() {
    assertEquals("8", puzzle.getAbsoluteValue("-8"));
  }

  @Test
  public void testGetAbsoluteValueWithPositiveNumber() {
    assertEquals("33", puzzle.getAbsoluteValue("33"));
  }

  @Test
  public void testGetAbsoluteValueWithZero() {
    assertEquals("0", puzzle.getAbsoluteValue("0"));
  }
}
