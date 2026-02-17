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

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JWindow;
import javax.swing.border.TitledBorder;

/**
 * Creates the display on the left side that shows the intermediate steps.
 * 
 * @author Joey Linneman
 * @version 1.2
 * Honor Code: This work complies with JMU's Honor Code.
 */
public class IntermediateDisplay extends JWindow implements ActionListener, ComponentListener
{
  public static final String INTER_US = "Intermediate Steps";
  public static final String INTER_DE = "Zwischenschritte";
  public static final String INTER_FR = "Étapes Intermédiaires";
  private static final long serialVersionUID = 1L;
  protected Container contentPane;
  protected JTextArea sessionText = new JTextArea();
  protected JPanel panel = new JPanel();
  protected JTextArea intermediateText = new JTextArea();
  protected JButton outArrow = new JButton("<");
  protected JButton inArrow = new JButton(">");
  protected JPanel sessionHistory = new JPanel();
  private Font numberFont = new Font(Font.SANS_SERIF, Font.PLAIN, 19);
  private FragileCalculator calc;
  private boolean isOpen = false;

 /**
  * Constructor for the IntermediateDisplay.
  * @param calc The calculator the display is to be attached to.
  */
  public IntermediateDisplay(final FragileCalculator calc)
  {
    super();
    this.calc = calc;
    setupLayout();
    setSize(250, 250);
    setLocation(248, 261);
    setVisible(true);
  }

 /**
  * Sets up the layout for the display.
  */
  public void setupLayout()
  {
    setLayout(new BorderLayout());
    setBackground(new Color(1.0f, 1.0f, 1.0f, 0.0f));
    calc.addComponentListener(this);
    panel.setSize(200, 100);
    panel.setLayout(new BorderLayout());
    panel.setBackground(new Color(1.0f, 1.0f, 1.0f, 0.0f));
    contentPane = getContentPane();
    contentPane.setLayout(new BorderLayout());
    contentPane.setBackground(new Color(1.0f, 1.0f, 1.0f, 0.0f));
    sessionHistory.setLayout(new BorderLayout());
    sessionHistory.setSize(200, 300);
    sessionHistory.setBackground(calc.displayColor);
    sessionHistory.setSize(100, 100);
    outArrow.addActionListener(this);
    outArrow.setBackground(Color.BLUE);
    outArrow.setForeground(Color.BLACK);
    outArrow.setFont(FragileCalculator.plainFont);
    outArrow.setSize(10, 10);
    outArrow.setVisible(true);
    outArrow.setOpaque(false);
    outArrow.setBackground(calc.displayColor);
    // Set up collapse arrow.
    inArrow.addActionListener(this);
    inArrow.setBackground(Color.RED);
    inArrow.setForeground(Color.BLACK);
    inArrow.setFont(FragileCalculator.plainFont);
    inArrow.setBackground(calc.displayColor);
    // Set up the scroll bar.
    JScrollPane scrollPane = new JScrollPane(sessionText);
    scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
    // Set up the session history panel.
    sessionHistory.setVisible(true);
    // Spacing.
    sessionHistory.add(inArrow, BorderLayout.WEST);
    TitledBorder sessionBorder;
    if (calc.getLocale().toString().equalsIgnoreCase("de_DE"))
    {
      sessionBorder = BorderFactory.createTitledBorder(INTER_DE);
    }
    else if (calc.getLocale().toString().equalsIgnoreCase("fr_FR"))
    {
      sessionBorder = BorderFactory.createTitledBorder(INTER_FR);
    }
    else
    {
      sessionBorder = BorderFactory.createTitledBorder(INTER_US);
    }
    sessionText.setBorder(sessionBorder);
    sessionText.setEditable(true);
    sessionText.setLineWrap(true);
    sessionText.setWrapStyleWord(true);
    sessionText.setFont(numberFont);
    sessionText.setText("");
    sessionText.setBackground(calc.displayColor);
    sessionHistory.add(scrollPane, BorderLayout.CENTER);
    // Layout adding between the spacing.
    panel.add(sessionHistory, BorderLayout.CENTER);
    contentPane.add(outArrow, BorderLayout.WEST);
    contentPane.add(panel, BorderLayout.CENTER);
  }

  @Override
  public void componentResized(final ComponentEvent e)
  {
  }

  @Override
  public void componentMoved(final ComponentEvent e)
  {
    if (isOpen)
    {
      if (e.getComponent() == calc)
      {
        Point frameLocation = calc.getLocation();
        setLocation(frameLocation.x - 250, frameLocation.y + 125);
      }
    }
    else
    {
      if (e.getComponent() == calc)
      {
        Point frameLocation = calc.getLocation();
        setLocation(frameLocation.x - 35, frameLocation.y + 125);
      }
    }
  }

  @Override
  public void componentShown(final ComponentEvent e)
  {
  }

  @Override
  public void componentHidden(final ComponentEvent e)
  {
  }

  @Override
  public void actionPerformed(final ActionEvent e)
  {
    if (e.getSource() == inArrow)
    {
      isOpen = false;
      outArrow.setVisible(true);
      inArrow.setVisible(false);
      hideDisplay();
      this.setAlwaysOnTop(false);
      calc.setAlwaysOnTop(true);
    }
    if (e.getSource() == outArrow)
    {
      isOpen = true;
      outArrow.setVisible(false);
      inArrow.setVisible(true);
      unHideDisplay();
      this.setAlwaysOnTop(false);
      calc.setAlwaysOnTop(true);
    }
  }

 /**
  * Hides the display.
  */
  public void hideDisplay()
  {
    Point frameLocation = calc.getLocation();
    setLocation(frameLocation.x - 35, frameLocation.y + 125);
  }

 /**
  * Unhides the display.
  */
  public void unHideDisplay()
  {
    Point frameLocation = calc.getLocation();
    setLocation(frameLocation.x - 250, frameLocation.y + 125);
  }

 /**
  * Sets the text of the display.
  * @param text The text to be set.
  */
  public void setIntermediateText(final String text)
  {
    sessionText.setText(text);
  }
}
