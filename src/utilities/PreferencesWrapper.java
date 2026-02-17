package utilities;

import java.io.Serializable;
import java.util.HashMap;

/**
 * A wrapper class that saves keybinds and the thousands separator in a single object.
 * 
 * @author John Ryder
 * @version 12/8/23
 * Honor Code: This work complies with JMU's Honor Code:
 */
public class PreferencesWrapper implements Serializable
{

  /**
   * Default serialization ID.
   */
  private static final long serialVersionUID = 1L;
  
  private HashMap<String, Integer> mnemonicItems;
  private boolean sepsOn;
  
  /**
   * Create the wrapper object.
   * @param mnemonicItems - the mnemonic items to hold.
   * @param sepsOn - if separators should be turned on or not.
   */
  public PreferencesWrapper(final HashMap<String, Integer> mnemonicItems, final boolean sepsOn)
  {
    this.mnemonicItems = mnemonicItems;
    this.sepsOn = sepsOn;
  }
  
  /**
   * Get the mnemonic items.
   * @return the mnemonic items.
   */
  public HashMap<String, Integer> getMnemonicItems()
  {
    return this.mnemonicItems;
  }
  
  /**
   * Gets if separators should be turned on.
   * @return if separators should be turned on.
   */
  public boolean getSepsOn()
  {
    return this.sepsOn;
  }
}
