package Model;


/**
 * Created by: Yarrith Devos
 * Date: 29-nov-2010
 * Time: 21:14:00
 */
public class Check {

    public static boolean Nummer(Score.ScoreNaam n) {
        if (n == Score.ScoreNaam.Eenen) {
            if (Spel.getActivePlayer().getScoresheet()[0] == -1) {
                return true;
            } else {
                return false;
            }
        }
        if (n == Score.ScoreNaam.Tweeen) {
            if (Spel.getActivePlayer().getScoresheet()[1] == -1) {
                return true;
            } else {
                return false;
            }
        }
        if (n == Score.ScoreNaam.Drieen) {
            if (Spel.getActivePlayer().getScoresheet()[2] == -1) {
                return true;
            } else {
                return false;
            }
        }
        if (n == Score.ScoreNaam.Vieren) {
            if (Spel.getActivePlayer().getScoresheet()[3] == -1) {
                return true;
            } else {
                return false;
            }
        }
        if (n == Score.ScoreNaam.Vijven) {
            if (Spel.getActivePlayer().getScoresheet()[4] == -1) {
                return true;
            } else {
                return false;
            }
        }
        if (n == Score.ScoreNaam.Zessen) {
            if (Spel.getActivePlayer().getScoresheet()[5] == -1) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    private static int[] telDobbelstenen() {
        int[] nr = new int[6];
        for (Dobbelsteen d : Worp.getWaarden()) {
            nr[d.getWaarde()-1]++;

        }
        return nr;
    }

    public static boolean DrieDezelfde() {
        if (Spel.getActivePlayer().getScoresheet()[6] == -1) {
            int[] nr = telDobbelstenen();
            if (nr[0] >= 3 || nr[1] >= 3 || nr[2] >= 3 || nr[3] >= 3 || nr[4] >= 3 || nr[5] >= 3 || Speler.isYahtzeeBonus()) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    public static boolean Carré() {
        if (Spel.getActivePlayer().getScoresheet()[7] == -1) {
            int[] nr = telDobbelstenen();
            if (nr[0] >= 4 || nr[1] >= 4 || nr[2] >= 4 || nr[3] >= 4 || nr[4] >= 4 || nr[5] >= 4 || Speler.isYahtzeeBonus()) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    public static boolean FullHouse() {
        if (Spel.getActivePlayer().getScoresheet()[8] == -1) {
            int[] nr = telDobbelstenen();
            if (nr[0] >= 3 || nr[1] >= 3 || nr[2] >= 3 || nr[3] >= 3 || nr[4] >= 3 || nr[5] >= 3 || Speler.isYahtzeeBonus()) {
                if ((nr[0] >= 2 || nr[1] >= 2 || nr[2] >= 2 || nr[3] >= 2 || nr[4] >= 2 || nr[5] >= 2) && (!(nr[0] >= 3) || !(nr[1] >= 3) || !(nr[2] >= 3) || !(nr[3] >= 3) || !(nr[4] >= 3) || !(nr[5] >= 3)) || Speler.isYahtzeeBonus()) {
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }
        return false;
    }

    public static boolean KleineStraat() {
        if (Spel.getActivePlayer().getScoresheet()[9] == -1) {
            int[] nr = telDobbelstenen();
            if (((nr[0] >= 1) && (nr[1] >= 1) && (nr[2] >= 1) && (nr[3] >= 1)) || ((nr[1] >= 1) && (nr[2] >= 1) && (nr[3] >= 1) && (nr[4] >= 1)) || ((nr[2] >= 1) && (nr[3] >= 1) && (nr[4] >= 1) && (nr[5] >= 1)) || Speler.isYahtzeeBonus()) {
                return true;
            } else {
                return false;
            }
        }
        return false;

    }

    public static boolean GroteStraat() {
        if (Spel.getActivePlayer().getScoresheet()[10] == -1) {
            int[] nr = telDobbelstenen();
            if (((nr[0] == 1) && (nr[1] == 1) && (nr[2] == 1) && (nr[3] == 1) && (nr[4] == 1)) || ((nr[1] == 1) && (nr[2] == 1) && (nr[3] == 1) && (nr[4] == 1) && (nr[5] == 1)) || Speler.isYahtzeeBonus()) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    public static boolean Yahtzee() {
        if (Spel.getActivePlayer().getScoresheet()[11] == -1) {
            int[] nr = telDobbelstenen();
            if (nr[0] == 5 || nr[1] == 5 || nr[2] == 5 || nr[3] == 5 || nr[4] == 5 || nr[5] == 5) {
                return true;
            } else {
                return false;
            }
        }
        else if (Speler.getYahtzeeBonus()) {
            int[] nr = telDobbelstenen();
            if (nr[0] == 5 || nr[1] == 5 || nr[2] == 5 || nr[3] == 5 || nr[4] == 5 || nr[5] == 5) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    public static boolean Chance() {
        if (Spel.getActivePlayer().getScoresheet()[12] == -1) {
            return true;
        } else {
            return false;
        }

    }

    public static boolean Nul(int index) {
        if (Spel.getActivePlayer().getScoresheet()[index] == -1) {
            return true;
        } else {
            return false;
        }
    }


}
