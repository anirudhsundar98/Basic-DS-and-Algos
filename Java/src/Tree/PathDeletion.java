package Tree;

// http://www.geeksforgeeks.org/remove-nodes-root-leaf-paths-length-k/
public class PathDeletion {

    static int pathLen(Node n) {
        int l;
        if (n.left != null && n.right != null)
            l = Integer.max(pathLen(n.left), pathLen(n.right));
        else if (n.right == null && n.left != null)
            l = pathLen(n.left);
        else if (n.left == null && n.right != null)
            l = pathLen(n.right);
        else
            l = n.depth;

        n.pathLength = l;
        return l;
    }

    static int deletePath(Node n, int k) {
        if (n.pathLength < k)
            return 0;

        if (n.left != null) {
            int a = deletePath(n.left, k);
            if (a == 0)
                n.left = null;
        }

        if (n.right != null) {
            int a = deletePath(n.right, k);
            if (a == 0)
                n.right = null;
        }

        return 1;
    }

    static void printLen(Node n) {
        if (n == null)
            return;

        System.out.print(n.pathLength + " ");
        printLen(n.left);
        printLen(n.right);
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree(1);
        Node head = tree.head;
        head.left = new Node(2);
        head.left.left = new Node(4);
        head.left.right = new Node(5);
        head.left.left.left = new Node(7);

        head.right = new Node(3);
        head.right.right = new Node(6);
        head.right.right.left = new Node(8);

        tree.assignDepth(head, 1);
        pathLen(head);

        tree.inOrder(head);
        System.out.println();
        tree.preOrder(head);
        System.out.println();
        printLen(head);
        System.out.println();

        System.out.println("\nDeleting\n");
        int result = deletePath(head, 4);
        if (result == 0)
            head = null;

        tree.inOrder(head);
        System.out.println();
        tree.preOrder(head);
        System.out.println();
    }
}
