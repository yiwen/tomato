package leet;

import java.util.Map;

/**
 * Created by ygao on 3/15/16.
 */
public class TrieTree {
    private TrieNode root;

    public TrieTree() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        Map<Character, TrieNode> children = root.children;
        for (int i=0; i <word.length() ; i++){
            char w = word.charAt(i);
            TrieNode t = null;
            if(children.containsKey(w)){
                t= children.get(w);

            } else{
                t = new TrieNode(w);
                children.put(w, t);

                if (i==word.length()-1){
                    t.isLeaf = true;
                }
            }
            children = t.children;

        }

    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        if (word==null || word.length()==0){
            return false;
        }
        TrieNode t = searchW(word);
        if (t!=null && !t.isLeaf){
            return true;
        }
        return false;
    }

    public TrieNode searchW(String word) {

        Map<Character, TrieNode> children = root.children;
        TrieNode t=null;
        for(int i=0;i<word.length();i++){
            char w = word.charAt(i);
            if (!children.containsKey(w)){
                return null;
            }else{
                t = children.get(w);
                children = t.children;
            }
        }
        return t;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        if (prefix==null || prefix.length()==0){
            return false;
        }
        TrieNode t = searchW(prefix);
        if (t!=null){
            return true;
        }
        return false;

    }
}
