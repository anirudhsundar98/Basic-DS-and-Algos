package Arrays;

public class Rotate {

    static int[][] rotate(int[][] matrix) {
        int[][] temp = new int[matrix[0].length][matrix.length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                temp[matrix.length-j-1][i] = matrix[i][j];
            }
        }

        return temp;
    }

    public static void main(String[] args) {
        int[][] arr = {
                {1, 2, 3, 4},
                {2, 4, 6, 8},
                {3, 6, 9, 12},
                {4, 8, 12, 16}
        };

        int[][] result = rotate(arr);
        for (int[] x : result) {
            for (int y : x)
                System.out.print(y + " ");
            System.out.println();
        }
    }
}
