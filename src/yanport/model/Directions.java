package yanport.model;

import java.util.Objects;

/**
 * Enum class for the different Directions
 */
public enum Directions {
    NORTH(0),
    EAST(1),
    SOUTH(2),
    WEST(3);

    private int code;

    private Directions(int code) {
        this.code = code;
    }

    /**
     * change String label on the user interface to a Directions object
     * if the label doesn't match a Direction, the methode throw an IAE
     * @param label String - to change to a Direction
     * @return Directions - a new Direction from the label
     */
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
