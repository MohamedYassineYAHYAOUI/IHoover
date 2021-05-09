package yanport.view;

import yanport.controller.HooverConfig;
import yanport.model.UserInput;

import javax.swing.*;
import java.util.Objects;

/**
 * userView object class
 */
public class UserView {

    private final JPanel panel;
    private final HooverConfig config;
    private Grid grid;
    private UserInput model;

    /**
     * constructor for the UserView application
     * @param mainPanel panel for the main window
     * @param config application config
     */
    public UserView(JPanel mainPanel, HooverConfig config){
        this.panel = Objects.requireNonNull(mainPanel);
        this.config = Objects.requireNonNull(config);
    }

    /**
     * pop up message
     * @param msg message in the popup
     */
    public void popUp(String msg){
        JOptionPane.showMessageDialog(panel, msg);
    }

    /**
     * initialize the grid and initialize components of the grid
     * @param model model object
     */
    public void initGrid(UserInput model){
        Objects.requireNonNull(model);
        this.model = model;
        if(model.finishedInstruction() ){
            throw new IllegalStateException("a grid is already active");
        }else if (grid != null){
            grid.closeFrame();
        }
        grid = Grid.gridFactory(config.getAppDimension(), config.getAppName(), config.gridMargin(), model.getGridWidth(), model.getGridHeight());
        grid.initComponents(model, this);
    }



}
