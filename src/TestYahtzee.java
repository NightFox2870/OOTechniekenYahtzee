import Model.*;

import java.util.Arrays;

/**
 * Created by: Yarrith Devos
 * Date: 29-nov-2010
 * Time: 21:14:00
 */
public class TestYahtzee {
    public static void main(String[] args) {
        Speler speler = new Speler("Karel");
        Spel.alleenToeVoegen(speler);
        Dobbelsteen d = new Dobbelsteen();
        d.setWaarde(1);
        Worp.getDobbelstenen()[0] = new Dobbelsteen();
        Worp.getDobbelstenen()[1] = new Dobbelsteen();
        Worp.getDobbelstenen()[2] = new Dobbelsteen();
        Worp.getDobbelstenen()[3] = new Dobbelsteen();
        Worp.getDobbelstenen()[4] = new Dobbelsteen();
        Worp.getDobbelstenen()[0].setWaarde(1);
        Worp.getDobbelstenen()[1].setWaarde(1);
        Worp.getDobbelstenen()[2].setWaarde(1);
        Worp.getDobbelstenen()[3].setWaarde(1);
        Worp.getDobbelstenen()[4].setWaarde(1);

        for (int i = 0; i < 5; i++) {
            Worp.getDobbelstenen()[i].setWaarde(1);
        }
        speler.zetScore(Score.ScoreNaam.Nul.ordinal(), 0);
        for (int i = 0; i < 5; i++) {
            Worp.getDobbelstenen()[i].setWaarde(2);
        }
        speler.zetScore(Score.ScoreNaam.Nul.ordinal(), 1);
        for (int i = 0; i < 5; i++) {
            Worp.getDobbelstenen()[i].setWaarde(3);
        }
        speler.zetScore(Score.ScoreNaam.Nul.ordinal(), 2);
        for (int i = 0; i < 5; i++) {
            Worp.getDobbelstenen()[i].setWaarde(4);
        }
        speler.zetScore(Score.ScoreNaam.Nul.ordinal(), 3);
        for (int i = 0; i < 5; i++) {
            Worp.getDobbelstenen()[i].setWaarde(5);
        }
        speler.zetScore(Score.ScoreNaam.Nul.ordinal(), 4);
        for (int i = 0; i < 5; i++) {
            Worp.getDobbelstenen()[i].setWaarde(6);
        }
        speler.zetScore(Score.ScoreNaam.Nul.ordinal(), 5);
        for (int i = 0; i < 5; i++) {
            Worp.getDobbelstenen()[i].setWaarde(6);
        }
        speler.zetScore(Score.ScoreNaam.Nul.ordinal(), 6);
        for (int i = 0; i < 5; i++) {
            Worp.getDobbelstenen()[i].setWaarde(6);
        }
        speler.zetScore(Score.ScoreNaam.Carre.ordinal(), 29);
        for (int i = 0; i < 5; i++) {
            if(i <=  2) {
                Worp.getDobbelstenen()[i].setWaarde(1);
            } else {
                Worp.getDobbelstenen()[i].setWaarde(2);
            }
        }
        speler.zetScore(Score.ScoreNaam.FullHouse.ordinal(), 40);
        for (int i = 0; i < 5; i++) {
            Worp.getDobbelstenen()[i].setWaarde(i+1);
        }
        speler.zetScore(Score.ScoreNaam.Nul.ordinal(), 9);
        for (int i = 0; i < 5; i++) {
            Worp.getDobbelstenen()[i].setWaarde(i+1);
        }
        speler.zetScore(Score.ScoreNaam.Nul.ordinal(), 10);
        for (int i = 0; i < 5; i++) {
            Worp.getDobbelstenen()[i].setWaarde(6);
        }
        speler.zetScore(Score.ScoreNaam.Yahtzee.ordinal(), 0);
        for (int i = 0; i < 5; i++) {
            Worp.getDobbelstenen()[i].setWaarde(6);
        }
        speler.zetScore(Score.ScoreNaam.Chance.ordinal(), 12);
        String s = "";
        if(Speler.isYahtzeeBonus()) {
            s = "True";
        } else {
            s = "False";
        }


        System.out.println("" + speler.weergeefScoresheet());
        System.out.println("Bonus: " + s);
         for (int i = 0; i < Spel.getSpelers().size(); i++) {
            System.out.printf("Totaal speler %d %d\n", i+1, speler.berekenTotaal());
        }
        Spel.HighScore();
        for (int i = 0; i < 10; i++) {
            System.out.printf("%d %s\n", (i + 1), Spel.bekijkHighscore().get(i));
        }


    }

}
