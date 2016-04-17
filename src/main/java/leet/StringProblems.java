package leet;

import java.lang.*;
import java.util.*;

/**
 * Created by yiwengao on 12/24/15.
 */
public class StringProblems {
    public static String addBinary(String a, String b) {
        // Write your code here
        int pa = a.length() - 1;
        int pb = b.length() - 1;
        boolean usePb = b.length() > a.length() ? true : false;
        char[] rst = new char[usePb ? b.length() : a.length()];
        boolean add1 = false;
        while (pa >= 0 || pb >= 0) {
            int ai = pa >= 0 ? Integer.valueOf(String.valueOf(a.charAt(pa))) : 0;
            int bi = pb >= 0 ? Integer.valueOf(String.valueOf(b.charAt(pb))) : 0;

            int sum = (add1) ? ai + bi + 1 : ai + bi;
            if (sum >= 2) {
                add1 = true;
                rst[pb >= pa ? pb : pa] = String.valueOf(sum - 2).charAt(0);
            } else {
                add1 = false;
                rst[pb >= pa ? pb : pa] = String.valueOf(sum).charAt(0);

            }
            pa--;
            pb--;


        }
        if (add1) {
            return "1" + String.valueOf(rst);
        } else {

            return String.valueOf(rst);
        }
    }


    public boolean compareStrings(String A, String B) {
        if (A == null) {
            return false;
        }
        if (B == null) {
            return true;
        }
        // write your code here
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for (char a : A.toCharArray()) {
            if (map.get(Character.valueOf(a)) == null) {
                map.put(Character.valueOf(a), 1);

            } else {
                map.put(Character.valueOf(a), map.get(Character.valueOf(a)) + 1);

            }


        }
        for (char b : B.toCharArray()) {
            if (map.get(b) == null) {
                return false;
            }
            if (map.get(b) - 1 > 0) {
                map.put(Character.valueOf(b), map.get(b) - 1);
            } else {
                map.put(Character.valueOf(b), null);

            }

        }
        return true;
    }

    public int lengthOfLastWord(String s) {
        // Write your code here
        if (s.length() == 0) {
            return 0;
        }
        if (s.trim().length() == 0) {
            return 0;
        }
        int l = s.length() - 1;
        StringBuilder builder = new StringBuilder();
        while (s.charAt(l) != ' ') {
            builder.append(s.charAt(l));
            l--;
            if (l < 0) {
                break;
            }
        }
        return builder.toString().length();


    }

    public static String reverseWords(String s) {
        // write your code
        if(s==null){
            return null;
        }
        s= s.trim();
        if (s.length()==0){
            return s;
        }
        char[] ss = s.toCharArray();
        reverse(ss, 0, s.length()-1);
        String[] words = new String(ss).split(" ");
        String rst = "";
        for (String word : words){
            char[] wordsChar = word.toCharArray();
            reverse(wordsChar, 0, wordsChar.length-1);
            rst = rst + new String(wordsChar) + " ";
        }

        return rst.trim();



    }

    private static void reverse(char[] ss, int start, int end) {

        while (start < end) {
            char tmp = ss[start];
            ss[start] = ss[end];
            ss[end] = tmp;
            start++;
            end--;


        }
    }


    public void rotateString(char[] str, int offset) {

        if (str.length == 0) {
            return;
        }
        int actualOffset = offset % str.length;
        // write your code here


        int shift = 0;
        while (shift < actualOffset) {
            shift(str);
            shift++;
        }
    }

    private void shift(char[] ss) {
        int pnt = ss.length - 1;
        char tmp = ss[pnt];
        pnt--;
        while (pnt >= 0) {
            ss[pnt + 1] = ss[pnt];
            pnt--;
        }
        ss[0] = tmp;

    }

    public boolean anagram(String s, String t) {
        // write your code here
        if (s.length() != t.length()) {
            return false;
        }
        int[] count = new int[256];
        for (int i = 0; i < s.length(); i++) {
            count[(int) s.charAt(i)]++;
            count[(int) t.charAt(i)]--;

        }
        for (int i = 0; i < 256; i++) {
            if (count[i] != 0) {
                return false;
            }
        }

        return true;
    }


    public boolean isUnique(String str) {
        // write your code here
        int[] count = new int[256];
        for (int i = 0; i < str.length(); i++) {
            if (count[str.charAt(i)] != 0) {
                return false;
            }
        }
        return true;
    }

    public static int replaceBlank(char[] string, int length) {
        int space = 0;
        System.out.println(string.length);
        System.out.println(length);

        for (char c : string) {
            if (c == ' ') {
                space = space + 2;
            }
        }
        int p = length + space - 1;

        for (int cur = length - 1; cur >= 0; cur--) {
            if (string[cur] != ' ') {
                string[p--] = string[cur];


            } else {
                string[p--] = '0';
                string[p--] = '2';
                string[p--] = '%';
            }
        }
        return p;
    }


    public static void main(String[] args) {

        StringProblems p = new StringProblems();
       p.minWindow("aaaaaaaaaaaabbbbbcdd", "abcdd");
    }

    public String countAndSay(int n) {
        // Write your code here
        String next = "1";
        String say = next;
        for (int i = 0; i < n - 1; i++) {
            say = say(next);
            next = say;

        }
        return say;
    }

    private String say(String nums) {
        StringBuilder builder = new StringBuilder();
        int count = 1;
        char cur = nums.charAt(0);
        for (int i = 1; i < nums.length(); i++) {

            if (cur == nums.charAt(i)) {
                count++;
            } else {
                builder.append(count);
                builder.append(cur);
                cur = nums.charAt(i);
                count = 1;

            }


        }
        builder.append(count);
        builder.append(cur);
        return builder.toString();

    }

    public List<String> anagrams(String[] strs) {
        // write your code here
        if(strs==null || strs.length==0){
            return new ArrayList<String>();

        }
        Map<String, List<String>> dic = new HashMap<String, List<String>>();
        for(int i=0;i<strs.length;i++){
            String key=null;
            if (strs[i].length()==0){
                key="";
            }else {
                char[] tmp = strs[i].toCharArray();
                Arrays.sort(tmp);
                 key = new String(tmp);
            }
            if(dic.containsKey(key)){
                List<String> newlist = dic.get(key);
                newlist.add(strs[i]);
                dic.put(key,newlist);
            }else {
                List<String> list = new ArrayList<String>();
                list.add(strs[i]);
                dic.put(key,list);

            }

        }
        List<String> rst = new ArrayList<String>();
        for(String key: dic.keySet()){
            List<String> list= dic.get(key);
            if (list.size()>1){
                list.addAll(dic.get(key)) ;
            }
        }
        return rst;
    }
    public int longestCommonSubstring(String A, String B) {
        if (A==null || B==null){
            return 0;
        }
        if (A.length()==0 || B.length()==0){
            return 0;
        }

        int max = Integer.MIN_VALUE;
        int al=A.length();
        int bl = B.length();


        for(int i =0;i<al;i++){
            for(int j=0;j<bl;j++){
                int len = 0;
                while(A.charAt(i+len)==B.charAt(j+len)){
                    len++;
                }
                max = java.lang.Math.max(len, max);
            }
        }
        return max;


    }

    public String longestCommonPrefix(String[] strs) {
        // write your code here
        int len = 0;
        char cur ;

        while(len < strs[0].length()){
            for (int i =1 ;i < strs.length;i++){
                cur = strs[0].charAt(len);
                if (len > strs[i].length()-1 || cur!=strs[i].charAt(len)){
                    return strs[0].substring(0,len);
                }
            }
            len++;
        }
        return strs[0].substring(0,len);


    }
    public String minWindow(String source, String target) {
        // write your code
        if (target == null || target.length() == 0 || source == null || source.length() == 0 || source.length() < target.length()) {
            return "";
        }
        Map<Character, Integer> targetMap = new HashMap<Character, Integer>();
        Map<Character, Integer> sourceMap = new HashMap<Character, Integer>();
        for (int i = 0; i < target.length(); i++) {
            if (targetMap.containsKey(target.charAt(i))) {
                targetMap.put(target.charAt(i), targetMap.get(target.charAt(i)) + 1);
            } else {
                targetMap.put(target.charAt(i), 1);
            }
        }
        int end = 0;
        int start = 0;
        int minLen = Integer.MAX_VALUE;
        String minStr = "x";
        for (int i = 0; i < source.length(); i++) {
            if (!targetMap.containsKey(source.charAt(i))) {
                continue;
            }
            if (sourceMap.containsKey(source.charAt(i))) {
                sourceMap.put(source.charAt(i), sourceMap.get(source.charAt(i)) + 1);
            } else {
                sourceMap.put(source.charAt(i), 1);
            }
            while (start < i) {
                if (!targetMap.containsKey(source.charAt(start))) {
                    start++;
                    continue;
                }
                if (sourceMap.get(source.charAt(start)) > targetMap.get(source.charAt(start))) {
                    sourceMap.put(source.charAt(start), sourceMap.get(source.charAt(start)) - 1);
                    start++;

                } else {
                    break;
                }

            }
            if (sourceMap.size() == targetMap.size()) {

                end = i;
                int count = 0;
                for (Character character : targetMap.keySet()) {
                    if (targetMap.get(character) > sourceMap.get(character)) {
                        break;
                    }
                    count++;

                }
                System.out.println("start:" + start + " end:" + end);

                if (count == targetMap.size()) {
                    end = i;
                    if (end - start + 1 < minLen) {

                        minLen = end - start + 1;

                        minStr = source.substring(start, end + 1);
                        System.out.println("found small:" + minStr);
                    }
                }
            }




        }

        return minStr;
    }
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        if (s.length()==2 && s.charAt(0)==s.charAt(1)){
            return s;
        } else if (s.charAt(0)!=s.charAt(1)){
            return s.substring(0,1);
        }
        boolean[][] check = new boolean[s.length()][s.length()];
        int max = Integer.MIN_VALUE ;

        for(int m=0;m<s.length()-1;m++){
            check[m][m+1] = true;
        }
        String longest = s.substring(0,1);
        for(int i=1;i<s.length();i++) {
            for (int j = 0; j < i-1; j++) {

                if (s.charAt(i) == s.charAt(j) && check[j + 1][i - 1]) {

                    longest = i-j+1>longest.length()?s.substring(j, i + 1): longest;
                    check[j][i]=true;
                }

            }



        }

        return longest;
    }

}
