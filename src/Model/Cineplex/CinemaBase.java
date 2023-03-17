package Model.Cineplex;

/**
 * Enumeration class of Cinema types
 */
public enum CinemaBase {
    DIAMOND("A small cinema with only Diamond suite seats"),
    LARGE("Large Cinema with a variety of seats"),
    MEDIUM("Medium Cinema with normal single and couple seats"),
    SMALL("Small Cinema with normal single seats"),
    CUSTOM("A Cinema with a auto-generated format");
    
    /**
     * Descriptor for the cinema base
     */
    private String cinemaTypeDescriptor;
    
    /**
     * Create a Cinema type with the type provided
     * @param cinemaTypeDescriptor Name of the cinema base
     */
    private CinemaBase(String cinemaTypeDescriptor){
        this.cinemaTypeDescriptor = cinemaTypeDescriptor;  
    }
    
    
    
    /**
     * Identify the Cinema base and generate the corresponding
     * seating format
     * @param cinema The cinema object containing all arguments required to
     * generate the format
     * @return A base seating format object
     */
    public static SeatFormat generateformat(Cinema cinema) {
        SeatRowType[] tempComposition;
        switch(cinema.baseType.toString()) {
            case "DIAMOND":
                tempComposition = new SeatRowType[]{
                    SeatRowType.DIAMOND,
                    SeatRowType.DIAMOND,
                    SeatRowType.DIAMOND,
                    SeatRowType.DIAMOND,
                    SeatRowType.DIAMOND,
                    SeatRowType.DIAMOND
                };
                return new SeatFormat(9,1,tempComposition);
            
            case "LARGE":
                tempComposition = new SeatRowType[]{
                    SeatRowType.ULTIMAS,
                    SeatRowType.ELITES,
                    SeatRowType.ELITES,
                    SeatRowType.BLANKS,
                    SeatRowType.COUPLES,
                    SeatRowType.COUPLES,
                    SeatRowType.SINGLES,
                    SeatRowType.SINGLES,
                    SeatRowType.SINGLES,
                    SeatRowType.SINGLES,
                    SeatRowType.SINGLES
                };
                return new SeatFormat(35,2,tempComposition);
                
            case "MEDIUM":
                tempComposition = new SeatRowType[]{
                    SeatRowType.COUPLES,
                    SeatRowType.COUPLES,
                    SeatRowType.COUPLES,
                    SeatRowType.BLANKS,
                    SeatRowType.SINGLES,
                    SeatRowType.SINGLES,
                    SeatRowType.SINGLES,
                    SeatRowType.SINGLES,
                    SeatRowType.SINGLES
                };
                return new SeatFormat(20,1,tempComposition);
                
            case "SMALL":
                tempComposition = new SeatRowType[]{
                    SeatRowType.SINGLES,
                    SeatRowType.SINGLES,
                    SeatRowType.SINGLES,
                    SeatRowType.SINGLES,
                    SeatRowType.SINGLES
                };
                return new SeatFormat(11,1,tempComposition);
            default:
                 tempComposition = new SeatRowType[]{
                    SeatRowType.SINGLES,
                    SeatRowType.SINGLES,
                    SeatRowType.SINGLES,
                    SeatRowType.SINGLES,
                    SeatRowType.SINGLES
                };
                return new SeatFormat(11,1,tempComposition);
        }
    }
}
