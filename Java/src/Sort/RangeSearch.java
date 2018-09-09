package Sort;

// https://leetcode.com/submissions/detail/130029551/
public class RangeSearch {
    static int[] searchRange(int[] nums, int target) {
        int[] res = new int[2];
        if (nums.length == 0) {
            res[0] = -1;
            res[1] = -1;
            return res;
        }

        int pos = binarySearch(nums, target, 0, nums.length - 1);
        if (pos == -1) {
            res[0] = -1;
            res[1] = -1;
            return res;
        }

        int startIndex = pos, endIndex = pos;
        while( startIndex >= 0 && nums[startIndex] == nums[pos])
            startIndex--;

        while (endIndex <= nums.length - 1 && nums[endIndex] == nums[pos]) {
            endIndex++;
        }

        res[0] = startIndex + 1;
        res[1] = endIndex - 1;

        return res;
    }

    static int binarySearch(int[] nums, int target, int start, int end) {
        if (start > end)
            return -1;

        int mid = (start + end)/2;
        if (nums[mid] == target)
            return mid;

        if (nums[mid] < target)
            return binarySearch(nums, target, mid + 1, end);

        return binarySearch(nums, target, start, mid - 1);
    }

    public static void main(String[] args) {
        int[] arr = {1,3,7,7,7,8,8};
        int target = 7;
        int[] res = searchRange(arr, target);
        for (int i : res)
            System.out.print(i + " ");

        System.out.println();
    }
}
