package View;

import Model.Ronde;
import Model.Score;
import Model.Spel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by: Yarrith Devos
 * Date: 04-mar-2011
 * Time: 23:14:00
 */
public class YahtzeeEventHandlers {
    //   private static WerpButton werpButton = new WerpButton();

    static class WerpButton implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Spel.startSpel();
            Ronde.Werp();
            YahtzeeGUI.refreshButtonImages();
            if (Ronde.getAantalBeurten() == Ronde.getMaxBeurten()) {
                YahtzeeGUI.getWerp().setEnabled(false);
            }
        }
    }

    static class QuitButton implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    }

    static class ZetVast1 implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Ronde.zetVast(0);
        }
    }

    static class ZetVast2 implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Ronde.zetVast(1);
        }
    }

    static class ZetVast3 implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Ronde.zetVast(2);
        }
    }

    static class ZetVast4 implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Ronde.zetVast(3);
        }
    }

    static class ZetVast5 implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Ronde.zetVast(4);
        }
    }

    static class VulScoreIn implements ActionListener {
        public void actionPerformed(ActionEvent actionEvent) {
            boolean b;
            if (YahtzeeGUI.getinTeVullen().getSelectedIndex() == 0) {
                Spel.getActivePlayer().isYahtzeeBonus();
                b = Spel.getActivePlayer().zetScore(YahtzeeGUI.getinTeVullen().getSelectedIndex(), Score.telAantal(1));
            } else if (YahtzeeGUI.getinTeVullen().getSelectedIndex() == 1) {
                Spel.getActivePlayer().isYahtzeeBonus();
                b = Spel.getActivePlayer().zetScore(YahtzeeGUI.getinTeVullen().getSelectedIndex(), Score.telAantal(2));
            } else if (YahtzeeGUI.getinTeVullen().getSelectedIndex() == 2) {
                Spel.getActivePlayer().isYahtzeeBonus();
                b = Spel.getActivePlayer().zetScore(YahtzeeGUI.getinTeVullen().getSelectedIndex(), Score.telAantal(3));
            } else if (YahtzeeGUI.getinTeVullen().getSelectedIndex() == 3) {
                Spel.getActivePlayer().isYahtzeeBonus();
                b = Spel.getActivePlayer().zetScore(YahtzeeGUI.getinTeVullen().getSelectedIndex(), Score.telAantal(4));
            } else if (YahtzeeGUI.getinTeVullen().getSelectedIndex() == 4) {
                Spel.getActivePlayer().isYahtzeeBonus();
                b = Spel.getActivePlayer().zetScore(YahtzeeGUI.getinTeVullen().getSelectedIndex(), Score.telAantal(5));
            } else if (YahtzeeGUI.getinTeVullen().getSelectedIndex() == 5) {
                Spel.getActivePlayer().isYahtzeeBonus();
                b = Spel.getActivePlayer().zetScore(YahtzeeGUI.getinTeVullen().getSelectedIndex(), Score.telAantal(6));
            } else if (YahtzeeGUI.getinTeVullen().getSelectedIndex() == 13) {
                String s;
                s = JOptionPane.showInputDialog("Waar wil je een nul zetten? (geef de scorenaam zonder spaties of speciale tekens)");
                if(s == null) {
                    b = false;
                    JOptionPane.showMessageDialog(null, "Geen nul gezet", "Geen nul", JOptionPane.INFORMATION_MESSAGE);
                }
                b = Spel.getActivePlayer().zetNul(s);
            } else {
                Spel.getActivePlayer().isYahtzeeBonus();
                b = Spel.getActivePlayer().zetScore(YahtzeeGUI.getinTeVullen().getSelectedIndex(), Score.telAlleStrenen());
            }
            if (b) {
                JOptionPane.showMessageDialog(null, "Score ingevuld", "Ingevuld", JOptionPane.INFORMATION_MESSAGE);
                YahtzeeGUI.setScoreListData(Spel.getActivePlayer().geefScoreSheet());
                YahtzeeGUI.setPlayerListData(Spel.totalen());
                Spel.changeActivePlayer();
            } else {
                JOptionPane.showMessageDialog(null, "Score niet ingevuld", "Niet Ingevuld", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }

    static class HighScore implements ActionListener {
        public void actionPerformed(ActionEvent actionEvent) {
            String str = "";
            for (String s : Spel.bekijkHighscore()) {
                str += String.format("%s\n", s);
            }
            JOptionPane.showMessageDialog(null, str, "Highscores", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    static class NewGame implements ActionListener {
        public void actionPerformed(ActionEvent actionEvent) {
            Spel.leegSpelers();
            YahtzeeGUI.nieuwSpel();
        }
    }

}
