package leet;

import java.util.HashSet;
import java.util.Set;


public class LinkedListProblems {


    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
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
        if (head == null){
            return head;

        }
        ListNode cur = head;
        ListNode tmp = null;
        ListNode next = null;
        ListNode prev=null;
        boolean isHead=true;
        while (cur != null){
            if (isHead) {
                tmp = cur.next;
                cur.next=prev;
                prev = cur;

                if (tmp!=null){
                    next = tmp.next;
                }
                cur = tmp;
                isHead = false;

            }  else {
                cur.next = prev;
                prev = cur;
                 if (next!=null){
                    tmp = next.next;
                    next.next = cur;
                    cur=next;
                    next = tmp;

                 }else{
                 cur =null;
                 }


            }


        }
        if (prev !=null){
            return prev;
        } else {
            return head;
        }

    }

    public int removeElement(int[] A, int elem) {
        if (A == null || A.length == 0)  {
            return 0;
        }
        int fillStart =0;
        for (int i=0; i<A.length; i++){

            if (A[i] == elem){

                continue;


            } else {
                A[fillStart] = A[i];
                fillStart++;

            }
        }
        return fillStart;

    }
    public static ListNode partition(ListNode head, int x) {
        // write your code here
        ListNode leftTail =null;
        ListNode leftStart=new ListNode(0);
     //   leftStart.next = leftTail;
       leftTail = leftStart;
        ListNode rightTail = null;
        ListNode prev= null;
        ListNode rightStart = new ListNode(0);
        rightTail = rightStart;
       // rightStart.next = rightTail;
        ListNode cur = head;
        while(cur!=null){
            ListNode tmp = new ListNode(cur.val);
            tmp.next = cur.next;
            if (cur.val < x){
           //     prev  = leftTail==null? leftStart : leftTail;

                leftTail.next = cur;
                leftTail = cur;


            }  else {
           //     prev  = rightTail==null? rightStart : rightTail;

                rightTail.next = cur;
                rightTail=cur;


            }
            cur = cur.next;
        }
        rightTail.next=null;

        leftTail.next = rightStart.next;
         return leftStart.next;
    }

    public static void main(String[] args){
        ListNode n1 = new ListNode(4, null);
        ListNode n2 = new ListNode(2, n1);
        ListNode n3 = new ListNode(1, n2);
        ListNode n4 = new ListNode(3, n3);
        ListNode n5 = new ListNode(3, n4);

        partition(n5, 3);
    }


    public void deleteNode(ListNode node) {
        // write your code here
        ListNode cur = node;
        if (cur !=null) {
            ListNode tmp = cur;
            ListNode next = cur.next;
            if (next != null) {
                tmp.val = next.val;
                tmp.next = next.next;
            }
        }

    }

    public ListNode addLists(ListNode l1, ListNode l2) {
        ListNode n1 = l1;
        ListNode n2 = l2;
        ListNode n3 = new ListNode(0);
        ListNode n4= n3;
        boolean add1 = false;

        ListNode tmp = null;
        // write your code here
        while(n1 != null || n2 !=null){
            if (n1 !=null && n2 !=null ) {
                int sum = add1 ? n1.val + n2.val + 1 : n1.val + n2.val;

                if (sum < 10) {
                    tmp = new ListNode(sum);
                    add1 = false;
                } else {
                    add1 = true;
                    tmp = new ListNode(sum - 10);
                }
                n4.next = tmp;
                n4 = n4.next;
                n1 = n1.next;
                n2 = n2.next;
            } else if (n1 == null && n2 !=null){
                n4.next = add1? new ListNode (n2.val+1) : n2;
                n4 = n4.next;
                n2= n2.next;
                add1 = false;
            } else if (n1 != null && n2 ==null){
                n4.next = add1? new ListNode (n1.val+1) : n1;
                n4 = n4.next;
                n1=n1.next;
                add1 = false;
            }

        }

        if (add1){
            tmp = new ListNode(1);
            n4.next=tmp;

        }


        return n3.next;
    }

    ListNode nthToLast(ListNode head, int n) {
        ListNode cur = head;
        ListNode nth = null;
        int i = 0;
        while(i<n && cur!=null){

            cur = cur.next;
            i++;
        }

        nth = cur;
        cur = head;
        while(nth!=null) {
            nth=nth.next;
            cur = cur.next;
        }
        return cur;

    }

    public ListNode insertionSortList(ListNode head) {
        return null;// write your code here
    }






}
