package gui;

/**
 * 
 */
public class RelationalButtonsFunctionality extends RelationalButtons
{
  private static final long serialVersionUID = 1L;
  private FragileCalculator calculator;

 /**
  * The constructor for the RelationalButtonsFunctionality class.
  * @param calculator The calculator the functionality will be applied to.
  */
  public RelationalButtonsFunctionality(final FragileCalculator calculator)
  {
    super(calculator);
    this.calculator = calculator;
  }

/**
  * Handles the greaterThan button functionality.
  */
  public void greaterThanFunc()
  {
    String greaterThan = " >";
    calculator.buttonPressed(greaterThan);

    calculator.moveToLeft();
    if (calculator.getJustEvaluated())
      calculator.getDisplayTop().setText(previousEvaluation.toString() + greaterThan);
    calculator.setCount(0);
    calculator.setinD(false);
    calculator.setinN(false);
    calculator.setinN2(false);
    calculator.setinD2(false);
    calculator.getDisplayBottom().setText(FragileCalculator.focus);
    calculator.setJustEvaluated(false);
  }

 /**
  * Handles the lessThan button functionality.
  */
  public void lessThanFunc()
  {
    String lessThan = " <";
    calculator.buttonPressed(lessThan);

    calculator.moveToLeft();
    if (calculator.getJustEvaluated())
      calculator.getDisplayTop().setText(previousEvaluation.toString() + lessThan);
    calculator.setCount(0);
    calculator.setinD(false);
    calculator.setinN(false);
    calculator.setinN2(false);
    calculator.setinD2(false);
    calculator.getDisplayBottom().setText(FragileCalculator.focus);
    calculator.setJustEvaluated(false);
  }
 /**
  * Handles the equalsTo button functionality.
  */
  public void equalsToFunc()
  {
    String equals = " ≝";
    calculator.buttonPressed(equals);
    calculator.moveToLeft();
    if (calculator.getJustEvaluated())
      calculator.getDisplayTop().setText(previousEvaluation.toString() + equals);
    calculator.setCount(0);
    calculator.setinD(false);
    calculator.setinN(false);
    calculator.setinN2(false);
    calculator.setinD2(false);
    calculator.getDisplayBottom().setText(FragileCalculator.focus);
    calculator.setJustEvaluated(false);
  }

}
