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
    public boolean isPalindrome(ListNode head) {
        
        ListNode slow = head;
        ListNode fast = head;
        ListNode dummy = head;
        
        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        slow.next = reverse(slow.next);
        slow = slow.next;
        
        while(slow != null) {
            
            if(dummy.val != slow.val) return false;
            
            dummy = dummy.next;
            slow = slow.next;
            
        }
        return true;
    }
    
    public ListNode reverse(ListNode head) {
        
        ListNode prev = null;
        ListNode curr = head;
        ListNode fwd;
        
        while(curr != null) {
            fwd = curr.next;
            curr.next = prev;
            prev = curr;
            curr = fwd;
        }
        
        head = prev;
        return head;        
    }
}