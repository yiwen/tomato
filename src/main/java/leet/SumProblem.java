package leet;

import java.util.*;

/**
 * Created by yiwengao on 4/28/15.
 */
public class SumProblem {
    public static void main(String[] args){
    }
    public int[] twoSum(int[] numbers, int target) {
        if(numbers.length<2){
            return new int[2];
        }
        // write your code here
        Map<Integer, Integer>  map = new HashMap<Integer, Integer>();
        for(int i=0;i<numbers.length;i++){
            int remain = target - numbers[i];
            map.put(Integer.valueOf(remain), i);

        }
        for(int i=0;i<numbers.length;i++) {
            if(map.containsKey(numbers[i])){
                return new int[]{map.get(numbers[i]), i};
            }
        }
        return new int[2];


    }
    public int findPeak(int[] A) {
        if (A==null || A.length == 0){
            return -1;
        }
        // write your code here
        int start = 0;
        int end = A.length-1;
        while(start+1<end){
            int mid = start + (end-start)/2;
            if (A[mid]>A[mid-1] && A[mid]>A[mid+1]){
                return mid;
            }
            if (A[mid]<=A[mid+1]){
                  start=mid;
            }
           else if (A[mid]<=A[mid-1]){
                end=mid;
            } else {

            }


        }
        if (A[start]>A[end]){
            return start;
        } else {
            return end;
        }
    }


}
