class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
          return head;
        }

        ListNode prev = null;
        while (head != null) {
          ListNode next = head.next;
          head.next = prev;
          prev = head;
          head = next;
        }
        return prev;
    }

    public ListNode reverseListII(ListNode head) {
        if (head == null || head.next == null) {
          return head;
        }

        ListNode newHead = reverseListII(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
}
