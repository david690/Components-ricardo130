/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Scripts;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author ricardo130
 */
public class JPanelImage extends JPanel {

    private Icon icon;
    private final Dimension dimension = new Dimension(100, 100);
    private Image image;
    private ImageIcon ii;
    
    public JPanelImage() {
        this.setPreferredSize(dimension);
        this.setOpaque(false);
    }

    @Override
    public void paintComponent(Graphics g) {
        g.drawImage(image, 0, 0, this.getWidth(), this.getHeight(), null);
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
