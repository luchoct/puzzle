package com.luchoct.puzzle;

import static org.junit.Assert.assertEquals;

import com.luchoct.puzzle.translator.british.BritishNineDigitsTranslator;
import org.junit.BeforeClass;
import org.junit.Test;

import com.luchoct.puzzle.translator.british.BritishSignTranslator;
import com.luchoct.puzzle.translator.british.BritishThreeDigitsTranslator;

public class PuzzleIntegrationTest {

  private static Puzzle puzzle;

  @BeforeClass
  public static void createPuzzle() {
    puzzle = new Puzzle(BritishSignTranslator.getInstance(), new BritishNineDigitsTranslator(
        new BritishThreeDigitsTranslator()));
  }

  @Test
  public void testTranslateValue10123() {
    assertEquals("ten thousand one hundred and twenty three", puzzle.translate("10123"));
  }

  @Test
  public void testTranslateValue56945781() {
    assertEquals("fifty six million nine hundred and forty five thousand seven hundred and eighty one",
        puzzle.translate("56945781"));
  }

  @Test
  public void testTranslateValue999999999() {
    assertEquals(
        "nine hundred and ninety nine million nine hundred and ninety nine thousand nine hundred and ninety nine",
        puzzle.translate("999999999"));
  }

  @Test
  public void testTranslateValue10001() {
    assertEquals("ten thousand and one", puzzle.translate("10001"));
  }

  @Test
  public void testTranslateValueMinus18010001() {
    assertEquals("minus eighteen million and ten thousand and one", puzzle.translate("-18010001"));
  }

  @Test
  public void testTranslateValueMinus805000000() {
    assertEquals("minus eight hundred and five million", puzzle.translate("-805000000"));
  }
}
