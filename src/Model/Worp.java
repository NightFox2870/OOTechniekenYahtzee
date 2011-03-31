package Model;

import javax.swing.*;

/**
 * Created by: Yarrith Devos
 * Date: 29-nov-2010
 * Time: 21:14:00
 */
public class Worp {
    private static Dobbelsteen[] dobbelstenen = new Dobbelsteen[5];

    public Worp() {
        dobbelstenen[0] = new Dobbelsteen();
        dobbelstenen[1] = new Dobbelsteen();
        dobbelstenen[2] = new Dobbelsteen();
        dobbelstenen[3] = new Dobbelsteen();
        dobbelstenen[4] = new Dobbelsteen();
    }

    public void werp() {
        for (Dobbelsteen d : dobbelstenen) {
            if (!d.isVast()) {
                d.Werp();
            }
        }
    }

    public void zetVast(int dbnr) {
        dobbelstenen[dbnr].zetVast();
    }

    public static Dobbelsteen[] getWaarden() {
        return dobbelstenen;
    }

    public String toString() {
        return String.format("Dobbelsteen 1: %d\nDobbelsteen 2: %d\nDobbelsteen 3: %d\nDobbelsteen 4: %d\nDobbelsteen 5: %d\n",
                dobbelstenen[0].getWaarde(), dobbelstenen[1].getWaarde(), dobbelstenen[2].getWaarde(), dobbelstenen[3].getWaarde(),
                dobbelstenen[4].getWaarde());
    }

    public static void nietVast() {
        for (Dobbelsteen d : dobbelstenen) {
            d.nietVast();
        }
    }

    public static Dobbelsteen[] getDobbelstenen() {
        return dobbelstenen;
    }

    public static ImageIcon getImageDobbelsteen(int dbnr) {
        ImageIcon db1 = new ImageIcon("dice1.png");
        ImageIcon db2 = new ImageIcon("dice2.png");
        ImageIcon db3 = new ImageIcon("dice3.png");
        ImageIcon db4 = new ImageIcon("dice4.png");
        ImageIcon db5 = new ImageIcon("dice5.png");
        ImageIcon db6 = new ImageIcon("dice6.png");
        int dbwaarde = dobbelstenen[dbnr].getWaarde();
        switch (dbwaarde) {
            case 1:
                return db1;
            case 2:
                return db2;
            case 3:
                return db3;
            case 4:
                return db4;
            case 5:
                return db5;
            case 6:
                return db6;
        }
        return db6;
    }

}
