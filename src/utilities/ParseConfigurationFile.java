package utilities;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * A utility method for loading items from a configuration file.
 * 
 * @author John Ryder
 * @version 12/4/23
 * Honor Code: This work complies with JMU's Honor Code.
 */
public class ParseConfigurationFile
{
  
  /**
   * Creates an array of configuration values to be used by the window (colors, image files, etc).
   * 
   * @param fileName - the file to take from.
   * @return an array of config files.
   * @throws URISyntaxException if something goes wrong with loading the file.
   * @throws IOException if something goes wrong with loading the file.
   */
  public static ArrayList<String> getConfigsFromFile(final String fileName) 
      throws IOException, URISyntaxException
  {
    TempResourcePath resourcePath = new TempResourcePath(); //Get the temporary resource path.
    String toTemp = resourcePath.getTempResourceString();
    ArrayList<String> configArray = new ArrayList<>();
    File configFile = new File(toTemp + fileName);
    Scanner inputFromFile = new Scanner(configFile);
    while (inputFromFile.hasNext())
    {
      String[] currentLine = inputFromFile.nextLine().split(" ");
      configArray.add(currentLine[2]); //Add the actual value;
    }
    inputFromFile.close();
    return configArray;
  }
}
