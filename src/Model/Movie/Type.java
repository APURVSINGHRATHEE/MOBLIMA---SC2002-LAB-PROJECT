package Model.Movie;

/**
 * Enumeration Type of Movie
 */
public enum Type {
    _3D("3D Movie"),
    _2D("2D Movie");
    
    /**
     * String Description Describing the Movie Type
     */
    private final String typeDescription;
	
    /**
     * Create a Movie Type
     * @param typeDescription Description of movie type
    */ 
    Type(String typeDescription){
	this.typeDescription = typeDescription;
    }

    /**
     * Returns the movie rating description
     * @return movie rating description
     */
    public String toString() {
        return typeDescription;
    }
}    
