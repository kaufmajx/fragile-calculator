package gui;

/**
 * Functionality for deletion buttons.
 */
public class DeletionButtonsFunctionality
{
  
  private FragileCalculator calculator;
  

  /**
   * Create the DeletionButtonsFunctionality object.
   * @param calculator - the calculator to link the deletion buttons to.
   */
  public DeletionButtonsFunctionality(final FragileCalculator calculator)
  {
    this.calculator = calculator;
  }
  /**
   * Reset button functionality.
   */
  public void resetFunc() 
  {
    calculator.getDisplayTop().setText("");
    calculator.getDisplayBottom().setText(FragileCalculator.focus);
    calculator.setCount(0);
    calculator.setinD(false);
    calculator.setinN(false);
    calculator.setinD2(false);
    calculator.setinN2(false);
  }
  
  /**
   * Clear button functionality.
   */
  public void clearFunc() 
  {
    calculator.getDisplayBottom().setText(FragileCalculator.focus);
    calculator.setCount(0);
    calculator.setinD(false);
    calculator.setinN(false);
    calculator.setinD2(false);
    calculator.setinN2(false);
  }
  
  /**
   * Delete button functionality.
   */
  public void deleteFunc() 
  {
    calculator.backspaceButtonPressed();
    if (calculator.separators)
    {
      calculator.separatorsOff(calculator.getDisplayBottom().getText(), 
    		  calculator.getDisplayTop().getText());
      calculator.separatorsOn(calculator.getDisplayBottom().getText(), 
    		  calculator.getDisplayTop().getText());
    }
  }
}
