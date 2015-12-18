/**
 * Created by yiwengao on 6/30/15.
 */
public class CountWithoutLoop {
    private static int initStart = -1;

    public static void main(String[] args){
        System.out.println("CountUpAndDown");
        countUpAndDown(3, 6);
        System.out.println("CountUp");
        countUp(4, 10);
    }

    public static void countUp(int start, int end) {
        int current = start;
        if (current > end) {
            return;
        }
        System.out.println(current);
        current ++;
        countUp(current, end);
    }

    public static void countUpAndDown(int start, int end) {
         if (initStart < 0){
             initStart = start;
         }
        if (start < initStart){
            return ;
       } else {
            if (start < end) {
                System.out.println(start);
                int next=  start + 1;
                countUpAndDown(next, end);
            }
            if (start == end) {
                System.out.println(start);
                int next= start-1;
                countUpAndDown(next, initStart);
            }
            if (start > end) {
                System.out.println(start);
                int next = start-1;
                countUpAndDown(next, end);
            }
        }
    }
}
