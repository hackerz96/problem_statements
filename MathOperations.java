public class MathOperations {
   
public void cube(int num){
    int cube = num * num * num;
    System.out.println("Cube of " + num + " is: " + cube);
}

public static void square(int num){
    int square = num * num;
    System.out.println("Square of " + num + " is: " + square);
}

    public static void main(String[] args) {

        // calling static method square
        square(4); // Output: Square of 4 is: 16

        // calling instance method cube
         MathOperations mathOps = new MathOperations();
         mathOps.cube(3); // Output: Cube of 3 is: 27

    }
}