/*
 * Create class Medicine with below attributes: 

MedicineName - String 
batch - String 
disease - String 
price - int

Create class Solution and implement static method "getPriceByDisease" in the Solution class. 
This method will take array of Medicine objects and a disease String as parameters. 
And will return another sorted array of Integer objects where the disease String matches with the 
original array of Medicine object's disease attribute (case insensitive search).

Write necessary getters and setters.

Before calling "getPriceByDisease" method in the main method, read values for four Medicine objects 
referring the attributes in above sequence along with a String disease. Then call the "getPriceByDisease" 
method and print the result.

Input
-------------

dolo650
FAC124W
fever
100
paracetamol
PAC545B
bodypain
150
almox
ALM747S
fever
200
aspirin
ASP849Q
flu
250
fever

Output
---------
100
200
 */

import java.util.*;

public class Solution6 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        Medicine[] arr = new Medicine[4];

        arr[0] = new Medicine("Dolo650", "FAC124W", "Fever", 100);
        arr[1] = new Medicine("Paracetamol", "PAC545B", "Body Pain", 150);
        arr[2] = new Medicine("Almox", "ALM747S", "Fever", 200);
        arr[3] = new Medicine("Aspirin", "ASP849Q", "Flu", 250);

        String input1 = "Fever";

        Medicine[] ans = getPriceByDisease(arr,input1);
        Arrays.sort(ans,new Comparator<Medicine>(){
            @Override
            public int compare(Medicine m1,Medicine m2){
                return m1.getMedicineName().compareTo(m2.getMedicineName());
            }
        });

        for(Medicine m : ans){
            System.out.println(m.getMedicineName()+" "+m.getPrice());
        }


    }

    static Medicine[] getPriceByDisease(Medicine[] arr,String givenDisease){
        int count = 0;
        for(int i = 0;i<arr.length;i++){
            Medicine curr = arr[i];
            if(curr.getDisease().toLowerCase().equals(givenDisease.toLowerCase())){
                count++;
            }
        }

        Medicine[] ans = new Medicine[count];
        int j = 0;
        for(int i = 0;i<arr.length;i++){
            Medicine curr = arr[i];
            if(curr.getDisease().toLowerCase().equals(givenDisease.toLowerCase())){
                ans[j]=curr;
                j++;
            }
        }
        



        return ans;
    }




}


class Medicine{
    String medicineName;
    String batch;
    String disease;
    int price;

    public Medicine(String medicineName,String batch,String disease,int price){
        this.medicineName=medicineName;
        this.batch=batch;
        this.disease=disease;
        this.price=price;
    }

    public String getMedicineName(){
        return medicineName;
    }

    public String getBatch(){
        return batch;
    }

    public String getDisease(){
        return disease;
    }

    public int getPrice(){
        return price;
    }
}