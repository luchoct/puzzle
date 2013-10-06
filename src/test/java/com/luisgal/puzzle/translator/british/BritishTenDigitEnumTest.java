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
public class BritishTenDigitEnumTest {

  @Test
  public void testGetBritishRepresentationFromTwenty() {
    assertEquals("twenty", BritishTenDigitEnum.TWENTY.getBritishRepresentation());
  }

  @Test
  public void testValueOfProperTenDigitReturnsEnum() {
    assertEquals(BritishTenDigitEnum.TWENTY,
        BritishTenDigitEnum.valueOfTenDigit(BritishTenDigitEnum.TWENTY.getTenDigit()));
  }

  @Test(expected = IllegalArgumentException.class)
  public void testValueOfUnproperTenDigitThrowsException() {
    BritishTenDigitEnum.valueOfTenDigit('a');
  }
}
