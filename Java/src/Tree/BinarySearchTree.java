package Tree;

public class BinarySearchTree extends BinaryTree {

    public BinarySearchTree(int val) {
        head = new Node(val);
    }

    public BinarySearchTree() { }

    public BinarySearchTree insert(int data) {
        Node t1 = this.head, t2 = t1;
        Node newNode = new Node(data);
        char dir = 'n';

        while (t1 != null) {
            t2 = t1;
            if (newNode.data < t1.data) {
                t1 = t1.left;
                dir = 'l';
            } else if (newNode.data > t1.data) {
                t1 = t1.right;
                dir = 'r';
            } else return null;
        }

        if (dir == 'n')
            this.head = newNode;
        else if (dir == 'l')
            t2.left = newNode;
        else t2.right = newNode;

        return this;
    }
}
