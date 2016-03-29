package leet;

import java.util.*;


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

    public static void main(String[] args){

         ListNode head = new ListNode(2);
        ListNode l2=new ListNode(4);
        head.next=l2;
        l2.next=null;

        List<ListNode> lists = new ArrayList<ListNode>();
        lists.add(head);
        ListNode head2=new ListNode(0);
        head2.next=null;
        ListNode head3 = new ListNode(-1);
         head2.next=null;
        lists.add(head2);
        lists.add(head3);

        mergeKSortedList(lists);
    }


    public ListNode findMiddle(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        while(fast!=null&fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }

        return slow;
    }

    public static ListNode middleNode(ListNode head) {
        // Write your code here
        if (head==null){
            return null;
        }
        if (head.next==null){
            return head;
        }
        ListNode slow = new ListNode(0);
        slow.next=head;
        ListNode fast = new ListNode(0);
        fast.next =head;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast =fast.next.next;
        }
        return slow;
    }
    public static  ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            // write your code here
        ListNode cur1 = l1;
        ListNode cur2 = l2;
        ListNode dummy = new ListNode(0);

        ListNode rst = dummy;

        while(cur1!=null && cur2!=null){
            if (cur1.val < cur2.val){
                rst.next=cur1;
                cur1 = cur1.next;
                rst = rst.next;
            }  else{
                rst.next = cur2;
                cur2=cur2.next;
                rst = rst.next;
            }
        }
        if (cur1==null){
            rst.next = cur2;
        }   else {
            rst.next=cur1;
        }
        return dummy.next;

    }

    public static  ListNode mergeKSortedList(List<ListNode> list){
      if(list==null || list.size()==0){
          ;
      }
        ListNode cur = list.get(0);
      for (int i=1;i<list.size();i++){
         cur = mergeTwoLists(cur, list.get(i));

      }
       return cur;

    }

    public ListNode mergeKLists(List<ListNode> lists) {
          // write your code here
        if (lists==null ||lists.size()==0){
            return null;
        }
        ListNode cur = lists.get(0);
        for (int i=1; i<lists.size();i++){
            cur = mergeTwoLists(cur, lists.get(i));

        }
        return cur;
      }


   class RandomListNode {
         int label;
         RandomListNode next, random;
        RandomListNode(int x) { this.label = x; }
   };



    public void reorderList(ListNode head) {
        // write your code here
        if (head==null){
            return ;


        }
        if (head.next==null){
            return ;
        }
        ListNode mid = findMiddle(head);
        ListNode dummy = new ListNode(0);
        ListNode begin = head;
        ListNode end = reverseList(mid);
        ListNode tmp = dummy;
        boolean fromBegin = true;
        while(end!=null && begin!=null ){
            if(fromBegin){
                tmp.next=  begin ;
                begin= begin.next;

                fromBegin=false;
            }else {
                tmp.next=end;
                end = end.next;

                fromBegin=true;
            }
            tmp=tmp.next;


        }



    }

    public ListNode reverseList(ListNode head){
        if (head==null){
            return null;
        }
        if (head.next==null){
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next=head;
        ListNode prev=dummy ;
        ListNode cur=head ;
        while(cur!=null){
            ListNode next = cur.next;
            cur.next=prev;
            prev=cur;
            cur=next;


        }
         head.next=null;

        return prev;


    }
    public RandomListNode copyRandomList(RandomListNode head) {
        // write your code here
        if(head==null){
            return null;
        }

        RandomListNode cur =head;
        Set<RandomListNode> set = new HashSet<RandomListNode>();
        RandomListNode dummy = new RandomListNode(0);
        RandomListNode clone = dummy;

        while(cur!=null){

            RandomListNode   node = new RandomListNode(cur.label);

            set.add(node);
            clone.next=node;
            cur=cur.next;
            clone=clone.next;
        }
        RandomListNode clonePnt = dummy.next;
        cur =head;
        while(cur!=null){
           RandomListNode random = cur.random;
            if (set.contains(random)){
                clonePnt.random=random;
            }else{
                clonePnt.random=new RandomListNode(random.label);
            }
            clonePnt = clonePnt.next;
        }

        return dummy.next;

    }

    public ListNode reverseBetween(ListNode head, int m , int n) {
        // write your code
        if (head==null){
            return null;
        }
        if (head.next==null){
            return head;
        }
        ListNode m_1Node = findN_1thNode(head, m);
        ListNode mNode =m_1Node.next;

        ListNode n_1Node = findN_1thNode(head, n);
        ListNode nNode = n_1Node.next;
        ListNode nnNode = nNode.next;

        int length = n-m+1;

        ListNode prev = m_1Node;
        ListNode cur = mNode;
        int count =0;
        while(count<length){
            ListNode next = cur.next;
            cur.next=prev;
            prev = cur;
            cur = next;
            count++;
        }


        if (m>1) {
            m_1Node.next = cur;
            mNode.next = nnNode;
            return head;
        }else {

            mNode.next=nnNode;
            return cur;
        }
    }


    ListNode findN_1thNode(ListNode head, int n){
        ListNode cur = new ListNode(0);
        cur.next=head;
        int count=0;
        while(cur!=null && count<n-1){
            cur = cur.next;
            count++;
            if(count==n-1){
                return cur;

            }
        }
        return cur;

}

    ListNode mergTwoHeads(ListNode n1, ListNode n2){
        ListNode dummy= new ListNode(0);
        ListNode cur= dummy;

        while (n1!=null && n2!=null){
            if(n1.val<n2.val){
                cur.next=n1;
                n1=n1.next;
                cur=cur.next;
            }else{
                cur.next=n2;
                n2=n2.next;
                cur=cur.next;

            }
        }
        if (n1==null){
            cur.next=n2;
        }else {
            cur.next=n1;
        }
        return dummy.next;
    }

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode mid = findMiddle(head);
        ListNode right = sortList(mid.next);
        mid.next = null;
        ListNode left = sortList(head);

        return mergeTwoLists(left, right);

    }

    public ListNode detectCycle(ListNode head) {
        // write your code here
        if (head==null || head.next==null){

            return null;
        }
        ListNode slow= head;
        ListNode fast =head;
        while(fast!=null|| fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(slow!=fast){
                return  findMeetPoint(head, fast);
            }
        }
        return null;
    }

    ListNode findMeetPoint(ListNode head, ListNode k){
        ListNode cur = head;
        while (cur!=k){
            cur=cur.next;
            k=k.next;
        }
        return cur;
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // Write your code here
        if (headA==null || headB==null){
            return null;
        }
        ListNode dummyA =headA;
        ListNode dummyB = headB;
        int lenA = 0;
        int lenB =0;
        while(dummyA!=null){
            lenA++;
            dummyA = dummyA.next;
        }
        while(dummyB!=null){
            lenB++;
            dummyB = dummyB.next;
        }
        if(lenB > lenA){
            int tmp =lenB;
            while(tmp> lenA){
                tmp--;
                dummyB=dummyB.next;
            }
        }else if(lenB < lenA){
            int tmp =lenA;
            while(tmp> lenB){
                tmp--;
                dummyA=dummyA.next;
            }
        }else{
            while(dummyB!=null && dummyA !=null ){
                if(dummyB.val !=dummyA.val){
                    return dummyA;
                }

                dummyB=dummyB.next;
                dummyA=dummyA.next;
            }

        }
        return null;


    }
}
