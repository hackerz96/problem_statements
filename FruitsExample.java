class Fruits{
    String name;
    String taste;
    String size;

    // constructor
    public Fruits(String name, String tase, String size) {
        this.name = name;
        this.taste = tase;
        this.size = size;
    }

    //methods
    public void eat(){}
}

class Apple extends Fruits{

    // constructor
    public Apple(String name, String taste, String size) {
        super(name, taste, size);
    }
    @Override
    public void eat() {
        System.out.println("Eating " + name + " which is " + taste + " in taste.");
    }
}

class Orange extends Fruits{

    // constructor
    public Orange(String name, String taste, String size) {
        super(name, taste, size);
    }
    @Override
    public void eat() {
        System.out.println("Eating " + name + " which is " + taste + " in taste.");
    }
}

public class FruitsExample {
    public static void main(String[] args) {
        Fruits apple = new Apple("Apple", "Sweet", "Medium");
        Fruits orange = new Orange("Orange", "Sour", "Medium");

        apple.eat(); // Output: Eating Apple which is Sweet in taste.
        orange.eat(); // Output: Eating Orange which is Sour in taste.
    }
}
