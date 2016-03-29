package leet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by ygao on 2/26/16.
 */
public class SubSet_Premu {

    public ArrayList<ArrayList<Integer>> subsets(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<ArrayList<Integer>>();
        }
        Arrays.sort(nums);

        ArrayList<ArrayList<Integer>> rsts = new ArrayList<ArrayList<Integer>>();
        rsts.add(new ArrayList<Integer>());
        for (int i = 0; i < nums.length; i++) {
            int size = rsts.size();
            for (int j = 0; j < size; j++) {

                ArrayList<Integer> cur = new ArrayList<Integer>();
                cur.add(nums[i]);
                cur.addAll(rsts.get(j));
                rsts.add(cur);
            }
        }
        return rsts;

    }

    public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> nums) {
        if (nums == null) {
            return new ArrayList<ArrayList<Integer>>();
        }
        ArrayList<ArrayList<Integer>> rsts = new ArrayList<ArrayList<Integer>>();
        ArrayList<ArrayList<Integer>> frsts = new ArrayList<ArrayList<Integer>>();

        rsts.add(new ArrayList<Integer>());
        for (int i = 0; i < nums.size(); i++) {
            int tmp = nums.get(i);
            int size = rsts.size();
            for (int j = 0; j < size; j++) {
                ArrayList<ArrayList<Integer>> tmpRest = insertIntoAll(rsts.get(j), tmp);
                for (ArrayList<Integer> oneRST : tmpRest) {
                    if (oneRST.size() == nums.size()) {
                        frsts.add(oneRST);
                    }
                    rsts.add(oneRST);
                }
            }
        }
        return frsts;

    }

    ArrayList<ArrayList<Integer>> insertIntoAll(ArrayList<Integer> subset, int number) {
        ArrayList<ArrayList<Integer>> fRst = new ArrayList<ArrayList<Integer>>();
        int size = subset.size();
        for (int i = 0; i <= size; i++) {
            ArrayList<Integer> oneRst = new ArrayList<Integer>();
            oneRst.add(i, number);
            fRst.add(oneRst);

        }
        return fRst;
    }

    public static void main(String[] args) {
        ArrayList<Integer> test = new ArrayList<Integer>();
        test.add(0);
        test.add(1);
        SubSet_Premu pro = new SubSet_Premu();
        pro.subsets(new int[]{1, 2, 2});
    }

    public List<List<Integer>> subsets_recu(ArrayList<Integer> S) {
        List<List<Integer>> rst = new ArrayList<List<Integer>>();
        List<Integer> empty = new ArrayList<Integer>();

        if (S == null || S.size() == 0) {
            rst.add(empty);
            return rst;
        }

        subsetHelper(S, rst, empty, 0);
        return rst;

    }
    void subsetHelper(ArrayList<Integer> nums, List<List<Integer>> rst, List<Integer> list, int pos) {
        rst.add(new ArrayList<Integer>(list));
        for (int i = pos; i < nums.size(); i++) {
            if(i!=pos && nums.get(i)==nums.get(i-1)){
                continue;
            }
            list.add(nums.get(i));
            subsetHelper(nums, rst, list, i + 1);
            list.remove(list.size() - 1);
        }

    }

    public  ArrayList<ArrayList<Integer>> permute_recur(ArrayList<Integer> nums) {
        ArrayList<ArrayList<Integer>> rst = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> empty = new ArrayList<Integer>();
        if(nums==null ||nums.size()==0){
            rst.add(empty);
            return rst;
        }
        int[] visited = new int[nums.size()];
        Collections.sort(nums);
        permuHelper(rst, nums, empty, visited);
        return rst;
    }

    void permuHelper(ArrayList<ArrayList<Integer>> rst,ArrayList<Integer> nums, ArrayList<Integer> list ,int[] visited ){
        if(list.size() == nums.size()){
            rst.add(new ArrayList<Integer>(list));
            return;
        }
        for(int i=0;i<nums.size() ;i++){
            if (visited[i]==1 || (i!=0 && visited[i-1]==0 && nums.get(i)==nums.get(i-1))){
                continue;
            }
            list.add(nums.get(i));
            visited[i]=1;
            permuHelper(rst, nums, list,visited);
            list.remove(list.size()-1);
            visited[i]=0;
        }
    }

    }