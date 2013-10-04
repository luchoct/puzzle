package com.luisgal.puzzle.translator.british;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class BritishFirstTenDigitEnumTest {

  @Test
  public void testGetBritishRepresentation() {
    assertEquals("thirteen", BritishFirstTenDigitEnum.THIRTEEN.getBritishRepresentation());
  }

  @Test
  public void testValueOfProperTenDigit() {
    assertEquals(BritishFirstTenDigitEnum.THIRTEEN,
        BritishFirstTenDigitEnum.valueOfOneDigit(BritishFirstTenDigitEnum.THIRTEEN.getOneDigit()));
  }

  @Test(expected = IllegalArgumentException.class)
  public void testValueOfUnproperTenDigit() {
    BritishFirstTenDigitEnum.valueOfOneDigit('a');
  }
}
