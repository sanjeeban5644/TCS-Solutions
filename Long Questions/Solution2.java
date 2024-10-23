/* 
 * Create a class named "Employee" with the following attributes:

id (int)
name (String)
designation (String)
salary (double)

The above attributes should be private, and the class should have a parameterized constructor to initialize them.

Implement the following methods in the Employee class:

getSalary(): This method should return the salary of the employee.
getDesignation(): This method should return the designation of the employee.

Create a class named "Company" with the following attributes:

companyName (String)
employees (Employee array)
numEmployees (int)

The above attributes should be private, and the class should have a parameterized constructor to initialize them.

Implement the following methods in the Company class:

getAverageSalary(): This method should return the average salary of all the employees in the company.
getMaxSalary(): This method should return the highest salary of all the employees in the company.
getEmployeesByDesignation(String designation): This method should return an array of all employees with the given designation.

In the main method, use a Scanner object to read the values of the company name, number of employees, and the employee details 
(id, name, designation, and salary) in a loop. Once all employee details have been read, create a Company object and pass the 
appropriate parameters. Finally, call the three methods mentioned above and print the output.

Note:

All searches should be case-insensitive.
You may assume that the input is valid and in the correct format.

Sample input:
---------------------
Enter company name: ABC Company
Enter number of employees: 3
Enter employee details:
Employee 1:
Enter id: 101
Enter name: John Smith
Enter designation: Manager
Enter salary: 5000
Employee 2:
Enter id: 102
Enter name: Jane Doe
Enter designation: Engineer
Enter salary: 4000
Employee 3:
Enter id: 103
Enter name: Bob Johnson
Enter designation: Engineer
Enter salary: 4500

Sample Output:
--------------------
Average salary: 4500.0
Max salary: 5000.0
Employees with designation: Engineer
ID: 102, Name: Jane Doe, Designation: Engineer, Salary: 4000.0
ID: 103, Name: Bob Johnson, Designation: Engineer, Salary: 4500.0
 * 
*/





public class Solution2 {
    public static void main(String[] args) {
        Company[] arr = new Company[4];
        arr[0]=new Company("ABC Company",
            new Employee[]{
                new Employee(101,"John Smith","Manager",5000.0),
                new Employee(102,"Jane Doe","Engineer",4000.0),
                new Employee(103,"Bob Johnson","Engineer",4500.0)
            },
        3);

        double ans1 = arr[0].getAverageSalary(arr[0].getEmployees());
        System.out.println(ans1);
        double ans2 = arr[0].getMaxSalary(arr[0].getEmployees());
        System.out.println(ans2);
        Employee[] ans3 = arr[0].getEmployeesByDesignation("Engineer",arr[0].getEmployees());
        for(Employee e : ans3){
            System.out.println(e.getId()+" "+e.getName()+" "+e.getDesignation()+" "+e.getSalary());
        }
    }
}

class Employee {
    private int id;
    private String name;
    private String designation;
    private double salary;

    public Employee(int id, String name, String designation, double salary) {
        this.id = id;
        this.name = name;
        this.designation = designation;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public String getDesignation() {
        return designation;
    }
}

class Company {
    private String companyName;
    private Employee[] employee;
    private int numEmployees;

    public Company(String companyName, Employee[] employee, int numEmployees) {
        this.companyName = companyName;
        this.employee = employee;
        this.numEmployees = numEmployees;
    }

    public Employee[] getEmployees() {
        return employee;
    }

    public double getAverageSalary(Employee[] employee) {
        double ans = 0.0;
        for (int i = 0; i < employee.length; i++) {
            Employee curr = employee[i];
            ans += curr.getSalary();
        }
        return ans / employee.length; 
    }

    public double getMaxSalary(Employee[] employee) {
        double ans = Double.MIN_VALUE;
        for (int i = 0; i < employee.length; i++) {
            Employee curr = employee[i];
            if (curr.getSalary() > ans) {
                ans = curr.getSalary();
            }
        }
        return ans;
    }

    public Employee[] getEmployeesByDesignation(String designation, Employee[] employee) {
        int n = 0;
        for (int i = 0; i < employee.length; i++) {
            Employee curr = employee[i];
            if (curr.getDesignation().toLowerCase().equals(designation.toLowerCase())) {
                n++;
            }
        }
        Employee[] ans = new Employee[n];
        int j = 0;
        for (int i = 0; i < employee.length; i++) {
            Employee curr = employee[i];
            if (curr.getDesignation().toLowerCase().equals(designation.toLowerCase())) {
                ans[j] = curr;
                j++; 
            }
        }
        return ans;
    }
}
