package Tree;

public class BSTTest {

    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree(8);
        Node head = tree.head;
        tree.insert(2).insert(7).insert(11).insert(12).insert(24).insert(16).insert(4).insert(6);

        tree.preOrder(head);
        System.out.println();

//        tree.inOrder(head);
//        System.out.println();
//
//        tree.postOrder(head);
//        System.out.println();
    }
}
