package gui;

import java.awt.event.KeyEvent;

/**
 * Handles the physical keyboard input for digits.
 */
public class PhysicalNumberButtons
{

  private NumberButtonsFunctionality numButtonFunct;
  private FragileCalculator calculator;

 /**
  * Constructor for the PhysicalNumberButtons class.
  * @param numButtonFunct The functionality for the buttons.
  * @param calculator The calculator the buttons will control.
  */
  public PhysicalNumberButtons(final NumberButtonsFunctionality numButtonFunct,
      final FragileCalculator calculator)
  {
    this.numButtonFunct = numButtonFunct;
    this.calculator = calculator;
  }

 /**
  * Handles if a number key is pressed. 
  * @param e The event of the key being pressed.
  */
  public void numberKeyPressed(final KeyEvent e)
  {

    int keyCode = e.getKeyCode();
    boolean shiftPressed = e.isShiftDown();
    if (keyCode == KeyEvent.VK_0)
    {
      if (calculator.getFocusOwner() != null)
        numButtonFunct.zeroFunc();
    }
    else if (keyCode == KeyEvent.VK_1)
    {
      if (calculator.getFocusOwner() != null)
        numButtonFunct.oneFunc();
    }
    else if (keyCode == KeyEvent.VK_2)
    {
      if (calculator.getFocusOwner() != null)
        numButtonFunct.twoFunc();
    }
    else if (keyCode == KeyEvent.VK_3)
    {
      if (calculator.getFocusOwner() != null)
        numButtonFunct.threeFunc();
    }
    else if (keyCode == KeyEvent.VK_4)
    {
      if (calculator.getFocusOwner() != null)
        numButtonFunct.fourFunc();
    }
    else if (keyCode == KeyEvent.VK_5)
    {
      if (calculator.getFocusOwner() != null)
        numButtonFunct.fiveFunc();
    }
    else if (keyCode == KeyEvent.VK_6 && !shiftPressed)
    {
      if (calculator.getFocusOwner() != null)
        numButtonFunct.sixFunc();
    }
    else if (keyCode == KeyEvent.VK_7)
    {
      if (calculator.getFocusOwner() != null)
        numButtonFunct.sevenFunc();
    }
    else if (keyCode == KeyEvent.VK_8 && !shiftPressed)
    {
      if (calculator.getFocusOwner() != null)
        numButtonFunct.eightFunc();
    }
    else if (keyCode == KeyEvent.VK_9)
    {
      if (calculator.getFocusOwner() != null)
        numButtonFunct.nineFunc();
    }
  }
}
