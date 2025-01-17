// 143. Reorder List

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
        
        if(head == null)
            return;
        
        // get the mid of the list
        
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        // Reverse the list
        
        fast = reverse(slow.next);
        
        // merge two lists 
        slow.next = null;
        
        // This if to put back slow to the head again.
        slow = head;
        
        while(fast != null) {
            ListNode temp = slow.next;
            slow.next = fast;
            fast = fast.next;
            slow.next.next = temp;
            slow = temp;
        }
    }
    
    // function to reverse 
    private ListNode reverse(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ListNode reversed = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return reversed;
    } 
}

/*
Complexity Analysis

Time complexity: 
O(N). There are three steps here. 
- To identify the middle node takes O(N) time. 
- To reverse the second part of the list, one needs N/2 operations. 
- The final step, to merge two lists, requires N/2 operations as well. 
In total, that results in O(N) time complexity.

Space complexity: 
O(1), since we do not allocate any additional data structures.
*/