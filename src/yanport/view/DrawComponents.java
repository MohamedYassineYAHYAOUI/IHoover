package yanport.view;

import yanport.model.UserInput;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * JPanel extension class that draws the different component on the panel
 */
class DrawComponents extends JPanel {

    private final List<DrawingPanel> components; // different components on the panel

    /**
     * constructor of the DrawComponents class
     * @param model UserInput model object of the application
     * @param view UserView view object of the application
     * @param drawables VARARGS the different DrawingPanels to draw
     */
    DrawComponents(UserInput model, UserView view, DrawingPanel... drawables){
        components = new ArrayList<>();
        for (var drawable:drawables ) {
            components.add(drawable);
        }
        // launch a timer that refresh the panel,
        var timer = new Timer(1000, (event) -> {
            model.moveHoover();
            repaint();
            if(model.finishedInstruction()){ // check if the grid finished the instruction
                view.popUp("Finished :\nx=" + model.getX() + " y=" + model.getY() + " Direction=" + model.getCurrentDir()); // pop up message for the user
                ((Timer)event.getSource()).stop(); // stop the timer
            }
        });
        timer.start();
    }

    /**
     * call the paint methode for the different components to refresh the panel
     * @param g Graphics
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (var component : components) {
            component.drawComponent(g);
        }
    }

}
