package Tree;

import java.util.ArrayDeque;
import java.util.Deque;

public class BinaryTree {
    public Node head = null;

    public BinaryTree(int val) {
        head = new Node(val);
    }

    public BinaryTree(){}

    void assignDepth(Node node, int depth) {
        if (node == null)
            return;

        node.depth = depth;
        assignDepth(node.left, depth + 1);
        assignDepth(node.right, depth + 1);
    }

    public boolean dfs(Node node, int val) {
        if (node == null)
            return false;

        return node.data == val || dfs(node.left, val) || dfs(node.right, val);
    }

    public boolean bfs(Node node, int val) {
        if (node == null)
            return false;
        if (node.data == val)
            return true;

        Deque<Node> queue = new ArrayDeque<>();

        if (node.left != null)
            queue.add(node.left);
        if (node.right != null)
            queue.add(node.right);

        while (!queue.isEmpty()) {
            node = queue.poll();
            if (node.data == val)
                return true;

            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }

        return false;
    }

    public void preOrder(Node node) {
        if (node == null)
            return;

        System.out.print(node.data + " ");
        preOrder(node.left);
        preOrder(node.right);
    }

    public void inOrder(Node node) {
        if (node == null)
            return;

        inOrder(node.left);
        System.out.print(node.data + " ");
        inOrder(node.right);
    }

    public void postOrder(Node node) {
        if (node == null)
            return;

        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.data + " ");
    }
}
