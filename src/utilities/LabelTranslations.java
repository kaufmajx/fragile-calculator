package utilities;
/**
 * A static class for holding different text in buttons for languages.
 * 
 * @author John Ryder
 * @version 12/5/23
 * Honor Code: This work complies with JMU's Honor Code:
 */
public class LabelTranslations
{
  
  public static final String HELFEN = "Helfen";
  public static final String MODE = "Mode";
  public static final String HELP = "Help";
  public static final String AIDE = "Aide";

  /**
   * Get text in German.
   * @return the texts in German.
   */
  public static String[] getLabelsGER()
  {
    String[] returnVal = new String[21];
    returnVal[0] = "Datei";
    returnVal[1] = "Drucksitzung";
    returnVal[2] = "Neuer Rechner";
    returnVal[3] = "Ausfahrt";
    returnVal[4] = "Modus";
    returnVal[5] = "Richtig";
    returnVal[6] = "Reduziert";
    returnVal[7] = "Sicht";
    returnVal[8] = "Kuchendiagramm";
    returnVal[9] = HELFEN;
    returnVal[10] = "Über";
    returnVal[11] = HELFEN;
    returnVal[12] = "Präferenzen";
    returnVal[13] = "Bearbeiten";
    returnVal[14] = "Offen";
    returnVal[15] = "Speichern";
    returnVal[16] = "Trennzeichen";
    returnVal[17] = "An";
    returnVal[18] = "Aus";
    returnVal[19] = "Wählen Sie eine Datei zum Speichern aus:";
    returnVal[20] = "Wählen Sie eine Datei zum Öffnen aus:";
    return returnVal;
  }
  
  /**
   * Get text in English.
   * @return the texts in English.
   */
  public static String[] getLabelsUS()
  {
    String[] returnVal = new String[21];
    returnVal[0] = "File";
    returnVal[1] = "Print Session";
    returnVal[2] = "New Calculator";
    returnVal[3] = "Exit";
    returnVal[4] = MODE;
    returnVal[5] = "Proper";
    returnVal[6] = "Reduced";
    returnVal[7] = "View";
    returnVal[8] = "Pie Chart";
    returnVal[9] = HELP;
    returnVal[10] = "About";
    returnVal[11] = HELP;
    returnVal[12] = "Preferences";
    returnVal[13] = "Edit";
    returnVal[14] = "Open";
    returnVal[15] = "Save";
    returnVal[16] = "Separators";
    returnVal[17] = "On";
    returnVal[18] = "Off";
    returnVal[19] = "Select a file to save to:";
    returnVal[20] = "Select a file to open from:";
    return returnVal;
  }
  
  /**
   * Get the text in French.
   * @return the texts in French.
   */
  public static String[] getLabelsFR()
  {
    String[] returnVal = new String[21];
    returnVal[0] = "Déposer";
    returnVal[1] = "Séance D'impression";
    returnVal[2] = "Nouvelle Calculatrice";
    returnVal[3] = "Sortie";
    returnVal[4] = MODE;
    returnVal[5] = "Approprié";
    returnVal[6] = "Réduit";
    returnVal[7] = "Voir";
    returnVal[8] = "Diagramme Circulaire";
    returnVal[9] = AIDE;
    returnVal[10] = "À Propos";
    returnVal[11] = AIDE;
    returnVal[12] = "Préférences";
    returnVal[13] = "Modifier";
    returnVal[14] = "Ouvrir";
    returnVal[15] = "Sauvegarder";
    returnVal[16] = "Séparateurs";
    returnVal[17] = "Sur";
    returnVal[18] = "Désactivé";
    returnVal[19] = "Sélectionnez un fichier dans lequel enregistrer:";
    returnVal[20] = "Sélectionnez un fichier à ouvrir:";
    return returnVal;
  }
}
