/*
 * Create class Movie with below attributes: 

movieName - String 
company - String 
genre - String 
budget - int

Create class Solution and implement static method "getMovieByGenre" in the Solution class. This method will 
take array of Movie objects and a searchGenre String as parameters. And will return another array of Movie 
objects where the searchGenre String matches with the original array of Movie object's genre attribute 
(case insensitive search).

Write necessary getters and setters.

Before calling "getMovieByGenre" method in the main method, read values for four Movie objects referring the 
attributes in above sequence along with a String searchGenre. Then call the "getMovieByGenre" method and write
logic in main method to print "High Budget Movie",if the movie budget attribute is greater than 80000000 else 
print "Low Budget Movie".

Input
---------
aaa
Marvel
Action
250000000
bbb
Marvel
Comedy
25000000
ccc
Marvel
Comedy
2000000
ddd
Marvel
Action
300000000
Action

Output
-------------------
High Budget Movie
High Budget Movie
 */

import java.util.*;

public class Solution8 {
    public static void main(String[] args) {
        Scanner  in = new Scanner(System.in);

        Movie[] arr = new Movie[4];

        arr[0] = new Movie("aaa", "Marvel", "Action", 250000000);
        arr[1] = new Movie("bbb", "Marvel", "Comedy", 25000000);
        arr[2] = new Movie("ccc", "Marvel", "Comedy", 2000000);
        arr[3] = new Movie("ddd", "Marvel", "Action", 300000000);

        int fence = 80000000;

        String input1 = "Action";
        
        List<Movie> list = getMovieByGenre(arr,fence,input1);
        //System.out.println(list.size());
        for(int i = 0;i<list.size();i++){ 
            Movie curr = list.get(i);
            if(curr.getBudget()>fence){
                System.out.println("High Budget Movie");
            }
        }

        
    }

    static List<Movie> getMovieByGenre(Movie[] arr,int fence,String givenGenre){
        List<Movie> list = new ArrayList<>();
        //System.out.println("entered");
        for(int i = 0;i<arr.length;i++){
            Movie curr = arr[i];
            //System.out.println(curr.getGenre());
            if(curr.getGenre().toLowerCase().equals(givenGenre.toLowerCase())){
                //System.out.println(i);
                list.add(curr);
            }
        }

        return list;
    }

}

class Movie{
    String movieName;
    String company;
    String genre;
    int budget;

    public Movie(String movieName,String company,String genre,int budget){
        this.movieName=movieName;
        this.company=company;
        this.genre=genre;
        this.budget=budget;
    }

    public String getMovieName(){
        return movieName;
    }

    public String getCompany(){
        return company;
    }

    public String getGenre(){
        return genre;
    }

    public int getBudget(){
        return budget;
    }

}