/**
 * 
 */
package com.luisgal.puzzle.translator.british;

/**
 * It translates integers between minus one thousand and one thousand, both
 * exclusive into British English.
 * @author Luis
 * 
 */
public class BritishUnderThousandTranslator extends AbstractBritishLanguageTranslator {

  /**
   * Singleton Holder
   * @author Luis
   */
  static final class BritishUnderThousandTranslatorHolder {
    private static final BritishUnderThousandTranslator INSTANCE = new BritishUnderThousandTranslator();

    private BritishUnderThousandTranslatorHolder() {
    };
  }

  private BritishUnderThousandTranslator() {
    super(-999, 999);
  }

  /**
   * It returns an instance of the class.
   * @return The instance.
   */
  public static BritishUnderThousandTranslator getInstance() {
    return BritishUnderThousandTranslatorHolder.INSTANCE;
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
