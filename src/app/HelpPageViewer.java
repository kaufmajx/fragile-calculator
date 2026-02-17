package app;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.swing.JOptionPane;

import utilities.TempResourcePath;

/**
 * A class for opening the Fragile HTML help file.
 * 
 * @author John Ryder
 * @version 10/31/23
 * Honor Code: This work complies with JMU's Honor Code:
 */
public class HelpPageViewer
{
  
  public static final String ERROR_OUTPUT = "Invalid/Missing Help File";
  public static final String ERROR = "Error";
  
  /**
   * Shows the help file in the user's browser in english.
   * 
   * @throws URISyntaxException if the URI is syntatically incorrect.
   * @throws IOException if the URI cannot be found.
   */
  public static void webpageStarterEN()
  {
    Desktop userDesktop = Desktop.getDesktop();
    try
    {
      TempResourcePath resourcePath = new TempResourcePath();
      String tempURIString = resourcePath.getTempResourcePath().toUri().toString();
      tempURIString = tempURIString + "FragileHelpEN.htm";
      URI helpURI = new URI(tempURIString);
      userDesktop.browse(helpURI);
    }
    catch (IOException | URISyntaxException e)
    {
      JOptionPane.showMessageDialog(null, ERROR_OUTPUT, ERROR, 
          JOptionPane.ERROR_MESSAGE);
      e.printStackTrace();
    }
  }
  
  /**
   * Shows the help file in the user's browser in French.
   * 
   * @throws URISyntaxException if the URI is syntatically incorrect.
   * @throws IOException if the URI cannot be found.
   */
  public static void webpageStarterFR()
  {
    Desktop userDesktop = Desktop.getDesktop();
    try
    {
      TempResourcePath resourcePath = new TempResourcePath();
      String tempURIString = resourcePath.getTempResourcePath().toUri().toString();
      tempURIString = tempURIString + "FragileHelpFR.htm";
      URI helpURI = new URI(tempURIString);
      userDesktop.browse(helpURI);
    }
    catch (IOException | URISyntaxException e)
    {
      JOptionPane.showMessageDialog(null, ERROR_OUTPUT, ERROR, 
          JOptionPane.ERROR_MESSAGE);
      e.printStackTrace();
    }
  }
  
  /**
   * Shows the help file in the user's browser in German.
   * 
   * @throws URISyntaxException if the URI is syntatically incorrect.
   * @throws IOException if the URI cannot be found.
   */
  public static void webpageStarterGER()
  {
    Desktop userDesktop = Desktop.getDesktop();
    try
    {
      TempResourcePath resourcePath = new TempResourcePath();
      String tempURIString = resourcePath.getTempResourcePath().toUri().toString();
      tempURIString = tempURIString + "FragileHelpGER.htm";
      URI helpURI = new URI(tempURIString);
      userDesktop.browse(helpURI);
    }
    catch (IOException | URISyntaxException e)
    {
      JOptionPane.showMessageDialog(null, ERROR_OUTPUT, ERROR, 
          JOptionPane.ERROR_MESSAGE);
      e.printStackTrace();
    }
  }
}
