package controller;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import static java.util.Collections.shuffle;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import model.CompareBox;

public class BoxController {

    private JComboBox yerBox;
    private JToggleButton[] oyunButton;
    private JPanel oyunPanel;
    private JTextField adetText;
    private JLabel sureLabel;
    private JButton baslatButton;
    private JLabel puanLabel;
    private ArrayList<Integer> oyunList = new ArrayList<Integer>();
    private ButtonListener blr;
    static int sinir=0;
    TimeController tcr;

    public BoxController(JPanel oyunPanel, JTextField adetText, JComboBox yerBox,JLabel sureLabel,JButton baslatButton,JLabel puanLabel) {
        this.oyunPanel = oyunPanel;
        this.adetText = adetText;
        this.yerBox = yerBox;
        this.sureLabel=sureLabel;
        this.baslatButton=baslatButton;
        this.puanLabel=puanLabel;

        String str = yerBox.getSelectedItem().toString();

        if (Integer.parseInt(adetText.getText()) % 2 == 0) {
            oyunButton = new JToggleButton[Integer.parseInt(adetText.getText())];
        } else {
            oyunButton = new JToggleButton[Integer.parseInt(adetText.getText()) + 1];
        }
        for (int i = 0; i < 2; i++) {
            for (int ii = 1; ii < (oyunButton.length / 2) + 1; ii++) {
                oyunList.add(ii);
            }
        }
        shuffle(oyunList);

        blr = new ButtonListener(this.oyunButton, this.oyunList,this.puanLabel);

        for (int i = 0; i < oyunButton.length; i++) {
            oyunButton[i] = new JToggleButton("" + oyunList.get(i));
            oyunButton[i].setFont(new Font("Serif", Font.BOLD, 28));
            oyunButton[i].addActionListener(blr);

        }
        tcr=new TimeController(oyunButton,this.sureLabel,this.baslatButton);

        if (str.equals("Grid Layout")) {
            oyunPanel.setLayout(new GridLayout(2,2));
        } else {
            oyunPanel.setLayout(new FlowLayout());

        }

        for (int i = 0; i < oyunButton.length; i++) {
            if(sinir<1){
            oyunPanel.add(oyunButton[i]);    
            }
            
        }

        oyunPanel.validate();
        oyunPanel.repaint();

        /*for (int i = 0; i < 2; i++) {
            for (int ii = 1; ii < (oyunButton.length / 2) + 1; ii++) {
                oyunList.add(ii);
            }
        }
        shuffle(oyunList);*/
        sinir =1;
    }
    
    public void resetBox(){
        tcr.textSet();
    }
    
    public void timer(){
        tcr.timer();
    }
    
    
    
   
    
    
   

    
}
