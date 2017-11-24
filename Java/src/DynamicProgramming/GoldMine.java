package DynamicProgramming;

import java.util.Arrays;

public class GoldMine {
    static int[][] maxPath;

    static void init(int n, int m) {
        maxPath = new int[n][m];
        for (int[] arr : maxPath)
            Arrays.fill(arr, -1);
    }

    static int maxGold(int[][] mine) {
        int max = 0;
        for (int i = 0; i < mine.length; i++) {
            max = Integer.max(max, findMaxPath(mine, i, 0));
        }
        return max;
    }

    static int findMaxPath(int[][] mine, int row, int col) {
        if (col + 1 == mine[0].length)
            return mine[row][col];

        int max = 0;
        int start = (row == 0)? row: row-1;
        int end = (row == mine.length - 1)? row: row+1;

        for (int i = start; i <= end; i++) {
            if (maxPath[i][col+1] == -1)
                maxPath[i][col+1] = findMaxPath(mine, i, col + 1);

            max = Integer.max(max, maxPath[i][col+1]);
        }

        return max + mine[row][col];
    }

    public static void main(String[] args) {
        int m = 4;
        int n = 4;
        int[][] mine = {
            {10, 33, 13, 15},
            {22, 21, 04, 1},
            {5, 0, 2, 3},
            {0, 6, 14, 2}
        };

        init(n, m);
        System.out.println(maxGold(mine));
    }
}
