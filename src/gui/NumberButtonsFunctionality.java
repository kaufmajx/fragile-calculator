package gui;

/**
 * Functionality for number buttons.
 */
public class NumberButtonsFunctionality
{
  public static final String SLASH = "/";
  public static final String ONE = "1";
  public static final String TWO = "2";
  public static final String THREE = "3";
  public static final String FOUR = "4";
  public static final String FIVE = "5";
  public static final String SIX = "6";
  public static final String SEVEN = "7";
  public static final String EIGHT = "8";
  public static final String NINE = "9";
  public static final String ZERO = "0";
  private FragileCalculator calculator;
  
 /**
  * Constructor for the NumberButtonsFunctionality class.
  * @param calculator The calculator the buttons are to be put onto.
  */
  public NumberButtonsFunctionality(final FragileCalculator calculator)
  {
    this.calculator = calculator;
  }

  /**
   * Zero button functionality.
   */
  public void zeroFunc() 
  {
    calculator.setJustEvaluated(false);
    String current = calculator.getDisplayBottom().getText();
    String newText = "";
    if (current.contains(FragileCalculator.focus + SLASH))
    {
      calculator.setinN(true);
      calculator.moveFocusFrac(ZERO);
    }
    else if (current.contains(SLASH + FragileCalculator.focus))
    {
      calculator.setinD(true);
      newText = current.substring(0, current.length() - 1);
      calculator.getDisplayBottom().setText(newText);
      calculator.moveFocusFrac(ZERO);

    }
    else
    {
      calculator.buttonPressed(ZERO);
      calculator.moveFocus();
    }
    if (calculator.separators)
    {
      calculator.separatorsOff(calculator.getDisplayBottom().getText(), 
    		  calculator.getDisplayTop().getText());
      calculator.separatorsOn(calculator.getDisplayBottom().getText(), 
    		  calculator.getDisplayTop().getText());
    }
  }
  
  /**
   * One button functionality.
   */
  public void oneFunc() 
  {
    calculator.setJustEvaluated(false);
    String current = calculator.getDisplayBottom().getText();
    String newText = "";
    if (current.contains(FragileCalculator.focus + SLASH))
    {
      calculator.setinN(true);
      calculator.moveFocusFrac(ONE);
    }
    else if (current.contains(SLASH + FragileCalculator.focus))
    {
      calculator.setinD(true);
      newText = current.substring(0, current.length() - 1);
      calculator.getDisplayBottom().setText(newText);
      calculator.moveFocusFrac(ONE);

    }
    else
    {
      calculator.buttonPressed(ONE);
      calculator.moveFocus();
    }
    if (calculator.separators)
    {
      calculator.separatorsOff(calculator.getDisplayBottom().getText(), 
    		  calculator.getDisplayTop().getText());
      calculator.separatorsOn(calculator.getDisplayBottom().getText(), 
    		  calculator.getDisplayTop().getText());
    }
  }
  
  /**
   * Two button functionality.
   */
  public void twoFunc() 
  {
    calculator.setJustEvaluated(false);
    String current = calculator.getDisplayBottom().getText();
    String newText = "";
    if (current.contains(FragileCalculator.focus + SLASH))
    {
      calculator.setinN(true);
      calculator.moveFocusFrac(TWO);
    }
    else if (current.contains(SLASH + FragileCalculator.focus))
    {
      calculator.setinD(true);
      newText = current.substring(0, current.length() - 1);
      calculator.getDisplayBottom().setText(newText);
      calculator.moveFocusFrac(TWO);

    }
    else
    {
      calculator.buttonPressed(TWO);
      calculator.moveFocus();
    }
    if (calculator.separators)
    {
      calculator.separatorsOff(calculator.getDisplayBottom().getText(), 
    		  calculator.getDisplayTop().getText());
      calculator.separatorsOn(calculator.getDisplayBottom().getText(), 
    		  calculator.getDisplayTop().getText());
    }
  }
  
  /**
   * Three button functionality.
   */
  public void threeFunc() 
  {
    calculator.setJustEvaluated(false);
    String current = calculator.getDisplayBottom().getText();
    String newText = "";
    if (current.contains(FragileCalculator.focus + SLASH))
    {
      calculator.setinN(true);
      calculator.moveFocusFrac(THREE);
    }
    else if (current.contains(SLASH + FragileCalculator.focus))
    {
      calculator.setinD(true);
      newText = current.substring(0, current.length() - 1);
      calculator.getDisplayBottom().setText(newText);
      calculator.moveFocusFrac(THREE);

    }
    else
    {
      calculator.buttonPressed(THREE);
      calculator.moveFocus();
    }
    if (calculator.separators)
    {
      calculator.separatorsOff(calculator.getDisplayBottom().getText(), 
    		  calculator.getDisplayTop().getText());
      calculator.separatorsOn(calculator.getDisplayBottom().getText(), 
    		  calculator.getDisplayTop().getText());
    }
  }
  
  /**
   * Four button functionality.
   */
  public void fourFunc() 
  {
    calculator.setJustEvaluated(false);
    String current = calculator.getDisplayBottom().getText();
    String newText = "";
    if (current.contains(FragileCalculator.focus + SLASH))
    {
      calculator.setinN(true);
      calculator.moveFocusFrac(FOUR);
    }
    else if (current.contains(SLASH + FragileCalculator.focus))
    {
      calculator.setinD(true);
      newText = current.substring(0, current.length() - 1);
      calculator.getDisplayBottom().setText(newText);
      calculator.moveFocusFrac(FOUR);

    }
    else
    {
      calculator.buttonPressed(FOUR);
      calculator.moveFocus();
    }
    if (calculator.separators)
    {
      calculator.separatorsOff(calculator.getDisplayBottom().getText(), 
    		  calculator.getDisplayTop().getText());
      calculator.separatorsOn(calculator.getDisplayBottom().getText(), 
    		  calculator.getDisplayTop().getText());
    }
  }
  
  /**
   * Five button functionality.
   */
  public void fiveFunc() 
  {
    calculator.setJustEvaluated(false);
    String current = calculator.getDisplayBottom().getText();
    String newText = "";
    if (current.contains(FragileCalculator.focus + SLASH))
    {
      calculator.setinN(true);
      calculator.moveFocusFrac(FIVE);
    }
    else if (current.contains(SLASH + FragileCalculator.focus))
    {
      calculator.setinD(true);
      newText = current.substring(0, current.length() - 1);
      calculator.getDisplayBottom().setText(newText);
      calculator.moveFocusFrac(FIVE);

    }
    else
    {
      calculator.buttonPressed(FIVE);
      calculator.moveFocus();
    }
    if (calculator.separators)
    {
      calculator.separatorsOff(calculator.getDisplayBottom().getText(), 
    		  calculator.getDisplayTop().getText());
      calculator.separatorsOn(calculator.getDisplayBottom().getText(), 
    		  calculator.getDisplayTop().getText());
    }
  }
  
  /**
   * Six button functionality.
   */
  public void sixFunc() 
  {
    calculator.setJustEvaluated(false);
    String current = calculator.getDisplayBottom().getText();
    String newText = "";
    if (current.contains(FragileCalculator.focus + SLASH))
    {
      calculator.setinN(true);
      calculator.moveFocusFrac(SIX);
    }
    else if (current.contains(SLASH + FragileCalculator.focus))
    {
      calculator.setinD(true);
      newText = current.substring(0, current.length() - 1);
      calculator.getDisplayBottom().setText(newText);
      calculator.moveFocusFrac(SIX);

    }
    else
    {
      calculator.buttonPressed(SIX);
      calculator.moveFocus();
    }
    if (calculator.separators)
    {
      calculator.separatorsOff(calculator.getDisplayBottom().getText(), 
    		  calculator.getDisplayTop().getText());
      calculator.separatorsOn(calculator.getDisplayBottom().getText(), 
    		  calculator.getDisplayTop().getText());
    }
  }
  
  /**
   * Seven button functionality.
   */
  public void sevenFunc() 
  {
    calculator.setJustEvaluated(false);
    String current = calculator.getDisplayBottom().getText();
    String newText = "";
    if (current.contains(FragileCalculator.focus + SLASH))
    {
      calculator.setinN(true);
      calculator.moveFocusFrac(SEVEN);
    }
    else if (current.contains(SLASH + FragileCalculator.focus))
    {
      calculator.setinD(true);
      newText = current.substring(0, current.length() - 1);
      calculator.getDisplayBottom().setText(newText);
      calculator.moveFocusFrac(SEVEN);

    }
    else
    {
      calculator.buttonPressed(SEVEN);
      calculator.moveFocus();
    }
    if (calculator.separators)
    {
      calculator.separatorsOff(calculator.getDisplayBottom().getText(), 
    		  calculator.getDisplayTop().getText());
      calculator.separatorsOn(calculator.getDisplayBottom().getText(), 
    		  calculator.getDisplayTop().getText());
    }
  }
  
  /**
   * Eight button functionality.
   */
  public void eightFunc() 
  {
    calculator.setJustEvaluated(false);
    String current = calculator.getDisplayBottom().getText();
    String newText = "";
    if (current.contains(FragileCalculator.focus + SLASH))
    {
      calculator.setinN(true);
      calculator.moveFocusFrac(EIGHT);
    }
    else if (current.contains(SLASH + FragileCalculator.focus))
    {
      calculator.setinD(true);
      newText = current.substring(0, current.length() - 1);
      calculator.getDisplayBottom().setText(newText);
      calculator.moveFocusFrac(EIGHT);

    }
    else
    {
      calculator.buttonPressed(EIGHT);
      calculator.moveFocus();
    }
    if (calculator.separators)
    {
      calculator.separatorsOff(calculator.getDisplayBottom().getText(), 
    		  calculator.getDisplayTop().getText());
      calculator.separatorsOn(calculator.getDisplayBottom().getText(), 
    		  calculator.getDisplayTop().getText());
    }
  }
  
  /**
   * Nine button functionality.
   */
  public void nineFunc() 
  {
    calculator.setJustEvaluated(false);
    String current = calculator.getDisplayBottom().getText();
    String newText = "";
    if (current.contains(FragileCalculator.focus + SLASH))
    {
      calculator.setinN(true);
      calculator.moveFocusFrac(NINE);
    }
    else if (current.contains(SLASH + FragileCalculator.focus))
    {
      calculator.setinD(true);
      newText = current.substring(0, current.length() - 1);
      calculator.getDisplayBottom().setText(newText);
      calculator.moveFocusFrac(NINE);

    }
    else
    {
      calculator.buttonPressed(NINE);
      calculator.moveFocus();
    }
    if (calculator.separators)
    {
      calculator.separatorsOff(calculator.getDisplayBottom().getText(), 
    		  calculator.getDisplayTop().getText());
      calculator.separatorsOn(calculator.getDisplayBottom().getText(), 
    		  calculator.getDisplayTop().getText());
    }
  }
}
