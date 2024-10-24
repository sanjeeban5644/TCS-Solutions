/*
 * Create a class called Employee with the below attributes:

employeeld - int
name - String
branch - String
rating - double
company Transport - boolean
The above attributes should be private. write getters, setters and parameterized constructor as required.

Create class MyClass with main method.
Implement two static methods findCountOfEmployeesUsingCompTransport and findEmployeeWithSecondHighestRating
in MyClass class.

findCountOfEmployeesUsingCompTransport method: 
----------------------------------------------
This method will take an array of Employee object and a String parameter as input parameters. 
This method will calculate and return the count of Employees who are all using company transport 
in the given branch (String parameter passed).
If no Employee in the given branch using company transport in the array of Employee objects, then 
the method should return 0.

findEmployeeWithSecondHighestRating method: 
--------------------------------------------
This method will take an array of Employee objects as an input parameter. This method will return 
the object of the second highest rating employee from the array of Employee objects who are not using 
company transport.
If all Employees using company transport in the array of Employee objects, then the method should return null.

Note: All the searches should be case sensitive, companyTransport and rating combination of each Employee 
is unique.
For findCountOfEmployeesUsingCompTransport method, The main method should print the returned count as it 
is if the returned value is greater than 0, else it should print "No such Employees".
Ex: 2 , where 2 is the count
For findEmployeeWithSecondHighestRating method: The main method should print the employeeld and name from 
the returned object if the returned value is not null. If the returned value is null, then it should 
print "All Employees using company transport".
Ex: 1003
    Uma
where 1003 is the employeeld and Uma is the name.
Before calling these static methods in main, use Scanner object to read the values of four Employee 
objects referring attributes in the above mentioned attributes sequence. Next, read the value of String
parameter for capturing branch.

Input : 

1001
Ashwa
IT
5
true
1002
Preeti
IT
4
true
1003
Uma
Admin
3
false
1004
Akash
Hardware
4.5
false
IT



Output : 

2
1003
Uma
 */



 import java.util.*;

 public class Solution4 {
     public static void main(String[] args) {
         Scanner in = new Scanner(System.in);
 
         Employee[] arr = new Employee[4];
 
         arr[0] = new Employee(1001, "Ashwa", "IT", 5.0, true);
         arr[1] = new Employee(1002, "Preeti", "IT", 4.0, true);
         arr[2] = new Employee(1003, "Uma", "Admin", 3.0, false);
         arr[3] = new Employee(1004, "Akash", "Hardware", 4.5, false);
         
 
         String input1 = "IT";
 
         int ans1 = findCountOfEmployeesUsingCompTransport(arr,input1);
         if(ans1==0){
             System.out.println("No Employee");
         }else{
             System.out.println("Total Employees: "+ans1);
         }
 
 
         Employee ans2 = findEmployeeWithSecondHighestRating(arr);
         System.out.println(ans2.getEmployeeId()+" "+ans2.getName());
 
 
     }
 
     static Employee findEmployeeWithSecondHighestRating(Employee[] arr){
 
         double highest = 0;
         double secondHighest=0;
 
         Employee ans = null;
 
 
         for(int i = 0;i<arr.length;i++){
             Employee curr = arr[i];
             if(!curr.getCompanyTransport()){
                 if(curr.getRating()>highest){
                     secondHighest=highest;
                     highest=curr.getRating();
                 }else if(curr.getRating()>secondHighest){
                     secondHighest=curr.getRating();
                 }
             }
         }
 
         for(int i = 0;i<arr.length;i++){
             Employee curr = arr[i];
             if(curr.getRating()==secondHighest){
                 ans=curr;
             }
         }
         
         return  ans;
     }
 
 
     static int findCountOfEmployeesUsingCompTransport(Employee[] arr,String input){
 
         int ans = 0;
 
         for(int i = 0;i<arr.length;i++){
             Employee curr = arr[i];
             if(curr.getBranch().toLowerCase().equals(input.toLowerCase())){
                 ans++;
             }
         }
 
 
         return ans;
     }
 
 
 
 
 
 }
 
 
 
 
 
 class Employee{
     int employeeId;
     String name;
     String branch;
     double rating;
     boolean companyTransport;
 
     public Employee(int employeeId, String name, String branch, double rating, boolean companyTransport) {
         this.employeeId = employeeId;
         this.name = name;
         this.branch = branch;
         this.rating = rating;
         this.companyTransport = companyTransport;
     }
 
     public int getEmployeeId() {
         return employeeId;
     }
 
     public String getName() {
         return name;
     }
 
     public String getBranch() {
         return branch;
     }
 
     public double getRating() {
         return rating;
     }
 
     public boolean getCompanyTransport() {
         return companyTransport;
     }
 }
 