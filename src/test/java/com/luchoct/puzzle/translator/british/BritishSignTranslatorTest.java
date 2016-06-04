/**
 * 
 */
package com.luchoct.puzzle.translator.british;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * @author Luis
 * 
 */
public class BritishSignTranslatorTest {

  private final BritishSignTranslator translator = BritishSignTranslator.getInstance();

  @Test
  public void testTranslateNegativeValue() {
    assertEquals("minus", translator.translate("-123"));
  }

  @Test
  public void testTranslateMinusZeroValue() {
    assertEquals("minus", translator.translate("-0"));
  }

  @Test
  public void testTranslateZeroValue() {
    assertEquals("", translator.translate("0"));
  }

  @Test
  public void testTranslatePositiveValue() {
    assertEquals("", translator.translate("123"));
  }
}
