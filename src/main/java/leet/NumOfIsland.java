package leet;

/**
 * Created by yiwengao on 5/3/15.
 */
public class NumOfIsland {
    public static void main(String[] args){
        char[][] grid = new char[1][1];
        grid[0][0] = '0';
        System.out.println(solve(grid));
    }
    public static int solve(char[][] grid){
        int count = 0;
        int n = grid.length;
        if (n==0){
           return 0;
        }
        int m = grid[0].length;
        int maxJ=-1;
        int iStart = -1;
        int jStart = -1;

        int maxI=-1;
        boolean found = false;
        while(iStart+1 < m&& jStart +1 <n) {
            for (int i = iStart + 1; i < grid.length; i++) {
                int j= jStart + 1;

                while (j<n && grid[i][j] == '1') {
                    maxI = i;
                    maxJ = j;
                    j++;
                }
            }
            if (maxI != iStart && maxJ != jStart) {
                count++;
                jStart++;
                iStart++;
                found=true;

            }
        }
        return count;
    }
}
