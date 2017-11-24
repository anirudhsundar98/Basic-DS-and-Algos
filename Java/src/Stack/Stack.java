package Stack;

/**
 * Created by anirudh on 8/3/17.
 */
public class Stack {
    Node top;
    private int min;

    Stack push(int val) {
        Node newNode = new Node(val);
        if (top == null) {
            newNode.next = null;
            top = newNode;
            min = top.data;
        } else {
            newNode.next = top;
            top = newNode;
            if (min > top.data) {
                min = top.data;
            }
        }
        return this;
    }

    Node pop() {
        if (top == null) {
            System.out.println("Stack empty");
            return null;
        }

        Node temp = top;
        top = top.next;
        return temp;
    }

    void display() {
        Node temp = top;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
        System.out.println();
    }

    int getMinimum() {
        if (top == null) {
            System.out.println("Error");
            return -1;
        }

        else return min;
    }
}
