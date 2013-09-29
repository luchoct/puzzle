package com.luisgal.puzzle.translator.british;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Integration tests of BritishUnderBillionTranslator class
 * @author Luis
 * 
 */
public class BritishUnderBillionTranslatorIntegrationTest {

  @Test
  public void testNegativePrefixTranslation() {
    assertEquals("minus", BritishUnderBillionTranslator.getInstance().getNegativePrefixTranslation());
  }

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

  @Test
  public void testValidateValueBetweenMinus999999999And999999999() {
    BritishUnderBillionTranslator.getInstance().validateValue("-999999999");
    BritishUnderBillionTranslator.getInstance().validateValue("-2");
    BritishUnderBillionTranslator.getInstance().validateValue("0");
    BritishUnderBillionTranslator.getInstance().validateValue("10");
    BritishUnderBillionTranslator.getInstance().validateValue("999999999");
  }

  @Test
  public void testTranslateValueMinus10123() {
    assertEquals("minus ten thousand one hundred and twenty thre", BritishUnderBillionTranslator.getInstance()
        .translate("-10123"));
  }

  @Test
  public void testTranslateValue10123() {
    assertEquals("ten thousand one hundred and twenty thre",
        BritishUnderBillionTranslator.getInstance().translate("10123"));
  }

  @Test
  public void testTranslateValue56945781() {
    assertEquals("fifty six million nine hundred and forty five thousand seven hundred and eighty one",
        BritishUnderBillionTranslator.getInstance().translate("56945781"));
  }

  @Test
  public void testTranslateValue999999999() {
    assertEquals(
        "nine hundred and ninety nine million nine hundred and ninety nine thousand Nine hundred and ninety nine",
        BritishUnderBillionTranslator.getInstance().translate("999999999"));
  }

  @Test
  public void testTranslateValue10001() {
    assertEquals("ten thousand and one", BritishUnderBillionTranslator.getInstance().translate("10001"));
  }
}