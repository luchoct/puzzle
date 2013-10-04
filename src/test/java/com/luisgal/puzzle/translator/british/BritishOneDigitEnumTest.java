/**
 * 
 */
package com.luisgal.puzzle.translator.british;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * @author Luis
 * 
 */
public class BritishOneDigitEnumTest {
  @Test
  public void testGetBritishRepresentation() {
    assertEquals("one", BritishOneDigitEnum.ONE.getBritishRepresentation());
  }

  @Test
  public void testValueOfProperOneDigit() {
    assertEquals(BritishOneDigitEnum.ONE,
        BritishOneDigitEnum.valueOfOneDigit(BritishOneDigitEnum.ONE.getOneDigit()));
  }

  @Test(expected = IllegalArgumentException.class)
  public void testValueOfUnproperOneDigit() {
    BritishOneDigitEnum.valueOfOneDigit('a');
  }
}
