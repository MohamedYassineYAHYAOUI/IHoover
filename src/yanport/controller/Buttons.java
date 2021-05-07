package yanport.controller;

import yanport.model.UserInput;
import yanport.view.UserView;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;


class Launch implements ActionListener {

    private JPanel mainPanel;
    private JComboBox cardBox;
    private JSpinner posYValue, gridWidth, posXValue, gridHeight;
    private UserInput model ;
    private final UserView view;
    private JTextField instructions;

    Launch(JSpinner posYValue, JSpinner gridWidth, JSpinner posXValue, JSpinner gridHeight, JComboBox cardBox, JPanel mainPanel, JTextField instructions){
        this.cardBox =  Objects.requireNonNull(cardBox);
        this.posYValue =  Objects.requireNonNull(posYValue);
        this.gridWidth =  Objects.requireNonNull(gridWidth);
        this.posXValue =  Objects.requireNonNull(posXValue);
        this.gridHeight =  Objects.requireNonNull(gridHeight);
        this.mainPanel = Objects.requireNonNull(mainPanel);
        this.instructions = Objects.requireNonNull(instructions);
        this.view = new UserView(mainPanel);
    }

    /**
     * Invoked when an action occurs.
     *
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        try{
            model = checkUserValues();

            //userValues();
        }catch(IllegalArgumentException err){
            view.errorPopUp(err.getMessage() );
        }

    }


    private UserInput checkUserValues(){
        var y = (int) posYValue.getValue();
        var x = (int) posXValue.getValue();
        var width = (int) gridWidth.getValue();
        var height = (int) gridHeight.getValue();
        return UserInput.userModelFactory(x,y,width,height,instructions.getText());
    }

}
