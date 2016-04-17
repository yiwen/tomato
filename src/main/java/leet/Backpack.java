package leet;

/**
 * Created by ygao on 4/13/16.
 */
public class Backpack {

    public int backPack(int m, int[] A) {
        // write your code here
        if (A==null || A.length==0 || m==0){
            return 0;
        }
        boolean[][] backPack = new boolean[A.length+1][m+1];

        for(int i =0;i<A.length+1;i++){
            backPack[i][0]=false;
        }

        for(int i=1;i<A.length+1;i++){
            for (int j=1 ; j<=m;j++){
                backPack[i][j] = backPack[i-1][j-1];
                if(j>=A[i] && backPack[i-1][j-A[i]] ){
                    backPack[i][j]=true;
                }
            }
        }
        for(int i=m ;i>=0;i--){
            if(backPack[A.length+1][i]){
                return i;
            }
        }
        return 0;

    }
}
