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
  public String translatePartially(String translationOfPrefix, String part) {

    final String fixedLengthValue = "000000000".substring(0, 9 - part.length()).concat(part);

    final StringBuilder currentTranslationOfPrefix = new StringBuilder(translationOfPrefix);
    final StringBuilder translatedValue = new StringBuilder(120);
    for (int i = 0; i < 3; i++) {
      final String currentPartToTranslate = fixedLengthValue.substring(i * 3, (i + 1) * 3);
      final String partialTranslation = threeDigitsTranslator.translatePartially(currentTranslationOfPrefix.toString(),
          currentPartToTranslate);
      if (!"zero".equals(partialTranslation) || (i == 2)) {
        // If we get "zero" and it´s not the last translation, we don't append
        // anything.
        StringBuilderUtilities.appendWord(translatedValue, partialTranslation);
        StringBuilderUtilities.appendWord(currentTranslationOfPrefix, partialTranslation);
        if (i == 0) {
          StringBuilderUtilities.appendWord(translatedValue, "million");
          StringBuilderUtilities.appendWord(currentTranslationOfPrefix, "million");
        } else if (i == 1) {
          StringBuilderUtilities.appendWord(translatedValue, "thousand");
          StringBuilderUtilities.appendWord(currentTranslationOfPrefix, "thousand");
        }
      }
    }
    return translatedValue.toString();
  }
}
