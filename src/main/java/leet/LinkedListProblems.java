package leet;

import java.util.HashSet;
import java.util.Set;


public class LinkedListProblems {


    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static ListNode deleteDuplicates(ListNode head) {
        Set<Integer> map = new HashSet<Integer>();
        ListNode cur = head;
        ListNode prev=head;

        while (cur != null){
            if (map.contains((Integer)(cur.val))){
                prev.next = cur.next;

            } else {
                map.add((Integer) cur.val);

                prev = cur;
            }
            cur = cur.next;
        }
        return head;
    }

    ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode cur = head;
        ListNode nth = null;
        int i =1;
        while(i < n){
            if (cur!=null) {
                cur = cur.next;
                i++;
            } else {
               return head;
            }

        }
        ListNode start = head;
        ListNode prev = null;
        nth = cur;
        while(nth.next!=null){
            nth = nth.next;
            prev = start;
            start = start.next;
        }
        if (prev!=null){
            prev.next=start.next;
            return head;

        } else {
            return head.next;
        }

    }

    public ListNode reverse(ListNode head) {
        // write your code here
    }



}
