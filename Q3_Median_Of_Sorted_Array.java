package March_28_Assignment;

import java.util.Scanner;

public class Q3_Median_Of_Sorted_Array {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int totalLength = nums1.length + nums2.length;
        int[] mergedArray = new int[totalLength];

        int i = 0, j = 0, k = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] <= nums2[j]) {
                mergedArray[k++] = nums1[i++];
            } else {
                mergedArray[k++] = nums2[j++];
            }
        }

        while (i < nums1.length) {
            mergedArray[k++] = nums1[i++];
        }

        while (j < nums2.length) {
            mergedArray[k++] = nums2[j++];
        }

        if (totalLength % 2 == 0) {
            return (mergedArray[totalLength / 2 - 1] + mergedArray[totalLength / 2]) / 2.0;
        } else {
            return mergedArray[totalLength / 2];
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the size of the first array: ");
        int n = scanner.nextInt();
        int[] nums1 = new int[n];
        System.out.print("Enter the elements of the first array: ");
        for (int i = 0; i < n; i++) {
            nums1[i] = scanner.nextInt();
        }

        System.out.print("Enter the size of the second array: ");
        int m = scanner.nextInt();
        int[] nums2 = new int[m];
        System.out.print("Enter the elements of the second array: ");
        for (int i = 0; i < m; i++) {
            nums2[i] = scanner.nextInt();
        }

        double median = findMedianSortedArrays(nums1, nums2);
        System.out.println("Median of the two sorted arrays: " + median);

        scanner.close();
    }
}
