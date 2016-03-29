package leet;

import java.util.*;
import java.util.concurrent.SynchronousQueue;

/**
 * Created by ygao on 2/16/16.
 */
public class DataStructure {

    class QueueStack {
        Queue<Integer> topQ;
        Queue<Integer> remainQ;

        public QueueStack() {
            this.topQ =  new LinkedList<Integer>();
            this.remainQ = new LinkedList<Integer>();
        }

        // Push a new item into the stack
        public void push(int x) {

            topQ.offer(x);
            while(topQ.size()!=1){
                int tmp =topQ.poll();
                remainQ.offer(tmp);
            }
        }

        // Pop the top of the stack
        public void pop() {
            // Write your code here
            topQ.poll();
            while(remainQ.size()>1){
                int tmp =remainQ.poll();
                topQ.offer(tmp);
            }
            if(remainQ.size()==1) {
                int last = remainQ.poll();
                while (!topQ.isEmpty()) {
                    int tmp = topQ.poll();

                    remainQ.offer(tmp);
                }
                topQ.offer(last);
            }
        }
        // Return the top of the stack
        public int top() {

            return topQ.peek();

        }

        // Check the stack is empty or not.
        public boolean isEmpty() {
            // Write your code here
            return topQ.isEmpty() && remainQ.isEmpty();
        }
    }


    public class MinStack {
        Stack<Integer> minStack;
        Stack<Integer> stack;
        int min = Integer.MAX_VALUE;
        public MinStack() {
            // do initialize if necessary
            minStack = new Stack<Integer>();
            stack=new Stack<Integer>();
        }

        public void push(int number) {
            // write your code here
            stack.push(number);
           if(minStack.isEmpty()){
               minStack.push(number);
           }else{
               minStack.push(Math.min(minStack.peek(), number));
           }
        }

        public int pop() {
            // write your code here
            minStack.pop();
            return stack.pop();
        }

        public int min() {
            // write your code here
            return minStack.peek();
        }
    }

    public int largestRectangleArea(int[] height) {
        if (height==null || height.length==0){
            return 0;
        }
        // write your code here
        int max = Integer.MIN_VALUE;
        Stack<Integer> stack = new Stack<Integer>();

        for(int i=0 ; i<= height.length;i++){
            int tmp = i != height.length ? height[i] : -1;

            while(!stack.empty() &&height[stack.peek()]>=tmp){
                int cur = stack.pop();
                int left  = !stack.empty() ? stack.peek() : -1;
                int width = i-left-1;
                max = Math.max(max, width * height[cur]);

            }
            stack.push(i);


        }
        return max;
    }
    public static void main(String[] args){
        DataStructure dataStructure = new DataStructure();
        System.out.println(dataStructure.largestRectangleArea(new int[]{2,1,5,6,2,3}));
    }

}
