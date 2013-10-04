/**
 * 
 */
package com.luisgal.puzzle.translator.british;

/**
 * @author Luis Enum with the tens and their integer representations.
 */
public enum BritishTenDigitEnum {

  TEN('1'), TWENTY('2'), THIRTY('3'), FORTY('4'), FIFTY('5'), SIXTY('6'), SEVENTY('7'), EIGHTY('8'), NINETY('9');

  private final char tenDigit;

  private BritishTenDigitEnum(final char aTenDigit) {
    tenDigit = aTenDigit;
  }

  /**
   * It returns the enumeration which represent the given one digit.
   * @param aTenDigit The ten digit to match.
   * @return The enumeration that matches the given digit.
   * @throws IllegalArgumentException The exception when the digit doesn't match
   *           any OneEnum.
   */
  public static BritishTenDigitEnum valueOfTenDigit(final char aTenDigit) {
    for (final BritishTenDigitEnum currentTenEnum : BritishTenDigitEnum.values()) {
      if (currentTenEnum.getTenDigit() == aTenDigit) {
        return currentTenEnum;
      }
    }
    throw new IllegalArgumentException("No BritishTenDigitEnum matches the given ten digit");
  }

  public char getTenDigit() {
    return tenDigit;
  }

  public String getBritishRepresentation() {
    return toString().toLowerCase();
  }
}
