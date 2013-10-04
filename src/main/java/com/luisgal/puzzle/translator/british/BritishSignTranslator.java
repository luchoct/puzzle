/**
 * 
 */
package com.luisgal.puzzle.translator.british;

import com.luisgal.puzzle.translator.SignLanguageTranslator;

/**
 * @author Luis A translator that translates the sign into British
 * 
 */
public class BritishSignTranslator implements SignLanguageTranslator {

  /**
   * Singleton Holder
   * @author Luis
   */
  static final class BritishSignTranslatorHolder {
    private static final BritishSignTranslator INSTANCE = new BritishSignTranslator();

    private BritishSignTranslatorHolder() {
    };
  }

  private BritishSignTranslator() {
  }

  /**
   * It returns an instance of the class.
   * @return The instance.
   */
  public static BritishSignTranslator getInstance() {
    return BritishSignTranslatorHolder.INSTANCE;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public String translate(final String value) {
    if (value.startsWith("-")) {
      return "minus";
    } else {
      return "";
    }
  }
}
