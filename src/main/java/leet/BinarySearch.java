package leet;

/**
 * Created by yiwengao on 12/22/15.
 */
public class BinarySearch {
    public int searchInsert(int[] A, int target) {
        //write your code here
        if(A.length==0){
            return -1;
        }
        int start = -1;
        int end = A.length;
        while (start +1 < end) {

            int midPos = start + (end-start)/2;
            int mid = A[midPos];
            if (mid==target){
                return midPos;
            }else if (mid > target) {
                end = midPos;
            } else if (mid < target) {
               start = midPos;
            }
        }
        return start+1;
    }


    public int binarySearch(int[] nums, int target) {
        //write your code here

        if (nums == null || nums.length ==0){
            return -1;
        }

        int start = -1;
        int end = nums.length;
        int mid ;
        while(start + 1< end){
             mid = (end + start)/2;


            if (nums[mid] >= target){
                end= mid;
            }  else {
                start = mid;
            }
        }
        if (nums[start] == target){
            return start;
        } else if (nums[end] == target){
            return end;
        } else {

            return -1;
        }
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix==null || matrix.length==0 || matrix[0].length==0){
            return false;
        }
         // write your code here
        int sm=0;
        int sn =-1;

        int m = matrix.length;
        int n= matrix[0].length;
        int em=m-1;
        int en=n;
        int mPos;
        int nPos;
        int sPos = -1;
        int ePos = m*n;
        while(sPos+1 < ePos){

            int mid = (em*n+en+ sm*n +sn)/2;
            mPos = mid/ n;
            nPos =  mid-mPos*n-1 ;
            if(matrix[mPos][nPos] < target){
                sm=mPos;
                sn=nPos;
            } else{
                em=mPos;
                en=nPos;
            }

           sPos = sm*n+sn;
           ePos = em*n+en;

        }

        if (ePos != m * n && matrix[em][en] == target ){
            return true;
        }else {
            return false;
        }

     }

    public int sqrt(int x) {
        if (x<0){
            return -1;
        }

        // write your code here
        int start =0 ;
        long end = (long)x+1;

        while(start+1 <end){
            long mid =(long)(start +end)/2;
            long tmp =mid*mid;
            if (tmp ==x){
                return (int)mid;
            }
            if (tmp>x){
                end = (int)mid;
            } else {
                start =(int)mid;
            }
        }


        return start;


    }



}
