package gui;

import java.util.ArrayList;
import java.util.Locale;

import javax.swing.JOptionPane;

import math.Fraction;
/**
 * Functionality for soft buttons and keyboard operators.
 */
import math.MixedFraction;
import math.Operations;

/**
 * Class to handle the functionality of the operator buttons.
 */
public class OperatorButtonsFunctionality extends OperatorButtons
{

  public static final String TRUE_US = "True";
  public static final String FALSE_US = "False";
  public static final String TRUE_DE = "Wahr";
  public static final String FALSE_DE = "Falsch";
  public static final String TRUE_FR = "Vrai";
  public static final String FALSE_FR = "Faux";
  public static final String RESULT_US = "Relational Calculation Result";
  public static final String RESULT_DE = "Relationales Berechnungsergebnis";
  public static final String RESULT_FR = "Résultat Du Calcul Relationnel";
  private static final long serialVersionUID = 1L;
  private String session = FragileCalculator.EMPTYSTRINGCHARACTER;
  private ArrayList<String> sessionListFull = new ArrayList<String>();
  private ArrayList<String> sessionListAnswer = new ArrayList<String>();
  private FragileCalculator calculator;

  /**
   * Add button functionality.
   * 
   * @param calculator
   */

  public OperatorButtonsFunctionality(final FragileCalculator calculator)
  {
    super(calculator);
    this.calculator = calculator;
  }

  /**
   * Add button functionality.
   */
  public void addFunc()
  {
    String addChar = " +";
    calculator.buttonPressed(addChar);

    calculator.moveToLeft();
    if (calculator.getJustEvaluated())
      calculator.getDisplayTop().setText(previousEvaluation.toString() + addChar);
    calculator.setCount(0);
    calculator.setinD(false);
    calculator.setinN(false);
    calculator.setinN2(false);
    calculator.setinD2(false);
    calculator.getDisplayBottom().setText(FragileCalculator.focus);
    calculator.setJustEvaluated(false);
    if (calculator.separators)
    {
      calculator.separatorsOff(calculator.getDisplayBottom().getText(),
          calculator.getDisplayTop().getText());
      calculator.separatorsOn(calculator.getDisplayBottom().getText(),
          calculator.getDisplayTop().getText());
    }
  }

  /**
   * Subtract button functionality.
   */
  public void subtractFunc()
  {
    String subChar = " -";
    calculator.buttonPressed(subChar);

    calculator.moveToLeft();
    if (calculator.getJustEvaluated())
      calculator.getDisplayTop().setText(previousEvaluation.toString() + subChar);

    calculator.setCount(0);
    calculator.setinD(false);
    calculator.setinN(false);
    calculator.setinN2(false);
    calculator.setinD2(false);
    calculator.getDisplayBottom().setText(FragileCalculator.focus);
    calculator.setJustEvaluated(false);
    if (calculator.separators)
    {
      calculator.separatorsOff(calculator.getDisplayBottom().getText(),
          calculator.getDisplayTop().getText());
      calculator.separatorsOn(calculator.getDisplayBottom().getText(),
          calculator.getDisplayTop().getText());
    }
  }

  /**
   * Multiplication button functionality.
   */
  public void multFunc()
  {
    String multChar = " ×";
    calculator.buttonPressed(multChar);

    calculator.moveToLeft();
    if (calculator.getJustEvaluated())
      calculator.getDisplayTop().setText(previousEvaluation.toString() + multChar);

    calculator.setCount(0);
    calculator.setinD(false);
    calculator.setinN(false);
    calculator.setinN2(false);
    calculator.setinD2(false);
    calculator.getDisplayBottom().setText(FragileCalculator.focus);
    calculator.setJustEvaluated(false);
    if (calculator.separators)
    {
      calculator.separatorsOff(calculator.getDisplayBottom().getText(),
          calculator.getDisplayTop().getText());
      calculator.separatorsOn(calculator.getDisplayBottom().getText(),
          calculator.getDisplayTop().getText());
    }
  }

  /**
   * Divide button functionality.
   */
  public void divideFunc()
  {
    String divChar = " ÷";
    calculator.buttonPressed(divChar);

    calculator.moveToLeft();
    if (calculator.getJustEvaluated())
      calculator.getDisplayTop().setText(previousEvaluation.toString() + divChar);

    calculator.setCount(0);
    calculator.setinD(false);
    calculator.setinN(false);
    calculator.setinN2(false);
    calculator.setinD2(false);
    calculator.getDisplayBottom().setText(FragileCalculator.focus);
    calculator.setJustEvaluated(false);
    if (calculator.separators)
    {
      calculator.separatorsOff(calculator.getDisplayBottom().getText(),
          calculator.getDisplayTop().getText());
      calculator.separatorsOn(calculator.getDisplayBottom().getText(),
          calculator.getDisplayTop().getText());
    }
  }

  /**
   * Equals button functionality.
   */
  public void equalsFunc()
  {
    String currentBottom = calculator.getDisplayBottom().getText();
    String currentTop = calculator.getDisplayTop().getText();
    String newString = currentTop + FragileCalculator.ONESPACECHARACTER + currentBottom;

    // check for whole num in second operand
    if (newString.contains(" /"))
    {
      newString = newString.substring(0, newString.length() - 2);
    }

    // checking if it is relational.
    String operator = currentTop.substring(currentTop.length() - 1);
    boolean isRelational = (operator.equals(">") || operator.equals("<") || operator.equals("≝"));

    answerFraction = newString; // To use for parsing & calculations.
    MixedFraction evaluation = Operations.evaluteCurrentExpression(answerFraction);
    previousEvaluation = evaluation;

    if (isRelational)
    {
      boolean booleanVal = (evaluation.getWholeNumber() == 1);
      String booleanAnswerStr = FALSE_US;
      if (calculator.getLocale().equals(Locale.GERMANY)
          || calculator.getLocale().equals(Locale.GERMAN))
      {
        booleanAnswerStr = FALSE_DE;
      }
      else if (calculator.getLocale().equals(Locale.FRANCE)
          || calculator.getLocale().equals(Locale.FRENCH))
      {
        booleanAnswerStr = FALSE_FR;
      }
      String answerStr = FragileCalculator.EMPTYSTRINGCHARACTER;
      if (booleanVal)
      {
        booleanAnswerStr = TRUE_US;
        if (calculator.getLocale().equals(Locale.GERMANY)
            || calculator.getLocale().equals(Locale.GERMAN))
        {
          booleanAnswerStr = TRUE_DE;
        }
        else if (calculator.getLocale().equals(Locale.FRANCE)
            || calculator.getLocale().equals(Locale.FRENCH))
        {
          booleanAnswerStr = TRUE_FR;
        }
      }
      answerStr = answerFraction.substring(0, answerFraction.length() - 1)
          + FragileCalculator.EQUALSSPACES + booleanAnswerStr;
      answerStr.replaceAll(FragileCalculator.focus, FragileCalculator.EMPTYSTRINGCHARACTER);

      calculator.getDisplayTop().setText(FragileCalculator.EMPTYSTRINGCHARACTER);
      calculator.getDisplayBottom().setText(FragileCalculator.EMPTYSTRINGCHARACTER);
      session = session + answerFraction.substring(0, answerFraction.length() - 1)
          + FragileCalculator.EQUALSSPACES + booleanAnswerStr + FragileCalculator.NEWLINECHAR;
      sessionListFull.add(answerFraction.substring(0, answerFraction.length() - 1)
          + FragileCalculator.EQUALSSPACES + booleanAnswerStr);
      sessionListAnswer.add(previousEvaluation.toString());
      if (calculator.getLocale().equals(Locale.GERMANY)
          || calculator.getLocale().equals(Locale.GERMAN))
      {
        JOptionPane.showMessageDialog(calculator, answerStr, RESULT_DE,
            JOptionPane.INFORMATION_MESSAGE);
      }
      else if (calculator.getLocale().equals(Locale.FRANCE)
          || calculator.getLocale().equals(Locale.FRENCH))
      {
        JOptionPane.showMessageDialog(calculator, answerStr, RESULT_FR,
            JOptionPane.INFORMATION_MESSAGE);
      }
      else
      {
        JOptionPane.showMessageDialog(calculator, answerStr, RESULT_US,
            JOptionPane.INFORMATION_MESSAGE);
      }
      this.calculator.getSessionDisplay().setsessionText(session);
    }
    else
    {
      if (calculator.getProper())
      {
        Fraction evaluationImproper = evaluation.convertToFraction();
        if (calculator.getReduced())
          evaluationImproper = evaluationImproper.simplifyFraction();

        calculator.getDisplayTop().setText(answerFraction.substring(0, answerFraction.length() - 1)
            + FragileCalculator.EQUALSSPACES + evaluationImproper.toString());
        calculator.getDisplayTop().setText(calculator.getDisplayTop().getText()
            .replaceAll(FragileCalculator.focus, FragileCalculator.EMPTYSTRINGCHARACTER));
        session = session + answerFraction.substring(0, answerFraction.length() - 1)
            + FragileCalculator.EQUALSSPACES + evaluationImproper + FragileCalculator.NEWLINECHAR;
        sessionListFull.add(answerFraction.substring(0, answerFraction.length() - 1)
            + FragileCalculator.EQUALSSPACES + evaluationImproper);
        sessionListAnswer.add(previousEvaluation.toString());
        this.calculator.getSessionDisplay().setsessionText(session);
      }
      else
      {
        if (calculator.getReduced())
          evaluation = evaluation.simplify();
        calculator.getDisplayTop().setText(answerFraction.substring(0, answerFraction.length() - 1)
            + FragileCalculator.EQUALSSPACES + evaluation);
        calculator.getDisplayTop().setText(calculator.getDisplayTop().getText()
            .replaceAll(FragileCalculator.focus, FragileCalculator.EMPTYSTRINGCHARACTER));
        session = session + answerFraction.substring(0, answerFraction.length() - 1)
            + FragileCalculator.EQUALSSPACES + evaluation + FragileCalculator.NEWLINECHAR;
        sessionListFull.add(answerFraction.substring(0, answerFraction.length() - 1)
            + FragileCalculator.EQUALSSPACES + evaluation);
        sessionListAnswer.add(previousEvaluation.toString());
        this.calculator.getSessionDisplay().setsessionText(session);
      }
      calculator.setCount(0);
      calculator.setinD(false);
      calculator.setinN(false);
      calculator.setinN2(false);
      calculator.setinD2(false);
      calculator.getDisplayBottom().setText(FragileCalculator.focus);
      calculator.setJustEvaluated(true);

      this.calculator.getSessionDisplay().getID()
          .setIntermediateText(Operations.getIntermediateSteps());
    }
    if (calculator.separators)
    {
      calculator.separatorsOff(calculator.getDisplayBottom().getText(),
          calculator.getDisplayTop().getText());
      calculator.separatorsOn(calculator.getDisplayBottom().getText(),
          calculator.getDisplayTop().getText());
    }
  }

  /**
   * Power button functionality.
   */
  public void powerFunc()
  {
    String powerChar = " ^";
    calculator.buttonPressed(powerChar);
    calculator.moveToLeft();
    if (calculator.getJustEvaluated())
      calculator.getDisplayTop().setText(previousEvaluation.toString() + powerChar);
    calculator.setCount(0);
    calculator.setinD(false);
    calculator.setinN(false);
    calculator.setinN2(false);
    calculator.setinD2(false);
    calculator.getDisplayBottom().setText(FragileCalculator.focus);
    calculator.setJustEvaluated(false);
    if (calculator.separators)
    {
      calculator.separatorsOff(calculator.getDisplayBottom().getText(),
          calculator.getDisplayTop().getText());
      calculator.separatorsOn(calculator.getDisplayBottom().getText(),
          calculator.getDisplayTop().getText());
    }
  }

  /**
   * Inverse function functionality.
   */
  public void inverseFunc()
  {
    calculator.buttonPressed(" Inv");
    String bottomWindowText = calculator.getDisplayBottom().getText()
        .replaceAll(FragileCalculator.focus, FragileCalculator.EMPTYSTRINGCHARACTER);
    String[] bottomString = bottomWindowText.split(FragileCalculator.ONESPACECHARACTER);
    Integer wholeNumber = 0;
    Integer numerator = 1;
    Integer denominator = 1;
    String[] nandD;

    // catch for only a fraction with no whole number
    try
    {
      wholeNumber = Integer.parseInt(bottomString[0]);
    }
    catch (NumberFormatException e)
    {
      wholeNumber = 0;
    }

    // split the numerator and denominator if there is not whole number inputed
    if (bottomString.length == 2)
      nandD = bottomString[0].split(FragileCalculator.SLASHCHARACTER);
    // split the numerator and denominator if there is a whole number
    else
      nandD = bottomString[1].split(FragileCalculator.SLASHCHARACTER);

    /* catch for simplifying with only a whole number or either a numerator or denominator */
    // only a numerator
    if (nandD.length == 1)
    {
      try
      {
        numerator = Integer.parseInt(nandD[0]);
      }
      catch (NumberFormatException e)
      {
        numerator = 1;
      }
    }
    // numerator and denominator
    if (nandD.length == 2)
    {
      // try catch block for only a denominator
      try
      {
        numerator = Integer.parseInt(nandD[0]);
      }
      catch (NumberFormatException e)
      {
        numerator = 1;
      }

      // try catch block to make sure the denominator an integer
      try
      {
        denominator = Integer.parseInt(nandD[1]);
      }
      catch (NumberFormatException e)
      {
        denominator = 1;
      }
    }
    MixedFraction invertedFraction = new MixedFraction(wholeNumber, numerator, denominator);
    invertedFraction = Operations.invertFraction(invertedFraction);
    calculator.getDisplayBottom().setText(invertedFraction.toString());
  }

  /**
   * Simplify button functionality.
   */
  public void simplifyFunc()
  {
    calculator.buttonPressed(" ↡");
    String bottomWindowText = calculator.getDisplayBottom().getText()
        .replaceAll(FragileCalculator.focus, FragileCalculator.EMPTYSTRINGCHARACTER);
    String[] bottomString = bottomWindowText.split(FragileCalculator.ONESPACECHARACTER);
    Integer wholeNumber = 0;
    Integer numerator = 1;
    Integer denominator = 1;
    String[] nandD;

    // catch for only a fraction with no whole number
    try
    {
      wholeNumber = Integer.parseInt(bottomString[0]);
    }
    catch (NumberFormatException e)
    {
      wholeNumber = 0;
    }

    // split the numerator and denominator if there is not whole number inputed
    if (bottomString.length == 2)
      nandD = bottomString[0].split(FragileCalculator.SLASHCHARACTER);
    // split the numerator and denominator if there is a whole number
    else
      nandD = bottomString[1].split(FragileCalculator.SLASHCHARACTER);

    /* catch for simplifying with only a whole number or either a numerator or denominator */
    // only a numerator
    if (nandD.length == 1)
    {
      try
      {
        numerator = Integer.parseInt(nandD[0]);
      }
      catch (NumberFormatException e)
      {
        numerator = 1;
      }

      String message = "The mixed fraction needs a denominator to simplify.";
      JOptionPane.showMessageDialog(calculator, message, "Fraction Simplification Error",
          JOptionPane.INFORMATION_MESSAGE);
    }
    // numerator and denominator
    if (nandD.length == 2)
    {
      // try catch block for only a denominator
      try
      {
        numerator = Integer.parseInt(nandD[0]);
      }
      catch (NumberFormatException e)
      {
        numerator = 1;
      }

      // try catch block to make sure the denominator an integer
      try
      {
        denominator = Integer.parseInt(nandD[1]);
      }
      catch (NumberFormatException e)
      {
        denominator = 1;
      }
    }

    MixedFraction simplifiedFraction = new MixedFraction(wholeNumber, numerator, denominator);
    simplifiedFraction = simplifiedFraction.simplify();
    calculator.getDisplayBottom().setText(simplifiedFraction.toString() + FragileCalculator.focus);
  }

  /**
   * Mediant button functionality.
   */
  public void mediantFunc()
  {
    String mediantChar = " ⇹";
    calculator.buttonPressed(mediantChar);
    // bottom fraction
    calculator.moveToLeft();
    if (calculator.getJustEvaluated())
      calculator.getDisplayTop().setText(previousEvaluation.toString() + mediantChar);

    calculator.setCount(0);
    calculator.setinD(false);
    calculator.setinN(false);
    calculator.setinN2(false);
    calculator.setinD2(false);
    calculator.getDisplayBottom().setText(FragileCalculator.focus);
    calculator.setJustEvaluated(false);
  }
}
