public class RemoveDuplicates {
    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;

        int i = 0; // pointer for the last unique element
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }

        // Optional: Fill remaining part with underscores (or arbitrary values)
        for (int k = i + 1; k < nums.length; k++) {
            nums[k] = -1; 
        }

        return i + 1; // new length with unique elements
    }

    public static void main(String[] args) {
        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int newLength = removeDuplicates(nums);
        System.out.println("New length: " + newLength);
        System.out.print("Modified array: ");
        for (int num : nums) {
            if (num == -1)
                System.out.print("_, ");
            else
                System.out.print(num + ", ");
        }
    }
}
