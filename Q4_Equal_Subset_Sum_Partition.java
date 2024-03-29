package March_28_Assignment;

import java.util.Scanner;

public class Q4_Equal_Subset_Sum_Partition {
    public static boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        if (sum % 2 != 0) {
            return false;
        }

        sum /= 2;
        boolean[] dp = new boolean[sum + 1];
        dp[0] = true;

        for (int num : nums) {
            for (int i = sum; i >= num; i--) {
                dp[i] = dp[i] || dp[i - num];
            }
        }

        return dp[sum];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of test cases: ");
        int t = scanner.nextInt();

        for (int i = 0; i < t; i++) {
            System.out.print("Enter the size of the array for test case " + (i + 1) + ": ");
            int n = scanner.nextInt();
            int[] nums = new int[n];
            System.out.print("Enter the elements of the array for test case " + (i + 1) + ": ");
            for (int j = 0; j < n; j++) {
                nums[j] = scanner.nextInt();
            }

            boolean result = canPartition(nums);
            System.out.println("Output for test case " + (i + 1) + ": " + result);
        }

        scanner.close();
    }
}
