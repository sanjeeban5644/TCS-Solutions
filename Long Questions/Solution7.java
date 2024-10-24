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