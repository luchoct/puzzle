/**
 * 
 */
package com.luchoct.puzzle.translator.british;

import com.luchoct.puzzle.translator.AbstractIntegerLanguageTranslator;
import com.luchoct.puzzle.util.StringBuilderUtilities;

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

      if (!"000".equals(currentPartToTranslate)) {
        final String partialTranslation = threeDigitsTranslator.translate(currentPartToTranslate);
        appendAndWord(translatedValue, translatedValue.toString(), currentPartToTranslate);
        StringBuilderUtilities.appendWord(translatedValue, partialTranslation);
        appendGroupSeparator(translatedValue, i);
      }
    }
    if (translatedValue.toString().isEmpty()) {
      StringBuilderUtilities.appendWord(translatedValue, BritishOneDigitEnum.ZERO.getBritishRepresentation());
    }
    return translatedValue.toString();
  }

  /**
   * It appends the 'and' word if needed.
   * @param builder The builder where the 'and' word will be appended.
   * @param previousTranslation The translation of the previous parts.
   * @param currentTranslatedPart The part that has been translated.
   */
  void appendAndWord(final StringBuilder builder, final String previousTranslation, final String currentTranslatedPart) {
    if (!previousTranslation.isEmpty() && currentTranslatedPart.startsWith("0")) {
      StringBuilderUtilities.appendWord(builder, "and");
    }
  }

  /**
   * It appends the translation of a group separator if needed.
   * @param builder The builder where the translation of the group separator
   *          will be appended.
   * @param lastIndex The index of the last translated part.
   */
  void appendGroupSeparator(final StringBuilder builder, int lastIndex) {
    if (lastIndex == 0) {
      StringBuilderUtilities.appendWord(builder, "million");
    } else if (lastIndex == 1) {
      StringBuilderUtilities.appendWord(builder, "thousand");
    }
  }
}
