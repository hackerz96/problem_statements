// Define the interface
interface Sortable {
    void sort(int[] arr);  // Method to sort an array
}

// BubbleSort implementation
class BubbleSort implements Sortable {
    @Override
    public void sort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Swap arr[j] and arr[j+1]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        System.out.println("Sorted using Bubble Sort:");
        display(arr);
    }

    private void display(int[] arr) {
        for (int num : arr)
            System.out.print(num + " ");
        System.out.println();
    }
}

// SelectionSort implementation
class SelectionSort implements Sortable {
    @Override
    public void sort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIdx]) {
                    minIdx = j;
                }
            }
            // Swap arr[i] and arr[minIdx]
            int temp = arr[i];
            arr[i] = arr[minIdx];
            arr[minIdx] = temp;
        }
        System.out.println("Sorted using Selection Sort:");
        display(arr);
    }

    private void display(int[] arr) {
        for (int num : arr)
            System.out.print(num + " ");
        System.out.println();
    }
}

// Main class to test both sorting methods
public class SortExample {
    public static void main(String[] args) {
        int[] array1 = {5, 3, 8, 1, 2};
        int[] array2 = {5, 3, 8, 1, 2};

        Sortable bubble = new BubbleSort();
        bubble.sort(array1);

        Sortable selection = new SelectionSort();
        selection.sort(array2);
    }
}
