/*
 * Create the class Flowers with below attribute:

flowerId-int;
flowerName-String;
price-int;
rating-int;
type-String;

The above attributes must be private,write getters and setters and parametrized constructor as well.

Create class MyClass with main method.

Implement one static method:findMinPriceByType in MyClass class.

findMinPriceByType Method:

This method will take two input parameters:Array of Flower objects and String parameter.This method will return the minimum 
priced flower object from  array of Flower objects for the given type(String parameter),only if the rating is greater than 
3. If no Flowers with the above conditions are present in the array of the flower objects,then the method will return null.

For this method-The main method  should print the flowerId from the returned object if the returned value is not null.
else it should print "There is no flower with given type".

**********************************************************************

input1:

123
Yellow trout lilly
3000
5
ephemerals
345
snowdrop
2500
4
ephemerals
321
Yarrow
1000
4
perennials
213
red trillium
2250
4
ephemerals
ephemerals



output:

213





**********************

input2:

123

Yellow trout lilly

3000

5

ephemerals

345

snowdrop

2500

4

ephemerals

321

Yarrow

1000

4

perennials

213

red trillium

2250

4

ephemerals

Biennial


output2:

There is no flower with given type.



 */

import java.util.*;


public class Solution13 {
    public static void main(String[] args) {
        Scanner  in = new Scanner(System.in);

        List<Flowers> list = new ArrayList<>();

        list.add(new Flowers(123, "Yellow trout lilly", 3000, 5, "ephemerals"));
        list.add(new Flowers(345, "Snowdrop", 2500, 4, "ephemerals"));
        list.add(new Flowers(321, "Yarrow", 1000, 4, "perennials"));
        list.add(new Flowers(213, "Red trillium", 2250, 4, "ephemerals"));

        String input1 = "Ephemerals";
        Flowers ans = findMinPriceByType(list,input1);
        if(ans!=null){
            System.out.println(ans.getFlowerId());
        }else{
            System.out.println("There is no Flower with given type");
        }

    }

    static Flowers findMinPriceByType(List<Flowers> list,String givenType){
        Flowers ans = null;

        List<Flowers> ansList = new ArrayList<>();

        for(int i = 0;i<list.size();i++){
            Flowers curr = list.get(i);
            if(curr.getType().toLowerCase().equals(givenType.toLowerCase()) && curr.getRating()>3){
                ansList.add(curr);
            }
        }

        if(ansList.size()!=0){
            ansList.sort(Comparator.comparingInt(flowers -> flowers.price));
            ans = ansList.get(0);
        }

        return ans;
    }
}


class Flowers{
    int flowerId;
    String flowerName;
    int price;
    int rating;
    String type;

    public Flowers(int flowerId,String flowerName,int price,int rating,String type){
        this.flowerId=flowerId;
        this.flowerName=flowerName;
        this.price=price;
        this.rating=rating;
        this.type = type;
    }

    public int getFlowerId(){
        return flowerId;
    }

    public String getFlowerName(){
        return flowerName;
    }

    public int getPrice(){
        return price;
    }

    public  int getRating(){
        return rating;
    }

    public String getType(){
        return type;
    }

}