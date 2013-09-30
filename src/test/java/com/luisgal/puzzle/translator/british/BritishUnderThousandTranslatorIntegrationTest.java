package com.luisgal.puzzle.translator.british;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class BritishUnderThousandTranslatorIntegrationTest {

  @Test
  public void testTranslateValueMinus123() {
    assertEquals("minus one hundred and twenty thre", BritishUnderBillionTranslator.getInstance().translate("-123"));
  }

  @Test
  public void testTranslateValue123() {
    assertEquals("one hundred and twenty thre", BritishUnderBillionTranslator.getInstance().translate("123"));
  }

  @Test
  public void testTranslateValue781() {
    assertEquals("seven hundred and eighty one", BritishUnderBillionTranslator.getInstance().translate("781"));
  }

  @Test
  public void testTranslateValue999() {
    assertEquals("nine hundred and ninety nine", BritishUnderBillionTranslator.getInstance().translate("999"));
  }

  @Test
  public void testTranslateValue001() {
    assertEquals("one", BritishUnderBillionTranslator.getInstance().translate("001"));
  }

  @Test
  public void testTranslateValue01() {
    assertEquals("one", BritishUnderBillionTranslator.getInstance().translate("01"));
  }

  @Test
  public void testTranslateValue0() {
    assertEquals("zero", BritishUnderBillionTranslator.getInstance().translate("0"));
  }

  @Test
  public void testTranslateValue000() {
    assertEquals("zero", BritishUnderBillionTranslator.getInstance().translate("000"));
  }
}
