package List;

public class PairSwap {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    static ListNode swapPairs(ListNode head) {
        if (head == null)
            return null;

        if (head.next == null)
            return head;

        ListNode oddNode = head, evenNode = head.next, hold;
        ListNode returnNode = head.next;

        while (oddNode != null && evenNode != null) {
            hold = evenNode.next;
            evenNode.next = oddNode;
            if (hold != null && hold.next != null)
                oddNode.next = hold.next;
            else oddNode.next = hold;

            oddNode = hold;
            if (hold != null)
                evenNode = hold.next;
        }

        return returnNode;
    }

    static void displayList(ListNode head) {
        ListNode temp = head;
        int count = 0;
        while (temp != null) {
            System.out.println(temp.val);
            temp = temp.next;
            count++;
            if (count == 6)
                break;
        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
//        head.next.next.next.next.next = new ListNode(6);

        displayList(swapPairs(head));
    }
}
