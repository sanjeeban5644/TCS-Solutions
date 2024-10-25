/*
 * create a class Antenna with below attributes.
antennaid=int
antennaName=String
projectLead=String
antennaVSWR=double

the above attribute should be private ,write getter and setter and parametrized constructor as well.

create class MyClass with main method.
implement two static methods searchAntennaByName and sortAntennaByVSWR in MyClass class.


searchAntennaByName :
---------------------------------------
This method will take an array of Antenna objects and the string value as input parameter.The method will find out Antenna name(String parameterpassed).
It will return Antennaid if found.if there is no Antenna that matches then the method will return zero.
The main method should print the antennaid,if the returned value is not 0.if the returned value is 0 then print,"There is no antenna with the given parameter".


sortAntennaByVSWR:
--------------------------------------
This method will take an array of Antenna Objects and a double value as input.
This method will return an array of Antenna objects sorted in ascending orderof their antennaVSWR, which is less than VSWR(double value passed).       

The main method should print name of the project leads from the returned array if the returned value is not null.if the returned value is null then main method 
should print "No Antenna found";


input1:

111
Reconfigurable
Hema
0.4
222
Wearable
Kavya
0.9
333
Microstrip
Teju
0.3
444
Dielectric
Sai
0.65
Microstrip
0.5

output:
333
Teju
Hema


input 2:
111
Reconfigurable
Hema
0.3
222
Wearable
Kavya
0.9
333
Microstrip
Teju
0.4
444
Dielectric
Sai
0.65
Resonator
0.25

output:
There is no antenna with given parameter
No Antenna found
 */

import java.util.*;

public class Solution12 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        List<Antenna> list = new ArrayList<>();

        list.add(new Antenna(111, "Reconfigurable", "Hema", 0.4));
        list.add(new Antenna(222, "Wearable", "Kavya", 0.9));
        list.add(new Antenna(333, "Microstrip", "Teju", 0.3));
        list.add(new Antenna(444, "Dielectric", "Sai", 0.65));

        String input1 = "Resonator";
        Antenna ans1 = searchAntennaByName(list,input1);

        if(ans1==null){
            System.out.println("There is no antenna with the given parameter");
        }else{
            System.out.println(ans1.getAntennaId());
        }

        

        double input2 = 0.25;
        List<Antenna> ans2 = sortAntennaByVSWR(list,input2);
        if(ans2.size()==0){
            System.out.println("No Antenna Found");
        }else{
            ans2.sort(Comparator.comparingDouble(antenna -> antenna.antennaVSWR));

            for(Antenna curr : ans2){
                System.out.println(curr.getProjectLead());
            }
        }
       


    }

    static List<Antenna> sortAntennaByVSWR(List<Antenna> list, double givenVSWR){
        List<Antenna> ans = new ArrayList<>();

        for(int i = 0;i<list.size();i++){
            Antenna curr = list.get(i);
            if(curr.getAntennaVSWR()<givenVSWR){
                ans.add(curr);
            }
        }

        return ans;
    }

    static Antenna searchAntennaByName(List<Antenna> list,String givenName){
        Antenna ans = null;

        for(int i = 0;i<list.size();i++){
            Antenna curr = list.get(i);
            if(curr.getAntennaName().toLowerCase().equals(givenName.toLowerCase())){
                ans = curr;
                break;
            }
        }


        return ans;
    }
}

class Antenna{
    int  antennaId;
    String antennaName;
    String projectLead;
    double antennaVSWR;

    public Antenna(int antennaId,String antennaName,String projectLead,double antennaVSWR){
        this.antennaId=antennaId;
        this.antennaName=antennaName;
        this.projectLead=projectLead;
        this.antennaVSWR=antennaVSWR;
    }

    public int getAntennaId(){
        return antennaId;
    }

    public String getAntennaName(){
        return antennaName;
    }

    public String getProjectLead(){
        return projectLead;
    }

    public double getAntennaVSWR(){
        return antennaVSWR;
    }

}