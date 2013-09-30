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
public class TenEnumTest {

  @Test
  public void testToString() {
    assertEquals("twenty", TenEnum.TWENTY.toString());
  }

  @Test
  public void testValueOfProperIntegerRepresentation() {
    assertEquals(TenEnum.TWENTY, TenEnum.valueOfIntegerRepresentation(TenEnum.TWENTY.getIntegerRepresentation()));
  }

  @Test(expected = IllegalArgumentException.class)
  public void testValueOfUnproperIntegerRepresentation() {
    TenEnum.valueOfIntegerRepresentation("fakeValue");
  }
}
