import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ErrorHandling37 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 1. File Reading Operation
        System.out.print("Enter file path to read: ");
        String filePath = scanner.nextLine();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            System.out.println("File content:");
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error: File not found at path: " + filePath);
        } catch (IOException e) {
            System.out.println("Error: IO exception occurred while reading the file.");
        }

        // 2. Arithmetic Operation
        try {
            System.out.print("\nEnter numerator: ");
            int numerator = scanner.nextInt();
            System.out.print("Enter denominator: ");
            int denominator = scanner.nextInt();
            int result = numerator / denominator;
            System.out.println("Result: " + result);
        } catch (ArithmeticException e) {
            System.out.println("Error: Cannot divide by zero.");
        } catch (InputMismatchException e) {
            System.out.println("Error: Invalid input. Please enter integers only.");
            scanner.nextLine(); // clear invalid input
        }

        // 3. Array Access
        try {
            int[] arr = {10, 20, 30};
            System.out.print("\nEnter array index to access: ");
            int index = scanner.nextInt();
            System.out.println("Element at index " + index + ": " + arr[index]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error: Index out of bounds. Please enter a valid index (0-2).");
        }

        // 4. Null Pointer Exception
        try {
            String nullStr = null;
            System.out.println("\nLength of null string: " + nullStr.length());
        } catch (NullPointerException e) {
            System.out.println("Error: Attempted to access a method on a null object.");
        }

        System.out.println("\nProgram executed with proper exception handling.");
    }
}
