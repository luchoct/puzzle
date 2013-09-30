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
public class OneEnumTest {
  @Test
  public void testToString() {
    assertEquals("one", OneEnum.ONE.toString());
  }

  @Test
  public void testValueOfProperIntegerRepresentation() {
    assertEquals(OneEnum.ONE, OneEnum.valueOfIntegerRepresentation(OneEnum.ONE.getIntegerRepresentation()));
  }

  @Test(expected = IllegalArgumentException.class)
  public void testValueOfUnproperIntegerRepresentation() {
    OneEnum.valueOfIntegerRepresentation("fakeValue");
  }
}
