package leet;

import java.util.ArrayList;
import java.util.Set;

/**
 * Created by yiwengao on 12/28/15.
 */
public class DP {


    public int maxSubArray(int[] nums) {
        // write your code
        int maxSofar = nums[0];
        int maxEndHere = nums[0];
        for (int i = 1; i < nums.length; i++) {
            maxEndHere = maxEndHere + nums[i] > nums[i] ? maxEndHere + nums[i] : nums[i];
            maxSofar = maxSofar > maxEndHere ? maxSofar : maxEndHere;
        }
        return maxSofar;
    }

    public int minSubArray(ArrayList<Integer> nums) {
        // write your code

        int minSofar = nums.get(0);
        int minEndHere = nums.get(0);
        for (int i = 1; i < nums.size(); i++) {
            minEndHere = minEndHere + nums.get(i) < nums.get(i) ? minEndHere + nums.get(i) : nums.get(i);
            minSofar = minSofar < minEndHere ? minSofar : minEndHere;
        }
        return minSofar;
    }


    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        // write your code here
        //s[i][j]= Min(s[i][j-], s[i-1][j])
        //s[0][j]= sum(s[0][0]...s[0][j])
        //s[i][0]= sum(s[0][0],..s[i][0])
        int M = grid.length;
        int N = grid[0].length;

        int sum[][] = new int[M][N];
        sum[0][0] = grid[0][0];
        for (int i = 1; i < M; i++) {
            sum[i][0] = sum[i - 1][0] + grid[i][0];
        }

        for (int j = 1; j < N; j++) {
            sum[0][j] = sum[0][j - 1] + grid[0][j];
        }
        int cur = 0;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (i > 0 && j > 0) {
                    sum[i][j] = Math.min(sum[i][j - 1], sum[i - 1][j]) + grid[i][j];

                }
            }
        }
        return sum[M - 1][N - 1];

    }

    public int minimumTotal(int[][] triangle) {
        // write your code here

        //sum[i][j]=Min(sum[i-1][j], sum[i-1][j-1], sum[i-1][j+1]
        //sum[[i][0]=
        if (triangle == null || triangle.length == 0) {
            return 0;
        }
        int level = triangle.length;

        int[][] sum = new int[level][level];
        sum[0][0] = triangle[0][0];
        for (int i = 1; i < level; i++) {
            sum[i][0] = sum[i - 1][0] + triangle[i][0];
        }
        for (int i = 1; i < level; i++) {
            sum[i][i] = sum[i - 1][i - 1] + triangle[i][i];
        }
        for (int i = 1; i < level; i++) {
            for (int j = 1; j < i; j++) {

                sum[i][j] = Math.min(sum[i - 1][j], sum[i - 1][j - 1]) + triangle[i][j];

            }
        }
        int min = sum[level - 1][0];
        for (int i = 0; i < level; i++) {
            min = Math.min(min, sum[level - 1][i]);
        }
        return min;

    }

    public int uniquePaths(int m, int n) {
        if (m <= 0 || n <= 0) {
            return -1;
        }
        // write your code here
        int[][] total = new int[m][n];
        total[0][0] = 1;
        for (int i = 0; i < m; i++) {
            total[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            total[0][i] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; i < n; j++) {
                total[i][j] = total[i - 1][j] + total[i][j - 1];
            }
        }
        return total[m - 1][n - 1];
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // write your code here
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        int[][] total = new int[m][n];
        if (obstacleGrid[0][0] == 1 || obstacleGrid[m - 1][n - 1] == 1) {
            return 0;
        }
        total[0][0] = 1;
        boolean getThrough = true;
        for (int i = 0; i < m; i++) {
            if (getThrough && obstacleGrid[i][0] == 0) {
                total[i][0] = 1;
            } else {
                break;


            }
        }
        getThrough = true;
        for (int i = 0; i < n; i++) {
            if (getThrough && obstacleGrid[0][i] == 0) {
                total[0][i] = 1;
            } else {
                break;

            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] != 1) {
                    total[i][j] = total[i - 1][j] + total[i][j - 1];

                } else {
                    total[i][j] = 0;
                }
            }
        }
        return total[m - 1][n - 1];
    }

    public boolean canJump(int[] A) {
        // wirte your code here

        if (A == null) {
            return false;
        }
        if (A.length == 0) {
            return true;
        }

        boolean[] can = new boolean[A.length];
        can[0] = true;
        for (int i = 1; i < A.length; i++) {
            for (int j = 0; j < i; j++) {
                if (can[j] && j + A[j] == i) {
                    can[i] = true;
                }
            }

        }
        return can[A.length - 1];
    }

    public int jump(int[] A) {
        // write your code here
        if (A == null || A.length == 0) {
            return -1;
        }
        int[] jumpCoumts = new int[A.length];
        jumpCoumts[0] = 0;
        for (int i = 1; i < A.length; i++) {
            int minJumpToI = Integer.MAX_VALUE;
            for (int j = 0; j < i; j++) {
                if (A[j] > 0 && j + A[j] >= i) {
                    minJumpToI = Math.min(jumpCoumts[j], minJumpToI);
                }
            }

            jumpCoumts[i] = minJumpToI + 1;
        }
        return jumpCoumts[A.length - 1];
    }

    public boolean wordBreak(String s, Set<String> dict) {
        if (dict.isEmpty()) {
            return false;
        }
        // write your code here
        if (s == null || s.length() == 0) {
            return false;
        }
        int longest = getMaxLength(dict);
        boolean[] can = new boolean[s.length() + 1];
        can[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int last = 1; last <= i && last <= longest; last++) {
                can[i] = can[i - last] && dict.contains(s.substring(i - last, i));
                if (can[i]) {
                    break;
                }
            }

        }
        return can[s.length() - 1];
    }

    int getMaxLength(Set<String> dict) {
        int max = Integer.MIN_VALUE;
        for (String str : dict) {
            max = Math.max(str.length(), max);

        }
        return max;
    }

    public int longestIncreasingSubsequence(int[] nums) {
        // write your code here
        if (nums == null) {
            return -1;
        }
        if (nums.length == 0) {
            return 0;
        }
        int[] lis = new int[nums.length];

        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            lis[i] = 1;
            for (int j = 0; j < i; j++) {
                lis[i] = nums[i] >= nums[j] ? Math.max(lis[i], lis[j] + 1) : lis[i];


            }
            max = Math.max(max, lis[i]);


        }
        return max;


    }

    private static int[][] isPHash;

    private static boolean isP(int start, int end, String s) {
        if (isPHash[start][end] != 0) {
            return isPHash[start][end] > 0 ? true : false;
        }

        String str = s.substring(start, end);

        int sp = 0;
        int ep = str.length() - 1;
        while (sp + 1 < ep) {
            if (str.charAt(sp) == str.charAt(ep)) {
                sp++;
                ep--;
            } else {
                isPHash[start][end] = -1;

                return false;

            }

        }
        if (sp == ep || str.charAt(sp) == str.charAt(ep)) {

            isPHash[start][end] = 1;
            return true;
        } else {
            isPHash[start][end] = -1;

            return false;

        }


    }

    public static int minCut(String s) {
        // write your code here
        if (s == null) {
            return -1;
        }
        if (s.length() == 0) {
            return 0;
        }
        isPHash = new int[s.length() + 1][s.length() + 1];

        int[] cut = new int[s.length() + 1];
        cut[0] = -1;
        for (int i = 1; i <= s.length(); i++) {
            cut[i] = i - 1;
            for (int j = 0; j < i; j++) {
                if (isP(j, i, s)) {
                    cut[i] = Math.min(cut[j] + 1, cut[i]);
                }
            }
        }
        return cut[s.length()];
    }


    public static void main(String[] args) {
        DP problems = new DP()
;
        problems.longestPalindrome("aaaa");
    }

    public static int longestCommonSubstring(String A, String B) {
        // write your code here
        if (A == null || B == null) {
            return 0;
        }

        int al = A.length();
        int bl = B.length();
        if (al == 0 || bl == 0) {
            return 0;
        }


        int longest = 0;
        for (int a = 0; a < al; ++a) {
            int len = 0;
            for (int b = 0; b < bl; ++b) {
                while (a + len < al && b + len < bl &&
                        A.charAt(a + len) == B.charAt(b + len)) {
                    len++;
                    longest = Math.max(len, longest);

                }


            }
        }
        return longest;

    }

    private boolean contain(String a, char b) {
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) == b) {
                return true;
            }
        }
        return false;
    }

    public int longestCommonSubsequence(String A, String B) {
        // write your code here
        if (A == null || B == null) {
            return 0;
        }
        if (A.length() == 0 || B.length() == 0) {
            return 0;
        }
        int aLen = A.length();
        int bLen = B.length();


        int[][] lcs = new int[aLen][bLen];
        for (int i = 0; i < aLen; i++) {
            lcs[i][0] = 0;
        }
        for (int i = 0; i < aLen; i++) {
            lcs[0][i] = 0;
        }
        for (int i = 1; i <= aLen; i++) {
            for (int j = 1; j <= bLen; j++) {
                int preMax = Math.max(lcs[i - 1][j], lcs[i][j - 1]);
                if (A.charAt(i) == B.charAt(j)) {
                    lcs[i][j] = preMax + 1;
                }
            }
        }
        return lcs[aLen][bLen];
    }

    public int minDistance(String word1, String word2) {
        if (word1 == null || word2 == null) {
            return -1;
        }

        // write your code here
        int fromLen = word1.length();
        int toLen = word2.length();
        if (fromLen == 0) {
            return toLen;
        }
        if (toLen == 0) {
            return fromLen;
        }
        int[][] ops = new int[fromLen + 1][toLen + 1];


        int[][] lcs = new int[fromLen + 1][toLen + 1];
        for (int i = 0; i <= fromLen; i++) {
            ops[i][0] = i;
        }
        for (int i = 0; i <= toLen; i++) {
            ops[0][i] = i;
        }
        for (int i = 1; i <= fromLen; i++) {
            for (int j = 1; j <= toLen; j++) {
                int preMin = Math.min(ops[i][j - 1], ops[i - 1][j]);
                if (word1.charAt(i) == word2.charAt(j)) {
                    ops[i][j] = ops[i - 1][j - 1];
                } else {
                    ops[i][j] = Math.min(preMin, ops[i - 1][j - 1]) + 1;
                }
            }
        }
        return ops[fromLen][toLen];

    }

    public int numDistinct(String S, String T) {
        if (T == null || S == null) {
            return -1;
        }

        // write your code here
        int sLen = S.length();
        int tLen = T.length();

        if (sLen == 0) {
            return -1;
        }
        if (tLen == 0) {
            return 1;
        }
        if (sLen < tLen) {
            return -1;
        }
        int[][] ops = new int[sLen + 1][tLen + 1];

        for (int i = 0; i < sLen; i++) {
            ops[i][0] = 1;
        }


        for (int i = 1; i <= sLen; i++) {
            for (int j = 1; j <= tLen; j++) {
                if (S.charAt(i - 1) == T.charAt(j - 1)) {
                    ops[i][j] = ops[i - 1][j] + ops[i - 1][j - 1];
                } else {
                    ops[i][j] = ops[i - 1][j];

                }
            }
        }

        return ops[sLen][tLen];


    }

    private int getDistinct(String source, String target) {

        int tPnt = 0;
        int sPnt = 0;
        int count = 0;
        while (sPnt < source.length() && tPnt < target.length()) {
            if (source.charAt(sPnt) == target.charAt(tPnt)) {
                tPnt++;
                sPnt++;
                count++;

            } else {
                sPnt++;
            }
        }
        if (tPnt == target.length()) {
            return count;
        } else {
            return -1;
        }
    }

    public boolean isInterleave(String s1, String s2, String s3) {
        // write your code here

        int s1Len = s1.length();
        int s2Len = s2.length();

        int s3Len = s3.length();
        if (s1Len + s2Len != s3Len) {
            return false;
        }

        boolean[][] isInter = new boolean[s1Len + 1][s2Len + 1];

        for (int i = 0; i < s1Len; i++) {
            isInter[i][0] = s1.charAt(i - 1) == s3.charAt(i - 1);
        }
        for (int i = 0; i < s2Len; i++) {
            isInter[0][i] = s2.charAt(i - 1) == s3.charAt(i - 1);
        }
        for (int i = 1; i <= s1Len; i++) {
            for (int j = 1; j <= s2Len; j++) {
                if (s3.charAt(i + j - 1) == s1.charAt(i - 1)) {
                    isInter[i][j] = isInter[i - 1][j];
                } else if (s3.charAt(i + j - 1) == s2.charAt(j - 1)) {
                    isInter[i][j] = isInter[i][j - 1];

                } else {
                    isInter[i][j] = false;
                }
            }
        }

        return isInter[s1Len][s2Len];
    }

    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }

        boolean[][] check = new boolean[s.length()][s.length()];
        int max = Integer.MIN_VALUE ;
        for(int m=0;m<s.length();m++){
            check[m][m] = true;
        }
        String longest = s.substring(0,1);
        for(int i=1;i<s.length();i++) {
            for (int j = 0; j < i; j++) {
                if (j <= i - 2) {
                    if (s.charAt(i) == s.charAt(j) && check[j + 1][i - 1]) {

                        longest = i-j+1>longest.length()?s.substring(j, i + 1): longest;
                        check[i][j]=true;

                    }

                } else {
                    if (s.charAt(i) == s.charAt(j)) {
                        longest = i-j+1>longest.length()?s.substring(j, i + 1): longest;
                        check[i][j]=true;
                    }

                }


            }
        }

        return longest;
    }

    public int numDecodings(String s) {
        if (s==null ||s.length()==0){
            return 0;
        }
        int[] counts = new int[s.length()+1];
        counts[0] = 0;
        counts[1]= s.charAt(0) !='0'? 1:0;
        for(int i=2;i<=s.length();i++){

            if(s.charAt(i-1)!='0'){
                counts[i] = counts[i] +counts[i-1];
            }
            if((s.charAt(i-2)=='1' || s.charAt(i-2) =='2')){
                counts[i] = counts[i] + counts[i-2];
            }
        }
        return counts[s.length()];

    }

    public int longestIncreasingContinuousSubsequence(int[] A) {
        // Write your code here
        if (A==null || A.length==0){
            return 0;
        }
        if (A.length==1){
            return 1;
        }
        int longest = Integer.MIN_VALUE;
        int tmpLen = 0;
        for (int i =1;i<A.length;i++){
            if (A[i] == A[i-1] +1){
                tmpLen++;
            }else{
                longest = Math.max(longest, tmpLen);
                tmpLen=0;
            }
        }
        tmpLen = 0;
        for (int i =1;i<A.length;i++){
            if (A[i] == A[i-1] -1){
                tmpLen++;
            }else{
                longest = Math.max(longest, tmpLen);
                tmpLen=0;
            }
        }

        return longest;
    }


}
