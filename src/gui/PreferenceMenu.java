package gui;

import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.Locale;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

/**
 * A class for creating a window for setting preferences.
 * 
 * @author John Ryder
 * @version 1.2
 * Honor Code: This work complies with JMU's Honor Code:
 * -Used https://stackoverflow.com/questions/44993759/assign-string-array-to-combobox-in-java
 * for help with setting up JComboBoxes.
 * -Used https://stackoverflow.com/questions/1944446/close-one-jframe-without-closing-another
 * for help with DISPOSE_ON_CLOSE.
 * 
 */
public class PreferenceMenu extends JFrame implements ActionListener
{
  public static final String RECORD_US = "Record";
  public static final String RECORD_FR = "Enregistrer";
  public static final String RECORD_DE = "Aufzeichnen";
  public static final String THOUSANDS_US = "Thousands Separator";
  public static final String THOUSANDS_FR = "Séparateur de Milliers:";
  public static final String THOUSANDS_DE = "Tausendertrennzeichen:";
  private static final long serialVersionUID = 1L;
  private HashMap<String, Integer> mnemonicItems;
  private JPanel mainPanel;
  private JLabel thousandsSeparatorLabel;
  private JComboBox<String> dropDownMenu;
  private JRadioButton recordButton;
  private JRadioButton onButton;
  private JRadioButton offButton;
  private ButtonGroup separatorButtons;
  private FragileCalculator calculator;
  private Locale currentLocale;
  private KeyboardFocusManager currentManager;
  private KeyDispatcher currentDispatcher;
  
 /**
  * The constructor for the PreferenceMenu class. 
  * @param mnemonicItems The mnemonic items for the calculator preferences.
  * @param calculator The calculator the menu will be on.
  */
  public PreferenceMenu(final HashMap<String, Integer> mnemonicItems, 
		  final FragileCalculator calculator)
  {
    super();
    this.mainPanel = new JPanel();
    this.mnemonicItems = mnemonicItems;
    this.calculator = calculator;
    this.currentLocale = calculator.getLocale();
    dropDownMenu = new JComboBox<>();
    currentManager = KeyboardFocusManager.getCurrentKeyboardFocusManager();
    currentDispatcher = new KeyDispatcher();
    currentManager.addKeyEventDispatcher(currentDispatcher);
    if (currentLocale.equals(Locale.GERMAN) || currentLocale.equals(Locale.GERMANY))
    {
      recordButton = new JRadioButton(RECORD_DE);
      thousandsSeparatorLabel = new JLabel(THOUSANDS_DE);
    } else if (currentLocale.equals(Locale.FRANCE) || currentLocale.equals(Locale.FRENCH))
    {
      recordButton = new JRadioButton(RECORD_FR);
      thousandsSeparatorLabel = new JLabel(THOUSANDS_FR);
    } else
    {
      recordButton = new JRadioButton(RECORD_US);
      thousandsSeparatorLabel = new JLabel(THOUSANDS_US);
    }
    this.setupWindow();
  }
  
  /**
   * Adds components and sets up the window.
   */
  private void setupWindow()
  {
    this.setTitle(calculator.preferencesLabel);
    this.setIconImage(calculator.getIconImage());
    this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    this.setupDropDown();
    onButton = new JRadioButton(calculator.onLabel);
    if (calculator.separatorsTurnedOn)
    {
      onButton.doClick();
    }
    onButton.addActionListener(this);
    offButton = new JRadioButton(calculator.offLabel);
    if (!calculator.separatorsTurnedOn)
    {
      offButton.doClick();
    }
    offButton.addActionListener(this);
    separatorButtons = new ButtonGroup();
    separatorButtons.add(onButton);
    separatorButtons.add(offButton);
    this.mainPanel.setBackground(calculator.mainColor);
    this.onButton.setBackground(calculator.mainColor);
    this.offButton.setBackground(calculator.mainColor);
    this.recordButton.setBackground(calculator.mainColor);
    this.mainPanel.add(dropDownMenu);
    this.mainPanel.add(recordButton);
    this.mainPanel.add(thousandsSeparatorLabel);
    this.mainPanel.add(onButton);
    this.mainPanel.add(offButton);
    this.add(mainPanel);
    this.pack();
    this.setVisible(true);
  }
  
  private void setupDropDown()
  {
    String[] labelArray = new String[19];
    labelArray[0] = calculator.fileLabel;
    labelArray[1] = calculator.printSessionLabel;
    labelArray[2] = calculator.newCalculatorLabel;
    labelArray[3] = calculator.exitLabel;
    labelArray[4] = calculator.modeLabel;
    labelArray[5] = calculator.properLabel;
    labelArray[6] = calculator.reducedLabel;
    labelArray[7] = calculator.viewLabel;
    labelArray[8] = calculator.pieChartLabel;
    labelArray[9] = calculator.helpLabel;
    labelArray[10] = calculator.aboutLabel;
    labelArray[11] = calculator.helpHelpLabel;
    labelArray[12] = calculator.preferencesLabel;
    labelArray[13] = calculator.editLabel;
    labelArray[14] = calculator.openLabel;
    labelArray[15] = calculator.saveLabel;
    labelArray[16] = calculator.separatorsLabel;
    labelArray[17] = calculator.onLabel;
    labelArray[18] = calculator.offLabel;
    this.dropDownMenu.setModel(new DefaultComboBoxModel<String>(labelArray));
    this.dropDownMenu.setFont(FragileButtons.plainFont);
  }
  
  /**
   * Private class to handle keyboard inputs.
   */
  private class KeyDispatcher implements KeyEventDispatcher
  {
    @Override
    public boolean dispatchKeyEvent(final KeyEvent e)
    {
      if (recordButton.isSelected()) //Radio button on, add to mnemonics.
      {
        String dropDownSelection = (String) dropDownMenu.getSelectedItem();
        int keyID = e.getKeyCode();
        mnemonicItems.put(dropDownSelection, keyID);
        calculator.overwriteMnemonic(dropDownSelection, keyID);
        recordButton.setSelected(false);
      }
      return false;
    }
  }

  
  @Override
  public void actionPerformed(final ActionEvent e)
  {
    if (e.getSource() == onButton)
    {
      calculator.sepMenuItem.doClick();
      calculator.onButton.doClick();
    }
    if (e.getSource() == offButton)
    {
      calculator.sepMenuItem.doClick();
      calculator.offButton.doClick();
    }
  }
}
