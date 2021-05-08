package yanport.view;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

class GridFrame implements DrawingPanel {

    private final int columns ;
    private final int lines;
    private final Dimension dimension;
    private final int rectWidth;
    private final int rectHeight;
    private final int margin ;

    GridFrame(Dimension dimension, int columns, int lines, int rectWidth, int rectHeight, int margin){
        this.dimension = Objects.requireNonNull(dimension);
        this.columns = columns;
        this.lines = lines;
        this.rectWidth = rectWidth;
        this.rectHeight = rectHeight;
        this.margin = margin;
    }

    @Override
    public void drawComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g.create();
        for(int c=0; c <columns ; c++  ){
            int x = margin + c * rectWidth;
            for(int l=0; l < lines; l++){
                int y = margin + l*rectHeight;
                g.drawRect(x, y, rectWidth, rectHeight);
            }
        }
        g2d.dispose();
    }
}

