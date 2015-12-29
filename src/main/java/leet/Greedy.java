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

}
