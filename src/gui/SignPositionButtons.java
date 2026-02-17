package gui;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 * Class that sets up the sign position category of buttons onto the button panel.
 * 
 * @author Layla Aure & Alyssa Girard
 * @version 1.0
 */
public class SignPositionButtons extends FragileButtons
{
  private static final long serialVersionUID = 1L;
  private FragileCalculator calculator;
  private SignPositionButtonsFunctionality signPosButtonFunct;

  /**
   * Empty constructor for the SignPositionButtons class.
   * @param calculator The calculator button frame to put the buttons onto.
   */
  public SignPositionButtons(final FragileCalculator calculator)
  {
    super(calculator);
    this.calculator = calculator;
  }

  /**
   * Sets up the sign position category of buttons onto the button panel.
   * @param calc
   *          The current button panel being set up.
   */
  public void setup(final FragileButtons calc)
  {
    signPosButtonFunct = new SignPositionButtonsFunctionality(this.calculator);
    // sign button
    c.gridx = 4;
    c.gridy = 0;
    posnegButton = new JButton("±");
    posnegButton.setForeground(calculator.signColor);
    posnegButton.setBackground(calculator.mainColor);
    posnegButton.setPreferredSize(bd);
    posnegButton.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
    posnegButton.setFont(plainFont);
    posnegButton.addActionListener(new ActionListener()
    {
      public void actionPerformed(final ActionEvent e)
      {
        signPosButtonFunct.signFunc();
      }
    });
    calc.add(posnegButton, c);

    // position button
    c.fill = GridBagConstraints.NONE;
    c.gridwidth = 1;
    c.gridx = 2;
    c.gridy = 4;
    ImageIcon frac = new ImageIcon(calculator.getTempResourcePath().getTempResourceString() 
    		+ "/fracbutton.png/");
    Image image = frac.getImage();
    image = image.getScaledInstance(11, 16, java.awt.Image.SCALE_SMOOTH);
    frac = new ImageIcon(image);
    JButton fracButton = new JButton(frac);
    fracButton.setBackground(calculator.mainColor);
    fracButton.setPreferredSize(bd);
    fracButton.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
    fracButton.addActionListener(new ActionListener()
    {
      public void actionPerformed(final ActionEvent e)
      {
        signPosButtonFunct.positionFunc();
      }
    });
    calc.add(fracButton, c);
  }

 /**
  * Returns the calculator to assign the buttons to.
  * @return calculator The calculator to assign the buttons to.
  */
  public FragileCalculator getCalculator()
  {
    return this.calculator;
  }

 /**
  * Returns the calculator to assign the functionality to.
  * @return calculator The calculator to assign the functionality to.
  */
  public SignPositionButtonsFunctionality getsignPosButtonFunct()
  {
    return signPosButtonFunct;
  }
}
