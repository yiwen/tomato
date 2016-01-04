package leet;

/**
 * Created by yiwengao on 5/3/15.
 */
public class NumOfIsland {

    public static  int numIslands(boolean[][] grid) {

        if (grid.length ==0 || (grid[0].length==0) ){
              return 0;
          }
        // Write your code here
        int row = grid.length;
          int col = grid[0].length;
          boolean[][] visited = new boolean[row][col];

        int count = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {

                if (!visited[i][j] && grid[i][j]) {
                    dfs(i, j, visited, grid, row, col);
                    count++;
                }
            }

        }
        return count;
    }

    static int[] rowAdj = {-1, -1,-1, 0,0,1,1, 1};
    static int[] colAdj = {-1,  0,1, -1,1,-1,0, 1};

    private static void dfs(int i, int j, boolean[][] visited, boolean[][] grid,int row, int col){
        visited[i][j] =true;

        for (int m=0; m<8 ;m ++){
            if(canBeVisited(i + rowAdj[m], j + colAdj[m], visited, grid, row, col)){
                dfs(i + rowAdj[m], j + colAdj[m], visited, grid,row, col );
            }
        }
    }

    private static boolean canBeVisited(int r, int c,boolean[][] visited, boolean[][] grid,  int row, int col){
        if (r < row && r >=0 && c <col && c >=0 && grid[r][c] && !visited[r][c]){
            return true;
        }
        return false;
    }

    public static void main (String[] args) throws java.lang.Exception
        {
             boolean[][] M=  new boolean[][] {{true ,false},

                                     { false, true}
                                    };
            System.out.println("Number of islands is: "+ numIslands(M));
        }

}
