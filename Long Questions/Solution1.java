/*
 * Create a class Employee with below attributes:

employeeId - int
employeeName - String
age - int
gender - char
salary - double

where employeeId is the unique identifier of the employee, employeeName is the name of the employee, age is the age of 
the employee, gender is the gender of the employee and salary is the salary of the employee.

The above attributes should be private, write getters, setters and parameterized constructor as required.

Create class Solution with main method.
Implement two static methods - getEmployeeWithSecondLowestSalary and countEmployeesBasedOnAge in Solution class.

getEmployeeWithSecondLowestSalary method:
This method will take an array of Employee objects as a parameter.
The method will return the Employee object with the second lowest salary in the array of Employee objects.
If there are less than two employees in the array, then the method should return null.

countEmployeesBasedOnAge method:
This method will take two input parameters - array of Employee objects and an integer parameter (for age).
The method will return the count of employees from the array of Employee objects whose age matches with the input 
parameter.
If no employee with the given age is present in the array of Employee objects, then the method should return 0.

Note :

Two employee objects can have the same salary.
All the searches should be case insensitive.

The above mentioned static methods should be called from the main method.

For getEmployeeWithSecondLowestSalary method - The main method should print the employeeId followed by # and employeeName
from the returned Employee object, if the returned value is not null.

If the returned value is null then it should print "Null".

For countEmployeesBasedOnAge method - The main method should print the count of employees as it is, if the returned value
is greater than 0, otherwise it should print "No employee found for the given age".

Before calling these static methods in main, use Scanner to read the number of objects and objects to read the values of 
Employee objects referring attributes in the above mentioned attribute sequence.

Consider below sample input and output:

Input:
-------------
4
101
John
30
M
10000.00
102
Samantha
25
F
15000.00
103
Alex
28
M
12000.00
104
Lisa
30
F
15000.00
30

Output:
----------------
103#Alex
2
 */






 import java.util.*;

 public class Solution1 {
     public static void main(String[] args) {
         Scanner in = new Scanner(System.in);
         int n = 4;
         Employee[] arr = new Employee[n];
         arr[0]=new Employee(101,"John",30,'M',10000.00);
         arr[1]=new Employee(102,"Samantha",25,'F',15000.00);
         arr[2]=new Employee(103,"Alex",28,'M',12000.00);
         arr[3]=new Employee(104,"Lisa",30,'F',15000.00);
 
         Employee ans1 = getEmployeeWithSecondLowestSalary(arr);
         System.out.println(ans1.getId()+"#"+ans1.getName());
 
         int ans2 = countEmployeesBasedOnAge(arr,30);
         System.out.println(ans2);
 
     }
 
     public static int countEmployeesBasedOnAge(Employee[] arr,int givenAge){
 
         int count = 0;
         for(int i = 0;i<arr.length;i++){
             Employee curr = arr[i];
             if(curr.getAge()==givenAge){
                 count++;
             }
         }
 
 
 
 
         return count;
     }
 
 
 
 
 
     public static Employee getEmployeeWithSecondLowestSalary(Employee[] arr){
 
         Employee ans = null;
 
         double smallest = Double.MAX_VALUE;
 
         for(int i = 0;i<arr.length;i++){
             Employee curr = arr[i];
             if(curr.getSalary()<smallest){
                 smallest = curr.getSalary();
             }
         }
         //System.out.println("Smallest: "+smallest);
         
         int diff = Integer.MAX_VALUE;
         for(int i = 0;i<arr.length;i++){
             Employee curr = arr[i];
             if(curr.getSalary()!=smallest){
                 int d = (int)(curr.getSalary()-smallest);
                 if(d<diff){
                     
                     ans = curr;
                     diff=d;
                 }
             }
         }
         return ans;
     }
 
 }
 
 
 
 
 
 class Employee{
     private int employeeId;
     private String employeeName;
     private int age;
     private char gender;
     private double salary;
 
     public Employee(int employeeId,String employeeName,int age,char gender,double salary){
         this.employeeId=employeeId;
         this.employeeName=employeeName;
         this.age=age;
         this.gender=gender;
         this.salary=salary;
     }
 
     public int getId(){
         return employeeId;
     }
 
     public  String getName(){
         return employeeName;
     }
 
     public int getAge(){
         return age;
     }
 
     public char getGender(){
         return gender;
     }
 
     public double getSalary(){
         return salary;
     }
 
 
 
 }
