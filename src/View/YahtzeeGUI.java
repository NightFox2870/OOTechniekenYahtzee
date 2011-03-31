package View;


import Model.*;

import javax.swing.*;
import java.awt.*;

/**
 * Created by: Yarrith Devos
 * Date: 04-mar-2011
 * Time: 23:14:00
 */
public class YahtzeeGUI extends JFrame {
    private JButton newGame;
    private JButton highScore;
    private JButton quit;
    private static JList playerList;
    private static JList playerScore;
    private JList scoreNamen;
    private static JList scores;
    private static JComboBox inTeVullen;
    private JButton vulIn;
    private static JButton dice1;
    private static JButton dice2;
    private static JButton dice3;
    private static JButton dice4;
    private static JButton dice5;
    private static JButton roll;

    public YahtzeeGUI() {
        super();
        maakComponenten();
        trySystemLookAndFeel();
        setLayout();
        initializeFrame();
        addEvents();
        toonFrame();
    }

    private void maakComponenten() {
        //tijdelijke inhoud
        String[] ps = {"<Hier komt de totale score per speler op dat moment>"};
        String[] sc = {"<Hier komt de score per onderdeel van actieve speler>"};

        newGame = new JButton("New Game");
        highScore = new JButton("Highscore");
        quit = new JButton("Quit");
        playerList = new JList();
        //playerList.setEnabled(false);
        playerScore = new JList(ps);
        //playerScore.setEnabled(false);
        scoreNamen = new JList(Score.getScorenamenJC());
        //scoreNamen.setEnabled(false);
        scores = new JList(sc);
        //scores.setEnabled(false);
        inTeVullen = new JComboBox(Score.getScorenamen());
        vulIn = new JButton("Vul In");
        dice1 = new JButton("Zet vast");
        dice2 = new JButton("Zet vast");
        dice3 = new JButton("Zet vast");
        dice4 = new JButton("Zet vast");
        dice5 = new JButton("Zet vast");
        roll = new JButton("Roll");
    }

    private void setLayout() {
        JPanel leftPanel = new JPanel();
        JPanel middlePanel = new JPanel();
        JPanel rightPanel = new JPanel();
        JPanel bottomPanel = new JPanel();
        Container container = this.getContentPane();
        container.setLayout(new BorderLayout());
        container.add(leftPanel, BorderLayout.WEST);
        container.add(middlePanel, BorderLayout.CENTER);
        container.add(rightPanel, BorderLayout.EAST);
        container.add(bottomPanel, BorderLayout.SOUTH);
        leftPanel.setLayout(new GridLayout(3, 1, 10, 10));
        middlePanel.setLayout(new GridLayout(2, 2, 10, 10));
        rightPanel.setLayout(new GridLayout(6, 1, 10, 10));
        bottomPanel.setLayout(new GridLayout(1, 2, 10, 10));
        leftPanel.add(newGame);
        leftPanel.add(highScore);
        leftPanel.add(quit);
        middlePanel.add(playerList);
        middlePanel.add(playerScore);
        middlePanel.add(scoreNamen);
        middlePanel.add(scores);
        bottomPanel.add(inTeVullen);
        bottomPanel.add(vulIn);
        rightPanel.add(dice1);
        rightPanel.add(dice2);
        rightPanel.add(dice3);
        rightPanel.add(dice4);
        rightPanel.add(dice5);
        rightPanel.add(roll);
    }

    public static void refreshButtonImages() {
        dice1.setIcon(Worp.getImageDobbelsteen(0));
        dice2.setIcon(Worp.getImageDobbelsteen(1));
        dice3.setIcon(Worp.getImageDobbelsteen(2));
        dice4.setIcon(Worp.getImageDobbelsteen(3));
        dice5.setIcon(Worp.getImageDobbelsteen(4));
    }

    private void addEvents() {
        roll.addActionListener(new YahtzeeEventHandlers.WerpButton());
        quit.addActionListener(new YahtzeeEventHandlers.QuitButton());
        dice1.addActionListener(new YahtzeeEventHandlers.ZetVast1());
        dice2.addActionListener(new YahtzeeEventHandlers.ZetVast2());
        dice3.addActionListener(new YahtzeeEventHandlers.ZetVast3());
        dice4.addActionListener(new YahtzeeEventHandlers.ZetVast4());
        dice5.addActionListener(new YahtzeeEventHandlers.ZetVast5());
        vulIn.addActionListener(new YahtzeeEventHandlers.VulScoreIn());
        highScore.addActionListener(new YahtzeeEventHandlers.HighScore());
        newGame.addActionListener(new YahtzeeEventHandlers.NewGame());
    }

    private void initializeFrame() {   // Voorlopig gewoon random dobbelsteenwaarden toevoegen
        nieuwSpel();
    	playerList.setListData(Spel.getSpelerArray());
        Spel.changeActivePlayer();
        Ronde.Werp();
        refreshButtonImages();
    }

    private void trySystemLookAndFeel() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
    }

    private void toonFrame() {
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void setScoreListData(String[] data) {
        scores.setListData(data);
    }

    public static void setPlayerListData (String[] data) {
        playerScore.setListData(data);
    }
    
    public static void makePlayerActive (String[] data) {
    	playerList.setListData(data);
    }

    public static JComboBox getinTeVullen() {
        return inTeVullen;
    }
    
    public static JButton getWerp() {
    	return roll;
    }
    
    public static void nieuwSpel() {
    	String spelers = JOptionPane.showInputDialog("Hoeveel spelers spelen mee?");
        int aantalSpelers = 0;
        try {
            aantalSpelers = Integer.decode(spelers);
        } catch (NullPointerException e) {
            System.exit(0);
        } catch (NumberFormatException e) {
            spelers = JOptionPane.showInputDialog("Gelieve alleen cijfers in te geven, hoeveel spelers spelen er mee?");
            try {
                aantalSpelers = Integer.decode(spelers);
            } catch (NullPointerException ex) {
                System.exit(0);
            }
            catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Gelieve alleen cijfers in te geven, herstart de applicatie", "Alleen cijfers", JOptionPane.WARNING_MESSAGE);
                System.exit(1);
            }
        }
        for (int i = 0; i < aantalSpelers; i++) {
            Spel.voegSpelerToe(JOptionPane.showInputDialog("Geef de naam van speler " + (i + 1)));
        }
    }
}