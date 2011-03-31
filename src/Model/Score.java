package Model;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by: Yarrith Devos
 * Date: 29-nov-2010
 * Time: 21:14:00
 */
public class Score {
    private int[] scoresheet = new int[13];
    private static String[] scorenamen = {"Eenen", "Tweeën", "Drieën", "Vieren", "Vijven", "Zessen", "Drie Dezelfde", "Carré", "Full House", "Kleine straat", "Grote straat", "Yahtzee", "Chance", "Zet een nul" };
    private static String nul = "Zet een nul";

    public Score() {
        Arrays.fill(scoresheet, -1);
    }

    public static String[] getScorenamen() {
        return scorenamen;
    }

    public static String[] getScorenamenJC() {
        String[] scoreN = new String[13];
        for (int i = 0; i < 13; i++) {
            scoreN[i] = scorenamen[i];
        }
        return scoreN;
    }

    public static ArrayList<String> getNul() {
        ArrayList<String> scores = new ArrayList<String>();
        for(int i = 0; i < scorenamen.length; i++) {
            scores.add(scorenamen[i]);
        }
        scores.add(nul);
        return scores;
    }

    public boolean zetScore(int scoreOrdinal, int Score) {
        boolean b = false;
        if (scoreOrdinal == ScoreNaam.Eenen.ordinal()) {
            if (Check.Nummer(ScoreNaam.Eenen)) {
                scoresheet[0] = Score;
                b = true;
            }
        } else if (scoreOrdinal == ScoreNaam.Tweeen.ordinal()) {
            if (Check.Nummer(ScoreNaam.Tweeen)) {
                scoresheet[1] = Score;
                b = true;
            }
        } else if (scoreOrdinal == ScoreNaam.Drieen.ordinal()) {
            if (Check.Nummer(ScoreNaam.Drieen)) {
                scoresheet[2] = Score;
                b = true;
            }
        } else if (scoreOrdinal == ScoreNaam.Vieren.ordinal()) {
            if (Check.Nummer(ScoreNaam.Vieren)) {
                scoresheet[3] = Score;
                b = true;
            }
        } else if (scoreOrdinal == ScoreNaam.Vijven.ordinal()) {
            if (Check.Nummer(ScoreNaam.Vijven)) {
                scoresheet[4] = Score;
                b = true;
            }
        } else if (scoreOrdinal == ScoreNaam.Zessen.ordinal()) {
            if (Check.Nummer(ScoreNaam.Zessen)) {
                scoresheet[5] = Score;
                b = true;
            }
        } else if (scoreOrdinal == ScoreNaam.DrieDezelfde.ordinal()) {
            if (Check.DrieDezelfde()) {
                scoresheet[6] = Score;
                b = true;
            }
        } else if (scoreOrdinal == ScoreNaam.Carre.ordinal()) {
            if (Check.Carré()) {
                scoresheet[7] = Score;
                b = true;
            }
        } else if (scoreOrdinal == ScoreNaam.FullHouse.ordinal()) {
            if (Check.FullHouse()) {
                scoresheet[8] = 25;
                b = true;
            }
        } else if (scoreOrdinal == ScoreNaam.KleineStraat.ordinal()) {
            if (Check.KleineStraat()) {
                scoresheet[9] = 30;
                b = true;
            }
        } else if (scoreOrdinal == ScoreNaam.GroteStraat.ordinal()) {
            if (Check.GroteStraat()) {
                scoresheet[10] = 40;
                b = true;
            }
        } else if (scoreOrdinal == ScoreNaam.Yahtzee.ordinal()) {
            if (Check.Yahtzee()) {
                scoresheet[11] = 50;
                b = true;
            }
        } else if (scoreOrdinal == ScoreNaam.Chance.ordinal()) {
            if (Check.Chance()) {
                scoresheet[12] = Score;
                b = true;
            }
        }
        return b;
    }

    public boolean zetNul(int index) {
        boolean b = false;
        if (Check.Nul(index)) {
            scoresheet[index] = 0;
            b = true;
        }
        return b;
    }

    public int[] getScoresheet() {
        return scoresheet;
    }

    public enum ScoreNaam {
        Eenen, Tweeen, Drieen, Vieren, Vijven, Zessen, DrieDezelfde, Carre, FullHouse, KleineStraat, GroteStraat, Yahtzee, Chance, Nul
    }

    public static int telAantal(int getal) {
        int totaalWaarde = 0;
        for (Dobbelsteen d : Worp.getWaarden()) {
            if (d.getWaarde() == getal) {
                totaalWaarde += d.getWaarde();
            }
        }
        return totaalWaarde;
    }

    public static int telAlleStrenen() {
        int totaal = 0;
        for (Dobbelsteen d : Worp.getWaarden()) {
            totaal += d.getWaarde();
        }
        return totaal;
    }

    public String weergeefScoresheet() {
        String score = "";
        for (int i = 0; i < scoresheet.length; i++) {
            switch (i) {
                case (0):
                    if (scoresheet[i] != -1) {
                        score += String.format("Eenen: %d\n", scoresheet[i]);
                    } else {
                        score += String.format("Eenen: %d\n", 0);
                    }
                    break;
                case (1):
                    if (scoresheet[i] != -1) {
                        score += String.format("Tweëen: %d\n", scoresheet[i]);
                    } else {
                        score += String.format("Tweëen: %d\n", 0);
                    }
                    break;
                case (2):
                    if (scoresheet[i] != -1) {
                        score += String.format("Drieën: %d\n", scoresheet[i]);
                    } else {
                        score += String.format("Drieën: %d\n", 0);
                    }
                    break;
                case (3):
                    if (scoresheet[i] != -1) {
                        score += String.format("Vieren: %d\n", scoresheet[i]);
                    } else {
                        score += String.format("Vieren: %d\n", 0);
                    }
                    break;
                case (4):
                    if (scoresheet[i] != -1) {
                        score += String.format("Vijven: %d\n", scoresheet[i]);
                    } else {
                        score += String.format("Vijven: %d\n", 0);
                    }
                    break;
                case (5):
                    if (scoresheet[i] != -1) {
                        score += String.format("Zessen: %d\n", scoresheet[i]);
                    } else {
                        score += String.format("Zessen: %d\n", 0);
                    }
                    break;
                case (6):
                    if (scoresheet[i] != -1) {
                        score += String.format("Drie Dezelfde: %d\n", scoresheet[i]);
                    } else {
                        score += String.format("Drie Dezelfde: %d\n", 0);
                    }
                    break;
                case (7):
                    if (scoresheet[i] != -1) {
                        score += String.format("Carré: %d\n", scoresheet[i]);
                    } else {
                        score += String.format("Carré: %d\n", 0);
                    }
                    break;
                case (8):
                    if (scoresheet[i] != -1) {
                        score += String.format("Full House: %d\n", scoresheet[i]);
                    } else {
                        score += String.format("Full House: %d\n", 0);
                    }
                    break;
                case (9):
                    if (scoresheet[i] != -1) {
                        score += String.format("Kleine Straat: %d\n", scoresheet[i]);
                    } else {
                        score += String.format("Kleine Straat: %d\n", 0);
                    }
                    break;
                case (10):
                    if (scoresheet[i] != -1) {
                        score += String.format("Grote Straat: %d\n", scoresheet[i]);
                    } else {
                        score += String.format("Grote Straat: %d\n", 0);
                    }
                    break;
                case (11):
                    if (scoresheet[i] != -1) {
                        score += String.format("Yahtzee: %d\n", scoresheet[i]);
                    } else {
                        score += String.format("Yahtzee: %d\n", 0);
                    }
                    break;
                case (12):
                    if (scoresheet[i] != -1) {
                        score += String.format("Chance: %d\n", scoresheet[i]);
                    } else {
                        score += String.format("Chance: %d\n", 0);
                    }
                    break;
            }
        }
        return score;
    }
}
