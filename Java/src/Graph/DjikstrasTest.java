package Graph;

public class DjikstrasTest {

    public static void main(String[] args) {
        int m = Integer.MAX_VALUE;

        int[][] arr = new int[][]{
                {m, 4, m, m, m, m, m, 8, m},
                {4, m, 8, m, m, m, m, 11, m},
                {m, 8, m, 7, m, 4, m, m, 2},
                {m, m, 7, m, 9, 14, m, m, m},
                {m, m, m, 9, m, 10, m, m, m},
                {m, m, 4, 14, 10, m, 2, m, m},
                {m, m, m, m, m, 2, m, 1, 6},
                {8, 11, m, m, m, m, 1, m, 7},
                {m, m, 2, m, m, m, 6, 7, m}
        };

        Graph graph = new Graph(arr);

        int[] lel = graph.djikstras(0);
        for (int i : lel)
            System.out.print(i + " ");
        System.out.println();
    }
}
