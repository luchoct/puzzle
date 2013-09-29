/**
 * 
 */
package com.luisgal.puzzle;

import com.luisgal.puzzle.translator.IntegerLanguageTranslator;
import com.luisgal.puzzle.translator.british.BritishUnderBillionTranslator;

/**
 * This class is the Command Line Interface of Puzzle One. It translates the
 * first argument into the British words translation.
 * @author Luis.
 */
public class Puzzle {

  private final IntegerLanguageTranslator translator;

  /**
   * It creates a new instance that will use the given language translator.
   * @param languageTranslator The translator to use.
   */
  public Puzzle(final IntegerLanguageTranslator languageTranslator) {
    this.translator = languageTranslator;
  }

  /**
   * It translate the given value.
   * @param value The value to translate.
   * @return
   * @throws IllegalArgumentException In case the
   */
  public String translate(final String value) throws IllegalArgumentException {
    translator.validateValue(value);
    return translator.translate(value);
  }

  /**
   * It translates the first argument into the British words translation.
   * @param args The argument must satisfy the validation of the translator.
   * @see com.luisgal.puzzle.translator.british.BritishUnderBillionTranslator
   */
  public static void main(String[] args) {
    if (args.length != 1) {
      System.err.println("Expected one argument. Input the integer to translate.");
    } else {
      final Puzzle puzzle = new Puzzle(BritishUnderBillionTranslator.getInstance());
      try {
        System.out.println(puzzle.translate(args[0]));
      } catch (IllegalArgumentException e) {
        System.err.println(e.getMessage());
      }
    }
  }
}
