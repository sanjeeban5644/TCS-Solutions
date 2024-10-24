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