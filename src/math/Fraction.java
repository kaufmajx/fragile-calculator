package math;

/**

 * Represents a fraction without a whole number.
 * @author Jelal Kaufman, Joseph Linneman
 */
public class Fraction
{
  private int numerator;
  private int denominator;

 /**
  * Constructor for a Fraction object.
  * @param numerator The numerator of the Fraction.
  * @param denominator The denominator of the Fraction.
  */
  public Fraction(final int numerator, final int denominator)
  {
    this.numerator = numerator;
    this.denominator = denominator;
  }

  /**
   * Gets the numerator of this fraction.
   * @return The numerator
   */
  public int getNumerator()
  {
    return numerator;
  }

  /**
   * Gets the denominator of this fraction.
   * @return The denominator
   */
  public int getDenominator()
  {
    return denominator;
  }

  /**
   * Sets the numerator of the owning fraction.
   * @param x The new numerator
   */
  public void setNumerator(final int x)
  {
    this.numerator = x;
  }
  /**
   * Sets the denominator of the owning fraction.
   * @param x The new denominator
   */
  public void setDenominator(final int x)
  {
    this.denominator = x;
  }

  /**
   * Converts this fraction to Mixed Fraction form.
   * @return The mixed fraction form of this fraction
   */
  public MixedFraction convertToMixedFraction()
  {
    if (numerator < 0 && denominator < 0)
      return new MixedFraction(Math.abs(numerator / denominator), Math.abs(numerator % denominator),
          Math.abs(denominator));

    else if (numerator / denominator < 0)
      return new MixedFraction(numerator / denominator, Math.abs(numerator % denominator),
          Math.abs(denominator));

    return new MixedFraction(Math.abs(numerator / denominator), numerator % denominator,
        denominator);
  }

  /**
   * Standardizes this fraction, preserving its value, using the provided factor.
   * @param factor The factor to standardize by
   * @return An equivalent fraction with a standardized numerator/denominator
   */
  public Fraction standardize(final int factor)
  {
    return new Fraction(numerator * factor, denominator * factor);
  }

  /**
   * Converts this fraction to simplest form.
   * @return The simplest form of the fraction
   */
  public Fraction simplifyFraction()
  {
    int num = numerator;
    int den = denominator;
    int gcd = Math.abs(Operations.greatestCommonDivisor(num, den));
    if (gcd > 1)
    {
      num /= gcd;
      den /= gcd;
    }

    return new Fraction(num, den);
  }
  
 /**
  * Returns the ratio of the numerator & denominator.
  * @return The ratio of the numerator & denominator.
  */
  public Double ratio() 
  {
    return  ((double) numerator / denominator);
  }
  
  /**
   * Returns a string representation of this fraction.
   * @return The string representation
   */
  public String toString()
  {
    return numerator + "/" + denominator;
  }
}
