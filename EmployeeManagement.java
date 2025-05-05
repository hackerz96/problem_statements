import java.util.ArrayList;

class Employee {
    int empID;
    String empName;
    String email;
    String gender;
    float salary;

    public Employee(int empID, String empName, String email, String gender, float salary) {
        this.empID = empID;
        this.empName = empName;
        this.email = email;
        this.gender = gender;
        this.salary = salary;
    }

    public void getEmployeeDetails() {
        System.out.println("Employee ID: " + empID);
        System.out.println("Employee Name: " + empName);
        System.out.println("Email: " + email);
        System.out.println("Gender: " + gender);
        System.out.println("Salary: " + salary);
        System.out.println();
    }
}

class EmployeeDB {
    ArrayList<Employee> list = new ArrayList<>();

    boolean addEmployee(Employee e) {
        return list.add(e);
    }

    boolean deleteEmployee(int empID) {
        for (Employee e : list) {
            if (e.empID == empID) {
                return list.remove(e);
            }
        }
        return false;
    }

    String showPaySlip(int empID) {
        for (Employee e : list) {
            if (e.empID == empID) {
                return "Pay Slip for Employee ID: " + empID + "\n" +
                       "Name: " + e.empName + "\n" +
                       "Salary: " + e.salary + "\n" ;
            }
        }
        return "Employee not found.";
    }
}

public class EmployeeManagement {
    public static void main(String[] args) {
        EmployeeDB db = new EmployeeDB();

        Employee emp1 = new Employee(101, "Jagannath Gondo", "jagannath@gmail.com", "male", 50000);
        Employee emp2 = new Employee(102, "Yasmin Walia", "yasminw@gmail.com", "female", 60000);
        Employee emp3 = new Employee(103, "Ravi Kumar", "ravikumar@gmail.com", "male", 55000);

        db.addEmployee(emp1);
        db.addEmployee(emp2);
        db.addEmployee(emp3);

        System.out.println("Added Employees:");
        emp1.getEmployeeDetails();
        emp2.getEmployeeDetails();
        emp3.getEmployeeDetails();
        System.out.println();

        System.out.println("Pay Slips:");
        System.out.println(db.showPaySlip(101));
        System.out.println(db.showPaySlip(102));
        System.out.println(db.showPaySlip(103));
        System.out.println();

        db.deleteEmployee(102);
        System.out.println("Deleted Employee with ID 102");

        System.out.println(db.showPaySlip(102)); 
    }
}
