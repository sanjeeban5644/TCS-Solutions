/*
 * Create class Associate with below attributes:
id - int
name - String
technology - String
experienceInYears - int

Create class Solution and implement static method "associatesForGivenTechnology" in the Solution class.
This method will take array of Associate objects and a searchTechnology String as parameters.
And will return another array of Associate objects where the searchTechnology String matches with the original array of 
Associate object's technology attribute (case insensitive search) and experienceInYears attribute should be multiples of 5.

Write necessary getters and setters.

Before calling "associatesForGivenTechnology" method in the main method, read values for five associate objects referring 
the attributes in above sequence along with a String searchTechnology.
Then call the "associatesForGivenTechnology" method and write the logic to print the id's in the main method.

Input
-----------------
101
Alex
Java
15
102
Albert
Unix
20
103
Alferd
Testing
13
104
Alfa
Java
15
105
Almas
Java
29
Java

Output
------------------
101
104
 */



import java.util.*;


public class Solution17 {
    public static void main(String[] args) {
        Scanner  in = new Scanner(System.in);

        List<Associate> list = new ArrayList<>();

        list.add(new Associate(101, "Alex", "Java", 15));
        list.add(new Associate(102, "Albert", "Unix", 20));
        list.add(new Associate(103, "Alferd", "Testing", 13));
        list.add(new Associate(104, "Alfa", "Java", 15));
        list.add(new Associate(105, "Almas", "Java", 29));

        String input = "java";
        List<Associate> ans = associatesForGivenTechnology(list,input);
        if(ans.isEmpty()){
            System.out.println("No information");
        }else{
            for(Associate ass : ans){
                System.out.println(ass.getId());
            }
        }


    }

    static List<Associate> associatesForGivenTechnology(List<Associate> list,String givenTechnology){
        List<Associate> ansList = new ArrayList<>();

        for(int i = 0;i<list.size();i++){
            Associate curr = list.get(i);
            if(curr.getTechnology().toLowerCase().equals(givenTechnology.toLowerCase()) && curr.getExperienceInYears()%5==0){
                ansList.add(curr);
            }
        }


        return ansList;
    }


}


class Associate{
    int id;
    String name;
    String technology;
    int experienceInYears;

    public Associate(int id,String name,String technology,int experienceInYears){
        this.id = id;
        this.name = name;
        this.technology = technology;
        this.experienceInYears = experienceInYears;
    }

    public int getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public String getTechnology(){
        return technology;
    }

    public int getExperienceInYears(){
        return experienceInYears;
    }


}