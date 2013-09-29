package com.luisgal.puzzle;

import static org.junit.Assert.fail;

import org.junit.Test;

public class PuzzleCLITest {

  @Test
  public void testMainUsesBritishLocale() {
    fail();
  }

  @Test
  public void testMainTranslatesFirstArgument() {
    fail();
  }

  @Test(expected = IllegalArgumentException.class)
  public void testMainWithZeroArguments() {
  }

  @Test(expected = IllegalArgumentException.class)
  public void testMainWithArgumentWhichIsNotAnInteger() {
  }

  @Test(expected = IllegalArgumentException.class)
  public void testMainWithArgumentWhichIsSmallerThanMinus999999999() {
  }

  @Test(expected = IllegalArgumentException.class)
  public void testMainWithArgumentWhichIsGreaterThan999999999() {
  }
}
