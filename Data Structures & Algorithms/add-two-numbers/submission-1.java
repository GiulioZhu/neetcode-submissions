/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode();
        ListNode ans = new ListNode();
        int reminder = 0;
        head.next = ans;
        while(l1!=null && l2 != null) {
            ans.val += l1.val + l2.val;
            if (ans.val >= 10) {
                reminder = 1;
                ans.val = ans.val % 10;
            } else {
                reminder = 0;
            }

            
            ans.next = new ListNode();
            ans.next.val += reminder;

            if (l1.next == null && l2.next == null && ans.next.val == 0) {
                ans.next = null;
            }
            ans = ans.next;
            
            l1 = l1.next;
            l2 = l2.next;
        }

        while(l1 != null) {
            ans.val += l1.val;

            if (ans.val >= 10) {
                reminder = 1;
                ans.val = ans.val % 10;
            } else {
                reminder = 0;
            }

            ans.next = new ListNode();
            ans.next.val += reminder;

            if (l1.next == null && ans.next.val == 0) {
                ans.next = null;
            }
            ans = ans.next;
            l1 = l1.next;
        }
        while(l2 != null) {
            ans.val += l2.val;

            if (ans.val >= 10) {
                reminder = 1;
                ans.val = ans.val % 10;
            } else {
                reminder = 0;
            }

            ans.next = new ListNode();
            ans.next.val += reminder;

            if (l2.next == null && ans.next.val == 0) {
                ans.next = null;
            }

            ans = ans.next;
            l2 = l2.next;
        }

        return head.next;
    }
}
