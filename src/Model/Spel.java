package Model;

import View.YahtzeeGUI;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Formatter;
import java.util.Scanner;


/**
 * Created by: Yarrith Devos
 * Date: 29-nov-2010
 * Time: 21:14:00
 * Spelgedaan checken bij invullen van score op scoresheet (invullen JButton)
 */
public class Spel {
    private static ArrayList<Speler> spelers = new ArrayList<Speler>();
    private static boolean spelGedaan = false;

    public static void voegSpelerToe(String naam) {
        Speler speler = new Speler(naam);
        spelers.add(speler);
    }

    public static void isSpelGedaan() {
        boolean[] sp = new boolean[spelers.size()];
        int i = 0;
        boolean all = true;
        for (Speler s : spelers) {
            if (s.getAantalGespeeldeRondes() >= Speler.getAANTAL_RONDES()) {
                sp[i] = true;
                i++;
            }
        }
        for (int j = 0; j < sp.length; j++) {
            if (!sp[j]) {
                all = false;
            }
        }
        if (all) {
            spelGedaan = true;
        }
    }

    public static void leegSpelers() {
        for (int i = 0; i < spelers.size(); i++) {
            spelers.remove(i);
        }
    }

    public static void startSpel() {
        if (!spelGedaan) {
            boolean allInactive = true;
            for (Speler s : spelers) {
                if (s.isActive()) {
                    allInactive = false;
                }
            }
            if (allInactive) {
                spelers.get(0).setActive(true);
                for (Speler s : spelers) {
                    s.setAantalGespeeldeRondes(0);
                }
            }
        }
    }

    public static void changeActivePlayer() {
        getActivePlayer().setAantalGespeeldeRondes((getActivePlayer().getAantalGespeeldeRondes() + 1));
        Ronde.zetAantalBeurten(0);
        Worp.nietVast();
        YahtzeeGUI.getWerp().setEnabled(true);
        isSpelGedaan();
        Ronde.eersteWorp();
        YahtzeeGUI.refreshButtonImages();
        if (!spelGedaan) {
            if (spelers.size() > 1) {
                boolean foundActive = false;
                for (int i = 0; i < spelers.size(); i++) {
                    if (spelers.get(i).isActive()) {
                        spelers.get(i).setActive(false);
                        if (!(i == spelers.size())) {
                            foundActive = true;
                        } else {
                            foundActive = false;
                        }
                    } else if (spelers.get(i).isActive() && foundActive) {
                        spelers.get(i).setActive(true);
                        i = spelers.size();
                    } else if (((i + 1) == spelers.size()) && !foundActive) {
                        spelers.get(0).setActive(true);
                    }
                }
            } else {
                spelers.get(0).setActive(true);
            }
            YahtzeeGUI.makePlayerActive(getSpelerArray());
        } else {
            for (Speler s : spelers) {
                s.berekenTotaal();
            }
            HighScore();
        }
    }

    public static Speler getActivePlayer() {
        Speler speler = new Speler(null);
        for (Speler s : spelers) {
            if (s.getAantalGespeeldeRondes() < Speler.getAANTAL_RONDES()) {
                if (s.isActive()) {
                    speler = s;
                }
            }
        }
        return speler;
    }

    public static void alleenToeVoegen(Speler speler) {
        spelers.add(speler);
    }

    public static ArrayList<Speler> getSpelers() {
        return spelers;
    }

    public static String[] getSpelerArray() {
        String[] spelerArray = new String[spelers.size()];
        int i = 0;
        for (Speler s : spelers) {
            if (s.isActive()) {
                spelerArray[i] = String.format("%s %s", "(Active)", s.getNaam());
                i++;
            } else {
                spelerArray[i] = s.getNaam();
                i++;
            }
        }
        return spelerArray;
    }

    public static Speler berekenWinnaar() {
        sorteer();
        return spelers.get(0);
    }

    public static int[] berekenTotaal() {
        int[] totaal = new int[spelers.size()];
        int teller = 0;
        for (Speler s : spelers) {
            totaal[teller] += Speler.getTotaal();
            for (int i : s.getScoresheet()) {
                if (i == -1) {
                    i = 0;
                }
                totaal[teller] += i;
            }
            teller++;
        }
        return totaal;
    }

    public static void checkYahtzeeBonus() {
        if (getActivePlayer().getScoresheet()[11] != -1) {
            Speler.setYahtzeeBonus(true);
        }
    }

    public static void HighScore() {
        for (Speler sp : spelers) {
            ArrayList<String> scores = new ArrayList<String>();
            try {
                Scanner scanner = new Scanner(new FileReader("topscores.txt"));
                ArrayList<Integer> cijferScores = new ArrayList<Integer>();
                boolean gezet = false;
                for (int b = 0; b < 10; b++) {
                    scores.add(scanner.nextLine());   //De 10 lijnen van topscores.txt inlezen en in een arraylist opslaan
                }
                for (int b = 0; b < 10; b++) {
                    ArrayList<Character> naam = new ArrayList<Character>();
                    for (int i = 1; i < 5;) {
                        if (scores.get(b).charAt(scores.get(b).length() - i) != ' ') {             //als char geen spatie is
                            naam.add((i - 1), scores.get(b).charAt(scores.get(b).length() - i));   //laatste paar chars uit strings van arraylist halen (de score zelf dus)
                            i++;
                        } else {                                                //als char een spatie is wordt de for-next lus beëindigd
                            i = 5;
                        }
                        if (naam.get(naam.size() - 1) == '\t') {                //als het char \t (een tab) in de arraylist staat, verwijder deze dan
                            naam.remove(naam.size() - 1);
                        }
                    }
                    StringBuilder temp = new StringBuilder();
                    for (int i = naam.size(); i > 0; i--) {                       //Plak de cijfers aan elkaar in een stringbuilder
                        temp.append(naam.get(i - 1));
                    }
                    String s = String.format("%s", temp);                         //Maak een string van de stringbuilder
                    cijferScores.add(Integer.decode(s));                          //zet de string om naar een int en zet deze int in een arraylist
                    if (cijferScores.get(b) < sp.getTotaal() && !gezet) {         //als de huidige score kleiner is dan het totaal van de huidige speler
                        scores.add(b, String.format("%s %d", sp.getNaam(), sp.getTotaal()));    //voeg deze speler dan toe aan de arraylist met scores
                        scores.remove(scores.size() - 1);                                 //en verwijder de laatste score in de arraylist
                        gezet = true;                                                     //De score van de huidige speler is toegevoegd
                    }
                }


            } catch (FileNotFoundException e) {
                System.out.println("topscores.txt niet gevonden!");
            }


            try {
                Formatter uitvoer = new Formatter("topscores.txt");
                for (int c = 0; c < 10; c++) {
                    uitvoer.format("%s\n", scores.get(c));             //Schrijf de scores uit de arraylist terug weg naar topscores.txt
                }
                uitvoer.close();
            } catch (FileNotFoundException e) {
                System.out.println("Schrijven lukt niet!");
            }
        }
    }

    public static ArrayList<String> bekijkHighscore() {             //haal de highscores uit txt file en zet ze in een arraylist die gereturned wordt
        ArrayList<String> scores = new ArrayList<String>();
        try {

            Scanner scanner = new Scanner(new FileReader("topscores.txt"));
            for (int b = 0; b < 10; b++) {
                scores.add(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("topscores.txt niet gevonden!");
        }
        return scores;
    }

    public static String[] totalen() {
        String[] totalen = new String[spelers.size()];
        for (int i = 0; i < spelers.size(); i++) {
            totalen[i] = spelers.get(i).berekenTotaalString();
        }
        return totalen;
    }

    private static void sorteer() {
        for (Speler s : spelers) {
            s.berekenTotaal();
        }
        Collections.sort(spelers);
    }
}
