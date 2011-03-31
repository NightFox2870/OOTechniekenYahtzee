package Model;


/**
 * Created by: Yarrith Devos
 * Date: 29-nov-2010
 * Time: 21:14:00
 */
public class Speler implements Comparable<Speler>{
    private String naam;
    private int spelernr, teller = 1;
    private Score score = new Score();
    private static boolean yahtzeeBonus;
    private static int totaal = 0;
    private static final int AANTAL_RONDES = 13;
    private int aantalGespeeldeRondes = 0;
    private static boolean active = false;

    public Speler(String naam) {
        this.naam = naam;
        spelernr = teller++;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        Speler.active = active;
    }

    public int getAantalGespeeldeRondes() {
        return aantalGespeeldeRondes;
    }

    public void setAantalGespeeldeRondes(int aantalGespeeldeRondes) {
        this.aantalGespeeldeRondes = aantalGespeeldeRondes;
    }

    public static void setYahtzeeBonus(boolean bonus) {
        yahtzeeBonus = bonus;
    }

    public static int getAANTAL_RONDES() {
        return AANTAL_RONDES;
    }

    public static boolean isYahtzeeBonus() {
        Spel.checkYahtzeeBonus();
            voegBonusPuntenToe();
        return yahtzeeBonus;
    }

    private static void voegBonusPuntenToe() {
        if(yahtzeeBonus) {
            if(Check.Yahtzee()) {
                totaal += 100;
            }

        }
    }

    public static boolean getYahtzeeBonus() {
        return yahtzeeBonus;
    }

    public boolean zetNul(String s) {
        boolean b = false;
        String str = s.toLowerCase();
        if(str.compareToIgnoreCase("eenen") == 0) {
            b = score.zetNul(0);
        } else if(str.compareToIgnoreCase("tweeen") == 0) {
            b = score.zetNul(1);
        } else if(str.compareToIgnoreCase("drieen") == 0) {
            b = score.zetNul(2);
        } else if(str.compareToIgnoreCase("vieren") == 0) {
            b = score.zetNul(3);
        } else if(str.compareToIgnoreCase("vijven") == 0) {
            b = score.zetNul(4);
        } else if(str.compareToIgnoreCase("zessen") == 0) {
            b = score.zetNul(5);
        } else if(str.compareToIgnoreCase("driedezelfde") == 0) {
            b = score.zetNul(6);
        } else if(str.compareToIgnoreCase("carre") == 0) {
            b = score.zetNul(7);
        } else if(str.compareToIgnoreCase("fullhouse") == 0) {
            b = score.zetNul(8);
        } else if(str.compareToIgnoreCase("kleinestraat") == 0) {
            b = score.zetNul(9);
        } else if(str.compareToIgnoreCase("grotestraat") == 0) {
            b = score.zetNul(10);
        } else if(str.compareToIgnoreCase("yahtzee") == 0) {
            b = score.zetNul(11);
        } else if(str.compareToIgnoreCase("chance") == 0) {
            b = score.zetNul(12);
        }
        return b;
    }

    public boolean zetScore(int scoreNaamOrdinal, int scoreNr) {
        boolean b;
        b = score.zetScore(scoreNaamOrdinal, scoreNr);
        return b;
    }

    public int[] getScoresheet() {
        return score.getScoresheet();
    }

    public static int getTotaal() {
        return totaal;
    }

    public String getNaam() {
        return naam;
    }

    public int getSpelernr() {
        return spelernr;
    }

    public int berekenTotaal() {
            for (int i : getScoresheet()) {
                if(i == -1) {
                    i = 0;
                }
                totaal += i;
            }
        return totaal;
    }

    public String berekenTotaalString() {
        return String.format("%d", berekenTotaal());
    }

    public int compareTo(Speler o) {
        return o.totaal - this.totaal;
    }

    @Override
    public String toString() {
        return String.format("%s Speler %d", naam, spelernr);
    }

    public String weergeefScoresheet () {
        return score.weergeefScoresheet();
    }

    public String[] geefScoreSheet () {
        String [] scores = new String[13];
        int[] sInts = new int[getScoresheet().length];
        for(int i = 0; i < getScoresheet().length; i++) {
            sInts[i] = getScoresheet()[i];
        }
        for(int i = 0; i < score.getScoresheet().length; i++) {
            if(sInts[i] == -1) {
            	sInts[i] = 0;
            }
        	scores[i] = String.format("%d", sInts[i]);
        }
        return scores;
    }
}
