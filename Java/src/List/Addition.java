package List;

// http://www.geeksforgeeks.org/add-two-numbers-represented-by-linked-lists/
public class Addition {

    static LinkedList add(Node head1, Node head2) {
        LinkedList res = new LinkedList();
        int carry = 0;
        Node temp = null;

        while (head1 != null || head2 != null) {
            int sum = carry;
            if (head1 != null)
                sum += head1.data;
            if (head2 != null)
                sum += head2.data;
            carry = sum/10;
            sum %= 10;
            Node n = new Node(sum);
            if (temp == null) {
                temp = n;
                res.head = temp;
            } else {
                temp.next = n;
                temp = temp.next;
            }

            if (head1 != null)
                head1 = head1.next;
            if (head2 != null)
                head2 = head2.next;
        }

        while (carry != 0) {
            int sum = carry % 10;
            carry /= 10;
            Node n = new Node(sum);
            temp.next = n;
            temp = temp.next;
        }

        return res;
    }

    public static void main(String[] args) {
        LinkedList l1 = new LinkedList();
        l1.head = new Node(8);
        l1.appendToTail(4);
        LinkedList l2 = new LinkedList();
        l2.head = new Node(7);
        l2.appendToTail(5);
        l2.appendToTail(9);
        l2.appendToTail(4);
        l2.appendToTail(6);

        LinkedList ans = add(l1.head, l2.head);
        ans.displayList();
    }
}
