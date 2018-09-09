package List;

// http://www.geeksforgeeks.org/reverse-a-list-in-groups-of-given-size/
public class ReverseInGroups {

    static void reverse(LinkedList l, int k) {
        Node r = l.head;
        if (r == null || k == 1 || k == 0)
            return;
        Node q = r.next;
        if (q == null)
            return;

        Node p = l.head;
        Node tempHead = null, tempTailPrev = null, tempTailCurr = null;
        int count;
        boolean headIsSet = false;

        while (p != null) {
            tempTailCurr = p;
            q = p.next;
            r = p;
            if (q == null) {
                tempTailPrev.next = p;
                p.next = null;
                break;
            }
            p = q.next;
            q.next = r;
            count = 1;
            while (p != null && count < k - 1) {
                r = q;
                q = p;
                p = p.next;
                q.next = r;
                count++;
            }

            if (p == null)
                tempTailCurr.next = null;

            tempHead = q;
            if (tempTailPrev != null)
                tempTailPrev.next = tempHead;
            tempTailPrev = tempTailCurr;
            tempTailCurr = null;

            if (!headIsSet) {
                l.head = q;
                headIsSet = true;
            }
        }
    }

    public static void main(String[] args) {
        LinkedList l1 = new LinkedList();
        l1.head = new Node(1);
        l1.appendToTail(2);
        l1.appendToTail(3);
        l1.appendToTail(4);
        l1.appendToTail(5);
        l1.appendToTail(6);
        l1.appendToTail(7);
        l1.appendToTail(8);
        l1.appendToTail(9);
        l1.appendToTail(10);
        l1.appendToTail(11);

        l1.displayList();
        reverse(l1, 10);
        System.out.println();
        l1.displayList();
    }
}
