/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {        
        
        int len1 = getLength(headA);
        int len2 = getLength(headB);
        
        if(len1 > len2) {
            int k = len1 - len2;
            while(k -- > 0) {
                headA = headA.next;
            }
        } else {
           int k = len2 - len1;
            while(k -- > 0) {
                headB = headB.next;
            } 
        }
        
        while(headA != null || headB != null) {
            if(headA == headB) return headA;
            
            headA = headA.next;
            headB = headB.next;
        }
        return headA;        
    }
    
    public int getLength(ListNode head) {
        ListNode curr = head;
        int len = 0;
        while(curr != null) {
            len ++;
            curr = curr.next;
        }
        return len;
    }
}