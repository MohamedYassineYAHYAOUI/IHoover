package yanport.view;

import yanport.model.Directions;
import yanport.model.UserInput;

import javax.swing.*;
import java.awt.*;

class HooverFrame implements DrawingPanel {

    private final int rectWidth ,rectHeight;
    private final Dimension dim;
    private final UserInput model;


    HooverFrame(UserInput model, int rectWidth, int rectHeight, Dimension dimension){
        this.model = model;
        this.rectWidth = rectWidth;
        this.rectHeight = rectHeight;
        this.dim = dimension;

    }

    private void drawDirection(Graphics g, int posX, int posY){
        switch (model.getCurrentdir()){
            case NORTH :
                g.fillOval(posX + rectWidth/2, posY + 5, rectWidth/10,  rectHeight/10 );
                break;
            case SOUTH:
                g.fillOval(posX + rectWidth/2 - 5, posY + rectHeight - 10, rectWidth/10,  rectHeight/10 );
                break;
            case WEST:
                g.fillOval(posX + 5, posY + rectHeight/2 , rectWidth/10,  rectHeight/10 );
                break;
            case EAST:
                g.fillOval(posX + rectWidth - 5, posY + rectHeight/2 , rectWidth/10,  rectHeight/10 );
                break;
            default:
                return;
        }
    }

    @Override
    public void drawComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g.create();
        int posX = model.getX()*rectWidth  ;
        int posY = dim.height - model.getY()*rectHeight - rectHeight ;
        g.setColor(Color.DARK_GRAY);
        g.fillOval(posX+3, posY+3,rectWidth-3, rectHeight-3 );
        g.setColor(Color.CYAN);
        drawDirection(g, posX, posY);
        g2d.dispose();
    }
}
