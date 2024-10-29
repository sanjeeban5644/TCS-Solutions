/*
 * Create class Team with below attributes:

tId - int
tName - String
tCountry - String
tRun - int

The above attributes should be private.Write Getter and Setter and parametrized constructor as required.

Create class Solution with main method.

Implement One static method-

● findPlayer

findPlayer in the solution class. 
This method will take array of Team objects, int paramater run and String country and returns the Team object where taken 
country is matched with the country of team object and team run is greater than the taken run.

Write code to perform following tasks:

1. In main mehod, take 1st input as integer parameter which shows the number of team object.
2. Take necessary input variable and call findPlayer.
3. All searches should be case insensitive.

For this method- The main method should print the team object. As if the returned value is not null, 
or it should print "No team is found from the given country and run".

Input
------------------
3 
1
Arijit
India
43
2
Doremon
China
40
3
Donal
England
32
35
China



Output
--------------
2
Doremon
China
40
 */


import java.util.*;


public class Solution23 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        List<Team> list = new ArrayList<>();

        list.add(new Team(1, "Arijit", "India", 43));
        list.add(new Team(2, "Doremon", "China", 40));
        list.add(new Team(3, "Donal", "England", 32));

        int input1 = 35;
        String input2 = "china";

        Team ans = findPlayer(list,input1,input2);

        if(ans==null){
            System.out.println("No team is found from the given country and run");
        }else{
            System.out.println(ans.getTId()+" "+ans.getTName()+" "+ans.getTCountry()+" "+ans.getTRun());
        }


    }

    static Team findPlayer(List<Team> list,int givenRuns,String givenCountry){
        Team ans = null;

        for(int i = 0;i<list.size();i++){
            Team curr = list.get(i);
            if(curr.getTCountry().toLowerCase().equals(givenCountry.toLowerCase()) && curr.getTRun()>givenRuns){
                ans = curr;
                break;
            }
        }


        return ans;
    }


}


class Team{
    int tId;
    String tName;
    String tCountry;
    int tRun;

    public Team(int tId,String tName,String tCountry,int tRun){
        this.tId = tId;
        this.tName = tName;
        this.tCountry = tCountry;
        this.tRun = tRun;
    }

    public int getTId(){
        return tId;
    }

    public String getTName(){
        return tName;
    }

    public String getTCountry(){
        return tCountry;
    }

    public int getTRun(){
        return tRun;
    }

}