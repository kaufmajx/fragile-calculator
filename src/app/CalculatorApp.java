package app;

import java.io.IOException;
import java.net.URISyntaxException;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import gui.FragileCalculator;

/**
 * Runs the Calculator App.
 */
public class CalculatorApp
{

 /**
  * Main runner for the calculator app.
  * @param args The arguments for the desired calculator.
  * @throws IOException Thrown if there is an issue with the input and/or output.
  * @throws URISyntaxException Thrown if there is an issue with the syntax of the URI.
  */
  public static void main(final String[] args) throws IOException, URISyntaxException
  {
    try
    {
      UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
    }
    catch (UnsupportedLookAndFeelException | ClassNotFoundException | InstantiationException 
        | IllegalAccessException e)
    {
      // Use the default
    }
    // creates the initial FragileCalculator
    new FragileCalculator(true);
    
  }
}
