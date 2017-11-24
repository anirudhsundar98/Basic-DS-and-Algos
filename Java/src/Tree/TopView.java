package Tree;

import java.util.HashMap;
import java.util.Map;

public class TopView {

    static HashMap<Integer, Node> map = new HashMap<>();

    static void topView(Node node, int dist) {
        if (node == null)
            return;

        if (map.get(dist)== null || map.get(dist).depth > node.depth)
            map.put(dist, node);
        topView(node.left, dist-1);
        topView(node.right, dist+1);
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree(6);
        tree.head.left = new Node(2);
        tree.head.right = new Node(1);

        tree.head.left.left = new Node(3);
        tree.head.left.right = new Node(8);
        tree.head.right.left = new Node(4);
        tree.head.right.right = new Node(5);

        tree.head.left.right.left = new Node(9);
        tree.head.left.right.left.left = new Node(10);
        tree.head.left.right.left.left.left = new Node(100);

        tree.assignDepth(tree.head, 0);
        topView(tree.head, 0);
        for (Map.Entry<Integer, Node> m : map.entrySet()) {
            System.out.print(m.getValue().data + " ");
        }
    }
}
