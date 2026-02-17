package gui;

import javax.swing.*;
import java.awt.*;

/**
 * CalculatorButtons - the buttons for the Calculator.
 * 
 * @author Layla Aure & Alyssa Girard
 * @version 1.0
 */
public class FragileButtons extends JPanel
{
  private static final long serialVersionUID = 1L;
  private FragileCalculator calculator;
  protected static Font plainFont = new Font(Font.SERIF, Font.PLAIN, 20);
  protected static GridBagConstraints c; 
  protected JButton rButton;
  protected JButton cButton;
  protected JButton arrowButton;
  protected JButton addButton;
  protected JButton subButton;
  protected JButton divButton;
  protected JButton multButton;
  protected JButton equalsButton;
  protected JButton posnegButton;
  protected JButton oneButton;
  protected JButton twoButton;
  protected JButton threeButton;
  protected JButton fourButton;
  protected JButton fiveButton;
  protected JButton sixButton;
  protected JButton sevenButton;
  protected JButton eightButton;
  protected JButton nineButton;
  protected JButton zeroButton;
  protected JButton intPowerButton;
  protected JButton invButton;
  protected JButton simplifyButton;
  protected JButton leftButton;
  protected JButton greaterButton;
  protected JButton relationalEqualsButton;
  protected String currentSign = "";
  protected Dimension bd = new Dimension(35, 35);
  protected OperatorButtons operatorButtons;
  protected DeletionButtons deletionButtons;
  protected SignPositionButtons signPositionButtons;
  protected NumberButtons numberButtons;
  protected RelationalButtons relationalButtons;

 /**
  * Constructor for the FragileButtons class.
  * @param calculator The calculator the buttons are to be put onto.
  */
  public FragileButtons(final FragileCalculator calculator)
  {
    this.calculator = calculator;
    setBackground(calculator.mainColor);
    //this.setupLayout();
  }

 /**
  * Sets up the layout of the button panel.
  * @return The FragileButtons that are made.
  */
  public JPanel setupLayout()
  {
	  c = new GridBagConstraints(); 
    setLayout(new GridBagLayout());
    c.insets = new Insets(8, 8, 8, 8);
    c.fill = GridBagConstraints.HORIZONTAL;

    // buttons
    operatorButtons = new OperatorButtons(this.calculator);
    deletionButtons = new DeletionButtons(this.calculator);
    signPositionButtons = new SignPositionButtons(this.calculator);
    numberButtons = new NumberButtons(this.calculator);
    relationalButtons  = new RelationalButtons(this.calculator);
    
    operatorButtons.setup(this);
    deletionButtons.setup(this);
    signPositionButtons.setup(this);
    numberButtons.setup(this);
    relationalButtons.setup(this);

 // spaces
    c.gridx = 4;
    c.gridy = 1;
    add(new JLabel(""), c);

    c.gridx = 4;
    c.gridy = 2;
    add(new JLabel(""), c);

    c.gridx = 4;
    c.gridy = 3;
    add(new JLabel(""), c);

    c.gridx = 4;
    c.gridy = 4;
    add(new JLabel(""), c);

    setVisible(true);
    return this;
  }

  /**
  * Returns the operator buttons. 
  * @return the operator buttons.
  */
  public OperatorButtons getOperatorButtons()
  {
    return operatorButtons;
  }

 /**
  * Returns the sign position buttons.
  * @return the sign position buttons for the calculator.
  */
  public SignPositionButtons getSignPositionButtons()
  {
    return signPositionButtons;
  }

 /**
  * Returns the number buttons. 
  * @return numberButtons the NumberButtons to be put onto the calculator.
  */
  public NumberButtons getNumberButtons()
  {
    return numberButtons;
  }
}