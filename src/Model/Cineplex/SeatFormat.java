package Model.Cineplex;

import java.util.Hashtable;
import java.io.Serializable;
import java.util.Set;

/**
 * Class that represents the seating format for a cinema
 */
public class SeatFormat implements Serializable{
    
    private static final long serialVersionUID = 12324134119L;
    
    /**
     * Width of the format; corresponds to the width of the Cinema
     */
    private int formatWidth;
    
    /**
     * Number of aisles in the format
     */
    private int aisleCount;
    
    /**
     * Row composition of the format;rows start from the back (i.e. the entrance)
     */
    private SeatRowType[] rowsComposition;
    
    /**
     * The seating format of the cinema stored as a hash table
     */
    private Hashtable<Integer,SeatRow> seatformat;
    
    /**
     * Create a seating format based on the width of the Cinema and the
     * ordered composition of the seat rows
     * @param lformatWidth the width of the Cinema
     * @param rowsComposition the composition of seat row types stored as an array
     * Rows starting from the entrance begins as the first element of the array
     */
    public SeatFormat(int lformatWidth, int aisleCount, SeatRowType[] rowsComposition ) {
        this.formatWidth = lformatWidth;
        this.rowsComposition = rowsComposition;
        this.aisleCount = aisleCount;
        seatformat = generateformat(this);
    }
    
    /**
     * Get the width (X) of the seating format
     * @return Width of the seating format
     */
    public int getWidth() {
        return this.formatWidth;
    }
    
    /**
     * Get the length (Y) of the seating format
     * @return Length of the seating format
     */
    public int getLength() {
        return seatformat.size();
    }
    
    /**
     * Get the number of aisles in the seating format
     * @return Number of aisles in the seating format
     */
    public int getAisleCount() {
        return aisleCount;
    }
    
    /**
     * Generate the format for the cinema based on the parameters provided
     * @return format of the cinema, stored in a Hashtable
     */
    private static Hashtable<Integer,SeatRow> generateformat(SeatFormat format) {
        Hashtable<Integer,SeatRow> newformat = new Hashtable<>();
        int[] aisleIndexes = generateAisleIndex(format.formatWidth,
        format.aisleCount);
        int rowCtr = 1;
        for (SeatRowType rowType: format.rowsComposition) {
            newformat.put(rowCtr++,new SeatRow(rowCtr,format.formatWidth,
                    aisleIndexes,rowType));
        }
        return newformat;
    }
    
    /**
     * Generate an array of indexes of blocks to leave empty for the aisles
     * @param formatWidth The width of the format
     * @param aisleCount The number of aisle to include in the format
     * @return an array of indexes of blocks specified for the aisle
     */
    private static int[] generateAisleIndex(int formatWidth, int aisleCount) {
        int i;
        int[] aisleIndex;
        int multiplier = formatWidth/(aisleCount+1);
        
        aisleIndex = new int[aisleCount];
        for (i=0;i<aisleCount;i++) {
            aisleIndex[i]=multiplier*(i+1);
        }
        return aisleIndex;
    }
    
    /**
     * Gets the number of each seat type in the seating format
     * @param seatformat the seating format to count the number of each seat type
     * @return A Hashtable of count for each seat type in the seating format
     */
    public static Hashtable<String,Integer> getCapacityByType(
            SeatFormat seatformat) {
        int i;
        Hashtable<String,Integer> formatCapacityByType = new Hashtable<>();
        Hashtable<String,Integer> tempRowCapacityByType;
        Hashtable<Integer,SeatRow> tempformat = seatformat.getformat();
        Set<String> keys2;
        
        Set<Integer> keys = tempformat.keySet();
        for (Integer key: keys) {
            tempRowCapacityByType = 
                    SeatRow.countSeatsByType(tempformat.get(key));
            
            keys2 = tempRowCapacityByType.keySet();
            for (String key2: keys2) {
                i = formatCapacityByType.get(key2);
                if (formatCapacityByType.containsKey(key2)) {
                    formatCapacityByType.put(key2,++i);
                }
                else {
                    formatCapacityByType.put(key2,i);;
                }
            }    
        }
        return formatCapacityByType;
    }
    
    /**
     * Gets the total number of seats in the seating lformat
     * @param seatformat The seating format to count the total number of seats
     * @return Total number of seats
     */
    public static int getCapacity(SeatFormat seatformat) {
        int tempRowCapacity;
        Hashtable<Integer,SeatRow> tempformat = seatformat.getformat();
        Set<Integer> keys = tempformat.keySet();
        int formatCapacity = 0;
        
        for (Integer key: keys) {
            tempRowCapacity = 
                    SeatRow.countTotalSeats(tempformat.get(key));
                    formatCapacity += tempRowCapacity;
        }
        return formatCapacity;
    }
    
    /**
     * Get the seating format, stored in a Hashtable
     * @return seating format
     */
    public Hashtable<Integer,SeatRow> getformat() {
        return this.seatformat;
    }
    
    /**
     * Print the seating format, stored in a Hashtable, for debugging purposes.
     * Prints the rows starting from the screen
     * @param seatformat the format object with the seating format to be printed
     */
    public static void printformat(SeatFormat seatformat) {
        CinemaBlock[] tempSeatRow;
        Seat tempSeat;
        String tempIcon;
        Hashtable<Integer,SeatRow> tempformat = seatformat.getformat();
        Set<Integer> keys = tempformat.keySet();
        
        for (Integer key: keys) {
            tempSeatRow = tempformat.get(key).blocks;
            for (CinemaBlock block: tempSeatRow) {
                if(block.getClass()== Seat.class) {
                    tempSeat = (Seat) block;
                    tempIcon = tempSeat.getSeatType().toIcon();
                    System.out.print(tempIcon);
                }
                else {
                    System.out.print("   ");
                }
                
            }
            System.out.print("\n");
        }
    }
    
    /**
     * Get the seating format, stored in a Hashtable
     * @param newformat the new format to replace
     * 
     */
    public void setformat(Hashtable<Integer,SeatRow> newformat) {
        this.seatformat = newformat;
    }
}
