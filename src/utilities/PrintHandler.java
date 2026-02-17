package utilities;

import java.awt.print.*;
import javax.swing.*;

/**
 * A class for handling the printing of SessionHistories.
 * 
 * @author Jelal Kaufman
 * @version 1.2
 * Honor Code: This work complies with JMU's Honor Code:
 */
public class PrintHandler
{
  
  /**
   * Print the printable object.
   * @param printable - the object to print.
   * @param parent - the parent JFrame.
   */
  public static void print(final Printable printable, final JFrame parent)
  {
    PrinterJob job = PrinterJob.getPrinterJob();
    try
    {
      job.setPrintable(printable);
      boolean shouldPrint = job.printDialog();
      if (shouldPrint)
        job.print();
    }
    catch (PrinterException e)
    {
      JOptionPane.showMessageDialog(parent, "Unable to print!", "Error", JOptionPane.ERROR_MESSAGE);
    }
  }
}
