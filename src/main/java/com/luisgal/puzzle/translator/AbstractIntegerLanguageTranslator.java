package com.luisgal.puzzle.translator;

public abstract class AbstractIntegerLanguageTranslator implements IntegerLanguageTranslator {

  private int minimumValue;
  private int maximumValue;

  public AbstractIntegerLanguageTranslator(final int minimumValue, final int maximumValue) {
    this.minimumValue = minimumValue;
    this.maximumValue = maximumValue;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public String translate(final String value) {
    return translatePartially("", value);
  }

  /**
   * It validates that the value is an integer, without grouping characters,
   * from minus one billion to one billion, both exclusive.
   * @see com.luisgal.puzzle.translator.IntegerLanguageTranslator#validateValue(int)
   */
  @Override
  public void validateValue(final String value) {
    try {
      final int intValue = Integer.parseInt(value);
      if ((intValue > maximumValue) || (intValue < minimumValue)) {
        throw new IllegalArgumentException(String.format(
            "Wrong value to translate. It must be an integer between %s and %s, both exclusive", minimumValue,
            maximumValue));
      }
    } catch (NumberFormatException nfe) {
      throw new IllegalArgumentException("Wrong value to translate. It must be an integer");
    }
  }
}
