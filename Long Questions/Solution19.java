/*
 * Create class Inventory with below attributes:

inventoryId - String
maximumQuantity - int
currentQuantity - int
threshold - int

Create class Solution and implement static method "Replenish" in the Solution class.
This method will take array of Inventory objects and a limit int as parameters.
And will return another array of Inventory objects where the limit int is greater than or equal to the original array of 
Inventory object's threshold attribute.

Write necessary getters and setters.

Before calling "Replenish" method in the main method, read values for four Inventory objects referring the attributes in above 
sequence along with a int limit.Then call the "Replenish" method and write logic in main method to print "Critical Filling",
if the threshold attribute is greater than 75. Else if the threshold attribute is between 50 and 75 then print 
"Moderate Filling". Else print "Non-Critical Filling"

Input
---------------------------
1
100
50
50
2
200
60
40
3
150
35
45
4
80
45
40
45

Output
----------------------------
2 Non-Critical Filling
3 Non-Critical Filling
4 Non-Critical Filling
 */


import java.util.*;


public class Solution19 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        List<Inventory> list = new ArrayList<>();

        list.add(new Inventory("1", 100, 50, 50));
        list.add(new Inventory("2", 200, 60, 40));
        list.add(new Inventory("3", 150, 35, 45));
        list.add(new Inventory("4", 80, 45, 40));

        int limit = 45;
        List<Inventory> ansList = replenish(list,limit);
        if(ansList.isEmpty()){
            System.out.println("There is no data");
        }else{
            for(Inventory inven : ansList){
                String val = func(inven.getThreshold());
                System.out.println(inven.getInventoryId()+" "+val);

            }
        }


    }

    static String func(int threshold){
        String ans = "";    

        if(threshold>75){
            ans =  "Critical Filling";
        }else if(threshold>=50 && threshold<=75){
            ans = "Moderate Filling";
        }else{
            ans = "Non-Critical Filling";
        }

        return ans;
    }

    static List<Inventory> replenish(List<Inventory> list,int limit){
        List<Inventory> ansList = new ArrayList<>();

        for(int i = 0;i<list.size();i++){
            Inventory curr = list.get(i);
            if(limit>=curr.getThreshold()){
                ansList.add(curr);
            }
        }

        return ansList;
    }


}


class Inventory{
    String inventoryId;
    int maximumQuantity;
    int currentQuantity;
    int threshold;

    public Inventory(String inventoryId,int maximumQuantity,int currentQuantity,int threshold){
        this.inventoryId = inventoryId;
        this.maximumQuantity = maximumQuantity;
        this.currentQuantity = currentQuantity;
        this.threshold = threshold;
    }

    public String getInventoryId(){
        return inventoryId;
    }

    public int getMaximumQuantity(){
        return maximumQuantity;
    }

    public int getCurrentQuantity(){
        return currentQuantity;
    }

    public int getThreshold(){
        return threshold;
    }

}