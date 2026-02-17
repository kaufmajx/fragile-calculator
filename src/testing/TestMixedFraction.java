package testing;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.Test;

import math.Fraction;
import math.MixedFraction;

/**
 * Test cases for the MixedFraction class.
 * 
 * @author John Ryder
 * @version 11/2/23 Honor Code: This work complies with JMU's Honor Code:
 */
public class TestMixedFraction
{
  /**
   * Test basic functionality of the constructor and getters.
   */
  @Test
  public void testConstructorAndGetters()
  {
    MixedFraction testFraction = new MixedFraction(2, 1, 3);
    assertEquals(2, testFraction.getWholeNumber());
    assertEquals(1, testFraction.getNumerator());
    assertEquals(3, testFraction.getDenominator());
    assertTrue(testFraction.getHasWholeNumber());
    MixedFraction testFraction2 = new MixedFraction(0, 1, 4);
    assertEquals(0, testFraction2.getWholeNumber());
    assertTrue(!testFraction2.getHasWholeNumber());
    MixedFraction testFraction3 = new MixedFraction(-2, 1, 5);
    assertEquals(-2, testFraction3.getWholeNumber());
    MixedFraction testFraction4 = new MixedFraction(2, -1, -5);
    assertEquals(2, testFraction4.getWholeNumber());
    assertEquals(1, testFraction4.getNumerator());
    assertEquals(5, testFraction4.getDenominator());
    MixedFraction testFraction5 = new MixedFraction(null, 1, 2);
    assertEquals(0, testFraction5.getWholeNumber());
    assertEquals(1, testFraction5.getNumerator());
    assertEquals(2, testFraction5.getDenominator());
    assertTrue(testFraction5.getHasNumerator());
    assertTrue(testFraction5.getHasDenominator());
  }

  /**
   * Tests that the constructor throws an IllegalArgumentException if passed a 0 denominator.
   */
  @Test
  public void testConstructorThrows()
  {
    assertThrows(IllegalArgumentException.class, () -> new MixedFraction(1, 2, 0));
  }

  /**
   * Tests that fractions are correctly updated (reduced, improper fractions eliminated, etc).
   */
  @Test
  public void testFractionUpdate()
  {
    MixedFraction testFraction4 = new MixedFraction(2, 4, 3);
    testFraction4.updateMixedFraction();
    assertEquals(3, testFraction4.getWholeNumber());
    MixedFraction testFraction5 = new MixedFraction(3, 2, 4).simplify();
    assertEquals(3, testFraction5.getWholeNumber());
    assertEquals(1, testFraction5.getNumerator());
    assertEquals(2, testFraction5.getDenominator());
    MixedFraction testFraction6 = new MixedFraction(-3, 1, 2);
    assertEquals(-3, testFraction6.getWholeNumber());
    assertEquals(1, testFraction6.getNumerator());
    assertEquals(2, testFraction6.getDenominator());
    MixedFraction testFraction7 = new MixedFraction(3, -1, 2);
    assertEquals(3, testFraction7.getWholeNumber());
    assertEquals(-1, testFraction7.getNumerator());
    assertEquals(2, testFraction7.getDenominator());
    MixedFraction testFraction8 = new MixedFraction(3, 1, -2);
    assertEquals(3, testFraction8.getWholeNumber());
    assertEquals(-1, testFraction8.getNumerator());
    assertEquals(2, testFraction8.getDenominator());
    MixedFraction testFraction9 = new MixedFraction(-2, 4, 3);
    testFraction9.updateMixedFraction();
    assertEquals(-1, testFraction9.getWholeNumber());
    assertEquals(1, testFraction9.getNumerator());
    assertEquals(3, testFraction9.getDenominator());

    MixedFraction testFraction10 = new MixedFraction(-2, 3, 4);
    testFraction10.updateMixedFraction();
    assertEquals(-2, testFraction10.getWholeNumber());
    assertEquals(3, testFraction10.getNumerator());
    assertEquals(4, testFraction10.getDenominator());
  }

  /**
   * Tests the function to change a fraction from positive to negative and vice versa.
   */
  @Test
  public void testChangeSign()
  {
    MixedFraction testFraction8 = new MixedFraction(2, 1, 3);
    testFraction8.changeSign();
    assertEquals(-2, testFraction8.getWholeNumber());
    assertEquals(1, testFraction8.getNumerator());
    assertEquals(3, testFraction8.getDenominator());
    assertTrue(testFraction8.isNegative());
    testFraction8.changeSign();
    assertEquals(2, testFraction8.getWholeNumber());
    assertEquals(1, testFraction8.getNumerator());
    assertEquals(3, testFraction8.getDenominator());
    assertFalse(testFraction8.isNegative());
  }

  @Test
  public void testNullArguments()
  {
    MixedFraction nullWhole = new MixedFraction(null, -1, 2);

    assertEquals(0, nullWhole.getWholeNumber());
    assertEquals(-1, nullWhole.getNumerator());
    assertEquals(2, nullWhole.getDenominator());

    MixedFraction nullNumerator = new MixedFraction(5, null, 5).simplify();

    assertEquals(5, nullNumerator.getWholeNumber());
    assertEquals(0, nullNumerator.getNumerator());
    assertEquals(1, nullNumerator.getDenominator());

    MixedFraction nullDenominator = new MixedFraction(5, 2, null);
    assertEquals(5, nullDenominator.getWholeNumber());
    assertEquals(0, nullDenominator.getNumerator());
    assertEquals(1, nullDenominator.getDenominator());

    MixedFraction allNull = new MixedFraction(null, null, null);
    assertEquals(0, allNull.getWholeNumber());
    assertEquals(0, allNull.getNumerator());
    assertEquals(1, allNull.getDenominator());
  }

  /**
   * /** Tests MixedFraction's toString.
   */
  @Test
  public void testToString()
  {
    MixedFraction testFraction9 = new MixedFraction(2, 1, 3);
    assertEquals("2 1/3", testFraction9.toString());
    testFraction9.changeSign();
    assertEquals(("-2 1/3"), testFraction9.toString());
    MixedFraction testFraction10 = new MixedFraction(5, null, null);
    assertEquals("5", testFraction10.toString());

    MixedFraction testFraction11 = new MixedFraction(null, 5, 10);
    assertEquals(" 5/10", testFraction11.toString());

    MixedFraction testFraction12 = new MixedFraction(null, null, null);
    assertEquals("0", testFraction12.toString());

    MixedFraction testFraction13 = new MixedFraction(5, null, 10);
    assertEquals("5", testFraction13.toString());

    MixedFraction testFraction14 = new MixedFraction(5, 5, null);
    assertEquals("5", testFraction14.toString());

    MixedFraction testFraction15 = new MixedFraction(5, 0, 10);
    assertEquals("5", testFraction15.toString());
    
    MixedFraction testFraction16 = new MixedFraction(0, 0, 5);
    assertEquals("0", testFraction16.toString());
  }

  @Test
  public void testParseMixedFractionFromString()
  {
    String testParse1 = "5 3/4";
    MixedFraction parseTest1 = MixedFraction.parseMixedFractionFromString(testParse1);
    assertEquals(5, parseTest1.getWholeNumber());
    assertEquals(3, parseTest1.getNumerator());
    assertEquals(4, parseTest1.getDenominator());

    String testParse2 = "";
    MixedFraction parseTest2 = MixedFraction.parseMixedFractionFromString(testParse2);
    assertEquals(0, parseTest2.getWholeNumber());
    assertEquals(0, parseTest2.getNumerator());
    assertEquals(1, parseTest2.getDenominator());

    String testParse3 = "5";
    MixedFraction parseTest3 = MixedFraction.parseMixedFractionFromString(testParse3);
    assertEquals(5, parseTest3.getWholeNumber());

    String testParse4 = "3/5";
    MixedFraction parseTest4 = MixedFraction.parseMixedFractionFromString(testParse4);
    assertEquals(3, parseTest4.getNumerator());
    assertEquals(0, parseTest4.getWholeNumber());
    assertEquals(5, parseTest4.getDenominator());

    String testParse5 = "-3/5";
    MixedFraction parseTest5 = MixedFraction.parseMixedFractionFromString(testParse5);
    assertEquals(-3, parseTest5.getNumerator());
    assertEquals(5, parseTest5.getDenominator());

    String testParse6 = "-5";
    MixedFraction parseTest6 = MixedFraction.parseMixedFractionFromString(testParse6);
    assertEquals(-5, parseTest6.getWholeNumber());

    String testParse7 = "-5 2/3";
    MixedFraction parseTest7 = MixedFraction.parseMixedFractionFromString(testParse7);
    assertEquals(-5, parseTest7.getWholeNumber());
    assertEquals(2, parseTest7.getNumerator());
    assertEquals(3, parseTest7.getDenominator());

    String testParse8 = "5 /3";
    MixedFraction parseTest8 = MixedFraction.parseMixedFractionFromString(testParse8);
    assertEquals(5, parseTest8.getWholeNumber());
    assertEquals(0, parseTest8.getNumerator());
    assertEquals(1, parseTest8.getDenominator());

    String testParse9 = "5 2/";
    MixedFraction parseTest9 = MixedFraction.parseMixedFractionFromString(testParse9);
    assertEquals(5, parseTest9.getWholeNumber());
    assertEquals(0, parseTest9.getNumerator());
    assertEquals(1, parseTest9.getDenominator());

  }

  @Test
  public void testComparison()
  {
    MixedFraction mf1 = new MixedFraction(5, 1, 2);
    MixedFraction mf2 = new MixedFraction(3, 5, 8);

    int comparison1 = mf1.compareTo(mf2);

    assertTrue(comparison1 > 0);

    mf1 = new MixedFraction(5, 1, 2);
    mf2 = new MixedFraction(5, 4, 8);

    int comparison2 = mf1.compareTo(mf2);

    assertEquals(0, comparison2);
  }

  @SuppressWarnings("unlikely-arg-type")
  @Test
  public void testEquals()
  {
    MixedFraction mf1 = new MixedFraction(1, 1, 2);
    MixedFraction mf2 = new MixedFraction(1, 1, 2);
    assertTrue(mf1.equals(mf2));
      
    mf2 = new MixedFraction(-1, 1, 2);
    assertFalse(mf1.equals(mf2));
      
    mf2 = new MixedFraction(0, 3, 2);
    assertTrue(mf1.equals(mf2));
      
    String coverage = "coverage";
    assertFalse(mf2.equals(coverage));
    assertFalse(mf2.equals(null));
  }

  @Test
  public void testConvertToFraction()
  {
    MixedFraction mf1 = new MixedFraction(3, 1, 2);
    Fraction mf1Frac = mf1.convertToFraction();
    assertEquals("7/2", mf1Frac.toString());
    assertEquals(7, mf1Frac.getNumerator());
    assertEquals(2, mf1Frac.getDenominator());

    MixedFraction mf2 = new MixedFraction(5, 20, 6);
    Fraction mf2Frac = mf2.convertToFraction();
    assertEquals(50, mf2Frac.getNumerator());
    assertEquals(6, mf2Frac.getDenominator());

    MixedFraction mf3 = new MixedFraction(-4, 3, 6);
    Fraction mf3Frac = mf3.convertToFraction();
    assertEquals(-27, mf3Frac.getNumerator());
    assertEquals(6, mf3Frac.getDenominator());

  }
  
  @Test
  public void testSimplify() {
    MixedFraction mf1 = new MixedFraction(5, 3, 6);
    MixedFraction mf2 = new MixedFraction(5, 1, 2);
    
    
    MixedFraction mf1Simplified = mf1.simplify();
    MixedFraction mf2Simplified = mf2.simplify();
    
    assertEquals(5, mf1Simplified.getWholeNumber());
    assertEquals(1, mf1Simplified.getNumerator());
    assertEquals(2, mf1Simplified.getDenominator());
    
    assertEquals(5, mf2Simplified.getWholeNumber());
    assertEquals(1, mf2Simplified.getNumerator());
    assertEquals(2, mf2Simplified.getDenominator());
    
  }
  
  @Test
  public void testHashCode() {
    new MixedFraction(1, 1, 1).hashCode();
  }
}
