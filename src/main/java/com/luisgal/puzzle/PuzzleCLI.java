/**
 * 
 */
package com.luisgal.puzzle;

import com.luisgal.puzzle.translator.IntegerLanguageTranslator;

/**
 * This class is the Command Line Interface of Puzzle One. It translates the
 * first argument into the British words translation.
 * @author Luis.
 */
public class PuzzleCLI {

  private final IntegerLanguageTranslator translator;

  /**
   * It creates a new instance that will use the given language translator.
   * @param languageTranslator The translator to use.
   */
  public PuzzleCLI(final IntegerLanguageTranslator languageTranslator) {
    this.translator = languageTranslator;
  }

  /**
   * It translate the given value.
   * @param value The value to translate.
   * @return
   * @throws IllegalArgumentException In case the
   */
  public String translate(final String value) throws IllegalArgumentException {
    // TODO
    return null;
  }

  /**
   * It translates the first argument into the British words translation.
   * @param args The first argument contains an integer between -999999999 and
   *          999999999. @
   */
  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }

}
