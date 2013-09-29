/**
 * 
 */
package com.luisgal.puzzle.translator;

/**
 * It translates an integer into a word translation in one specific language.
 * @author Luis
 * 
 */
public interface IntegerLanguageTranslator {

  /**
   * It returns the translation of the negative prefix.
   * @return The translation of the negative prefix.
   */
  String getNegativePrefixTranslation();

  /**
   * It returns the translation of the given value.
   * @param value The value to translate.
   * @return The translation.
   */
  String translate(String value);

  /**
   * It validates the value which will be translated.
   * @param value The value to validate.
   * @throws IllegalArgumentException In case of failure on validation.
   */
  void validateValue(String value) throws IllegalArgumentException;
}
