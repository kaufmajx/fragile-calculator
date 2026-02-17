package gui;

import java.awt.event.KeyEvent;

/**
 * Class for the handling of the deletion operations via the keyboard buttons.
 */
public class PhysicalDeletionButtons
{
  private FragileCalculator calculator;

 /**
  * Constructor for the PhysicalDeletionButtons class.
  * @param calculator The calculator to handle the buttons on.
  */
  public PhysicalDeletionButtons(final FragileCalculator calculator)
  {
    this.calculator = calculator;
  }

 /**
  * Handles if the backspace button is pressed.
  * @param e
  */
  public void deletionKeyPressed(final KeyEvent e)
  {
    int keyCode = e.getKeyCode();
    if (keyCode == KeyEvent.VK_BACK_SPACE)
    {
      // the following line checks if this calculator is in focus and if true, it performs the task.
      if (calculator.getFocusOwner() != null)
        calculator.backspaceButtonPressed();
    }
  }
}
