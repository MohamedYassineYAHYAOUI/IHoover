package yanport.controller;

import yanport.model.Directions;
import yanport.model.UserInput;
import yanport.view.UserView;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

/**
 * Controller of the application
 * this class implements ActionListener so it can be used to perform actions from the
 * Mainframe
 */
class MainFrameController extends JFrame implements ActionListener {

    private JComboBox cardBox;
    private JSpinner posYValue, gridWidth, posXValue, gridHeight;
    private UserInput model ;
    private final UserView view;
    private JTextField instructions;
    private final HooverConfig config;

    /**
     * constructor for the application controller
     */
    MainFrameController(JSpinner posYValue, JSpinner gridWidth, JSpinner posXValue, JSpinner gridHeight, JComboBox cardBox, JPanel mainPanel, JTextField instructions, HooverConfig config){
        this.cardBox =  Objects.requireNonNull(cardBox);
        this.posXValue =  Objects.requireNonNull(posXValue);
        this.posYValue =  Objects.requireNonNull(posYValue);
        this.gridWidth =  Objects.requireNonNull(gridWidth);
        this.gridHeight =  Objects.requireNonNull(gridHeight);
        this.instructions = Objects.requireNonNull(instructions);
        this.config = Objects.requireNonNull(config);
        this.view = new UserView(mainPanel, config);

    }

    /**
     * Invoked when user click on start button
     * check if the user input is valide and initialize the application grid with
     * the hoover,
     * popup the error message in case of IAE or ISE
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        try{
            model = checkUserValues(config);
            view.initGrid(model);

        }catch(IllegalArgumentException | IllegalStateException  err){
            view.popUp(err.getMessage() );
        }
    }

    /**
     * check the user input before starting initializing the grid using the model package
     * @param config application configuration
     * @return a new model object UserInput, initialized with correct input
     */
    private UserInput checkUserValues(HooverConfig config){
        var y = (int) posYValue.getValue()-1; // initiale Y position
        var x = (int) posXValue.getValue()-1; // initiale X position
        var width = (int) gridWidth.getValue(); // number of columns
        var height = (int) gridHeight.getValue(); // number of lines
        var dir = Directions.labelToDirection((String) cardBox.getSelectedItem()); // initiale direction
        return UserInput.userModelFactory(x,y,width,height, dir, instructions.getText(), config);
    }

}
