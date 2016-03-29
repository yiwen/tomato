package leet;

import java.util.ArrayList;

/**
 * Created by ygao on 3/14/16.
 */
public class DFS {

    public boolean exist(char[][] board, String word) {

        if (board==null && board.length==0 || word==null){
            return false;
        }

        for (int i=0 ; i < board.length ; i++){
            for (int j = 0; j < board[0].length; j++){
                int w = 0;
                if (board[i][j] == word.charAt(w)) {

                    boolean rst = dfs(i, j, board, word, w);
                    if (rst){
                        return true;
                    }
                }

            }
        }

        return false;



    }

    boolean dfs(int i, int j, char[][] board, String word, int pos){
        if (pos == word.length()){
            return true;
        }

        if (visitable(i, j, board) && board[i][j] == word.charAt(pos)){
            char tmp = board[i][j];
            board[i][j] = '#';

           boolean rst = dfs(i, j-1, board, word, pos+1)|| dfs(i, j+1, board, word, pos+1) || dfs(i-1, j, board, word, pos+1) ||dfs(i+1, j, board, word, pos+1);
            board[i][j] = tmp;
            return rst;

        }
        return false;


    }

    boolean visitable(int i, int j, char[][] board){
        if (i>=0 && i  < board.length && j>=0&& j <board[0].length){
            return true;
        }
        return false;
    }


    public ArrayList<String> wordSearchII(char[][] board, ArrayList<String> words) {
        ArrayList<String> rst = new ArrayList<String>();

        if (board==null ||board.length==0|| words==null ||words.size()==0){
            return rst;
        }

        for (String word :  words){
            if (exist(board, word)){
                rst.add(word);
            }
        }
        return rst;
    }

}
