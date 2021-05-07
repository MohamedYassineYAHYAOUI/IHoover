package yanport.model;

import java.util.Objects;

public class UserInput {

    private final int x, y, width, height;
    private final String instructions;

    private UserInput(int x, int y, int width, int height, String instructions){
        this.x = x;
        this.y = y;
        this.height = height;
        this.width = width;
        this.instructions = instructions;
    }

    public static UserInput userModelFactory(int x, int y, int width, int height, String input){
        if(x < 0){ throw new IllegalArgumentException("X value must be positive "); }
        if(x >= width){throw new IllegalArgumentException("X value be less then grid width ");}
        if(y < 0){throw new IllegalArgumentException("Y value must be positive");}
        if(y>=height){throw new IllegalArgumentException("Y value must be less then grid height"); }
        return new UserInput(x,y,width, height, Objects.requireNonNull(input));
    }



}
