/**
 * 
 */
package com.luisgal.puzzle.translator.british;

import com.luisgal.puzzle.translator.AbstractIntegerLanguageTranslator;
import com.luisgal.puzzle.util.StringBuilderUtilities;

/**
 * It translates nine digits positive integers into British English.
 * @author Luis
 * 
 */
public class BritishNineDigitsTranslator extends AbstractIntegerLanguageTranslator {

  private BritishThreeDigitsTranslator threeDigitsTranslator = new BritishThreeDigitsTranslator();

  /**
   * It creates a new instance by specifying the three digits British translator
   * to use.
   * @param aThreeDigitsTranslator the three digits British translator to use.
   */
  public BritishNineDigitsTranslator(final BritishThreeDigitsTranslator aThreeDigitsTranslator) {
    super(0, 999999999);
    threeDigitsTranslator = aThreeDigitsTranslator;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public String translate(final String value) {

    final String fixedLengthValue = "000000000".substring(0, 9 - value.length()).concat(value);

    final StringBuilder translatedValue = new StringBuilder(120);
    for (int i = 0; i < 3; i++) {
      final String currentPartToTranslate = fixedLengthValue.substring(i * 3, (i + 1) * 3);
      final String partialTranslation = threeDigitsTranslator.translate(currentPartToTranslate);

      if (!"000".equals(currentPartToTranslate)) {
        if (!translatedValue.toString().isEmpty() && currentPartToTranslate.startsWith("0")) {
          StringBuilderUtilities.appendWord(translatedValue, "and");
        }
        StringBuilderUtilities.appendWord(translatedValue, partialTranslation);
      }
      if (!"000".equals(currentPartToTranslate)) {
        if (i == 0) {
          StringBuilderUtilities.appendWord(translatedValue, "million");
        } else if (i == 1) {
          StringBuilderUtilities.appendWord(translatedValue, "thousand");
        }
      }
    }
    if (translatedValue.toString().isEmpty()) {
      StringBuilderUtilities.appendWord(translatedValue, BritishOneDigitEnum.ZERO.getBritishRepresentation());
    }
    return translatedValue.toString();
  }
}
