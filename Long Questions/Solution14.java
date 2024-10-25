/*
 * create a class Footwear which consists of the below attributes.
  footwearId=int
  footwearName=String
  footwearType=String
  price =int

the above attributes should be private.
write getter and setter and parametrised constructor as required.

create the class footwearProgrammm with the main method.
implement the 2 static methods.getCountByType and
getSecondHighestPriceByBrand in the Solution class.


getCountByType method:
   this method will take two input parameters.
array of the Footwear objects and string parameter footwear type.
this method will return the count of the footwears from array of the
footwear objects for the given type of footwear.
if no footwear with the given footwear type is found in the
array of footwear abjects,then the method should return 0.



getSecondHighestPriceByBrand method:
  this method will take 2 input parameters-array of footwear objects and string parameter inputFootwearName.the method
will return the second highest footwear objects based on the price from the array of the Footwear objects


whose brand name matches with the input string parameter.


if no footwear with the given brand is present in the array of the footwear objects,the the method
should return null.

NOTE: no two footwear objects would have the same footwearId.All the searches should be case insensitive.
the above mentioned static methods should be called from the main method.

for getCountByType method- the main method should print the count of the footwears ,if the returned value
is greater than zero. or it should print "Footwear not available";

for getSecondHighestPriceByBrand method-The main method should print price from the returned footwear objects


if the returned footwear object is not null.else it should print "Brand not available".
for example.
112
ABC
25555
  where 112 is the footwear id,ABC is brand name,25555 is price.

consider the sample input and output.
100
Sketchers
sneekers
12345
103
Puma
running shoes
10099
102
reebok
Running shoes
5667
101
Reebok
running shoes
5656
99
reebok
floaters
5666
Running shoes
reebok

Sample output:
3
99
reebok
5666

Sample input2:

100
Puma
sneekers
12345
101
Puma
sneekers
10099
102
Puma
sneekers
5000
102
Reebok
sneekers
8000
104
Puma
floaters
2000
running shoes
bata

Sample output:
Footwear not available
Brand not available
 */

import java.util.*;


public class Solution14 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        List<Footwear> list = new ArrayList<>();

        list.add(new Footwear(100, "Sketchers", "sneakers", 12345));
        list.add(new Footwear(103, "Puma", "running shoes", 10099));
        list.add(new Footwear(102, "Reebok", "running shoes", 5667));
        list.add(new Footwear(101, "Reebok", "running shoes", 5656));
        list.add(new Footwear(99, "Reebok", "floaters", 5666));

        String input1 = "Running shoes";
        int ans1 = getCountByType(list,input1);
        if(ans1==0){
            System.out.println("No available footwear");
        }else{
            System.out.println(ans1);
        }

        String input2 = "reebok";
        Footwear ans2 = getSecondHighestPriceByBrand(list,input2);
        if(ans2!=null){
            System.out.println(ans2.getFootwearId()+" "+ans2.getFootwearName()+" "+ans2.getPrice());
        }else{
            System.out.println("No available footwear");
        }



    }

    static Footwear getSecondHighestPriceByBrand(List<Footwear> list,String givenFootwearName){
        Footwear highest = null;
        Footwear secondHighest = null;


        list.sort(Comparator.comparingInt(footwear -> footwear.price));

        for(int i = 0;i<list.size();i++){
            Footwear curr = list.get(i);
            if(curr.getFootwearName().toLowerCase().equals(givenFootwearName.toLowerCase())){
                
                if(highest==null){
                    highest = curr;
                    secondHighest = curr;
                }
                //System.out.println(curr.getFootwearId()+" "+curr.getFootwearName()+" "+curr.getPrice());
                if(curr.getPrice()>highest.getPrice()){
                    secondHighest = highest;
                    highest = curr;
                }else if(curr.getPrice()>secondHighest.getPrice()){
                    secondHighest = curr;
                }
            }
        }
            return secondHighest;
    }





        
    



    static int getCountByType(List<Footwear> list,String givenType){
        int count = 0;

        for(int i = 0;i<list.size();i++){
            Footwear curr = list.get(i);
            if(curr.getFootwearType().toLowerCase().equals(givenType.toLowerCase())){
                count++;
            }
        }


        return count;
    }
}


class Footwear{
    int footwearId;
    String footwearName;
    String footwearType;
    int price; 


    public Footwear(int footwearId,String footwearName,String footwearType,int price){
        this.footwearId = footwearId;
        this.footwearName = footwearName;
        this.footwearType = footwearType;
        this.price = price;
    }

    public int getFootwearId(){
        return footwearId;
    }

    public String getFootwearName(){
        return footwearName;
    }

    public String getFootwearType(){
        return footwearType;
    }

    public int getPrice(){
        return price; 
    }

}