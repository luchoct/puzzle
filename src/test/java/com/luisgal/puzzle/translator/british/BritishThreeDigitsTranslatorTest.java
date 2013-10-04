package com.luisgal.puzzle.translator.british;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class BritishThreeDigitsTranslatorTest {

  private final BritishThreeDigitsTranslator translator = new BritishThreeDigitsTranslator();

  // We test translatePartially method without a given translated prefix.

  @Test
  public void testTranslatePartially123WithEmptyPrefix() {
    assertEquals("one hundred and twenty three", translator.translatePartially("", "123"));
  }

  @Test
  public void testTranslatePartially781WithEmptyPrefix() {
    assertEquals("seven hundred and eighty one", translator.translatePartially("", "781"));
  }

  @Test
  public void testTranslatePartially999WithEmptyPrefix() {
    assertEquals("nine hundred and ninety nine", translator.translatePartially("", "999"));
  }

  @Test
  public void testTranslatePartially909WithEmptyPrefix() {
    assertEquals("nine hundred and nine", translator.translatePartially("", "909"));
  }

  @Test
  public void testTranslatePartially900WithEmptyPrefix() {
    assertEquals("nine hundred", translator.translatePartially("", "900"));
  }

  @Test
  public void testTranslatePartially15WithEmptyPrefix() {
    assertEquals("fifteen", translator.translatePartially("", "15"));
  }

  @Test
  public void testTranslatePartially001WithEmptyPrefix() {
    assertEquals("one", translator.translatePartially("", "001"));
  }

  @Test
  public void testTranslatePartially01WithEmptyPrefix() {
    assertEquals("one", translator.translatePartially("", "01"));
  }

  @Test
  public void testTranslatePartially0WithEmptyPrefix() {
    assertEquals("zero", translator.translatePartially("", "0"));
  }

  @Test
  public void testTranslatePartially000WithEmptyPrefix() {
    assertEquals("zero", translator.translatePartially("", "000"));
  }

  // We test translatePartially method with a given translated prefix.

  @Test
  public void testTranslatePartially123WithNonEmptyPrefix() {
    assertEquals("one hundred and twenty three", translator.translatePartially("one thousand", "123"));
  }

  @Test
  public void testTranslatePartially781WithNonEmptyPrefix() {
    assertEquals("seven hundred and eighty one", translator.translatePartially("one thousand", "781"));
  }

  @Test
  public void testTranslatePartially999WithNonEmptyPrefix() {
    assertEquals("nine hundred and ninety nine", translator.translatePartially("one thousand", "999"));
  }

  @Test
  public void testTranslatePartially909WithNonEmptyPrefix() {
    assertEquals("nine hundred and nine", translator.translatePartially("one thousand", "909"));
  }

  @Test
  public void testTranslatePartially900WithNonEmptyPrefix() {
    assertEquals("nine hundred", translator.translatePartially("one thousand", "900"));
  }

  @Test
  public void testTranslatePartially15WithNonEmptyPrefix() {
    assertEquals("and fifteen", translator.translatePartially("one thousand", "15"));
  }

  @Test
  public void testTranslatePartially001WithNonEmptyPrefix() {
    assertEquals("and one", translator.translatePartially("one thousand", "001"));
  }

  @Test
  public void testTranslatePartially01WithNonEmptyPrefix() {
    assertEquals("and one", translator.translatePartially("one thousand", "01"));
  }

  @Test
  public void testTranslatePartially0WithNonEmptyPrefix() {
    assertEquals("", translator.translatePartially("one thousand", "0"));
  }

  @Test
  public void testTranslatePartially000WithNonEmptyPrefix() {
    assertEquals("", translator.translatePartially("one thousand", "000"));
  }

  // We test the appendAndWord method without prefix. The method should append
  // the 'and' when there are hundreds digit and another digit different from
  // zero.

  @Test
  public void testAppendAndWordWithoutPrefixAndWith000() {
    final StringBuilder builder = new StringBuilder();
    translator.appendAndWord(builder, "", '0', '0', '0');
    // The British representation is 'zero' so I does not include any 'and'
    // word.
    assertEquals(0, builder.length());
  }

  @Test
  public void testAppendAndWordWithoutPrefixAndWith001() {
    final StringBuilder builder = new StringBuilder();
    translator.appendAndWord(builder, "", '0', '0', '1');
    // The British representation is 'one' so I does not include any 'and' word.
    assertEquals(0, builder.length());
  }

  @Test
  public void testAppendAndWordWithoutPrefixAndWith010() {
    final StringBuilder builder = new StringBuilder();
    translator.appendAndWord(builder, "", '0', '1', '0');
    // The British representation is 'ten' so I does not include any 'and' word.
    assertEquals(0, builder.length());
  }

  @Test
  public void testAppendAndWordWithoutPrefixAndWith100() {
    final StringBuilder builder = new StringBuilder();
    translator.appendAndWord(builder, "", '1', '0', '0');
    // The British representation is 'one hundred' so I does not include any
    // 'and' word.
    assertEquals(0, builder.length());
  }

  @Test
  public void testAppendAndWordWithoutPrefixAndWith101() {
    final StringBuilder builder = new StringBuilder();
    translator.appendAndWord(builder, "", '1', '0', '1');
    // The British representation is 'one hundred and one' so I does include the
    // 'and' word.
    assertEquals("and", builder.toString());
  }

  @Test
  public void testAppendAndWordWithoutPrefixAndWith110() {
    final StringBuilder builder = new StringBuilder();
    translator.appendAndWord(builder, "", '1', '1', '0');
    // The British representation is 'one hundred and ten' so I does include the
    // 'and' word.
    assertEquals("and", builder.toString());
  }

  @Test
  public void testAppendAndWordWithoutPrefixAndWith111() {
    final StringBuilder builder = new StringBuilder();
    translator.appendAndWord(builder, "", '1', '1', '1');
    // The British representation is 'one hundred and eleven' so I does include
    // the 'and' word.
    assertEquals("and", builder.toString());
  }

  // We test the appendAndWord method with prefix. In this case, regardless
  // there are not hundres, the method should append the 'and' when either tens
  // or ones digit are different from zero.

  @Test
  public void testAppendAndWordWithPrefixAndWith000() {
    final StringBuilder builder = new StringBuilder();
    translator.appendAndWord(builder, "", '0', '0', '0');
    // The British representation is 'zero' so I does not include any 'and'
    // word.
    assertEquals(0, builder.length());
  }

  @Test
  public void testAppendAndWordWithPrefixAndWith001() {
    final StringBuilder builder = new StringBuilder();
    translator.appendAndWord(builder, "", '0', '0', '1');
    // The British representation is 'one' so I does not include any 'and' word.
    assertEquals(0, builder.length());
  }

  @Test
  public void testAppendAndWordWithPrefixAndWith010() {
    final StringBuilder builder = new StringBuilder();
    translator.appendAndWord(builder, "", '0', '1', '0');
    // The British representation is 'ten' so I does not include any 'and' word.
    assertEquals(0, builder.length());
  }

  @Test
  public void testAppendAndWordWithPrefixAndWith100() {
    final StringBuilder builder = new StringBuilder();
    translator.appendAndWord(builder, "", '1', '0', '0');
    // The British representation is 'one hundred' so I does not include any
    // 'and' word.
    assertEquals(0, builder.length());
  }

  @Test
  public void testAppendAndWordWithPrefixAndWith101() {
    final StringBuilder builder = new StringBuilder();
    translator.appendAndWord(builder, "", '1', '0', '1');
    // The British representation is 'one hundred and one' so I does include the
    // 'and' word.
    assertEquals("and", builder.toString());
  }

  @Test
  public void testAppendAndWordWithPrefixAndWith110() {
    final StringBuilder builder = new StringBuilder();
    translator.appendAndWord(builder, "", '1', '1', '0');
    // The British representation is 'one hundred and ten' so I does include the
    // 'and' word.
    assertEquals("and", builder.toString());
  }

  @Test
  public void testAppendAndWordWithPrefixAndWith111() {
    final StringBuilder builder = new StringBuilder();
    translator.appendAndWord(builder, "", '1', '1', '1');
    // The British representation is 'one hundred and eleven' so I does include
    // the 'and' word.
    assertEquals("and", builder.toString());
  }

  @Test
  public void testTranslateHundredsDigitWithZeroDigit() {
    assertEquals("", translator.translateHundredsDigit('0'));
  }

  @Test
  public void testTranslateHundredsDigitWithNonZeroDigit() {
    assertEquals("three hundred", translator.translateHundredsDigit('3'));
  }

  @Test
  public void testTranslateTensAndOnesWith00() {
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
