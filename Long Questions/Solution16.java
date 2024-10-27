/*
 * Create a class Fruits with below attributes as private
● int fruitId
● String fruitName
● int price
● int rating

Write getters, setters and parameterized constructor in the abovementioned attribute 
sequence as required.

Create class Solution with main method

Implement One static method-

● findMaximumPriceByRating

findMaximumPriceByRating in the solution class. 
This method will take array of Fruit objects, int paramater and returns the maximum priced fruit 
object from array of Fruit objects whichever has rating greater than the rating 
(rating parameter passed). This method should be called from main method.

Write code to perform following tasks:

1. Take necessary input variable and call findMaximumPriceByRating.

For this method- The main method should print the fruitId from returnedobject. As if the 
returned value is not null, or it should print "No such Fruit".

Note:- Before calling this static method, use Scanner object to read thevalues of four Fruits 
objects. No two Fruits will have same price. All thesearches should be case insensitive.
Consider below sample input and output to test your code.


Input
-------------------
555
Apple
200
5
777
Orange
150
4
333
Banana
100
4
888
Avocado
250
4
3

Output
-----------------
888
 */


import java.util.*;


public class Solution16 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        List<Fruits> list = new ArrayList<>();

        list.add(new Fruits(555, "Apple", 200, 5));
        list.add(new Fruits(777, "Orange", 150, 4));
        list.add(new Fruits(333, "Banana", 100, 4));
        list.add(new Fruits(888, "Avocado", 250, 4));

        int input = 3;

        Fruits ans = findMaximumPriceByRating(list,input);
        if(ans==null){
            System.out.println("No such Fruit");
        }else{
            System.out.println(ans.getFruitId());
        }


    }

    static Fruits findMaximumPriceByRating(List<Fruits> list, int givenRating){
        Fruits ans = null;
        int highest = Integer.MIN_VALUE;

        for(int i = 0;i<list.size();i++){
            Fruits curr = list.get(i);
            if(curr.getRating()>givenRating){
                if(curr.getPrice()>highest){
                    highest = curr.getPrice();
                    ans = curr;
                }
            }
        }


        return ans;
    }

}


class Fruits{
    int fruitId;
    String fruitName;
    int price;
    int rating;

    public Fruits(int fruitId,String fruitName,int price,int rating){
        this.fruitId=fruitId;
        this.fruitName=fruitName;
        this.price = price;
        this.rating = rating;
    }

    public int getFruitId(){
        return fruitId;
    }

    public String getFruitName(){
        return fruitName;
    }

    public int getPrice(){
        return price;
    }

    public int getRating(){
        return rating;
    }

}

