package Arrays;

// https://leetcode.com/problems/search-in-rotated-sorted-array/description/
public class RotatedSearch {
    static int search(int[] nums, int target) {
        if (nums.length == 0)
            return -1;

        int minIndex = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i-1]) {
                minIndex = i;
                break;
            }
        }

        return binarySearch(nums, target, 0, nums.length-1, minIndex);
    }

    static int binarySearch(int[] arr, int target, int start, int end, int offset) {
        if (start > end)
            return -1;

        int mid = (start+end) / 2;
        int index = mid + offset;
        if (index >= arr.length)
            index -= arr.length;

        if (start == end && arr[index] != target)
            return -1;

        if (arr[index] == target)
            return index;

        if (arr[index] < target)
            return binarySearch(arr, target, mid+1, end, offset);

        return binarySearch(arr, target, start, mid, offset);
    }

    public static void main(String[] args) {
        int[] arr = {1,3};
        int k = 3;
        System.out.println(search(arr,k));
    }
}
