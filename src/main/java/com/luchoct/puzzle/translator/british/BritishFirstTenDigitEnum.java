package com.luchoct.puzzle.translator.british;

public enum BritishFirstTenDigitEnum {

  TEN('0'), ELEVEN('1'), TWELVE('2'), THIRTEEN('3'), FORTEEN('4'), FIFTEEN('5'), SIXTEEN('6'), SEVENTEEN('7'), 
  EIGHTEEN('8'), NINETEEN('9');

  private final char oneDigit;

  private BritishFirstTenDigitEnum(final char anOneDigit) {
    oneDigit = anOneDigit;
  }

  /**
   * It returns the enumeration which represent the first ten with the given one
   * digit.
   * @param anOneDigit The one digit to match.
   * @return The enumeration that matches the given digit.
   * @throws IllegalArgumentException The exception when the digit doesn't match
   *           any OneEnum.
   */
  public static BritishFirstTenDigitEnum valueOfOneDigit(final char anOneDigit) {
    for (final BritishFirstTenDigitEnum currentTenEnum : BritishFirstTenDigitEnum.values()) {
      if (currentTenEnum.getOneDigit() == anOneDigit) {
        return currentTenEnum;
      }
    }
    throw new IllegalArgumentException("No BritishFirstTenDigitEnum matches the given one digit");
  }

  public char getOneDigit() {
    return oneDigit;
  }

  public String getBritishRepresentation() {
    return toString().toLowerCase();
  }
}
