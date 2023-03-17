package Model.Cineplex;

/**
 * Enumeration class of seat types
 */
public enum SeatType {
    SINGLE("Single Seat","[ ]"),
    COUPLE("Couple Seat","! !"),
    ELITE("Elite Single Seats","| |"),
    ULTIMA("Ultima Couple Seats","T T"),
    DIAMOND("Diamond Single Seats","( )"),
    WHEELCHAIR("Wheelchair Accessible Spot","{ }");
    
    /**
     * Name of the seat type
     */
    private final String typeName;
    
    /**
     * Icon representing the seat type
     */
    private final String icon;
    
    /**
     * Create a seat type with the seat type provided
     * @param typeName Name of the seat type
     * @param icon The icon representing the seat
     * @param size Block size of the seat type
     */
    SeatType(String typeName, String icon){
        this.typeName = typeName;
        this.icon = icon;
    }
    
    /**
     * Returns the seat type name of this seat
     * @return Name of seat type
     */
    @Override
    public String toString() {
        return typeName;
    }
    
    /**
     * Returns the seat type name of this seat
     * @return Name of seat type
     */
    public String toIcon() {
        return icon;
    }
}
