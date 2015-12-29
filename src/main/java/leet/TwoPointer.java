package leet;

/**
 * Created by yiwengao on 12/23/15.
 */
public class TwoPointer {

        public static void partitionArray(int[] nums) {
            if (nums == null || nums.length <= 1) {
                return;
            }
            int start = 0, end = nums.length - 1;
            while (start < end) {
                while (start < end && nums[start] % 2 != 0) {
                    start++;
                }
                while (start < end && nums[end] % 2 == 0) {
                    end--;
                }
                if (start < end) {
                    int tmp = nums[start];
                    nums[start] = nums[end];
                    nums[end] = tmp;
                    start++;
                    end--;
                }
            }
        }


    public int removeDuplicates(int[] nums) {
        // write your code here
        int pnt = 0;
        int dup = 0;
        for (int i=1; i<nums.length;i++){
            if (nums[i] !=nums[pnt]){
                pnt++;
                nums[pnt]=nums[i];
            }  else {
                dup++;
            }
        }
        return nums.length-dup;
    }


    public int removeDuplicatesII(int[] nums) {
        if (nums == null || nums.length <= 2) {
            return 0;
        }
       // write your code here
       int pnt = 1;
       for (int i=2; i<nums.length;i++){
           if (nums[i] !=nums[pnt] || nums[pnt]!=nums[pnt-1]){
               pnt++;
               nums[pnt]=nums[i];

           }
       }
       return pnt+1;
   }

    public boolean isPalindrome(String s) {
        String tmp=s.toLowerCase();
        // Write your code here
        int start = 0;
        int end = tmp.length()-1;
        while (start<end){

            while(start <= tmp.length()-1 && ((tmp.charAt(start) >='a' && tmp.charAt(start) <='x')||(tmp.charAt(start) >='0' && tmp.charAt(start) <='9')) ){
                start ++;
            }
            while(end>=0 && ((tmp.charAt(end) >='a' && tmp.charAt(end) <='x')||(tmp.charAt(end) >='0' && tmp.charAt(end) <='9')) ){
                end--;
            }
            if (tmp.charAt(start)!=tmp.charAt(end)){
                return false;
            } else {
                start++;
                end--;
            }

        }
        return true;
    }




}
