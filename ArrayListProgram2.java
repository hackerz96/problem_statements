import java.util.ArrayList;
import java.util.Iterator;

public class ArrayListProgram2 {
    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>();

        // add number into the list
        for (int i = 1; i <= 20; i++) {
            numbers.add(i);
        }

        // traverse the list using for loop
        System.out.println("Original ArrayList (using for loop): " + numbers);
        for(int i=0; i<numbers.size(); i++){
            int num = numbers.get(i);
            System.out.print(num + " ");
        }
        System.out.println();

        // traverse the list using for-each loop
        System.out.println("Original ArrayList (using for-each loop): " + numbers);
        for(int num : numbers){
            System.out.print(num + " ");
        }
        System.out.println();

        // traverse the list using iterator
        System.out.println("Original ArrayList (using iterator): " + numbers);
        Iterator<Integer> iterator = numbers.iterator();
        while(iterator.hasNext()){
            int num = iterator.next();
            System.out.print(num + " ");
        }
        System.out.println();

        // checking if the element is present in the list
        int elementToCheck = 10;
        if(numbers.contains(elementToCheck)){
            System.out.println("Element " + elementToCheck + " is present in the list.");
        } else {
            System.out.println("Element " + elementToCheck + " is not present in the list.");
        }

        // adding an element at a specific index
        int indexToAdd = 5;
        int elementToAdd = 99;
        numbers.add(indexToAdd, elementToAdd);
        System.out.println("ArrayList after adding " + elementToAdd + " at index " + indexToAdd + ": " + numbers);
    }
}
