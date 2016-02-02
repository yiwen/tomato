package leet;

import java.util.ArrayList;

/**
 * Created by yiwengao on 12/23/15.
 */
public class Greedy {
    public int majorityNumber(ArrayList<Integer> nums) {
        // write your code
        int major = nums.get(0);
        int count = 0;
        for(int i=1; i<nums.size(); i++){
            if(major == nums.get(i)){
                count++;
            } else{
                count--;
            }
            if (count==0){
                major = nums.get(i);

            }

        }
       return count;
    }

    public int climbStairs(int n) {
        // write your code here
        if(n==1) {
            return 1;
        }
        if (n==2){
            return 2;
        }
        long last =2;
        long lastLast =1;
        long total =0;
        for (int i=3 ;i <=n;n++){
            total = last + lastLast;
            lastLast = last;
            last = total;
        }
        if (total < Integer.MAX_VALUE){
            return Integer.valueOf(((Long)total).toString());
        } else{
            return Integer.MAX_VALUE;

        }

    }

    public int strStr(String source, String target) {

        //write your code here
        int sl = source.length();
        int tl = target.length();
        if (sl > tl){
            return  -1;
        }
        int found = -1;
        for (int i = 0; i< sl-tl+1 ;i++){
            for(int j=i; j < tl +i;j++){
                if (source.charAt(j) != target.charAt(i)){
                    break;
                }
                found = i;

            }
            if (found >=0){
                return found;
            }

        }
        return found;


    }

    public int canCompleteCircuit(int[] gas, int[] cost) {
        // write your code her
        int count = gas.length;
        int sum= 0 ;
        int start = 0;
        int sumHere = 0;
        for (int i = 0; i < count; i++){
            sum = sum + gas[i]-cost[i];
            sumHere = sumHere +  gas[i]-cost[i];
            if (sumHere < 0){
                sumHere =0;
                start = i;
            }
        }
        if(sum < 0){
            return -1;
        } else {
            return start;
        }
    }


}
