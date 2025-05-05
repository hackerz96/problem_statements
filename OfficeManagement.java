
abstract class Employee{
    String name;
    int id;
    double basicSalary;

    abstract double calculateSalary();
    abstract void displayDetails();
    public Employee(String name, int id, double basicSalary) {
        this.name = name;
        this.id = id;
        this.basicSalary = basicSalary;
    }
}

class Manager extends Employee{
    double bonus;

    public Manager(String name, int id, double basicSalary, double bonus){
        super(name, id, basicSalary);
        this.bonus = bonus;
    }
    @Override
    double calculateSalary() {
        return basicSalary + bonus;
    }

    @Override
    void displayDetails() {
        System.out.println("Manager Name: " + name);
        System.out.println("ID: " + id);
        System.out.println("Basic Salary: " + basicSalary);
        System.out.println("Bonus: " + bonus);
        System.out.println("Total Salary: " + calculateSalary());
    }
}

class Developer extends Employee{
    double projectAllowance;

    public Developer(String name, int id, double basicSalary, double projectAllowance){
        super(name, id, basicSalary);
        this.projectAllowance = projectAllowance;
    }

    @Override
    double calculateSalary() {
        return basicSalary + projectAllowance;
    }

    @Override
    void displayDetails(){
        System.out.println("Developer Name: " + name);
        System.out.println("ID: " + id);
        System.out.println("Basic Salary: " + basicSalary);
        System.out.println("Project Allowance: " + projectAllowance);
        System.out.println("Total Salary: " + calculateSalary());
    }
}



public class OfficeManagement {
    public static void main(String[] args) {
        Employee manager = new Manager("Shreeman Legend", 123, 59000, 4500);
        Employee developer = new Developer("Karnu Shinde", 4545, 45000, 3000);

        manager.displayDetails();
        System.out.println();
        developer.displayDetails();
        System.out.println();

        System.out.println("Polymorphism Demonstration:");
        System.out.println("Manager's salary: " + manager.calculateSalary());
        System.out.println("Developer's salary: " + developer.calculateSalary());
    }
}
