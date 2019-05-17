package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JToggleButton;
import javax.swing.Timer;

public class GameController {

    private int count;
    private int count2;
    private int btnLength;
    public static int x;
    public static int plusScore=50;
    public static int minScore=0;
    private JLabel puanLabel;

    int saniye, dakika, saat;

    public GameController(int count, int count2, int btnLength,JLabel puanLabel) {
        this.count = count;
        this.count2 = count2;
        this.btnLength = btnLength;
        this.puanLabel=puanLabel;
    }

    public void endGame() {        //A V E N G E R S
        if (count + 1 == (btnLength / 2)) {
            count2++;
        }
        if (count2 == 2) {
            x = 1;
            JOptionPane.showMessageDialog(null, "Oyun Bitti");
            int topScore=(plusScore-minScore)*btnLength;
            puanLabel.setText(Integer.toString(topScore));

        }
    }

}
