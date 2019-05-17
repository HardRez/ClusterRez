package controller;

import controller.GameController;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JToggleButton;
import model.CompareBox;

public class ButtonListener implements ActionListener {

    private int[] btnID = new int[2];
    private int[] btnValue = new int[2];
    private int count = 0;
    private int count2 = 0;
    private int sayac = 0;
    private int btnLength;
    private JToggleButton[] oyunButton;
    private JLabel puanLabel;
    private ArrayList<Integer> oyunList = new ArrayList<Integer>();
    CompareBox cmp;
    GameController gcr;

    public ButtonListener(JToggleButton[] oyunButton, ArrayList<Integer> oyunList,JLabel puanLabel) {
        this.oyunButton = oyunButton;
        this.oyunList = oyunList;
        this.btnLength = this.oyunButton.length;
        this.puanLabel=puanLabel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        cmp = new CompareBox(oyunButton, oyunList, btnID, btnValue, count);
        gcr = new GameController(count, count2, btnLength,puanLabel);

        for (int i = 0; i < oyunButton.length; i++) {

            if (oyunButton[i] == e.getSource()) {
                oyunButton[i].setText("" + oyunList.get(i));
                oyunButton[i].setEnabled(false);
                oyunButton[i].setSelected(true);
                sayac++;

                if (sayac == 3) {

                    if (sameValues()) {
                        cmp.compareFalse();
                        gcr.plusScore=gcr.plusScore+50;
                        
                    } else {
                        cmp.compareTrue();
                        gcr.minScore=gcr.minScore+20;
                    }

                    sayac = 1;
                }
                if (sayac == 1) {
                    btnID[0] = i;
                    btnValue[0] = oyunList.get(i);
                }
                if (sayac == 2) {
                    btnID[1] = i;
                    btnValue[1] = oyunList.get(i);
                }
            }
            gcr.endGame();
        }

    }

    public boolean sameValues() {
        if (btnValue[0] == btnValue[1]) {
            count++;
            
            return true;
        }
        return false;
    }
    
}
