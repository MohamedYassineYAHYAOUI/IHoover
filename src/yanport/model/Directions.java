package yanport.model;

import java.util.Objects;

public enum Directions {
    NORTH(0),
    EAST(1),
    SOUTH(2),
    WEST(3);

    private int code;

    private Directions(int code) {
        this.code = code;
    }

    public static Directions labelToDirection(String label){
        Objects.requireNonNull(label);
        switch (label){
            case "North (N)" :
                return NORTH;
            case "South (S)":
                return SOUTH;
            case "East  (E)":
                return EAST;
            case "West  (W)":
                return WEST;
            default:
                throw new IllegalArgumentException("label "+label+" is not a valide direction");
        }
    }

}
