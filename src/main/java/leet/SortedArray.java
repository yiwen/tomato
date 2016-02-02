package leet;

import java.util.ArrayList;

/**
 * Created by yiwengao on 12/27/15.
 */
public class SortedArray {




    public void recoverRotatedSortedArray(ArrayList<Integer> nums) {
        // write your code
         if (nums.size() <2){
             return;
         }
         int cur = nums.get(0);
        for (int i=1; i <nums.size() ; i++){
            if (cur > nums.get(i)){
                int pos = i-1;
                while(pos<nums.size()-1) {
                    shift(pos, nums);
                    pos++;
                }



            }
            cur = nums.get(i);
        }
    }

    private void shift(int c, ArrayList<Integer> nums ) {
         int last = nums.get(nums.size()-1);
        for (int i= nums.size()-2 ; i >=0 ;i--) {
            nums.set(i+1, nums.get(i));

        }
        nums.set(0, last);


    }
}
