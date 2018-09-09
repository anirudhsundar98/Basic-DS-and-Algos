package DynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;

// http://www.geeksforgeeks.org/maximum-sum-pairs-specific-difference/
public class MaxPairSum {

    static int max(ArrayList<Integer> list) {
        int sum = 0;

        for (int i : list) {
            sum += i;
        }

        return sum;
    }

    public static void main(String[] args) {
        int[] arr = {5, 15, 10, 100};
        int k = 12;
        Arrays.sort(arr);

        int index = arr.length - 1;
        ArrayList<Integer> list = new ArrayList<>();

        while (index > 0) {
            if (arr[index] - arr[index - 1] < k) {
                list.add(arr[index]);
                list.add(arr[index - 1]);
                index -= 2;
            } else {
                index--;
            }
        }

        System.out.println(max(list));
    }
}
