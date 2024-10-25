/*
 * Create a class AutonomousCar with the below attributes:

carld – int
brand – String 
noOfTestsConducted – int
noOfTestsPassed- int
environment – String

Write getters, setters for the above attributes . Create constructor which takes parameter in the above sequence 
except grade.

Create class Solution with main method. Implement two static methods – findTestPassedByEnv and updateCarGrade in 
Solution class.

findTestPassedByEnv method:

This method will take two input parameters -array of AutonomousCar objects and string parameter environment. The method 
will return the sum of the noOfTestsPassed attribute from autonomousCar objects for the environment passed as parameter. 
If no autonomousCar with the given environment is present in the array of AutonomousCar objects, then the method should 
return 0.

updateCarGrade method:

This method will take a String parameter brand, along with the array of AutonomousCar objects. The method will return 
the autonomousCar object, if the input String parameter matches with the brand attribute of the autonomousCar object. 
Before returning the object, the grade should be derived based on the rating calculation mentioned below. This grade 
value should be assigned to the object. If any of the above conditions are not met, then the method should return null. 
The grade attribute should be calculated as follows: rating .(noOfTestsPassed * 100)/noOfTestsConducted 
If the rating > = 80 then grade should be ‘A1’, otherwise the grade should be ‘B2’.

The above mentioned static methods should be called from the main method. For findTestPassedByEnv method – The main 
method should print the totalTestPassed as it is, if the returned value is greater than 0, or it should print “There 
are no tests passed in this particular environment”.

For updateCarGrade method – The main method should print the brand and grade of the returned autonomousCar object. 
The brand and grade should be concatinated with :: while printing. eg:- Tesla::A1, where Tesla is the brand and Al 
is the grade.

If the returned value is null then it should print “No Car is available with the specified brand”. Before calling these 
static methods in main, use Scanner object to read the values of four autonomousCar objects referring attributes in the 
above mentioned attribute sequence (except grade attribute). Next, read the value for environment and brand.

Input
----------------
100
Tesla
1000
500
Hills
200
Ford
2000
1500
Desert
300
Royce
3000
1700
Hills
400
Mercedez
1000
400
Desert
Desert
Mercedez

Output
-----------
1900
Mercedez::B2
 */

import java.util.*;

public class Solution7 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        AutonomousCar[] arr = new AutonomousCar[4];
        arr[0] = new AutonomousCar(100, "Tesla", 1000, 500, "Hills");
        arr[1] = new AutonomousCar(200, "Ford", 2000, 1500, "Desert");
        arr[2] = new AutonomousCar(300, "Royce", 3000, 1700, "Hills");
        arr[3] = new AutonomousCar(400, "Mercedez", 1000, 400, "Desert");

        String input1 = "Desert";

        int ans1 = findTestPassedByEnv(arr,input1);
        System.out.println(ans1);

        String input2 = "Mercedez";

        AutonomousCar ans2 = updateCarGrade(arr,input2);
        if(ans2!=null){
            String grade = "";
            int rating = (ans2.getNoOfTestsPassed()*100)/ans2.getNoOfTestsConducted();
            if(rating>=80){
                grade = "A1";
            }else{
                grade = "B2";
            }
            System.out.println(ans2.getBrand()+":"+grade);
        }else{
            System.out.println("No brand found");
        }



        
    }

    static AutonomousCar updateCarGrade(AutonomousCar[] arr,String givenBrand){
        AutonomousCar ans = null;
        
        for(int i = 0;i<arr.length;i++){
            AutonomousCar curr = arr[i];
            if(curr.getBrand().toLowerCase().equals(givenBrand.toLowerCase())){
                ans = curr;
                break;
            }
        }


        return  ans;
    }






    static int findTestPassedByEnv(AutonomousCar[] arr,String givenEnv){
        int ans = 0;
        for(int i = 0;i<arr.length;i++){
            AutonomousCar curr = arr[i];
            if(curr.getEnvironment().toLowerCase().equals(givenEnv.toLowerCase())){
                ans+=curr.getNoOfTestsPassed();
            }
        }
        return ans;
    }


}


class AutonomousCar{
    int carId;
    String brand;
    int noOfTestsConducted;
    int noOfTestsPassed;
    String environment;

    public AutonomousCar(int carId,String brand,int noOfTestsConducted,int noOfTestsPassed,String environment){
        this.carId=carId;
        this.brand=brand;
        this.noOfTestsConducted=noOfTestsConducted;
        this.noOfTestsPassed=noOfTestsPassed;
        this.environment=environment;
    }

    public int getCarId(){
        return carId;
    }

    public String getBrand(){
        return brand;
    }

    public int getNoOfTestsConducted(){
        return noOfTestsConducted;
    }

    public int getNoOfTestsPassed(){
        return noOfTestsPassed;
    }

    public String getEnvironment(){
        return environment;
    }

}