package yanport.view;

import javax.swing.*;
import java.util.Objects;

public class UserView {

    private final JPanel panel;
    private final Grid grid;

    public UserView(JPanel mainPanel){

        this.panel = Objects.requireNonNull(mainPanel);
        this.grid = new Grid();
    }


    public void errorPopUp(String err){
        JOptionPane.showMessageDialog(panel, err);
    }
}
