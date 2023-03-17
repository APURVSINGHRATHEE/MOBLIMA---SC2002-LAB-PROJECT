package Model.Cineplex;

import java.util.Hashtable;
import java.io.Serializable;

/**
 * Class that represents a row of seats (including blocks) in 
 * the seating format of a cinema
 */
public class SeatRow implements Serializable {
    
    private static final long serialVersionUID = 12324134119L;
    
    /**
     * blocks in the row; will be replaced by a seat where appropriate
     */
    protected CinemaBlock[] blocks;
    
    /**
     * Alphabetical Label for the row
     */
    protected String rowLabel;
    
    /**
     * Row number of the seat row in the seating format
     */
    protected int rowNumber;
    
    /**
     * Width of the row
     */
    protected int rowWidth;
    
    /**
     * Indexes of the blocks in the row to leave empty for the aisles
     */
    protected int[] aisleIndexes;
    
    /**
     * Indexes of the blocks in the row to leave empty for the aisles
     */
    protected SeatRowType rowType;
    
    /**
     * Create a row of seats from a base of seat row types under the
     * constraints of the size of the Cinema and the number of aisles
     * @param rowNumber The row number of the new seat row
     * @param rowWidth The width of the new seat row
     * @param aisleIndexes The block indexes to leave empty in the new seat row
     * @param rowType The type of seats included in this row
     */
    public SeatRow(int rowNumber, int rowWidth,
            int[] aisleIndexes,SeatRowType rowType) {
        this.rowNumber = rowNumber;
        this.rowWidth = rowWidth;
        this.rowLabel = intToRowLabel(rowNumber);
        this.aisleIndexes = aisleIndexes;
        this.rowType = rowType;
        this.blocks = SeatRowType.generateformat(this);
    }
    
    /**
     * Converts the row number into the row label
     * @param rowNumber The row number of the seat
     * @return The row label of the seat
     */
    public static String intToRowLabel(int rowNumber) {
        if (rowNumber+64<91) {
            return Character.toString((char) (rowNumber+64));  
        }
        return "Z" + intToRowLabel(rowNumber-26);
        
    }
    
    /**
     * Counts the number of each seat type in the seat row
     * @param seatRow The row to count the number of each seat type
     * @return A Hashtable of count for each seat type in the row
     */
    public static Hashtable<String,Integer> countSeatsByType(SeatRow seatRow) {
        Hashtable<String,Integer> rowCapacityByType = new Hashtable<>();
        SeatType tempSeatType;
        int i;
        for (CinemaBlock block: seatRow.blocks) {
            if(block.getClass()== Seat.class) {
                tempSeatType = ((Seat) block).getSeatType();
                if (rowCapacityByType.containsKey(tempSeatType.toString())) {
                    i = rowCapacityByType.get(tempSeatType.toString());
                    rowCapacityByType.put(tempSeatType.toString(),++i);
                }
                else {
                    rowCapacityByType.put(tempSeatType.toString(),1);
                }
            }
        }
        return rowCapacityByType;
    }
    
    /**
     * Counts the total number of seats in the seat row
     * @param seatRow The row to count the number of each seat type
     * @return total number of seats in the seating format
     */
    public static int countTotalSeats(SeatRow seatRow) {
        int rowCapacity = 0;
        for (CinemaBlock block: seatRow.blocks) {
            if(block.getClass()== Seat.class) {
                rowCapacity++;
            }
        }
        return rowCapacity;
    }
    
    /**
     * Remove a seat from the seating format
     * @param offset The column number of the seat to remove
     */
    public void removeBlock(int offset) {
        if (blocks[offset].getClass() == Seat.class && blocks[offset] != null) {
            blocks[offset] = new CinemaBlock(rowNumber,offset);
        }
    }
    
    /**
     * Add a seat to the format
     * @param offset The column number of the seat to add
     * @param seatType The seat type of the seat to add
     */
    public void addSeat(int offset, SeatType seatType) {
        if (blocks[offset] != null) {
            blocks[offset] = new Seat(rowNumber,offset,intToRowLabel(rowNumber),
                offset,seatType);
        }
    }
    
    /**
     * Get the row of blocks the seat row
     * @return Returns the blocks of the seat row
     */
    public CinemaBlock[] getRow() {
        return this.blocks;
    }
    
    /**
     * Get width of the seat row
     * @return the width of the seat row
     */
    public int getWidth() {
        return this.rowWidth;
    }
}
