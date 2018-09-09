package DynamicProgramming;

import java.util.Arrays;

/**
 * Created by anirudh on 7/21/17.
 */
public class LCS {

    static int[][] lcs;

    static int LCS(String s1, int i1, String s2, int i2) {
        if (i1 < 0 || i2 < 0)
            return 0;

        if (s1.charAt(i1) == s2.charAt(i2)) {
            if (lcs[i1][i2] == -1)
                lcs[i1][i2] = 1 + LCS(s1, i1 - 1, s2, i2 - 1);
            return lcs[i1][i2];
        }

        if (lcs[i1][i2] == -1)
            lcs[i1][i2] = Math.max(LCS(s1, i1-1, s2, i2), LCS(s1, i1, s2, i2-1));
        return lcs[i1][i2];
    }

    public static void main(String[] args) {
        String s1 = "AGGTAB";
        String s2 = "GXTXAYB";
//        char[] X = s1.toCharArray();
//        char[] Y = s2.toCharArray();
        int m = s1.length() - 1;
        int n = s2.length() - 1;

        lcs = new int[m+1][n+1];
        for (int[] a : lcs)
            Arrays.fill(a, -1);

        System.out.println(LCS(s1, m, s2, n));


//        int[][] LCS = new int[m+1][n+1];

//        for (int i = 0; i <= m; i++) {
//            for (int j = 0; j <= n; j++) {
//                if (i == 0 || j == 0) {
//                    LCS[i][j] = 0;
//                } else if (X[i-1] == Y[j-1]) {
//                    LCS[i][j] = LCS[i-1][j-1] + 1;
//                } else {
//                    LCS[i][j] = Math.max(LCS[i-1][j], LCS[i][j-1]);
//                }
//            }
//        }

//        System.out.println(LCS[m][n]);
    }
}
