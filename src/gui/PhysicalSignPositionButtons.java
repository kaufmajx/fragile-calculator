package gui;

import java.awt.event.KeyEvent;

/**
 * Handles the physical keyboard input for sign position buttons.
 */
public class PhysicalSignPositionButtons
{
  private SignPositionButtonsFunctionality getsignPosButtonFunct;
  private FragileCalculator calculator;

 /**
  * Constructor for the PhysicalSignPositionButtons.
  * @param getsignPosButtonFunct The functionality of the buttons.
  * @param calculator Handles the physical keyboard input for operators.
  */
  public PhysicalSignPositionButtons(final SignPositionButtonsFunctionality getsignPosButtonFunct,
      final FragileCalculator calculator)
  {
    this.getsignPosButtonFunct = getsignPosButtonFunct;
    this.calculator = calculator;
  }

 /**
  * Handles if a position key is pressed.
  * @param e The event of the key being pressed.
  */
  public void signPosKeyPressed(final KeyEvent e)
  {
    int keyCode = e.getKeyCode();
    if (keyCode == KeyEvent.VK_PERIOD)
    {
      // checks if this calculator is in focus
      if (calculator.getFocusOwner() != null)
        getsignPosButtonFunct.positionFunc(); // runs if in focus
    }
  }
}
