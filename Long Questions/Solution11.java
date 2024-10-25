/*
 * Create a class Student with below attributes:

rollNo - int
name - String
subject - String
grade - char
date - String [DD/MM/YYYY]



The above attributes should be private.Write Getter and Setter and parametrized constructor as required.


Create class Solution with main method.
****************************************************************************
Implement one static method: findStudentByGradeAndMonth Solution Class.


findStudentByGradeAndMonth Method:

This method will take an array of Student objects, char value as grade and int value as month 
for input parameters.The method will find out all Students from the given grade and month. 
This method will return array of Student object assending based on their rollNo if found. 
If there is no Student that matches then the method should return null.

for this method- main method should print Student name, subject and total student found [The 
length of the list], if the returned value is not null. If the returned value is null then 
main method should print "No student found".


NOTE:
	1. For Taking char as input use sc.nextLine().charAt(0)
	2. To match/check the month You havee to convert int month in the parameter to String.
	3. No need to count the Student array if return not null just print the array length.


****************************************************************************



Consider the below input and output:


input1:

111
Arijit
Math
B
22/09/2023
101
Priyanka
English
A
30/03/2022
107
Shreosi
History
C
13/05/2022
105
Tatan
Physics
A
27/03/2022
A
3


output1:

Priyanka
English
Tatan
Physics
2





input2:

111
Sohel
Math
B
22/09/2022
101
Priyanka
English
A
30/03/2022
107
Gopa
History
C
12/05/2022
105
Kamal
Physics
A
27/03/2022
A
7



output 2:

No student found
 */

import java.util.*;

public class Solution11 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        Student[] arr = new Student[4];

        arr[0] = new Student(111, "Arijit", "Math", 'B', "22/09/2023");
        arr[1] = new Student(101, "Priyanka", "English", 'A', "30/03/2022");
        arr[2] = new Student(107, "Shreosi", "History", 'C', "13/05/2022");
        arr[3] = new Student(105, "Tatan", "Physics", 'A', "27/03/2022");

        char input1 = 'A';
        int input2 = 7;

        List<Student> ans = findStudentByGradeAndMonth(arr,input1,input2);
        if(ans.size()!=0){
            ans.sort(Comparator.comparingInt(student -> student.rollNo));
            for(int i = 0;i<ans.size();i++){
                System.out.println(ans.get(i).getName()+" "+ans.get(i).getSubject());
            }
        }else{
            System.out.println("No Student Found");
        }


    }

    static List<Student> findStudentByGradeAndMonth(Student[] arr,char givenGrade,int givenMonth){
        List<Student> list = new ArrayList<>();

        for(int i = 0;i<arr.length;i++){
            Student curr = arr[i];
            if(curr.getGrade()==givenGrade && curr.getMonth()==givenMonth){
                list.add(curr);
            }
        }



        return list;
    }





}


class Student{
    int rollNo;
    String name;
    String subject;
    char grade;
    String date;

    public Student(int rollNo,String name,String subject,char grade,String date){
        this.rollNo=rollNo;
        this.name=name;
        this.subject=subject;
        this.grade=grade;
        this.date = date;
    }

    public int getRollNo(){
        return rollNo;
    }

    public String getName(){
        return name;
    }

    public String getSubject(){
        return subject;
    }

    public char getGrade(){
        return grade;
    }

    public String getDate(){
        return date;
    }
    
    public int getMonth(){
        String month = this.getDate().substring(3,5);
        int thisMonth = Integer.parseInt(month);
        return thisMonth; 
    }

}