package yanport.view;

import yanport.model.UserInput;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

class DrawComponents extends JPanel {

    private final List<DrawingPanel> components;

    DrawComponents(UserInput model, DrawingPanel... drawables){
        components = new ArrayList<>();
        for (var drawable:drawables ) {
            components.add(drawable);
        }
        Timer timer = new Timer(1000, new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                model.moveHoover();
                repaint();
            }
        });
        timer.start();
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (var component : components) {
            component.drawComponent(g);
        }
    }

}
