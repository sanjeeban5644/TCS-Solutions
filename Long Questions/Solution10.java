import java.util.*;

public class Solution10 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        
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
        this.noOfVoyagesCompleted=noOfVoyagesPlanned;
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