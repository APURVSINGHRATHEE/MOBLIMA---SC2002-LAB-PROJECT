package Model.Cineplex;

import java.util.Hashtable;

/**
 * Enumeration class of row types
 */
public enum SeatRowType {
    SINGLESWHEELCHAIR("Single seats with wheelchair spots at the aisles"),
    COUPLES("Couple seats only"),
    SINGLES("Single seats only"),
    ELITES ("Elite single seats only"),
    ULTIMAS ("Ultima single seats only"),
    DIAMOND("Diamond suite seats only"),
    BLANKS("Empty row");
    
    /**
     * Name of the row type
     */
    private final String rowTypeName;
    
    /**
     * Create a seat row type with the type name provided
     * @param seatType The seat type used in this type of seat row
     * @param rowTypeName Name of the row type
     */
    private SeatRowType(String rowTypeName){
        this.rowTypeName = rowTypeName;  
    }
    
    /**
     * Identify the seat row type and calls the relevant method to 
     * generate the corresponding row of seats (including empty blocks for aisle)
     * @param seatRow the Seat row object containing all the arguments required
     * @return An array of cinema blocks representing a row of seats
    */
    public static CinemaBlock[] generateformat(SeatRow seatRow) {
        switch(seatRow.rowType.toString()) {
            case "DIAMOND":
                return generateSingles(seatRow,SeatType.DIAMOND);
            case "ELITES":
                return generateSingles(seatRow,SeatType.ELITE);
            case "ULTIMAS":
                return generateCouples(seatRow,SeatType.ULTIMA);
            case "SINGLES":
                return generateSingles(seatRow,SeatType.SINGLE);
            case "COUPLES":
                return generateCouples(seatRow,SeatType.COUPLE);
            case "SINGLESWHEELCHAIR":
                return generateSingleWithHandicapped(seatRow,SeatType.SINGLE);
            default:
                return generateBlank(seatRow);
        }
    }
    
    /**
     * Checks if the particular block provided is potentially an aisle seat
     * @param colNumber X/Column index of the block
     * @param aisleIndex array of indexes of block to leave empty for the aisle
     * @return true if block provided will be an aisle seat, false otherwise
     */
    private static boolean isAisleSeat(int colNumber,int[] aisleIndex) {
        for (int index: aisleIndex) {
            if(colNumber + 1 == index || colNumber - 1 == index ) {
                return true;
            }
        }
        return false;
    }
    
    /**
     * Checks if the particular block is in the aisle
     * @param colNumber X/Column index of the block
     * @param aisleIndex array of indexes of block to leave empty for the aisle
     * @return true if block provided in the aisle, false otherwise
     */
    protected static boolean isAisle(int colNumber,int[] aisleIndex) {
        for (int index: aisleIndex) {
            if(colNumber == index) {
                return true;
            }
        }
        return false;
    }
    
    /**
     * Checks if the particular block is in the aisle
     * @param colNumbers array of X/Column indexes of the blocks
     * @param aisleIndex array of indexes of blocks to leave empty for the aisle
     * @return true if block provided in the aisle, false otherwise
     */
    protected static boolean isAisle(int[] colNumbers,int[] aisleIndex) {
        for (int index: aisleIndex) {
            for (int colNumber: colNumbers) {
                if(colNumber == index) {
                    return true;
                }
            }
        }
        return false;
    }
   
    /**
     * Return the String name of the seat row type
     * @param seatRowType Seat row type object to obtain the type name from
     * @return String name of the seat row type
     */
    public static String getRowTypeName(SeatRowType seatRowType) {
        return seatRowType.rowTypeName;
    }
    
    /**
     * Generates a row of single seaters (including empty blocks for aisle)
     * @param seatRow the Seat row object containing all the arguments required
     * @return An array of cinema blocks representing a row of seats
     */
    private static CinemaBlock[] generateSingles(SeatRow seatRow
            , SeatType seatType) {
        int i;
        int colCtr=0;
        CinemaBlock[] tempBlocks = new CinemaBlock[seatRow.rowWidth];
        for(i=0;i<seatRow.rowWidth;i++) {
            if (!(isAisle(i,seatRow.aisleIndexes))) {
                tempBlocks[i] = new Seat(seatRow.rowNumber,i,
                    seatRow.rowLabel,colCtr++,seatType);
            } 
            else{
                tempBlocks[i] = new CinemaBlock(seatRow.rowNumber,i);
            }
        }
        return tempBlocks;
    }
    
    /**
     * Generates a row of couple seaters (including empty blocks for aisle)
     * @param seatRow the Seat row object containing all the arguments required
     * @return An array of cinema blocks representing a row of seats
     */
    private static CinemaBlock[]  generateCouples(SeatRow seatRow
            , SeatType seatType) {
        int i;
        int colCtr=0;
        CinemaBlock[] tempBlocks = new CinemaBlock[seatRow.rowWidth];
        for(i=0;i<seatRow.rowWidth;i++) {
            // Check if the current block and next block are in the aisle
            if ((i+1)<seatRow.rowWidth) {
                if(!(isAisle(new int[]{i,i+1},seatRow.aisleIndexes))) {
                    tempBlocks[i] = new Seat(i,seatRow.rowNumber,
                        seatRow.rowLabel,colCtr++,seatType);
                    tempBlocks[i+1] = new Seat(i+1,seatRow.rowNumber,
                        seatRow.rowLabel,colCtr++,seatType);
                    Seat.pairSeat((Seat) tempBlocks[i],(Seat) tempBlocks[i+1]);
                    i++;
                }
                else {
                    tempBlocks[i] = new CinemaBlock(seatRow.rowNumber,i);
                }
            } 
            else {
                tempBlocks[i] = new CinemaBlock(seatRow.rowNumber,i);
            }
        }
        return tempBlocks;
    }
    
    /**
     * Generates a row of single seaters and wheelchair spots along the aisle
     * (including empty blocks for aisle)
     * @param seatRow The Seat Row object containing all the arguments required
     * @return An array of cinema blocks representing a row of seats
     */
    private static CinemaBlock[] generateSingleWithHandicapped(SeatRow seatRow
            , SeatType seatType) {
        int i;
        int colCtr=0;
        CinemaBlock[] tempBlocks = new CinemaBlock[seatRow.rowWidth];
        for(i=0;i<seatRow.rowWidth;i++) {
            if (!(isAisle(i,seatRow.aisleIndexes))) {
                // Handicapped seats can only be placed along the aisle
                if(isAisleSeat(i,seatRow.aisleIndexes)) {
                    tempBlocks[i] = new Seat(seatRow.rowNumber,i,
                        seatRow.rowLabel,colCtr++,SeatType.WHEELCHAIR);
                }
                else {
                    tempBlocks[i] = new Seat(seatRow.rowNumber,i,
                        seatRow.rowLabel,colCtr++,seatType);
                }
            }
            else {
                tempBlocks[i] = new CinemaBlock(seatRow.rowNumber,i);
            }
        }
        return tempBlocks;
    }
    
    /**
     * Generates a blank row
     * @param seatRow the Seat row object containing all the arguments required
     * @return An array of cinema blocks representing the blank row
     */
    private static CinemaBlock[] generateBlank(SeatRow seatRow) {
        int i;
        CinemaBlock[] tempBlocks = new CinemaBlock[seatRow.rowWidth];
        for(i=0;i<seatRow.rowWidth;i++) {
            tempBlocks[i] = new CinemaBlock(seatRow.rowNumber,i);
        }
        return tempBlocks;
    }
}


