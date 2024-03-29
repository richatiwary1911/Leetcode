/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
         Node curr = head;   
        Node fwd = head;    
        
        //inserting the node 
        while(curr != null) {
            fwd = curr.next;
            Node copy = new Node(curr.val);
            curr.next = copy;
            copy.next = fwd;
            
            curr = fwd;
        }
        
        //making the random links
        curr = head;
        while(curr != null) {
            if(curr.random != null) {
                curr.next.random = curr.random.next;
            }    
            curr = curr.next.next;
        }
        
        //restoring the links 
        curr = head;
        
        Node dummy = new Node(0);   
        Node copy = dummy;          
        
        while(curr != null) {
            fwd = curr.next.next;
            copy.next = curr.next;
            curr.next = fwd;
            
            curr = curr.next;             
            copy = copy.next;
                       
        }
        return dummy.next;
    }
}