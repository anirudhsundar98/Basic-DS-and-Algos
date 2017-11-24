package DynamicProgramming;

/**
 * Created by anirudh on 7/21/17.
 */
public class LCS {

    public static void main(String[] args) {
        String s1 = "AGGTAB";
        String s2 = "GXTXAYB";
        char[] X = s1.toCharArray();
        char[] Y = s2.toCharArray();
        int m = X.length;
        int n = Y.length;

        int[][] LCS = new int[m+1][n+1];

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0) {
                    LCS[i][j] = 0;
                } else if (X[i-1] == Y[j-1]) {
                    LCS[i][j] = LCS[i-1][j-1] + 1;
                } else {
                    LCS[i][j] = Math.max(LCS[i-1][j], LCS[i][j-1]);
                }
            }
        }

        System.out.println(LCS[m][n]);
    }
}
