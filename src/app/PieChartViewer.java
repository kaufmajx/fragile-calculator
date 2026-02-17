package app;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.util.Locale;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import gui.FragileCalculator;
import math.*;
import utilities.PieChartDraw;

/**
 * A class for creating and viewing pie charts of the current mixed fraction.
 * 
 * @author John Ryder
 * @version 10/31/23
 * Honor Code: This work complies with JMU's Honor Code:
 * -Used https://www.javatpoint.com/java-gridbaglayout for help with GridBagLayout.
 * -Used https://docs.oracle.com/javase/tutorial/uiswing/layout/gridbag.html for help
 * with GridBagLayout.
 */
public class PieChartViewer
{
  public static final Font HEADER_FONT = new Font(Font.DIALOG, Font.BOLD, 30);
  public static final Font LETTER_FONT = new Font(Font.DIALOG, Font.BOLD, 40);
  public static final Color FRAGILE_RED = new Color(169, 28, 2);
  public static final String EQUALS = "=";
  public static final String PLUS = "+";
  private MixedFraction bottomRight;
  private MixedFraction topLeft;
  private MixedFraction topRight;
  private MixedFraction topEquals;
  private String operator;
  private boolean isExpression;
  private Color drawingColor;
  private FragileCalculator calculator;
  
  /**
   * Creates a default PieChartViewer object with 1 1/1 as its fraction.
   * @param calculator - the calculator to use.
   */
  public PieChartViewer(final FragileCalculator calculator)
  {
    this.bottomRight = new MixedFraction(1, 1, 1);
    this.isExpression = false;
    this.calculator = calculator;
    drawingColor = FRAGILE_RED;
    
  }
  
  /**
   * Creates a default PieChartViewer with "1 1/2 + 1 2/3 = 3 1/6" if isExpression,
   * or default PieChartViewer constructor otherwise.
   * 
   * @param calculator - the calculator to use.
   * @param isExpression - if this default PieChartViewer should contain an expression or not.
   */
  public PieChartViewer(final FragileCalculator calculator, final boolean isExpression)
  {
    this.isExpression = isExpression;
    if (isExpression)
    {
      topLeft = new MixedFraction(1, 1, 2);
      topRight = new MixedFraction(1, 2, 3);
      operator = PLUS;
      drawingColor = FRAGILE_RED;
      this.calculator = calculator;
    }
    else //Not an expression, use default constructor 1.
    {
      new PieChartViewer(calculator);
    }
  }
  
  /**
   * Constructor to use with a single mixed fraction.
   * 
   * @param calculator - the calculator to use.
   * @param currentMixed - the mixed fraction to display.
   */
  public PieChartViewer(final FragileCalculator calculator, final MixedFraction currentMixed)
  {
    this.bottomRight = currentMixed;
    this.isExpression = false;
    this.calculator = calculator;
    drawingColor = FRAGILE_RED;
  }
  
  /**
   * Constructor to use with a mixed fraction expression.
   * 
   * @param topLeft - the fraction in the top left of Fragile's display.
   * @param topRight - the fraction in the top right of the display (to the left of the equals).
   * @param topEquals - what the expression in the top of the display equals.
   * @param operator - the operator used in the expression.
   * @param calculator - the calculator to use.
   */
  public PieChartViewer(final MixedFraction topLeft, final MixedFraction topRight, 
      final MixedFraction topEquals, final String operator, final FragileCalculator calculator)
  {
    this.topLeft = topLeft;
    this.topRight = topRight;
    this.topEquals = topEquals;
    this.operator = operator;
    this.isExpression = true;
    this.calculator = calculator;
    drawingColor = FRAGILE_RED;
  }
  
  /**
   * Set the color to draw the pie charts in.
   * 
   * @param r - the red value.
   * @param g - the green value.
   * @param b - the blue value.
   */
  public void setColor(final int r, final int g, final int b)
  {
    drawingColor = new Color(r, g, b);
  }
  
  
  /**
   * Create the pie chart window and draw the items in it.
   */
  public void createPieChart()
  {
    //Setup window for pie chart.
    Locale setLocale = calculator.getLocale();
    JFrame pieChartFrame;
    if (setLocale.equals(Locale.GERMANY))
    {
      pieChartFrame = new JFrame("Kuchendiagramm");
    } else if (setLocale.equals(Locale.FRANCE))
    {
      pieChartFrame = new JFrame("Diagramme Circulaire");
    } else 
    {
      pieChartFrame = new JFrame("Pie Chart");
    }
    pieChartFrame.setResizable(false);
    pieChartFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    pieChartFrame.setIconImage(calculator.getIconImage());
    JPanel pieChartDisplay = new JPanel();
    pieChartDisplay.setLayout(new BorderLayout());
    JPanel drawingPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
    pieChartDisplay.add(drawingPanel, BorderLayout.CENTER);
    if (this.isExpression) //Is an expression, draw accordingly.
    {
      JLabel pieChartLabel = new JLabel(topLeft.toString() + operator + topRight.toString() 
          + EQUALS + topEquals.toString(), SwingConstants.CENTER); //Create label in top of display.
      pieChartDisplay.add(pieChartLabel, BorderLayout.NORTH);
      if (topLeft.getHasWholeNumber()) //Has 1st whole number, draw it.
      {
        PieChartDraw wholePart1 = new PieChartDraw(topLeft.getWholeNumber() * 1.0);
        wholePart1.setColor(drawingColor);
        wholePart1.setSize(80, 80);
        drawingPanel.add(wholePart1);
      }
      if (topLeft.getHasNumerator() && topLeft.getHasDenominator()) //Has fraction, draw it.
      {
        PieChartDraw fraction1 = new PieChartDraw((topLeft.getNumerator() * 1.0)
            / (topLeft.getDenominator() * 1.0));
        fraction1.setColor(drawingColor);
        fraction1.setSize(80, 80);
        drawingPanel.add(fraction1);
      }
      JLabel operatorLabel = new JLabel(operator); //Draw operation symbol.
      operatorLabel.setFont(LETTER_FONT);
      operatorLabel.setSize(40, 40);
      drawingPanel.add(operatorLabel);
      if (topRight.getHasWholeNumber()) //Has 2nd whole number, draw it.
      {
        PieChartDraw wholePart2 = new PieChartDraw(topRight.getWholeNumber() * 1.0);
        wholePart2.setColor(drawingColor);
        wholePart2.setSize(80, 80);
        drawingPanel.add(wholePart2);
      }
      if (topRight.getHasNumerator() && topRight.getHasDenominator()) //Has fraction, draw it.
      {
        PieChartDraw fraction2 = new PieChartDraw((topRight.getNumerator() * 1.0)
            / (topRight.getDenominator() * 1.0));
        fraction2.setColor(drawingColor);
        fraction2.setSize(80, 80);
        drawingPanel.add(fraction2);
      }
      JLabel equalsLabel = new JLabel(EQUALS); //Draw equals symbol.
      equalsLabel.setFont(LETTER_FONT);
      equalsLabel.setSize(40, 40);
      drawingPanel.add(equalsLabel);
      if (topEquals.getHasWholeNumber()) //Has 3rd whole number, draw it.
      {
        PieChartDraw wholePart3 = new PieChartDraw(topEquals.getWholeNumber() * 1.0);
        wholePart3.setColor(drawingColor);
        wholePart3.setSize(80, 80);
        drawingPanel.add(wholePart3);
      }
      if (topEquals.getHasNumerator() && topEquals.getHasDenominator()) //Has fraction, draw it.
      {
        PieChartDraw fraction3 = new PieChartDraw((topEquals.getNumerator() * 1.0)
            / (topEquals.getDenominator() * 1.0));
        fraction3.setColor(drawingColor);
        fraction3.setSize(80, 80);
        drawingPanel.add(fraction3);
      }
    }
    else //Is not an expression.
    {
      JLabel pieChartLabel = new JLabel(bottomRight.toString(), 
          SwingConstants.CENTER); //Create label for top of display.
      pieChartDisplay.add(pieChartLabel, BorderLayout.NORTH);
      if (bottomRight.getHasWholeNumber()) //Has a whole number, draw it.
      {
        PieChartDraw wholePart = new PieChartDraw(bottomRight.getWholeNumber() * 1.0);
        wholePart.setColor(drawingColor);
        wholePart.setSize(80, 80);
        drawingPanel.add(wholePart);
      }
      if (bottomRight.getHasNumerator() && bottomRight.getHasDenominator()) //Has a fraction.
      {
        PieChartDraw fractionPart = new PieChartDraw((bottomRight.getNumerator() * 1.0)
            / (bottomRight.getDenominator() * 1.0));
        fractionPart.setColor(drawingColor);
        fractionPart.setSize(80, 80);
        drawingPanel.add(fractionPart);
      }
    }
    pieChartFrame.add(pieChartDisplay);
    pieChartFrame.pack();
    pieChartFrame.setVisible(true);
  }
}
