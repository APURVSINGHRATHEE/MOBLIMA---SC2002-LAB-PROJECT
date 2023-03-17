package Model.Cineplex;

import Helpful.Body;
import java.util.Hashtable;

/**
 * Class that represents a Cinema in a Cineplex
 */
public class Cinema extends Body{
    
    private static final long serialVersionUID = 12324134119L;
    
    /**
     * Seating format of the cinema
     */
    protected SeatFormat seatformat;
    
    /**
     * Type of cinema; used to generate the base seating format
     */
    protected CinemaBase baseType;
    
    /**
     * Rows composition of the cinema seating format
     */
    protected SeatRowType[] rowComposition;
    
    /**
     * Cinema Code of this Cinema
     */
    private String cinemaCode;
    
    /**
     * Width of the Cinema
     */
    private int width;
    
    /**
     * Length of the Cinema
     */
    private int length;
    
    /**
     * Number of aisles in the seating format
     */
    private int aisleCount;
    
    /**
     * Create a cinema with a customized size and row compositions
     * @param cinemaCode The cinema code of the cinema
     * @param width The width (X) of the cinema
     * @param length The length(Y) of the cinema
     * @param aisleCount The number of 1x1 aisle in the seating format of the
     *           cinema
     * @param rowComposition the composition of seat rows that will make up the
     *           seating format of the cinema
     */
    public Cinema(String cinemaCode,int width, int length
            , int aisleCount,SeatRowType[] rowComposition) {
        this.cinemaCode = cinemaCode;
        this.width = width;
        this.length = length;
        this.aisleCount = aisleCount;
        this.baseType = CinemaBase.CUSTOM;
        this.seatformat = new SeatFormat(width,aisleCount,rowComposition);
        
    }
    
    /**
     * Create a cinema from a base type with its own fixed dimensions and
     * seating format
     * @param cinemaCode The cinema code of the cinema
     * @param baseType The cinema base to generate the seating format from
     */
    public Cinema(String cinemaCode, CinemaBase baseType) {
        this.cinemaCode = cinemaCode;
        this.baseType = baseType;
        this.seatformat = CinemaBase.generateformat(this);
        this.width = seatformat.getWidth();
        this.length = seatformat.getLength();
        this.aisleCount = seatformat.getAisleCount();
    }
    public Cinema(String cinemaCode) {
        this.cinemaCode = cinemaCode;
        this.baseType = baseType;
        this.seatformat = CinemaBase.generateformat(this);
        this.width = seatformat.getWidth();
        this.length = seatformat.getLength();
        this.aisleCount = seatformat.getAisleCount();
    }
    
    /**
     * Print the seating format of the cinema in the console, for debugging
     * @param cinema the cinema to print the format from
     */
    public static void printformat(Cinema cinema) {
        SeatFormat.printformat(cinema.seatformat);
    }
    
    /**
     * Get the seating format of the cinema
     * @return The seating format of the cinema
     */
    public Hashtable<Integer,SeatRow> getformat() {
        return this.seatformat.getformat();
    }

    /**
     * @return the cinemaCode
     */
    public String getCinemaCode() {
        return cinemaCode;
    }

    /**
     * @param cinemaCode the cinemaCode to set
     */
    public void setCinemaCode(String cinemaCode) {
        this.cinemaCode = cinemaCode;
    }
    
    
}
