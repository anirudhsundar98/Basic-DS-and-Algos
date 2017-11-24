package List;

import DynamicProgramming.LIS;

// https://leetcode.com/problems/odd-even-linked-list/description/
public class OddEvenList {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode oddEvenList(ListNode head) {
        if (head == null)
            return null;

        ListNode temp = head, evenBuffer = null, firstEvenBuffer = null, lastOddBuffer = null;
        int count = 1;
        while (temp != null || evenBuffer != null) {
            if (count % 2 == 1) {
                evenBuffer = temp.next;
                if (temp.next != null && temp.next.next != null) {
                    temp.next = temp.next.next;
                    temp = temp.next;
                } else {
                    lastOddBuffer = temp;
                    temp = null;
                }

            } else {
                if (count == 2)
                    firstEvenBuffer = evenBuffer;

                if (evenBuffer.next != null && evenBuffer.next.next != null) {
                    evenBuffer.next = evenBuffer.next.next;
                    evenBuffer = evenBuffer.next;
                } else {
                    evenBuffer.next = null;
                    evenBuffer = null;
                }

            }
            count++;
        }

        lastOddBuffer.next = firstEvenBuffer;
        return head;
    }

    static void print(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ListNode head = null;
//        ListNode head = new ListNode(1);
//        head.next = new ListNode(2);
//        head.next.next = new ListNode(3);
//        head.next.next.next = new ListNode(4);
//        head.next.next.next.next = new ListNode(5);
//        head.next.next.next.next.next = new ListNode(6);
//        head.next.next.next.next.next.next = new ListNode(7);
//        head.next.next.next.next.next.next.next = new ListNode(8);
//        head.next.next.next.next.next.next.next.next = new ListNode(9);

        print(head);
        head = oddEvenList(head);
        print(head);
    }
}
