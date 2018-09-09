package DynamicProgramming;

import java.util.Arrays;

// http://www.geeksforgeeks.org/maximum-sum-such-that-no-two-elements-are-adjacent/
public class MaxSum2 {

    static int[] sum;

    static int maxSum(int[] arr, int index) {
        if (index >= arr.length)
            return 0;

        if (index == arr.length - 1) {
            sum[index] = arr[index];
            return arr[index];
        }

        if (sum[index] == Integer.MIN_VALUE)
            sum[index] = Integer.max(arr[index] + maxSum(arr, index+2), arr[index+1] + maxSum(arr, index+3));

        return sum[index];
    }

    public static void main(String[] args) {
        int[] arr = {5, 5, 10, 100, 10, 5};
        sum = new int[arr.length];
        Arrays.fill(sum, Integer.MIN_VALUE);
        System.out.println(maxSum(arr, 0));
    }
}
