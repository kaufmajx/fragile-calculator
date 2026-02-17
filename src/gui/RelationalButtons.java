package gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import math.MixedFraction;

/**
 * Class that sets up the relational category of buttons onto the button panel.
 */
public class RelationalButtons extends FragileButtons
{
  private static final long serialVersionUID = 1L;
  protected MixedFraction previousEvaluation;
  private FragileCalculator calculator;
  private RelationalButtonsFunctionality relationalButtonFunct;

  /**
   * Constructor for the RelationalButtons class.
   * 
   * @param calculator
   *          The calculator the buttons will be on.
   */
  public RelationalButtons(final FragileCalculator calculator)
  {
    super(calculator);
    this.calculator = calculator;
  }

  /**
   * Sets up the relational buttons.
   * 
   * @param calc
   *          The calculator the buttons will be on.
   */
  public void setup(final FragileButtons calc)
  {
    relationalButtonFunct = new RelationalButtonsFunctionality(getCalculator());

    // greater than
    c.gridx = 5;
    c.gridy = 0;
    addButton = new JButton(">");
    addButton.setForeground(calculator.operatorColor);
    addButton.setBackground(calculator.mainColor);
    addButton.setPreferredSize(bd);
    addButton.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
    addButton.setFont(plainFont);
    addButton.addActionListener(new ActionListener()
    {
      public void actionPerformed(final ActionEvent e)
      {
        relationalButtonFunct.greaterThanFunc();
      }
    });
    calc.add(addButton, c);

    // less than
    c.gridx = 5;
    c.gridy = 1;
    addButton = new JButton("<");
    addButton.setForeground(calculator.operatorColor);
    addButton.setBackground(calculator.mainColor);
    addButton.setPreferredSize(bd);
    addButton.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
    addButton.setFont(plainFont);
    addButton.addActionListener(new ActionListener()
    {
      public void actionPerformed(final ActionEvent e)
      {
        relationalButtonFunct.lessThanFunc();
      }
    });
    calc.add(addButton, c);

    // equals than
    c.gridx = 5;
    c.gridy = 2;
    addButton = new JButton("≝");
    addButton.setForeground(calculator.operatorColor);
    addButton.setBackground(calculator.mainColor);
    addButton.setPreferredSize(bd);
    addButton.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
    addButton.setFont(plainFont);
    addButton.addActionListener(new ActionListener()
    {
      public void actionPerformed(final ActionEvent e)
      {
        relationalButtonFunct.equalsToFunc();
      }
    });
    calc.add(addButton, c);
  }

  /**
   * Returns the calculator the buttons are being put on.
   * 
   * @return The calculator the buttons are being put on.
   */
  public FragileCalculator getCalculator()
  {
    return this.calculator;
  }

  /**
   * Returns the button functionality specifications.
   * 
   * @return relationalButtonFunct the button functionality specifications.
   */
  public RelationalButtonsFunctionality getopRelationalButtonFunct()
  {
    return relationalButtonFunct;
  }

}
