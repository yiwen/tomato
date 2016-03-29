package leet;

import java.util.*;

/**
 * Created by ygao on 2/8/16.
 */
public class Subarray {

    public ArrayList<Integer> subarraySum(int[] nums) {
        if (nums == null && nums.length == 0) {
            return new ArrayList<Integer>();
        }
        ArrayList<Integer> rst = new ArrayList<Integer>();
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum = sum + nums[i];
            if (sum == 0) {
                rst.add(0);
                rst.add(i);
                return rst;
            }
            if (map.containsKey(Integer.valueOf(sum))) {
                int start = map.get(sum) + 1;
                int end = i;
                rst.add(start);
                rst.add(end);
                return rst;

            } else {
                map.put(sum, i);
                ;
            }
        }
        return rst;
    }

    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int maxSofar = Integer.MIN_VALUE;
        int maxHere = 0;

        for (int i = 0; i < nums.length; i++) {
            maxHere = maxHere + nums[i] >= nums[i] ? maxHere + nums[i] : nums[i];

            maxSofar = maxSofar > maxHere ? maxSofar : maxHere;

        }
        return maxSofar;
    }


    class Pair {
        int sum;
        int pos;

        public Pair(int sum, int pos) {
            this.sum = sum;
            this.pos = pos;
        }
    }

    class PairComparator implements Comparator<Pair> {
        public int compare(Pair o1, Pair o2) {
            return Integer.valueOf(o1.sum).compareTo(Integer.valueOf(o2.sum));
        }
    }

    public int[] subarraySumClosest(int[] nums) {
        // write your code here
        int sum = 0;
        int[] rst = new int[2];
        int cloest = Integer.MAX_VALUE;
        ArrayList<Pair> sumList = new ArrayList<Pair>();
        for (int i = 0; i < nums.length; i++) {
            sum = sum + nums[i];
            if (cloest > sum) {
                cloest = sum;
                rst[0] = 0;
                rst[1] = i;
            }
            sumList.add(new Pair(sum, i));


        }
        Pair[] pairs = sumList.toArray(new Pair[sumList.size()]);
        Arrays.sort(pairs, new PairComparator());
        int diff;
        for (int i = 1; i < pairs.length; i++) {
            diff = pairs[i + 1].sum - pairs[i].sum;
            if (Math.abs(cloest) > Math.abs(diff)) {
                cloest = diff;
                rst[1] = pairs[i + 1].pos > pairs[i].pos ? pairs[i + 1].pos : pairs[i].pos;
                rst[0] = pairs[i + 1].pos > pairs[i].pos ? pairs[i].pos + 1 : pairs[i + 1].pos + 1;

            }


        }
        return rst;
    }

    public int maxSubArrayMaxMin(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int sum = 0;
        int rst = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            sum = sum + nums[i];
            max = max > sum ? max : sum;
            min = min < sum ? min : sum;

            rst = rst > max - min ? rst : max - min;

        }
        return rst;
    }

    public int maxSubArrayMaxMin(int start, int end, ArrayList<Integer> nums) {
        if (start == end) {
            return nums.get(start);
        }

        int maxSofar = Integer.MIN_VALUE;
        int maxHere = 0;

        for (int i = start; i <= end; i++) {
            maxHere = maxHere + nums.get(i) >= nums.get(i) ? maxHere + nums.get(i) : nums.get(i);

            maxSofar = maxSofar > maxHere ? maxSofar : maxHere;

        }
        return maxSofar;

    }

    public int maxTwoSubArrays(ArrayList<Integer> nums) {
        // write your code
        // write your code
        if (nums == null || nums.size() == 0) {
            return 0;
        }
        if (nums.size() == 1) {
            return nums.get(0);
        }
        int[] left = new int[nums.size()];
        int[] right = new int[nums.size()];
        int maxRst = Integer.MIN_VALUE;
        for (int i = 0; i < nums.size() - 1; i++) {
            left[i] = maxSubArrayMaxMin(0, i, nums);
            right[i] = maxSubArrayMaxMin(i + 1, nums.size() - 1, nums);
        }
        for (int i = 0; i < nums.size() - 1; i++) {
            int sum = right[i] + left[i];
            maxRst = maxRst > sum ? maxRst : sum;
        }
        return maxRst;
    }

    public int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        // write your code here
        int min = prices[0];
        int max = Integer.MIN_VALUE;
        for (int i = 1; i < prices.length; i++) {
            min = prices[i] > min ? min : prices[i];

            if (prices[i] - min > 0) {
                max = prices[i] - min > max ? prices[i] - min : max;
            }

        }
        return max < 0 ? 0 : max;
    }

    public int maxProfitII(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        // write your code here

        int max = 0;
        int prev = prices[0];

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prev) {
                max = max + prices[i] - prices[i - 1];
            }
        }
        return max;
    }

    public int maxProfitIII(int[] prices) {
        if (prices==null ||prices.length<2){
            return 0;
        }
        int[] left = new int[prices.length];
        int[] right = new int[prices.length];

        for (int i = 0; i < prices.length-1; i++) {
            left[i]=getMaxInSub(prices, 0,i);
            right[i] = getMaxInSub(prices, i+1, prices.length-1);
        }
        int max = Integer.MIN_VALUE;
        for(int i=0;i<prices.length-1;i++){
            max = Math.max(left[i]+right[i], max);
        }
        return max;


    }

    int getMaxInSub(int[] prices, int start, int end){
        if (start==end){
            return 0;
        }
        int min = prices[start];
        int max=prices[start];
        for(int i=start+1; i<=end;i++){
            min=Math.min(prices[i], min);
            max =Math.max(max, prices[i]-min);
        }
        return max;
    }

}
