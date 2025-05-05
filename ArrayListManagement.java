// problem statement 12 : Design a java program to manage an ArrayList of integers. The program should allow the user to perform the following operations:
// dynamic imsertion at any position, deletion, updating values, efficiently computing the sum of elements between two given indices after each modification.
import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListManagement {
    
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        Scanner scn = new Scanner(System.in);
        int choice = 0;
        System.out.println("ArrayList Management Program");

        while (true) { 
            
            System.out.println("Enter Your Choice: ");
            System.out.println("1. Insert an element at a specific position");
            System.out.println("2. Delete an element at a specific position");
            System.out.println("3. Update an element at a specific position");
            System.out.println("4. Compute the sum of elements between two indices");
            System.out.println("5. Display the ArrayList");
            System.out.println("6. Exit");
            System.out.print("Your choice: ");
            choice = scn.nextInt();

            switch(choice){
                case 1:
                    System.out.println("Enter the element to insert: ");
                    int elementToInsert = scn.nextInt();
                    System.out.println("Enter the position to insert the element: ");
                    int positionToInseert = scn.nextInt();
                    if(positionToInseert >=0 && positionToInseert <= list.size()){
                        list.add(positionToInseert, elementToInsert);
                        System.out.println("Element " + elementToInsert + " inserted at position " + positionToInseert);
                    } else {
                        System.out.println("Invalid position. Please try again.");
                    }
                    break;

                case 2:
                    System.out.println("Enter the element to delete: ");
                    int elementToDelete = scn.nextInt();
                    for(int i=0; i<list.size(); i++ ){
                        if(list.get(i) == elementToDelete){
                            list.remove(i);
                            System.out.println("Element " + elementToDelete + " deleted from position " + i);
                            break;
                        } else {
                            System.out.println("Element not found in the list.");
                        }
                    }
                    break;
                
                case 3:
                    System.out.println("Enter the position to update: ");
                    int positionToUpdate = scn.nextInt();
                    if(positionToUpdate >=0 && positionToUpdate <=list.size()){
                        System.out.println("Enter the new vlaue to update: ");
                        int valueToUpdate = scn.nextInt();
                        list.set(positionToUpdate, valueToUpdate);
                        System.out.println("Element at position " + positionToUpdate + " updated to " + valueToUpdate);    
                    }
                    else{
                        System.out.println("Invalid position to update.");
                    }
                    break;

                case 4:
                    System.out.println("Computing sum of elements between tow indices:");
                    System.out.println("Enter the starting index: ");
                    int startIdx = scn.nextInt();
                    System.out.println("Enter the ending index: ");
                    int endIdx = scn.nextInt();
                    if(startIdx >=0 && endIdx < list.size() && startIdx <= endIdx){
                        int sum = 0;
                        for(int i=startIdx; i<=endIdx; i++){
                            sum += list.get(i);
                        }
                        System.out.println("Sum of elements between indices " + startIdx + " and " + endIdx + " is: " + sum);
                    } else {
                        System.out.println("Invalid indices. Please try again.");
                    }
                    break;

                case 5:
                    System.out.println(list);
                    break;
            }
            
        }
    }

}
