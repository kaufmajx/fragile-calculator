package gui;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;

/**
 * Class that sets up the numbers category of buttons onto the button panel.
 * 
 * @author Layla Aure & Alyssa Girard
 * @version 1.0
 */
public class NumberButtons extends FragileButtons
{
  private static final long serialVersionUID = 1L;
  private FragileCalculator calculator;
  private NumberButtonsFunctionality numButtonFunct;

  /**
   * Empty constructor for the NumberButtons class.
   * @param calculator  - The calculator the buttons are to be put onto.
   */
  public NumberButtons(final FragileCalculator calculator)
  {
    super(calculator);
    this.calculator = calculator;
  }

  /**
   * Sets up the number category of buttons onto the button panel.
   * 
   * @param calc
   *          The current button panel being set up.
   **/

  public void setup(final FragileButtons calc)
  {
    numButtonFunct = new NumberButtonsFunctionality(getCalculator());
    // 0 button
    c.anchor = GridBagConstraints.LINE_START;
    c.fill = GridBagConstraints.HORIZONTAL;
    c.gridwidth = 2;
    c.gridx = 0;
    c.gridy = 4;
    zeroButton = new JButton("0");
    zeroButton.setForeground(Color.BLACK);
    zeroButton.setBackground(calculator.mainColor);
    zeroButton.setPreferredSize(bd);
    zeroButton.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
    zeroButton.setFont(plainFont);
    zeroButton.addActionListener(new ActionListener()
    {
      public void actionPerformed(final ActionEvent e)
      {
        numButtonFunct.zeroFunc();
      }
    });
    calc.add(zeroButton, c);

    // 1 button
    c.gridx = 0;
    c.gridy = 3;
    c.fill = GridBagConstraints.NONE;
    oneButton = new JButton("1");
    oneButton.setForeground(Color.BLACK);
    oneButton.setBackground(calculator.mainColor);
    oneButton.setPreferredSize(bd);
    oneButton.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
    oneButton.setFont(plainFont);
    oneButton.addActionListener(new ActionListener()
    {
      public void actionPerformed(final ActionEvent e)
      {
        numButtonFunct.oneFunc();
      }
    });
    calc.add(oneButton, c);

    // 2 button
    c.gridx = 1;
    c.gridy = 3;
    twoButton = new JButton("2");
    twoButton.setForeground(Color.BLACK);
    twoButton.setBackground(calculator.mainColor);
    twoButton.setPreferredSize(bd);
    twoButton.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
    twoButton.setFont(plainFont);
    twoButton.addActionListener(new ActionListener()
    {
      public void actionPerformed(final ActionEvent e)
      {
        numButtonFunct.twoFunc();
      }
    });
    calc.add(twoButton, c);

    // 3 button
    c.gridx = 2;
    c.gridy = 3;
    threeButton = new JButton("3");
    threeButton.setForeground(Color.BLACK);
    threeButton.setBackground(calculator.mainColor);
    threeButton.setPreferredSize(bd);
    threeButton.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
    threeButton.setFont(plainFont);
    threeButton.addActionListener(new ActionListener()
    {
      public void actionPerformed(final ActionEvent e)
      {
        numButtonFunct.threeFunc();
      }
    });
    calc.add(threeButton, c);

    // 4 button
    c.gridx = 0;
    c.gridy = 2;
    fourButton = new JButton("4");
    fourButton.setForeground(Color.BLACK);
    fourButton.setBackground(calculator.mainColor);
    fourButton.setPreferredSize(bd);
    fourButton.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
    fourButton.setFont(plainFont);
    fourButton.addActionListener(new ActionListener()
    {
      public void actionPerformed(final ActionEvent e)
      {
        numButtonFunct.fourFunc();
      }
    });
    calc.add(fourButton, c);

    // 5 button
    c.gridx = 1;
    c.gridy = 2;
    fiveButton = new JButton("5");
    fiveButton.setForeground(Color.BLACK);
    fiveButton.setBackground(calculator.mainColor);
    fiveButton.setPreferredSize(bd);
    fiveButton.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
    fiveButton.setFont(plainFont);
    fiveButton.addActionListener(new ActionListener()
    {
      public void actionPerformed(final ActionEvent e)
      {
        numButtonFunct.fiveFunc();
      }
    });
    calc.add(fiveButton, c);

    // 6 button
    c.gridx = 2;
    c.gridy = 2;
    sixButton = new JButton("6");
    sixButton.setForeground(Color.BLACK);
    sixButton.setBackground(calculator.mainColor);
    sixButton.setPreferredSize(bd);
    sixButton.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
    sixButton.setFont(plainFont);
    sixButton.addActionListener(new ActionListener()
    {
      public void actionPerformed(final ActionEvent e)
      {
        numButtonFunct.sixFunc();
      }
    });
    calc.add(sixButton, c);

    // 7 button
    c.gridx = 0;
    c.gridy = 1;
    sevenButton = new JButton("7");
    sevenButton.setForeground(Color.BLACK);
    sevenButton.setBackground(calculator.mainColor);
    sevenButton.setPreferredSize(bd);
    sevenButton.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
    sevenButton.setFont(plainFont);
    sevenButton.addActionListener(new ActionListener()
    {
      public void actionPerformed(final ActionEvent e)
      {
        numButtonFunct.sevenFunc();
      }
    });
    calc.add(sevenButton, c);

    // 8 button
    c.gridx = 1;
    c.gridy = 1;
    eightButton = new JButton("8");
    eightButton.setForeground(Color.BLACK);
    eightButton.setBackground(calculator.mainColor);
    eightButton.setPreferredSize(bd);
    eightButton.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
    eightButton.setFont(plainFont);
    eightButton.addActionListener(new ActionListener()
    {
      public void actionPerformed(final ActionEvent e)
      {
        numButtonFunct.eightFunc();
      }
    });
    calc.add(eightButton, c);

    // 9 button
    c.gridx = 2;
    c.gridy = 1;
    nineButton = new JButton("9");
    nineButton.setForeground(Color.BLACK);
    nineButton.setBackground(calculator.mainColor);
    nineButton.setPreferredSize(bd);
    nineButton.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
    nineButton.setFont(plainFont);
    nineButton.addActionListener(new ActionListener()
    {
      public void actionPerformed(final ActionEvent e)
      {
        numButtonFunct.nineFunc();
      }
    });
    calc.add(nineButton, c);
  }

 /**
  * Returns the calculator the buttons are to be put onto.
  * @return calculator The calculator the buttons are to be put onto.
  */
  public FragileCalculator getCalculator()
  {
    return this.calculator;
  }

 /**
  * Returns the NumberButtonsFunctionality to be used on the buttons.
  * @return returns the NumberButtonsFunctionality to be used on the buttons.
  */
  public NumberButtonsFunctionality getnumButtonFunct()
  {
    return numButtonFunct;
  }
}
