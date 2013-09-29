package com.luisgal.puzzle.translator.british;

import org.junit.Test;

public class BritishUnderBillionTranslatorTest {

  @Test(expected = IllegalArgumentException.class)
  public void testValidateValueWhichIsNotAnInteger() {
    BritishUnderBillionTranslator.getInstance().validateValue("hello");
  }

  @Test(expected = IllegalArgumentException.class)
  public void testValidateValueWhichIsSmallerThanMinus999999999() {
    BritishUnderBillionTranslator.getInstance().validateValue("-1000000000");
  }

  @Test(expected = IllegalArgumentException.class)
  public void testValidateValueWhichIsGreaterThan999999999() {
    BritishUnderBillionTranslator.getInstance().validateValue("1000000000");
  }

  @Test()
  public void testValidateValueBetweenMinus999999999And999999999() {
    BritishUnderBillionTranslator.getInstance().validateValue("-999999999");
    BritishUnderBillionTranslator.getInstance().validateValue("-2");
    BritishUnderBillionTranslator.getInstance().validateValue("0");
    BritishUnderBillionTranslator.getInstance().validateValue("10");
    BritishUnderBillionTranslator.getInstance().validateValue("999999999");
  }
}
