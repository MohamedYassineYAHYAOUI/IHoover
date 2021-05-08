package yanport.model;

import yanport.controller.HooverConfig;

import java.util.Objects;
import java.util.regex.Pattern;

public class UserInput {


    private final String instructions;
    private final Movements hooverMovements;
    private int index =0;

    private boolean finished;

    private UserInput(Movements movements, String instructions){
        this.hooverMovements = movements;
        this.instructions = instructions;
    }

    public static UserInput userModelFactory(int x, int y, int width, int height, Directions direction, String input, HooverConfig config){
        if(x < 0){ throw new IllegalArgumentException("X value must be between 1 and width "); }
        if(x >= width){throw new IllegalArgumentException("X value be less then grid width ");}
        if(y < 0){throw new IllegalArgumentException("Y value must  between and height value");}
        if(y>=height){throw new IllegalArgumentException("Y value must be less then grid height"); }
        if(!Pattern.matches("[ADG]+", input) ) {throw new IllegalArgumentException("input instructions are not valide");
        }
        return new UserInput( new Movements(x, y, direction, width, height, Objects.requireNonNull(config)), Objects.requireNonNull(input));
    }

    public int getGridWidth(){
        return hooverMovements.getWidth();
    }

    public int getGridHeight(){
        return hooverMovements.getHeight();
    }

    public Directions getCurrentdir(){return hooverMovements.getDir();}

    public int getX(){return hooverMovements.getX(); }

    public int getY(){ return hooverMovements.getY();}

    public boolean finishedInstruction(){return finished; }

    public void moveHoover(){
        if( index >= instructions.length()){
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
