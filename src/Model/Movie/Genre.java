package Model.Movie;

/**
 * Enumeration class of Movie Genre
 */
public enum Genre {
    ACTION("Action"),
    ADVENTURE("Adventure"),
    COMEDY("Comedy"),
    CRIME("Crime"),
    DRAMA("Drama"),
    FANTASY("Fantasy"),
    HISTORICAL("Historical"),
    HORROR("Horror"),
    MYSTERY("Mystery"),
    ROMANCE("Romance"),
    SCI_FI("Sci Fi"),
    THRILLER("Thriller"),
    ANIMATION("Animation");
    
    /**
     * String of Genre
     */
    private final String Genre;
    
    /**
     *Create a Movie Genre
     * @param Rating Description the description of movie
     */
    Genre(String Genre){
        this.Genre = Genre;
    }
    
    /**
     * Returns the genre name
     * @return the  genre name
     */
    public String toString() {
        return Genre;      
    }
    
}