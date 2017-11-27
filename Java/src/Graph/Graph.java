package Graph;

import java.util.*;

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

    int[] djikstras(int start) {
        HashSet<Integer> visited = new HashSet<>();
        int[] minDist = new int[adjacencyMatrix.length];
        Arrays.fill(minDist, Integer.MAX_VALUE);

        minDist[start] = 0;
        visited.add(start);
        while (visited.size() < adjacencyMatrix.length) {
            int min_val = Integer.MAX_VALUE;
            int min_index = -1, start_index = -1;
            for (Integer i : visited) {
                for (int j = 0; j < adjacencyMatrix.length; j++) {
                    if (visited.contains(j)) {
                        continue;
                    }

                    if (adjacencyMatrix[i][j] != Integer.MAX_VALUE && min_val > adjacencyMatrix[i][j] + minDist[i]) {
                        min_val = adjacencyMatrix[i][j] + minDist[i];
                        start_index = i;
                        min_index = j;
                    }
                }
            }
//
//            if (start_index == -1)
//                return minDist;
            System.out.println(start_index+" "+min_index+" "+adjacencyMatrix[start_index][min_index]);
//            System.out.println(start_index + " " + min_index);
            visited.add(min_index);
            minDist[min_index] = minDist[start_index] + adjacencyMatrix[start_index][min_index];
        }

        return minDist;
    }
}
