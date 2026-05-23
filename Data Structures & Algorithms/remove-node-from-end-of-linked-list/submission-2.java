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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode prev = null;
        while(head != null) {
            ListNode tmp = head.next;
            head.next = prev;
            prev = head;
            head = tmp;
        }

        ListNode dummy = new ListNode(-1);
        dummy.next = prev;
        int count = 1;
        while(dummy!=null) {
            ListNode tmp = dummy.next;
            if (count == n) {
                tmp = dummy.next.next;
            } 
            dummy.next = head;
            head = dummy;
            dummy = tmp;
            count++;
        }

        ListNode ptr = head;
        if (ptr.val == -1) return null;
        while(ptr.next.next != null) {
            ptr = ptr.next;
        }
        ptr.next = null;

        return head;
    }
}
