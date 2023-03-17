package Controller;


import java.util.ArrayList;
import Model.Movie.*;
import Model.User.MovieGoerMenu;
import java.util.Collections;

/**
 * Class that controls the movie entity
 */

public class MovieController extends Controller{
    /**
     * The list of movies shown by the company
     */
    private ArrayList<MovieMain> movieList;
    
    /**
     * The movie controller singleton
     */
    private static MovieController instance = null;
    
    /**
     * Creates a new movie controller
     */
    protected MovieController() {
        if (checkStoredListExist("MovieList")) {
            movieList = (ArrayList<MovieMain>) getStoredList("MovieList");
        }
        else {
            movieList = new ArrayList<>();
        }
    }
    
    /**
     * Get the movie controller instance
     * @return the movie controller
     */
    public static MovieController getInstance() {
        if(instance==null) {
            instance = new MovieController();
        }
        return instance;
    }
    
    /**
     * Add new movie information to list
     * @param movieTitle the title of Movie
     * @param movieType the age restriction of the Movie
     * @param movieDuration the duration of the Movie
     * @param movieGenre the list of Genre of the Movie
     * @param movieRating the rating of the Movie
     * @param movieSynopsis the synopsis of the Movie
     * @param director the director of the Movie
     * @param cast the lists of cast for the Movie
     * @param showingStatus the showing status of the movie
     * @return returns the newly created movie if successful, null otherwise
     */
    public MovieMain addMovie(String movieTitle, float movieDuration, 
            ArrayList<Genre> movieGenre, Type movieType,
            Ratings movieRating, String movieSynopsis,String director
            , ArrayList<String> cast, ShowingStatus showingStatus){
       
        MovieMain tempMovie = new MovieMain(movieTitle, movieDuration, movieGenre, movieType
               ,movieRating, movieSynopsis, director, cast, showingStatus);
        
        movieList.add(tempMovie);
        super.updateStoredList(movieList,"MovieList");
        
        return tempMovie;
    }
    
    
    /**
     * Remove the specified Movie from List, identified by movie title
     * @param movieTitle the title of Movie
     * @return return true if success, false otherwise
     */
    public boolean removeMovie (String movieTitle){
        int i;
        for (i=0;i<movieList.size();i++){
            if (movieList.get(i).getMovieTitle().equals(movieTitle)){
                movieList.remove(i);
                super.updateStoredList(movieList,"MovieList");
                return true;
            }
        }
        return false;
    }
    
    /**
     * Return a list of all movie names
     * @return the list of names of all movies
     */
    public ArrayList<String> listAllMovieNames (){
        ArrayList<String> nameList = new ArrayList<>();
        
        movieList.forEach((movie) -> {
            nameList.add(movie.getMovieTitle());
        });
        return nameList;
    }
    
    /**
     * Get movie object of the specified movie
     * @param movieTitle the title of Movie
     * @return the movie with the matching title
     */
    public MovieMain getMovie (String movieTitle){
        int i;
        for (i=0;i<movieList.size();i++){
            if (movieList.get(i).getMovieTitle().equals(movieTitle)){
               return movieList.get(i);
            }
        }
        return null;
    }
    
    /**
     * Get the Ratings and remarks of the Specified Movie
     * @param movieTitle the title of Movie
     * @return the list of remarks for the movie
     */
    public ArrayList<Remarks> getMovieRating (String movieTitle){
        int i;
        for (i=0;i<movieList.size();i++){
            if (movieList.get(i).getMovieTitle().equals(movieTitle)){
                if(movieList.get(i).getremark().isEmpty())
                    return null;
                else{
                    return movieList.get(i).getremark();
                }
            }
        }
        return null;
    }
    
    /**
     * Add Rating and Review for Specified Movie
     * @param movieTitle the title of Movie
     * @param remarker the movie goer who rates the movie
     * @param remarkRating the rating of the Movie
     * @param remark of the Movie
     * @return returns true if success, false otherwise
     */
    public boolean addMovieRating (String movieTitle, MovieGoerMenu remarker, 
            int remarkRating, String remark) {
        int i;
        for (i=0;i<movieList.size();i++){
            if (movieList.get(i).getMovieTitle().equals(movieTitle)){
                movieList.get(i).addremark(remarker, remarkRating, remark);
                super.updateStoredList(movieList,"MovieList");
                return true;
            }
        }
        return false;
    }
    
    
    /**
     * Comparator to get top five movie rating
     * @return Movie[] A list of top five movies based on movie ratings
     */
    public MovieMain[] getTopFiveMovieRating (){
        int i;
        
        ArrayList<MovieMain> MovieList = new ArrayList<>();
        
         for (i=0;i<movieList.size();i++){
            if(movieList.get(i).getAvgremark()!=-1){
            	MovieList.add(movieList.get(i));
            }
        }
        Collections.sort(MovieList, MovieMain.RatingComparator);
        MovieMain topFiveMovie[] = new MovieMain[5];
        if (MovieList.size()>0){
            
            if (MovieList.size() >= 5){
                for (i=0;i<5;i++){
                topFiveMovie[i]=MovieList.get(i);
                }
            }
            else{
                for (i=0;i<MovieList.size();i++){
                topFiveMovie[i]=MovieList.get(i);
                }
            }
            return topFiveMovie;
        }   
        else{
            return null;
        }
    }
    
    /**
     * Comparator method to get top five movies based on ticket sales
     * @return Movie[] A list of top five movies based on ticket sales
     */
    public MovieMain[] getTopFiveMovieTicket (){
        int i;
        
        ArrayList<MovieMain> MovieList = new ArrayList<>();
        
         for (i=0;i<movieList.size();i++){
            	MovieList.add(movieList.get(i));
        }

        Collections.sort(MovieList, MovieMain.MovieSalesComparator);
        MovieMain topFiveMovie[] = new MovieMain[5];
        if (MovieList.size()>0){
            
            if (MovieList.size() >= 5){
                for (i=0;i<5;i++){
                topFiveMovie[i]=MovieList.get(i);
                }
            }
            else{
                for (i=0;i<MovieList.size();i++){
                topFiveMovie[i]=MovieList.get(i);
                }
            }
            return topFiveMovie;
        }   
        else{
            return null;
        }
    }
    
    /**
     * Get movie list stored list
     * @return the movie stored list
     */
    public ArrayList<MovieMain> getMovieList(){
    	return movieList;
    }
    
    /**
     * Get movie list stored list with string
     * @return string of movies
     */
    public ArrayList<String> getAllMovieList(){
    	ArrayList<String> movieTitleList = new ArrayList<>();
        for(MovieMain movie: movieList) {
            movieTitleList.add(movie.getMovieTitle());
        }
        return movieTitleList;
    }
    
    
    /**
     * Reset the stored list
     */
    @Override
    public void resetList() {
        movieList = new ArrayList<>();
    }
}