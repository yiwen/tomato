package leet;

import java.util.*;
import java.util.List;

/**
 * Created by ygao on 2/21/16.
 */
public class HeapProblems {
    class NodeComparator implements Comparator<ListNode> {
        public int compare(ListNode o1, ListNode o2) {
            if (o1 == null) {
                return -1;
            } else if (o2 == null) {
                return 1;
            } else if (o1 == null && o2 == null) {
                return 0;
            }
            return Integer.valueOf(o1.val).compareTo(Integer.valueOf(o2.val));
        }
    }

    public ListNode mergeKLists(List<ListNode> lists) {
        if (lists == null || lists.size() == 0) {
            return null;
        }
        PriorityQueue<ListNode> priorityQueue = new PriorityQueue<ListNode>(lists.size(), new NodeComparator());
        for (ListNode listNode : lists) {
            priorityQueue.add(listNode);
        }
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        while (!priorityQueue.isEmpty()) {
            ListNode cur = priorityQueue.poll();
            tail.next = cur;
            tail = tail.next;
            tail.next = null;
            if (cur.next != null) {
                priorityQueue.offer(cur.next);
            }
        }
        return dummy.next;
    }
/*
    public static void main(String[] args) {
    *//*    ListNode node = new ListNode(0);
        ListNode node1 = new ListNode(0);
        node.next=node1;
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        tail.next=node;
        tail = tail.next;
        tail.next=null;
        if (node.next!=null) {
            System.out.println("node.next:" + node.next);
        }else {
            System.out.println("node.next:null");

        }*//*

        String[] array = {"yes", "lint", "code", "yes", "code", "baby", "you", "baby", "chrome", "safari", "lint", "code", "body", "lint", "code"};
        HeapProblems problems = new HeapProblems();
        problems.topKFrequentWords(array, 3);
    }*/

    class ArrayElement {
        int[] array;
        int pos;

        public ArrayElement(int[] array, int pos) {
            this.array = array;
            this.pos = pos;

        }

        public int getVal() {
            return array[pos];
        }
    }

    class ArrayComparator implements Comparator<ArrayElement> {

        public int compare(ArrayElement o1, ArrayElement o2) {
            if (o1 == null && o2 == null) {
                return 0;
            }
            if (o1 == null) {
                return -1;
            }
            if (o2 == null) {
                return 1;
            }
            return Integer.valueOf(o1.getVal()).compareTo(o2.getVal());
        }
    }

    public List<Integer> mergekSortedArrays(int[][] arrays) {
        // Write your code here
        if (arrays == null || arrays.length == 0) {
            return new ArrayList<Integer>();
        }
        int row = arrays.length;
        int col = arrays[0].length;
        List<Integer> rst = new ArrayList<Integer>();
        PriorityQueue<ArrayElement> priorityQueue = new PriorityQueue<ArrayElement>(arrays.length, new ArrayComparator());
        for (int i = 0; i < arrays.length; i++) {
            if (arrays[i].length > 0) {

                priorityQueue.add(new ArrayElement(arrays[i], 0));
            }

        }
        int count = 0;
        while (!priorityQueue.isEmpty()) {
            ArrayElement top = priorityQueue.poll();
            int[] a = top.array;
            int pos = top.pos;
            int posn = pos + 1;
            rst.add(top.getVal());
            System.out.println(top.getVal());
            if (pos < a.length - 1) {
                priorityQueue.add(new ArrayElement(a, posn));
            }

        }
        return rst;
    }

    class WordFrequency {
        int count;
        String word;

        public WordFrequency(int count, String word) {
            this.count = count;
            this.word = word;
        }
    }

    class WordComparator implements Comparator<WordFrequency> {
        public int compare(WordFrequency o1, WordFrequency o2) {
            if (o1 == null && o2 == null) {
                return 0;
            }
            if (o1 == null) {
                return -1;
            }
            if (o2 == null) {
                return 1;
            }
            if (o1.count == o2.count) {
                return o1.word.compareToIgnoreCase(o2.word);
            } else {
                return Integer.valueOf(o1.count).compareTo(o2.count);
            }
        }
    }

    public String[] topKFrequentWords(String[] words, int k) {
        // Write your code here
        if (words.length == 0) {
            return null;
        }

        if (k > words.length) {
            return null;
        }

        Map<String, Integer> countMap = new HashMap<String, Integer>();
        for (String word : words) {
            if (countMap.containsKey(word)) {
                int count = countMap.get(word);
                countMap.put(word, count + 1);

            } else {
                countMap.put(word, 1);
            }
        }

        PriorityQueue<WordFrequency> queue = new PriorityQueue<WordFrequency>(words.length, new WordComparator());
        for (String word : countMap.keySet()) {
            queue.add(new WordFrequency(countMap.get(word).intValue(), word));
        }

        List<String> rst = new ArrayList<String>();
        while (!queue.isEmpty() && rst.size() < k) {
            WordFrequency wordFrequency = queue.poll();

            rst.add(wordFrequency.word);


        }

        return rst.toArray(new String[]{});
    }

    public long kthPrimeNumber(int k) {
        // write your code here
        int[] prime = new int[k + 1];
        prime[0] = 1;
        int i3 = 0;
        int i5 = 0;
        int i7 = 0;
        for (int i = 1; i <= k; i++) {
            prime[i] = Math.min(Math.min(prime[i3] * 3, prime[i5] * 5), prime[i7] * 7);
            if (prime[i] % prime[i3] == 0) {
                i3++;
            }
            if (prime[i] % prime[i5] == 0) {
                i5++;
            }
            if (prime[i] % prime[i7] == 0) {
                i7++;
            }
        }
        return prime[k];
    }

    public long kthPrimeNumber_heap(int k) {
        PriorityQueue<Long> queue = new PriorityQueue<Long>();
        HashSet<Long> set = new HashSet<Long>();
        if (k == 1) {
            return 3L;
        }
        if (k == 2) {
            return 5L;
        }
        if (k == 3) {
            return 7L;
        }
        queue.offer(3L);
        queue.offer(5L);
        queue.offer(7L);

        int count = 0;
        while (count < k) {
            long number = queue.poll();
            if (!set.contains(number)) {
                set.add(number);
                count++;

                if (k == count) {

                    return number;
                } else {

                    queue.offer(number * 3);
                    queue.offer(number * 5);
                    queue.offer(number * 7);
                }
            }
        }

        return 0L;

    }

    public static void main(String[] args) {

        HeapProblems problems = new HeapProblems();
        problems.medianSlidingWindow(new int[]{1,2,7,7,2},3);
    }

    class minComp implements Comparator<Integer> {
        public int compare(Integer o1, Integer o2) {
            return Integer.compare(o1, o2);
        }
    }

    class maxComp implements Comparator<Integer> {
        public int compare(Integer o1, Integer o2) {
            return -Integer.compare(o1, o2);
        }
    }


    PriorityQueue<Integer> left = new PriorityQueue<Integer>(new minComp());
    PriorityQueue<Integer> right = new PriorityQueue<Integer>(new maxComp());

    int total = 0;

    public void insertIntoInStream(int tmp) {
        /*if (nums==null || nums.length<k){
            return new  int[]{};
        }*/
        if (total==0){
            left.add(tmp);
            return;
        }

        int leftMax = left.peek();
        if (tmp < leftMax) {
            left.add(tmp);
            right.add(left.poll());
        } else {
            right.add(tmp);
            if (total % 2 == 0) {
                left.add(right.poll());
            }
        }
        total++;


    }


    public int[] medianII(int[] nums) {
        if (nums==null|| nums.length==0) {
            return new int[]{};
        }

        int[] rst = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            insertIntoInStream(nums[i]);
            rst[i] = left.peek();
        }
        return rst;
    }

    public ArrayList<Integer> medianSlidingWindow(int[] nums, int k) {
        // write your code here
        ArrayList<Integer> rst =  new ArrayList<Integer>();

        if (k>nums.length){
            return rst;
        }


        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>(k);
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(k, Collections.reverseOrder());
        int maxLen = k%2==0? k/2: (k+1)/2;
        int minLen = k%2==0? k/2: (k-1)/2;

        for(int i =0;i<k;i++){


            if(maxHeap.isEmpty() ||nums[i]<=maxHeap.peek()){
                maxHeap.add(nums[i]);
            }else if(!maxHeap.isEmpty() || nums[i]>maxHeap.peek()){
                minHeap.add(nums[i]);
            }
            if (maxHeap.size()>maxLen){
                minHeap.add(maxHeap.poll());
            }
            if (minHeap.size()>minLen){
                maxHeap.add(minHeap.poll());
            }


        }
        rst.add(maxHeap.peek());

        for(int i =k;i<nums.length;i++){


            if (nums[i]<=maxHeap.peek()){
                maxHeap.add(nums[i]);
            }else{
                minHeap.add(nums[i]);
            }

            int toRmv=i-k;
            if(nums[toRmv]<=maxHeap.peek()){
                maxHeap.remove(nums[toRmv]);
            }else{
                minHeap.remove(nums[toRmv]);
            }

            if(maxHeap.size()>minHeap.size()+1){
                minHeap.add(maxHeap.poll());
            }
            if(maxHeap.size()<minHeap.size()){
                maxHeap.add(minHeap.poll());
            }

            if(i>= k-1){
                rst.add(maxHeap.peek());
            }

        }
        return rst;

    }






}