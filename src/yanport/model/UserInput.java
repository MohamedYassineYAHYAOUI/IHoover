package yanport.model;

public class UserInput {

    private final int x, y, length, width;

    public UserInput(int x, int y, int length, int width){

       if( (x < 0 || x >= width) || (y < 0 || y >= length)){
            throw new IllegalArgumentException("User Input not valide");
       }
        this.x = x;
        this.y = y;
        this.length = length;
        this.width = width;
    }




}
