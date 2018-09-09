package Tree;

// import java.util.ArrayList;
import java.util.HashMap;

// http://www.geeksforgeeks.org/bottom-view-binary-tree/
public class BottomView {
    static HashMap<Integer, Node> map = new HashMap<>();

    static void bottomView(Node node, int dist, int depth) {
        if (node.left != null)
            bottomView(node.left, dist - 1, depth + 1);

        if (map.get(dist) == null || map.get(dist).depth <= depth) {
            map.put(dist, node);
        }

        if (node.right != null)
            bottomView(node.right, dist + 1, depth + 1);
    }

    static void topView(Node node, int dist, int depth) {
        if (map.get(dist) == null || map.get(dist).depth > depth) {
            map.put(dist, node);
        }

        if (node.left != null)
            topView(node.left, dist - 1, depth + 1);

        if (node.right != null)
            topView(node.right, dist + 1, depth + 1);
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree(20);
        Node root = tree.head;
        root.left = new Node(8);
        root.right = new Node(22);
        root.left.left = new Node(5);
        root.left.right = new Node(3);
        root.right.left = new Node(4);
        root.right.right = new Node(25);
        root.left.right.left = new Node(10);
        root.left.right.right = new Node(14);

        tree.assignDepth(root, 0);
        bottomView(root, 0, 0);

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (HashMap.Entry m : map.entrySet()) {
//            System.out.println(m.getKey()+": "+((Node) m.getValue()).data);
            if ((int) m.getKey() < min)
                min = (int) m.getKey();
            if ((int) m.getKey() > max)
                max = (int) m.getKey();
        }

        int[] arr = new int[max - min + 1];

        for (HashMap.Entry m : map.entrySet()) {
//            list.add(min + (int) m.getKey() - 1, ((Node) m.getValue()).data);
            arr[(int) m.getKey() - min] = ((Node) m.getValue()).data;
        }

        for (int i : arr) {
            System.out.println(i);
        }
    }
}
