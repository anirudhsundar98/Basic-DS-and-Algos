package Graph;

import java.util.Stack;
import java.util.ArrayDeque;
import java.util.Deque;

public class Graph {
    int[][] adjacencyMatrix;

    public Graph() { }

    public Graph(int[][] mat) {
        adjacencyMatrix = mat;
    }

    void bft(int id) {
        int[] trackedNodes = new int[adjacencyMatrix.length];
        Deque<Integer> queue = new ArrayDeque<>();
        queue.add(id);

        while (!queue.isEmpty()) {
            int loc = queue.poll();
            trackedNodes[loc] = 1;
            System.out.print(loc + " ");

            for (int i = 0; i < adjacencyMatrix[loc].length; i++) {
                if (adjacencyMatrix[loc][i] == 1 && trackedNodes[i] != 1) {
                    queue.add(i);
                    trackedNodes[i] = 1;
                }
            }
        }

        System.out.println();
    }

    void dft(int id) {
        int[] trackedNodes = new int[adjacencyMatrix.length];
        Stack<Integer> stack = new Stack<>();
        stack.push(id);

        while (!stack.isEmpty()) {
            int loc = stack.pop();
            trackedNodes[loc] = 1;
            System.out.print(loc + " ");

            for (int i = 0; i < adjacencyMatrix[loc].length; i++) {
                if (adjacencyMatrix[loc][i] == 1 && trackedNodes[i] != 1) {
                    stack.add(i);
                    trackedNodes[i] = 1;
                }
            }
        }

        System.out.println();
    }

    void print() {
        for (int[] arr : adjacencyMatrix) {
            for (int i : arr) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
