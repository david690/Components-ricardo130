/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Scripts;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.JTextField;

/**
 *
 * @author ricardo130
 */
public class JTextFieldPlaceHolder extends JTextField {

    public String PlaceHolder = "Buscar...";
    private String temp = PlaceHolder;

    public String getPlaceHolder() {
        return PlaceHolder;
    }

    public void setPlaceHolder(String PlaceHolder) {
        this.PlaceHolder = PlaceHolder;
        temp = PlaceHolder;
    }

    public JTextFieldPlaceHolder() {

        this.setSize(78, 30);
        this.addFocusListener(new FocusListener() {

            @Override
            public void focusGained(FocusEvent e) {
                PlaceHolder = "";
                JTextFieldPlaceHolder.super.paintComponent(JTextFieldPlaceHolder.this.getGraphics());
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (JTextFieldPlaceHolder.this.getText().length() == 0) {
                    PlaceHolder = temp;
                    JTextFieldPlaceHolder.super.paintComponent(JTextFieldPlaceHolder.this.getGraphics());
                }
            }
        });

    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setFont(this.getFont());
        g2.drawString(PlaceHolder, 5, (this.getHeight() / 2) + 5);
    }

}
