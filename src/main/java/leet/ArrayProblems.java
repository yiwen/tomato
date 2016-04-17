package leet;

import java.util.*;

/**
 * Created by ygao on 3/1/16.
 */
public class ArrayProblems {
    public ArrayList<Long> productExcludeItself(ArrayList<Integer> A) {
        // write your code
        if (A == null || A.size() < 2) {
            return new ArrayList<Long>();
        }

        ArrayList<Long> rstlist = new ArrayList<Long>();
        long[] left = new long[A.size() - 1];
        long[] right = new long[A.size() - 1];
        long prodLeft = 1;
        long prodRight = 1;

        for (int i = 0; i < A.size() - 1; i++) {
            prodLeft = prodLeft * A.get(i);
            left[i] = prodLeft;
            prodRight = A.get(A.size() - 1 - i) * prodRight;
            right[i] = prodRight;
        }
        rstlist.add(right[A.size() - 1]);
        for (int i = 1; i < A.size() - 1; i++) {
            rstlist.add(left[i - 1] * right[A.size() - 1 - i]);

        }
        rstlist.add(left[A.size() - 1]);

        return rstlist;
    }

    public int removeElement(int[] A, int elem) {
        int p = 0;
        int fill = 0;
        while (p < A.length) {
            while (A[p] != elem) {

                A[fill] = A[p];
                p++;
                fill++;
            }

            fill = p;
            p++;
        }
        return fill;

    }

    public ArrayList<Integer> subarraySum(int[] nums) {
        int[] sum = new int[nums.length];
        sum[0] = nums[0];
        ArrayList<Integer> rst = new ArrayList<Integer>();
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 1; i < nums.length; i++) {
            sum[i] = sum[i - 1] + nums[i];
            if (map.containsKey(sum[i])) {
                rst.add(map.get(sum[i]) + 1);
                rst.add(i);
            } else {
                map.put(sum[i], nums[i]);
            }
        }
        return rst;

    }

    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;

        }
        int cur = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[cur] != nums[i]) {
                cur++;
                nums[cur] = nums[i];
            }

        }
        return cur+1;


    }



    public static int firstMissingPositive(int[] A) {
        if (A == null || A.length == 0) {
            return 1;
        }
        if (A.length==1) {
            return A[0]==1? 2: 1;
        }
        for (int i = 0; i < A.length; i++) {
            while(A[i]-1!=i) {
                if (A[i] < 1 || A[i] > A.length || A[A[i]-1] == A[i]-1) {

                    break;

                }
                int tmp = A[i];
                A[i] = A[tmp-1];
                A[tmp-1] = tmp;
            }

        }
        for (int  i=0;i<A.length;i++){
            if (A[i]-1!=i){
                return i+1;
            }
        }
        return 1;
    }

    public int longestConsecutive(int[] num) {
        // write you code here
        Set<Integer> set = new HashSet<Integer>();
        for (int i=0; i < num.length ; i++){
            set.add(num[i]);

        }
        int max = Integer.MIN_VALUE;
        int len = 1;
        for(int i=0 ; i < num.length ; i++){
            int cur = num[i] -1;
            while (set.contains(cur)) {
                len++;
                cur --;

            }
            max = Math.max(len, cur);
            len=1;
        }
        return max;
    }


}
