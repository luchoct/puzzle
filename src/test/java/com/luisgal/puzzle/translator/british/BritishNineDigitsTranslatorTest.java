package com.luisgal.puzzle.translator.british;

import static org.junit.Assert.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verifyNoMoreInteractions;

import org.junit.Test;
import org.mockito.InOrder;

/**
 * Integration tests of BritishUnderBillionTranslator class
 * @author Luis
 * 
 */
public final class BritishNineDigitsTranslatorTest {

  @Test
  public void testTranslatePartially() {
    final String translationOfPrefix = "one billion";
    final BritishThreeDigitsTranslator mockThreeDigitsTranslator = mock(BritishThreeDigitsTranslator.class);
    final String partToTranslate = "56915781";

    final BritishNineDigitsTranslator mockedTranslator = new BritishNineDigitsTranslator(mockThreeDigitsTranslator);
    given(mockThreeDigitsTranslator.translatePartially(eq(translationOfPrefix), eq("056"))).willReturn("and fifty six");
    given(mockThreeDigitsTranslator.translatePartially(eq("one billion and fifty six million"), eq("915"))).willReturn(
        "nine hundred and fifteen");
    given(
        mockThreeDigitsTranslator.translatePartially(
            eq("one billion and fifty six million nine hundred and fifteen thousand"), eq("781"))).willReturn(
        "seven hundred and eighty one");

    final String translation = mockedTranslator.translatePartially(translationOfPrefix, partToTranslate);

    final InOrder order = inOrder(mockThreeDigitsTranslator);
    order.verify(mockThreeDigitsTranslator).translatePartially(eq(translationOfPrefix), eq("056"));
    order.verify(mockThreeDigitsTranslator).translatePartially(eq("one billion and fifty six million"), eq("915"));
    order.verify(mockThreeDigitsTranslator).translatePartially(
        eq("one billion and fifty six million nine hundred and fifteen thousand"), eq("781"));

    verifyNoMoreInteractions(mockThreeDigitsTranslator);

    assertEquals("and fifty six million nine hundred and fifteen thousand seven hundred and eighty one", translation);
  }

  private final BritishNineDigitsTranslator translator = new BritishNineDigitsTranslator(
      new BritishThreeDigitsTranslator());

  @Test
  public void testTranslateValue10123() {
    assertEquals("ten thousand one hundred and twenty three", translator.translate("10123"));
  }

  @Test
  public void testTranslateValue56945781() {
    assertEquals("fifty six million nine hundred and forty five thousand seven hundred and eighty one",
        translator.translate("56945781"));
  }

  @Test
  public void testTranslateValue999999999() {
    assertEquals(
        "nine hundred and ninety nine million nine hundred and ninety nine thousand nine hundred and ninety nine",
        translator.translate("999999999"));
  }

  @Test
  public void testTranslateValue10001() {
    assertEquals("ten thousand and one", translator.translate("10001"));
  }
}
