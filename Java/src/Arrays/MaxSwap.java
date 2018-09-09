package Arrays;

import java.util.ArrayList;

// https://leetcode.com/problems/maximum-swap/description/
public class MaxSwap {
    static int[] createArray(int num) {
        int n = (int) Math.log10(num) + 1;
        int[] res = new int[n];
        for (int i = n - 1; num != 0; i--, num /= 10)
            res[i] = (num % 10);

        return res;
    }

    public static int maximumSwap(int num) {
        int[] arr = createArray(num);
        return 0;
//        char[] arr = Integer.toString(num).toCharArray();
//
//        int indexToSwap = -1;
//        for (int i = 1; i < arr.length; i++) {
//            if (arr[i] > arr[i-1]) {
//                indexToSwap = i-1;
//                break;
//            }
//        }
//
//        if (indexToSwap == -1) {
//            return num;
//        }
//
//        int max = arr[indexToSwap] - 48;
//        int swapIndex = -1;
//        for (int i = indexToSwap + 1; i < arr.length; i++) {
//            if (arr[i] - 48 >= max && arr[i] > arr[indexToSwap]) {
//                max = arr[i] - 48;
//                swapIndex = i;
//            }
//        }
//
//
//        char temp = arr[indexToSwap];
//        arr[indexToSwap] = arr[swapIndex];
//        arr[swapIndex] = temp;
//
//        return Integer.parseInt(new String(arr));
    }

    public static void main(String[] args) {
        int num = 2736;
        System.out.println(maximumSwap(num));
    }
}
