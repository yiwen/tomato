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

    public double findMedianSortedArrays(int[] A, int[] B) {
        if (A==null || B==null){
            return 0;
        }
        // write your code here

        if ((A.length + B.length)%2==1) {
            return findMedianSortedArraysHelper(A, B, 0, 0, (A.length + B.length)/2+1);
        }else {
            return (findMedianSortedArraysHelper(A, B, 0, 0, (A.length + B.length)/2+1) +
                    findMedianSortedArraysHelper(A, B, 0, 0, (A.length + B.length)/2))/2.0;


        }
    }

    public double findMedianSortedArraysHelper(int[] A, int[] B, int aS, int bS, int k) {
        if (aS>=A.length){
            return B[bS + k-1];
        }
        if (bS >=B.length){
            return A[aS +k-1];
        }
        if (k==1){
            return Math.min(A[aS], B[bS]);
        }
        // write your code here
        int aK = A.length > aS + k/2-1   ? A[aS+k/2-1] : Integer.MAX_VALUE;
        int bK = B.length > bS+ k/2-1 ? B[bS + k/2-1] : Integer.MAX_VALUE;

        if(aK < bK){
           return findMedianSortedArraysHelper(A, B, aS + k/2, bS, k-k/2);
        }else{
            return findMedianSortedArraysHelper(A, B, aS, bS+k/2, k- k/2);

        }

    }
}
