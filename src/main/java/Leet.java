import java.util.*;

/**
 * Created by yiwengao on 5/8/15.
 */
public class Leet {


    public List<List<Integer>> subsets(int[] nums) {
         Arrays.sort(nums);
        List<List<Integer>> rst = new ArrayList<List<Integer>>();
        for (int i=0; i <nums.length ; i++) {
            List<List<Integer>> tmp = new ArrayList<List<Integer>>();
            for (List<Integer> l: rst) {
                tmp.add(new ArrayList(l));
            }
            for(List<Integer> ll: tmp) {
                ll.add(nums[i]);
            }

            tmp.add(new ArrayList<Integer>(nums[i]));
            rst.addAll(tmp);

        }

        return rst;
    }

    public static  String reverseWords(String s) {
        if (s== null){
            return  null;
        }
        if (s.trim().length() == 0){
            return s.trim();
        }
        String[] splitted = s.split(" +");
        int count = splitted.length ;
        int i=0;
        while(i < count-i-1) {
            String tmp = splitted[i];
            splitted[i] = splitted[count - 1 - i];
            splitted[count - 1 - i] = tmp;
            i++;

        }
        String r = "";
        for   (String p: splitted){
            r= r + p + " ";
        }
        return  r.trim();

    }

    public int largestRectangleArea(int[] height) {
        int pre = 0;
        int current = 1;
        Stack<Integer> stack = new Stack<Integer>();
        while(height[current]> height[pre]){
            stack.push(current);
            pre = current;
            current++;
        }
        return 0;
    }

    public static void main(String[] args){
        System.out.println(threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
    }

    public static List<List<Integer>> threeSum(int[] nums) {
         List<List<Integer>> rst = new ArrayList<List<Integer>>();

         if (nums==null){
             return rst;
         }
         if (nums.length<3){
             return rst;
         }
         int[] two_sum= new int[nums.length];

         for(int i=0 ; i<nums.length;i++){
             two_sum[i] = 0-nums[i];
         }
         for(int i=0 ; i<nums.length-2;i++){
             Map<Integer, Integer> map = new HashMap<Integer, Integer>();

             for(int j=i+1 ; j<nums.length;j++) {
                     map.put(Integer.valueOf(nums[j]), two_sum[i]-Integer.valueOf(nums[j]));

             }
             boolean[] check=new boolean[nums.length];
             for (int q=0;q<nums.length;q++){
                 check[q] = false;
             }
             for(int j=i+1; j<nums.length;j++) {

                 if (map.containsKey(map.get(Integer.valueOf(nums[j])))){
                     List<Integer> combine = new ArrayList<Integer>();

                     combine.add(Integer.valueOf(nums[i]));
                     combine.add(Integer.valueOf(nums[j]));
                     combine.add(map.get(Integer.valueOf(nums[j])));
                     rst.add(combine);


                 }

             }

         }
         return rst;





    }






}
