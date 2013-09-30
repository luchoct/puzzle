/**
 * 
 */
package com.luisgal.puzzle.translator.british;

/**
 * Enum with the ones and their integer representations.
 * @author Luis
 * 
 */
public enum OneEnum {
  ZERO("0"), ONE("1"), TWO("2"), THREE("3"), FOUR("4"), FIVE("5"), SIX("6"), SEVEN("7"), EIGHT("8"), NINE("9");

  private final String integerRepresentation;

  private OneEnum(final String anIntegerRepresentation) {
    integerRepresentation = anIntegerRepresentation;
  }

  /**
   * It returns the OneEnum with the given integer representation.
   * @param anIntegerRepresentation The integer representation to match.
   * @return The OneEnum that matches the given integer representation.
   * @throws IllegalArgumentException The exception when the integer
   *           representation doesn't match any OneEnum.
   */
  public static OneEnum valueOfIntegerRepresentation(final String anIntegerRepresentation) {
    for (final OneEnum currentOneEnum : OneEnum.values()) {
      if (currentOneEnum.getIntegerRepresentation().equals(anIntegerRepresentation)) {
        return currentOneEnum;
      }
    }
    throw new IllegalArgumentException("No OneEnum matches the given integer representation");
  }

  public String getIntegerRepresentation() {
    return integerRepresentation;
  }

  public String toString() {
    return super.toString().toLowerCase();
  }
}
