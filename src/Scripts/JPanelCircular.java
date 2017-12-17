/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Scripts;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.border.AbstractBorder;

/**
 *
 * @author ricardo130
 */
public class JPanelCircular extends JPanel {

    private Icon icon;
    private final Dimension dimension = new Dimension(100, 100);
    private Shape shape;
    private Image image;
    private ImageIcon ii;
    private AbstractBorder circleBorder = new JPanelCircularBorder();

    public JPanelCircular() {
        this.setSize(dimension);
        this.setBorder(circleBorder);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, this.getWidth(), this.getHeight(), null);
    }

    @Override
    public boolean contains(int x, int y) {
        if (shape == null || !shape.getBounds().equals(getBounds())) {
            shape = new Ellipse2D.Float(0, 0, getWidth(), getHeight());
        }
        return shape.contains(x, y);
    }

    public Icon getIcon() {
        return icon;
    }

    public void setIcon(Icon icon) {
        this.icon = icon;
        ii = (ImageIcon) icon;
        image = ii.getImage();
    }

}
