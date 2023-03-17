package Model.Movie;

/**
 * Enumeration class of Movie Rating
 */
public enum Ratings {
    G("General"),
    PG("Parental Guidance Suggested"),
    PG_13("Parents Strongly Cautioned"),
    R("Restricted"),
    NC_17("Adults Only");
    
    /**
     * String description describing the movie rating
     */
    private final String ratingDescription;
	
    /**
     * Create a Movie Rating
     * @param rating Description Description of movie rating
    */ 
    Ratings(String ratingDescription){
	this.ratingDescription = ratingDescription;
    }

    /**
     * Returns the movie rating description
     * @return movie rating description
     */
    public String toString() {
        return ratingDescription;
    }
}    



