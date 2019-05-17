package controller;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JToggleButton;
import javax.swing.Timer;

public class TimeController {

    private JToggleButton[] oyunButton;
    private JButton baslatButton;
    private JLabel sureLabel;

    private Timer timer = null;

    int saniye, dakika, saat;

    public TimeController(JToggleButton[] oyunButton, JLabel sureLabel,JButton baslatButton) {
        this.oyunButton = oyunButton;
        this.sureLabel = sureLabel;
        this.baslatButton=baslatButton;
    }

    public void textSet() {
        for (int i = 0; i < oyunButton.length; i++) {
            oyunButton[i].setText("     ");
        }
    }

    public void timer() {
        baslatButton.setEnabled(false);
        timer = new Timer(1000, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                /// sureLabel.setText("0"+saat+"0"+dakika+"0"+saniye);

                saniye++;

                if (saniye == 60) {
                    saniye = 0;
                    dakika++;
                } else if (dakika == 60) {
                    dakika = 0;
                    saat++;
                }

                if (dakika >= 10) {
                    if (saniye >= 10) {
                        sureLabel.setText("0" + saat + ":" + dakika + ":" + saniye);
                    } else {
                        sureLabel.setText("0" + saat + ":" + dakika + ":0" + saniye);
                    }
                } else {
                    if (saniye >= 10) {
                        sureLabel.setText("0" + saat + ":0" + dakika + ":" + saniye);
                    } else {
                        sureLabel.setText("0" + saat + ":0" + dakika + ":0" + saniye);
                    }
                }

                if (GameController.x == 1) {
                    saniye--;
                    if (saniye >= 10) {
                        sureLabel.setText("0" + saat + ":0" + dakika + ":" + saniye);
                    } else {
                        sureLabel.setText("0" + saat + ":0" + dakika + ":0" + saniye);
                    }
                    timer.stop();
                }
            }

        });
        timer.start();

    }
}
