package leet;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ygao on 3/15/16.
 */
public class TrieNode {
    boolean isLeaf;
    char c;
    Map<Character, TrieNode> children = new HashMap<Character, TrieNode>();

    public TrieNode(Character c){
        this.c =c;
    }

    public TrieNode() {
    }
}
