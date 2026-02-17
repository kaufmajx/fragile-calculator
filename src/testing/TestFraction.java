package testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import math.Fraction;
import math.MixedFraction;
import math.Operations;

/**
 * A class for testing the ImproperFraction class.
 * 
 * @author John Ryder
 * @version 11/3/23 Honor Code: This work complies with JMU's Honor Code:
 */
class TestFraction
{

  /**
   * Tests constructor, getters, and setters.
   */
  @Test
  void testConstructorGettersSetters()
  {
    Fraction test1 = new Fraction(15, 2);
    assertEquals(15, test1.getNumerator());
    assertEquals(2, test1.getDenominator());
    test1.setNumerator(20);
    test1.setDenominator(9);
    assertEquals(20, test1.getNumerator());
    assertEquals(9, test1.getDenominator());
  }

  /**
   * Tests converting an improper fraction to a whole number.
   */
  @Test
  void testConvertToMixedFraction()
  {
    Fraction test2 = new Fraction(5, 2);
    MixedFraction test2Mixed = test2.convertToMixedFraction();
    assertEquals(2, test2Mixed.getWholeNumber());
    assertEquals(1, test2Mixed.getNumerator());
    assertEquals(2, test2Mixed.getDenominator());

    Fraction test2NegNumerator = new Fraction(-14, 10);
    MixedFraction test2NegNumeratorMixed = test2NegNumerator.convertToMixedFraction().simplify();
    assertEquals(-1, test2NegNumeratorMixed.getWholeNumber());
    assertEquals(2, test2NegNumeratorMixed.getNumerator());
    assertEquals(5, test2NegNumeratorMixed.getDenominator());

    Fraction test2NegDenom = new Fraction(14, -10);
    MixedFraction test2NegDenomMixed = test2NegDenom.convertToMixedFraction().simplify();
    assertEquals(-1, test2NegDenomMixed.getWholeNumber());
    assertEquals(2, test2NegDenomMixed.getNumerator());
    assertEquals(5, test2NegDenomMixed.getDenominator());

    Fraction test2BothNegative = new Fraction(-14, -10);
    MixedFraction test2BothNegativeMixed = test2BothNegative.convertToMixedFraction().simplify();
    assertEquals(1, test2BothNegativeMixed.getWholeNumber());
    assertEquals(2, test2BothNegativeMixed.getNumerator());
    assertEquals(5, test2BothNegativeMixed.getDenominator());

  }

  /**
   * Tests converting a mixed fraction to an improper number.
   */
  @Test
  void testConvertToImproperFraction()
  {
    MixedFraction test3Mixed = new MixedFraction(-2, 1, 2);
    Fraction test3 = test3Mixed.convertToFraction();
    assertEquals(-5, test3.getNumerator());
    assertEquals(2, test3.getDenominator());
    MixedFraction test4Mixed = new MixedFraction(2, 1, 2);
    Fraction test4 = test4Mixed.convertToFraction();
    assertEquals(5, test4.getNumerator());
    assertEquals(2, test4.getDenominator());
  }

  /**
   * Tests the process of standardizing two improper fractions, most commonly with the LCM of their
   * denominators.
   */
  @Test
  void testStandardize()
  {
    Fraction test4First = new Fraction(3, 8);
    Fraction test4Second = new Fraction(3, 7);
    int lcm = Operations.leastCommonMultiple(test4First.getDenominator(),
        test4Second.getDenominator());

    Fraction firstStandard = test4First.standardize(lcm / test4First.getDenominator());
    Fraction secondStandard = test4Second.standardize(lcm / test4Second.getDenominator());

    assertEquals(21, firstStandard.getNumerator());
    assertEquals(56, firstStandard.getDenominator());

    assertEquals(24, secondStandard.getNumerator());
    assertEquals(56, secondStandard.getDenominator());
  }
  
  @Test
  void testSimplifyImproperFraction() 
  {
    Fraction notSimplified = new Fraction(25, 5);
    Fraction simplified = notSimplified.simplifyFraction();
    assertEquals(5, simplified.getNumerator());
    assertEquals(1, simplified.getDenominator());
    
    MixedFraction notSimplifiedMixed = notSimplified.convertToMixedFraction();
    MixedFraction simplifiedMixed = simplified.convertToMixedFraction();
    
    assertEquals(notSimplifiedMixed.getWholeNumber(), simplifiedMixed.getWholeNumber());
    assertEquals(notSimplifiedMixed.getNumerator(), simplifiedMixed.getNumerator());
    assertEquals(notSimplifiedMixed.simplify().getDenominator(), simplifiedMixed.getDenominator());
    
    Fraction properNotSimplified = new Fraction(3, 6);
    Fraction properSimplified = properNotSimplified.simplifyFraction();
    
    assertEquals(1, properSimplified.getNumerator());
    assertEquals(2, properSimplified.getDenominator());
    
    Fraction properSimplified2 = new Fraction(2, 3);
    Fraction noEffect = properSimplified2.simplifyFraction();
    
    assertEquals(properSimplified2.getNumerator(), noEffect.getNumerator());
    assertEquals(properSimplified2.getDenominator(), noEffect.getDenominator());
    
  }
  
  @Test
  void testRatio() 
  {
    Fraction testFraction = new Fraction(25, 5);
    Double output = testFraction.ratio();
    assertEquals(5, output);
  }
  @Test
  void testToString()
  {
    Fraction toStringTest = new Fraction(25, 5);
    assertTrue(toStringTest.toString().equals("25/5"));
  }
}
