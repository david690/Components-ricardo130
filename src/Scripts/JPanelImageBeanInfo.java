/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Scripts;

import java.awt.Image;
import java.beans.SimpleBeanInfo;

/**
 * 
 * @author ricardo130
 */
public class JPanelImageBeanInfo extends SimpleBeanInfo {
    Image icon16A;
    Image icon16B;
    Image icon32A;
    Image icon32B;

    public JPanelImageBeanInfo() {
        icon16A = loadImage("/Images/IconBeanInfo16.png");
        icon16B = loadImage("/Images/IconBeanInfo16.png");
        icon32A = loadImage("/Images/IconBeanInfo32.png");
        icon32B = loadImage("/Images/IconBeanInfo32.png");
    }

    @Override
    public Image getIcon(int i) {
        switch (i) {
            case 1:
                return icon16A;

            case 2:
                return icon16B;

            case 3:
                return icon32A;

            case 4:
                return icon32B;
        }
        return null;
    }
}
