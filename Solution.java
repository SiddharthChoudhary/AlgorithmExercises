import java.util.ArrayList;
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
 class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
 }
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length==0){
            return new ListNode(0);
        }
        ListNode initial = lists[0];
        ListNode head    = initial;
        for(int i=1;i<lists.length-1;i++){
            initial = callRecursively(initial,lists[i]);
        }
        return initial;
    }
    public ListNode callRecursively(ListNode l1, ListNode l2){
        ListNode temp = l1;
        ListNode temp2= l2;
        ListNode head = new ListNode(0);
        ListNode temporary=head;
        while(temp!=null){
            while(temp2!=null&&temp2.val<temp.val){
                temporary.next = temp2;
                temporary      = temp2;
                temp2          = temp.next;
            }
            temporary.next = temp;
            temporary      = temp;
            temp           = temp.next;
        }
            temporary.next  = temp2;
        return head.next;
    }
    public static void main(String[] args){

    }
}
