public class MoveZeroesToEnd {
    public static void moveZeroes(int[] arr) {
        int n = arr.length;
        int index = 0; // Index to place the next non-zero element

        // First pass: Move all non-zero elements to the front
        for (int i = 0; i < n; i++) {
            if (arr[i] != 0) {
                arr[index] = arr[i];
                index++;
            }
        }

        // Second pass: Fill remaining positions with zeros
        while (index < n) {
            arr[index++] = 0;
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 0, 4, 3, 0, 5, 0};

        System.out.println("Original Array:");
        for (int num : arr) {
            System.out.print(num + " ");
        }

        moveZeroes(arr);

        System.out.println("\nArray after moving zeroes to end:");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
