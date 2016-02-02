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
        if (head==null){
            return null;
        }
        ListNode dummy =  new ListNode(0);
        dummy.next = head;
        ListNode prev= dummy;
        ListNode fistPnt = head;
        ListNode sedPnt = head;
        for(int i =1;i<=n;i++){
            if (sedPnt!=null){
                sedPnt=sedPnt.next;
            } else {
                return null;
            }
        }

        while(sedPnt!=null){
            prev= fistPnt;
            fistPnt = fistPnt.next;
            sedPnt = sedPnt.next;

        }
        prev.next = fistPnt.next;
        return dummy.next;


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
        if (head==null){
            return null;
        }
        // write your code here
        ListNode right = new ListNode(0);
        ListNode dummyR =right;
        ListNode left= new ListNode(0);
        ListNode dummyL =left;

        ListNode cur = head;
        while(cur!=null){
            if(cur.val<x){

                left.next=cur;
                left = left.next;

            } else {

                right.next=cur;
                right = right.next;
            }
            cur = cur.next;
        }
        left.next = dummyR.next;
        right.next=null;
        return  dummyL.next;

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
        ListNode prevHead = new ListNode(0);
        prevHead.next=head;
        ListNode cur = head;
        ListNode next = head.next;
        while (next!=null){
            if(cur.val <= next.val){
                cur = next;
                next = next.next;
            } else {
                ListNode existingNext = insertFromHead(next, prevHead);
                cur.next = existingNext;
                next= existingNext;

            }
        }
        return prevHead.next;
    }

    private ListNode insertFromHead(ListNode node, ListNode prevHead){
        ListNode cur = prevHead.next;
        ListNode existingNext = node.next;
        ListNode prev= prevHead;
        while(cur.val <= node.val){
            prev = cur;
            cur = cur.next;

        }
        prev.next = node;
        node.next = cur;
        return existingNext;
    }

    public static ListNode deleteDuplicatesII(ListNode head) {
        if (head==null){
            return null;
        }
        if (head.next==null){
            return head;
        }
        ListNode origin = new ListNode(head.val-1);
        origin.next=head;
        ListNode prev = origin;


        ListNode cur = head;
        ListNode next = head.next;
        Set<Integer> set = new HashSet<Integer>();
        while(cur!=null && next!=null){

            if(set.contains(cur.val) ){
                prev.next=cur.next;
                cur = cur.next;
                next = cur.next;

            } else if (cur.val == next.val){

                set.add(cur.val);
                if (next.next!=null) {
                    cur = next.next;
                    next = next.next.next;
                    prev.next=cur;

                }else {
                    prev.next=null;
                    break;

                }

            }  else{
                set.add(cur.val);
                prev=cur;
                cur = next;
                next = next.next;

            }

        }
        if (next==null){
            if(set.contains(cur.val) ){
                prev.next = null;
            }
        }

        return  origin.next;
    }

    public static void main(String[] args){

         ListNode head = new ListNode(0);
        head.next=null;
        sortedListToBST(head);
    }
    public static ListNode deleteDuplicatesII_NO_SET(ListNode head) {
        if (head==null){
            return null;
        }
        if (head.next==null){
            return head;
        }
        ListNode origin = new ListNode(head.val-1);
        origin.next=head;
        ListNode prev = origin;


        ListNode cur = head;
        ListNode next = head.next;
        boolean foundDup=false;
        while(cur!=null && next!=null){

            while(next!=null && cur.val==next.val){
                foundDup  = true;
                cur.next = next.next;
                next = next.next;
            }


            if (foundDup) {
                prev.next = next;
                foundDup = false;

            }else{
                prev=cur;
            }
            cur  = next;
            if (next!=null) {
                next = next.next;
            }

        }
        return origin.next;

    }

    static public TreeNode sortedListToBST(ListNode head) {
        int l = getLength(head);
       return sortListToBstHelper(head, l);
    }

    static int getLength(ListNode node){
        int l = 0;
        while(node!=null){
            l++;
            node=node.next;
        }
        return l;
    }
    static ListNode getMid(ListNode node, int l){
        int mid = (l+1)/2-1;
        ListNode cur =node;
        while(mid>0 && cur!=null){
            cur=cur.next;
            mid--;
        }

        return cur;
    }
    static TreeNode sortListToBstHelper(ListNode head, int length){
        if(head==null || length==0){
            return null;
        }
        if (length==1){
            return new TreeNode(head.val);
        }

        ListNode mid = getMid(head, length);
        TreeNode root = new TreeNode(mid.val);
        root.left = sortListToBstHelper(head, (length+1) / 2-1);
        root.right = sortListToBstHelper(mid.next, length-(length+1)/2);

        return root;
    }

    public ListNode sortList(ListNode head) {
        // write your code here
        int l= getLength(head);

    }
    sortListHelper(ListNode node, int l){
        ListNode mid = getMid(node, l);
        if (mid==null){
            return node;
        }
        int leftPnt = 1;
        int leftEnd = (l+1)/2-1;
        int rightPnt = l-(l+1)/2;
        ListNode left = node;
        ListNode right   = mid.next;
        while(leftPnt <leftEnd && right!=null){
            while(leftPnt <leftEnd && left.val<=mid.val){
                left=left.next;
                leftPnt++;
            }
            while(right!=null&& right.val > mid.val){
                rightPnt++;
                right=right.next ;
            }
            if(leftPnt==leftEnd){
                break;
            }

        }

    }

}
