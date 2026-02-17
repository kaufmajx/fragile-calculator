package app;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.*;

import gui.FragileCalculator;
/**
 * A class for creating the about pop-up window.
 * 
 * @author John Ryder
 * @version 10/29/23
 * Honor Code: This work complies with JMU's Honor Code:
 * -Used https://www.geeksforgeeks.org/java-swing-jpopupmenu/ for help on making a pop-up.
 * 
 * -Used https://stackoverflow.com/questions/1614772/how-to-change-jframe-icon for help on
 * changing the icon of a JFrame.
 * 
 * -Used https://web.mit.edu/6.005/www/sp14/psets/ps4/java-6-tutorial/components.html for help
 * on various Swing components.
 * 
 * -Used https://java2everyone.blogspot.com/2008/12/set-jtextfield-text-size.html for help on
 * changing font sizes.
 * 
 * -Used https://stackoverflow.com/questions/6810581/how-to-center-the-text-in-a-jlabel/
 * 18008358#18008358 for help on how to center text in a jlabel.
 * 
 * -Used https://stackoverflow.com/questions/11585854/
 * how-do-i-read-a-html-string-into-a-jeditorpane-jtextpane
 * for help on how to use HTML for a jeditorpane.
 * 
 * -Used https://www.w3schools.com/tags/tag_center.ASP for help on centering in HTML.
 * 
 * -Used https://medium.com/@michael71314/
 * java-lesson-22-inserting-images-onto-the-jframe-a0a0b6540cca
 * for help on inserting and scaling images.
 */
public class About
{
  
  public static final Font HEADER_FONT = new Font(Font.DIALOG, Font.BOLD, 30);
  public static final Font BODY_FONT = new Font(Font.DIALOG, Font.PLAIN, 20);
  public static final String ABOUT_EN = "About";
  public static final String ABOUT_FR = "À Propos";
  public static final String ABOUT_GER = "Über";
  public static final String CONTENT_TYPE = "text/html";
  public static final String AUTHOR_NAMES = 
      "<p>Joseph Linneman, Alyssa Girard, Jelal Kaufman, Layla Aure, and John Ryder</p>"
      + "</body>"
      + "</html>";
  public static final String HTML_INFO =
      "<!DOCTYPE html>"
      + "<html>"
      + "<style>"
      + "h1 {text-align: center;}"
      + "p {text-align: center;}"
      + "div {text-align: center;}"
      + "</style>"
      + "<body style=\"font-family:'Dialog'\">"
      + "<p>Fragile v1.2</p>";
  public static final String FRAGILE_HTML_DESC_EN = 
        HTML_INFO
      + "<p>Fragile is a modern, easy-to-use mixed fraction calculator.</p>"
      + "<p>It is a product of Sagacious Media that was</p>"
      + "<p>developed by:</p>"
      + AUTHOR_NAMES;

  public static final String FRAGILE_HTML_DESC_FR =
      HTML_INFO
      + "<p>Fragile est une calculatrice de fractions mixtes moderne et facile à utiliser.</p>"
      + "<p>Il s'agit d'un produit de Sagacious Media qui a été</p>"
      + "<p>développé par:</p>"
      + AUTHOR_NAMES;

  public static final String FRAGILE_HTML_DESC_GER = 
      HTML_INFO
      + "<p>Fragile ist ein moderner, einfach zu bedienender rechner für gemischte brüche.</p>"
      + "<p>Es ist ein produkt von Sagacious Media das</p>"
      + "<p>entwickelt von:</p>"
      + AUTHOR_NAMES;

  /**
   * Creates and displays the about pop-up window in English.
   * @param calculator - the calculator to get resources from.
   */
  public static void aboutMainEN(final FragileCalculator calculator)
  {
    JFrame popUpFrame = new JFrame(ABOUT_EN);
    popUpFrame.setIconImage(calculator.getIconImage());
    popUpFrame.setResizable(false);
    popUpFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
    JPanel popUpPanel = new JPanel();
    popUpPanel.setLayout(new BorderLayout());
    popUpPanel.setBackground(Color.WHITE);
    JLabel aboutLabel = new JLabel(ABOUT_EN, SwingConstants.CENTER);
    aboutLabel.setFont(HEADER_FONT);
    popUpPanel.add(aboutLabel, BorderLayout.NORTH);
    JPanel centerPanel = new JPanel();
    centerPanel.setBackground(Color.WHITE);
    centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
    ImageIcon scaledIcon = new ImageIcon(calculator.getIconImage().getScaledInstance(50, 50,
        Image.SCALE_SMOOTH));
    JLabel iconLabel = new JLabel();
    iconLabel.setIcon(scaledIcon);
    centerPanel.add(iconLabel);
    JEditorPane descriptionPane = new JEditorPane();
    descriptionPane.setContentType(CONTENT_TYPE);
    descriptionPane.setText(FRAGILE_HTML_DESC_EN);
    descriptionPane.setEditable(false);
    centerPanel.add(descriptionPane);
    popUpPanel.add(centerPanel, BorderLayout.CENTER);
    popUpFrame.add(popUpPanel);
    popUpFrame.setSize(400, 210);
    popUpFrame.pack();
    popUpFrame.setVisible(true);
  }
  
  /**
   * Creates and displays the about pop-up window in English.
   * @param calculator - the calculator to get resources from.
   */
  public static void aboutMainFR(final FragileCalculator calculator)
  {
    JFrame popUpFrame = new JFrame(ABOUT_FR);
    popUpFrame.setIconImage(calculator.getIconImage());
    popUpFrame.setResizable(false);
    popUpFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
    JPanel popUpPanel = new JPanel();
    popUpPanel.setLayout(new BorderLayout());
    popUpPanel.setBackground(Color.WHITE);
    JLabel aboutLabel = new JLabel(ABOUT_FR, SwingConstants.CENTER);
    aboutLabel.setFont(HEADER_FONT);
    popUpPanel.add(aboutLabel, BorderLayout.NORTH);
    JPanel centerPanel = new JPanel();
    centerPanel.setBackground(Color.WHITE);
    centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
    ImageIcon scaledIcon = new ImageIcon(calculator.getIconImage().getScaledInstance(50, 50,
        Image.SCALE_SMOOTH));
    JLabel iconLabel = new JLabel();
    iconLabel.setIcon(scaledIcon);
    centerPanel.add(iconLabel);
    JEditorPane descriptionPane = new JEditorPane();
    descriptionPane.setContentType(CONTENT_TYPE);
    descriptionPane.setText(FRAGILE_HTML_DESC_FR);
    descriptionPane.setEditable(false);
    centerPanel.add(descriptionPane);
    popUpPanel.add(centerPanel, BorderLayout.CENTER);
    popUpFrame.add(popUpPanel);
    popUpFrame.setSize(400, 210);
    popUpFrame.pack();
    popUpFrame.setVisible(true);
  }
  
  /**
   * Creates and displays the about pop-up window in English.
   * @param calculator - the calculator to get resources from.
   */
  public static void aboutMainGER(final FragileCalculator calculator)
  {
    JFrame popUpFrame = new JFrame(ABOUT_GER);
    popUpFrame.setIconImage(calculator.getIconImage());
    popUpFrame.setResizable(false);
    popUpFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
    JPanel popUpPanel = new JPanel();
    popUpPanel.setLayout(new BorderLayout());
    popUpPanel.setBackground(Color.WHITE);
    JLabel aboutLabel = new JLabel(ABOUT_GER, SwingConstants.CENTER);
    aboutLabel.setFont(HEADER_FONT);
    popUpPanel.add(aboutLabel, BorderLayout.NORTH);
    JPanel centerPanel = new JPanel();
    centerPanel.setBackground(Color.WHITE);
    centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
    ImageIcon scaledIcon = new ImageIcon(calculator.getIconImage().getScaledInstance(50, 50,
        Image.SCALE_SMOOTH));
    JLabel iconLabel = new JLabel();
    iconLabel.setIcon(scaledIcon);
    centerPanel.add(iconLabel);
    JEditorPane descriptionPane = new JEditorPane();
    descriptionPane.setContentType(CONTENT_TYPE);
    descriptionPane.setText(FRAGILE_HTML_DESC_GER);
    descriptionPane.setEditable(false);
    centerPanel.add(descriptionPane);
    popUpPanel.add(centerPanel, BorderLayout.CENTER);
    popUpFrame.add(popUpPanel);
    popUpFrame.setSize(400, 210);
    popUpFrame.pack();
    popUpFrame.setVisible(true);
  }
}
