package utilities;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Arc2D;
import java.awt.geom.Rectangle2D;


/**
 * A class for drawing pie chart items.
 * 
 * @author John Ryder
 * @version 11/1/23
 * Honor Code: This work complies with JMU's Honor Code:
 * -Used: https://forums.codeguru.com/showthread.php?270172-Drawing-half-circles-in-Java for help
 * drawing half circles.
 * -Used: https://www.javatpoint.com/Graphics-in-swing for help with canvas and graphics objects.
 * -Used: https://stackoverflow.com/questions/42855224/how-to-add-rgb-values-into-setcolor-in-java
 * for making my own color.
 * -Used https://stackoverflow.com/questions/18351069/
 * how-to-find-the-dimensions-of-a-string-that-you-are-drawing-with-graphics2d
 * for finding dimensions of a drawn string.
 * -Used https://stackoverflow.com/questions/27706197/how-can-i-center-graphics-drawstring-in-java
 * for centering numbers inside of a circle.
 */
public class PieChartDraw extends Canvas
{
  /**
   * 
   */
  public static final Color FRAGILE_RED = new Color(169, 28, 2);
  public static final Font LETTER_FONT = new Font(Font.DIALOG, Font.BOLD, 40);
  private static final long serialVersionUID = 1L;
  private Double currentValue;
  private Color drawingColor;
  private Font fontToUse;
  
  
  /**
   * Create the PieChartDraw item.
   * 
   * @param curVal - the current double to use.
   */
  public PieChartDraw(final Double curVal) 
  {
    this.currentValue = curVal;
    drawingColor = FRAGILE_RED;
  }
  
  /**
   * Set the color to draw the pie charts in.
   * 
   * @param newColor - the new color to use.
   */
  public void setColor(final Color newColor)
  {
    drawingColor = newColor;
  }
  
  /**
   * Paints the pie chart.
   * Notes about functionality:
   * -Text with bold setting and font size 30 seem to have width ~15 pixels. Text with bold
   * and font size 20 seem to have width ~10 pixels. Thus, it would seem like drawn letters have
   * a width of about font size/2. This factors into the math required to make sure that numbers
   * are centered, and the sizing of numbers at higher values (to make sure that they are still
   * centered and can fit inside the pie chart which is drawn.
   * 
   * @param g - the graphics engine automatically passed during execution.
   */
  public void paint(final Graphics g)
  {
    Graphics2D g2D = (Graphics2D) g;
    g2D.setColor(drawingColor);
    Rectangle2D boundingBox = new Rectangle2D.Float(0, 0, 80, 80);
    Arc2D currentPie = new Arc2D.Double(boundingBox, 0.0, -360 * this.currentValue, Arc2D.PIE);
    g2D.draw(currentPie);
    g2D.fill(currentPie);
    g2D.setColor(Color.BLACK);
    if (Math.abs(currentValue) >= 1.0) //Has a whole, draw the number in the whole part.
    {
      Double numWholes = Math.floor(currentValue);
      Integer numWholesInt = (int) Math.round(numWholes);
      String numWholesString = numWholesInt.toString();
      int fontScaleFactor = 70 - 10 * numWholesString.length();
      fontToUse = new Font(Font.DIALOG, Font.BOLD, fontScaleFactor);
      g2D.setFont(fontToUse);
      //Begin math for number spacing.
      FontMetrics stringMetrics = g2D.getFontMetrics(fontToUse);
      Double placeToStartXDouble = currentPie.getX() 
          + (currentPie.getWidth() - stringMetrics.stringWidth(numWholesString)) / 2;
      Double placeToStartYDouble = currentPie.getY() 
          + ((currentPie.getHeight() - stringMetrics.getHeight()) / 2) + stringMetrics.getAscent();
      int placeToStartX = (int) Math.round(placeToStartXDouble);
      int placeToStartY = (int) Math.round(placeToStartYDouble);
      //End math for number spacing.
      g2D.drawString(numWholesString, placeToStartX, placeToStartY);
    }
  }
}
