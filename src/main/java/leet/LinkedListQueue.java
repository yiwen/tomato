package leet;

import java.util.*;

/**
 * Created by ygao on 2/18/16.
 */
public class LinkedListQueue {
    public  class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }

    }
    public class Queue1 {


        ListNode head;
        ListNode last;
        public Queue1() {
            // do initialize if necessary

            head = new ListNode(0);
            last = null;

        }

        public void enqueue(int item) {
            // Write your code here
            if (head.next!=null){
                ListNode tmp=new ListNode(item);
                last.next = tmp;
                last = last.next;
            } else{
                last =new ListNode(item);
                head.next=last;
            }

        }

        public int dequeue() {
            // Write your code here


            if (head.next!=null) {
                ListNode cur = head.next;
                ListNode tmp = cur.next;
                head.next = tmp;

                return cur.val;
            } else {
                last=null;
                return 0;
            }

        }
    }

    public class Dequeue {
        ListNode head ;

        ListNode last;
        public Dequeue() {
            // do initialize if necessary
            head = new ListNode(0);

        }

        public void push_front(int item) {
            // Write your code here
            ListNode next = head.next;
            ListNode tmp =new ListNode(item);
            head.next = tmp;
            tmp.next=next;

        }

        public void push_back(int item) {
            // Write your code here
            if(head.next==null){
                ListNode tmp =new ListNode(item);
                last = tmp;
                head.next=last;
            }else {
                ListNode tmp =new ListNode(item);

                last.next=tmp;
                last=last.next;

            }

        }

        public int pop_front() {
            // Write your code here
            ListNode pop = head.next ;
            if (pop!=null){
                ListNode next = pop.next;
                head.next=next;
            }else{
                last=null;
            }

            return pop.val;

        }

        public int pop_back() {
            // Write your code here
            ListNode cur = head.next;
            ListNode prev = head;

            while(cur.next!=null){
                cur = cur.next;
                prev=prev.next;
            }
            prev.next = null;
            last = prev;
            return cur.val;


        }
    }

    static int maxDifference(int[] a) {
        if (a==null || a.length<2){
            return -1;
        }
        int maxDiff = 0;
        int minSofar = a[0];
        for(int i=1;i<a.length;i++){
            minSofar = Math.min(minSofar, a[i]);
            maxDiff = Math.max(maxDiff, a[i] - minSofar);

        }
        return maxDiff > 0 ? maxDiff : -1;


    }

    static String[] palindromize(String[] words) {
        if (words==null || words.length==0){
            return new String[]{"-1", "-1", "-1"};
        }
        String[] rst = new String[words.length];
        for(int i = 0; i <words.length;i++){
            rst[i]= palindromizeOneWord(words[i]);
        }
        return rst;
    }

    static String palindromizeOneWord(String word){
        if (word==null || word.length()==0){
            return "-1";
        }
        Set<Character> characterSet = new HashSet<Character>();
        int l = word.length();
        char[] newWord = new char[l];
        int start = 0;
        int end = l-1;
        for(int i=0 ;i<word.length(); i++){
            Character character = Character.valueOf(word.charAt(i));
            if(characterSet.contains(character)){
                newWord[start]=character;
                newWord[end]=character;
                start++;
                end--;
                characterSet.remove(character);
            }else{
                characterSet.add(character);
            }

        }
        if (characterSet.size()==1){
            Iterator<Character> iterator = characterSet.iterator();
            Character character = iterator.next();
            newWord[l/2]=character;
            return new String(newWord);
        } else if (characterSet.size() ==0){
            return new String(newWord);

        }else {
            return "-1";
        }



    }

}
