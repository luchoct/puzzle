/**
 * 
 */
package com.luisgal.puzzle.translator;

import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.doCallRealMethod;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

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
    public String translatePartially(String translationOfPrefix, String part) {
      throw new UnsupportedOperationException("Method not supported");
    }
  };

  private TestAbstractIntegerLanguageTranslator translator = new TestAbstractIntegerLanguageTranslator();

  @Test
  public void testTranslateValueInvokesTranslateParciallyWithEmptyPrefix() {

    final AbstractIntegerLanguageTranslator mockTranslator = mock(TestAbstractIntegerLanguageTranslator.class);
    final String valueToTranslate = "aValue";

    doCallRealMethod().when(mockTranslator).translate(eq(valueToTranslate));

    mockTranslator.translate(valueToTranslate);

    verify(mockTranslator).translatePartially(eq(""), eq(valueToTranslate));
  }

  @Test(expected = IllegalArgumentException.class)
  public void testValidateValueWhichIsNotAnInteger() {
    translator.validateValue("hello");
  }

  @Test(expected = IllegalArgumentException.class)
  public void testValidateValueWhichIsSmallerThanMinimumValue() {
    translator.validateValue("-10");
  }

  @Test(expected = IllegalArgumentException.class)
  public void testValidateValueWhichIsGreaterThanMaximumValue() {
    translator.validateValue("10");
  }

  @Test
  public void testValidateValueAllowedValue() {
    translator.validateValue("-9");
    translator.validateValue("-2");
    translator.validateValue("0");
    translator.validateValue("5");
    translator.validateValue("9");
  }

}
