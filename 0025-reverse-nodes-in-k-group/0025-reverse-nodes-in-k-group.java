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
    static ListNode reverse(ListNode head){
        if(head==null || head.next==null){
            return head;
        }
        ListNode prev = null;
        while(head!=null){
            ListNode curr = head.next;
            head.next = prev;
            prev = head;
            head = curr;
        }
        return prev;
    }
    static ListNode Find(ListNode curr,int k){
        ListNode temp = curr;
        while(temp!=null && --k>0){
            temp = temp.next;
        }
        return temp;
    }
    static ListNode Last(ListNode head){
        ListNode temp = head;
        while(temp.next!=null){
            temp = temp.next;
        }
        return temp;
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        ListNode temp = head;
        ListNode prev = dummy;
        while(temp!=null){
            ListNode kth = Find(temp,k);
            
            if(kth==null){
                if(prev!=null){
                    prev.next = temp;
                }
                break;
            }

            ListNode pointer = kth.next;

            kth.next = null;

            ListNode newNode = reverse(temp);

            if(dummy.next==null){
                dummy.next = newNode;
            }
            
            prev.next = newNode;

            ListNode rev_last = Last(newNode);

            rev_last.next = pointer;

            prev = rev_last;

            temp = pointer;

        }
        return dummy.next;
        
    }
}