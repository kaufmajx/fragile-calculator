package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FileDialog;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URISyntaxException;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.filechooser.FileSystemView;

import app.About;
import app.HelpPageViewer;
import app.PieChartViewer;
import math.MixedFraction;
import math.Operations;
import utilities.LabelTranslations;
import utilities.ParseConfigurationFile;
import utilities.PreferencesWrapper;
import utilities.TempResourcePath;

/**
 * The main class for Fragile, a mixed fraction calculator.
 * 
 * @authors Alyssa Girard, Layla Aure, Jelal Kauffman, Joey Linneman, and John Ryder
 * @version 1.2 Honor Code: This work complies with JMU's Honor Code: -Used
 *          https://docs.oracle.com/javase/tutorial/uiswing/components/menu.html#mnemonic for help
 *          on mnemonics. -Used https://stackoverflow.com/questions/60587552/
 *          is-there-a-way-to-get-directory-path-from-filedialog-in-java for help on using
 *          FileDialog to get the path that the user specified and then write to it. -Used
 *          https://stackoverflow.com/questions/44523347/java-new-file-does-not-create-file for help
 *          creating a new file if it isn't being made. -Used
 *          https://stackoverflow.com/questions/12126987/java-mkdir-not-writing-directory for
 *          creating a new directory. -Used
 *          https://stackoverflow.com/questions/9677692/getting-my-documents-path-in-java to find
 *          the way to the user's default directory and then use it to save files.
 * 
 */
/**
 * 
 */
public class FragileCalculator extends JFrame implements ActionListener
{

  // Constants
  public static final String PERIOD_CHAR = ".";
  public static final String COMMA_CHAR = ",";
  public static final String SLASHCHARACTER = "/";
  public static final String ADDITIONCHARACTER = "+";
  public static final String SUBTRACTIONCHARACTER = "-";
  public static final String MULTIPLICATIONCHARACTER = "×";
  public static final String DIVISIONCHARACTER = "÷";
  public static final String EMPTYSTRINGCHARACTER = "";
  public static final String ONESPACECHARACTER = " ";
  public static final String FRAGILEDEFAULTS = "/FragileDefaults/";
  public static final String DEFAULTS = "defaults.fpf";
  public static final String EQUALSCHARACTER = "=";
  public static final String EQUALSSPACES = " = ";
  public static final String NEWLINECHAR = "\n";
  public static final String CURRENT_CONFIG = "starbucks.properties";
  public static final String FOCUS = "▯";
  public static final String HELP = "Help";
  public static final String PREFERENCES = "Preferences";
  protected static Font menuFont = new Font(Font.SERIF, Font.PLAIN, 12);
  protected static Font numberFont = new Font(Font.SANS_SERIF, Font.PLAIN, 19);
  protected static Font plainFont = new Font(Font.SERIF, Font.PLAIN, 20);
  // text characters
  protected static String focus = FOCUS;
  protected static String fracString = " /";
  private static final long serialVersionUID = 1L;
  private static ArrayList<FragileCalculator> frames = new ArrayList<FragileCalculator>();
  protected boolean on = true;
  protected boolean off = false;
  protected final String separatorsOn = "separatorsOn";
  protected final String properOn = "properOn";
  protected final String reducedOn = "reducedOn";
  protected JMenu sepMenuItem = new JMenu("Separators");
  protected boolean separators;
  protected JRadioButton onButton = new JRadioButton("On");
  protected JRadioButton offButton = new JRadioButton("Off");
  // Strings for menu labels (for different languages).
  protected String fileLabel;
  protected String printSessionLabel;
  protected String newCalculatorLabel;
  protected String exitLabel;
  protected String modeLabel;
  protected String properLabel;
  protected String reducedLabel;
  protected String viewLabel;
  protected String pieChartLabel;
  protected String helpLabel;
  protected String aboutLabel;
  protected String helpHelpLabel;
  protected String preferencesLabel;
  protected String editLabel;
  protected String openLabel;
  protected String saveLabel;
  protected String separatorsLabel;
  protected String onLabel;
  protected String offLabel;
  protected String openDescLabel;
  protected String saveDescLabel;

  // fonts and colors
  protected String configFileName;
  protected Color mainColor;
  protected Color displayColor;
  protected Color numberColor;
  protected Color signColor;
  protected Color operatorColor;
  protected Color deletionColor;
  
  protected JFrame frame;

  // for buttons
  protected boolean justEvaluated;

  // physical button items
  protected KeyboardFocusManager manager = KeyboardFocusManager.getCurrentKeyboardFocusManager();
  protected PhysicalDeletionButtons deletion;
  protected PhysicalNumberButtons numberButtons;
  protected PhysicalOperatorButtons operatorButtons;
  protected PhysicalSignPositionButtons signPositionButtons;

  // properties
  protected boolean shouldLoadPrefs;
  protected boolean separatorsTurnedOn;

  // session display
  protected SessionDisplay newSessionDisplay;
  // fragile buttons
  private FragileButtons fragileButtons;
  private boolean proper = true;
  private boolean reduced = false;
  // the variables for each FragileCalcualtor made
  private Container contentPane;

  // the boolean values for focus and count
  private boolean inD = false;
  private boolean inN = false;
  private boolean inD2 = false;
  private boolean inN2 = false;
  private boolean inNb = false;
  private boolean inDb = false;
  private int count = 0;
  // menu and menu bar
  private JMenu file;
  private JMenu view;
  private JMenu help;
  private JMenu mode;
  private JMenu fileMenuItem = new JMenu("File");
  private JMenu modeMenuItem = new JMenu("Mode");
  private JMenu viewMenuItem = new JMenu("View");
  private JMenu helpMenuItem = new JMenu(HELP);
  private JMenu preferences = new JMenu(PREFERENCES);
  private JMenu preferencesMenuItem = new JMenu(PREFERENCES);
  private JMenuBar menuBar = new JMenuBar();
  private JMenuItem sessionButton = new JMenuItem("Print Session");
  private JMenuItem exitButton = new JMenuItem("Exit");
  private JMenuItem newCalculatorButton = new JMenuItem("New Calculator");
  private JMenuItem pieChartItem = new JMenuItem("Pie Chart");
  private JMenuItem aboutButton = new JMenuItem("About");
  private JMenuItem helpButton = new JMenuItem(HELP);
  private JMenuItem editButton = new JMenuItem("Edit");
  private JMenuItem openButton = new JMenuItem("Open");
  private JMenuItem saveButton = new JMenuItem("Save");
  private JCheckBox properBox = new JCheckBox("Proper");
  private JCheckBox reducedBox = new JCheckBox("Reduced");
  private TempResourcePath tempResourcePath;

  // Logos and icons
  private Image logo;
  private ImageIcon icon;

  // text areas and panels for text areas
  private JPanel textAreas1 = new JPanel();
  private JPanel textAreas2 = new JPanel();
  private JTextArea displayTop = new JTextArea(2, 1);
  private JTextArea displayBottom = new JTextArea(2, 1);
  private GridBagConstraints gBConstraint;

  // Locale
  private Locale currentLocale;
  private NumberFormat nf;

  private HashMap<String, Integer> mnemonicItems;

  /**
   * Run Fragile without loading default properties.
   */
  public FragileCalculator()
  {
    super();
    this.currentLocale = Locale.getDefault();
    NumberFormat.getInstance(currentLocale);
    // Set the value of the preference
    this.configFileName = CURRENT_CONFIG;
    this.shouldLoadPrefs = false;
    runWindow();
  }

  /**
   * Run Fragile and load default properties.
   * 
   * @param shouldLoadPrefs
   *          - if preferences should be loaded or not.
   */
  public FragileCalculator(final boolean shouldLoadPrefs)
  {
    super();
    this.currentLocale = Locale.getDefault();
    NumberFormat.getInstance(currentLocale);
    // Set the value of the preference
    this.configFileName = CURRENT_CONFIG;
    this.shouldLoadPrefs = true;
    runWindow();
  }

  /**
   * Creates the Fragile JFrame and calls setup for the other components that go into the JFrame.
   */
  public void runWindow()
  {
    resourcesSetup();
    newSessionDisplay = new SessionDisplay(getLocale().toString(), this);
    if (this.icon != null)
    {
      this.setIconImage(icon.getImage());
    }
    nf = NumberFormat.getInstance(currentLocale);
    this.nf = NumberFormat.getInstance(currentLocale);

    // sets JFrame aspects
    setTitle("Fragile");
    setSize(300, 400);

    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    setLayout(new GridBagLayout()); // set the entire layout for the calculator
    resourcesSetup();
    setupLabels();
    frames.add(this);

    // adds a windowListener to each JFrame
    addWindowListener(new WindowAdapter()
    {
      @Override
      public void windowClosing(final WindowEvent e)
      {
        frames.remove(e.getWindow());
        newSessionDisplay.getID().dispose();
        newSessionDisplay.dispose();
        // Check if all frames are disposed
        if (frames.isEmpty())
        {
          // Exit the program when all frames are disposed
          newSessionDisplay.getID().dispose();
          newSessionDisplay.dispose();
          System.exit(0);
        }
        else
        {
          dispose();
        }
      }
    });

    // creating the contentPane
    contentPane = getContentPane();
    contentPane.setSize(300, 4000);
    contentPane.setLayout(new BoxLayout(this.contentPane, BoxLayout.Y_AXIS));
    contentPane.add(Box.createVerticalGlue());
    contentPane.setBackground(mainColor);

    // creating the menus
    menuCreation();
    setJMenuBar(menuBar);

    // add logo
    addLogo();

    // add display
    addDisplay();

    // add calculator buttons
    addCalculatorButtons();

    // add listeners for physical buttons
    manager.addKeyEventDispatcher(new MyDispatcher());
    deletion = new PhysicalDeletionButtons(this);
    numberButtons = new PhysicalNumberButtons(fragileButtons.getNumberButtons().getnumButtonFunct(),
        this);
    operatorButtons = new PhysicalOperatorButtons(
        fragileButtons.getOperatorButtons().getopButtonFunct(), this);
    signPositionButtons = new PhysicalSignPositionButtons(
        fragileButtons.getSignPositionButtons().getsignPosButtonFunct(), this);
    mnemonicItems = new HashMap<>();
    loadDefaultPrefs();
    setMnemonics(this.mnemonicItems);
    if (this.separatorsTurnedOn)
    {
      onButton.doClick();
    }

    // sets the other aspects of the frame and packs it
    setLocationRelativeTo(null);
    setExtendedState(JFrame.NORMAL);
    setResizable(false);
    setMaximumSize(new Dimension(300, 400));
    pack();
    setVisible(true);
  }

  /**
   * Sets up the following components: ~Constructor ~runWindow ~menuCreation ~addLogo ~addDisplay
   * ~addCalculatorButtons ~ActionListener
   */

  /* CREATING THE MENUS AND ALL THE BUTTONS */

  /**
   * creates each menu and adds them to the menu bar then to the frame.
   */
  private void menuCreation()
  {
    this.menuBar.setBackground(mainColor);
    this.menuBar.setForeground(Color.BLACK);

    // Create the File menu.
    this.file = fileMenuSetup();
    this.file.setFont(menuFont);
    this.file.setBackground(mainColor);
    this.menuBar.setForeground(Color.BLACK);
    this.menuBar.add(file);

    // Create the Mode Menu.
    this.mode = modeMenuSetup();
    this.mode.setFont(menuFont);
    this.mode.setBackground(mainColor);
    this.mode.setForeground(Color.BLACK);
    this.menuBar.add(mode);

    // Create the View menu.
    this.view = viewMenuSetup();
    this.view.setFont(menuFont);
    this.view.setBackground(mainColor);
    this.view.setForeground(Color.BLACK);
    this.menuBar.add(view);

    // Create the Help menu.
    this.help = helpMenuSetup();
    this.help.setFont(menuFont);
    this.help.setBackground(mainColor);
    this.help.setForeground(Color.BLACK);
    this.menuBar.add(help);

    // Create the Preferences menu.
    this.preferences = preferencesMenuSetup();
    this.help.setFont(menuFont);
    this.help.setBackground(mainColor);
    this.help.setForeground(Color.BLACK);
    this.menuBar.add(preferences);

    // Create the Preferences menu.
    this.sepMenuItem = separatorsMenuSetup();
    this.sepMenuItem.setFont(menuFont);
    this.sepMenuItem.setBackground(mainColor);
    this.menuBar.add(sepMenuItem);
  }

  /**
   * Sets up the file submenu.
   * 
   * @return the file submenu to add into the toolbar.
   */
  public JMenu fileMenuSetup()
  {
    this.fileMenuItem = new JMenu(fileLabel);
    this.fileMenuItem.setFont(FragileCalculator.menuFont);
    this.sessionButton = new JMenuItem(printSessionLabel);
    this.sessionButton.setFont(menuFont);
    this.sessionButton.addActionListener(this);
    this.fileMenuItem.add(sessionButton);
    this.newCalculatorButton = new JMenuItem(newCalculatorLabel);
    this.newCalculatorButton.setFont(menuFont);
    this.newCalculatorButton.addActionListener(this);
    this.fileMenuItem.add(newCalculatorButton);
    this.exitButton = new JMenuItem(exitLabel);
    this.exitButton.setFont(menuFont);
    this.exitButton.addActionListener(this);
    this.fileMenuItem.add(exitButton);
    return this.fileMenuItem;
  }

  /**
   * Sets up the mode menu.
   * 
   * @return the mode menu.
   */
  public JMenu modeMenuSetup()
  {
    this.modeMenuItem = new JMenu(modeLabel);
    this.modeMenuItem.setFont(FragileCalculator.menuFont);
    this.modeMenuItem.setBackground(mainColor);
    this.properBox = new JCheckBox(properLabel);
    this.properBox.setFont(FragileCalculator.menuFont);
    this.properBox.addActionListener(this);
    this.properBox.doClick();
    this.modeMenuItem.add(properBox);
    this.reducedBox = new JCheckBox(reducedLabel);
    this.reducedBox.setFont(FragileCalculator.menuFont);
    this.reducedBox.addActionListener(this);
    this.modeMenuItem.add(this.reducedBox);
    return this.modeMenuItem;
  }

  /**
   * Sets up the view menu.
   * 
   * @return the view menu.
   */
  public JMenu viewMenuSetup()
  {
    this.viewMenuItem = new JMenu(viewLabel);
    this.viewMenuItem.setFont(FragileCalculator.menuFont);
    this.viewMenuItem.setBackground(this.mainColor);
    this.pieChartItem = new JMenuItem(pieChartLabel);
    this.pieChartItem.setFont(FragileCalculator.menuFont);
    this.pieChartItem.addActionListener(this);
    this.viewMenuItem.add(this.pieChartItem);
    return this.viewMenuItem;
  }

  /**
   * Sets up the help menu.
   * 
   * @return the help menu.
   */
  public JMenu helpMenuSetup()
  {
    this.helpMenuItem = new JMenu(helpLabel);
    this.helpMenuItem.setFont(FragileCalculator.menuFont);
    this.helpMenuItem.setBackground(this.mainColor);
    this.aboutButton = new JMenuItem(aboutLabel);
    this.aboutButton.setFont(FragileCalculator.menuFont);
    this.aboutButton.addActionListener(this);
    this.helpMenuItem.add(this.aboutButton);
    this.helpButton = new JMenuItem(helpHelpLabel);
    this.helpButton.setFont(FragileCalculator.menuFont);
    this.helpButton.addActionListener(this);
    this.helpMenuItem.add(this.helpButton);
    return this.helpMenuItem;
  }

  /**
   * Sets up the preferences menu.
   * 
   * @return the preferences menu
   */
  public JMenu preferencesMenuSetup()
  {
    this.preferencesMenuItem = new JMenu(preferencesLabel);
    this.preferencesMenuItem.setFont(FragileCalculator.menuFont);
    this.preferencesMenuItem.setBackground(mainColor);
    this.editButton = new JMenuItem(editLabel);
    this.editButton.setFont(FragileCalculator.menuFont);
    this.editButton.addActionListener(this);
    this.preferencesMenuItem.add(editButton);
    this.openButton = new JMenuItem(openLabel);
    this.openButton.setFont(FragileCalculator.menuFont);
    this.openButton.addActionListener(this);
    this.preferencesMenuItem.add(openButton);
    this.saveButton = new JMenuItem(saveLabel);
    this.saveButton.setFont(FragileCalculator.menuFont);
    this.saveButton.addActionListener(this);
    this.preferencesMenuItem.add(this.saveButton);
    return this.preferencesMenuItem;
  }

  /**
   * Sets up the separators menu.
   * 
   * @return the separators menu.
   */
  public JMenu separatorsMenuSetup()
  {
    this.sepMenuItem = new JMenu(separatorsLabel);
    this.sepMenuItem.setFont(menuFont);
    this.sepMenuItem.setBackground(this.mainColor);
    ButtonGroup styleButtons = new ButtonGroup();
    this.onButton = new JRadioButton(onLabel);
    this.onButton.addActionListener(this);
    this.onButton.setFont(FragileCalculator.menuFont);
    this.sepMenuItem.add(this.onButton);
    styleButtons.add(this.onButton);
    this.offButton = new JRadioButton(offLabel);
    this.offButton.addActionListener(this);
    this.offButton.doClick();
    this.offButton.setFont(FragileCalculator.menuFont);
    this.sepMenuItem.add(this.offButton);
    styleButtons.add(this.offButton);
    return this.sepMenuItem;
  }

  /**
   * Sets up the text in the buttons to support different languages.
   */
  private void setupLabels()
  {
    String[] labelArray;
    if (currentLocale.equals(Locale.GERMANY))
    {
      labelArray = LabelTranslations.getLabelsGER();
    }
    else if (currentLocale.equals(Locale.FRANCE))
    {
      labelArray = LabelTranslations.getLabelsFR();
    }
    else
    {
      labelArray = LabelTranslations.getLabelsUS();
    }
    fileLabel = labelArray[0];
    printSessionLabel = labelArray[1];
    newCalculatorLabel = labelArray[2];
    exitLabel = labelArray[3];
    modeLabel = labelArray[4];
    properLabel = labelArray[5];
    reducedLabel = labelArray[6];
    viewLabel = labelArray[7];
    pieChartLabel = labelArray[8];
    helpLabel = labelArray[9];
    aboutLabel = labelArray[10];
    helpHelpLabel = labelArray[11];
    preferencesLabel = labelArray[12];
    editLabel = labelArray[13];
    openLabel = labelArray[14];
    saveLabel = labelArray[15];
    separatorsLabel = labelArray[16];
    onLabel = labelArray[17];
    offLabel = labelArray[18];
    openDescLabel = labelArray[19];
    saveDescLabel = labelArray[20];
  }

  /**
   * Adds the logo to the current JFrame.
   */
  private void addLogo()
  {
    GridBagConstraints gbc = new GridBagConstraints();
    gbc.gridx = 5;
    gbc.gridy = 0;
    if (this.logo != null)
    {
      logo = logo.getScaledInstance(100, 30, java.awt.Image.SCALE_SMOOTH);
      ImageIcon scaledLogo = new ImageIcon(logo);
      JLabel logoLabel = new JLabel(scaledLogo);
      logoLabel.setBorder(BorderFactory.createEmptyBorder(6, 0, 4, 0));
      contentPane.add(logoLabel, gbc);
    }
  }

  /**
   * Adds the displays that Fragile uses to display data.
   */
  private void addDisplay()
  {
    // First half display for typing.
    this.gBConstraint = new GridBagConstraints();
    this.gBConstraint.gridwidth = 1;
    this.gBConstraint.gridx = 0;
    this.gBConstraint.gridy = 1;
    this.textAreas1.setLayout(new GridLayout(1, 1));
    this.textAreas1.setBackground(displayColor);
    this.displayTop.setBackground(displayColor);
    this.displayTop.setLineWrap(true);
    this.displayTop.setWrapStyleWord(true);
    this.displayTop.setFont(FragileCalculator.numberFont);
    this.displayTop.setBackground(displayColor);
    this.displayTop.setEditable(false);
    this.textAreas1.add(this.displayTop);

    // Spacing.
    JPanel space = new JPanel();
    space.setBackground(displayColor);
    JPanel space2 = new JPanel();
    space2.setBackground(displayColor);
    JPanel space3 = new JPanel();
    space3.setBackground(displayColor);

    // Second half display for typing.
    this.gBConstraint.gridwidth = 1;
    this.gBConstraint.gridx = 1;
    this.gBConstraint.gridy = 1;
    this.textAreas2.setLayout(new GridLayout(1, 1));
    this.textAreas2.setBackground(displayColor);
    this.textAreas2.add(Box.createRigidArea(new Dimension(1, 0)));
    this.textAreas2.add(Box.createRigidArea(new Dimension(1, 0)));
    this.displayBottom.setFont(FragileCalculator.numberFont);
    this.displayBottom.setBackground(displayColor);
    this.displayBottom.setText(FOCUS);
    this.textAreas2.add(this.displayBottom, BorderLayout.EAST);
    this.contentPane.add(this.textAreas1, this.gBConstraint);
    this.contentPane.add(this.textAreas2, this.gBConstraint);
  }

  /**
   * Get the display top.
   * 
   * @return the display top.
   */
  public JTextArea getDisplayTop()
  {
    return this.displayTop;
  }

  /**
   * Set the display top to a new display.
   * 
   * @param newDisplayTop
   *          - the new display to use.
   */
  public void setDisplayTop(final JTextArea newDisplayTop)
  {
    this.displayTop = newDisplayTop;
  }

  /**
   * Get the display bottom.
   * 
   * @return the display bottom.
   */
  public JTextArea getDisplayBottom()
  {
    return this.displayBottom;
  }

  /**
   * Set the display bottom to a new display.
   * 
   * @param newDisplayBottom
   *          - the new display to use.
   */
  public void setDisplayBottom(final JTextArea newDisplayBottom)
  {
    this.displayBottom = newDisplayBottom;
  }

  /**
   * Gets the NumberFormat that this Fragile window is using.
   * 
   * @return the NumberFormat.
   */
  public NumberFormat getFormatForLocale()
  {
    return this.nf;
  }

  /**
   * Gets if the focus is in the denominator of the first fraction.
   * 
   * @return if the focus is in the denominator.
   */
  public boolean getinD()
  {
    return inD;
  }

  /**
   * Gets if the focus is in the numerator of the first fraction.
   * 
   * @return if the focus is in the numerator.
   */
  public boolean getinN()
  {
    return inN;
  }

  /**
   * Gets if the focus is in the denominator of the second fraction.
   * 
   * @return if the focus is in the denominator.
   */
  public boolean getinD2()
  {
    return inD2;
  }

  /**
   * Gets if the focus is in the numerator of the second fraction.
   * 
   * @return if the focus is in the numerator.
   */
  public boolean getinN2()
  {
    return inN2;
  }

  /**
   * Returns if currently in denominator or not.
   * 
   * @return inNb if currently in denominator or not.
   */
  public boolean getinNb()
  {
    return inNb;
  }

  /**
   * Returns if currently in denominator or not.
   * 
   * @return inDb if currently in denominator or not.
   */
  public boolean getinDb()
  {
    return inDb;
  }

  /**
   * Gets if the calculator is set to be proper or not.
   * 
   * @return if the calculator is set to proper or not.
   */
  public boolean getProper()
  {
    return proper;
  }

  /**
   * Gets the count of fractions in the display.
   * 
   * @return the number of fractions in the display.
   */
  public int getCount()
  {
    return count;
  }

  /**
   * Sets focus to be in the denominator.
   * 
   * @param var
   *          - if the focus should be in the denominator or not.
   */
  public void setinD(final boolean var)
  {
    inD = var;
  }

  /**
   * Sets focus to be in the numerator.
   * 
   * @param var
   *          - if the focus should be in the numerator or not.
   */
  public void setinN(final boolean var)
  {
    inN = var;
  }

  /**
   * Sets if the focus should be in the denominator of the second fraction.
   * 
   * @param var
   *          - if the focus should be in the denominator or not.
   */
  public void setinD2(final boolean var)
  {
    inD2 = var;
  }

  /**
   * Sets if the focus should be in the numerator of the second fraction.
   * 
   * @param var
   *          - if the focus should be in the numerator or not.
   */
  public void setinN2(final boolean var)
  {
    inN2 = var;
  }

  /**
   * Sets if the focus should be in this spot's number.
   * 
   * @param var
   *          - if the focus should be in this spot.
   */
  public void setinNb(final boolean var)
  {
    inNb = var;
  }

  /**
   * Sets if the focus should be in this spot's numerator.
   * 
   * @param var
   *          - if the focus should be in this spot.
   */
  public void setinDb(final boolean var)
  {
    inDb = var;
  }

  /**
   * Sets if the focus should be in this spot's denominator.
   * 
   * @param var
   *          - if the focus should be in this spot.
   */
  public void setProper(final boolean var)
  {
    proper = var;
  }

  /**
   * Sets the new count.
   * 
   * @param newCount
   *          - the new count to use.
   */
  public void setCount(final int newCount)
  {
    count = newCount;
  }

  /**
   * Gets if justEvaluated is set or not.
   * 
   * @return if justEvaluated is set.
   */
  public boolean getJustEvaluated()
  {
    return this.justEvaluated;
  }

  /**
   * Sets justEvaluated.
   * 
   * @param val
   *          - if justEvaluated should be set or not.
   */
  public void setJustEvaluated(final boolean val)
  {
    this.justEvaluated = val;
  }

  /**
   * Get if the reduced flag is set or not.
   * 
   * @return if the reduced flag is set.
   */
  public boolean getReduced()
  {
    return this.reduced;
  }

  /**
   * Sets the reduced flag.
   * 
   * @param val
   *          - the new state of the reduced flag.
   */
  public void setReduced(final boolean val)
  {
    this.reduced = val;
  }

  /**
   * 
   * Returns the SessionDisplay.
   * 
   * @return the SessionDisplay.
   */
  public SessionDisplay getSessionDisplay()
  {
    return newSessionDisplay;
  }

  /**
   * Creates the calculator buttons used by Fragile.
   */
  private void addCalculatorButtons()
  {
    gBConstraint = new GridBagConstraints();
    /* adds buttons */
    gBConstraint.gridx = 0;
    gBConstraint.gridy = 2;

    // contentPane.add(new CalculatorButtons(), this.gBConstraintsonstraints);
    fragileButtons = new FragileButtons(this);
    contentPane.add(fragileButtons.setupLayout(), this.gBConstraint);
    setExtendedState(JFrame.NORMAL);
    setResizable(false);
    setMaximumSize(new Dimension(300, 400));
    setVisible(true);
  }

  @Override
  public void actionPerformed(final ActionEvent e)
  {
    if (e.getSource() == exitButton)
    {
      frames.remove(this);

      // Check if all frames are disposed
      if (frames.isEmpty())
      {
        // Exit the program when all frames are disposed
        System.exit(0);
      }
      else
      {
        // dispose of the current frame
        this.newSessionDisplay.getID().dispose();
        this.newSessionDisplay.dispose();
        dispose();
      }
    }
    if (e.getSource() == sessionButton)
    {
      // calls the method printSession in the SessionDisplay which prints the SessionDisplay
      this.newSessionDisplay.printSession(this);
    }
    if (e.getSource() == newCalculatorButton)
    {
      // creates a new FragileCalculator
      new FragileCalculator();
    }
    if (e.getSource() == aboutButton)
    {
      if (this.currentLocale.equals(Locale.GERMANY))
      {
        About.aboutMainGER(this);
      }
      else if (this.currentLocale.equals(Locale.FRANCE))
      {
        About.aboutMainFR(this);
      }
      else
      {
        About.aboutMainEN(this);
      }
    }
    if (e.getSource() == helpButton)
    {
      if (this.currentLocale.equals(Locale.GERMANY))
      {
        HelpPageViewer.webpageStarterGER();
      }
      else if (this.currentLocale.equals(Locale.FRANCE))
      {
        HelpPageViewer.webpageStarterFR();
      }
      else
      {
        HelpPageViewer.webpageStarterEN();
      }
    }
    if (e.getSource() == pieChartItem)
    {
      String bottomState = this.displayBottom.getText();
      String topState = this.displayTop.getText();
      bottomState = bottomState.replace(focus, EMPTYSTRINGCHARACTER);
      bottomState = bottomState.replace(SLASHCHARACTER, EMPTYSTRINGCHARACTER);
      String bottomCheck = bottomState.replace(ONESPACECHARACTER, EMPTYSTRINGCHARACTER);
      if (!bottomCheck.equals(EMPTYSTRINGCHARACTER)
          && !(topState.contains(this.displayBottom.getText())))
      // Something in the bottom, use it.
      {
        PieChartViewer currentFractionPie = new PieChartViewer(this,
            this.getCurrentFraction(false));
        currentFractionPie.setColor(displayColor.getRed(), displayColor.getGreen(),
            displayColor.getBlue());
        currentFractionPie.createPieChart();
      }
      else
      {
        String[] topParts = topState.split(Operations.getOperationsRegex());
        MixedFraction frac1 = MixedFraction.parseMixedFractionFromString(topParts[0]);
        MixedFraction frac2 = MixedFraction.parseMixedFractionFromString(topParts[1].substring(1));
        String[] equationFromAnswer = topState.split(" =");
        String operator = EMPTYSTRINGCHARACTER;
        if (equationFromAnswer[0].contains(SUBTRACTIONCHARACTER))
        {
          operator = SUBTRACTIONCHARACTER;
        }
        if (equationFromAnswer[0].contains(DIVISIONCHARACTER))
        {
          operator = DIVISIONCHARACTER;
        }
        if (equationFromAnswer[0].contains(ADDITIONCHARACTER))
        {
          operator = ADDITIONCHARACTER;
        }
        if (equationFromAnswer[0].contains(MULTIPLICATIONCHARACTER))
        {
          operator = MULTIPLICATIONCHARACTER;
        }
        MixedFraction frac3 = Operations.evaluteCurrentExpression(equationFromAnswer[0]);
        PieChartViewer currentFractionPie = new PieChartViewer(frac1, frac2, frac3, operator, this);
        currentFractionPie.setColor(displayColor.getRed(), displayColor.getGreen(),
            displayColor.getBlue());
        currentFractionPie.createPieChart();
      }
    }
    if (e.getSource() == properBox)
    {
      if (proper)
      {
        proper = false;
      }
      else
      {
        proper = true;
      }
    }
    if (e.getSource() == reducedBox)
    {
      if (reduced)
      {
        reduced = false;
      }
      else
      {
        reduced = true;
      }

    }
    if (e.getSource() == editButton)
    {
      new PreferenceMenu(this.mnemonicItems, this);
    }
    if (e.getSource() == openButton)
    {

      JFrame openParent = new JFrame(openLabel);
      openParent.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
      FileDialog openDialog = new FileDialog(openParent, openDescLabel, FileDialog.LOAD);
      openDialog.setLocale(Locale.getDefault());
      openDialog.setVisible(true);
      String filePath = openDialog.getDirectory();
      String fileName = filePath + openDialog.getFile();
      File selectedPath = new File(fileName);
      if (fileName != null)
      {
        FileInputStream fileIn;
        try
        {
          fileIn = new FileInputStream(selectedPath);
          ObjectInputStream objectIn = new ObjectInputStream(fileIn);
          PreferencesWrapper wrappedPreferences = (PreferencesWrapper) objectIn.readObject();
          HashMap<String, Integer> readMap = wrappedPreferences.getMnemonicItems();
          this.separatorsTurnedOn = wrappedPreferences.getSepsOn();
          if (readMap != null)
          {
            this.mnemonicItems = readMap;
            this.setMnemonics(this.mnemonicItems);
          }
          if (this.separatorsTurnedOn)
          {
            onButton.doClick();
          }
          objectIn.close();
        }
        catch (IOException e2)
        {
          System.out.println("Cannot find the file specified!");
          e2.printStackTrace();
        }
        catch (ClassNotFoundException e1)
        {
          System.out.println("Cannot set preferences!");
          e1.printStackTrace();
        }
      }
    }

    if (e.getSource() == saveButton)
    {
      JFrame saveParent = new JFrame(saveLabel);
      saveParent.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
      FileDialog saveDialog = new FileDialog(saveParent, saveDescLabel, FileDialog.SAVE);
      saveDialog.setLocale(Locale.getDefault());
      saveDialog.setVisible(true);
      String filePath = saveDialog.getDirectory();
      String fileName = filePath + saveDialog.getFile() + ".fpf";
      File selectedPath = new File(fileName);
      if (fileName != null)
      {
        FileOutputStream fileOut;
        FileOutputStream defaultFileOut;
        try
        {
          String defaultUserDirectory = FileSystemView.getFileSystemView().getDefaultDirectory()
              .getPath();
          String fragileStorageDirectory = defaultUserDirectory + FRAGILEDEFAULTS;
          String pathToDefaults = fragileStorageDirectory + DEFAULTS;
          fileOut = new FileOutputStream(selectedPath);
          defaultFileOut = new FileOutputStream(pathToDefaults);
          ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
          ObjectOutputStream defaultsOut = new ObjectOutputStream(defaultFileOut);
          PreferencesWrapper wrappedPreferences = new PreferencesWrapper(this.mnemonicItems,
              this.separatorsTurnedOn);
          objectOut.writeObject(wrappedPreferences);
          defaultsOut.writeObject(wrappedPreferences);
          objectOut.close();
          defaultsOut.close();
        }
        catch (IOException e1)
        {
          System.out.println("Cannot find file specified!");
          e1.printStackTrace();
        }
      }

    }

    if (e.getSource() == onButton)
    {
      separators = true;
      this.separatorsTurnedOn = true;
      separatorsOn(displayBottom.getText(), displayTop.getText());
    }
    if (e.getSource() == offButton)
    {
      separators = false;
      this.separatorsTurnedOn = false;
      separatorsOff(displayBottom.getText(), displayTop.getText());
    }
  }

  /**
   * Turns on the separators, adding them to the bottom and to the top.
   * 
   * @param currentBottom
   *          - the current bottom display.
   * @param currentTop
   *          - the current top display.
   */
  public void separatorsOn(final String currentBottom, final String currentTop)
  {
    String newBottom = EMPTYSTRINGCHARACTER;
    String newTop = EMPTYSTRINGCHARACTER;

    // get each number in an array
    String[] currBottomFraction = parseNums(currentBottom);

    // format with separators
    formatNums(currBottomFraction);

    // add back spacing
    if (currBottomFraction[0].equals(EMPTYSTRINGCHARACTER)
        && currBottomFraction[1] != EMPTYSTRINGCHARACTER)
      newBottom += currBottomFraction[1] + SLASHCHARACTER + currBottomFraction[2];
    else if (currBottomFraction[0].length() <= 1
        && currBottomFraction[1].equals(EMPTYSTRINGCHARACTER))
      newBottom += FOCUS;
    else
      newBottom += currBottomFraction[0] + ONESPACECHARACTER + currBottomFraction[1]
          + SLASHCHARACTER + currBottomFraction[2];

    if (currentTop.length() > 1)
    {
      // split expression into parts
      String[] fracs = this.displayTop.getText().split("[-×÷^+=]");

      // get each number in an array from expression
      String[] currTopFraction = new String[9];

      // first fraction
      String[] firstFrac = parseNums(fracs[0]);
      currTopFraction[0] = firstFrac[0];
      currTopFraction[1] = firstFrac[1];
      currTopFraction[2] = firstFrac[2];

      if (currentTop.contains(EQUALSCHARACTER))
      {
        // second fraction
        String[] secondFrac = parseNums(fracs[1]);
        currTopFraction[3] = secondFrac[0];
        currTopFraction[4] = secondFrac[1];
        currTopFraction[5] = secondFrac[2];

        // result
        String[] result = parseNums(fracs[2]);
        currTopFraction[6] = result[0];
        currTopFraction[7] = result[1];
        currTopFraction[8] = result[2];
      }
      // format with separators
      formatNums(currTopFraction);

      // add back spacing and focus
      if (currTopFraction[0].equals(EMPTYSTRINGCHARACTER))
        newTop += currTopFraction[1] + SLASHCHARACTER + currTopFraction[2] + ONESPACECHARACTER
            + getCurrentOperation(this.displayTop.getText());
      else if (currTopFraction[1].equals(EMPTYSTRINGCHARACTER))
        newTop = currTopFraction[0] + ONESPACECHARACTER + currTopFraction[1] + SLASHCHARACTER
            + currTopFraction[2] + ONESPACECHARACTER
            + getCurrentOperation(this.displayTop.getText());
      else
        newTop = currTopFraction[0] + ONESPACECHARACTER
            + getCurrentOperation(this.displayTop.getText());

      if (currentTop.contains(EQUALSCHARACTER))
      {
        String equalsCharWithSpaces = EQUALSSPACES;
        if (currTopFraction[3].equals(EMPTYSTRINGCHARACTER))
          newTop += ONESPACECHARACTER + currTopFraction[4] + SLASHCHARACTER + currTopFraction[5];
        else if (currTopFraction[4].equals(EMPTYSTRINGCHARACTER))
          newTop += ONESPACECHARACTER + currTopFraction[3] + ONESPACECHARACTER + currTopFraction[4]
              + SLASHCHARACTER + currTopFraction[5];
        else
          newTop += ONESPACECHARACTER + currTopFraction[3];

        if (currTopFraction[6].equals(EMPTYSTRINGCHARACTER))
          newTop += equalsCharWithSpaces + currTopFraction[7] + SLASHCHARACTER + currTopFraction[8];
        else if (currTopFraction[7] != EMPTYSTRINGCHARACTER)
          newTop += equalsCharWithSpaces + currTopFraction[6] + ONESPACECHARACTER
              + currTopFraction[7] + SLASHCHARACTER + currTopFraction[8];
        else
          newTop += equalsCharWithSpaces + currTopFraction[6];
      }
    }

    this.displayBottom.setText(newBottom);
    this.displayTop.setText(newTop);
  }

  /**
   * Turns off the separators, removing them from the displays.
   * 
   * @param currentBottom
   *          - the current bottom display.
   * @param currentTop
   *          - the current top display.
   */
  public void separatorsOff(final String currentBottom, final String currentTop)
  {
    String newBottom = EMPTYSTRINGCHARACTER;
    String newTop = EMPTYSTRINGCHARACTER;

    newBottom = remove(currentBottom);
    newTop = remove(currentTop);

    this.displayBottom.setText(newBottom);
    this.displayTop.setText(newTop);
  }

  /**
   * Private method to parse when turning on separators.
   * 
   * @param curr
   *          The current display text.
   * @return a String array of each number without any spaces or slash
   */
  private String[] parseNums(final String curr)
  {
    String[] nums = null;
    String[] allNums = {EMPTYSTRINGCHARACTER, EMPTYSTRINGCHARACTER, EMPTYSTRINGCHARACTER};

    if (curr.length() <= 1)
    {
      allNums[0] = EMPTYSTRINGCHARACTER;
      allNums[1] = EMPTYSTRINGCHARACTER;
      allNums[2] = EMPTYSTRINGCHARACTER;
      return allNums;
    }

    String trimmedCurr = curr.trim();
    String[] wholeAndFrac = trimmedCurr.split(ONESPACECHARACTER);

    // whole number and fraction
    if (wholeAndFrac.length > 1 && wholeAndFrac[1].length() > 1)
      nums = wholeAndFrac[1].split(SLASHCHARACTER);
    else if (wholeAndFrac[0].contains(SLASHCHARACTER))
      nums = wholeAndFrac[0].split(SLASHCHARACTER);

    if (nums == null)
    {
      nums = new String[2];
      nums[0] = EMPTYSTRINGCHARACTER;
      nums[1] = EMPTYSTRINGCHARACTER;
    }

    // whole number
    if (wholeAndFrac[0].contains(SLASHCHARACTER))
      allNums[0] = EMPTYSTRINGCHARACTER;
    else
      allNums[0] = wholeAndFrac[0];
    // numerator
    allNums[1] = nums[0];
    // denominator
    if (nums.length < 2)
      allNums[2] = EMPTYSTRINGCHARACTER;
    else
      allNums[2] = nums[1];

    return allNums;
  }

  /**
   * Private helper method to format the numbers with thousands separators.
   *
   * @param currFraction
   *          the current fraction as an array of Strings
   * @return currFraction the current fraction as an array of Strings.
   */
  private String[] formatNums(final String[] currFraction)
  {
    for (int i = 0; i < currFraction.length; i++)
    {
      if (currFraction[i] != null && currFraction[i].contains(FOCUS))
      {
        String[] focusAndNum = new String[2];
        focusAndNum[0] = currFraction[i].replace(FOCUS, EMPTYSTRINGCHARACTER);
        focusAndNum[1] = FOCUS;

        if (focusAndNum[0] != FOCUS)
        {
          try
          {
            focusAndNum[0] = nf.format(Double.parseDouble(focusAndNum[0]));
          }
          catch (NumberFormatException e)
          {

          }
        }

        currFraction[i] = focusAndNum[0] + focusAndNum[1];
      }
      else if (currFraction[i] != null && currFraction[i] != EMPTYSTRINGCHARACTER)
      {
        try
        {
          currFraction[i] = nf.format(Double.parseDouble(currFraction[i]));
        }
        catch (NumberFormatException e)
        {

        }
      }
    }

    return currFraction;
  }

  /**
   * Private helper method to remove thousands separators.
   *
   * @param currFraction
   *          the current fraction as an array of Strings.
   * @return newFrac the new fraction after removing the thounsands separators.
   */
  public static String remove(final String currFraction)
  {
    String sep = EMPTYSTRINGCHARACTER;
    String newFrac = EMPTYSTRINGCHARACTER;
    if (currFraction.contains(COMMA_CHAR))
    {
      sep = COMMA_CHAR;
      newFrac = currFraction.replace(sep, EMPTYSTRINGCHARACTER);
    }
    else if (currFraction.contains(PERIOD_CHAR))
    {
      sep = PERIOD_CHAR;
      newFrac = currFraction.replace(sep, EMPTYSTRINGCHARACTER);
    }
    else
    {
      newFrac = currFraction;
    }

    return newFrac;
  }

  /**
   * Private method to get the current operation from the top display.
   * 
   * @param currentTop
   *          A string of the content in the top display.
   * @return the operation being used
   */
  private String getCurrentOperation(final String currentTop)
  {
    String arrowUpChar = "^";
    String returnVal = "";
    if (currentTop.contains(ADDITIONCHARACTER))
      returnVal = ADDITIONCHARACTER;
    else if (currentTop.contains(MULTIPLICATIONCHARACTER))
      returnVal = MULTIPLICATIONCHARACTER;
    else if (currentTop.contains(DIVISIONCHARACTER))
      returnVal = DIVISIONCHARACTER;
    else if (currentTop.contains(arrowUpChar))
      returnVal = arrowUpChar;
    else if (currentTop.contains(SUBTRACTIONCHARACTER))
      returnVal = SUBTRACTIONCHARACTER;
    else
      returnVal = EMPTYSTRINGCHARACTER;
    return returnVal;
  }

  /**
   * Sets up resources to use resources in the file menu.
   */
  private void resourcesSetup()
  {
    try // Setting up colors from config file.
    {
      tempResourcePath = new TempResourcePath();
      ArrayList<String> configsFromFile = ParseConfigurationFile
          .getConfigsFromFile(SLASHCHARACTER + configFileName + SLASHCHARACTER);
      ImageIcon logoIcon = new ImageIcon(tempResourcePath.getTempResourceString() + SLASHCHARACTER
          + configsFromFile.get(0) + SLASHCHARACTER);
      logo = logoIcon.getImage();
      icon = new ImageIcon(tempResourcePath.getTempResourceString() + SLASHCHARACTER
          + configsFromFile.get(1) + SLASHCHARACTER);
      mainColor = new Color(Integer.parseInt(configsFromFile.get(3)),
          Integer.parseInt(configsFromFile.get(4)), Integer.parseInt(configsFromFile.get(5)));
      displayColor = new Color(Integer.parseInt(configsFromFile.get(6)),
          Integer.parseInt(configsFromFile.get(7)), Integer.parseInt(configsFromFile.get(8)));
      numberColor = new Color(Integer.parseInt(configsFromFile.get(9)),
          Integer.parseInt(configsFromFile.get(10)), Integer.parseInt(configsFromFile.get(11)));
      signColor = new Color(Integer.parseInt(configsFromFile.get(12)),
          Integer.parseInt(configsFromFile.get(13)), Integer.parseInt(configsFromFile.get(14)));
      operatorColor = new Color(Integer.parseInt(configsFromFile.get(15)),
          Integer.parseInt(configsFromFile.get(16)), Integer.parseInt(configsFromFile.get(17)));
      deletionColor = new Color(Integer.parseInt(configsFromFile.get(18)),
          Integer.parseInt(configsFromFile.get(19)), Integer.parseInt(configsFromFile.get(20)));
    }
    catch (IOException | URISyntaxException e) // Problem with config file or temp resources.
    {
      try // Try to use defaults.
      {
        tempResourcePath = new TempResourcePath();
        ArrayList<String> configsFromFile = ParseConfigurationFile
            .getConfigsFromFile("/FragileDefaults.properties/");
        ImageIcon logoIcon = new ImageIcon(tempResourcePath.getTempResourceString() + SLASHCHARACTER
            + configsFromFile.get(0) + SLASHCHARACTER);
        logo = logoIcon.getImage();
        icon = new ImageIcon(tempResourcePath.getTempResourceString() + SLASHCHARACTER
            + configsFromFile.get(1) + SLASHCHARACTER);
        mainColor = new Color(Integer.parseInt(configsFromFile.get(3)),
            Integer.parseInt(configsFromFile.get(4)), Integer.parseInt(configsFromFile.get(5)));
        displayColor = new Color(Integer.parseInt(configsFromFile.get(6)),
            Integer.parseInt(configsFromFile.get(7)), Integer.parseInt(configsFromFile.get(8)));
        numberColor = new Color(Integer.parseInt(configsFromFile.get(9)),
            Integer.parseInt(configsFromFile.get(10)), Integer.parseInt(configsFromFile.get(11)));
        signColor = new Color(Integer.parseInt(configsFromFile.get(12)),
            Integer.parseInt(configsFromFile.get(13)), Integer.parseInt(configsFromFile.get(14)));
        operatorColor = new Color(Integer.parseInt(configsFromFile.get(15)),
            Integer.parseInt(configsFromFile.get(16)), Integer.parseInt(configsFromFile.get(17)));
        deletionColor = new Color(Integer.parseInt(configsFromFile.get(18)),
            Integer.parseInt(configsFromFile.get(19)), Integer.parseInt(configsFromFile.get(20)));
      }
      catch (IOException | URISyntaxException f)
      {
        logo = null;
        icon = null;
        mainColor = new Color(204, 204, 204);
        displayColor = new Color(210, 237, 255);
        numberColor = new Color(0, 0, 0);
        signColor = new Color(140, 76, 131);
        operatorColor = new Color(81, 154, 151);
        deletionColor = new Color(150, 153, 72);
      }
    }
  }

  /* FOCUS METHODS */

  /**
   * Handles when a button is pressed.
   * 
   * @param output
   *          The String to be concatenated with the current output.
   */
  public void buttonPressed(final String output)
  {
    displayBottom.setText(displayBottom.getText() + output);
    System.out.println(displayBottom.getText());
  }

  /**
   * Moves the focus indicator in the fraction part of the mixed fraction.
   * 
   * @param num
   *          The number key clicked.
   */
  public void moveFocusFrac(final String num)
  {
    String current = this.displayBottom.getText();
    String newDisplay = current;

    // in whole number
    if (count == 0)
    {
      newDisplay = current.replace(focus, EMPTYSTRINGCHARACTER);
      newDisplay += FragileCalculator.focus;
      newDisplay += num;
      newDisplay = newDisplay.replace(fracString, EMPTYSTRINGCHARACTER);
      newDisplay += fracString;
    }

    // in denominator
    else if (count % 2 == 0)
    {
      String[] parts;
      newDisplay = current.replace(FragileCalculator.focus, EMPTYSTRINGCHARACTER);
      parts = newDisplay.split(SLASHCHARACTER);
      if (parts.length > 0)
      {
        newDisplay = parts[0];
        newDisplay += SLASHCHARACTER;
      }
      else
      {
        newDisplay = EMPTYSTRINGCHARACTER;
        newDisplay += SLASHCHARACTER;
      }
      if (parts.length > 1)
      {
        newDisplay += parts[1] + num + focus;
      }
      else
      {
        newDisplay += num + focus;
      }

      this.displayBottom.setText(newDisplay);
    }

    // in numerator
    else if (count % 2 != 0)
    {
      String[] parts;
      newDisplay = current.replace(FragileCalculator.focus, EMPTYSTRINGCHARACTER);
      parts = newDisplay.split(SLASHCHARACTER);
      if (parts.length > 0)
      {
        newDisplay = parts[0] + num;
        newDisplay += FragileCalculator.focus + SLASHCHARACTER;
      }
      else
      {
        newDisplay = EMPTYSTRINGCHARACTER;
        newDisplay += num;
        newDisplay += SLASHCHARACTER;
      }
      if (parts.length > 1)
      {
        newDisplay += parts[1];
      }

      this.displayBottom.setText(newDisplay);
    }
    this.displayBottom.setText(newDisplay);

  }

  /**
   * Moves the focus indicator.
   */
  public void moveFocus()
  {
    String current = displayBottom.getText();
    String newDisplay = EMPTYSTRINGCHARACTER;
    if (count == 0)
    {
      newDisplay = current.replace(focus, EMPTYSTRINGCHARACTER);
      newDisplay += focus;
      newDisplay = newDisplay.replace(fracString, EMPTYSTRINGCHARACTER);
      newDisplay += fracString;
    }
    else if (count % 2 == 0)
    {
      if (inN)
      {
        newDisplay = current.replace(focus, EMPTYSTRINGCHARACTER);
        newDisplay = newDisplay.replace(fracString, EMPTYSTRINGCHARACTER);
        newDisplay += focus;
      }
      else if (inD)
      {
        newDisplay = current.replace(focus, EMPTYSTRINGCHARACTER);
        newDisplay = newDisplay.replace(fracString, EMPTYSTRINGCHARACTER);
        newDisplay += focus;
      }
      else
      {
        newDisplay = current.replace(focus, EMPTYSTRINGCHARACTER);
        newDisplay = newDisplay.replace(fracString, EMPTYSTRINGCHARACTER);
        newDisplay += fracString;
        newDisplay += focus;
      }
    }
    else if (count % 2 != 0)
    {
      if (inN)
      {
        newDisplay = current.replace(focus, EMPTYSTRINGCHARACTER);
        newDisplay = newDisplay.replace(fracString, EMPTYSTRINGCHARACTER);
        newDisplay += focus;
      }
      else if (inD)
      {
        newDisplay = current.replace(focus, EMPTYSTRINGCHARACTER);
        newDisplay = newDisplay.replace(fracString, EMPTYSTRINGCHARACTER);
        newDisplay += ONESPACECHARACTER + focus;
      }
      else
      {
        newDisplay = current.replace(focus, EMPTYSTRINGCHARACTER);
        newDisplay = newDisplay.replace(fracString, EMPTYSTRINGCHARACTER);
        newDisplay += ONESPACECHARACTER + focus + SLASHCHARACTER;
      }
    }
    this.displayBottom.setText(newDisplay);
  }

  /**
   * Moves the current mixed fraction to the expression.
   */
  public void moveToLeft()
  {
    if (justEvaluated)
    {
      displayBottom.setText(EMPTYSTRINGCHARACTER);
    }
    else if (getCurrentFraction(true) != null)
    {
      String subText = displayBottom.getText().replace(focus, EMPTYSTRINGCHARACTER);

      // checks if it is only a whole number
      String[] fracParts = displayBottom.getText().split(ONESPACECHARACTER);

      String current = displayBottom.getText();
      String operator = current.substring(subText.length() - 1);

      if (fracParts[1].equals(SLASHCHARACTER))
      {
        subText = current.replace(focus, EMPTYSTRINGCHARACTER);
        subText = subText.replace(SLASHCHARACTER, EMPTYSTRINGCHARACTER);
        subText = subText.substring(0, subText.length() - 3);
        subText += operator;
      }

      // deals invalid numerator or denominator. Replaces blanks with 1.
      else if (fracParts[1].contains(SLASHCHARACTER))
      {
        subText = getCurrentFraction(false) + operator;
      }

      displayTop.setText(subText);
      displayBottom.setText(EMPTYSTRINGCHARACTER);
    }
    else if (getCurrentFraction(true) == null)
    {
      String current = displayBottom.getText();
      String subText = current.replace(focus, EMPTYSTRINGCHARACTER);
      String operator = current.substring(subText.length() - 1);
      subText = subText.replace(SLASHCHARACTER, EMPTYSTRINGCHARACTER);
      subText = subText.substring(0, subText.length() - 3);
      subText += operator;
      displayTop.setText(subText);
      displayBottom.setText(EMPTYSTRINGCHARACTER);
    }

  }

  /**
   * Handles when the sign button is pressed.
   * 
   * @param currentSign
   *          - The indicator if the number is currently positive or negative.
   * @return The new current sign.
   */
  public String signButtonPressed(final String currentSign)
  {
    String current = displayBottom.getText();
    String newDisplay = current.replaceFirst(SUBTRACTIONCHARACTER, EMPTYSTRINGCHARACTER);
    String posDisplay = current.replaceFirst(SUBTRACTIONCHARACTER, EMPTYSTRINGCHARACTER);
    if (currentSign.equals(EMPTYSTRINGCHARACTER))
    {
      displayBottom.setText(SUBTRACTIONCHARACTER + displayBottom.getText());
      return SUBTRACTIONCHARACTER;
    }
    else
    {
      displayBottom.setText(newDisplay);
      displayBottom.setText(posDisplay);
      return EMPTYSTRINGCHARACTER;
    }
  }

  /**
   * Moves the focus indicator backwards.
   */
  public void moveFocusBack()
  {
    String current = displayBottom.getText();
    String newDisplay = EMPTYSTRINGCHARACTER;
    if (count == 0)
    {
      newDisplay = current;
    }
    else if (count % 2 == 0)
    {
      if (inN)
      {
        newDisplay = current.replace(focus, EMPTYSTRINGCHARACTER);
        newDisplay = current + focus;
        newDisplay = newDisplay.replace(fracString, EMPTYSTRINGCHARACTER);
        newDisplay = newDisplay + fracString;
        inN = false;
      }
      else if (inD)
      {
        newDisplay = current.replace(focus, EMPTYSTRINGCHARACTER);
        newDisplay = current + focus;
        newDisplay = newDisplay.replace(fracString, EMPTYSTRINGCHARACTER);
        newDisplay = newDisplay + fracString;
        inD = false;
      }
      else
      {
        newDisplay = current.replace(focus, EMPTYSTRINGCHARACTER);
        newDisplay = newDisplay.replace(fracString, EMPTYSTRINGCHARACTER);
        newDisplay += fracString;
        newDisplay += focus;
      }
    }
    else if (count % 2 != 0)
    {
      if (inN)
      {
        newDisplay = current.replace(focus, EMPTYSTRINGCHARACTER);
        newDisplay += ONESPACECHARACTER + focus;
        newDisplay = newDisplay.replace(fracString, EMPTYSTRINGCHARACTER);
      }
      else if (inD)
      {
        newDisplay = current.replace(focus, EMPTYSTRINGCHARACTER);
        newDisplay += ONESPACECHARACTER + focus;
        newDisplay = newDisplay.replace(fracString, EMPTYSTRINGCHARACTER);
      }
      else
      {
        newDisplay = current.replace(focus, EMPTYSTRINGCHARACTER);
        newDisplay = newDisplay.replace(fracString, EMPTYSTRINGCHARACTER);
        newDisplay += focus + EMPTYSTRINGCHARACTER;
        newDisplay = newDisplay.replace(fracString, EMPTYSTRINGCHARACTER);
      }
    }
    displayBottom.setText(newDisplay);
  }

  /**
   * Handles when the backspace button is pressed.
   */
  public void backspaceButtonPressed()
  {
    String current = displayBottom.getText();
    String[] fracParts = current.split(ONESPACECHARACTER);
    String moveNtoW = fracParts[0] + ONESPACECHARACTER + focus;
    String moveDtoN = SLASHCHARACTER + focus;
    String subCurrent = EMPTYSTRINGCHARACTER;

    // move focus from numerator to denominator
    if (current.contains(moveNtoW))
    {
      subCurrent = current.replace(focus, EMPTYSTRINGCHARACTER);
      subCurrent = subCurrent.replace(fracString, EMPTYSTRINGCHARACTER);
      subCurrent += focus;
      subCurrent += fracString;
      count = 0;
      inN = false;
    }
    // move focus from denominator to numerator
    else if (current.contains(moveDtoN))
    {
      subCurrent = current.replace(focus, EMPTYSTRINGCHARACTER);
      subCurrent = subCurrent.replace(SLASHCHARACTER, EMPTYSTRINGCHARACTER);
      subCurrent += focus;
      subCurrent += SLASHCHARACTER;
      inD = false;
      inN = true;
      count++;
    }
    else
    {
      subCurrent = current.replace(focus, EMPTYSTRINGCHARACTER);
      subCurrent = subCurrent.replace(SLASHCHARACTER, EMPTYSTRINGCHARACTER);
      subCurrent = subCurrent.replaceAll(ONESPACECHARACTER, EMPTYSTRINGCHARACTER);
      if (subCurrent.length() > 0)
      {
        String lastNum = subCurrent.substring(subCurrent.length() - 1);
        int lastIndex = current.lastIndexOf(lastNum);
        if (lastIndex > 0)
        {
          String firstHalf = current.substring(0, lastIndex);
          String secondHalf = current.substring(lastIndex + 1);
          subCurrent = firstHalf + secondHalf;
        }
        else
        {
          subCurrent = current.replace(lastNum, EMPTYSTRINGCHARACTER);
        }
      }
      else
      {
        subCurrent = focus;
      }
    }
    displayBottom.setText(subCurrent);
  }

  /**
   * Gets the current mixed fraction.
   * 
   * @param printMessage
   *          Decides if the message prints or not.
   * @return the current mixed fraction in the bottom right.
   */
  public MixedFraction getCurrentFraction(final Boolean printMessage)
  {
    MixedFraction returnFraction = null;
    String[] fracSlash;
    String currentFraction = displayBottom.getText();
    String message = "The mixed fraction inputed is missing a component and the following "
        + "calculation will be incorrect. Please reset calculations and try again.";
    String fractInputError = "Fraction Input Error";
    System.out.println(currentFraction);
    currentFraction = currentFraction.replace(focus, EMPTYSTRINGCHARACTER);
    System.out.println(currentFraction);
    if (currentFraction.contains(COMMA_CHAR))
    {
      currentFraction = currentFraction.replace(COMMA_CHAR, EMPTYSTRINGCHARACTER);
    }
    System.out.println(currentFraction);
    String[] fracParts = currentFraction.split(ONESPACECHARACTER);

    if (fracParts[0].contains(SLASHCHARACTER))
    {
      fracSlash = fracParts[0].split(SLASHCHARACTER);
      int numerator = Integer.parseInt(fracSlash[0]);
      int denominator = Integer.parseInt(fracSlash[1]);
      returnFraction = new MixedFraction(0, numerator, denominator);
    }
    else if (fracParts[0].equals(EMPTYSTRINGCHARACTER))
    {
      fracSlash = fracParts[1].split(SLASHCHARACTER);
      int numerator = Integer.parseInt(fracSlash[0]);
      int denominator = Integer.parseInt(fracSlash[1]);
      returnFraction = new MixedFraction(0, numerator, denominator);
    }
    else if (fracParts.length > 1)
    {
      System.out.println("part 1 " + fracParts[0]);
      System.out.println("part 2 " + fracParts[1]);
      fracSlash = fracParts[1].split(SLASHCHARACTER);

      // creates a new list for the numerator and denominator or length two
      String oneChar = "1";
      String[] numeratorDenominatorList = {oneChar, oneChar};

      // copies over the existing values for numerator and denominator
      for (int i = 0; i < fracSlash.length; i++)
      {
        numeratorDenominatorList[i] = fracSlash[i];
        System.out.println("fracSlash part: " + fracSlash[i]);
      }
      if (fracSlash.length > 0)
      {
        if (fracSlash[0] == null || fracSlash[0].equals(EMPTYSTRINGCHARACTER))
        { // NO NUMERATOR GIVEN.
          numeratorDenominatorList[0] = oneChar;
          if (printMessage)
          {
            JOptionPane.showMessageDialog(this, message, fractInputError,
                JOptionPane.INFORMATION_MESSAGE);
          }
        }
        if (fracSlash.length == 1)
        { // NO DENOMINATOR GIVEN
          numeratorDenominatorList[1] = oneChar;
          if (printMessage)
          {
            JOptionPane.showMessageDialog(this, message, fractInputError,
                JOptionPane.INFORMATION_MESSAGE);
          }
        }

        int whole = Integer.parseInt(fracParts[0]);
        int numerator = 1;
        int denominator = 1;
        try
        {
          numerator = Integer.parseInt(numeratorDenominatorList[0]);
        }
        catch (NumberFormatException e)
        {
        }

        try
        {
          denominator = Integer.parseInt(numeratorDenominatorList[1]);
        }
        catch (NumberFormatException e)
        {
        }

        returnFraction = new MixedFraction(whole, numerator, denominator);
        System.out.println(returnFraction.toString());
      }
      else
      {
        returnFraction = new MixedFraction(Integer.parseInt(fracParts[0]), null, null);
      }

    }
    return returnFraction;
  }

  /**
   * Get the temporary resource path.
   * 
   * @return the temporary resource path.
   */
  public TempResourcePath getTempResourcePath()
  {
    return this.tempResourcePath;
  }

  /**
   * Private class to handle keyboard inputs.
   */
  private class MyDispatcher implements KeyEventDispatcher
  {
    @Override
    public boolean dispatchKeyEvent(final KeyEvent e)
    {

      if (e.getID() == KeyEvent.KEY_PRESSED)
      {
        numberButtons.numberKeyPressed(e);
        operatorButtons.operatorKeyPressed(e);
        signPositionButtons.signPosKeyPressed(e);
        deletion.deletionKeyPressed(e);
      }

      return false;
    }
  }

  /**
   * Sets up mnemonic shortcuts given a list of shortcuts to set.
   * 
   * @param mnemonicList
   *          - the list of shortcuts to set.
   */
  public void setMnemonics(final HashMap<String, Integer> mnemonicList)
  {
    ArrayList<String> specifiedMenus = new ArrayList<String>(mnemonicList.keySet());
    for (int i = 0; i < specifiedMenus.size(); i++)
    {
      String currentKey = specifiedMenus.get(i);
      if (currentKey.equals(fileLabel))
      {
        fileMenuItem.setMnemonic(mnemonicList.get(currentKey));
      }
      else if (currentKey.equals(printSessionLabel))
      {
        sessionButton.setMnemonic(mnemonicList.get(currentKey));
      }
      else if (currentKey.equals(newCalculatorLabel))
      {
        newCalculatorButton.setMnemonic(mnemonicList.get(currentKey));
      }
      else if (currentKey.equals(exitLabel))
      {
        exitButton.setMnemonic(mnemonicList.get(currentKey));
      }
      else if (currentKey.equals(modeLabel))
      {
        modeMenuItem.setMnemonic(mnemonicList.get(currentKey));
      }
      else if (currentKey.equals(properLabel))
      {
        properBox.setMnemonic(mnemonicList.get(currentKey));
      }
      else if (currentKey.equals(reducedLabel))
      {
        reducedBox.setMnemonic(mnemonicList.get(currentKey));
      }
      else if (currentKey.equals(viewLabel))
      {
        viewMenuItem.setMnemonic(mnemonicList.get(currentKey));
      }
      else if (currentKey.equals(pieChartLabel))
      {
        pieChartItem.setMnemonic(mnemonicList.get(currentKey));
      }
      else if (currentKey.equals(helpLabel))
      {
        helpMenuItem.setMnemonic(mnemonicList.get(currentKey));
      }
      else if (currentKey.equals(aboutLabel))
      {
        aboutButton.setMnemonic(mnemonicList.get(currentKey));
      }
      else if (currentKey.equals(helpHelpLabel))
      {
        helpButton.setMnemonic(mnemonicList.get(currentKey));
      }
      else if (currentKey.equals(preferencesLabel))
      {
        preferencesMenuItem.setMnemonic(mnemonicList.get(currentKey));
      }
      else if (currentKey.equals(editLabel))
      {
        editButton.setMnemonic(mnemonicList.get(currentKey));
      }
      else if (currentKey.equals(openLabel))
      {
        openButton.setMnemonic(mnemonicList.get(currentKey));
      }
      else if (currentKey.equals(saveLabel))
      {
        saveButton.setMnemonic(mnemonicList.get(currentKey));
      }
      else if (currentKey.equals(separatorsLabel))
      {
        sepMenuItem.setMnemonic(mnemonicList.get(currentKey));
      }
      else if (currentKey.equals(onLabel))
      {
        onButton.setMnemonic(mnemonicList.get(currentKey));
      }
      else if (currentKey.equals(offLabel))
      {
        offButton.setMnemonic(mnemonicList.get(currentKey));
      }
    }
  }

  /**
   * Overwrite/set a new mnemonic. Also adds the parent item to the same key for ease of use.
   * 
   * @param item
   *          - the item to set the mnemonic for.
   * @param keyToUse
   *          - the key to use.
   */
  public void overwriteMnemonic(final String item, final Integer keyToUse)
  {
    HashMap<String, Integer> newMnemonic = new HashMap<>();
    newMnemonic.put(item, keyToUse);
    String parentItem;
    if (item.equals(fileLabel) || item.equals(printSessionLabel) || item.equals(newCalculatorLabel)
        || item.equals(exitLabel))
    {
      parentItem = fileLabel;
    }
    else if (item.equals(modeLabel) || item.equals(properLabel) || item.equals(reducedLabel))
    {
      parentItem = modeLabel;
    }
    else if (item.equals(viewLabel) || item.equals(pieChartLabel))
    {
      parentItem = viewLabel;
    }
    else if (item.equals(helpLabel) || item.equals(aboutLabel) || item.equals(helpHelpLabel))
    {
      parentItem = helpLabel;
    }
    else if (item.equals(preferencesLabel) || item.equals(editLabel) || item.equals(openLabel)
        || item.equals(saveLabel))
    {
      parentItem = preferencesLabel;
    }
    else
    {
      parentItem = separatorsLabel;
    }
    if (!mnemonicItems.containsKey(parentItem)) // Parent bind not set, set to this key for use.
    {
      newMnemonic.put(parentItem, keyToUse);
    }
    this.setMnemonics(newMnemonic);
  }

  /**
   * Try to laod the default preferences from the FragileDefaults directory; if the directory or the
   * file doesn't exist, try to create them; if they can't be made, just use defaults.
   */
  private void loadDefaultPrefs()
  {
    if (this.shouldLoadPrefs)
    {
      try
      {
        String defaultUserDirectory = FileSystemView.getFileSystemView().getDefaultDirectory()
            .getPath();
        String fragileStorageDirectory = defaultUserDirectory + FRAGILEDEFAULTS;
        String pathToDefaults = fragileStorageDirectory + DEFAULTS;
        File defaultPrefsFile = new File(pathToDefaults);
        FileInputStream fileIn = new FileInputStream(defaultPrefsFile);
        ObjectInputStream objectIn = new ObjectInputStream(fileIn);
        PreferencesWrapper wrappedPreferences = (PreferencesWrapper) objectIn.readObject();
        HashMap<String, Integer> defaultPreferences = wrappedPreferences.getMnemonicItems();
        this.separatorsTurnedOn = wrappedPreferences.getSepsOn();
        if (defaultPreferences != null)
        {
          this.mnemonicItems = defaultPreferences;
        }
        else
        {
          this.mnemonicItems = new HashMap<String, Integer>();
        }
        objectIn.close();
      }
      catch (IOException | ClassNotFoundException e)
      {
        // Can't find file or directory, try to create a new one.
        String defaultUserDirectory = FileSystemView.getFileSystemView().getDefaultDirectory()
            .getPath();
        File defaultUserDirectoryAsFile = new File(defaultUserDirectory + "/FragileDefaults");
        defaultUserDirectoryAsFile.mkdir();
        File newDefaultFile = new File(defaultUserDirectory + "/FragileDefaults/defaults.fpf");
        try
        {
          newDefaultFile.createNewFile();
        }
        catch (IOException e1)
        {
          // Can't create new default file directory.
          System.out.println("Cannot load from/create new temporary directory!");
          e1.printStackTrace();
        }
        this.mnemonicItems = new HashMap<>();
        this.separatorsTurnedOn = false;
      }
    }
  }

  @Override
  public Locale getLocale()
  {
    return this.currentLocale;
  }
}
