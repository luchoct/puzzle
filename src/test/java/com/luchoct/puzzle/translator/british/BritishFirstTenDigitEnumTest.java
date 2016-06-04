package com.luchoct.puzzle.translator.british;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class BritishFirstTenDigitEnumTest {

  @Test
  public void testGetBritishRepresentationFromThirteen() {
    assertEquals("thirteen", BritishFirstTenDigitEnum.THIRTEEN.getBritishRepresentation());
  }

  @Test
  public void testValueOfProperTenDigitRetunsEnum() {
    assertEquals(BritishFirstTenDigitEnum.THIRTEEN,
        BritishFirstTenDigitEnum.valueOfOneDigit(BritishFirstTenDigitEnum.THIRTEEN.getOneDigit()));
  }

  @Test(expected = IllegalArgumentException.class)
  public void testValueOfUnproperTenDigitThrowsException() {
    BritishFirstTenDigitEnum.valueOfOneDigit('a');
  }
}
