/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Scripts;

import java.util.Calendar;
import javax.swing.JLabel;

/**
 *
 * @author ricardo130
 */
public class Clock extends JLabel {

    int hour = 0, minute = 0, second = 0;
    String hh = "", mm = "", ss = "";
    Fonts.Fuentes fuente = new Fonts.Fuentes();

    public Clock() {
        
        Clock.this.setFont(fuente.fuente(fuente.Consolas, fuente.Plain, Clock.this.getFont().getSize()));

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while (true) {
                        GetCurrentHour();
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
