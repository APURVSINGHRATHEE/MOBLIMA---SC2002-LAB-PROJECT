package Model.Cineplex;

import Helpful.Body;

/**
 * Class that represents an empty block in the seating format of a cinema
 */
public class CinemaBlock extends Body {
    
    private static final long serialVersionUID = 12324134119L;
    
    /**
     * X Coordinates of the block in the seating format
     */
    protected int xCoordinates;
    
    /**
     * Y Coordinates of the block in the seating format
     */
    protected int yCoordinates;
    
    /**
     * Create an empty block in the format at the X and Y coordinates provided
     * @param x The X coordinates of the block
     * @param y The Y coordinates of the block
     */
    public CinemaBlock(int x, int y){
        this.xCoordinates = x;
        this.yCoordinates = y;
    }
    
    /**
     * Get the X coordinates of the block
     * @return X coordinates of the block
     */
    public int getXCoordinates() {
        return this.xCoordinates;
    }
    
    /**
     * Get the Y coordinates of the block
     * @return Y coordinates of the block
     */
    public int getYCoordinates() {
        return this.yCoordinates;
    }
    
    /**
     * Change X coordinate of of block
     * @param x X coordinates to change to
     */
    public void setX(int x) {
        this.xCoordinates = x;
    }
    
    /**
     * Change Y coordinate of of blocks
     * @param y Y coordinates to change to
     */
    public void setY(int y) {
        this.yCoordinates = y;
    }
    
}

