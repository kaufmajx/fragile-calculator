package gui;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;

import math.MixedFraction;

/**
 * Class that sets up the operator category of buttons onto the button panel.
 * 
 * @author Layla Aure & Alyssa Girard
 * @version 1.0
 */
public class OperatorButtons extends FragileButtons
{

  private static final long serialVersionUID = 1L;
  protected String answerFraction = "";
  protected MixedFraction previousEvaluation;
  private FragileCalculator calculator;
  private OperatorButtonsFunctionality optButtonFunct;

  /**
   * Empty constructor for the OperatorButtons class.
   * @param calculator The calculator the FragileButtons will be put onto.
   */
  public OperatorButtons(final FragileCalculator calculator)
  {
    super(calculator);
    this.calculator = calculator;
    // TODO Auto-generated constructor stub
  }

 /**
  * Sets up the OperatorButtons to be put onto the FragileButtons panel.
  * @param calc the FragileButtons that the OperatorButtons are put onto.
  */
  public void setup(final FragileButtons calc)
  {
    optButtonFunct = new OperatorButtonsFunctionality(getCalculator());
    // addition
    c.gridx = 3;
    c.gridy = 0;
    addButton = new JButton("+");
    addButton.setForeground(calculator.operatorColor);
    addButton.setBackground(calculator.mainColor);
    addButton.setPreferredSize(bd);
    addButton.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
    addButton.setFont(plainFont);
    addButton.addActionListener(new ActionListener()
    {
      public void actionPerformed(final ActionEvent e)
      {
        optButtonFunct.addFunc();
      }
    });
    calc.add(addButton, c);

    // subtraction
    c.gridx = 3;
    c.gridy = 1;
    subButton = new JButton("-");
    subButton.setForeground(calculator.operatorColor);
    subButton.setBackground(calculator.mainColor);
    subButton.setPreferredSize(bd);
    subButton.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
    subButton.setFont(plainFont);
    subButton.addActionListener(new ActionListener()
    {
      public void actionPerformed(final ActionEvent e)
      {
        optButtonFunct.subtractFunc();
      }
    });
    calc.add(subButton, c);

    // multiplication
    c.gridx = 3;
    c.gridy = 2;
    multButton = new JButton("x");
    multButton.setForeground(calculator.operatorColor);
    multButton.setBackground(calculator.mainColor);
    multButton.setPreferredSize(bd);
    multButton.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
    multButton.setFont(plainFont);
    multButton.addActionListener(new ActionListener()
    {
      public void actionPerformed(final ActionEvent e)
      {
        optButtonFunct.multFunc();
      }
    });
    calc.add(multButton, c);

    // division
    c.gridx = 3;
    c.gridy = 3;
    divButton = new JButton("÷");
    divButton.setForeground(calculator.operatorColor);
    divButton.setBackground(calculator.mainColor);
    divButton.setPreferredSize(bd);
    divButton.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
    divButton.setFont(plainFont);
    divButton.addActionListener(new ActionListener()
    {
      public void actionPerformed(final ActionEvent e)
      {
        optButtonFunct.divideFunc();
      }
    });
    calc.add(divButton, c);

    // equals
    c.fill = GridBagConstraints.HORIZONTAL;
    c.gridx = 3;
    c.gridy = 4;
    equalsButton = new JButton("=");
    equalsButton.setForeground(calculator.operatorColor);
    equalsButton.setBackground(calculator.mainColor);
    equalsButton.setPreferredSize(bd);
    equalsButton.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
    equalsButton.setFont(plainFont);
    equalsButton.addActionListener(new ActionListener()
    {
      public void actionPerformed(final ActionEvent e)
      {
        optButtonFunct.equalsFunc();
      }
    });
    calc.add(equalsButton, c);

    // integer power
    c.fill = GridBagConstraints.HORIZONTAL;
    c.gridx = 4;
    c.gridy = 4;
    intPowerButton = new JButton("xⁿ");
    intPowerButton.setForeground(calculator.operatorColor);
    intPowerButton.setBackground(calculator.mainColor);
    intPowerButton.setPreferredSize(bd);
    intPowerButton.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
    intPowerButton.setFont(plainFont);
    intPowerButton.addActionListener(new ActionListener()
    {
      public void actionPerformed(final ActionEvent e)
      {
        optButtonFunct.powerFunc();
      }
    });
    calc.add(intPowerButton, c);

    // Inverse
    c.fill = GridBagConstraints.HORIZONTAL;
    c.gridx = 4;
    c.gridy = 1;
    invButton = new JButton("Inv");
    invButton.setForeground(calculator.operatorColor);
    invButton.setBackground(calculator.mainColor);
    invButton.setPreferredSize(bd);
    invButton.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
    invButton.setFont(plainFont);
    invButton.addActionListener(new ActionListener()
    {
      public void actionPerformed(final ActionEvent e)
      {
        optButtonFunct.inverseFunc();
      }
    });
    calc.add(invButton, c);

    // Simplify
    c.fill = GridBagConstraints.HORIZONTAL;
    c.gridx = 4;
    c.gridy = 2;
    simplifyButton = new JButton("↡");
    simplifyButton.setForeground(calculator.operatorColor);
    simplifyButton.setBackground(calculator.mainColor);
    simplifyButton.setPreferredSize(bd);
    simplifyButton.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
    simplifyButton.setFont(plainFont);
    simplifyButton.addActionListener(new ActionListener()
    {
      public void actionPerformed(final ActionEvent e)
      {
        optButtonFunct.simplifyFunc();
      }
    });
    calc.add(simplifyButton, c);

    // mediant
    c.fill = GridBagConstraints.HORIZONTAL;
    c.gridx = 4;
    c.gridy = 3;
    simplifyButton = new JButton("⇹");
    simplifyButton.setForeground(calculator.operatorColor);
    simplifyButton.setBackground(calculator.mainColor);
    simplifyButton.setPreferredSize(bd);
    simplifyButton.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
    simplifyButton.setFont(plainFont);
    simplifyButton.addActionListener(new ActionListener()
    {
      public void actionPerformed(final ActionEvent e)
      {
        optButtonFunct.mediantFunc();
      }
    });
    calc.add(simplifyButton, c);
  }

 /**
  * Returns the calculator.
  *
  * @return the calculator.
  */
  public FragileCalculator getCalculator()
  {
    return this.calculator;
  }

 /**
  * Returns the OperatorButtonFunctionality for the OperatorButtons.
  * 
  * @return optButtonFunct the OperatorButtonFunctionality for the OperatorButtons.
  */
  public OperatorButtonsFunctionality getopButtonFunct()
  {
    return optButtonFunct;
  }
}












































