package com.luisgal.puzzle.translator.british;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class AbstractBritishLanguageTranslatorTest {

  private final String testPrefix = "testPrefix";

  /**
   * Translator that mocks all methods and returns the testPrefix variable as
   * negative prefix translation.
   * @author Luis
   * 
   */
  private class TestAbstractBritishLanguageTranslator extends AbstractBritishLanguageTranslator {

    public TestAbstractBritishLanguageTranslator() {
      super(-9, 9);
    }

    @Override
    public String getNegativePrefixTranslation() {
      return testPrefix;
    }

    @Override
    public String translate(String value) {
      throw new UnsupportedOperationException("Method not supported");
    }

  };

  @Test
  public void testNegativePrefixTranslation() {
    final TestAbstractBritishLanguageTranslator translator = new TestAbstractBritishLanguageTranslator();
    assertEquals(testPrefix, translator.getNegativePrefixTranslation());
  }
}
