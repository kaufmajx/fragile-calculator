package gui;

/**
 * Functionality of sign and position buttons.
 */
public class SignPositionButtonsFunctionality extends SignPositionButtons
{
  private static final long serialVersionUID = 1L;
  private static String slash = "/";

  /**
   * Constructor for the SignPositionButtonsFunctionality class.
   * 
   * @param calculator
   *          The calculator to assign the button functionalities to.
   */
  public SignPositionButtonsFunctionality(final FragileCalculator calculator)
  {
    super(calculator);
  }

  /**
   * Position button functionality.
   */
  public void positionFunc()
  {
    super.getCalculator().setCount(super.getCalculator().getCount() + 1);
    cycleFocus();
  }

  /**
   * Sign button functionality.
   */
  public void signFunc()
  {
    super.getCalculator().buttonPressed("");
    currentSign = super.getCalculator().signButtonPressed(currentSign);
    super.getCalculator().moveFocus();
  }

  /**
   * Helper method for cycling focus.
   */
  private void cycleFocus()
  {
    if (super.getCalculator().getinD())
    {
      String current = super.getCalculator().getDisplayBottom().getText();
      String newDisplay = "";
      String[] parts;
      newDisplay = current.replace(FragileCalculator.focus, "");
      System.out.println(newDisplay);
      parts = newDisplay.split(slash);
      if (parts.length > 0)
      {
        newDisplay = parts[0];
        newDisplay.replace(slash, "");
        newDisplay += FragileCalculator.focus + slash;
      }
      else
      {
        newDisplay = newDisplay.replace(slash, "");
        newDisplay += FragileCalculator.focus + slash;
      }
      if (parts.length > 1)
      {
        newDisplay += parts[1];
      }
      super.getCalculator().setinD(false);
      super.getCalculator().setinN(true);

      super.getCalculator().getDisplayBottom().setText(newDisplay);
    }
    else if (super.getCalculator().getinN())
    {
      String current = super.getCalculator().getDisplayBottom().getText();
      String newDisplay = "";
      String[] parts;
      newDisplay = current.replace(FragileCalculator.focus, "");
      parts = newDisplay.split(slash);
      if (parts.length > 0)
      {
        newDisplay = parts[0];
        newDisplay += slash;
      }
      if (parts.length > 1)
      {
        newDisplay += parts[1] + FragileCalculator.focus;
      }
      else
      {
        newDisplay += FragileCalculator.focus;
      }
      super.getCalculator().setinD(true);
      super.getCalculator().setinN(false);

      super.getCalculator().getDisplayBottom().setText(newDisplay);
    }
    else if (!super.getCalculator().getinN() || !super.getCalculator().getinD())
    {
      String current = super.getCalculator().getDisplayBottom().getText();
      String newDisplay = "";

      newDisplay = current.replace(FragileCalculator.focus, "");
      newDisplay = newDisplay.replace(slash, "");
      newDisplay += FragileCalculator.focus + slash;

      super.getCalculator().setinD(false);
      super.getCalculator().setinN(true);

      super.getCalculator().getDisplayBottom().setText(newDisplay);
    }
  }
}
