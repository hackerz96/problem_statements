abstract class Person {
    private String name;
    private int age;

    public Person(String name, int age){
        this.name = name;
        this.age = age;
    }

    public String getName(){
        return name;
    }
    public int getAge(){
        return age;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setAge(int age){
        this.age = age;
    }

    abstract void displayDetails();
}

class Student extends Person {
    private int rollNumber;
    private String course;

    public Student(String name, int age, int rollNumber, String course){
        super(name, age);
        this.rollNumber = rollNumber;
        this.course = course;
    }

    public int getRollNumber(){
        return rollNumber;
    }
    public String getCourse(){
        return course;
    }
    public void setRollNumber(int rollNumber){
        this.rollNumber = rollNumber;
    }
    public void setCourse(String course){
        this.course = course;
    }

    @Override
    void displayDetails(){
        System.out.println("Student Name: " + getName());
        System.out.println("Age: " + getAge());
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Course: " + course);
    }
}

class Teacher extends Person {
    private int employeeId;
    private String subject;

    public Teacher(String name, int age, int employeeId, String subject){
        super(name, age);
        this.employeeId = employeeId;
        this.subject = subject;
    }

    public int getEmployeeId(){
        return employeeId;
    }
    public String getSubject(){
        return subject;
    }
    public void setEmployeeId(int employeeId){
        this.employeeId = employeeId;
    }
    public void setSubject(String subject){
        this.subject = subject;
    }

    @Override
    void displayDetails(){
        System.out.println("Teacher Name: " + getName());
        System.out.println("Age: " + getAge());
        System.out.println("Employee ID: " + employeeId);
        System.out.println("Subject: " + subject);
    }
}

public class PersonInfo38 {
    public static void main(String[] args) {
        Person[] personArray = new Person[2];
        personArray[0] = new Student("Johnny Jasus", 20, 101, "Computer Science");
        personArray[1] = new Teacher("Roronoa Zoro", 35, 201, "Swordsmanship");

        for (Person person : personArray) {
            person.displayDetails();
            System.out.println();
        }
    }
}
