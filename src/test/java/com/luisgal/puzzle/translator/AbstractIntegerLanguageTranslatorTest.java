/**
 * 
 */
package com.luisgal.puzzle.translator;

import org.junit.Test;

/**
 * @author Luis
 * 
 */
public class AbstractIntegerLanguageTranslatorTest {

  /**
   * Translator that mocks all methods, but the validation, and ensures the
   * value is between -9 and 9, both inclusive.
   * @author Luis
   * 
   */
  private class TestAbstractIntegerLanguageTranslator extends AbstractIntegerLanguageTranslator {

    public TestAbstractIntegerLanguageTranslator() {
      super(-9, 9);
    }

    @Override
    public String getNegativePrefixTranslation() {
      throw new UnsupportedOperationException("Method not supported");
    }

    @Override
    public String translate(String value) {
      throw new UnsupportedOperationException("Method not supported");
    }

  };

  private TestAbstractIntegerLanguageTranslator translator = new TestAbstractIntegerLanguageTranslator();

  @Test(expected = IllegalArgumentException.class)
  public void testValidateValueWhichIsNotAnInteger() {
    translator.validateValue("hello");
  }

  @Test(expected = IllegalArgumentException.class)
  public void testValidateValueWhichIsSmallerThanMinus9() {
    translator.validateValue("-10");
  }

  @Test(expected = IllegalArgumentException.class)
  public void testValidateValueWhichIsGreaterThan9() {
    translator.validateValue("10");
  }

  @Test
  public void testValidateValueBetweenMinus9And9() {
    translator.validateValue("-9");
    translator.validateValue("-2");
    translator.validateValue("0");
    translator.validateValue("5");
    translator.validateValue("9");
  }

}
