package leet;

import java.util.*;

/**
 * Created by yiwengao on 1/12/16.
 */
public class ExhaustiveSearch {

    public ArrayList<ArrayList<Integer>> subsets(int[] nums) {
        // write your code here
        ArrayList<ArrayList<Integer>> rst = new ArrayList<ArrayList<Integer>>();
        if (nums==null) {
            return rst;
        }
        Arrays.sort(nums);
        ArrayList<Integer> emptySet = new ArrayList<Integer>();
        rst.add(emptySet);
        for(int i =0 ; i<nums.length ;i++){
            int rstSize = rst.size();
            for(int j=0 ; j< rstSize ; j++){
                ArrayList<Integer> subset = rst.get(j);
                ArrayList<Integer> newSubset = new ArrayList<Integer>();
                newSubset.addAll(subset);
                newSubset.add(nums[i]);
                rst.add(newSubset);

            }
        }
        return rst;

    }

    public ArrayList<ArrayList<Integer>> subsetsRecursion(int[] nums) {
        // write your code here
        ArrayList<ArrayList<Integer>> rst = new ArrayList<ArrayList<Integer>>();
        if (nums==null) {
           return rst;
        }
        return subSetHelper( nums, nums.length-1);

    }

    public ArrayList<ArrayList<Integer>>  subSetHelper(int[] nums,  int index){

        if (index==-1){
            ArrayList<ArrayList<Integer>> rst = new ArrayList<ArrayList<Integer>>();

            ArrayList<Integer> newSubset = new ArrayList<Integer>();
            rst.add(newSubset);
            return rst;

        }
        ArrayList<ArrayList<Integer>> helperRst = subSetHelper( nums, index-1);
        int size = helperRst.size();
        for (int i =0 ; i < size ; i++){
            ArrayList<Integer> newSubset = new ArrayList<Integer>();
            newSubset.addAll(helperRst.get(i));
            newSubset.add(nums[i]);
            helperRst.add(newSubset);
        }
        return helperRst;
    }

    public static ArrayList<ArrayList<Integer>> subsetsWithDup(ArrayList<Integer> S) {
        // write your code here
        if (S== null){
            return null;
        }
        Collections.sort(S);
        Set<ArrayList<Integer>> set = new HashSet<ArrayList<Integer>>();
        ArrayList<ArrayList<Integer>> rst = new ArrayList<ArrayList<Integer>>();

        rst.add(new ArrayList<Integer>());
        set.add(new ArrayList<Integer>());
        for (int i =0 ; i < S.size() ; i++){

            int size = rst.size();



            for(int j=0; j< size ; j++){

                ArrayList<Integer> subset = new ArrayList<Integer>();
                subset.addAll(rst.get(j));
                subset.add(S.get(i));
                if (set.add(subset)) {
                    rst.add(subset);
                }


            }
        }
        return rst;
    }
    public static ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> nums) {
        if (nums==null){
            return new ArrayList<ArrayList<Integer>>();

        }
        ArrayList<ArrayList<Integer>> queue = new ArrayList<ArrayList<Integer>>();

        ArrayList<Integer> empty = new ArrayList<Integer>();
        queue.add(empty);
        for (int j=0;j<nums.size();j++) {
            ArrayList<ArrayList<Integer>> tmpRst = new ArrayList<ArrayList<Integer>>();
            for (ArrayList<Integer> list : queue) {
                //insertAllPlaces(list,nums.get(j),tmpRst);
            }
            queue = tmpRst;
            tmpRst = new ArrayList<ArrayList<Integer>>();
        }

        return queue;
    }



    public static ArrayList<ArrayList<Integer>> permuteRecur(ArrayList<Integer> nums) {

       // write your code here
       if (nums==null){
           return new ArrayList<ArrayList<Integer>>();

       }
       Queue<ArrayList<Integer>> queue =  permutationHelper(nums, nums.size()-1);
       ArrayList<ArrayList<Integer>> rst = new ArrayList<ArrayList<Integer>>();
       for(int j =0 ; j <=queue.size() ;j++){
           rst.add(queue.poll());
       }
       return rst;
   }
   private static  Queue<ArrayList<Integer>> permutationHelper(ArrayList<Integer> nums, int index){
       if (index ==0){
           Queue<ArrayList<Integer>> rst1 = new LinkedList<ArrayList<Integer>>();
           ArrayList<Integer> list =  new ArrayList<Integer>();
           list.add(nums.get(0));
           rst1.add(list);
           return rst1;
       }
       Queue<ArrayList<Integer>> rst = permutationHelper(nums, index-1);
       int size = rst.size();
       for (int i=0;i<size;i++){
           ArrayList<Integer> per = rst.poll();
           insertAllPlaces(per, nums.get(index), rst);

       }
       return rst;

   }
    private static void insertAllPlaces(List<Integer> per, int number, List<List<Integer>> rst){
        int size = per.size();
        for (int i = 0; i <= size; i++) {
            ArrayList<Integer>  newPer = new ArrayList<Integer>(per);
                newPer.add(i, number);
                rst.add(newPer);
            }



    }
    private static void insertAllPlaces(ArrayList<Integer> per, int number, Queue<ArrayList<Integer>> rst){
        int size = per.size();
        for (int i = 0; i <= size; i++) {
            ArrayList<Integer>  newPer = new ArrayList<Integer>(per);

                per.add(i, number);
                rst.add(newPer);

            }



    }

    public static  void main(String[] args){
        ArrayList<Integer> list = new ArrayList<Integer>();
      //  list.add(0);
        list.add(1);

        permute(list);
    }


    public List<List<Integer>> combine(int n, int k) {
		// write your code here

        List<List<Integer>> rst = new ArrayList<List<Integer>>();
        if (k > n || n<=0){
            return rst;
        }
        rst.add(new ArrayList<Integer>());

        for(int i = 1;i<=n;i++){

            for (int t =1; t<=2; t++) {
                List<List<Integer>> tmpRst = new ArrayList<List<Integer>>();
                for (List<Integer> per : rst) {
                    insertAllPlaces(per, i, tmpRst);
                }
                rst = tmpRst;
                tmpRst = new ArrayList<List<Integer>>();
            }
        }
        return rst;


    }


}
