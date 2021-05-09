package yanport.model;

import yanport.controller.HooverConfig;

/***
 * Movements class to determine the next possible movement / direction for
 * the user
 */
class Movements {

    private int x, y; // curent position of the user
    private final int width, height; // columns and lines of the grid
    private final HooverConfig config; //application config
    private Directions direction; // curent direction of the player

    /**
     * Constructor for the class Movements,
     * @param x int x position
     * @param y int y position
     * @param direction Directions current position
     * @param width int grid width
     * @param height int grid height
     * @param config HooverConfig application config
     */
    Movements(int x, int y, Directions direction ,int width, int height, HooverConfig config){
        this.config = config;
        this.x = x;
        this.y =y;
        this.width = width;
        this.height = height;
        this.direction = direction;
    }

    /**
     * main methode for the movement of the hoover,
     * the next position depends on the current direction and the placement in the grid :
     * if the Hoover is next to a grid limit and facing towards it, this methode doesn't change the current position
     * else advance toward the direction with 1 case
     */
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
            default -> throw new IllegalStateException("unknown direction");
        }
    }

    /**
     * turn the Hoover to the right with 90° angle without changing the current position
     * the new direction depends on the current Hoover direction
     */
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
            default -> throw new IllegalStateException("unknown direction");
        }
    }

    /**
     * turn the Hoover to the left with 90° angle without changing the current position
     * the new direction depends on the current Hoover direction
     */
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
            default -> throw new IllegalStateException("unknown direction");
        }
    }

    /**
     * getter for the grid width
     * @return int grid width
     */
    int getWidth(){
        return width;
    }

    /**
     * getter for the grid height
     * @return int grid height
     */
    int getHeight(){
        return height;
    }

    /**
     * getter fir the current direction
     * @return Directions current user direction
     */
    Directions getDir(){
        return direction;
    }

    /**
     * getter for the x position
     * @return int current x position
     */
    int getX() {return x;}

    /**
     * getter for the y position
     * @return int current y position
     */
    int getY() { return y;}
}

