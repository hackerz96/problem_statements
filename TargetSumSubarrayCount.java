

public class TargetSumSubarrayCount {
    int[] arr;
    int targetSum;
    int count = 0;

    public TargetSumSubarrayCount(int[] arr, int targetSum) {
        this.arr = arr;
        this.targetSum = targetSum;
    }

    public int countSubarrays() {
        for (int i = 0; i < arr.length; i++) {
            int sum = 0;
            for (int j = i; j < arr.length; j++) {
                sum += arr[j];
                if (sum == targetSum) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        TargetSumSubarrayCount target1 = new TargetSumSubarrayCount(new int[]{2, 3, 1, 2, 4, 3}, 7);
        System.out.println("The number of subarrays with target sum 7 is: " + target1.countSubarrays() + "\n");

        TargetSumSubarrayCount target2 = new TargetSumSubarrayCount(new int[]{1, 1, 1, 1, 1, 1, 1, 1}, 11);
        System.out.println("The number of subarrays with target sum 11 is: " + target2.countSubarrays() + "\n");
    }
}
