/**
 * 
 */
package com.luisgal.puzzle.translator.british;

/**
 * It translates integers between minus one billion and one billion, both
 * exclusive into British English.
 * @author Luis
 * 
 */
public class BritishUnderBillionTranslator extends AbstractBritishLanguageTranslator {

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
    super(-999999999, 999999999);
  }

  /**
   * It returns an instance of the class.
   * @return The instance.
   */
  public static BritishUnderBillionTranslator getInstance() {
    return BritishUnderBillionTranslatorHolder.INSTANCE;
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
}
