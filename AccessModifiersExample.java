class Person {
    private String name;         // private
    public int age;              // public
    protected String address;    // protected
    String phoneNumber;          // default (package-private)

    // Constructor
    public Person(String name, int age, String address, String phoneNumber) {
        this.name = name;
        this.age = age;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    // Public method to display details
    public void displayDetails() {
        System.out.println("Name: " + name); // Can access private within class
        System.out.println("Age: " + age);
        System.out.println("Address: " + address);
        System.out.println("Phone Number: " + phoneNumber);
    }

    // Public method to update phone number
    public void updatePhoneNumber(String newPhoneNumber) {
        this.phoneNumber = newPhoneNumber;
    }
}

class Employee extends Person {
    public String employeeId; // public attribute

    // Constructor
    public Employee(String name, int age, String address, String phoneNumber, String employeeId) {
        super(name, age, address, phoneNumber);
        this.employeeId = employeeId;
    }

    // Overridden method
    @Override
    public void displayDetails() {
        super.displayDetails(); // Call parent's display method
        System.out.println("Employee ID: " + employeeId);
    }

    public void accessInheritedAttributes() {
        System.out.println("\n[Inside Employee subclass]");
        //System.out.println("Name: " + name);           //  private (not accessible)
        System.out.println("Age: " + age);             //  public
        System.out.println("Address: " + address);     //  protected
        System.out.println("Phone Number: " + phoneNumber); // default (same package)
    }
}

public class AccessModifiersExample {
    public static void main(String[] args) {
        Employee emp = new Employee("John Doe", 30, "123 Main St", "555-1234", "E12345");

        // Accessing public method
        emp.displayDetails();

        // Accessing attributes from outside the class
        System.out.println("\n[Inside main()]");
        System.out.println("Accessing public age: " + emp.age);       
        System.out.println("Accessing public employeeId: " + emp.employeeId); 
        System.out.println();

        // System.out.println("Accessing private name: " + emp.name); 
        // System.out.println("Accessing protected address: " + emp.address); 
        // System.out.println("Accessing default phoneNumber: " + emp.phoneNumber); 

        // Update phone number using public method
        System.out.println("Details after updating phone number:");
        emp.updatePhoneNumber("999-9999");
        emp.displayDetails();

        // Demonstrate subclass access
        emp.accessInheritedAttributes();
    }
}
