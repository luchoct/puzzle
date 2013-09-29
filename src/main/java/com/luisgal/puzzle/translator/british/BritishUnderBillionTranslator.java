/**
 * 
 */
package com.luisgal.puzzle.translator.british;

import com.luisgal.puzzle.translator.IntegerLanguageTranslator;

/**
 * It translates integers between minus one billion and one billion, both
 * exclusive into British English.
 * @author Luis
 * 
 */
public final class BritishUnderBillionTranslator implements IntegerLanguageTranslator {

  /**
   * Singleton Holder
   * @author Luis
   */
  static final class BritishUnderBillionTranslatorHolder {
    private static final BritishUnderBillionTranslator INSTANCE = new BritishUnderBillionTranslator();

    private BritishUnderBillionTranslatorHolder() {
    };
  }

  private BritishUnderBillionTranslator() {
  }

  /**
   * It returns an instance of the class.
   * @return The instance.
   */
  public static BritishUnderBillionTranslator getInstance() {
    return BritishUnderBillionTranslatorHolder.INSTANCE;
  }

  /**
   * @see com.luisgal.puzzle.translator.IntegerLanguageTranslator#
   *      getNegativePrefixTranslation()
   */
  @Override
  public String getNegativePrefixTranslation() {
    return "minus";
  }

  /**
   * It returns the translation of the given number into British English.
   * @param value The number to translate. It must have been validated.
   * @return The translation into British English.
   * 
   * @see com.luisgal.puzzle.translator.IntegerLanguageTranslator#getWordTranslation
   *      (int)
   */
  @Override
  public String translate(final String value) {
    // TODO Auto-generated method stub
    return null;
  }

  /**
   * It validates that the value is an integer, without grouping characters,
   * from minus one billion to one billion, both exclusive.
   * @see com.luisgal.puzzle.translator.IntegerLanguageTranslator#validateValue(int)
   */
  @Override
  public void validateValue(final String value) {
    // TODO Auto-generated method stub
  }
}
