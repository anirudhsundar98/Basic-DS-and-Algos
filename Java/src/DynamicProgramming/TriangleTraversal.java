package DynamicProgramming;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/triangle/description/
public class TriangleTraversal {
    static int minimumTotal(List<List<Integer>> triangle) {
        if (triangle.size() == 0)
            return 0;

        if (triangle.size() == 1)
            return triangle.get(0).get(0);

        int[][] dp = new int[triangle.size()][triangle.size()];

        int min = Integer.MAX_VALUE;
        dp[0][0] = triangle.get(0).get(0);
        for (int i = 1; i < triangle.size(); i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0) {
                    dp[i][j] = triangle.get(i).get(j) + dp[i - 1][j];
                } else if (j == i) {
                    dp[i][j] = triangle.get(i).get(j) + dp[i-1][j-1];
                } else {
                    dp[i][j] = triangle.get(i).get(j) + Integer.min(dp[i-1][j], dp[i-1][j-1]);
                }

                if (i == triangle.size() - 1) {
                    if (dp[i][j] < min) {
                        min = dp[i][j];
                    }
                }
            }
        }
//
//        for (int[] arr : dp) {
//            for (int i : arr)
//                System.out.print(i+" ");
//            System.out.println();
//        }

        return min;
    }

    public static void main(String[] args) {
//        [[-1],[2,3],[1,-1,-3]]
        List<List<Integer>> cont = new ArrayList<>();
        ArrayList<Integer> l1 = new ArrayList<>();
        ArrayList<Integer> l2 = new ArrayList<>();
        ArrayList<Integer> l3 = new ArrayList<>();
        l1.add(-1);
        l2.add(2);
        l2.add(3);
        l3.add(1);
        l3.add(-1);
        l3.add(-3);
        cont.add(l1);
        cont.add(l2);
        cont.add(l3);

        System.out.println(minimumTotal(cont));
    }
}
