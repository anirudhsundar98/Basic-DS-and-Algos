package Tree;

public class BTTest {

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree(10);
        Node head = tree.head;

        head.left = new Node(4);
        head.left.left = new Node(15);
        head.left.right = new Node(3);
        head.left.right.right = new Node(5);

        head.right = new Node(2);
        head.right.left = new Node(8);
        head.right.right = new Node(9);

        tree.preOrder(head);
        System.out.println();

        tree.inOrder(head);
        System.out.println();

        tree.postOrder(head);
        System.out.println();

        System.out.println(tree.dfs(head, 5));
        System.out.println(tree.bfs(head, 5));
    }
}
