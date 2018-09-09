package Arrays;

// https://leetcode.com/problems/shortest-unsorted-continuous-subarray/description/
public class ShortestUnsortedSubarray {

    public static int findUnsortedSubarray(int[] nums) {
        if (nums.length == 0 || nums.length == 1)
            return 0;

        int startIndex = 0, endIndex = nums.length - 1;
        int startViolatedIndex = -1, endViolatedIndex = -1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] >= nums[i-1])
                continue;

            if (startViolatedIndex == -1 || nums[startViolatedIndex] > nums[i])
                startViolatedIndex = i;
        }

        if (startViolatedIndex == -1)
            return 0;

        for (int i = nums.length - 2; i >= 0 ; i--) {
            if (nums[i] <= nums[i+1])
                continue;

            if (endViolatedIndex == -1 || nums[endViolatedIndex] < nums[i])
                endViolatedIndex = i;
        }


        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= nums[startViolatedIndex]) {
                continue;
            }

            startIndex = i;
            break;
        }
        for (int i = nums.length - 1; i >= 0 ; i--) {
            if (nums[i] >= nums[endViolatedIndex]) {
                continue;
            }

            endIndex = i;
            break;
        }

        return endIndex - startIndex + 1;
    }

    public static void main(String[] args) {
        int[] arr = {1,3,5,4,2};
        System.out.println(findUnsortedSubarray(arr));
    }
}
