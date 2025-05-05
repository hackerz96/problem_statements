import java.util.ArrayList;
import java.util.List;

// base class
abstract class Staff{
    String name;
    int id;
    double salary;

    public Staff(String name, int id, double salary){
        this.name = name;
        this.id = id;
        this.salary = salary;   
    }

    abstract void displayInfo(); // abstract method to be implemented by subclasses
    abstract double calculateBonus(); // abstract method to be implemented by subclasses
    abstract void displaySalary(); // abstract method to be implemented by subclasses
    abstract void promote(); // abstract method to be implemented by subclasses

}

// derived classes

class Professor extends Staff{
    String Department;
    String subject;

    public Professor(String name, int id, double salary, String Department, String subject){
        super(name, id, salary);
        this.Department = Department;
        this.subject = subject;
    }

    @Override
    void displayInfo() {
        System.out.println("Professor Name: " + name);
        System.out.println("ID: " + id);
        System.out.println("Department: " + Department);
        System.out.println("Subject: " + subject);
    }

    @Override
    double calculateBonus() {
        return salary * 0.1; // 10% bonus
    }

    @Override
    void displaySalary() {
        System.out.println("Salary: " + salary);
    }

    @Override
    void promote() {
        System.out.println("Professor " + name + " has been promoted.");
    }
}

class AdministrativeStaff extends Staff{
    String role;

    public AdministrativeStaff(String name, int id, double salary, String role){
        super(name, id, salary);
        this.role = role;
    }

    @Override
    void displayInfo() {
        System.out.println("Administrative Staff Name: " + name);
        System.out.println("ID: " + id);
        System.out.println("Role: " + role);
    }

    @Override
    double calculateBonus() {
        return salary * 0.05; // 5% bonus
    }

    @Override
    void displaySalary() {
        System.out.println("Salary: " + salary);
    }

    @Override
    void promote() {
        System.out.println("Administrative Staff " + name + " has been promoted.");
    }
}

class MaintenanceStaff extends Staff{
    int yearsOfService;

    public MaintenanceStaff(String name, int id, double salary, int yearsOfService){
        super(name, id, salary);
        this.yearsOfService = yearsOfService;
    }

    @Override
    void displayInfo() {
        System.out.println("Maintenance Staff Name: " + name);
        System.out.println("ID: " + id);
        System.out.println("Years of Service: " + yearsOfService);
    }

    @Override
    double calculateBonus() {
        return salary * 0.03; // 3% bonus
    }

    @Override
    void displaySalary() {
        System.out.println("Salary: " + salary);
    }

    @Override
    void promote() {
        System.out.println("Maintenance Staff " + name + " has been promoted.");
    }
}


public class UniversityStaffMangaementSystem {
    public static void main(String[] args) {
        List<Staff> staffList = new ArrayList<>();
        staffList.add(new Professor("Dr. Meena", 101, 90000, "Physics", "Quantum Mechanics"));
        staffList.add(new AdministrativeStaff("Mr. Arjun", 201, 50000, "Accounts Officer"));
        staffList.add(new MaintenanceStaff("Mr. Ramesh", 301, 35000, 10));

        // loop to demonstrate polymorphism
        for (Staff staff : staffList) {
            staff.displayInfo();
            staff.displaySalary();
            System.out.println("Bonus: " + staff.calculateBonus());
            staff.promote();
            System.out.println("-----------------------------");
        }
    }
}
