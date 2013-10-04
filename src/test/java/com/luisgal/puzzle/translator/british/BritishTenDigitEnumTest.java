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
  public void testGetBritishRepresentation() {
    assertEquals("twenty", BritishTenDigitEnum.TWENTY.getBritishRepresentation());
  }

  @Test
  public void testValueOfProperTenDigit() {
    assertEquals(BritishTenDigitEnum.TWENTY,
        BritishTenDigitEnum.valueOfTenDigit(BritishTenDigitEnum.TWENTY.getTenDigit()));
  }

  @Test(expected = IllegalArgumentException.class)
  public void testValueOfUnproperTenDigit() {
    BritishTenDigitEnum.valueOfTenDigit('a');
  }
}
