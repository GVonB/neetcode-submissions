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
    public void reorderList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode revHalfHead = slow.next;

        // Reverse the linked list
        ListNode prev = null;
        while (revHalfHead != null) {
            ListNode temp = revHalfHead.next;
            revHalfHead.next = prev;
            prev = revHalfHead;
            revHalfHead = temp;
        }
        revHalfHead = prev;
        slow.next = null;

        // Alternate inserting nodes from each half into new list.
        ListNode first = head;
        ListNode second = revHalfHead;
        while (second != null) {
            ListNode tmp1 = first.next;
            ListNode tmp2 = second.next;

            first.next = second;
            second.next = tmp1;

            first = tmp1;
            second = tmp2;
            
        }
    }
}
