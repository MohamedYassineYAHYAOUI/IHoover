package yanport.controller;

import yanport.model.UserInput;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

class Launch implements ActionListener {

    private JComboBox cardBox;
    private JSpinner posYValue, gridLength, posXValue, gridWidth;
    private UserInput model ;

    Launch(JSpinner posYValue, JSpinner gridLength, JSpinner posXValue, JSpinner gridWidth, JComboBox cardBox){
        this.cardBox =  Objects.requireNonNull(cardBox);
        this.posYValue =  Objects.requireNonNull(posYValue);
        this.gridLength =  Objects.requireNonNull(gridLength);
        this.posXValue =  Objects.requireNonNull(posXValue);
        this.gridWidth =  Objects.requireNonNull(gridWidth);
    }

    /**
     * Invoked when an action occurs.
     *
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        /*try{
            checkUserValues();
        }catch(){

        }*/
        userValues();
    }


    private void userValues(){
        try{
            var y = (int) this.posYValue.getValue();
            var x = (int) this.posYValue.getValue();
            var length = (int) this.gridLength.getValue();
            var width = (int) this.gridWidth.getValue();
            model = new UserInput(x, y, length, width);
        }catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }
}
