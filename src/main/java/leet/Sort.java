package leet;

import java.util.*;

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

    public void sortColors(int[] nums) {
        // write your code here
        // write your code here
        if (nums==null || nums.length==0){
            return;
        }
        int red=-1;
        int blue=nums.length;
        int pos = 0;
        while (pos<blue){
            if (nums[pos]==0){
                red++;
                swap(nums, pos, red);
                pos++;

            }else
            if (nums[pos]==2){
                blue--;
                swap(nums, pos, blue);
            }else {
                pos++;
            }
        }
    }


    public int partitionArray(int[] nums, int k) {
        //write your code here
        if (nums==null || nums.length==0){
            return 0;
        }
        int left = 0;
        int right = nums.length-1;
       while(left<right){
            while(left<right && nums[left] <=k) {
                left++;

            }
            while(left<right && nums[right]>k){
                right--;
            }
           if (nums[left]>nums[right]) {
               swap(nums, left, right);
           }

        }
        return right <nums.length-1? right: nums.length ;
    }
    void swap(int[] nums, int a, int b){
        int tmp= nums[a];
        nums[a]=nums[b];
        nums[b]=tmp;

    }

    public void sortColors2(int[] colors, int k) {
        // write your code here
        if(colors==null ||colors.length==0){
            return;
        }
        if (k>colors.length){
            return;
        }
        int min=1;
        int max = k;
        int start =0;
        int end = colors.length-1;
        while(start<end){
            int[] tmpRst = sortIntoThreeGroups(colors, start, end, min, max);
            start = tmpRst[0]+1;
            end = tmpRst[1]-1;
            min++;
            max--;
        }
    }


    public int[] sortIntoThreeGroups(int[] colors, int start, int end, int min, int max){

        int minP=start-1;
        int maxP= end+1;
        int pos=0;
        while(pos<maxP){
            if(colors[pos]==min){
                minP++;
                swap(colors, pos, minP);
                pos++;
            }else  if(colors[pos]==max){
                maxP--;
                swap(colors, pos, maxP);
            }else{
                pos++;
            }
        }
        return new int[]{minP, maxP};
    }


    private int findKthMin(int[]a, int l , int r, int k) {
        if(l ==r){
            return a[r];
        }
        int left = l;
        int right = r;
        int pivot = a[l];

        while (left < right) {
            while (left < right && a[right] >= pivot) {
                right--;
            }
            a[left]=a[right];
            while (left < right && a[left] <= pivot) {
                left++;
            }
            a[right]=a[left];



        }
        a[left]=pivot;
         if (left ==k){
             return a[left];
         }else if (left < k){
            return findKthMin(a, left+1, r, k );
        }else {
             return findKthMin(a, l, left-1, k);

         }

    }

    public void wiggleSort(int[] nums) {
        // Write your code here
        if (nums==null || nums.length<2 ) {
            return;
        }
        int[] partitioned = partition(nums, 0, nums.length-1);
        groupMedian(nums);
       wiggleSortII(nums);

    }

    void groupMedian(int[] num){
        if (num.length<3){
            return;
        }
        int median = num[(num.length-1)/2];
        int mid = (num.length-1)/2;
        int rL = mid+1;

        while(rL <num.length && num[rL] == median){
            rL++;
        }

        int curP = rL+1;

        while(curP<num.length){
            if(num[curP] == median)   {
               swap(num, curP, rL);

                rL++;
            }
            curP ++;
        }
    }

    int[] partition(int[] num, int s, int  e){
        if (s==e){
            return num;
        }
        int left = s;
        int right = e;

        int pivot = num[left];
        while(left<right){
            while(left<right && num[right]>=pivot){
               right--;
            }
            num[left]=num[right];
            while(left<right && num[left] < pivot){
                left++;
            }

            num[right] = num[left];
        }
        num[left] = pivot;

        if (left==(num.length-1)/2) {
            return num;
        }else if (left < (num.length - 1) / 2) {
            return  partition(num, left+1, num.length - 1);
        } else {
           return  partition(num, 0, left-1);
        }



    }

    public void wiggleSortI(int[] nums) {
        // Write your code here
        if (nums==null || nums.length<2){
            return;
        }

        for (int i =1;i<nums.length ;i++){
            if ((i%2==1 || nums[i] <nums[i-1]) ||
                    (i%2==0 || nums[i]>nums[i-1])){
                int tmp = nums[i-1];
                nums[i-1] = nums[i];
                nums[i]=tmp;
            }
        }
    }

    public void wiggleSortII(int[] nums) {
        // Write your code here
        if (nums==null ||nums.length<2){
            return;
        }
     //   Arrays.sort(nums);
        int mid  = (nums.length-1)/2;
        int end  =nums.length-1;

        int[] ans = new int[nums.length];
        for(int i =0;i<ans.length ; i++){
            if (i%2==0) {
                ans[i] = nums[mid];
                //  System.out.println("i: " + ans[i] + "= mid:" + mid);
                mid --;
            }else {
                ans[i] = nums[end];
                //   System.out.println("i: " + ans[i] + "= end:" + end);

                end--;
            }
        }
        for(int j =0 ; j <ans.length; j++){
            nums[j] = ans[j];
        }

    }

    public  static  void main(String[] args){
        int[] a = {1,5,1,1,6,4};
        //    System.out.println(kthLargestElement(3, a));
        Sort sort = new Sort();
        sort.wiggleSortII(a);

    }
    public int strStr(String source, String target) {
        if (source ==null || target ==null){
            return -1;
        }

        //write your code here
        int sl = source.length();
        int tl = target.length();
        if ( tl==0){
            return 0;
        }
        if (sl < tl){
            return  -1;
        }
        int found=0;
        for(int i =0;i<source.length();i++){
            for (int j =0; j<target.length();j++){
                if(source.charAt(i+j)!=target.charAt(j)){
                    found = -1;
                    break;

                }
            }
            if (found==0){
                return 1;
            }

        }

        return  found==0? 1:-1;

    }

    public ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph) {
        // write your code here
        if (graph==null){
            return null;
        }
        ArrayList<DirectedGraphNode> rst = new ArrayList<DirectedGraphNode>();

        Map<DirectedGraphNode, Integer> map= new HashMap<DirectedGraphNode, Integer>();
        for(DirectedGraphNode node : graph){
            for(DirectedGraphNode nei :  node.neighbors){
                if (map.get(nei)!=null){
                    int count = map.get(nei);
                    map.put(nei,count+1);

                }else{
                    map.put(nei, 1);
                }
            }
        }
        DirectedGraphNode root =null;
        for(DirectedGraphNode node :  graph){
            if (map.get(node)==null){
                root = node;
            }
        }

        Queue<DirectedGraphNode> queue = new LinkedList<DirectedGraphNode>();
        queue.offer(root);

        while(queue.isEmpty()){
            int size = queue.size();

            for(int i =0 ; i < size ; i++){
                DirectedGraphNode cur = queue.poll();
                rst.add(cur);
                for(DirectedGraphNode nei : cur.neighbors){
                    int count  =map.get(nei);
                    if (count==0){
                        queue.offer(nei);
                    }else{
                        map.put(nei, count-1);
                    }
                }
            }
        }
        return rst;

    }


}
