package Graph;

public class GraphTest {

    public static void main(String[] args) {
        int[][] arr = new int[5][5];
        arr[0] = new int[]{0,1,1,0};
        arr[1] = new int[]{0,0,1,0};
        arr[2] = new int[]{1,0,0,1};
        arr[3] = new int[]{0,0,0,1};

        Graph graph = new Graph(arr);

        graph.bft(0);
        graph.dft(0);
    }
}
