/**
 * 
 */
package com.luisgal.puzzle.translator;

/**
 * It translates an integer into a word translation in one specific language. It
 * also translates a part of a bigger integer.
 * @author Luis
 * 
 */
public interface IntegerLanguageTranslator {

  /**
   * It returns the translation of the given value.
   * @param value The value to translate.
   * @return The translation.
   */
  String translate(String value);

  /**
   * It returns the translation of a part of a bigger number.
   * @param translationOfPrefix The translation of the prefix
   * @param part The part of the value to translate.
   * @return The translation of the given part.
   */
  String translatePartially(String translationOfPrefix, String part);

  /**
   * It validates the value which will be translated.
   * @param value The value to validate.
   * @throws IllegalArgumentException In case of failure on validation.
   */
  void validateValue(String value);
}
