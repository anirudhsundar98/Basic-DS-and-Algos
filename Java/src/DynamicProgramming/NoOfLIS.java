package DynamicProgramming;

import java.util.Arrays;

// https://leetcode.com/problems/number-of-longest-increasing-subsequence/description/
public class NoOfLIS {

    static int findNumberOfLIS(int[] nums) {
        if (nums.length == 0 || nums.length == 1)
            return nums.length;

        int[] L = new int[nums.length];
        int[] LCount = new int[nums.length];
        Arrays.fill(L, 1);
        LCount[0] = 1;

        int max = 1;

        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    if (L[i] == L[j] + 1) {
                        LCount[i] += LCount[j];
                    }

                    if (L[i] < L[j] + 1) {
                        L[i] = L[j] + 1;
                        LCount[i] = LCount[j];
                        if (max < L[i])
                            max = L[i];
                    }
                }
            }

            if (LCount[i] == 0)
                LCount[i] = 1;
        }

        int ans = 0;
        for (int i = 0; i < LCount.length; i++) {
            if (L[i] == max)
                ans += LCount[i];
        }
        return ans;
    }

    public static void main(String[] args) {
//        int[] arr = {15, 27, 14, 38, 26, 55, 46, 65, 1000};
        int[] arr = {2,2,2,2,2};
//        int[] arr = {1,2,4,3,5,4,7,2};
        System.out.println(findNumberOfLIS(arr));
    }
}
