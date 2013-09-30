/**
 * 
 */
package com.luisgal.puzzle.translator.british;

/**
 * @author Luis Enum with the tens and their integer representations.
 */
public enum TenEnum {

  TEN("1"), TWENTY("2"), THIRTY("3"), FORTY("4"), FIFTY("5"), SIXTY("6"), SEVENTY("7"), EIGHTTY("8"), NINETY("9");

  private final String integerRepresentation;

  private TenEnum(final String anIntegerRepresentation) {
    integerRepresentation = anIntegerRepresentation;
  }

  /**
   * It returns the TenEnum with the given integer representation.
   * @param anIntegerRepresentation The integer representation to match.
   * @return The TenEnum that matches the given integer representation.
   * @throws IllegalArgumentException The exception when the integer
   *           representation doesn't match any TenEnum.
   */
  public static TenEnum valueOfIntegerRepresentation(final String anIntegerRepresentation) {
    for (final TenEnum currentTenEnum : TenEnum.values()) {
      if (currentTenEnum.getIntegerRepresentation().equals(anIntegerRepresentation)) {
        return currentTenEnum;
      }
    }
    throw new IllegalArgumentException("No TenEnum matches the given integer representation");
  }

  public String getIntegerRepresentation() {
    return integerRepresentation;
  }

  public String toString() {
    return super.toString().toLowerCase();
  }
}
