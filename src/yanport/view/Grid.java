package yanport.view;

import yanport.controller.IHoover;
import yanport.model.Directions;
import yanport.model.UserInput;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

import java.util.logging.Logger;

class Grid extends JFrame {

    static private final Logger logger = Logger.getLogger(Grid.class.getName());
    private boolean running;
    private final int margin;
    private final int rectWidth;
    private final int rectHeight;
    private final int columns;
    private final int lines;
    private HooverFrame hoover;
    private final Dimension dimension;
   // private final JPanel drawingFrame;

    private Grid(Dimension dimension, int margin, int rectWidth, int rectHeight, int columns, int lines){
        this.running = true;
        this.dimension = dimension;
        this.margin = margin;
        this.rectWidth = rectWidth;
        this.rectHeight = rectHeight;
        this.columns = columns;
        this.lines = lines;
    }

    public static Grid gridFactory(Dimension dimension, String windowName, int margin, int columns, int lines){
        Objects.requireNonNull(dimension);
        Objects.requireNonNull(windowName);

        int rectWidth = (int) Math.round((dimension.getWidth()-(margin*2)) / columns);
        int rectHeight = (int) Math.round((dimension.getHeight()-(margin*2)) / lines);

        var gridFrame = new Grid(dimension, margin, rectWidth, rectHeight, columns, lines);
        gridFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        gridFrame.setPreferredSize(new Dimension(dimension.width+10, dimension.height+30));
        gridFrame.pack();
        //gridFrame.add(drawingFrame);
        gridFrame.setResizable(false);
        gridFrame.setVisible(true);
        return gridFrame;
    }


    void initComponents(UserInput model){
        var gridFrame =  new GridFrame(dimension, columns, lines, rectWidth, rectHeight, margin);
        hoover = new HooverFrame(model, rectWidth, rectHeight, dimension);
        this.add(new DrawComponents(model, gridFrame,hoover  ));
    }

    void closeFrame(){
        if(running){
            throw new IllegalStateException("Closed active Frame");
        }
        this.dispose();
        logger.info("closing Frame");
    }

    boolean isRunning(){
        return running;
    }





}
