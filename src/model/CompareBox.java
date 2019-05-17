package model;

import controller.ButtonListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JToggleButton;

public class CompareBox extends JToggleButton {

    private int[] btnID = new int[2];
    private int[] btnValue = new int[2];
    private int count;
    

    private JToggleButton[] oyunButton;
    private ArrayList<Integer> oyunList = new ArrayList<Integer>();

    public CompareBox(JToggleButton[] oyunButton, ArrayList<Integer> oyunList, int[] btnID,int[] btnValue,int count) {
        this.oyunButton = oyunButton;
        this.oyunList = oyunList;
        this.btnID = btnID;
        this.btnValue=btnValue;
        this.count=count;
    }

    public void compareFalse() {
        oyunButton[btnID[0]].setEnabled(false);
        oyunButton[btnID[1]].setEnabled(false);
        oyunButton[btnID[0]].setSelected(false);
        oyunButton[btnID[1]].setSelected(false);

    }

    public void compareTrue() {
        oyunButton[btnID[0]].setEnabled(true);
        oyunButton[btnID[0]].setText("      ");
        oyunButton[btnID[1]].setEnabled(true);
        oyunButton[btnID[1]].setText("      ");
        oyunButton[btnID[0]].setSelected(false);
        oyunButton[btnID[1]].setSelected(false);
    }

   /*public boolean sameValues() {
        if (btnValue[0] == btnValue[1]) {
            count++;
            return true;
        }
        return false;
    }*/

}
