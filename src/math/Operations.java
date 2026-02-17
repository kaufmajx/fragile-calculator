package math;

import java.util.ArrayList;
import java.util.Locale;

import gui.FragileCalculator;

/**
 * A class for handling operations done with mixed fractions.
 * 
 * @author Jelal Kaufman, Joseph Linneman
 * @version 11/2/23 Honor Code: This work complies with JMU's Honor Code:3 3,
 */
public class Operations
{

  private static String operationsRegex = "\\+|-(?!\\d)|×|÷|\\^|⇹|=|<|>|≝";
  private static ArrayList<String> intermediateSteps = new ArrayList<String>();
  private static final String ENGLISH = "English";
  private static final String FRENCH = "français";
  private static final String GERMAN = "Deutsch";
  private static final String DOUBLE_NEWLINE = "\n\n";
  private static final String INT_PRODUCT = "%d × %d = %d\n";

  /**
   * Gets the regular expression used for parsing expressions.
   * 
   * @return The regex
   */
  public static String getOperationsRegex()
  {
    return operationsRegex;
  }

  /**
   * This method computes the LCM of two integers.
   * 
   * @param x
   *          The first integer parameter.
   * @param y
   *          The second integer parameter.
   * @return The LCM of the two integers.
   */
  public static int leastCommonMultiple(final int x, final int y)
  {

    int lcm;

    if (x > y)
      lcm = x;
    else
      lcm = y;

    while (true)
    {
      if (lcm % x == 0 && lcm % y == 0)
        return lcm;
      lcm++;
    }

  }

  /**
   * This method finds the GCD of two integers.
   * 
   * @param x
   *          The first integer.
   * @param y
   *          The second integer.
   * @return The GCD of the two integers.
   */
  public static int greatestCommonDivisor(final int x, final int y)
  {
    int newX = x;
    int newY = y;
    while (newY != 0)
    {
      int temp = newY;
      newY = newX % newY;
      newX = temp;
    }
    return newX;

  }

  /**
   * This method multiplies two MixedFractions together.
   * 
   * @param x
   *          The first MixedFraction .
   * @param y
   *          The second MixedFraction.
   * @return A new MixedFraction with the value of the product of the two inputed MixedFractions.
   */
  public static MixedFraction multiply(final MixedFraction x, final MixedFraction y)
  {
    String language = Locale.getDefault().getDisplayLanguage();

    clearIntermediateSteps();
    Fraction xImproper = x.convertToFraction();
    Fraction yImproper = y.convertToFraction();

    intermediateSteps.add(demonstrateFractionConversion(x, language));
    intermediateSteps.add(demonstrateFractionConversion(y, language));

    int xImproperNumerator = xImproper.getNumerator();
    int yImproperNumerator = yImproper.getNumerator();

    int xImproperDenominator = xImproper.getDenominator();
    int yImproperDenominator = yImproper.getDenominator();

    int productNumerator = xImproperNumerator * yImproperNumerator;
    int productDenominator = xImproperDenominator * yImproperDenominator;

    Fraction product = new Fraction(productNumerator, productDenominator);

    switch (language)
    {
      case (ENGLISH):

        intermediateSteps.add(String.format(
            "Multiply the numerators to get the numerator of the product: " + INT_PRODUCT,
            xImproperNumerator, yImproperNumerator, productNumerator));
        intermediateSteps.add(String.format(
            "Multiply the denominators to get the denominator of the product: " + INT_PRODUCT,
            xImproperDenominator, yImproperDenominator, productDenominator));
        intermediateSteps
            .add("So, the fraction " + "form of the product is " + product + DOUBLE_NEWLINE);
        break;
      case (GERMAN):

        intermediateSteps.add(String.format(
            "Multiplizieren Sie die Zähler, um den Zähler des Produkts zu erhalten: " + INT_PRODUCT,
            xImproperNumerator, yImproperNumerator, productNumerator));
        intermediateSteps.add(String.format(
            "Multiplizieren Sie die Nenner, um den Nenner des Produkts zu erhalten: " + INT_PRODUCT,
            xImproperDenominator, yImproperDenominator, productDenominator));
        intermediateSteps.add("Die Bruchform des Produkts ist also " + product + DOUBLE_NEWLINE);
        break;
      case (FRENCH):

        intermediateSteps.add(String.format(
            "Multipliez les numérateurs pour obtenir le numérateur du produit : " + INT_PRODUCT,
            xImproperNumerator, yImproperNumerator, productNumerator));
        intermediateSteps.add(String.format(
            "Multipliez les dénominateurs pour obtenir le dénominateur du produit : " + INT_PRODUCT,
            xImproperDenominator, yImproperDenominator, productDenominator));
        intermediateSteps
            .add("Ainsi, la forme fractionnaire" + " du produit est " + product + DOUBLE_NEWLINE);
        break;
      default:
        return null;
    }

    return product.convertToMixedFraction();
  }

  /**
   * This method divides the first MixedFraction by the other MixedFraction.
   * 
   * @param x
   *          The first MixedFraction .
   * @param y
   *          The second MixedFraction.
   * @return A new MixedFraction with the value of the quotient of the two inputed MixedFractions.
   */
  public static MixedFraction divide(final MixedFraction x, final MixedFraction y)
  {
    String language = Locale.getDefault().getDisplayLanguage();

    clearIntermediateSteps();
    Fraction xImproper = x.convertToFraction();
    Fraction yImproper = y.convertToFraction();

    intermediateSteps.add(demonstrateFractionConversion(x, language));
    intermediateSteps.add(demonstrateFractionConversion(y, language));

    int xImproperNumerator = xImproper.getNumerator();
    int yImproperNumerator = yImproper.getNumerator();

    int xImproperDenominator = xImproper.getDenominator();
    int yImproperDenominator = yImproper.getDenominator();

    int quotientNumerator = xImproperNumerator * yImproperDenominator;
    int quotientDenominator = xImproperDenominator * yImproperNumerator;

    Fraction quotient = new Fraction(quotientNumerator, quotientDenominator);

    switch (language)
    {
      case (ENGLISH):

        intermediateSteps.add(String.format(
            "To get the numerator of the quotient, "
                + "multiply the numerator of the first operand "
                + "by the denominator of the second operand: " + INT_PRODUCT,
            xImproperNumerator, yImproperDenominator, quotientNumerator));

        intermediateSteps.add(String.format(
            "To get the denominator of the quotient, "
                + "multiply the denominator of the first operand "
                + "by the numerator of the second operand: " + INT_PRODUCT,
            xImproperDenominator, yImproperNumerator, quotientDenominator));

        intermediateSteps.add(String.format(
            "So, the fraction form of " + "the quotient is: %s " + DOUBLE_NEWLINE, quotient));
        break;
      case (GERMAN):

        intermediateSteps.add(String.format(
            "Um den Zähler des Quotienten zu erhalten, multiplizieren Sie den Zähler "
                + "des ersten Operanden mit dem Nenner des zweiten Operanden: " + INT_PRODUCT,
            xImproperNumerator, yImproperDenominator, quotientNumerator));

        intermediateSteps.add(String.format(
            "Um den Nenner des Quotienten zu erhalten, multiplizieren Sie den Nenner des "
                + "ersten Operanden mit dem Zähler des zweiten Operanden: " + INT_PRODUCT,
            xImproperDenominator, yImproperNumerator, quotientDenominator));

        intermediateSteps.add(String
            .format("Die Bruchform des " + "Quotienten ist also: %s " + DOUBLE_NEWLINE, quotient));
        break;

      case (FRENCH):

        intermediateSteps.add(String.format(
            "Pour obtenir le numérateur du quotient, multipliez le numérateur du premier "
                + "opérande par le dénominateur du deuxième opérande : " + INT_PRODUCT,
            xImproperNumerator, yImproperDenominator, quotientNumerator));

        intermediateSteps.add(String.format(
            "Pour obtenir le dénominateur du quotient, "
                + "multipliez le dénominateur du premier opérande par "
                + "le numérateur du deuxième opérande : " + INT_PRODUCT,
            xImproperDenominator, yImproperNumerator, quotientDenominator));

        intermediateSteps.add(String.format(
            "Ainsi, la forme fractionnaire " + "du quotient est : %s " + DOUBLE_NEWLINE, quotient));
        break;

      default:
        return null;
    }

    return quotient.convertToMixedFraction();
  }

  /**
   * This method adds two MixedFractions Together.
   * 
   * @param x
   *          The first MixedFraction .
   * @param y
   *          The second MixedFraction.
   * @return A new MixedFraction with the value of the sum of the two inputed MixedFractions.
   */
  public static MixedFraction add(final MixedFraction x, final MixedFraction y)
  {
    String language = Locale.getDefault().getDisplayLanguage();

    clearIntermediateSteps();

    Fraction xImproper = x.convertToFraction();
    Fraction yImproper = y.convertToFraction();

    intermediateSteps.add(demonstrateFractionConversion(x, language));
    intermediateSteps.add(demonstrateFractionConversion(y, language));

    int lcm = Operations.leastCommonMultiple(xImproper.getDenominator(),
        yImproper.getDenominator());

    Fraction xStandardized = xImproper.standardize(lcm / xImproper.getDenominator());
    Fraction yStandardized = yImproper.standardize(lcm / yImproper.getDenominator());

    intermediateSteps
        .add(demonstrateFractionStandardize(xImproper, lcm / xImproper.getDenominator(), language));
    intermediateSteps
        .add(demonstrateFractionStandardize(yImproper, lcm / yImproper.getDenominator(), language));

    int numeratorSum = xStandardized.getNumerator() + yStandardized.getNumerator();
    Fraction sum = new Fraction(numeratorSum, xStandardized.getDenominator());

    switch (language)
    {
      case (ENGLISH):
        intermediateSteps.add(String.format(
            "Then, add the numerators together, and place "
                + "that sum over the denominator to get the sum: %d + %d = %d; sum: %s",
            xStandardized.getNumerator(), yStandardized.getNumerator(), numeratorSum, sum));
        break;
      case (GERMAN):
        intermediateSteps.add(String.format(
            "Addieren Sie dann die Zähler und setzen Sie diese Summe über den "
                + "Nenner, um die Summe zu erhalten: %d + %d = %d; summe: %s",
            xStandardized.getNumerator(), yStandardized.getNumerator(), numeratorSum, sum));
        break;
      case (FRENCH):
        intermediateSteps.add(String.format(
            "Ensuite, additionnez les numérateurs et placez cette somme sur le dénominateur "
                + "pour obtenir la somme: %d + %d = %d; somme: %s",
            xStandardized.getNumerator(), yStandardized.getNumerator(), numeratorSum, sum));
        break;

      default:
        return null;
    }

    return new Fraction(xStandardized.getNumerator() + yStandardized.getNumerator(),
        xStandardized.getDenominator()).convertToMixedFraction();
  }

  /**
   * This method Subracts the first MixedFraction by the second Mixed Fraction.
   * 
   * @param x
   *          The first MixedFraction .
   * @param y
   *          The second MixedFraction.
   * @return A new MixedFraction with the value of the subtraction of the two inputed
   *         MixedFractions.
   */
  public static MixedFraction subtract(final MixedFraction x, final MixedFraction y)
  {

    String language = Locale.getDefault().getDisplayLanguage();

    clearIntermediateSteps();

    Fraction xImproper = x.convertToFraction();
    Fraction yImproper = y.convertToFraction();

    intermediateSteps.add(demonstrateFractionConversion(x, language));
    intermediateSteps.add(demonstrateFractionConversion(y, language));

    int lcm = Operations.leastCommonMultiple(xImproper.getDenominator(),
        yImproper.getDenominator());

    Fraction xStandardized = xImproper.standardize(lcm / xImproper.getDenominator());
    Fraction yStandardized = yImproper.standardize(lcm / yImproper.getDenominator());

    intermediateSteps.add(String.format(
        "Find the LCM of the " + "denominators of the two fractions: %d" + DOUBLE_NEWLINE, lcm));
    intermediateSteps
        .add(String.format(
            "Standardize the first fraction " + "with the factor %d / denominator (%d) = %d"
                + DOUBLE_NEWLINE,
            lcm, xImproper.getDenominator(), lcm / xImproper.getDenominator()));
    intermediateSteps
        .add(demonstrateFractionStandardize(xImproper, lcm / xImproper.getDenominator(), language));
    intermediateSteps
        .add(String.format(
            "Standardize the second fraction with the " + "factor %d / denominator (%d) = %d"
                + DOUBLE_NEWLINE,
            lcm, yImproper.getDenominator(), lcm / yImproper.getDenominator()));
    intermediateSteps
        .add(demonstrateFractionStandardize(yImproper, lcm / yImproper.getDenominator(), language));

    int numeratorDifference = xStandardized.getNumerator() - yStandardized.getNumerator();

    Fraction difference = new Fraction(xStandardized.getNumerator() - yStandardized.getNumerator(),
        xStandardized.getDenominator());

    switch (language)
    {
      case (ENGLISH):
        intermediateSteps.add(String.format(
            "Then, subtract the numerators, and place that " + "difference over the denominator to "
                + "get the difference: %d - %d = %d; difference: %s\n",
            xStandardized.getNumerator(), yStandardized.getNumerator(), numeratorDifference,
            difference));
        break;
      case (GERMAN):
        intermediateSteps.add(String.format(
            "Subtrahieren Sie dann die Zähler und setzen Sie die "
                + "Differenz über den Nenner, um die Differenz zu "
                + "erhalten: %d - %d = %d; Differenz: %s" + DOUBLE_NEWLINE,
            xStandardized.getNumerator(), yStandardized.getNumerator(), numeratorDifference,
            difference));
        break;
      case (FRENCH):
        intermediateSteps.add(String.format(
            "Ensuite, soustrayez les numérateurs et placez cette "
                + "différence sur le dénominateur pour obtenir la "
                + "différence : %d - %d = %d; différence: %s" + DOUBLE_NEWLINE,
            xStandardized.getNumerator(), yStandardized.getNumerator(), numeratorDifference,
            difference));
        break;

      default:
        return null;
    }

    return difference.convertToMixedFraction();
  }

  /**
   * Evaluates the expression encoded in the provided string.
   * 
   * @param expression
   *          The expression to parse
   * @return the Mixed Fraction evaluation of the expression
   */
  public static MixedFraction evaluteCurrentExpression(final String expression)
  {
    String temp = expression;
    temp = expression.replaceAll(FragileCalculator.FOCUS, "");

    String[] expressionComponents = temp.split(operationsRegex);

    char operation = temp.charAt(expressionComponents[0].length());

    String firstOperand = expressionComponents[0].substring(0,
        expressionComponents[0].length() - 1);
    firstOperand = FragileCalculator.remove(firstOperand);

    String secondOperand = expressionComponents[1].substring(1);
    secondOperand = FragileCalculator.remove(secondOperand);

    MixedFraction leftOperand = MixedFraction.parseMixedFractionFromString(firstOperand);
    MixedFraction rightOperand = MixedFraction.parseMixedFractionFromString(secondOperand);

    MixedFraction evaluation = null;

    switch (operation)
    {
      case ('+'):
        evaluation = Operations.add(leftOperand, rightOperand);
        break;
      case ('-'):
        evaluation = Operations.subtract(leftOperand, rightOperand);
        break;

      case ('×'):
        evaluation = Operations.multiply(leftOperand, rightOperand);
        break;

      case ('÷'):
        evaluation = Operations.divide(leftOperand, rightOperand);
        break;

      case ('⇹'):
        evaluation = Operations.mediant(leftOperand, rightOperand);
        break;

      case ('>'):
        evaluation = Operations.greaterThan(leftOperand, rightOperand);
        break;

      case ('<'):
        evaluation = Operations.lessThan(leftOperand, rightOperand);
        break;

      case ('≝'):
        evaluation = Operations.equalTo(leftOperand, rightOperand);
        break;

      default:
        evaluation = Operations.integerPower(leftOperand, rightOperand.getWholeNumber());
    }
    return evaluation;
  }

  /**
   * Raises the provided mixed fraction to the provided integer power.
   * 
   * @param mf
   *          The mixed fraction
   * @param power
   *          The power to raise it to
   * @return The result of this operation
   */
  public static MixedFraction integerPower(final MixedFraction mf, final int power)
  {
    String language = Locale.getDefault().getDisplayLanguage();

    int newNum;
    int newDen;
    Fraction iF = mf.convertToFraction();
    intermediateSteps.add(demonstrateFractionConversion(mf, language));

    if (power > 0)
    {

      switch (language)
      {
        case (ENGLISH):
          intermediateSteps.add(String.format(
              "To get the numerator of the result, "
                  + "raise the numerator %d to the power of %d: %.0f\n",
              iF.getNumerator(), power, Math.pow(iF.getNumerator(), power)));

          intermediateSteps.add(String.format(
              "To get the denominator of the result, raise "
                  + "the denominator %d to the power of %d: %.0f\n",
              iF.getDenominator(), power, Math.pow(iF.getDenominator(), power)));
          break;

        case (GERMAN):
          intermediateSteps.add(String.format(
              "Um den Zähler des Ergebnisses zu erhalten, Erhöhe den Zähler %d mit %d: %.0f\n",
              iF.getNumerator(), power, Math.pow(iF.getNumerator(), power)));

          intermediateSteps.add(String.format(
              "Um den Nenner des Ergebnisses zu erhalten, erhöhen Sie den Nenner %d mit %d: %.0f\n",
              iF.getDenominator(), power, Math.pow(iF.getDenominator(), power)));
          break;

        case (FRENCH):
          intermediateSteps.add(String.format(
              "Pour obtenir le numérateur du résultat, "
                  + "augmentez le numérateur %d à la puissance %d : %.0f\n",
              iF.getNumerator(), power, Math.pow(iF.getNumerator(), power)));

          intermediateSteps.add(String.format(
              "Pour obtenir le dénominateur du résultat, augmentez le "
                  + "dénominateur %d à la puissance %d : %.0f\n",
              iF.getDenominator(), power, Math.pow(iF.getDenominator(), power)));
          break;

        default:
          return null;
      }

      newNum = (int) Math.pow(iF.getNumerator(), power);
      newDen = (int) Math.pow(iF.getDenominator(), power);
    }
    else if (power == 0)
    {

      switch (language)
      {
        case (ENGLISH):
          intermediateSteps.add("Any number to the power of 0 is 1. \n");
          break;

        case (GERMAN):
          intermediateSteps.add("Jede Zahl hoch 0 ist 1. \n");
          break;

        case (FRENCH):
          intermediateSteps.add("Tout nombre à la puissance 0 vaut 1. \n");
          break;
        default:
          intermediateSteps.add(null);

      }

      return new MixedFraction(1, 0, mf.getDenominator());
    }
    else
    {
      int newPower = Math.abs(power);

      switch (language)
      {
        case (ENGLISH):
          intermediateSteps.add(String.format(
              "To get the numerator of the result,"
                  + " raise the denominator %d to the power of %d: %.0f \n",
              iF.getDenominator(), newPower, Math.pow(iF.getDenominator(), newPower)));

          intermediateSteps.add(String.format(
              "To get the denominator of the result, "
                  + "raise the numerator %d to the power of %d: %.0f \n",
              iF.getNumerator(), newPower, Math.pow(iF.getNumerator(), newPower)));
          break;

        case (GERMAN):
          intermediateSteps.add(String.format(
              "Um den Zähler des Ergebnisses zu erhalten, "
                  + "erhöhen Sie den Nenner %d auf die Potenz von %d: %.0f \n",
              iF.getDenominator(), newPower, Math.pow(iF.getDenominator(), newPower)));

          intermediateSteps.add(String.format(
              "Um den Nenner des Ergebnisses zu erhalten, "
                  + "erhöhen Sie den Zähler %d auf die Potenz von %d: %.0f \n",
              iF.getNumerator(), newPower, Math.pow(iF.getNumerator(), newPower)));
          break;

        case (FRENCH):
          intermediateSteps.add(String.format(
              "Pour obtenir le numérateur du résultat, augmentez "
                  + "le dénominateur %d à la puissance %d : %.0f \n",
              iF.getDenominator(), newPower, Math.pow(iF.getDenominator(), newPower)));

          intermediateSteps.add(String.format(
              "Pour obtenir le dénominateur du résultat, "
                  + "augmentez le numérateur %d à la puissance %d : %.0f \n",
              iF.getNumerator(), newPower, Math.pow(iF.getNumerator(), newPower)));
          break;

        default:
          return null;
      }

      newNum = (int) Math.pow(iF.getDenominator(), newPower);
      newDen = (int) Math.pow(iF.getNumerator(), newPower);
    }

    iF.setNumerator(newNum);
    iF.setDenominator(newDen);
    switch (language)
    {
      case (ENGLISH):
        intermediateSteps.add(String.format("So, the resulting fraction is: %s\n", iF));
        break;
      case (GERMAN):
        intermediateSteps.add(String.format("Der resultierende Bruch ist also: %s\n", iF));
        break;

      case (FRENCH):
        intermediateSteps.add(String.format("La fraction résultante est donc : %s\n", iF));
        break;

      default:
        intermediateSteps.add(null);

    }
    return iF.convertToMixedFraction();
  }

  /**
   * Finds the reciprocal of the mixed fraction.
   * 
   * @param mF
   *          The mixed fraction to reciprocate
   * @return The result of this operation
   */
  public static MixedFraction invertFraction(final MixedFraction mF)
  {
    Fraction iF = mF.convertToFraction();
    Fraction invertedIF = new Fraction(iF.getDenominator(), iF.getNumerator());
    MixedFraction invertedMF = invertedIF.convertToMixedFraction();
    return invertedMF;
  }

  /**
   * Converts the mixed fraction to reduced form.
   * 
   * @param mF
   *          The mixed fraction to reduce
   * @return The reduced mixed fraction
   */
  public static MixedFraction reduceFraction(final MixedFraction mF)
  {
    Fraction tempIF = mF.convertToFraction();
    MixedFraction reducedMF = tempIF.convertToMixedFraction();
    return reducedMF;
  }

  /**
   * Finds the mediant of the provided two mixed fractions.
   * 
   * @param x
   * @param y
   * @return The mediant
   */

  public static MixedFraction mediant(final MixedFraction x, final MixedFraction y)
  {
    String language = Locale.getDefault().getDisplayLanguage();

    clearIntermediateSteps();

    Fraction xFrac = x.convertToFraction();
    Fraction yFrac = y.convertToFraction();

    intermediateSteps.add(demonstrateFractionConversion(x, language));
    intermediateSteps.add(demonstrateFractionConversion(y, language));

    int mediantNumerator = xFrac.getNumerator() + yFrac.getNumerator();
    int mediantDenominator = xFrac.getDenominator() + yFrac.getDenominator();

    switch (language)
    {
      case (ENGLISH):
        intermediateSteps.add(String.format(
            "To find the numerator of the mediant, "
                + "simply add the numerators of the two operands: %d + %d = %d\n",
            xFrac.getNumerator(), yFrac.getNumerator(), mediantNumerator));

        intermediateSteps.add(String.format(
            "To find the denominator of the mediant, "
                + "simply add the denominators of the two operands: %d + %d = %d\n",
            xFrac.getDenominator(), yFrac.getDenominator(), mediantDenominator));
        break;
      case (GERMAN):
        intermediateSteps.add(String.format(
            "Um den Zähler des Medianten zu finden, "
                + "Addieren Sie einfach die Zähler der beiden Operanden: %d + %d = %d\n",
            xFrac.getNumerator(), yFrac.getNumerator(), mediantNumerator));

        intermediateSteps.add(String.format(
            "Um den Nenner des Medianten zu finden, "
                + "Addieren Sie einfach die Nenner der beiden Operanden: %d + %d = %d\n",
            xFrac.getDenominator(), yFrac.getDenominator(), mediantDenominator));
        break;
      case (FRENCH):
        intermediateSteps.add(String.format(
            "Pour trouver le numérateur du médiant, "
                + "additionnez simplement les numérateurs des deux opérandes : %d + %d = %d\n",
            xFrac.getNumerator(), yFrac.getNumerator(), mediantNumerator));

        intermediateSteps.add(String.format(
            "Pour trouver le dénominateur du médiant, "
                + "additionnez simplement les dénominateurs des deux opérandes : %d + %d = %d\n",
            xFrac.getDenominator(), yFrac.getDenominator(), mediantDenominator));
        break;

      default:
        intermediateSteps.add(null);
    }

    Fraction resultFraction = new Fraction(mediantNumerator, mediantDenominator);

    switch (language)
    {
      case (ENGLISH):
        intermediateSteps.add(String.format("So, the result is: %s\n", resultFraction));
        break;
      case (GERMAN):
        intermediateSteps.add(String.format("Das Ergebnis ist also: %s\n", resultFraction));
        break;
      case (FRENCH):
        intermediateSteps.add(String.format("Ainsi, le résultat est : %s\n", resultFraction));
        break;
      default:
        intermediateSteps.add(null);
    }

    return resultFraction.convertToMixedFraction();

  }

  /**
   * Checks if the first Mixed Fraction is greater than the second.
   * 
   * @param x
   *          The first mixed fraction
   * @param y
   *          The second mixed fraction
   * @return 1 if true, 0 if false
   */
  public static MixedFraction greaterThan(final MixedFraction x, final MixedFraction y)
  {
    clearIntermediateSteps();
    boolean result = greaterThanBool(x, y);

    int indicator = (result) ? 1 : 0;

    return new MixedFraction(indicator, null, null);
  }

  /**
   * Checks if the first Mixed Fraction is less than the second.
   * 
   * @param x
   *          The first mixed fraction
   * @param y
   *          The second mixed fraction
   * @return 1 if true, 0 if false
   */
  public static MixedFraction lessThan(final MixedFraction x, final MixedFraction y)
  {
    clearIntermediateSteps();
    boolean result = lessThanBool(x, y);

    int indicator = (result) ? 1 : 0;

    return new MixedFraction(indicator, null, null);
  }

  /**
   * Checks if the provided two mixed fractions are equal.
   * 
   * @param x
   *          The first mixed fraction
   * @param y
   *          The second mixed fraction
   * @return 1 if true, 0 if false
   */
  public static MixedFraction equalTo(final MixedFraction x, final MixedFraction y)
  {
    clearIntermediateSteps();
    boolean result = equalToBool(x, y);

    int indicator = (result) ? 1 : 0;

    return new MixedFraction(indicator, null, null);
  }

  private static boolean lessThanBool(final MixedFraction x, final MixedFraction y)
  {
    return x.compareTo(y) < 0;
  }

  private static boolean greaterThanBool(final MixedFraction x, final MixedFraction y)
  {
    return x.compareTo(y) > 0;
  }

  private static boolean equalToBool(final MixedFraction x, final MixedFraction y)
  {
    return x.equals(y);
  }

  /**
   * Retrieves the intermediate steps.
   * 
   * @return A formatted string of the intermediate steps.
   */
  public static String getIntermediateSteps()
  {
    String ret = "";
    for (String step : intermediateSteps)
    {
      ret = ret.concat(step + "\n");
    }
    return ret;
  }

  /**
   * Clears the intermediate steps.
   */
  public static void clearIntermediateSteps()
  {
    intermediateSteps.clear();
  }

  private static String demonstrateFractionConversionEnglish(final MixedFraction x)
  {

    String ret = String.format("Convert %s to fraction form: \n", x.toString());

    int num;
    int den = x.getDenominator();
    int temp = (den * x.getWholeNumber());

    ret = ret.concat(String.format("Multiply whole number and denominator: " + INT_PRODUCT,
        x.getWholeNumber(), x.getDenominator(), temp));

    if (temp < 0)
    {
      num = temp - x.getNumerator();
      ret = ret.concat(String.format("The numerator of the new fraction will be %d - the original "
          + "numerator, %d.  So, it will be %d.\n", temp, x.getNumerator(), num));
    }
    else
    {
      num = x.getNumerator() + temp;
      ret = ret.concat(String.format("The numerator of the new fraction will be %d + the "
          + "original numerator, %d.  So, it will be %d.\n", temp, x.getNumerator(), num));
    }

    ret = ret.concat(String.format(
        "The denominator of the new fraction will be the same as the original denominator. \n "
            + "So, the resulting fraction is: %s " + DOUBLE_NEWLINE,
        x.convertToFraction().toString()));

    return ret;
  }

  private static String demonstrateFractionConversionFrench(final MixedFraction x)
  {
    String ret = String.format("Convertissez %s en fraction:", x.toString());

    int num;
    int den = x.getDenominator();
    int temp = (den * x.getWholeNumber());

    ret = ret
        .concat(String.format("Multiplier le nombre entier et le dénominateur : " + INT_PRODUCT,
            x.getWholeNumber(), x.getDenominator(), temp));

    if (temp < 0)
    {
      num = temp - x.getNumerator();
      ret = ret.concat(String.format("Le numérateur de la nouvelle fraction sera %d + "
          + "le numérateur d’origine, %d. Ce sera donc %d. \n", temp, x.getNumerator(), num));
    }
    else
    {
      num = x.getNumerator() + temp;
      ret = ret
          .concat(String.format("Le numérateur de la nouvelle fraction sera %d + le numérateur "
              + "d’origine, %d. Ce sera donc %d.\n", temp, x.getNumerator(), num));
    }

    ret = ret.concat(String.format(
        "Le dénominateur de la nouvelle fraction sera le même que le dénominateur initial. \n "
            + "La fraction résultante est donc: %s " + DOUBLE_NEWLINE,
        x.convertToFraction().toString()));

    return ret;

  }

  private static String demonstrateFractionConversionGerman(final MixedFraction x)
  {
    String ret = String.format("Wandeln Sie %s in die Bruchform um: \n", x.toString());

    int num;
    int den = x.getDenominator();
    int temp = (den * x.getWholeNumber());

    ret = ret.concat(String.format("Ganze Zahl und Nenner multiplizieren: " + INT_PRODUCT,
        x.getWholeNumber(), x.getDenominator(), temp));

    if (temp < 0)
    {
      num = temp - x.getNumerator();
      ret = ret.concat(String.format("Der Zähler des neuen Bruchs ist %d + der "
          + "ursprüngliche Zähler %d. Er wird also %d sein.\n", temp, x.getNumerator(), num));
    }
    else
    {
      num = x.getNumerator() + temp;
      ret = ret.concat(String.format("Der Zähler des neuen Bruchs ist %d + der ursprüngliche "
          + "Zähler %d. Er wird also %d sein.\n", temp, x.getNumerator(), num));
    }

    ret = ret.concat(String.format(
        "Der Nenner des neuen Bruchs ist derselbe wie der ursprüngliche Nenner. \n "
            + "Der resultierende Bruch ist also: %s " + DOUBLE_NEWLINE,
        x.convertToFraction().toString()));

    return ret;
  }

  private static String demonstrateFractionConversion(final MixedFraction x, final String language)
  {
    switch (language)
    {
      case (ENGLISH):
        return demonstrateFractionConversionEnglish(x);
      case (GERMAN):
        return demonstrateFractionConversionGerman(x);
      case (FRENCH):
        return demonstrateFractionConversionFrench(x);
      default:
        return null;
    }
  }

  private static String demonstrateFractionStandardizeEnglish(final Fraction x, final int factor)
  {
    String ret = "";

    ret = ret.concat(String.format("To standardize the fraction %s, multiply its "
        + "numerator and denominator by the factor %d \n", x, factor));

    ret = ret.concat(String.format("Numerator:  %d × %d  = %d\n", x.getNumerator(), factor,
        x.getNumerator() * factor));

    ret = ret.concat(String.format("Denominator:  " + INT_PRODUCT, x.getDenominator(), factor,
        x.getDenominator() * factor));

    ret = ret.concat(String
        .format("So, the resulting fraction, which is equivalent to the original fraction, is: %s"
            + DOUBLE_NEWLINE, x.standardize(factor)));

    return ret;
  }

  private static String demonstrateFractionStandardizeGerman(final Fraction x, final int factor)
  {
    String ret = "";

    ret = ret.concat(String.format("Um den Bruch %s zu standardisieren, multiplizieren "
        + "Sie seinen Zähler und Nenner mit dem angegebenen Faktor %d \n", x, factor));

    ret = ret.concat(String.format("Zähler:  %d × %d  = %d\n", x.getNumerator(), factor,
        x.getNumerator() * factor));

    ret = ret.concat(String.format("Nenner:  " + INT_PRODUCT, x.getDenominator(), factor,
        x.getDenominator() * factor));

    ret = ret.concat(String
        .format("Der resultierende Bruch, der dem ursprünglichen Bruch entspricht, ist also: %s"
            + DOUBLE_NEWLINE, x.standardize(factor)));

    return ret;
  }

  private static String demonstrateFractionStandardizeFrench(final Fraction x, final int factor)
  {
    String ret = "";

    ret = ret.concat(String.format("Pour standardiser la fraction %s, multipliez son "
        + "numérateur et son dénominateur par le facteur donné, %d \n", x, factor));

    ret = ret.concat(String.format("Numérateur:  %d × %d  = %d\n", x.getNumerator(), factor,
        x.getNumerator() * factor));

    ret = ret.concat(String.format("Dénominateur:  " + INT_PRODUCT, x.getDenominator(), factor,
        x.getDenominator() * factor));

    ret = ret.concat(String.format(
        "Ainsi, la fraction résultante, qui est équivalente à la fraction originale, est : %s"
            + DOUBLE_NEWLINE,
        x.standardize(factor)));

    return ret;
  }

  private static String demonstrateFractionStandardize(final Fraction x, final int factor,
      final String language)
  {
    switch (language)
    {
      case (ENGLISH):
        return demonstrateFractionStandardizeEnglish(x, factor);
      case (GERMAN):
        return demonstrateFractionStandardizeGerman(x, factor);
      case (FRENCH):
        return demonstrateFractionStandardizeFrench(x, factor);
      default:
        return null;
    }
  }
}




































