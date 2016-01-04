package leet;

/**
 * Created by yiwengao on 12/30/15.
 */
public class BitManipulation {

    public boolean checkPowerOf2(int n) {
        // write your code here

        if (n<2) {
            return false;
        }

        return  (n & (n-1))==0;
    }

    public int countOnes(int num) {
        // write your code here
        int count = 0;
        while (num!=0){
            num = num &(num-1);
            count++;

        }
        return count;
    }
}






