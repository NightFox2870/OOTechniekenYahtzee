package View;

import Model.*;

import java.util.Scanner;

/**
 * Created by: Yarrith Devos
 * Date: 29-nov-2010
 * Time: 21:14:00
 */
public class YahtzeeConsole {

    public YahtzeeConsole() {
        Scanner scan = new Scanner(System.in);

        System.out.println("Hoeveel spelers gaan er mee spelen?");
        int aantalSpelers = scan.nextInt();
        scan.nextLine();
        for (int i = 0; i < aantalSpelers; i++) {
            System.out.printf("Geef de naam van speler %d:", (i + 1));
            Spel.voegSpelerToe(scan.nextLine());
        }

        for (int i = 0; i < Speler.getAANTAL_RONDES(); i++) {
            for (Speler s : Spel.getSpelers()) {
                Ronde.zetAantalBeurten(0);
                System.out.printf("Speler %d: %s\n", s.getSpelernr(), s.getNaam());
                while (Ronde.getAantalBeurten() < Ronde.getMaxBeurten()) {
                    System.out.println("Dobbelstenen worden geworpen.");
                    Ronde.Werp();
                    System.out.printf("De waarde van de dobbelstenen is:\n%s\n", Ronde.printDbWaarde());
                    System.out.println("Wil je dobbelstenen vastzetten? (geef dobbelsteennr gescheiden met spaties of 0 om te stoppen)");
                    String temp;
                    temp = scan.nextLine();
                    String[] strings = temp.split(" ");
                    for(String st: strings) {
                        int in = 0;
                        if(st != " ") {
                            in = Integer.decode(st);
                        }
                        if(in != 0) {
                            Ronde.zetVast(in);
                            System.out.println("Dobbelsteen " + in + " staat vast.");
                         }
                    }
                   // while (dbv != 0) {
                   //     Ronde.zetVast(dbv - 1);
                   //     System.out.println("Wil je dobbelstenen vastzetten? (geef dobbelsteennr of 0 om te stoppen)");
                   //     dbv = scan.nextInt();
                   // }
                    if (Ronde.getAantalBeurten() < Ronde.getMaxBeurten()) {
                        System.out.println("Wil je nog eens werpen? (y/n)");
                        char c = scan.next().toLowerCase().charAt(0);
                        scan.nextLine();
                        if (c == 'n') {
                            Ronde.zetAantalBeurten(3);
                        }
                    }
                }
                boolean klaar = false;
                while (!klaar) {
                    System.out.printf("De waarde van de dobbelstenen is:\n%s\n", Ronde.printDbWaarde());
                    System.out.println("Wat wil je invullen op je scoreblad?");
                    System.out.print("1.Eenen 2.Tweeën 3.Drieën 4.Vieren 5.Vijven 6.Zessen ");
                    System.out.println("7.Drie dezelfde 8.Carré 9.Full House 10.Kleine straat 11.Grote straat 12.Yahtzee 13.Chance 14.Zet een nul 15.Bekijk Scoresheet");
                    int keuze = scan.nextInt();
                    scan.nextLine();
                    if (keuze == 1) {
                        if (s.zetScore((keuze+1), Score.telAantal(1))) {
                            Speler.isYahtzeeBonus();
                            System.out.println("Score ingevuld");
                            klaar = true;
                        } else {
                            System.out.println("Illegal move");
                        }
                    } else if (keuze == 2) {
                        if (s.zetScore((keuze+1), Score.telAantal(1))) {
                            Speler.isYahtzeeBonus();
                            System.out.println("Score ingevuld");
                            klaar = true;
                        } else {
                            System.out.println("Illegal move");
                        }
                    } else if (keuze == 3) {
                        if (s.zetScore((keuze+1), Score.telAantal(1))) {
                            Speler.isYahtzeeBonus();
                            System.out.println("Score ingevuld");
                            klaar = true;
                        } else {
                            System.out.println("Illegal move");
                        }
                    } else if (keuze == 4) {
                        if (s.zetScore((keuze+1), Score.telAantal(1))) {
                            Speler.isYahtzeeBonus();
                            System.out.println("Score ingevuld");
                            klaar = true;
                        } else {
                            System.out.println("Illegal move");
                        }
                    } else if (keuze == 5) {
                        if (s.zetScore((keuze+1), Score.telAantal(1))) {
                            Speler.isYahtzeeBonus();
                            System.out.println("Score ingevuld");
                            klaar = true;
                        } else {
                            System.out.println("Illegal move");
                        }
                    } else if (keuze == 6) {
                        if (s.zetScore((keuze+1), Score.telAantal(1))) {
                            Speler.isYahtzeeBonus();
                            System.out.println("Score ingevuld");
                            klaar = true;
                        } else {
                            System.out.println("Illegal move");
                        }
                    } else if (keuze == 7) {
                        if (s.zetScore((keuze+1), Score.telAlleStrenen())) {
                            Speler.isYahtzeeBonus();
                            System.out.println("Score ingevuld");
                            klaar = true;
                        } else {
                            System.out.println("Illegal move");
                        }
                    } else if (keuze == 8) {
                        if (s.zetScore((keuze+1), Score.telAlleStrenen())) {
                            Speler.isYahtzeeBonus();
                            System.out.println("Score ingevuld");
                            klaar = true;
                        } else {
                            System.out.println("Illegal move");
                        }
                    } else if (keuze == 9) {
                        if (s.zetScore((keuze+1), 0)) {
                            Speler.isYahtzeeBonus();
                            System.out.println("Score ingevuld");
                            klaar = true;
                        } else {
                            System.out.println("Illegal move");
                        }
                    } else if (keuze == 10) {
                        if (s.zetScore((keuze+1), 0)) {
                            Speler.isYahtzeeBonus();
                            System.out.println("Score ingevuld");
                            klaar = true;
                        } else {
                            System.out.println("Illegal move");
                        }
                    } else if (keuze == 11) {
                        if (s.zetScore((keuze+1), 0)) {
                            Speler.isYahtzeeBonus();
                            System.out.println("Score ingevuld");
                            klaar = true;
                        } else {
                            System.out.println("Illegal move");
                        }
                    } else if (keuze == 12) {
                        if (s.zetScore((keuze+1), 0)) {
                            Speler.isYahtzeeBonus();
                            System.out.println("Score ingevuld");
                            klaar = true;
                        } else {
                            System.out.println("Illegal move");
                        }
                    } else if (keuze == 13) {
                        if (s.zetScore((keuze+1), Score.telAlleStrenen())) {
                            Speler.isYahtzeeBonus();
                            System.out.println("Score ingevuld");
                            klaar = true;
                        } else {
                            System.out.println("Illegal move");
                        }
                    } else if (keuze == 14) {
                        Speler.isYahtzeeBonus();
                        System.out.printf("Geef in welke score je een nul wil geven:\n");
                        int t = scan.nextInt();
                        if (Spel.getActivePlayer().getScoresheet()[t] == -1) {
                            if(s.zetScore((keuze+1), t));
                            System.out.println("Nul ingevuld");
                            klaar = true;
                        } else {
                            System.out.println("Score al ingevuld");
                        }

                    } else if (keuze == 15) {
                        System.out.println("Scoresheet:\n" + s.weergeefScoresheet());
                    } else {
                        System.out.printf("Verkeerd nummer\n");
                    }
                }
                Worp.nietVast();
            }
        }
        if (Spel.getSpelers().size() > 1) {
            Spel.berekenWinnaar();
        }
        for (int i = 0; i < Spel.getSpelers().size(); i++) {
            System.out.printf("Totaal speler %d %d\n", i+1, Spel.berekenTotaal()[i]);
        }
        Spel.HighScore();
        for (int i = 0; i < 10; i++) {
            System.out.printf("%d %s\n", (i + 1), Spel.bekijkHighscore().get(i));
        }
    }
}
