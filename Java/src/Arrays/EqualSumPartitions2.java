package Arrays;

import java.util.ArrayList;
import java.util.HashSet;

public class EqualSumPartitions2 {

    static HashSet<Integer> set = new HashSet<>();

    static void printSet(HashSet<Integer> set) {
        for (int i : set)
            System.out.print(i + " ");

        System.out.println();
    }

    static boolean canPartitionKSubsets(int[] nums, int k) {
        if (nums.length == 0 || k == 0)
            return false;

        if (nums.length == 1)
            return true;

        int max = Integer.MIN_VALUE, sum = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (nums[i] > max)
                max = nums[i];
        }

        if (sum % k != 0 || max > sum/k) {
//            System.out.println("init exit");
            return false;
        }
        sum = sum/k;

        for (int i = 0; i < nums.length; i++) {
            if (set.contains(i)) {
                continue;
            }

            if (nums[i] == sum) {
                set.add(i);
                continue;
            }

            ArrayList<Integer> list = new ArrayList<>();
            list.add(i);
            boolean b = check(nums, i+1, sum-nums[i], list);
            if (!b) {
//                System.out.println(i +" out");
                return false;
            }
//            System.out.print(i+": ");
//            printSet(set);

        }

        return true;
    }

    static boolean check(int[] nums, int index, int sum, ArrayList<Integer> list) {
        if (index >= nums.length)
            return false;

        if (nums[index] > sum || set.contains(index))
            return check(nums, index+1, sum, list);

        if (nums[index] == sum) {
            list.add(index);
            set.addAll(list);
            return true;
        }

        boolean a = check(nums, index+1, sum, list);
        if (a)
            return true;
        list.add(index);
        return check(nums, index+1, sum-nums[index], list);
    }

    public static void main(String[] args) {
        int[] nums = {4,15,1,1,1,1,3,11,1,10};
        int k = 3;
        System.out.println(canPartitionKSubsets(nums,k));
    }
}
