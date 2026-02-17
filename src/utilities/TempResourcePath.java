package utilities;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Path;

/**
 * A class for getting the temp resource path (for use in deployment).
 * 
 * @author John Ryder
 * @version 12/4/23
 * Honor Code: This work complies with JMU's Honor Code.
 */
public class TempResourcePath
{
  private Path tempResourcePath;
  
  /**
   * Creates the temporary resource directory and saves its directory.
   * @throws IOException if something goes wrong in making the temp directory.
   * @throws URISyntaxException if something goes wrong in making the temp directory.
   */
  public TempResourcePath() throws IOException, URISyntaxException
  {
    tempResourcePath = ResourceCopier.copyResourcesToTemp("tempResources", "/resource/");
  }
  
  /**
   * Gets the temporary resource directory's path as a String.
   * 
   * @return the String form of the temporary resource directory.
   */
  public String getTempResourceString()
  {
    return this.tempResourcePath.toString();
  }
  
  /**
   * Gets the "true" temporary resource directory's path as a path object.
   * 
   * @return the path object.
   */
  public Path getTempResourcePath()
  {
    return this.tempResourcePath;
  }
}
