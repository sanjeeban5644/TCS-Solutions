import java.util.*;

public class Solution9 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        Phone[] arr = new Phone[4];

        arr[0] = new Phone(111, "iOS", "Apple", 30000);
        arr[1] = new Phone(222, "Android", "Samsung", 50000);
        arr[2] = new Phone(333, "Symbian", "HTC", 12000);
        arr[3] = new Phone(444, "Paranoid", "HTC", 89000);

        String input1 = "HTC";
        int ans1 = findPriceForGivenBrand(arr,input1);
        if(ans1==0){
            System.out.println("The given phone brand is not present");
        }else{
            System.out.println(ans1);
        }

        String input2 = "Android";
        Phone ans2 = getPhoneIdBasedOnOs(arr,input2);
        System.out.println(ans2.getPhoneId());





    }

    static Phone getPhoneIdBasedOnOs(Phone[] arr,String givenOs){
        Phone ans = null;

        for(int i = 0;i<arr.length;i++){
            Phone curr = arr[i];
            if(curr.getOs().toLowerCase().equals(givenOs.toLowerCase()) && curr.getPrice()>=50000){
                ans = curr;
            }
        }

        return  ans;
    }





    static int findPriceForGivenBrand(Phone[] arr,String givenBrand){
        int ans = 0;

        for(int i = 0;i<arr.length;i++){
            Phone curr = arr[i];
            if(curr.getBrand().toLowerCase().equals(givenBrand.toLowerCase())){
                ans+=curr.getPrice();
            }
        }

        return  ans;
    }




}


class Phone{
    int phoneId;
    String os;
    String brand;
    int price;

    public Phone(int phoneId,String os,String brand,int price){
        this.phoneId=phoneId;
        this.os=os;
        this.brand=brand;
        this.price=price;
    }

    public int getPhoneId(){
        return phoneId;
    }

    public String getOs(){
        return os;
    }

    public String getBrand(){
        return brand;
    }

    public int getPrice(){
        return price;
    }
}