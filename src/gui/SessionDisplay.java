package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.util.Locale;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JWindow;
import javax.swing.SwingUtilities;
import javax.swing.border.TitledBorder;
import utilities.PrintHandler;
import utilities.PrintSession;

/**
 * 
 */
public class SessionDisplay extends JWindow implements ActionListener, ComponentListener
{
  /**
   * 
   */
  protected static Color calcColor;
  protected static String focus = "▯";
  protected static String fracString = " /";
  protected static final String SESSION_US = "Session History";
  protected static final String SESSION_DE = "Sitzungsverlauf";
  protected static final String SESSION_FR = "Historique Des Sessions";
  private static final long serialVersionUID = 1L;
  protected FragileCalculator calc;
  protected JTextArea sessionText;
  protected Color displayColor;
  protected IntermediateDisplay test;
  protected Locale locale;
  Container contentPane;
  JMenu file;
  JMenu view;
  JMenu help;
  JMenu mode;
  JMenu style;
  JPanel panel;
  JPanel sessionHistory;
  JButton outArrow;
  JButton inArrow;
  private Font numberFont = new Font(Font.SANS_SERIF, Font.PLAIN, 19);
  private String languageSetting;
  private boolean isOpen = false;
  
 /**
  * The constructor for the SessionDisplay class.
  * @param languageSetting The desired language setting.
  * @param calc The calculator the SessionDisplay will be attached to.
  */
  public SessionDisplay(final String languageSetting, final FragileCalculator calc)
  {
    super();
    this.languageSetting = languageSetting;
    this.calc = calc;
    setSize(250, 250);
    setupLayout();
    setVisible(true);
    calc.setAlwaysOnTop(true);
  }

 /**
  * Sets up the layout of the SessionDisplay.
  */
  private void setupLayout()
  {
    calcColor = calc.mainColor;
    displayColor = calc.displayColor;

    // Make the calculator show.
    calc.addComponentListener(this);

    // Set up expand button holder.
    outArrow = new JButton(">");
    inArrow = new JButton("<");
    // space1 = new JPanel();
    // space2 = new JPanel();
    test = new IntermediateDisplay(calc);
    setLocation(781, 261);
    setBackground(new Color(1.0f, 1.0f, 1.0f, 0.0f));
    setLayout(new BorderLayout());
    panel = new JPanel();
    panel.setSize(200, 100);
    panel.setBackground(new Color(1.0f, 1.0f, 1.0f, 0.0f));
    panel.setLayout(new BorderLayout());
    contentPane = getContentPane();
    contentPane.setLayout(new BorderLayout());
    contentPane.setBackground(new Color(1.0f, 1.0f, 1.0f, 0.0f));
    sessionHistory = new JPanel();
    sessionHistory.setLayout(new BorderLayout());
    sessionHistory.setSize(200, 300);
    sessionHistory.setBackground(new Color(1.0f, 1.0f, 1.0f, 0.0f));
    sessionHistory.setSize(100, 100);

    // Setup expand button.
    outArrow.addActionListener(this);
    outArrow.setBackground(displayColor);
    outArrow.setForeground(Color.BLACK);
    outArrow.setFont(FragileCalculator.plainFont);
    outArrow.setSize(10, 10);
    outArrow.setVisible(true);
    // outArrow.setOpaque(false);

    // Set up collapse arrow.
    inArrow.addActionListener(this);
    inArrow.setBackground(displayColor);
    inArrow.setForeground(Color.BLACK);
    inArrow.setFont(FragileCalculator.plainFont);
    // Set up the session history panel.

    sessionHistory.setVisible(true);
    sessionHistory.add(inArrow, BorderLayout.EAST);
    sessionText = new JTextArea();
    sessionText.setBackground(displayColor);
    TitledBorder sessionBorder;
    if (languageSetting.equalsIgnoreCase("de_DE"))
    {
      sessionBorder = BorderFactory.createTitledBorder(SESSION_DE);
    }
    else if (languageSetting.equalsIgnoreCase("fr_FR"))
    {
      sessionBorder = BorderFactory.createTitledBorder(SESSION_FR);
    }
    else
    {
      sessionBorder = BorderFactory.createTitledBorder(SESSION_US);
    }
    sessionText.setBorder(sessionBorder);
    sessionText.setEditable(true);
    sessionText.setLineWrap(true);
    sessionText.setWrapStyleWord(true);
    sessionText.setFont(numberFont);
    sessionText.setText("");
    sessionHistory.add(sessionText, BorderLayout.CENTER);

    // Layout adding between the spacing.
    panel.add(sessionHistory, BorderLayout.CENTER);
    contentPane.add(outArrow, BorderLayout.EAST);
    contentPane.add(panel, BorderLayout.CENTER);
  }

  @Override
  public void actionPerformed(final ActionEvent e)
  {
    if (e.getSource() == inArrow)
    {
      isOpen = false;
      SwingUtilities.invokeLater(new Runnable()
      {
        public void run()
        {
          outArrow.setVisible(true);
          inArrow.setVisible(false);
          hideSession();
          calc.setAlwaysOnTop(true);
        }
      });

    }

    if (e.getSource() == outArrow)
    {
      isOpen = true;
      SwingUtilities.invokeLater(new Runnable()
      {
        public void run()
        {
          outArrow.setVisible(false);
          inArrow.setVisible(true);
          unHideSession();
          calc.setAlwaysOnTop(true);
        }
      });

    }
  }

  @Override
  public void componentResized(final ComponentEvent e)
  {
    if (e.getComponent() == calc)
    {
      setVisible(true);
      Point frameLocation = calc.getLocation();
      setLocation(frameLocation.x + 90, frameLocation.y + 125);
    }
  }

  @Override
  public void componentMoved(final ComponentEvent e)
  {
    if (isOpen)
    {
      if (e.getComponent() == calc)
      {
        Point frameLocation = calc.getLocation();
        setLocation(frameLocation.x + 307, frameLocation.y + 125);
      }
    }
    else
    {
      if (e.getComponent() == calc)
      {
        Point frameLocation = calc.getLocation();
        setLocation(frameLocation.x + 90, frameLocation.y + 125);
      }
    }
  }

  @Override
  public void componentShown(final ComponentEvent e)
  {
    if (e.getComponent() == calc)
    {
      System.out.println("shown");
      setVisible(true);
      Point frameLocation = calc.getLocation();
      setLocation(frameLocation.x + 90, frameLocation.y + 125);
    }
  }

  @Override
  public void componentHidden(final ComponentEvent e)
  {
    if (e.getComponent() == calc)
    {
      setVisible(false);
      Point frameLocation = calc.getLocation();
      setLocation(frameLocation.x + 90, frameLocation.y + 125);
    }
  }

 /**
  * Prints the contents of the current SessionDisplay.
  * @param frame the Frame of the session to be printed.
  */
  public void printSession(final JFrame frame)
  {
    PrintSession printSession = new PrintSession(sessionText);
    PrintHandler.print(printSession, frame);
  }

 /**
  * Hides the SessionDisplay.
  */
  public void hideSession()
  {
    Point frameLocation = calc.getLocation();
    setLocation(frameLocation.x + 90, frameLocation.y + 125);
  }

 /**
  * Unhides the SessionDisplay.
  */
  public void unHideSession()
  {
    Point frameLocation = calc.getLocation();
    setLocation(frameLocation.x + 307, frameLocation.y + 125);
  }

 /**
  * sets the sessionText to the desired text.
  * @param text The new sessionText text.
  */
  public void setsessionText(final String text)
  {

    this.sessionText.setText(text);
  }

 /**
  * Returns the IntermediateDisplay.
  * @return test the IntermediateDisplay
  */
  public IntermediateDisplay getID()
  {
    return test;
  }
}
