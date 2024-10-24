/*
 * 
 * Create a class Player with below attributes: 

playerId - int 
skill - String 
level - String 
points - int

Write getters, setters and parameterized constructor in the above mentioned attribute 
sequence as required.

Create class Solution with the main method.

Implement two static methods - findPointsForGivenSkill and getPlayerBasedOnLevel in Solution class.

findPointsForGivenSkill method: 
------------------------------------
This method will take two input parameters - array of Player objects 
and string parameter skill. The method will return the sum of the points attribute from player objects 
for the skill passed as parameter. If no player with the given skill is present in the array of player 
objects, then the method should return 0.

getPlayerBasedOnLevel method: 
-------------------------------------
This method will take two String parameters level and skill, along with the array of Player objects. 
The method will return the player object, if the input String parameters matches with the level and 
skill attribute of the player object and its point attribute is greater than or equal to 20. If any 
of the conditions are not met, then the method should return null.

Note : No two player object would have the same value for skill and level attribute. All player object 
would have the points greater than 0. All the searches should be case insensitive.

These above mentioned static methods should be called from the main method.

For findPointsForGivenSkill method - The main method should print the points as it is if the returned 
price is greater than 0, or it should print "The given Skill is not available".

For getPlayerBasedOnLevel method - The main method should print the playerId of the returned player object.
If the returned value is null then it should print "No player is available with specified level, skill 
and eligibility points".

Before calling these static methods in main, use Scanner object to read the values of four Player objects 
referring attributes in the above mentioned attribute sequence. Next, read the value for skill and level.
Please consider the skill value read above as skill parameter for both the static methods.

Input:
-----------
101
Cricket
Basic
20
102
Cricket
Intermediate
25
111
Football
Intermediate
50
113
BaseBall
Advanced
100
Cricket
Intermediate

Output:
--------------
45
102
 */

import java.util.*;

public class Solution5 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Player[] arr = new Player[4];
        arr[0] = new Player(101, "Cricket", "Basic", 20);
        arr[1] = new Player(102, "Cricket", "Intermediate", 25);
        arr[2] = new Player(111, "Football", "Intermediate", 50);
        arr[3] = new Player(113, "BaseBall", "Advanced", 100);

        String input1 = "Cricket";
        int ans1 = findPointsForGivenSkill(arr,input1);
        System.out.println("Points are : "+ans1);

        String input2 = "Intermediate";
        Player ans2 = getPlayerBasedOnLevel(arr,input1,input2);
        System.out.println(ans2.getPlayerId());


    }

    static Player getPlayerBasedOnLevel(Player[] arr,String givenSkill,String givenLevel){
        Player ans = null;

        for(int i = 0;i<arr.length;i++){
            Player curr = arr[i];
            if(curr.getSkill().toLowerCase().equals(givenSkill.toLowerCase()) && curr.getLevel().toLowerCase().equals(givenLevel.toLowerCase()) && curr.getPoints()>=20){
                ans = curr;
                break;
            }
        }



        return ans;
    }

    static int findPointsForGivenSkill(Player[] arr,String givenSkill){
        int ans = 0;
        for(int i = 0;i<arr.length;i++){
            Player curr = arr[i];
            if(curr.getSkill().toLowerCase().equals(givenSkill.toLowerCase())){
                ans+=curr.getPoints();
            }
        }
        return ans;
    }
}


class Player{
    int playerId;
    String skill;
    String level;
    int points;

    public Player(int playerId,String skill,String level,int points){
        this.playerId=playerId;
        this.skill=skill;
        this.level=level;
        this.points=points;
    }

    public int getPlayerId(){
        return playerId;
    }

    public String getSkill(){
        return skill;
    }

    public String getLevel(){
        return level;
    }

    public int getPoints(){
        return points;
    }
}
