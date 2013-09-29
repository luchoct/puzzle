package com.luisgal.puzzle;

import static org.mockito.Matchers.anyString;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

import org.junit.Test;

import com.luisgal.puzzle.translator.IntegerLanguageTranslator;
import com.luisgal.puzzle.translator.british.BritishUnderBillionTranslator;

public class PuzzleCLITest {

  @Test
  public void testTranslateInvokesValidation() {
    final IntegerLanguageTranslator translator = mock(BritishUnderBillionTranslator.class);
    final PuzzleCLI puzzle = new PuzzleCLI(translator);

    final String inputValue = "test";
    puzzle.translate(inputValue);

    verify(translator).validateValue(eq(inputValue));
  }

  @Test(expected = IllegalArgumentException.class)
  public void testTranslateDoesNotTranslateOnRetrievingValidationErrors() {
    final IntegerLanguageTranslator translator = mock(BritishUnderBillionTranslator.class);
    final PuzzleCLI puzzle = new PuzzleCLI(translator);

    puzzle.translate("test");

    doThrow(IllegalArgumentException.class).when(translator).validateValue(anyString());
    verify(translator, never()).translate(anyString());
  }

  @Test(expected = IllegalArgumentException.class)
  public void testTranslateDoesTranslateOnNotRetrievingValidationErrors() {
    final IntegerLanguageTranslator translator = mock(BritishUnderBillionTranslator.class);
    final PuzzleCLI puzzle = new PuzzleCLI(translator);

    final String inputValue = "test";
    puzzle.translate(inputValue);

    doNothing().when(translator).validateValue(eq(inputValue));
    verify(translator).translate(eq(inputValue));
  }
}
