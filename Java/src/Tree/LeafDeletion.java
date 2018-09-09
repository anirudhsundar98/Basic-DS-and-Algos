package Tree;

// http://www.geeksforgeeks.org/delete-leaf-nodes-value-x/
public class LeafDeletion {

    static boolean isLeafNode(Node n) {
        return (n.left == null && n.right == null);
    }

    static boolean leafDel(Node node, int val) {
        if (node == null)
            return true;

//        System.out.println(node.data + " " + (isLeafNode(node)));
        if (isLeafNode(node) && node.data == val) {
//            System.out.println(node.data);
            return false;
        }

        if (!isLeafNode(node)) {
            boolean left = leafDel(node.left, val);
            if (!left)
                node.left = null;
            boolean right = leafDel(node.right, val);
            if (!right)
                node.right = null;

            if (isLeafNode(node) && node.data == val)
                return false;
        }

        return true;
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree(6);
        tree.head.left = new Node(4);
        tree.head.right = new Node(5);

        tree.head.left.left = new Node(1);
        tree.head.left.right = new Node(5);
        tree.head.right.left = new Node(5);
        tree.head.right.right = new Node(5);

        tree.inOrder(tree.head);
        System.out.println();
        leafDel(tree.head, 5);
        tree.inOrder(tree.head);
    }
}
