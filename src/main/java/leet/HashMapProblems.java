package leet;

import java.util.*;

/**
 * Created by ygao on 12/21/15.
 */
public class HashMapProblems {

    public static int  hashCode(char[] key,int HASH_SIZE) {
        int v = 0;
        // write your code here
        for (int i = key.length -1; i>=0;i--) {
            int a = (int)key[i];
            v= v+  power33(a, key.length -1-i,HASH_SIZE);


        }
        return v;

    }

    private static int  power33(int a, int i, int HASH_SIZE){
        int mod = a%HASH_SIZE;
        for (int m=1; m<=i;m++){
            mod = mod * (33%HASH_SIZE);
        }
        return mod%HASH_SIZE;
    }


    public boolean isHappy(int n) {
        // Write your code here
        Set<Integer> map = new HashSet<Integer>();
        int sum = 0;
        while(true){
            sum = getSum(sum);

            if(map.contains(Integer.valueOf(sum))){
                break;
            } else {
                map.add(Integer.valueOf(sum));
            }
            if (sum==1){
                break;
            }
        }
        if (sum ==1){
            return true;
        } else {
            return false;
        }
    }

    private int getSum(int tmp){
        int sum = 0;
        int remain=tmp;
        while(remain>0){
            int dig = remain%10;
            remain = (remain - dig)/10;
            sum = sum + dig*dig;
        }
        return sum;
    }

    public static ArrayList<Integer> subarraySum(int[] nums) {
        // write your code here
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int sum=0;
        ArrayList<Integer> rst = new ArrayList<Integer>();
        for (int i=0;i<nums.length;i++){
                sum = sum + nums[i];
                if (sum == 0){
                      rst.add(0);
                      rst.add(i);
                         return rst;
                }
                if ( map.get(Integer.valueOf(sum)) == null ) {
                        map.put(Integer.valueOf(sum), Integer.valueOf(i));

                }else {
              //  if (map.get(Integer.valueOf(sum)).intValue() + 1 != i) {
                    rst.add(map.get(Integer.valueOf(sum)) + 1);
                    rst.add(Integer.valueOf(i));
                      return rst;
            //    }
                }

       }
       return rst;

    }

    public static void main(String[] args){
        System.out.println(subarraySum(new int[]{1,-1}));
    }
}
