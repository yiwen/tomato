package leet;

import java.util.ArrayList;

/**
 * Created by yiwengao on 12/28/15.
 */
public class DP {


   public int maxSubArray(int[] nums) {
       // write your code
       int maxSofar = nums[0];
       int maxEndHere = nums[0];
       for (int i=1 ;i < nums.length; i++){
            maxEndHere =  maxEndHere +nums[i] > nums[i]?  maxEndHere +nums[i]  :  nums[i];
           maxSofar = maxSofar > maxEndHere ? maxSofar : maxEndHere;
       }
       return maxSofar;
   }

    public int minSubArray(ArrayList<Integer> nums) {
        // write your code

        int minSofar = nums.get(0);
        int minEndHere = nums.get(0);
        for (int i=1; i< nums.size() ; i++){
            minEndHere = minEndHere + nums.get(i) < nums.get(i) ?  minEndHere +nums.get(i): nums.get(i);
            minSofar = minSofar < minEndHere ? minSofar : minEndHere;
        }
        return minSofar;
    }
}
