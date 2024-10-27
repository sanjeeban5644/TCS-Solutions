/*
 * Create a class Cinema with the below attributes:

movieId - int
director - String
rating - int
budget - int

Write getters, setters and parameterized constructor in the above mentioned attribute sequence as required.

Create class Solution with the main method.

Implement two static methods - findAvgBudgetByDirector and getMovieByRatingBudget in Solution class.

findAvgBudgetByDirector method:
----------------------------------
This method will take two input parameters - array of Movie objects and string parameter director.
The method will return the average of the budget attribute from Movie objects directed by the director passed as parameter.
If no movie with the given director is present in the array of movie objects, then the method should return 0.

getMovieByRatingBudget method:
----------------------------------
This method will take two int parameters rating and budget, along with the array of movie objects.
The method will return the movie object, if the input parameters rating and budget, matches with the rating and budget 
attribute of the movie object respectively.

Also check if rating is a factor of budget (eg: 3 is a factor of 12 because 3 divides 12 without leaving a remainder).
If any of the conditions are not met, then the method should return null.

Note : No two movie object would have the same value for rating and budget attributes.
All the searches should be case insensitive.
The budget mentioned are in crores and in INR.

These above mentioned static methods should be called from the main method.

For findAvgBudgetByDirector method - The main method should print the average budget as it is if the returned value is 
greater than 0, or it should print "Sorry - The given director has not yet directed any movie".

For getMovieByRatingBudget method - The main method should print the movieId of the returned movie object. If the returned 
value is null then it should print "Sorry - No movie is available with the specified rating and budget requirement".

Before calling these static methods in main, use Scanner object to read the values of four Movie objects referring attributes 
in the above mentioned attribute sequence. Next, read the value for director, rating and budget.

Input
----------
1101
GVM
4
100
1201
Shankar
5
500
1301
Shankar
3
50
1401
GVM
5
300
GVM
5
300

Output
----------
200
1401
 */


import java.util.*;

public class Solution20 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        List<Cinema> list = new ArrayList<>();

        list.add(new Cinema(1101, "GVM", 4, 100));
        list.add(new Cinema(1201, "Shankar", 5, 500));
        list.add(new Cinema(1301, "Shankar", 3, 50));
        list.add(new Cinema(1401, "GVM", 5, 300));

        String input1 = "GVM";
        int ans1 = findAvgBudgetByDirector(list,input1);
        if(ans1==0){
            System.out.println("Sorry - The given director has not yet directed any movie");
        }else{
            System.out.println(ans1);
        }

        int input2 = 5;
        int input3 = 300;
        Cinema ans2 = getMovieByRatingBudget(list,input2,input3);
        if(ans2==null){
            System.out.println("Sorry - No movie is available with the specified requirements");
        }else{
            System.out.println(ans2.getMovieId());
        }



    }

    static Cinema getMovieByRatingBudget(List<Cinema> list,int givenRating,int givenBudget){
        Cinema ans = null;

        for(int i = 0;i<list.size();i++){
            Cinema curr = list.get(i);
            if(curr.getRating() == givenRating && curr.getBudget() == givenBudget && curr.getBudget()%curr.getRating()==0){
                ans = curr;
                break;
            }
        }

        return ans;
    }






    static int findAvgBudgetByDirector(List<Cinema> list,String givenDirector){
        int ans = 0;
        int count = 0;

        for(int i = 0;i<list.size();i++){
            Cinema curr = list.get(i);
            if(curr.getDirector().toLowerCase().equals(givenDirector.toLowerCase())){
                ans+=curr.getBudget();
                count++;
            }
        }

        return ans/count;
    }



}


class Cinema{
    int movieId;
    String director;
    int rating;
    int budget;

    public Cinema(int movieId, String director, int rating, int budget){
        this.movieId = movieId;
        this.director = director;
        this.rating = rating;
        this.budget = budget;
    }

    public int getMovieId(){
        return movieId;
    }

    public String getDirector(){
        return director;
    }

    public int getRating(){
        return rating;
    }

    public int getBudget(){
        return budget;
    }

}