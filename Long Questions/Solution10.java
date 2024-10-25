/*
 * Create a class NavalVessel with the below attributes:

vesselld – int
vesselName – String
noOfVoyagesPlanned – int
noOfVoyagesCompleted – int
purpose – String


Write getters, setters for the above attributes. Create constructor which takes parameter in the above 
sequence except classification.

Create class Solution with main method. Implement two static methods – findAvgVoyagesByPct and findVesselByGrade 
in Solution class.

findAvgVoyagesByPct method:

This method will take two input parameters -array of NavalVessel objects and int parameter percentage. The method will 
return the average of the noOfVoyagesCompleted attribute from NavalVessel objects which meets the percentage requirement 
as mentioned below.The percentage for each navalVessel is calculated as 
percentage .(noOfVoyagesCompleted * 100)/noOfVoyagesPlanned. If the above calculated percentage is greater than or equal 
to the percentage passed as the parameter, then those objects should participate in the average calculation. If there are 
no objects with the mentioned criteria, then the method should return 0.

findVesselByGrade method:

This method will take a String parameter purpose, along with the array of NavalVessel objects. The method will return the 
NavalVessel object, if the input String parameter matches with the purpose attribute of the NavalVessel object. Before 
returning the object, the classification should be derived as mentioned below. This classification value should be assigned 
to the object before returning. If any of the above conditions are not met, then the method should return null. The 
classification attribute should be calculated based on the percentage calculation mentioned above. 
If the percentage = 100 then classification should be ‘Star’, if percentage is between 99 and 80 then classification should 
be ‘Leader, if percentage is between 79 and 55 then classification should be ‘Inspirer' otherwise the classification should 
be ‘Striver’ If the returned value is null then it should print “No Naval Vessel is available with the specified purpose”.

Before calling these static methods in main, use Scanner object to read the values of four NavalVessel objects referring 
attributes in the above mentioned attribute sequence (except the classification attribute). Next, read the value for 
percentage and purpose.

Input
-------------------
111
Rojer
100
100
Passenger
222
Kalam
200
100
Goods
333
Yashwin
400
300
Army
444
Thanishwini
500
500
Welfare
75
Army

Output
------------------
300
Yashwin%Inspirer
 */

import java.util.*;

public class Solution10 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        NavalVessel[] arr = new NavalVessel[4];
        arr[0] = new NavalVessel(111, "Rojer", 100, 100, "Passenger");
        arr[1] = new NavalVessel(222, "Kalam", 200, 100, "Goods");
        arr[2] = new NavalVessel(333, "Yashwin", 400, 300, "Army");
        arr[3] = new NavalVessel(444, "Thanishwini", 500, 500, "Welfare");

        int input1 = 75;
        int ans1 = findAvgVoyagesByPct(arr,input1);
        System.out.println(ans1);

        String input2 = "Army";
        NavalVessel ans2 = findVesselByGrade(arr,input2);
        if(ans2==null){
            System.out.println("No Naval Vessl is available with the specified purpose");
        }else{
            String param = findParam(checkPercentage(ans2));
            System.out.println(ans2.getVesselName()+"%"+param);
        }


        
    }

    static String findParam(int percentage){
        String ans = "";
        

        if(percentage==100){
            ans="Star";
        }else if(percentage<=99 && percentage>=80){
            ans = "Leader";
        }else if(percentage>=55 && percentage<=79){
            ans = "Inspirer";
        }else{
            ans = "Striver";
        }
        


        return ans;
    }



    static NavalVessel findVesselByGrade(NavalVessel[] arr,String givenPurpose){
        NavalVessel ans = null;

        for(int i = 0;i<arr.length;i++){
            NavalVessel curr = arr[i];
            if(curr.getPurpose().toLowerCase().equals(givenPurpose.toLowerCase())){
                ans = curr;
                break;
            }
        }


        return ans;
    }




    static int findAvgVoyagesByPct(NavalVessel[] arr,int givenPer){
        int ans = 0;
        int count = 0;

        for(int i = 0;i<arr.length;i++){
            NavalVessel curr = arr[i];
            if(checkPercentage(curr)>=givenPer){
                ans+=curr.getnoOfVoyagesCompleted();
                count++;
            }
        }

        return ans/count;
    }

    static int checkPercentage(NavalVessel curr){
        int ans = (curr.getnoOfVoyagesCompleted()*100)/curr.getnoOfVoyagesPlanned();
        return ans;
    }


}


class NavalVessel{

    int vesselId;
    String vesselName;
    int noOfVoyagesPlanned;
    int noOfVoyagesCompleted;
    String purpose;

    public NavalVessel(int vesselId,String vesselName,int noOfVoyagesPlanned,int noOfVoyagesCompleted,String purpose){
        this.vesselId=vesselId;
        this.vesselName=vesselName;
        this.noOfVoyagesPlanned=noOfVoyagesPlanned;
        this.noOfVoyagesCompleted=noOfVoyagesCompleted;
        this.purpose=purpose;
    }

    public int getVesselId(){
        return  vesselId;
    }

    public String getVesselName(){
        return vesselName;
    }

    public int getnoOfVoyagesPlanned(){
        return noOfVoyagesPlanned;
    }

    public int getnoOfVoyagesCompleted(){
        return noOfVoyagesCompleted;
    }

    public String getPurpose(){
        return purpose;
    }

}