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