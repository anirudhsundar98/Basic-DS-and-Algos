package DynamicProgramming;

import java.util.Arrays;

// http://www.geeksforgeeks.org/dynamic-programming-set-15-longest-bitonic-subsequence/
public class LBS {

    public static void main(String[] args) {
        int[] arr = {80, 60, 30, 40, 20, 10};
        int[] LBS = new int[arr.length];
        boolean[] increasing = new boolean[arr.length];
        Arrays.fill(LBS, 1);
        Arrays.fill(increasing, true);

        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                if (increasing[j] && LBS[j] + 1 > LBS[i]) {
                    LBS[i] = LBS[j] + 1;
                    increasing[i] = (arr[j] <= arr[i]);
                }
                else if (!increasing[j] && LBS[j] + 1 > LBS[i] && arr[j] >= arr[i]) {
                    LBS[i] = LBS[j] + 1;
                    increasing[i] = false;
                }
            }
        }

        for (int i : LBS)
            System.out.print(i + " ");
        System.out.println();
    }
}
