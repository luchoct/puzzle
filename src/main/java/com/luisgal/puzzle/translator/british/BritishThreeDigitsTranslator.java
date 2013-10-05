/**
 * 
 */
package com.luisgal.puzzle.translator.british;

import com.luisgal.puzzle.translator.AbstractIntegerLanguageTranslator;
import com.luisgal.puzzle.util.StringBuilderUtilities;

/**
 * It translates three digits positive integers into British English.
 * @author Luis
 * 
 */
public class BritishThreeDigitsTranslator extends AbstractIntegerLanguageTranslator {

  public BritishThreeDigitsTranslator() {
    super(0, 999);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public String translate(final String value) {

    final StringBuilder translatedValue = new StringBuilder(40);

    final String fixedLengthValue = "000".substring(0, 3 - value.length()).concat(value);
    final char hundreds = fixedLengthValue.charAt(0);
    final char tens = fixedLengthValue.charAt(1);
    final char ones = fixedLengthValue.charAt(2);
    StringBuilderUtilities.appendWord(translatedValue, translateHundredsDigit(hundreds));
    appendAndWord(translatedValue, hundreds, tens, ones);
    if (tens != '0') {
      StringBuilderUtilities.appendWord(translatedValue, translateTensAndOnes(tens, ones));
    } else if (ones != '0') {
      StringBuilderUtilities.appendWord(translatedValue, BritishOneDigitEnum.valueOfOneDigit(ones)
          .getBritishRepresentation());
    }
    if (translatedValue.toString().isEmpty()) {
      StringBuilderUtilities.appendWord(translatedValue, BritishOneDigitEnum.ZERO.getBritishRepresentation());
    }
    return translatedValue.toString();
  }

  /**
   * It appends the 'and' word to the given builder if the British
   * representation should contain the word.
   * @param builder The builder where the 'and' word should be appended.
   * @param translationOfPrefix The translation of the prefix
   * @param hundreds The digit that represents the hundreds.
   * @param tens The digit that represents the tens.
   * @param ones The digit that represents the ones.
   */
  void appendAndWord(final StringBuilder builder, final char hundreds, final char tens, final char ones) {

    if ((hundreds != '0') && ((tens != '0') || (ones != '0'))) {
      // We append and when hundred digit will be translated, and in addition,
      // at least tens or ones digit will be translated.
      StringBuilderUtilities.appendWord(builder, "and");
    }
  }

  /**
   * It translate the hundreds digit
   * @param hundredsDigit The hundreds digit.
   * @return The British translation.
   */
  String translateHundredsDigit(final char hundredsDigit) {
    final StringBuilder translatedValue = new StringBuilder(40);
    if (hundredsDigit != '0') {
      StringBuilderUtilities.appendWord(translatedValue, BritishOneDigitEnum.valueOfOneDigit(hundredsDigit)
          .getBritishRepresentation());
      StringBuilderUtilities.appendWord(translatedValue, "hundred");
    }
    return translatedValue.toString();
  }

  /**
   * It returns the translation for the combination between the tens digit and
   * the ones digit.
   * @param tensDigit The tens digit.
   * @param onesDigit The ones digit.
   * @return The British translation.
   */
  String translateTensAndOnes(final char tensDigit, final char onesDigit) {
    final StringBuilder translatedValue = new StringBuilder(40);
    if ((tensDigit == '0') && (onesDigit == '0')) {
      StringBuilderUtilities.appendWord(translatedValue, BritishOneDigitEnum.ZERO.getBritishRepresentation());
    } else if (tensDigit == '1') {
      StringBuilderUtilities.appendWord(translatedValue, BritishFirstTenDigitEnum.valueOfOneDigit(onesDigit)
          .getBritishRepresentation());
    } else {
      if (tensDigit != '0') {
        StringBuilderUtilities.appendWord(translatedValue, BritishTenDigitEnum.valueOfTenDigit(tensDigit)
            .getBritishRepresentation());
      }
      if (onesDigit != '0') {
        StringBuilderUtilities.appendWord(translatedValue, BritishOneDigitEnum.valueOfOneDigit(onesDigit)
            .getBritishRepresentation());
      }
    }
    return translatedValue.toString();
  }

}
