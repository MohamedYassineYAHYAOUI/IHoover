package yanport.model;

import yanport.controller.HooverConfig;

import java.util.Objects;
import java.util.regex.Pattern;


/**
 * Model class with the responsibility to check the user input
 * keep track and change the current position in th grid
 */
public class UserInput {
    private final String instructions;
    private final Movements hooverMovements;
    private int index =0; // current index on the instructions string = current instruction

    private boolean finished;

    /**
     * constructor for the class UserInput
     * this constructor is private so we force the user to pass by the factory methode userModelFactory
     * @param movements movements object for the Hoover movements on the grid
     * @param instructions the instructions given by the user, must be valide instruction
     */
    private UserInput(Movements movements, String instructions){
        this.hooverMovements = movements;
        this.instructions = instructions;
    }

    /**
     * factory methode for the class UserInput, check if the different user inputs are valide, if so create a new
     * UserInput object, else throw an IAE
     * @param x initial x positon
     * @param y initial y positon
     * @param width grid width
     * @param height grid height
     * @param direction initial hoover direction
     * @param input user instructions
     * @param config application config
     * @return a new UserInput object with the initial inputs data
     */
    public static UserInput userModelFactory(int x, int y, int width, int height, Directions direction, String input, HooverConfig config){
        if(x < 0){ throw new IllegalArgumentException("X value must be between 1 and width "); }
        if(x >= width){throw new IllegalArgumentException("X value be less then grid width ");}
        if(y < 0){throw new IllegalArgumentException("Y value must  between and height value");}
        if(y>=height){throw new IllegalArgumentException("Y value must be less then grid height"); }
        if(!Pattern.matches("[ADG]+", input) ) {throw new IllegalArgumentException("input instructions are not valide"); }
        return new UserInput( new Movements(x, y, direction, width, height, Objects.requireNonNull(config)), Objects.requireNonNull(input));
    }

    /**
     * getter for the grid width
     * @return grid width
     */
    public int getGridWidth(){
        return hooverMovements.getWidth();
    }
    /**
     * getter for the grid height
     * @return grid height
     */
    public int getGridHeight(){
        return hooverMovements.getHeight();
    }

    /**
     * getter for the current hoover direction
     * @return current hoover direction
     */
    public Directions getCurrentDir(){ return hooverMovements.getDir();}

    /**
     * getter for the current x position
     * @return current x position
     */
    public int getX(){ return hooverMovements.getX();}

    /**
     * getter for the current y position
     * @return current y position
     */
    public int getY(){return hooverMovements.getY();}

    /**
     * @return true if the current grid finished the instruction, else false
     */
    public boolean finishedInstruction(){ return finished;}

    /**
     * parse the user instructions, and call the appropriate methode for the next action
     * this methode assume that the instructions are valide, the verification is done in the factory methode
     */
    public void moveHoover(){

        if (index >= instructions.length()) {
            finished = true;
            return;
        }
        switch (instructions.charAt(index)){
            case 'A':
                hooverMovements.advance();
                break;
            case 'D':
                hooverMovements.turnRight();
                break;
            case 'G':
                hooverMovements.turnLeft();
                break;
            default:
                throw new IllegalArgumentException("Illegal instruction");
        }
        index++;
    }


}
