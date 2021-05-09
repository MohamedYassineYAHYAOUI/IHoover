package yanport.view;

import java.awt.*;

/**
 * interface to assemble the different components that we want to
 * draw on a panel, every component must implement this interface
 */
interface DrawingPanel {

    /**
     * draw methode for the component
     * @param g Graphics
     */
    void drawComponent(Graphics g) ;
}
