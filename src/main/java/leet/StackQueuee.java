package leet;

import java.util.Stack;

/**
 * Created by ygao on 2/18/16.
 */
public class StackQueuee {

    public class Queue {
        private Stack<Integer> pushStack;
        private Stack<Integer> popStack;

        public Queue() {
            // do initialization if necessary
            pushStack = new Stack<Integer>();
            popStack = new Stack<Integer>();
        }

        public void push(int element) {
            // write your code here
            while(!popStack.isEmpty()){
               pushStack.push(popStack.pop());
            }
            pushStack.push(element);
        }

        public int pop() {
            // write your code here
            while(!pushStack.isEmpty()){
                popStack.push(pushStack.pop());
            }
            return  popStack.pop();
        }

        public int top() {
            // write your code here
            while(!pushStack.isEmpty()){
                popStack.push(pushStack.pop());
            }
            return  popStack.peek();

        }
    }
}
