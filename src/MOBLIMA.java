
import Controller.*;
import Model.Movie.*;
import Model.Cineplex.*;
import Model.KickOff.*;
import Model.User.*;
import View.*;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import Model.Cineplex.Cinema;

/**
 * The main class
 */
public class MOBLIMA {
    
    private static IDController accountController;
    private static CineplexController cineplexController;
    private static MovieController movieController;
    private static KickOffController showtimeController;
    
    
    public static void main(String[] args) {
        init();
        LoginView.getInstance().login();
    }
    
    public static void init() {
        File directory = new File("Storage");
        if(!directory.exists()){
            directory.mkdir();
        }
        
        accountController = IDController.getInstance();
        cineplexController = CineplexController.getInstance();
        movieController = MovieController.getInstance();
        showtimeController = KickOffController.getInstance();
        
        // Comment out to stop resetting.
        reset();
    }
    
    private static void reset() {
        File directory = new File("Storage");
        if(!directory.exists()){
            directory.delete();
        }
        
        accountController.resetList();
        cineplexController.resetList();
        movieController.resetList();
        showtimeController.resetList();
        
        accountController.addStaff("apurvsr", "apurvsr");
        accountController.addStaff("MZ", "MZ");
        accountController.addMovieGoer("zyaqub"
                , "zyaqub"
                , MovieGoerType.NORMAL
                , "Yaqub", 85395499, "apurv007@gmail.com");
        accountController.addMovieGoer("light"
                , "light"
                , MovieGoerType.NORMAL
                , "light", 88888788, "light@gmail.com");
        accountController.addMovieGoer("Ash"
                , "Ash"
                , MovieGoerType.NORMAL
                , "Ash", 88888388, "Ash@gmail.com");
        accountController.addMovieGoer("May"
                , "May"
                , MovieGoerType.NORMAL
                , "May", 88888328, "May@gmail.com");
        
        accountController.addMovieGoer("alakshya"
                , "alakshya"
                , MovieGoerType.STUDENT
                , "Lakshya", 82141835, "alakshya@gmail.com");
        
        accountController.addMovieGoer("utkarsha"
                , "utkarsha"
                , MovieGoerType.ELDERLY
                , "Utkarsh", 98131326, "utkarsha@gmail.com");
        populateMovies();
        populateCineplex();
        populateShowtime();
    }
    
    private static void populateShowtime() {
        KickOffController tempController = KickOffController.getInstance();
        KickOff tempShowtime;
        MovieGoerMenu tempMovieGoer;
        
        Cineplex tempCineplex = CineplexController
                .getInstance().getCineplexByLocation("Bedok");
        
        Cinema tempCinema = CineplexController
                .getInstance()
                .getCinemaByCode(tempCineplex, "B01");
        
        MovieMain tempMovie = MovieController.getInstance().getMovie("Bramhastra Part One: Shiva");
        
        tempController.addKickOff(tempCinema
                , tempMovie, "20/11/2022 10:00:00");
        

        tempController.addKickOff(tempCinema
                , tempMovie, "21/11/2022 15:00:00");

        tempShowtime = tempController.addKickOff(tempCinema
                , tempMovie, "22/11/2022 20:00:00");

   
        Cineplex tempCineplex2 = CineplexController
        .getInstance().getCineplexByLocation("Bedok");
        
        Cinema tempCinema2 = CineplexController
                .getInstance()
                .getCinemaByCode(tempCineplex, "B02");
        
        MovieMain tempMovie2 = MovieController.getInstance().getMovie("Black Adam");

        tempController.addKickOff(tempCinema
                , tempMovie2, "20/11/2022 12:00:00");
        
        tempController.addKickOff(tempCinema
                , tempMovie2, "21/11/2022 18:00:00");

        tempShowtime = tempController.addKickOff(tempCinema
                , tempMovie2, "22/11/2022 21:00:00");

        Cineplex tempCineplex3 = CineplexController
        .getInstance().getCineplexByLocation("Bedok");
        
        Cinema tempCinema3 = CineplexController
                .getInstance()
                .getCinemaByCode(tempCineplex, "B03");

        MovieMain tempMovie3 = MovieController.getInstance().getMovie("Black Panther: Wakanda Forever");

        tempController.addKickOff(tempCinema
                , tempMovie3, "24/11/2022 10:00:00");
        
        tempController.addKickOff(tempCinema
                , tempMovie3, "25/11/2022 14:00:00");

        tempShowtime = tempController.addKickOff(tempCinema
                , tempMovie3, "26/11/2022 17:00:00");


        MovieMain tempMovie4 = MovieController.getInstance().getMovie("Ram Setu");

        tempController.addKickOff(tempCinema
                , tempMovie4, "20/11/2022 21:00:00");

        MovieMain tempMovie5 = MovieController.getInstance().getMovie("Iron Man");

        tempController.addKickOff(tempCinema
                , tempMovie5, "14/11/2022 12:00:00");
        
        tempController.addKickOff(tempCinema
                , tempMovie5, "17/11/2022 18:00:00");

        tempShowtime = tempController.addKickOff(tempCinema
                , tempMovie5, "22/11/2022 22:00:00");

        MovieMain tempMovie6 = MovieController.getInstance().getMovie("Life is Beautiful");

        tempController.addKickOff(tempCinema
                , tempMovie6, "20/11/2022 12:00:00");
        
        tempController.addKickOff(tempCinema
                , tempMovie6, "21/11/2022 18:00:00");

        tempShowtime = tempController.addKickOff(tempCinema
                , tempMovie6, "22/11/2022 22:00:00");

        MovieMain tempMovie7 = MovieController.getInstance().getMovie("Bhediya");

        tempController.addKickOff(tempCinema
                , tempMovie7, "21/11/2022 21:00:00");
        
        MovieMain tempMovie8 = MovieController.getInstance().getMovie("Puss in Boots: The Last Wish");

        tempController.addKickOff(tempCinema
                , tempMovie8, "22/11/2022 21:00:00");
        
        MovieMain tempMovie9 = MovieController.getInstance().getMovie("Minions: The Rise of Gru");

        tempController.addKickOff(tempCinema
                , tempMovie9, "23/11/2022 21:00:00");

        MovieMain tempMovie10 = MovieController.getInstance().getMovie("DC League of Super-Pets");

        tempController.addKickOff(tempCinema
                , tempMovie10, "24/11/2022 21:00:00");

        MovieMain tempMovie11 = MovieController.getInstance().getMovie("Top Gun Maverick");

        tempController.addKickOff(tempCinema
                , tempMovie11, "24/11/2022 11:00:00");
        
        tempController.addKickOff(tempCinema
                , tempMovie11, "25/11/2022 17:00:00");

        tempShowtime = tempController.addKickOff(tempCinema
                , tempMovie11, "26/11/2022 19:00:00");

        MovieMain tempMovie12 = MovieController.getInstance().getMovie("Phone Booth");

        tempController.addKickOff(tempCinema
                , tempMovie12, "25/11/2022 21:00:00");
        
        MovieMain tempMovie13 = MovieController.getInstance().getMovie("Ajoomma");

        tempController.addKickOff(tempCinema
                , tempMovie13, "20/11/2022 13:00:00");
        
        tempController.addKickOff(tempCinema
                , tempMovie13, "21/11/2022 20:00:00");

        tempShowtime = tempController.addKickOff(tempCinema
                , tempMovie13, "22/11/2022 23:00:00");

        MovieMain tempMovie14 = MovieController.getInstance().getMovie("Bullet Train");

        tempController.addKickOff(tempCinema
                , tempMovie14, "20/11/2022 15:00:00");
        
        tempController.addKickOff(tempCinema
                , tempMovie14, "21/11/2022 17:00:00");

        tempShowtime = tempController.addKickOff(tempCinema
                , tempMovie14, "22/11/2022 22:00:00");
        
        tempMovieGoer = (MovieGoerMenu) IDController.getInstance()
                .getUser("zyaqub");   
       
        showtimeController.addKickOff(tempCinema, tempMovie, "22/11/2022 23:00:00");
        //KickOff.printBookingLayout(tempShowtime);
        //KickOff.getUUIDString(tempMovie14);
        //(tempMovieGoer, tempShowtime, 3, 4);
        //showtimeController.bookSeat(tempMovieGoer, tempShowtime, 1, 2);
        //showtimeController.bookSeat(tempMovieGoer, tempShowtime, 2, 1);
        //showtimeController.bookSeat(tempMovieGoer, tempShowtime, 2, 2);
        
        tempMovieGoer = (MovieGoerMenu) IDController.getInstance()
                .getUser("alakshya");
        
        //showtimeController.bookSeat(tempMovieGoer, tempShowtime, 3, 1);
        //showtimeController.bookSeat(tempMovieGoer, tempShowtime, 3, 2);
        
        tempMovieGoer = (MovieGoerMenu) IDController.getInstance()
                .getUser("utkarsha");
        
        //showtimeController.bookSeat(tempMovieGoer, tempShowtime, 4, 2);
        //showtimeController.bookSeat(tempMovieGoer, tempShowtime, 4, 3);
    }
    
    private static void populateCineplex() {
        Cineplex tempCineplex;
        Cinema tempCinema;
        
        CineplexController tempController 
                = CineplexController.getInstance();
        
        tempCineplex = tempController.addCineplex("Bedok");
        
        tempCinema = tempController.createCinema("B01"
                , CinemaBase.LARGE);
        
        tempController.addCinemaToCineplex(tempCineplex, tempCinema);
        
        tempCinema = tempController.createCinema("B02"
                , CinemaBase.MEDIUM);
         
        tempController.addCinemaToCineplex(tempCineplex, tempCinema);
        
        tempCinema = tempController.createCinema("B03"
                , CinemaBase.DIAMOND);
         
        tempController.addCinemaToCineplex(tempCineplex, tempCinema);
             
    }
    

    
    
    private static void populateMovies() {
        // Creating Movie Bramhastra Part One: Shiva
        ArrayList<String> castList1 = new ArrayList<>();
        ArrayList<Genre> genreList1 = new ArrayList<>();
        castList1.add("Ranbir Kapoor");
        castList1.add("Alia Bhatt");
        genreList1.add(Genre.ACTION);
        genreList1.add(Genre.ADVENTURE);
        MovieController.getInstance().addMovie("Bramhastra Part One: Shiva", 167, genreList1 
                ,Type._2D,Ratings.G, "A young man on the brink of falling in love gets his world"
                + " turned upside down when he discovers he has the power to control fire "
                + "and a connection to a secret society of guardians."
                , "Ayan Mukerji" 
                , castList1 , ShowingStatus.NOWSHOWING);

        // Creating Movie Black Adam
        ArrayList<String> castList2 = new ArrayList<>();
        ArrayList<Genre> genreList2 = new ArrayList<>();
        castList2.add("The Rock");
        castList2.add("Pierce Brosnan");
        genreList2.add(Genre.ACTION);
        genreList2.add(Genre.THRILLER);
        MovieController.getInstance().addMovie("Black Adam", 125, genreList2 
                ,Type._2D, Ratings.PG
                ,  "In ancient Kahndaq, Teth Adam was bestowed the almighty powers of the gods. After using these powers for vengeance, he was imprisoned, becoming Black Adam. "
                        + " Nearly 5,000 years have passed, and Black Adam has gone from man to myth to legend. "
                        + "Now free, his unique form of justice, born out of rage, is challenged by modern-day heroes who form the  "
                        + "Justice Society: Hawkman, Dr. Fate, Atom Smasher and Cyclone."
                , "Jaume Collet-Serra" 
                , castList2 , ShowingStatus.NOWSHOWING);

        // Creating Movie Peacemaker
        ArrayList<String> castList3 = new ArrayList<>();
        ArrayList<Genre> genreList3 = new ArrayList<>();
        castList3.add("John Cena");
        castList3.add("Jennifer Holland");
        genreList3.add(Genre.HORROR);
        genreList3.add(Genre.THRILLER);
        genreList3.add(Genre.ACTION);
        MovieController.getInstance().addMovie("Peacemaker", 183, genreList3 
                ,Type._2D, Ratings.NC_17
                , "Peacemaker is a man who fights for peace at any cost "
                        + "no matter how many people he has to kill to get it. "
                , "James Gunn"
                , castList3 , ShowingStatus.NOWSHOWING);

        // Creating Black Panther: Wakanda Forever
        ArrayList<String> castList4 = new ArrayList<>();
        ArrayList<Genre> genreList4 = new ArrayList<>();
        castList4.add("Letitia Wright");
        castList4.add("Angela Bassett");
        genreList4.add(Genre.ACTION);
        genreList4.add(Genre.THRILLER);
        MovieController.getInstance().addMovie("Black Panther: Wakanda Forever", 161, genreList4 
                ,Type._3D, Ratings.NC_17
                , "Queen Ramonda, Shuri, M'Baku, Okoye and the Dora Milaje fight to protect their nation from intervening world powers "
                        + "in the wake of King T'Challa's death. As the Wakandans strive to embrace their next chapter, "
                        + "the heroes must band together with Nakia and Everett Ross to forge a new path for their beloved kingdom. "
                , "Ryan Coogler", castList4 
                ,ShowingStatus.COMINGSOON);

        // Creating Movie Ram Setu 
        ArrayList<String> castList5 = new ArrayList<>();
        ArrayList<Genre> genreList5 = new ArrayList<>();
        castList5.add("Akshay Kumar");
        castList5.add("Jacqueline Fernandes");
        genreList5.add(Genre.ACTION);
        genreList5.add(Genre.ADVENTURE);
        MovieController.getInstance().addMovie("Ram Setu", 157, genreList5 
                ,Type._2D, Ratings.PG
                ,  "An atheist archaeologist turned believer races against time "
                        + "dto prove the true existence of the legendary Ram Setu "
                        + "before evil forces destroy the pillar of India's heritage." 
                ,"Abhishek Sharma", castList5 
                , ShowingStatus.PREVIEW);
        
        // Creating Movie Iron Man
        ArrayList<String> castList6 = new ArrayList<>();
        ArrayList<Genre> genreList6 = new ArrayList<>();
        castList6.add("Robert Downey Jr.");
        castList6.add("Gwyneth Paltrow");
        castList6.add("Jon Faverau");
        genreList6.add(Genre.ACTION);
        genreList6.add(Genre.THRILLER);
        MovieController.getInstance().addMovie("Iron Man", 126
                , genreList6 ,Type._2D, Ratings.PG
                , "When Tony Stark, an industrialist, is captured, he constructs a high-tech armoured suit to escape. "
                        + "Once he manages to escape, "
                        + "he decides to use his suit to fight against "
                        + "evil forces to save the world."
                ,"Jon Faverau", castList6 , ShowingStatus.NOWSHOWING);
        
        // Creating Movie Life is Beautiful
        ArrayList<String> castList7 = new ArrayList<>();
        ArrayList<Genre> genreList7 = new ArrayList<>();
        castList7.add("Ryu Seung-ryong");
        castList7.add("Yum Jung-ah");
        castList7.add("Ong Seong-wu");
        genreList7.add(Genre.DRAMA);
        genreList7.add(Genre.ROMANCE);
        MovieController.getInstance().addMovie("Life is Beautiful", 122, genreList7 
                ,Type._2D, Ratings.PG_13, 
                        "a musical about Oh Se-yeon who asks her husband to help her "
                        + "ind her childhood sweetheart as her birthday gift. "
                        + "Both embark on journey to find him."
                       ,"Nick Cassavetes"
                , castList7 , ShowingStatus.NOWSHOWING);
        
        // Creating Movie Bhediya
        ArrayList<String> castList8 = new ArrayList<>();
        ArrayList<Genre> genreList8 = new ArrayList<>();
        castList8.add("Varun Dhawan");
        castList8.add("Kriti Sanon");
        castList8.add("Abhishek Banerjee");
        genreList8.add(Genre.ACTION);
        genreList8.add(Genre.THRILLER);
        MovieController.getInstance().addMovie("Bhediya", 158,
                genreList8 ,Type._2D, Ratings.R
                , " story of Bhaskar, a man who gets bitten by a wolf, and begins to transform into the creature. "
                        + "As Bhaskar and his buddies try to find answers, "
                        + "bunch of twists, turns, and laughs ensue."
                ,"Amar Kaushik", castList8 , ShowingStatus.PREVIEW);
        
        // Creating Movie Puss in Boots: The Last Wish
        ArrayList<String> castList9 = new ArrayList<>();
        ArrayList<Genre> genreList9 = new ArrayList<>();
        castList9.add("Antonio Banderas");
        genreList9.add(Genre.ANIMATION);
        genreList9.add(Genre.ADVENTURE);
        genreList9.add(Genre.COMEDY);
        MovieController.getInstance().addMovie("Puss in Boots: The Last Wish", 100, genreList9 
                ,Type._2D, Ratings.PG
                , "Puss sets out on an epic journey to find "
                        + "he mythical Last Wish and restore his nine lives. "
                ,"Andrew Adamson", castList9 , ShowingStatus.PREVIEW);
        
        // Creating Movie Minions: The Rise of Gru
        ArrayList<String> castList10 = new ArrayList<>();
        ArrayList<Genre> genreList10 = new ArrayList<>();
        castList10.add("Steve Carell");
        castList10.add("Julie Andrews");
        genreList10.add(Genre.ANIMATION);
        genreList10.add(Genre.ADVENTURE);
        genreList10.add(Genre.COMEDY);
        MovieController.getInstance().addMovie("Minions: The Rise of Gru", 90, genreList10
                ,Type._2D, Ratings.PG
                , "Gru and his Minions go on the run with the Vicious 6 hot on their tails. "
                        + "Luckily, he finds an unlikely source for guidance -- Wild Knuckles himself --  "
                        + "and soon discovers that even bad guys need a little help from their friends."
                ,"Kyle Balda", castList10 , ShowingStatus.PREVIEW);
        
        // Creating Movie DC League of Super-Pets
        ArrayList<String> castList11 = new ArrayList<>();
        ArrayList<Genre> genreList11 = new ArrayList<>();
        castList11.add("THe Rock");
        castList11.add("Kevin Hart");
        genreList11.add(Genre.ANIMATION);
        genreList11.add(Genre.ADVENTURE);
        genreList11.add(Genre.COMEDY);
        MovieController.getInstance().addMovie("DC League of Super-Pets", 105
                , genreList11 ,Type._2D, Ratings.PG
                , "Krypto the Super-Dog and Superman are inseparable best friends, sharing the same "
                        + "superpowers and fighting crime side by side in Metropolis. However,  "
                        + "when the Man of Steel and the rest of the Justice League are kidnapped, Krypto must convince a ragtag "
                        + "group of animals to master their own newfound powers for a rescue mission."
                ,"Jared Stern", castList11 , ShowingStatus.PREVIEW);
        
        // Creating Movie Top Gun Maverick
        ArrayList<String> castList12 = new ArrayList<>();
        ArrayList<Genre> genreList12 = new ArrayList<>();
        castList12.add("Tom Cruise");
        castList12.add("Miles Teller");
        castList12.add("Val Kilmer");
        genreList12.add(Genre.ADVENTURE);
        genreList12.add(Genre.COMEDY);
        MovieController.getInstance().addMovie("Top Gun Maverick", 131, genreList12 
                ,Type._2D, Ratings.PG
                , "After more than 30 years of service as one of the Navy's top aviators, Pete Maverick Mitchell is where he belongs "
                        + "pushing the envelope as a courageous test pilot and dodging the advancement in rank that would ground him. "
                        + "Training a detachment of graduates for a special assignment, Maverick must confront the ghosts of his past and his deepest fears, "
                        + "culminating in a mission that demands the ultimate sacrifice from those who choose to fly it."
                , "Chris Carter", castList12 , ShowingStatus.COMINGSOON);
        
        // Creating Movie Phone Booth
        ArrayList<String> castList13 = new ArrayList<>();
        ArrayList<Genre> genreList13 = new ArrayList<>();
        castList13.add("Katrina Kaif");
        castList13.add("Ishaan Khattar");
        castList13.add("Siddhant Chaturvedi");
        genreList13.add(Genre.DRAMA);
        genreList13.add(Genre.THRILLER);
        MovieController.getInstance().addMovie("Phone Booth", 135, genreList13 
                ,Type._3D, Ratings.R
                , "Two crazy, jobless, horror-film addicts Major and Gullu, under immense family pressure to find work, hit upon the idea "
                        + "to float a unique ghost-capturing service when they meet a female spirit, Ragini, who makes their business "
                        + "a success but in return asks them for a dangerous favour which they are compelled to honour."
                , "Gurmmeet Singh", castList13 , ShowingStatus.PREVIEW);
        
         // Creating Movie Ajoomma
        ArrayList<String> castList14 = new ArrayList<>();
        ArrayList<Genre> genreList14 = new ArrayList<>();
        castList14.add("Hong Huifang");
        castList14.add("Jung Dong-Hwan");
        castList14.add("Kang Hyung Suk");
        genreList14.add(Genre.ACTION);
        genreList14.add(Genre.DRAMA);
        MovieController.getInstance().addMovie("Ajoomma", 90, genreList14
                ,Type._3D, Ratings.PG_13
                , " story of a woman’s journey of self-discovery, where Auntie learns "
                        + "to embrace her new independent life with renewed confidence and panache. "
                , "He Shuming", castList14 , ShowingStatus.NOWSHOWING);
        
         // Creating Movie Bullet Train
        ArrayList<String> castList15 = new ArrayList<>();
        ArrayList<Genre> genreList15 = new ArrayList<>();
        castList15.add("Brad Pitt");
        castList15.add("Joey King");
        castList15.add("Aaron Taylor Johnson");
        genreList15.add(Genre.ACTION);
        genreList15.add(Genre.ADVENTURE);
        MovieController.getInstance().addMovie("Bullet Train", 126, genreList15
                ,Type._3D,Ratings.PG_13
                , "Ladybug is an unlucky assassin who's determined to do his job peacefully after one too many gigs has gone  "
                        + "off the rails. Fate, however, may have other plans as his latest mission puts him on a collision course with "
                        + "lethal adversaries from around the globe -- all with connected yet conflicting objectives "
                        + "- on the world's fastest train. "
                , "David Leitch", castList15 , ShowingStatus.NOWSHOWING);
    }
}
