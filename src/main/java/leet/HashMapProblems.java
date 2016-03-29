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

    public int longestConsecutive(int[] num) {
        // write you code here
        HashSet<Integer> set = new HashSet<Integer>();
        for(int i=0; i <num.length ; i++){
            set.add(num[i]);

        }
        int count=0;
        int tmp;
        int max = Integer.MIN_VALUE;
        for(int i=0; i <num.length ; i++){
            tmp = num[i];
            count = 0;
            set.remove(tmp);
            while(set.contains(tmp-1)){
                tmp--;
                count++;
            }
            tmp = num[i];
            while(set.contains(tmp+1)){
                tmp++;
                count++;
            }
            max = Math.max(max, count);
        }
        return max;
    }

    public ListNode[] rehashing(ListNode[] hashTable) {
        // write your code here
        if (hashTable==null || hashTable.length==0){
            return new ListNode[]{};
        }
        int cap = hashTable.length * 2;

        ListNode[] rst = Arrays.copyOf(hashTable, cap);
        for(int i=0 ;i<hashTable.length ; i++){
            if(hashTable[i]==null){
                continue;
            }
            ListNode node = hashTable[i];
            ListNode tmp ;
            while(node.next!=null){
                tmp = node;
                int newIndex = (node.val%cap + node.val)%cap;
                if (rst[newIndex]==null) {
                    rst[newIndex] = tmp;

                }else{
                    ListNode cur = rst[newIndex];
                    while(cur.next!=null){
                        cur=cur.next;
                    }
                    cur.next=tmp;


                }

                node = node.next;

                tmp.next = null;

            }
            rst[i] = node;

        }
        return rst;
    }
}
