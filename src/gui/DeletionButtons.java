package gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;

/**
 * Class that sets up the deletion category of buttons onto the button panel.
 * 
 * @author Layla Aure & Alyssa Girard
 * @version 1.2
 */
public class DeletionButtons extends FragileButtons
{
  private static final long serialVersionUID = 1L;
  private FragileCalculator calculator;

  /**
   * Empty constructor for the DeletionButtons class.
   * 
   * @param calculator The calculator to put the Deletion Buttons into.
   */
  public DeletionButtons(final FragileCalculator calculator)
  {
    super(calculator);
    this.calculator = calculator;
  }

  /**
   * Sets up the deletion category of buttons onto the button panel.
   * 
   * @param calc
   *          The current button panel being set up.
   */
  public void setup(final FragileButtons calc)
  {
    DeletionButtonsFunctionality deletionButtonFunct = 
    		new DeletionButtonsFunctionality(getCalculator());
    // reset button
    c.gridx = 0;
    c.gridy = 0;
    rButton = new JButton("R");
    rButton.setForeground(calculator.deletionColor);
    rButton.setBackground(calculator.mainColor);
    rButton.setPreferredSize(bd);
    rButton.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
    rButton.setFont(plainFont);
    rButton.addActionListener(new ActionListener()
    {
      public void actionPerformed(final ActionEvent e)
      {
        deletionButtonFunct.resetFunc();
      }
    });
    calc.add(rButton, c);

    // clear buttons
    c.gridx = 1;
    c.gridy = 0;
    cButton = new JButton("C");
    cButton.setForeground(calculator.deletionColor);
    cButton.setBackground(calculator.mainColor);
    cButton.setPreferredSize(bd);
    cButton.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
    cButton.setFont(plainFont);
    cButton.addActionListener(new ActionListener()
    {
      public void actionPerformed(final ActionEvent e)
      {
        deletionButtonFunct.clearFunc();
      }
    });
    calc.add(cButton, c);

    // delete button
    c.gridx = 2;
    c.gridy = 0;
    arrowButton = new JButton("←");
    arrowButton.setForeground(calculator.deletionColor);
    arrowButton.setBackground(calculator.mainColor);
    arrowButton.setPreferredSize(bd);
    arrowButton.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
    arrowButton.setFont(plainFont);
    arrowButton.addActionListener(new ActionListener()
    {
      public void actionPerformed(final ActionEvent e)
      {
        deletionButtonFunct.deleteFunc();
      }
    });
    calc.add(arrowButton, c);
  }
  
  /**
   * Get the current calculator being used.
   * @return the current calculator.
   */
  public FragileCalculator getCalculator()
  {
    return this.calculator;
  }
}
