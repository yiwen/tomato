package leet;

/**
 * Created by yiwengao on 12/30/15.
 */
public class Sort {

    public static int median(int[] nums) {
        // write your code here
        int m = (nums.length-1)/2;
            return findMedian(nums, 0, nums.length - 1, m);
    }

    private static int findMedian(int[] a, int l, int u, int k){


        if (l >=u){
            return a[u];
        }
        int t = a[u];
        int left = l;
        int right = u-1;

        System.out.println("left:" + left + "| right:"+right +"| u:"+u);
        for (int item : a) {
                        System.out.print(item + " ");
                    }
                    System.out.println();

        while(left<right){
            while(a[left] < t) {
                left++;
            }
            while( left <=right && a[right] >=t){
                right--;
            }

            if(left > right){
                break;
            }
            int tmp =  a[left];
            a[left] = a[right];
            a[right]=tmp;
        }
        System.out.println("left:" + left + "| right:"+right);

        for (int item : a) {
                    System.out.print(item + " ");
                }
                System.out.println();
         if (a[u]<a[left] ){
        int tmp2 = a[u];
        a[u] = a[left];
        a[left] = tmp2;      }

        System.out.println("left: " + left + " k:" +k);

        if (left==k){
            return a[k];
        }  else if(left >k){
            return  findMedian(a, l, left - 1, k);

        }  else {
            return findMedian(a, left+1, u, k);
        }
    }





    public static  int kthLargestElement(int k, int[] nums) {
        // write your code here

        return  kthMax(nums, 0, nums.length-1,  nums.length-k ) ;

    }

    private static int kthMax(int[] a, int l, int u, int k){


        if (l >=u){
            return a[u];
        }
        int t = a[u];
        int left = l;
        int right = u-1;
        System.out.println("left:" + left + "| right:"+right +"| u:"+u);
        for (int item : a) {
                        System.out.print(item + " ");
                    }
                    System.out.println();

        while(left<right){
            while(a[left] < t) {
                left++;
            }
            while( left <=right && a[right] >=t){
                right--;
            }

            if(left > right){
                break;
            }
            int tmp =  a[left];
            a[left] = a[right];
            a[right]=tmp;
        }
        System.out.println("left:" + left + "| right:"+right);

        for (int item : a) {
                    System.out.print(item + " ");
                }
                System.out.println();
         if (a[u]<a[left] ){
        int tmp2 = a[u];
        a[u] = a[left];
        a[left] = tmp2;      }

        System.out.println("left: " + left + " k:" +k);

        if (left==k){
            return a[k];
        }  else if(left >k){
            return kthMax(a, l, left-1, k);

        }  else {
            return kthMax(a, left+1, u, k);
        }
    }

    public  static  void main(String[] args){
        int[] a = {9,8,7,6,2,0,1,5,4};
       //    System.out.println(kthLargestElement(3, a));
        System.out.println(findMissing(a));

    }
    public static int firstMissingPositive(int[] A) {
        if (A == null || A.length == 0) {
            return 1;
        }


        for (int i=0; i<A.length; i++){






            while(A[i] != i +1){

                if (A[i] < 1|| A[i] >= A.length ) {

                    break;
                }
                if (A[A[i]-1] == A[i])  {
                  break;
               }
                int tmp = A[A[i] - 1];
                A[A[i] - 1] = A[i];
                A[i] = tmp;

            }
        }



        for (int j = 0; j < A.length; j++) {

            if (A[j] != j + 1) {
                return j + 1;
            }
        }
        return A.length+1;
    }

    public static int findMissing(int[] nums) {
        int l = nums.length ;
        for (int i =0; i <l; i++) {
            while (nums[i] != i) {
                print(nums);
                if (nums[i] >= l) {
                    break;
                }
                if (nums[nums[i]] == nums[i]) {
                    break;
                }
                System.out.println("swap:A[" + i + "] with " + i);

                int tmp = nums[nums[i]];
                nums[nums[i]] = nums[i];
                nums[i] = tmp;

                print(nums);

            }
        }
        for (int i =0; i <l; i++){
            if(nums[i] !=i){
                return i;
            }
        }
        return l;


    }


    public static void  print(int[] nums){
        for (int item : nums) {
                System.out.print(item + " ");
            }
            System.out.println();
    }

}
