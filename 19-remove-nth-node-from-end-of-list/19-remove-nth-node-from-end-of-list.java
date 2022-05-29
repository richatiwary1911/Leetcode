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
                
        ListNode dummy = new  ListNode();
        dummy.next = head;
        
        ListNode slow = dummy;
        ListNode fast = dummy;
        
        for(int i = 0; i < n; i++)
            fast = fast.next;
        
        while(fast.next != null) {
            
            fast = fast.next;
            slow = slow.next;            
        }
        
        slow.next = slow.next.next;
        return dummy.next;
        
        


//         ListNode curr = head;
//         ListNode dummy = new ListNode(0);
//         dummy.next = head;
//         int len = 0;
        
//         while(curr != null) {
//             len ++;      
//             curr = curr.next;
//         }
        
//         int k = len - n;
//         curr = dummy;
//         while(k -- > 0) {
//             curr = curr.next;
//         }
//         curr.next = curr.next.next;
//         return dummy.next;
     } 
    
    
    
}