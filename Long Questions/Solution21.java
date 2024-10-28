/*
 * Create class Player2 with below attributes:

id - int
name - String
iccRank - int
matchesPlayed - int
runsScored - int

Create class Solution and implement static method "findAverageOfRuns" in the Solution class.
This method will take array of Player objects and a target int as parameters.
And will return another double array where the target int is lesser than or equal to the original array of Player object's 
matchesPlayed attribute and contains the average run scored by each player satisfying above condition.

Write necessary getters and setters.

Before calling "findAverageOfRuns" method in the main method, read values for four Player objects referring the attributes 
in above sequence along with a int target.
Then call the "findAverageOfRuns" method and write logic in main method to print "Grade A",if the calculated averageRun 
value is 80 to 100. Else if the averageRun value is between 50 and 79 then print "Grade B". Else print "Grade C".

Input
------------------
100
Sachin
5
150
13000
101
Sehwag
4
120
10000
103
Dhoni
7
110
7000
104
Kohli
15
57
4400
100

Output
--------------------
Grade A
Grade A
Grade B
 */


import java.util.*;


public class Solution21 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        List<Player2> list = new ArrayList<>();

        list.add(new Player2(100, "Sachin", 5, 150, 13000));
        list.add(new Player2(101, "Sehwag", 4, 120, 10000));
        list.add(new Player2(103, "Dhoni", 7, 110, 7000));
        list.add(new Player2(104, "Kohli", 15, 57, 4400));


        int input1 = 100;
        double[] ans = findAverageOfRuns(list,input1);
        //System.out.println(Arrays.toString(ans));
        for(double runs : ans){
            if(runs>=80 && runs<=100){
                System.out.println("Grade A");
            }else if(runs>=50 && runs<=79){
                System.out.println("Grade B");
            }else{
                System.out.println("Grade C");
            }
        }


    }

    static double[] findAverageOfRuns(List<Player2> list,int givenMatches){
        int count = 0;
        for(int i = 0;i<list.size();i++){
            Player2 curr = list.get(i);
            if(givenMatches<=curr.getMatchesPlayed()){
                count++;
            }
        }
        double[] ans = new double[count];

        int j = 0;
        for(int i = 0;i<list.size();i++){
            Player2 curr = list.get(i);
            if(givenMatches<=curr.getMatchesPlayed()){
                ans[j] = curr.getRunsScored()/curr.getMatchesPlayed();
                j++;
            }
        }

        return ans;
    }


}

class Player2{
    int id;
    String name;
    int iccRank;
    int matchesPlayed;
    int runsScored;

    public Player2(int id,String name,int iccRank,int matchesPlayed,int runsScored){
        this.id = id;
        this.name = name;
        this.iccRank = iccRank;
        this.matchesPlayed = matchesPlayed;
        this.runsScored = runsScored;
    }

    public int getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public int getIccRank(){
        return iccRank;
    }

    public int getMatchesPlayed(){
        return matchesPlayed;
    }

    public int getRunsScored(){
        return runsScored;
    }


}
