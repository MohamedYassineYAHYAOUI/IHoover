package yanport.view;

import yanport.controller.HooverConfig;
import yanport.model.UserInput;

import javax.swing.*;
import java.util.Objects;

public class UserView {

    private final JPanel panel;
    private final HooverConfig config;
    private Grid grid;
    private UserInput model;

    public UserView(JPanel mainPanel, HooverConfig config){
        this.panel = Objects.requireNonNull(mainPanel);
        this.config = Objects.requireNonNull(config);
    }


    public void errorPopUp(String err){
        JOptionPane.showMessageDialog(panel, err);
    }

    public void initGrid(UserInput model){
        Objects.requireNonNull(model);
        this.model = model;
        if(grid != null && grid.isRunning()){
            throw new IllegalStateException("a grid is already active");
        }else if(grid != null){
            grid.closeFrame();
        }
        grid = Grid.gridFactory(config.getAppDimension(), config.getAppName(), config.gridMargin(), model.getGridWidth(), model.getGridHeight());
        grid.initComponents(model);
    }



}
