package com.luchoct.puzzle.translator.british;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class BritishThreeDigitsTranslatorTest {

  private final BritishThreeDigitsTranslator translator = new BritishThreeDigitsTranslator();

  @Test
  public void testTranslate123() {
    assertEquals("one hundred and twenty three", translator.translate("123"));
  }

  @Test
  public void testTranslate781() {
    assertEquals("seven hundred and eighty one", translator.translate("781"));
  }

  @Test
  public void testTranslate999() {
    assertEquals("nine hundred and ninety nine", translator.translate("999"));
  }

  @Test
  public void testTranslate909() {
    assertEquals("nine hundred and nine", translator.translate("909"));
  }

  @Test
  public void testTranslate900() {
    assertEquals("nine hundred", translator.translate("900"));
  }

  @Test
  public void testTranslate15() {
    assertEquals("fifteen", translator.translate("15"));
  }

  @Test
  public void testTranslate001() {
    assertEquals("one", translator.translate("001"));
  }

  @Test
  public void testTranslate01() {
    assertEquals("one", translator.translate("01"));
  }

  @Test
  public void testTranslate0() {
    assertEquals("zero", translator.translate("0"));
  }

  @Test
  public void testTranslate000() {
    assertEquals("zero", translator.translate("000"));
  }

  @Test
  public void testAppendAndWordWith000DoesNotAppendAnything() {
    final StringBuilder builder = new StringBuilder();
    translator.appendAndWord(builder, '0', '0', '0');
    // The British representation is 'zero' so I does not include any 'and'
    // word.
    assertTrue(builder.toString().isEmpty());
  }

  @Test
  public void testAppendAndWordWith001DoesNotAppendAnything() {
    final StringBuilder builder = new StringBuilder();
    translator.appendAndWord(builder, '0', '0', '1');
    // The British representation is 'one' so I does not include any 'and' word.
    assertTrue(builder.toString().isEmpty());
  }

  @Test
  public void testAppendAndWordWith010DoesNotAppendAnything() {
    final StringBuilder builder = new StringBuilder();
    translator.appendAndWord(builder, '0', '1', '0');
    // The British representation is 'ten' so I does not include any 'and' word.
    assertTrue(builder.toString().isEmpty());
  }

  @Test
  public void testAppendAndWordWith100DoesNotAppendAnything() {
    final StringBuilder builder = new StringBuilder();
    translator.appendAndWord(builder, '1', '0', '0');
    // The British representation is 'one hundred' so I does not include any
    // 'and' word.
    assertTrue(builder.toString().isEmpty());
  }

  @Test
  public void testAppendAndWordWith101DoesAppendAndWord() {
    final StringBuilder builder = new StringBuilder();
    translator.appendAndWord(builder, '1', '0', '1');
    // The British representation is 'one hundred and one' so I does include the
    // 'and' word.
    assertEquals("and", builder.toString());
  }

  @Test
  public void testAppendAndWordWith110DoesAppendAndWord() {
    final StringBuilder builder = new StringBuilder();
    translator.appendAndWord(builder, '1', '1', '0');
    // The British representation is 'one hundred and ten' so I does include the
    // 'and' word.
    assertEquals("and", builder.toString());
  }

  @Test
  public void testAppendAndWordWith111DoesAppendAndWord() {
    final StringBuilder builder = new StringBuilder();
    translator.appendAndWord(builder, '1', '1', '1');
    // The British representation is 'one hundred and eleven' so I does include
    // the 'and' word.
    assertEquals("and", builder.toString());
  }

  @Test
  public void testTranslateHundredsDigitWithZeroDigitTranslatesEmptyString() {
    assertTrue(translator.translateHundredsDigit('0').isEmpty());
  }

  @Test
  public void testTranslateHundredsDigitWithNonZeroDigit() {
    assertEquals("three hundred", translator.translateHundredsDigit('3'));
  }

  @Test
  public void testTranslateTensAndOnesWith00TranslatesZero() {
    assertEquals("zero", translator.translateTensAndOnes('0', '0'));
  }

  @Test
  public void testTranslateTensAndOnesWith01() {
    assertEquals("one", translator.translateTensAndOnes('0', '1'));
  }

  @Test
  public void testTranslateTensAndOnesWith10() {
    assertEquals("ten", translator.translateTensAndOnes('1', '0'));
  }

  @Test
  public void testTranslateTensAndOnesWith15() {
    assertEquals("fifteen", translator.translateTensAndOnes('1', '5'));
  }

  @Test
  public void testTranslateTensAndOnesWith20() {
    assertEquals("twenty", translator.translateTensAndOnes('2', '0'));
  }

  @Test
  public void testTranslateTensAndOnesWith25() {
    assertEquals("twenty five", translator.translateTensAndOnes('2', '5'));
  }
}
