/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Scripts;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JTextField;

/**
 *
 * @author ricardo130
 */
public class JTextFieldPlaceHolder2 extends JTextField {

    public String PlaceHolder = "Buscar...";
    private String temp = PlaceHolder;

    public String getPlaceHolder() {
        return PlaceHolder;
    }

    public void setPlaceHolder(String PlaceHolder) {
        this.PlaceHolder = PlaceHolder;
    }

    public JTextFieldPlaceHolder2() {
        this.setSize(78, 30);

        this.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (JTextFieldPlaceHolder2.this.getText().length() - 1 <= 0) {
                    PlaceHolder = temp;
                    JTextFieldPlaceHolder2.super.paintComponent(JTextFieldPlaceHolder2.this.getGraphics());
                }
                if (JTextFieldPlaceHolder2.this.getText().length() + 1 > 0) {
                    PlaceHolder = "";
                    JTextFieldPlaceHolder2.super.paintComponent(JTextFieldPlaceHolder2.this.getGraphics());
                }
                System.out.println(JTextFieldPlaceHolder2.this.getText().length());
            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {

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
