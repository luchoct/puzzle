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
public class BritishOneDigitEnumTest {
  @Test
  public void testGetBritishRepresentationFromOne() {
    assertEquals("one", BritishOneDigitEnum.ONE.getBritishRepresentation());
  }

  @Test
  public void testValueOfProperOneDigitReturnsEnum() {
    assertEquals(BritishOneDigitEnum.ONE, BritishOneDigitEnum.valueOfOneDigit(BritishOneDigitEnum.ONE.getOneDigit()));
  }

  @Test(expected = IllegalArgumentException.class)
  public void testValueOfUnproperOneDigitThrowsException() {
    BritishOneDigitEnum.valueOfOneDigit('a');
  }
}
