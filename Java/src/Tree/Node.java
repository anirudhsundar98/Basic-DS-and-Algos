package Tree;

public class Node {
    public int data;
    public int depth;
    public int pathLength;
    public Node left = null;
    public Node right = null;

    public Node(int val) {
        data = val;
    }

    public Node() {}
}
