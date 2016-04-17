package leet;

import java.util.*;

/**
 * Created by ygao on 3/30/16.
 */
public class UF {

    public List<List<Integer>> connectedSet2(ArrayList<DirectedGraphNode> nodes) {
        List<List<Integer>> rst = new ArrayList<List<Integer>>();
        HashSet<Integer> set = new HashSet<Integer>();
        for(DirectedGraphNode node : nodes){
            set.add(node.label);
            for(DirectedGraphNode nei : node.neighbors) {

                set.add(nei.label);
            }
        }

        UnionFind uf = new UnionFind(set);

        for(DirectedGraphNode node : nodes){
            for(DirectedGraphNode nei : node.neighbors){
                    uf.union(nei.label, node.label);
            }
        }

        Map<Integer, List<Integer>> parentChildren = new HashMap<Integer, List<Integer>>();
        for(Integer i : uf.map.keySet()){
            int parent=uf.map.get(i);
            if(parentChildren.containsKey(parent)){
                List<Integer> children = parentChildren.get(parent);
                children.add(i);
            }else{
                List<Integer> children = new ArrayList<Integer>();
                children.add(i);
                parentChildren.put(parent,children );
            }
        }
        for(Integer parent : parentChildren.keySet()){
            List<Integer> oneSet = parentChildren.get(parent);
            Collections.shuffle(oneSet);
            rst.add(oneSet);

        }

        return rst;
    }
}