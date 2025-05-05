
public class LargestSmallest {

    public static void largest(int [] arr){
        int largest = arr[0];
        for(int i=0; i<arr.length; i++){
            if(arr[i] > largest){
                largest = arr[i];
            }
        }
        System.out.println("The largest element from the given array is: " + largest);
    }

    public static void smallest(int [] arr){
        int smallest = arr[0];
        for(int i=0; i<arr.length; i++){
            if(arr[i] < smallest){
                smallest = arr[i];
            }
        }
        System.out.println("The smallest element from the given array is: " + smallest);
    }

    public static void reverseArray(int [] arr){
        int startIdx = 0;
        int endIdx = arr.length - 1;
        while(startIdx < endIdx){
            int temp = arr[startIdx];
            arr[startIdx] = arr[endIdx];
            arr[endIdx] = temp;
            startIdx++;
            endIdx--;
        }
        System.out.print("The reversed array is: ");
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static int [] joinArrays(int [] arr1, int [] arr2){
        int [] joinedArray = new int[arr1.length + arr2.length];
        int index = 0;
        for(int i=0; i<arr1.length; i++){
            joinedArray[index] = arr1[i];
            index++;
        }
        for(int i=0; i<arr2.length; i++){
            joinedArray[index] = arr2[i];
            index++;
        }
        return joinedArray;
    }

   public static void main(String[] args) {
        int [] arr1 = {1, 3, 5, 9, 34, 2, 6, 8};
        int [] arr2 = {4, 7, 10, 12, 14, 16, 18};

        largest(arr1);
        smallest(arr1);
        reverseArray(arr1);

        System.out.print("The joined array is: ");
        int [] joinedArray = joinArrays(arr1, arr2);
        for(int i=0; i<joinedArray.length; i++){
            System.out.print(joinedArray[i] + " ");
        }
   } 
}
