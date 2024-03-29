package March_28_Assignment;

import java.util.Scanner;

public class Q2_Trampolin_jumps {
    public static int minJumps(int[] arr) {
        int n = arr.length;
        int jumps = 0;
        int currentEnd = 0;
        int farthest = 0;

        for (int i = 0; i < n - 1; i++) {
            farthest = Math.max(farthest, i + arr[i]);
            if (i == currentEnd) {
                jumps++;
                currentEnd = farthest;
            }
            if (currentEnd >= n - 1) {
                return jumps;
            }
            if (i >= currentEnd) {
                return -1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of test cases: ");
        int t = scanner.nextInt();

        while (t != 0) {
            System.out.print("Enter the number of shops: ");
            int n = scanner.nextInt();
            int[] arr = new int[n];
            System.out.print("Enter the array of trampoline jumps: ");
            for (int i = 0; i < n; i++) {
                arr[i] = scanner.nextInt();
            }

            int result = minJumps(arr);
            System.out.println("Minimum number of trampoline jumps: " + result);
        }
    }
}
