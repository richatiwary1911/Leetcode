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
       
        int len = getLength(head);
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        ListNode prev = dummy;
        ListNode curr = dummy;
        ListNode fwd = dummy;
        
        while(len >= k) {
            curr = prev.next;  
            fwd = curr.next;
            
            for(int i = 1; i < k; i++) {
                curr.next = fwd.next;
                fwd.next = prev.next;
                prev.next = fwd;
                fwd = curr.next;
            }
            prev = curr;
            len -= k;
        }
        return dummy.next;
    }
    
    public int getLength(ListNode head) {
       
        int len = 0;
        
        while(head != null) {
            len ++;
            head = head.next;
        }
        return len;
    }
}