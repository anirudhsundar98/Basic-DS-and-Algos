package Arrays;

import java.util.HashMap;

// http://www.geeksforgeeks.org/find-next-greater-number-set-digits/
public class NextGreatest {

    static void quicksort(int[] arr, int start, int end) {
        if (start >= end || start < 0 || end < 0)
            return;

        int pivot = end;
        int wall = start - 1;

        for (int i = start; i < end; i++) {
            if (arr[pivot] <= arr[i])
                continue;

            wall++;
            int temp = arr[wall];
            arr[wall] = arr[i];
            arr[i] = temp;
        }

        int temp = arr[wall+1];
        arr[wall+1] = arr[pivot];
        arr[pivot] = temp;

        quicksort(arr, start, wall);
        quicksort(arr, wall+2, end);
    }

    static int[] createArray(int num) {
        int n = (int) Math.log10(num) + 1;
        int[] res = new int[n];
        for (int i = n - 1; num != 0; i--, num /= 10)
            res[i] = (num % 10);

        return res;
    }

    static int nextNum(int num) {
        int[] arr = createArray(num);
        HashMap<Integer, Integer> map = new HashMap<>();
        int index = -1;


        for (int i = arr.length - 1; i >= 0; i--) {
            map.putIfAbsent(arr[i], i);
            if (i == arr.length - 1 || arr[i] >= arr[i+1])
                continue;

            for (int j = arr[i] + 1; j < 10; j++) {
                if (map.get(j) == null)
                    continue;

                int swpIndex = map.get(j);
                int temp = arr[i];
                arr[i] = arr[swpIndex];
                arr[swpIndex] = temp;
                index = i + 1;
                break;
            }
            break;
        }

        if (index == -1)
            return num;

        quicksort(arr, index, arr.length - 1);
        int res = 0, pow = 1;
        for (int i = arr.length - 1; i >= 0; i--, pow *= 10)
            res += pow*arr[i];
        return res;
    }

    public static void main(String[] args) {
        int num = 534976;
        System.out.println(num);
        System.out.println(nextNum(num));
    }
}
