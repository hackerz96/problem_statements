import java.util.ArrayList;
import java.util.Iterator;

public class ArrayListProgram {

    public static void main(String[] args) {

        ArrayList<Integer> numbers = new ArrayList<>();

        // Adding numbers 1 to 25
        for (int i = 1; i <= 25; i++) {
            numbers.add(i);
        }

        System.out.println("Original ArrayList: " + numbers);

        // Create an iterator
        Iterator<Integer> iterator = numbers.iterator();

        // Iterate and remove primes
        while (iterator.hasNext()) {
            int num = iterator.next();
            if (isPrime(num)) {
                iterator.remove(); // Safe removal during iteration
            }
        }

        System.out.println("ArrayList after removing prime numbers: " + numbers);
    }

    public static boolean isPrime(int num){
        if(num <= 1) return false;
        if(num == 2) return true;
        if(num % 2 == 0) return false;
        for(int i=3; i< num/2; i++){
            if(num % i == 0) return false;
        }
        return true;
    }
}
