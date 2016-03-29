package leet;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

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
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[pnt]) {
                pnt++;
                nums[pnt] = nums[i];
            } else {
                dup++;
            }
        }
        return nums.length - dup;
    }


    public int removeDuplicatesII(int[] nums) {
        if (nums == null || nums.length <= 2) {
            return 0;
        }
        // write your code here
        int pnt = 1;
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] != nums[pnt] || nums[pnt] != nums[pnt - 1]) {
                pnt++;
                nums[pnt] = nums[i];

            }
        }
        return pnt + 1;
    }

    public boolean isPalindrome(String s) {
        String tmp = s.toLowerCase();
        // Write your code here
        int start = 0;
        int end = tmp.length() - 1;
        while (start < end) {

            while (start <= tmp.length() - 1 && ((tmp.charAt(start) >= 'a' && tmp.charAt(start) <= 'x') || (tmp.charAt(start) >= '0' && tmp.charAt(start) <= '9'))) {
                start++;
            }
            while (end >= 0 && ((tmp.charAt(end) >= 'a' && tmp.charAt(end) <= 'x') || (tmp.charAt(end) >= '0' && tmp.charAt(end) <= '9'))) {
                end--;
            }
            if (tmp.charAt(start) != tmp.charAt(end)) {
                return false;
            } else {
                start++;
                end--;
            }

        }
        return true;
    }


    public void sortLetters(char[] chars) {
        //write your code here
        if (chars == null || chars.length == 0) {
            return;
        }
        int lower = -1;
        int upper = chars.length;
        int i = 0;
        while (i < upper) {
            if (chars[i] > 96) {
                lower++;
                swapChar(chars, lower, i);

            } else {
                upper--;
                swapChar(chars, upper, i);

            }

        }


    }

    void swapChar(char[] chars, int i, int j) {
        char tmp = chars[i];
        chars[i] = chars[j];
        chars[j] = tmp;
    }

    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int[] table = new int[256];
        int max = 1;

        for (int i = 0; i < s.length(); i++) {
            table[s.charAt(i)] = 1;
            int j=i+1;
            while(j < s.length() && table[s.charAt(j)] != 1){
                table[s.charAt(j)] =1;
                j++;

            }

            System.out.println("i:" + i + "j:"+j);
            max = Math.max(max, j - i);
            table = new int[256];


        }
        return max;

    }
    public static void main(String[] args){
        TwoPointer pointer =new TwoPointer();
        System.out.println(pointer.lengthOfLongestSubstringKDistinct_2("eqgkcwGFvjjmxutystqdfhuMblWbylgjxsxgnoh", 16));
       // System.out.println(pointer.lengthOfLongestSubstring("abc"));

    }

    public int lengthOfLongestSubstringKDistinct(String S, int k) {
        // write your code here
        if (S==null || S.length()==0){
            return 0;
        }
        String s=S.toLowerCase();
        int max = Integer.MIN_VALUE;
        Map<Character ,Integer> set= new HashMap<Character, Integer>();
        int j=0;
        for (int i=0;i<s.length();i++){

            if (set.get(s.charAt(i)) ==null){
                set.put(s.charAt(i), 1);
            } else{
                int count =set.get(s.charAt(i));
                set.put(s.charAt(i),  count+ 1);
            }

          //  System.out.println("totla: "+ set.size());
            if (set.size()==k){
                max = Math.max(max, i-j+1);
                System.out.println("s:" + j + " e:"+i + " len:"+ s.substring(j,i));
                while(set.size()==k && j<i) {
                    if (Integer.valueOf(set.get(s.charAt(j))) == 1) {
                        set.remove(s.charAt(j));


                    } else {
                        int count = set.get(s.charAt(j));

                        set.put(s.charAt(j), count - 1);

                    }
                    j++;
                }
            }




        }
        return max;
    }
    public int lengthOfLongestSubstringKDistinct_2(String s, int k) {

        // write your code here
    int slow = 0;
    int maxLen = 0;

    // Key: letter; value: the number of occurrences.
    Map<Character, Integer> map = new HashMap<Character, Integer>();
    int fast;
    for (fast = 0; fast < s.length(); ++fast) {
        char c = s.charAt(fast);
        if (map.containsKey(c)) {
            map.put(c, map.get(c) + 1);
        } else {
            map.put(c, 1);
            while (map.size() > k) {
                char slowChar = s.charAt(slow++);
                int count = map.get(slowChar);
                if (count > 1) {
                    map.put(slowChar, count - 1);
                } else {
                    map.remove(slowChar);
                }
            }
        }
        System.out.println("slow:" + slow+ " j:"+fast + " rst: " + s.substring(slow, fast));

        maxLen = Math.max(maxLen, fast - slow + 1);
    }

    return maxLen;
}

}
