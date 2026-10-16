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
    public ListNode mergeKLists(ListNode[] lists) {
        Queue<ListNode> pq = new PriorityQueue<>(Comparator.comparingInt((ListNode n) -> n.val));

        for (ListNode list : lists) {
            while(list != null) {
                pq.add(list);
                list = list.next;
            }
        }

        ListNode head = new ListNode();
        ListNode node = head;

        while (!pq.isEmpty()) {
            node.next = pq.poll();
            node = node.next;
        }

        return head.next;
    }
}
