package leet;

import java.util.*;

/**
 * Created by yiwengao on 4/28/15.
 */
public class TwoSum {
    public static void main(String[] args){
    }
    public List<List<Integer>> twoSum(int[] nums, int target) {
        List<List<Integer>> rst = new ArrayList<List<Integer>>();

        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        Set<Integer> set = new HashSet<Integer>();
        for (int i=0;i<nums.length;i++){
            map.put(Integer.valueOf(nums[i]), Integer.valueOf(target-i));
        }
        for (int i=0;i<nums.length;i++) {
            List<Integer> pair = new ArrayList<Integer>();
            if (map.get(nums[i])!=null){
                int check = target - map.get(nums[i]);

            }

        }
        return  null;

    }

}
