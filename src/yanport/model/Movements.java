package yanport.model;

import yanport.controller.HooverConfig;

class Movements {

    private int x, y;
    private final int width, height;
    private final HooverConfig config;
    private Directions direction;


    Movements(int x, int y, Directions direction ,int width, int height, HooverConfig config){
        this.config = config;
        this.x = x;
        this.y =y;
        this.width = width;
        this.height = height;
        this.direction = direction;
    }

    void advance(){
        switch (direction){
            case NORTH -> {
                if (y+1 < height) y++;
                break;
            }
            case EAST -> {
                if (x+1 < width) x++;
                break;
            }
            case WEST -> {
                if (x > 0) x--;
                break;
            }
            case SOUTH ->{
                if (y > 0) y--;
                break;
            }
        }
    }

    void turnRight(){
        switch (direction){
            case NORTH -> {
                direction = Directions.EAST;
                break;
            }
            case EAST -> {
                direction = Directions.SOUTH;
                break;
            }
            case WEST -> {
                direction = Directions.NORTH;
                break;
            }
            case SOUTH ->{
                direction = Directions.WEST;
                break;
            }
        }
    }

    void turnLeft(){
        switch (direction){
            case NORTH -> {
                direction = Directions.WEST;
                break;
            }
            case EAST -> {
                direction = Directions.NORTH;
                break;
            }
            case WEST -> {
                direction = Directions.SOUTH;
                break;
            }
            case SOUTH ->{
                direction = Directions.EAST;
                break;
            }
        }
    }

    int getWidth(){
        return width;
    }
    int getHeight(){
        return height;
    }

    Directions getDir(){
        return direction;
    }

    int getX() {return x;}

    int getY() { return y;}
}

