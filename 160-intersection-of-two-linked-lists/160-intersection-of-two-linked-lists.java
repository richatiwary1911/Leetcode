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
        
        int diff = len1 - len2;
        if(diff < 0) {
            while(diff ++ < 0) {
                headB = headB.next;
            }
        } else {
            while(diff -- > 0) {
                headA = headA.next;
            }
        }
        
        while(headA != null) {
            if(headA == headB) return headA;
            
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }
    
    public int getLength(ListNode head) {
        int len = 0;
        while(head != null) {
            len++;
            head = head.next;
        }
        return len;
    }
}