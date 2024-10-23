/*create the class Course with the below Attributes.

courseId- int
courseName- String
courseAdmin- String
quiz- int
handson -int

The above methods should be private ,write getter and
setter and parametrized constructor as required.

create class courseProgram with main method.

implement two static methods-
   findAvgOfQuizByAdmin method:this method will take array
of Course objects and a String  value as input parameters.
This method will find out Average (as int) of Quiz questions
for given Course Admin (String parametre passed)
This method will return Average if found.if there is no course
that matches then the method should return 0.

sortCourseByHandsOn method:
This method will take an Array of Course Objects and int
value as input parameters.
This methods should return an Array of Course objects in an
ascending order of their  handson which are less than the
given handson(int parameter passed) value. if there is no
such course then the method should return null.

The above mentioned static methods should be called from
main methods.

for findAvgOfQuizByAdmin method: The main method
should print the average if the returned value is not 0.
if the returned value is 0 then it should print "No Course
found."


for sortCourseByHandsOn method:
                        the  main method should print the name
of the Course from the returned Course object Array if the
returned value is not null.if the returned value is null then
it should print "No Course found with mentioned attribute."

input1:
111
kubernetes
Nisha
40
10
321
cassandra
Roshini
30
15
457
Apache Spark
Nisha
30
12
987
site core
Tirth
50
20
Nisha
17

output1:
35
kubernetes
Apache Spark
cassandra

input2:
111
kubernetes
Nisha
40
10
321
cassandra
Roshini
30
15
457
Apache Spark
Nisha
30
12
987
site core
Tirth
50
20
Shubhamk
5

output 2:
No Course found
No Course found with mentioned attributes.
*/






import java.util.*;


public class Solution3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        Course[] arr = new Course[4];

        arr[0] = new Course(111, "kubernetes", "Nisha", 40, 10);
        arr[1] = new Course(321, "cassandra", "Roshini", 30, 15);
        arr[2] = new Course(457, "Apache Spark", "Nisha", 30, 12);
        arr[3] = new Course(987, "site core", "Tirth", 50, 20);

        String input1 = "Nisha";

        int ans1 = findAvgOfQuizByAdmin(arr,input1);
        System.out.println(ans1);

        int input2 = 17;

        Course[] ans2 = sortCourseByHandson(arr,input2);
        if(ans2==null){
            System.out.println("No Course found with mentioned attributes");
        }else{

            Arrays.sort(ans2,new Comparator<Course>() {
                @Override
                public int compare(Course c1,Course c2){
                    return Integer.compare(c1.getHandson(),c2.getHandson());
                }
            });



            for(Course course: ans2){
                System.out.println(course.getCourseName());
            }
        }
        

    }

    static Course[] sortCourseByHandson(Course[] arr,int input2){
        int count = 0;
        for(int i = 0;i<arr.length;i++){
            Course curr = arr[i];
            if(curr.getHandson()<input2){
                count++;
            }
        }
        if(count==0) return null;
        int j = 0;
        Course[] ans = new Course[count];
        for(int i = 0;i<arr.length;i++){
            Course curr = arr[i];
            if(curr.getHandson()<input2){
                ans[j]=curr;
                j++;
            }
        }
        return ans;

    }


    static int findAvgOfQuizByAdmin(Course[] arr,String input1){
        int ans = 0;
        int count = 0;

        for(int i = 0;i<arr.length;i++){
            Course curr = arr[i];
            if(curr.getCourseAdmin().toLowerCase().equals(input1.toLowerCase())){
                ans+=curr.getQuiz();
                count++;
            }
        }

        if(ans!=0){
            ans/=count;
            return ans;
        }
        System.out.println("No Course found");
        return 0;
    }




}


class Course{
    int courseId;
    String courseName;
    String courseAdmin;
    int quiz;
    int handson;

    public Course(int courseId,String courseName,String courseAdmin,int quiz,int handson){
        this.courseId=courseId;
        this.courseName=courseName;
        this.courseAdmin=courseAdmin;
        this.quiz=quiz;
        this.handson=handson;
    }

    public String getCourseName(){
        return courseName;
    }

    public String getCourseAdmin(){
        return courseAdmin;
    }

    public int getQuiz(){
        return quiz;
    }

    public int getHandson(){
        return handson;
    }


}