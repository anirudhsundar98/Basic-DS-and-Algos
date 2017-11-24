package DynamicProgramming;
import java.util.Arrays;

public class LIS {

    public static void main(String[] args) {
        int[] arr = {15, 27, 14, 38, 26, 55, 46, 65, 85};
        int[] L = new int[10];
        Arrays.fill(L, 1);


        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j] && L[i] < L[j] + 1) {
                    L[i] = L[j] + 1;
                }
            }
        }

        System.out.println(L[arr.length - 1]);
    }
}
