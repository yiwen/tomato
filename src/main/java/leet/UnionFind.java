package leet;

import java.util.HashMap;
import java.util.Set;

/**
 * Created by ygao on 3/30/16.
 */
public class UnionFind {

    HashMap<Integer, Integer> map;

    public UnionFind(Set<Integer> set) {
        map =  new HashMap<Integer, Integer>();
        for(Integer i : set){
            map.put(i, i);
        }


    }

    public int find(int t){
        int parent = map.get(t);
        while(parent!=map.get(parent)){
            parent=map.get(parent);
        }
        return parent;
    }


    public void union(int x, int y){
        int parentX=find(x);
        int parentY=find(y);
        if (parentX!=parentY){
            map.put(parentX, parentY);
        }
    }
}
