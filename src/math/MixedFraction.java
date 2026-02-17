package math;

/**
 * A class for creating mixed fractions.
 * 
 * @author Jelal Kaufman, Joseph Linneman
 * @version 11/2/23 Honor Code: This work complies with JMU's Honor Code:
 */
public class MixedFraction implements Comparable<MixedFraction>
{
  private static final int NEGATIVE_ONE = -1;
  private static final Integer DEFAULT_WHOLE_NUMBER_VALUE = 0;
  private static final Integer DEFAULT_NUMERATOR_VALUE = 0;
  private static final Integer DEFAULT_DENOMINATOR_VALUE = 1;
  private static final String SLASH = "/";
  private Integer wholeNumber;
  private Integer numerator;
  private Integer denominator;
  private boolean hasWholeNumber;
  private boolean hasNumerator;
  private boolean hasDenominator;
  private boolean isNegative;

  /**
   * The MixedFraction constructor.
   * 
   * @param wholeNumber
   *          An integer representing the whole number of the mixed fraction.
   * @param numerator
   *          An integer representing the numerator of the mixed fraction.
   * @param denominator
   *          An integer representing the denominator of the mixed fraction.
   * @throws IllegalArgumentException
   */
  public MixedFraction(final Integer wholeNumber, final Integer numerator,
      final Integer denominator) throws IllegalArgumentException
  {

    if (wholeNumber == null)
    {
      this.wholeNumber = DEFAULT_WHOLE_NUMBER_VALUE;
      hasWholeNumber = false;
    }
    else
    {
      Integer.valueOf(wholeNumber);
      this.wholeNumber = wholeNumber;
      hasWholeNumber = true;
    }

    if (numerator == null)
    {
      this.numerator = DEFAULT_NUMERATOR_VALUE;
      this.denominator = DEFAULT_DENOMINATOR_VALUE;
      hasNumerator = false;
      hasDenominator = false;
    }
    else
    {
      Integer.valueOf(numerator);
      this.numerator = numerator;
      hasNumerator = true;
    }

    if (denominator == null)
    {
      this.numerator = DEFAULT_NUMERATOR_VALUE;
      this.denominator = DEFAULT_DENOMINATOR_VALUE;
      hasNumerator = false;
      hasDenominator = false;
    }
    else
    {
      Integer.valueOf(denominator);
      this.denominator = denominator;
      hasDenominator = true;
    }

    // denominator cannot be 0 in a mixed fraction
    if (this.denominator == 0)
      throw new IllegalArgumentException();

    if (this.denominator < 0 && this.numerator > 0)
    {
      this.numerator = this.numerator * NEGATIVE_ONE;
      this.denominator = this.denominator * NEGATIVE_ONE;
    }

    this.isNegative = this.wholeNumber < 0 || this.numerator < 0;

    // if the whole number is not zero, hasWholeNumber = true
    this.hasWholeNumber = (this.wholeNumber != 0);

    if (this.numerator < 0 && this.denominator < 0)
    {
      this.numerator *= NEGATIVE_ONE;
      this.denominator *= NEGATIVE_ONE;
    }
  }

  /**
   * Getter for the wholeNumber of the MixedFraction.
   * 
   * @return The integer in wholeNumber.
   */
  public Integer getWholeNumber()
  {
    return wholeNumber;
  }

  /**
   * Getter for the numerator of the MixedFraction.
   * 
   * @return The integer in numerator.
   */
  public Integer getNumerator()
  {
    return numerator;
  }

  /**
   * Getter for the denominator of the MixedFraction.
   * 
   * @return The integer in denominator.
   */
  public Integer getDenominator()
  {
    return denominator;
  }

  /**
   * Getter for the hasWholeNumber of the MixedFraction.
   * 
   * @return The boolean in hasWholeNumber.
   */
  public boolean getHasWholeNumber()
  {
    return hasWholeNumber;
  }

  /**
   * Getter for the hasNumerator of the MixedFraction.
   * 
   * @return The boolean in hasNumerator.
   */
  public boolean getHasNumerator()
  {
    return hasNumerator;
  }

  /**
   * Getter for the hasDenominator of the MixedFraction.
   * 
   * @return The boolean in hasDenominator.
   */
  public boolean getHasDenominator()
  {
    return hasDenominator;
  }

  /**
   * Getter for the isNegative attribute of this MixedFraction.
   * 
   * @return A boolean denoting whether the mixed fraction is negative.
   */
  public boolean isNegative()
  {
    return isNegative;
  }

  /**
   * This method updates the MixedFraction to be in simplest form.
   */
  public void updateMixedFraction()
  {
    int reductionNumber = 0;
    if (Math.abs(numerator) >= denominator)
    {
      reductionNumber = (Math.abs(numerator) / denominator);
    }
    wholeNumber += reductionNumber;
    numerator -= denominator * reductionNumber;
  }

  /**
   * Changes the sign of the mixed fraction. A negative number to a positive or positive to
   * negative.
   */
  public void changeSign()
  {
    isNegative = !isNegative;
    wholeNumber = wholeNumber * -1;
  }

  /**
   * Simplifies the numerator and denominator of this mixed fraction.
   * 
   * @return The newly simplified mixed fraction
   */
  public MixedFraction simplify()
  {
    int num = numerator;
    int den = denominator;
    int gcd = Math.abs(Operations.greatestCommonDivisor(num, den));
    if (gcd > 1)
    {
      num /= gcd;
      den /= gcd;
    }

    return new MixedFraction(wholeNumber, num, den);
  }

  /**
   * Converts this MixedFraction to fraction form.
   * 
   * @return The fraction form
   */
  public Fraction convertToFraction()
  {
    int num;
    int den;
    int temp;
    temp = (denominator * wholeNumber);
    if (temp < 0)
      num = temp - numerator;
    else
      num = numerator + temp;

    den = denominator;

    return new Fraction(num, den);
  }

  /**
   * Returns a String representing the MixedFraction in wholeNumber numerator/denominator style.
   * 
   * @return the correctly formatted string.
   */
  public String toString()
  {
    String ret = "";

    if (wholeNumber == 0 && numerator == 0)
      return "0";

    if (hasWholeNumber)
      ret = ret.concat(wholeNumber.toString());

    if (hasNumerator && numerator != 0)
      ret = ret.concat(String.format(" %d/%d", numerator, denominator));

    return ret;
  }

  /**
   * Builds a mixed fraction out of the provided string.
   * 
   * @param s
   *          The string to parse
   * @return A mixed fraction from that string
   */
  public static MixedFraction parseMixedFractionFromString(final String s)
  {

    if (s.isBlank())
      return new MixedFraction(null, null, null);
    else if (!s.contains(SLASH))
      return new MixedFraction(Integer.parseInt(s.replace(" ", "")), null, null);
    else
    {
      String[] components = s.split("\s");

      int wholeNumber = 0;
      String[] numeratorAndDenominator;

      if (components[0].contains(SLASH))
      {
        wholeNumber = 0;
        numeratorAndDenominator = components[0].split(SLASH);
      }

      else
      {
        wholeNumber = Integer.parseInt(components[0]);
        numeratorAndDenominator = components[1].split(SLASH);
      }

      if (numeratorAndDenominator.length != 2 || numeratorAndDenominator[0].isBlank())
        return new MixedFraction(wholeNumber, null, null);

      int numerator = Integer.parseInt(numeratorAndDenominator[0]);
      int denominator = Integer.parseInt(numeratorAndDenominator[1]);

      MixedFraction test = new MixedFraction(wholeNumber, numerator, denominator);

      return test;
    }

  }

  @Override
  public int compareTo(final MixedFraction o)
  {
    // TODO write comparison functions

    Fraction thisFraction = this.convertToFraction();
    Fraction oFraction = o.convertToFraction();

    return thisFraction.ratio().compareTo(oFraction.ratio());
  }

  /**
   * Evaluates the equality of two mixed fractions.
   * @param o the other object to compare with, usually another MixedFraction
   * @return true or false
   */
  public boolean equals(final Object o)
  {
    if (o == null || getClass() != o.getClass())
      return false;

    MixedFraction other = (MixedFraction) o;

    return this.compareTo(other) == 0;
  }

  /**
   * Not used in this product.
   * 
   * @return 1
   */
  public int hashCode()
  {
    return 1;
  }
}
