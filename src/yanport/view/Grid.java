package yanport.view;


import yanport.model.UserInput;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

/**
 * application Grid class
 */
class Grid extends JFrame {

    private final int margin;
    private final int rectWidth;
    private final int rectHeight;
    private final int columns;
    private final int lines;
    private HooverFrame hoover;
    private final Dimension dimension;

    /**
     * Grid class constructor, this constructor is private to force user to pass by the factory methode
     * @param dimension Dimension application dimensions
     * @param margin grid outer margin
     * @param rectWidth a case width
     * @param rectHeight a case height
     * @param columns number of grid columns
     * @param lines number of grid lines
     */
    private Grid(Dimension dimension, int margin, int rectWidth, int rectHeight, int columns, int lines){
        this.dimension = dimension;
        this.margin = margin;
        this.rectWidth = rectWidth;
        this.rectHeight = rectHeight;
        this.columns = columns;
        this.lines = lines;
    }

    /**
     * factory methode for the Grid class, calculate a grid's case width and height and initialize
     * the grid frame
     * @param windowName window name
     * @param dimension Dimension application dimensions
     * @param margin grid outer margin
     * @param columns number of grid columns
     * @param lines number of grid lines
     * @return an initialized Grid object
     */
    public static Grid gridFactory(Dimension dimension, String windowName, int margin, int columns, int lines){
        Objects.requireNonNull(dimension);
        Objects.requireNonNull(windowName);

        int rectWidth = (int) Math.round((dimension.getWidth()-(margin*2)) / columns);
        int rectHeight = (int) Math.round((dimension.getHeight()-(margin*2)) / lines);

        var gridFrame = new Grid(dimension, margin, rectWidth, rectHeight, columns, lines);
        gridFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        gridFrame.setPreferredSize(new Dimension(dimension.width+10, dimension.height+30));
        gridFrame.pack();
        gridFrame.setResizable(false);
        gridFrame.setVisible(true);
        return gridFrame;
    }

    /**
     * initialize the components on the grid
     * @param model model object of the application
     * @param view View object of the application
     */
    void initComponents(UserInput model, UserView view){
        var gridFrame =  new GridFrame( columns, lines, rectWidth, rectHeight, margin);
        hoover = new HooverFrame(model, rectWidth, rectHeight, dimension);
        this.add(new DrawComponents(model, view,gridFrame,hoover  ));
    }

    /**
     * dispose of the current frame
     */
    void closeFrame(){
        this.dispose();
    }

}
