package leet;

import java.util.*;

/**
 * Created by yiwengao on 4/28/15.
 */
public class SumProblem {
    public static void main(String[] args) {
    }

    public int[] twoSum_hash(int[] numbers, int target) {
        if (numbers.length < 2) {
            return new int[2];
        }
        // write your code here
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < numbers.length; i++) {
            int remain = target - numbers[i];
            map.put(Integer.valueOf(remain), i);

        }
        for (int i = 0; i < numbers.length; i++) {
            if (map.containsKey(numbers[i])) {
                return new int[]{map.get(numbers[i]), i};
            }
        }
        return new int[2];


    }

    public int[] twoSum(int[] numbers, int target) {
        Arrays.sort(numbers);
        int begin = 0;
        int end = numbers.length - 1;
        while (begin < end) {
            if (numbers[begin] + numbers[end] == target) {
                return new int[]{numbers[begin], numbers[end]};
            }
            if (numbers[begin] + numbers[end] > target) {
                end--;
            }
            if (numbers[begin] + numbers[end] < target) {
                begin++;
            }

        }
        return null;

    }

    public ArrayList<Integer> twoSum_forThreesum(int[] numbers, int pos, int target, ArrayList<ArrayList<Integer>> all) {
        int begin = pos + 1;
        int end = numbers.length - 1;
        while (begin < end) {

            if (begin > 0 && numbers[begin] == numbers[begin - 1]) {
                begin++;
                continue;
            }
            if (end < numbers.length - 1 && numbers[end] == numbers[end + 1]) {
                end--;
                continue;
            }
            if (numbers[begin] + numbers[end] + numbers[pos] == target) {
                ArrayList<Integer> tmp = new ArrayList<Integer>();
                tmp.add(numbers[pos]);
                tmp.add(numbers[begin]);
                tmp.add(numbers[end]);
                all.add(tmp);
                begin++;
                end--;
                while (begin < end && numbers[begin] == numbers[begin - 1]) {
                    begin++;
                }
                while (begin < end && numbers[end] == numbers[end + 1]) {
                    end--;
                }
            }
            if (numbers[begin] + numbers[end] > target) {
                end--;
            } else {
                begin++;
            }

        }
        return null;

    }

    int threeSumClosestHelper(int[] numbers, int pos, int target) {
        int begin = pos + 1;
        int end = numbers.length - 1;
        int closest = Integer.MIN_VALUE;
        while (begin < end) {
            int cur = numbers[begin] + numbers[end] + numbers[pos];
            closest = Math.abs(cur - target) < Math.abs(target - closest) ? cur : closest;
            if (cur > target) {
                end--;
            } else if (cur < target) {
                begin++;
            } else {
                return target;
            }

        }
        return closest;
    }

    public int threeSumCloset(int[] numbers, int target) {
        Arrays.sort(numbers);
        int closet = Integer.MIN_VALUE;
        for (int i = 0; i < numbers.length - 2; i++) {
            if (i > 0 && numbers[i] == numbers[i - 1]) {
                continue;
            }
            int tmp = threeSumClosestHelper(numbers, i, target);
            closet = Math.abs(tmp - target) < Math.abs(target - closet) ? tmp : closet;


        }
        return closet;
    }

    public ArrayList<ArrayList<Integer>> threeSum(int[] numbers) {
        Arrays.sort(numbers);
        ArrayList<ArrayList<Integer>> all = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < numbers.length - 2; i++) {
            if (i > 0 && numbers[i] == numbers[i - 1]) {
                continue;
            }
            ArrayList rst = twoSum_forThreesum(numbers, i, 0, all);
            if (rst != null) {
                all.add(rst);
            }
        }
        return all;

    }


    public int findPeak(int[] A) {
        if (A == null || A.length == 0) {
            return -1;
        }
        // write your code here
        int start = 0;
        int end = A.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (A[mid] > A[mid - 1] && A[mid] > A[mid + 1]) {
                return mid;
            }
            if (A[mid] <= A[mid + 1]) {
                start = mid;
            } else if (A[mid] <= A[mid - 1]) {
                end = mid;
            } else {

            }


        }
        if (A[start] > A[end]) {
            return start;
        } else {
            return end;
        }
    }

    public ArrayList<ArrayList<Integer>> foureSum(int[] numbers) {


    }
}