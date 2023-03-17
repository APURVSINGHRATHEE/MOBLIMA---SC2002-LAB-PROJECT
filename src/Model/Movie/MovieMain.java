package Model.Movie;

import Model.User.MovieGoerMenu;
import Helpful.Body;
import java.util.*;

/**
 * Class that represents a Movie
 */
public class MovieMain extends Body{
    
    private static final long serialVersionUID = 12324134119L;
    
    /**
     * Name of the Movie Title
     */
    private String movieTitle;
    
    /**
     * Duration of the Movie
     */
    private float movieDuration;
    
    /**
     * The screen type of the movie
     */
    private Type type;
    
    /**
     * Ticket sales of the movie
     */
    private int ticketSales;
    
    /**
     * Array List of the Movie Genre
     */
    private ArrayList<Genre> Genre = new ArrayList<>();
    
    /**
     * Rating of the Movie (etc. R, PG...)
     */
    private Ratings rating;
    
    /**
     * Synopsis of the Movie
     */
    private String movieSynopsis;
    
    /**
     * Name of the Movie Director
     */
    private String director;
    
    /**
     * Array List of the Movie Cast
     */
    private ArrayList<String> cast = new ArrayList<>();
    
    /**
     * Showing Status of Move (eg. Coming Soon, Showing Now)
     */
    public ShowingStatus showingStatus;
    
    /**
     * Array of Movie Remarks Rating
     */
    private ArrayList< Remarks>  remarks = new ArrayList<>();
    
    /**
     * Create a new movie
     * @param movieTitle the title of Movie
     * @param movieDuration the duration of the movie
     * @param Genre the list of Genre of the Movie
     * @param type the movie type of the movie
     * @param rating the rating of the Movie
     * @param movieSynopsis the synopsis of the Movie
     * @param director the director of the Movie
     * @param cast the lists of cast for the Movie
     * @param showingStatus the showing status of the movie
    */

    public MovieMain(String movieTitle, float movieDuration, 
            ArrayList<Genre> Genre,Type type,
            Ratings rating, String movieSynopsis,String director
            , ArrayList<String> cast, 
            ShowingStatus showingStatus){
        this.movieTitle = movieTitle;
        this.movieDuration = movieDuration;
        this.Genre = Genre;
        this.type = type;
        this.rating = rating;
        this.movieSynopsis = movieSynopsis;
        this.director = director;
        this.cast = cast;
        this.showingStatus = showingStatus;
        this.ticketSales = 0;
    }
    
    /**
     * Create an empty movie
    */
    public MovieMain() {
        this.movieTitle = null;
        this.movieDuration = 0;
        this.Genre = null;
        this.type = null;
        this.rating = null;
        this.movieSynopsis = null;
        this.director = null;
        this.cast = null;
        this.showingStatus = null;;
        this.ticketSales = 0;
    }
    
    /**
     * Add remark to Movie
     * @param remarker the author of the remark
     * @param remarkRating the remark rating of the movie
     * @param remark the remark text of the movie
    */
    public void addremark(MovieGoerMenu remarker, int remarkRating, String remark){
        this.getremarks().add(new Remarks(remarker,remarkRating,remark));
    }
       
    /**
     * Get the title of the Movie
     * @return title of the Movie
     */
    public String getMovieTitle(){
        return movieTitle;
    }
    
    /**
     * Get the Movie Duration
     * @return Movie Duration
     */
    public float getMovieDuration(){
        return movieDuration;
    }
    
    /**
     * Get the Genres
     * @return Genres
     */
    public ArrayList<Genre> getGenre(){
        return Genre;
    }
    
    /**
     * Get the Movie Rating
     * @return Movie Rating
     */
    public Ratings getrating(){
        return rating;
    }
    
    /**
     * Get the Movie Synopsis
     * @return Movie Synopsis
     */
    public String getMovieSynopsis(){
        return movieSynopsis;
    }
    
    /**
     * Get the Movie Director
     * @return Movie Director
     */
    public String getDirector(){
        return director;
    }
    
    /**
     * Get the Movie Casts
     * @return Movie Casts
     */
    public ArrayList<String> getCast(){
        return cast;
    }
    
    /**
     * Get the Movie Showing Status
     * @return Movie Showing Status
     */
    public ShowingStatus getShowingStatus(){
        return showingStatus;
    }
    
    /**
     * Get the Movie remarks
     * @return list of remarks for the movie
     */
    public ArrayList<Remarks> getremark(){
        return getremarks();
    }
    
    /**
     * @return the remarks
     */
    public ArrayList<Remarks> getremarks() {
        return remarks;
    }
    
    /**
     * Get the average rating score
     * @return average rating score of the movie
     */
    public float getAvgremark(){
        int i;
        float sum = 0;
        if (getremarks().size() <= 1)
            return -1;
        
        for (i=0; i < getremarks().size(); i++){
            sum += getremarks().get(i).getremarkRating();
        }
        return (float) sum/getremarks().size();
    }

    /**
     * @param movieTitle the movieTitle to set
     */
    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    /**
     * @param movieDuration the movieDuration to set
     */
    public void setMovieDuration(float movieDuration) {
        this.movieDuration = movieDuration;
    }

    /**
     * @param Genre the Genre to set
     */
    public void setGenre(ArrayList<Genre> Genre) {
        this.Genre = Genre;
    }

    /**
     * @param rating the rating to set
     */
    public void setrating(Ratings rating) {
        this.rating = rating;
    }

    /**
     * @param movieSynopsis the movieSynopsis to set
     */
    public void setMovieSynopsis(String movieSynopsis) {
        this.movieSynopsis = movieSynopsis;
    }

    /**
     * @param director the director to set
     */
    public void setDirector(String director) {
        this.director = director;
    }

    /**
     * @param cast the cast to set
     */
    public void setCast(ArrayList<String> cast) {
        this.cast = cast;
    }

    /**
     * @param showingStatus the showingStatus to set
     */
    public void setShowingStatus(ShowingStatus showingStatus) {
        this.showingStatus = showingStatus;
    }

    /**
     * @param remarks the remarks to set
     */
    public void setremark(ArrayList<Remarks> remarks) {
        this.remarks = remarks;
    }
    
    /**
     * Adds 1 to ticket sales
     */
    public void addTicketsales() {
        ticketSales++;
    }
    
    /**
     * Sets ticket sales to new value
     * @param newSales value to be set to
     */
    public void setTicketsales(int newSales) {
        ticketSales = newSales;
    }
    
    /**
     * Get the total ticket sales for the movie
     * @return ticket sales for the movie
     */
    public int getSales() {
        return ticketSales;
    }

    /*Comparator for sorting the list by Average Ratings*/
    public static  Comparator<MovieMain> RatingComparator = new Comparator<MovieMain>() {

    	 public int compare(MovieMain m1, MovieMain m2) {
    	    float rating1 = m1.getAvgremark();
    	    float rating2 = m2.getAvgremark();

    	    return Float.compare(rating2, rating1);
    	 }
    };
   
    /*Comparator for sorting the list by ticket sales*/
    public static Comparator<MovieMain> MovieSalesComparator = new Comparator<MovieMain>() {

    	 public int compare(MovieMain m1, MovieMain m2) {

    	    int sales1 = m1.getSales();
    	    int sales2 = m2.getSales();

    	    return sales2-sales1;
    	 }
    };
    	 
   
}