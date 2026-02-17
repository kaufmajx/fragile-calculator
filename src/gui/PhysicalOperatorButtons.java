package gui;

import java.awt.event.KeyEvent;

/**
 * Handles the physical keyboard input for operators.
 */
public class PhysicalOperatorButtons
{

  private OperatorButtonsFunctionality operatorButtonFunct;
  private FragileCalculator calculator;

  /**
   * Constructor for the PhysicalOperatorButtons class.
 * @param operatorButtonFunct The functionality for the buttons.
 * @param calculator The calculator the buttons will control.
 */
  public PhysicalOperatorButtons(final OperatorButtonsFunctionality operatorButtonFunct,
      final FragileCalculator calculator)
  {
    this.operatorButtonFunct = operatorButtonFunct;
    this.calculator = calculator;
  }

  /**
   * Called by CalculatorWindow KeyEventDispatcher.
   * 
   * @param e
   *          the key being pressed
   */
  public void operatorKeyPressed(final KeyEvent e)
  {
    int keyCode = e.getKeyCode();

    boolean shiftPressed = e.isShiftDown();

    // addition
    if (shiftPressed && keyCode == KeyEvent.VK_EQUALS)
    {
      if (calculator.getFocusOwner() != null)
        operatorButtonFunct.addFunc();
    }
    // subtraction
    else if (keyCode == KeyEvent.VK_MINUS)
    {
      if (calculator.getFocusOwner() != null)
        operatorButtonFunct.subtractFunc();
    }
    // multiplication
    else if (shiftPressed && keyCode == KeyEvent.VK_8)
    {
      if (calculator.getFocusOwner() != null)
        operatorButtonFunct.multFunc();
    }
    // division
    else if (keyCode == KeyEvent.VK_SLASH)
    {
      if (calculator.getFocusOwner() != null)
        operatorButtonFunct.divideFunc();
    }
    // power
    else if (shiftPressed && keyCode == KeyEvent.VK_6)
    {
      if (calculator.getFocusOwner() != null)
        operatorButtonFunct.powerFunc();
    }
    // equals
    else if (keyCode == KeyEvent.VK_ENTER)
    {
      if (calculator.getFocusOwner() != null)
        operatorButtonFunct.equalsFunc();
    }

  }
}
