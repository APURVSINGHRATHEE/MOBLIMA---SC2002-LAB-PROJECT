package Model.Movie;

import Model.User.MovieGoerMenu;
import Helpful.Body;

/**
 * Class that represents a Movie remark
 */
public class Remarks extends Body{
    
    private static final long serialVersionUID = 12324134119L;
    
    /**
     * MovieGoer that wrote the remark
     */
    private MovieGoerMenu remarker;
    
    /**
     * remark rating of the movie remark
     */
    private int remarkRating;
    
    /**
     * Text of the movie remark
     */
    private String remark;
    
    /**
     * Creates a movie remark
     * @param remarker the MovieGoer that authored the remark
     * @param remarkRating the rating given by the remarker
     * @param remark the text of the remark
     */
    public  Remarks(MovieGoerMenu remarker, int remarkRating, String remark) {
        this.remarker = remarker;
        this.remarkRating = remarkRating;
        this.remark = remark;
    }
    
    /**
     * Edit a movie remark
     * @param remarkRating the rating given by the remarker
     * @param remark the text of the remark
     */
    public void editremark(int remarkRating, String remark){
        this.remarkRating = remarkRating;
        this.remark = remark;
    }
    
    /**
     * Get the MovieGoer object of the author of this remark
     * @return the username of the author
     */
    public MovieGoerMenu getremarker(){
        return remarker;
    }
    
    /**
     * Get the name of the author of this remark
     * @return the username of the author
     */
    public String getremarkerName(){
        return remarker.getName();
    }
    
    /**
     * Get the remark rating of this remark
     * @return the rating of this remark
     */
    public int getremarkRating(){
        return remarkRating;
    }
    
    /**
     * Get the remark text of this remark
     * @return the remark text of this remark
     */
    public String getremark(){
        return remark;
    }
}

