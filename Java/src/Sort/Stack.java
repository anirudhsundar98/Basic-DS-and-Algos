package Sort;

/**
 * Created by anirudh on 8/3/17.
 */
public class Stack {
    Node top;

    Stack push(int val) {
        Node newNode = new Node(val);
        if (top == null) {
            newNode.next = null;
            top = newNode;
        } else {
            newNode.next = top;
            top = newNode;
        }
        return this;
    }

    Node pop() {
        if (top == null) {
            System.out.println("Stack empty");
            return null;
        }

        Node temp = top;
        if (top.next == null) {
            top = null;
        } else {
            top = top.next;
        }
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

    Stack sort() {
        Stack s1 = this;
        Stack s2 = new Stack();
        Stack s3 = new Stack();
        while (s1.top != null) {
            if (s2.top == null) {
                s2.push(s1.pop().data);
            } else {
                while (s2.top != null && s1.top.data > s2.top.data) {
                    s3.push(s2.pop().data);
                }
                s2.push(s1.pop().data);
                while(s3.top != null) {
                    s2.push(s3.pop().data);
                }
            }
        }
        return s2;
    }
}
