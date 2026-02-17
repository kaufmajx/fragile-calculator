package testing;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Locale;

import org.junit.jupiter.api.Test;

import math.Fraction;
import math.MixedFraction;
import math.Operations;

/**
 * A class for testing the operations module.
 * 
 * @author John Ryder
 * @version 11/2/23 Honor Code: This work complies with JMU's Honor Code:
 */
public class TestOperations
{

  
  @Test
  public void setLanguageEnglish()
  {
    Locale.setDefault(Locale.US);
  }
  
  
  
  /**
   * Tests the least common denominator function.
   */

  @Test
  void testLCM()
  {
    new Operations();
    int testInt1 = 15;
    int testInt2 = 45;
    int lcm1 = Operations.leastCommonMultiple(testInt1, testInt2);
    assertEquals(45, lcm1);
    int testInt3 = 63;
    int testInt4 = 15;
    int lcm2 = Operations.leastCommonMultiple(testInt3, testInt4);
    assertEquals(315, lcm2);
  }

  /**
   * Tests the greatest common divisor function.
   */

  @Test
  void testGCD()
  {
    int testGCD1 = 15;
    int testGCD2 = 24;
    int gcd1 = Operations.greatestCommonDivisor(testGCD1, testGCD2);
    assertEquals(3, gcd1);
    int testGCD3 = 25;
    int testGCD4 = 0;
    int gcd2 = Operations.greatestCommonDivisor(testGCD3, testGCD4);
    assertEquals(25, gcd2);
  }

  /**
   * Tests the multiply function.
   */

  @Test
  void testMultiply()
  {
    MixedFraction testFraction1 = new MixedFraction(2, 1, 2);
    MixedFraction testFraction2 = new MixedFraction(3, 2, 3);
    MixedFraction multiplyTest1 = Operations.multiply(testFraction1, testFraction2);
    assertEquals(9, multiplyTest1.getWholeNumber());
    assertEquals(1, multiplyTest1.getNumerator());
    assertEquals(6, multiplyTest1.getDenominator());
    MixedFraction testFraction3 = new MixedFraction(-2, 1, 2);
    MixedFraction testFraction4 = new MixedFraction(3, 2, 5);
    MixedFraction multiplyTest2 = Operations.multiply(testFraction3, testFraction4).simplify();
    assertEquals(-8, multiplyTest2.getWholeNumber());
    assertEquals(1, multiplyTest2.getNumerator());
    assertEquals(2, multiplyTest2.getDenominator());
    MixedFraction testFraction5 = new MixedFraction(-2, 1, 2);
    MixedFraction testFraction6 = new MixedFraction(-3, 1, 2);
    MixedFraction multiplyTest3 = Operations.multiply(testFraction5, testFraction6);
    assertEquals(8, multiplyTest3.getWholeNumber());
    assertEquals(3, multiplyTest3.getNumerator());
    assertEquals(4, multiplyTest3.getDenominator());
  }

  /**
   * Tests the divide function.
   */

  @Test
  void testDivide()
  {
    MixedFraction testFraction1 = new MixedFraction(2, 1, 2);
    MixedFraction testFraction2 = new MixedFraction(3, 2, 3);
    MixedFraction divideTest1 = Operations.divide(testFraction1, testFraction2);
    assertEquals(0, divideTest1.getWholeNumber());
    assertEquals(15, divideTest1.getNumerator());
    assertEquals(22, divideTest1.getDenominator());
    MixedFraction testFraction3 = new MixedFraction(-2, 1, 2);
    MixedFraction testFraction4 = new MixedFraction(3, 2, 5);
    MixedFraction divideTest2 = Operations.divide(testFraction3, testFraction4);
    assertEquals(0, divideTest2.getWholeNumber());
    assertEquals(-25, divideTest2.getNumerator());
    assertEquals(34, divideTest2.getDenominator());
    MixedFraction testFraction5 = new MixedFraction(-2, 1, 2);
    MixedFraction testFraction6 = new MixedFraction(-3, 1, 2);
    MixedFraction divideTest3 = Operations.divide(testFraction5, testFraction6).simplify();
    assertEquals(0, divideTest3.getWholeNumber());
    assertEquals(5, divideTest3.getNumerator());
    assertEquals(7, divideTest3.getDenominator());
  }

  /**
   * Tests the subtract function.
   */

  @Test
  void testSubtract()
  {
    MixedFraction testFraction1 = new MixedFraction(2, 1, 2);
    MixedFraction testFraction2 = new MixedFraction(3, 2, 3);
    MixedFraction subTest1 = Operations.subtract(testFraction1, testFraction2);
    assertEquals(-1, subTest1.getWholeNumber());
    assertEquals(1, subTest1.getNumerator());
    assertEquals(6, subTest1.getDenominator());
    MixedFraction testFraction3 = new MixedFraction(-2, 1, 2);
    MixedFraction testFraction4 = new MixedFraction(3, 2, 5);
    MixedFraction subTest2 = Operations.subtract(testFraction3, testFraction4);
    assertEquals(-5, subTest2.getWholeNumber());
    assertEquals(9, subTest2.getNumerator());
    assertEquals(10, subTest2.getDenominator());
    MixedFraction testFraction5 = new MixedFraction(-2, 1, 2);
    MixedFraction testFraction6 = new MixedFraction(-3, 1, 2);
    MixedFraction subTest3 = Operations.subtract(testFraction5, testFraction6).simplify();
    assertEquals(1, subTest3.getWholeNumber());
    assertEquals(0, subTest3.getNumerator());
    assertEquals(1, subTest3.getDenominator());
    MixedFraction testFraction7 = new MixedFraction(2, 1, 2);
    MixedFraction testFraction8 = new MixedFraction(-3, 1, 2);
    MixedFraction subTest4 = Operations.subtract(testFraction7, testFraction8).simplify();
    assertEquals(6, subTest4.getWholeNumber());
    assertEquals(0, subTest4.getNumerator());
    assertEquals(1, subTest4.getDenominator());
  }

  /**
   * Tests the addition function.
   */

  @Test
  void testAdd()
  {
    MixedFraction testFraction1 = new MixedFraction(2, 1, 2);
    MixedFraction testFraction2 = new MixedFraction(3, 2, 3);
    MixedFraction addTest1 = Operations.add(testFraction1, testFraction2);
    assertEquals(6, addTest1.getWholeNumber());
    assertEquals(1, addTest1.getNumerator());
    assertEquals(6, addTest1.getDenominator());
    MixedFraction testFraction3 = new MixedFraction(-2, 1, 2);
    MixedFraction testFraction4 = new MixedFraction(3, 2, 5);
    MixedFraction addTest2 = Operations.add(testFraction3, testFraction4);
    assertEquals(0, addTest2.getWholeNumber());
    assertEquals(9, addTest2.getNumerator());
    assertEquals(10, addTest2.getDenominator());
    MixedFraction testFraction5 = new MixedFraction(-2, 1, 2);
    MixedFraction testFraction6 = new MixedFraction(-3, 1, 2);
    MixedFraction addTest3 = Operations.add(testFraction5, testFraction6).simplify();
    assertEquals(-6, addTest3.getWholeNumber());
    assertEquals(0, addTest3.getNumerator());
    assertEquals(1, addTest3.getDenominator());
    MixedFraction testFraction7 = new MixedFraction(2, 1, 2);
    MixedFraction testFraction8 = new MixedFraction(-3, 2, 5);
    MixedFraction addTest4 = Operations.add(testFraction7, testFraction8);
    assertTrue(addTest4.isNegative());
    assertEquals(0, addTest4.getWholeNumber());
    assertEquals(-9, addTest4.getNumerator());
    assertEquals(10, addTest4.getDenominator());
    MixedFraction testFraction9 = new MixedFraction(2, 1, 2);
    MixedFraction testFraction10 = new MixedFraction(5, 1, 7);
    MixedFraction addTest5 = Operations.subtract(testFraction9, testFraction10);
    assertEquals(-2, addTest5.getWholeNumber());
    assertEquals(9, addTest5.getNumerator());
    assertEquals(14, addTest5.getDenominator());

    MixedFraction notSimplified = new MixedFraction(2, 2, 4);
    MixedFraction notSimplified2 = new MixedFraction(3, 9, 3);

    MixedFraction notSimplifiedSum = Operations.add(notSimplified, notSimplified2);

    assertEquals(8, notSimplifiedSum.getWholeNumber());
    assertEquals(6, notSimplifiedSum.getNumerator());
    assertEquals(12, notSimplifiedSum.getDenominator());
  }

  /**
   * Tests the EvaluateCurrentExpression function.
   */
  @Test
  void testEvaluateCurrentExpression()
  {
    String testString1 = "5 3/8 × 2 1/2 ";
    MixedFraction testEvaluate1 = Operations.evaluteCurrentExpression(testString1);
    assertEquals(13, testEvaluate1.getWholeNumber());
    assertEquals(7, testEvaluate1.getNumerator());
    assertEquals(16, testEvaluate1.getDenominator());
    String testString2 = "5 3/8 ÷ 2 1/2 ";
    MixedFraction testEvaluate2 = Operations.evaluteCurrentExpression(testString2).simplify();
    assertEquals(2, testEvaluate2.getWholeNumber());
    assertEquals(3, testEvaluate2.getNumerator());
    assertEquals(20, testEvaluate2.getDenominator());
    String testString3 = "5 3/8 + 2 1/2 ";
    MixedFraction testEvaluate3 = Operations.evaluteCurrentExpression(testString3);
    assertEquals(7, testEvaluate3.getWholeNumber());
    assertEquals(7, testEvaluate3.getNumerator());
    assertEquals(8, testEvaluate3.getDenominator());
    String testString4 = "5 3/8 - 2 1/2 ";
    MixedFraction testEvaluate4 = Operations.evaluteCurrentExpression(testString4);
    assertEquals(2, testEvaluate4.getWholeNumber());
    assertEquals(7, testEvaluate4.getNumerator());
    assertEquals(8, testEvaluate4.getDenominator());
    String testString5 = "5 3/8 ^ 2";
    MixedFraction testEvaluate5 = Operations.evaluteCurrentExpression(testString5);
    assertEquals(28, testEvaluate5.getWholeNumber());
    assertEquals(57, testEvaluate5.getNumerator());
    assertEquals(64, testEvaluate5.getDenominator());
  }

  @Test
  void testIntegerPower()
  {
    MixedFraction testFraction1 = new MixedFraction(2, 1, 2);
    MixedFraction iPTest1 = Operations.integerPower(testFraction1, 2);
    assertEquals(6, iPTest1.getWholeNumber());
    assertEquals(1, iPTest1.getNumerator());
    assertEquals(4, iPTest1.getDenominator());

    MixedFraction testFraction2 = new MixedFraction(3, 2, 3);
    MixedFraction iPTest2 = Operations.integerPower(testFraction2, 3);
    assertEquals(49, iPTest2.getWholeNumber());
    assertEquals(8, iPTest2.getNumerator());
    assertEquals(27, iPTest2.getDenominator());

    MixedFraction testFraction3 = new MixedFraction(3, 2, 3);
    MixedFraction iPTest3 = Operations.integerPower(testFraction3, -3);
    assertEquals(0, iPTest3.getWholeNumber());
    assertEquals(27, iPTest3.getNumerator());
    assertEquals(1331, iPTest3.getDenominator());

    MixedFraction testFraction4 = new MixedFraction(3, 2, 3);
    MixedFraction iPTest4 = Operations.integerPower(testFraction4, 0);
    assertEquals(1, iPTest4.getWholeNumber());
    assertEquals(0, iPTest4.getNumerator());
    assertEquals(testFraction4.getDenominator(), iPTest4.getDenominator());
  }

  @Test
  void testUpdateMixedFraction()
  {
    MixedFraction testFraction1 = new MixedFraction(2, 82, 8);
    testFraction1.updateMixedFraction();
    testFraction1 = testFraction1.simplify();
    assertEquals(12, testFraction1.getWholeNumber());
    assertEquals(1, testFraction1.getNumerator());
    assertEquals(4, testFraction1.getDenominator());

    MixedFraction testFraction2 = new MixedFraction(2, 2082, 1040);
    testFraction2.updateMixedFraction();
    testFraction2 = testFraction2.simplify();
    assertEquals(4, testFraction2.getWholeNumber());
    assertEquals(1, testFraction2.getNumerator());
    assertEquals(520, testFraction2.getDenominator());
  }

  @Test
  void testInvertFraction()
  {
    MixedFraction testFraction1 = new MixedFraction(2, 82, 8);
    MixedFraction iPTest1 = Operations.invertFraction(testFraction1).simplify();
    assertEquals(0, iPTest1.getWholeNumber());
    assertEquals(4, iPTest1.getNumerator());
    assertEquals(49, iPTest1.getDenominator());

    MixedFraction testFraction2 = new MixedFraction(2, 2082, 1040);
    MixedFraction iPTest2 = Operations.invertFraction(testFraction2).simplify();
    assertEquals(0, iPTest2.getWholeNumber());
    assertEquals(520, iPTest2.getNumerator());
    assertEquals(2081, iPTest2.getDenominator());
  }

  @Test
  void testReduceFraction()
  {
    MixedFraction bigFraction = new MixedFraction(2, 5, 4);
    bigFraction = Operations.reduceFraction(bigFraction);
    assertEquals(3, bigFraction.getWholeNumber());
    assertEquals(1, bigFraction.getNumerator());
    assertEquals(4, bigFraction.getDenominator());
  }

  @Test
  void testMediant()
  {
    MixedFraction mf1 = new MixedFraction(5, 1, 2);
    MixedFraction mf2 = new MixedFraction(3, 5, 8);

    Fraction mediant1 = Operations.mediant(mf1, mf2).convertToFraction();
    assertEquals(40, mediant1.getNumerator());
    assertEquals(10, mediant1.getDenominator());

    MixedFraction mf3 = new MixedFraction(-5, 1, 2);

    Fraction mediant2 = Operations.mediant(mf2, mf3).convertToFraction();
    assertEquals(18, mediant2.getNumerator());
    assertEquals(10, mediant2.getDenominator());

  }

  @Test
  void testComparisonOperations()
  {
    MixedFraction trueIndicator = new MixedFraction(1, null, null);
    MixedFraction falseIndicator = new MixedFraction(0, null, null);

    MixedFraction mf1 = new MixedFraction(1, 1, 2);
    MixedFraction mf2 = new MixedFraction(1, 0, 2);

    assertTrue(Operations.greaterThan(mf1, mf2).equals(trueIndicator));
    assertFalse(Operations.greaterThan(mf1, mf2).equals(falseIndicator));
    assertTrue(Operations.greaterThan(mf2, mf1).equals(falseIndicator));
    
    
    assertTrue(Operations.lessThan(mf2, mf1).equals(trueIndicator));
    assertFalse(Operations.lessThan(mf2, mf1).equals(falseIndicator));
    assertTrue(Operations.lessThan(mf1, mf2).equals(falseIndicator));
    


    mf1 = new MixedFraction(-3, 1, 2);
    mf2 = new MixedFraction(-5, 3, 2);
    
    assertTrue(Operations.greaterThan(mf1, mf2).equals(trueIndicator));
    assertFalse(Operations.greaterThan(mf1, mf2).equals(falseIndicator));
    assertTrue(Operations.greaterThan(mf2, mf1).equals(falseIndicator));
    
    
    assertTrue(Operations.lessThan(mf2, mf1).equals(trueIndicator));
    assertFalse(Operations.lessThan(mf2, mf1).equals(falseIndicator));
    assertTrue(Operations.lessThan(mf1, mf2).equals(falseIndicator));
  }
  
  @Test
  void testEqualityOperation() 
  {
    
    MixedFraction trueIndicator = new MixedFraction(1, null, null);
    MixedFraction falseIndicator = new MixedFraction(0, null, null);
    
    MixedFraction mf1 = new MixedFraction(1, 1, 2);
    MixedFraction mf2 = new MixedFraction(1, 1, 2);
    
    assertTrue(Operations.equalTo(mf1, mf2).equals(trueIndicator));
    assertFalse(Operations.equalTo(mf1, mf2).equals(falseIndicator));
    
    
    mf2 = new MixedFraction(0, 3, 2);
    assertTrue(Operations.equalTo(mf1, mf2).equals(trueIndicator));
    assertFalse(Operations.equalTo(mf1, mf2).equals(falseIndicator));
    
    mf2 = new MixedFraction(5, 1, 2);
    assertFalse(Operations.equalTo(mf1, mf2).equals(trueIndicator));
    assertTrue(Operations.equalTo(mf1, mf2).equals(falseIndicator));
    
    
   
  }

}
