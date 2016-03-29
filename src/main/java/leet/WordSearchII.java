package leet;

import java.util.ArrayList;

/**
 * Created by ygao on 3/15/16.
 */
public class WordSearchII {
    public ArrayList<String> wordSearchII(char[][] board, ArrayList<String> words) {
        ArrayList<String> rst = new ArrayList<String>();

        if (board == null && board.length == 0 || words == null) {
            return rst;
        }

        TrieTree trieTree = new TrieTree();
        for(int i=0;i<words.size(); i++){
            trieTree.insert(words.get(i));
        }

        for(int i=0; i <board.length;i++){
            for (int j=0;j<board[0].length;j++){
                dfs(i, j, board, "", trieTree, rst);
            }
        }
        return rst;
    }

    void dfs(int i, int j, char[][] board, String word, TrieTree trieTree, ArrayList<String> rst){
        if (i<0 || i>board.length || j <0 || j>board[0].length){
            return ;
        }
        word = word + board[i][j];
        if (!trieTree.startsWith(word)){
            return ;
        }

        if (trieTree.search(word)){
            rst.add(word);
            return;
        }
        char tmp = board[i][j] = '#';
        dfs(i, j+1, board, word, trieTree, rst) ;
                dfs(i-1, j, board, word, trieTree, rst) ;
                dfs(i+1, j+1, board, word, trieTree, rst) ;
                dfs(i-1, j-1, board, word, trieTree, rst);

        board[i][j]=tmp;

    }
}
