package Tree;

import java.util.HashMap;

public class MaxPath {

    static int maxVal = Integer.MIN_VALUE;
    static HashMap<Integer, Integer> map = new HashMap<>();

    static int maxPathFromRoot(Node node, int sum) {
        if (node == null)
            return sum;

        return Integer.max(maxPathFromRoot(node.left, sum + node.data), maxPathFromRoot(node.right, sum+node.data));
    }

    static void maxPath(Node node) {
        if (node == null)
            return;

        maxPath(node.left);
        maxPath(node.right);

        int l = 0, r = 0;

        if (node.left != null) {
            if (map.get(node.left.data) != null) {
                l = map.get(node.left.data);
            } else {
                l = maxPathFromRoot(node.left, 0);
                map.put(node.left.data, l);
            }
        }
        if (node.right != null) {
            if (map.get(node.right.data) != null) {
                r = map.get(node.right.data);
            } else {
                r = maxPathFromRoot(node.right, 0);
                map.put(node.right.data, l);
            }
        }

        int max = Integer.max(Integer.max(l + node.data, r + node.data), Integer.max(l + r + node.data, node.data));
        if (max > maxVal)
            maxVal = max;
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree(-15);
        Node root = tree.head;

//        head.left = new Node(2);
//        head.left.left = new Node(4);
//        head.left.right = new Node(5);
//
//        head.right = new Node(3);
//        head.right.left = new Node(6);
//        head.right.left.left = new Node(9);
//        head.right.right = new Node(7);

        root.left = new Node(5);
        root.right = new Node(6);
        root.left.left = new Node(-8);
        root.left.right = new Node(1);
        root.left.left.left = new Node(2);
        root.left.left.right = new Node(6);
        root.right.left = new Node(3);
        root.right.right = new Node(9);
        root.right.right.right = new Node(0);
        root.right.right.right.left = new Node(4);
        root.right.right.right.right = new Node(-1);
        root.right.right.right.right.left = new Node(10);

        maxPath(root);
        System.out.println(maxVal);
    }
}
