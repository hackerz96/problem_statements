public class MathOperation27 {
        public static void main(String[] args) {
            try {
                // Check if exactly 5 integers are provided
                if (args.length != 5) {
                    throw new IllegalArgumentException("Please provide exactly 5 integer values.");
                }
    
                int[] numbers = new int[5];
                int sum = 0;
                double average;
    
                // Parse command-line arguments to integers and calculate sum
                for (int i = 0; i < args.length; i++) {
                    numbers[i] = Integer.parseInt(args[i]); // may throw NumberFormatException
                    sum += numbers[i];
                }
    
                // Calculate average (may throw ArithmeticException if array length is 0, but we checked length already)
                average = sum / (double) numbers.length;
    
                // Display results
                System.out.println("Numbers: ");
                for (int num : numbers) {
                    System.out.print(num + " ");
                }
                System.out.println("\nSum = " + sum);
                System.out.println("Average = " + average);
            }
    
            // Handle specific exceptions
            catch (NumberFormatException e) {
                System.out.println("Error: One or more arguments are not valid integers.");
            } catch (ArithmeticException e) {
                System.out.println("Error: Arithmetic error occurred (possibly division by zero).");
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("An unexpected error occurred: " + e);
            }
        }
}
