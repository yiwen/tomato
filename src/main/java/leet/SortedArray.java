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

    public void merge(int[] A, int m, int[] B, int n){
        int pos=m+n-1;
        int aP=m-1;
        int bP=n-1;
        while(aP>=0&& bP>=0) {
            while (A[aP] >= B[bP] && aP >= 0) {
                A[pos] = A[aP];
                pos--;
                aP--;
            }
            while (A[aP] < B[bP] && bP >= 0) {
                A[pos] = B[bP];
                pos--;
                bP--;
            }

        }
        if (aP < 0) {
            while (bP >=0) {
                A[pos] = B[bP];
                bP--;
                pos--;
            }
        }
        if (bP <0) {
            while (aP >=0) {
                A[pos] = A[aP];
                aP--;
                pos--;
            }
        }


    }
}
