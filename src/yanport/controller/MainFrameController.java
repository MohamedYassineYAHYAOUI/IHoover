package yanport.controller;

import yanport.model.Directions;
import yanport.model.UserInput;
import yanport.view.UserView;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;


class MainFrameController extends JFrame implements ActionListener {

    private JPanel mainPanel;
    private JComboBox cardBox;
    private JSpinner posYValue, gridWidth, posXValue, gridHeight;
    private UserInput model ;
    private final UserView view;
    private JTextField instructions;
    private final HooverConfig config;


    MainFrameController(JSpinner posYValue, JSpinner gridWidth, JSpinner posXValue, JSpinner gridHeight, JComboBox cardBox, JPanel mainPanel, JTextField instructions, HooverConfig config){
        this.cardBox =  Objects.requireNonNull(cardBox);
        this.posXValue =  Objects.requireNonNull(posXValue);
        this.posYValue =  Objects.requireNonNull(posYValue);
        this.gridWidth =  Objects.requireNonNull(gridWidth);
        this.gridHeight =  Objects.requireNonNull(gridHeight);
        this.mainPanel = Objects.requireNonNull(mainPanel);
        this.instructions = Objects.requireNonNull(instructions);
        this.config = Objects.requireNonNull(config);
        this.view = new UserView(mainPanel, config);

    }

    /**
     * Invoked when an action occurs.
     *
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        try{
            model = checkUserValues(config);
            view.initGrid(model);
        }catch(IllegalArgumentException | IllegalStateException  err){
            view.errorPopUp(err.getMessage() );
        }
    }

    private UserInput checkUserValues(HooverConfig config){
        var y = (int) posYValue.getValue()-1;
        var x = (int) posXValue.getValue()-1;
        var width = (int) gridWidth.getValue();
        var height = (int) gridHeight.getValue();
        var dir = Directions.labelToDirection((String) cardBox.getSelectedItem());
        return UserInput.userModelFactory(x,y,width,height, dir, instructions.getText(), config);
    }

}
