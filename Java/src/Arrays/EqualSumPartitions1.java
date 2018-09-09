package Arrays;

import java.util.ArrayList;

// https://leetcode.com/problems/partition-equal-subset-sum/description/
// (Simple Recursive Soln. - No DP)
public class EqualSumPartitions1 {

    static boolean canPartition(int[] nums) {
        if (nums.length == 0 || nums.length == 1)
            return nums.length == 0;

        int sum = 0, max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max)
                max = nums[i];

            sum += nums[i];
        }

        if (sum % 2 != 0 || max > sum/2)
            return false;

        return check(nums, 0, sum/2, sum/2);
    }

    static boolean check(int[] nums, int index, int sum1, int sum2) {
        if (index >= nums.length && sum1 == 0 && sum2 == 0)
            return true;

        if (sum1 - nums[index] < 0 && sum2 - nums[index] < 0)
            return false;

        if (sum1 - nums[index] < 0)
            return check(nums, index + 1, sum1, sum2 - nums[index]);
        if (sum2 - nums[index] < 0)
            return check(nums, index + 1, sum1 - nums[index], sum2);

        return ( check(nums, index + 1, sum1 - nums[index], sum2) || check(nums, index + 1, sum1, sum2 - nums[index]) );
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,5};
        System.out.println(canPartition(arr));
        ArrayList<Integer> l =new ArrayList<>();
    }
}
