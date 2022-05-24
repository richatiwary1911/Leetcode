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
    public ListNode reverseKGroup(ListNode head, int k) {
        
        if(head == null || k == 1) return head;
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode curr = dummy; 
        ListNode fwd = dummy; 
        
        int length = 0;
        
        while(curr.next != null) {
            length ++;
            curr = curr.next;
        }
        
        while(length >= k) {
            curr = pre.next;
            fwd = curr.next;
            
            for(int i = 1; i < k; i++) {
                curr.next = fwd.next;
                fwd.next = pre.next;
                pre.next = fwd;
                fwd = curr.next;
            }
            
            pre = curr;
            length -= k;
        }
        return dummy.next;       
    }
}