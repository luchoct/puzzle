package com.luisgal.puzzle.translator.british;

import com.luisgal.puzzle.translator.AbstractIntegerLanguageTranslator;

public abstract class AbstractBritishLanguageTranslator extends AbstractIntegerLanguageTranslator {

  public AbstractBritishLanguageTranslator(int minimumValue, int maximumValue) {
    super(minimumValue, maximumValue);
  }

  /**
   * @see com.luisgal.puzzle.translator.IntegerLanguageTranslator#
   *      getNegativePrefixTranslation()
   */
  @Override
  public String getNegativePrefixTranslation() {
    return "minus";
  }

}
