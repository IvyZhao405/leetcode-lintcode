class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
      ListNode dummy = new ListNode(0);
      ListNode cur = dummy;
      int carry = 0;
      while (l1 != null || l2 != null) {
        int v1 = (l1 != null) ? l1.val : 0;
        int v2 = (l2 != null) ? l2.val : 0;
        int sum = v1 + v2 + carry;
        carry = sum / 10;
        cur.next = new ListNode(sum % 10 );
        cur = cur.next;
        if (l1 != null) l1 = l1.next;
        if (l2 != null) l2 = l2.next;
      }

      if (carry != 0) {
        cur.next = new ListNode(carry);
      }
      return dummy.next;
    }
}
