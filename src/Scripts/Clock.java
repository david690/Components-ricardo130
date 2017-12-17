/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Scripts;

import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.accessibility.Accessible;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

/**
 *
 * @author ricardo130
 */
public class Clock extends JLabel implements SwingConstants, Accessible {

    int hour = 0, minute = 0, second = 0;
    String hh = "", mm = "", ss = "";
    Fonts.Fuentes fuente = new Fonts.Fuentes();

    public Clock() {

        GetCurrentHour();
        
        this.setFont(fuente.fuente(fuente.Consolas, fuente.Plain, this.getFont().getSize()));

        new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    while (true) {
                        second++;
                        if (second == 60) {
                            second = 0;
                            minute++;
                        }
                        if (minute == 60) {
                            minute = 0;
                            hour++;
                        }
                        if (hour == 24) {
                            second = 0;
                            minute = 0;
                            hour = 0;
                        }
                        hh = String.valueOf(hour);
                        mm = String.valueOf(minute);
                        ss = String.valueOf(second);
                        if (second < 10) {
                            ss = "0" + String.valueOf(second);
                        }
                        if (minute < 10) {
                            mm = "0" + String.valueOf(minute);
                        }
                        if (hour < 10) {
                            hh = "0" + String.valueOf(hour);
                        }
                        Clock.this.setText(String.valueOf(hh + ":" + mm + ":" + ss));
                        Thread.sleep(1000);
                    }
                } catch (InterruptedException ex) {
                    Logger.getLogger(Clock.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }).start();

    }

    private void GetCurrentHour() {
        Calendar cal = Calendar.getInstance();
        hour = cal.get(Calendar.HOUR_OF_DAY);
        minute = cal.get(Calendar.MINUTE);
        second = cal.get(Calendar.SECOND);
    }

}
