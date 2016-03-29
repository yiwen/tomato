package leet;

import java.util.*;

/**
 * Created by ygao on 2/26/16.
 */
public class BFS {

    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        // write your code here
        if (node == null) {
            return null;
        }

        Map<UndirectedGraphNode, UndirectedGraphNode> nodeMap = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
        Queue<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
        queue.offer(node);
        nodeMap.put(node, new UndirectedGraphNode(node.label));
        while (!queue.isEmpty()) {
            UndirectedGraphNode cur = queue.poll();
            for (UndirectedGraphNode graphNode : cur.neighbors) {
                if (!nodeMap.containsKey(graphNode)) {
                    nodeMap.put(graphNode, new UndirectedGraphNode(graphNode.label));
                    queue.offer(graphNode);
                }
            }

        }
        for (UndirectedGraphNode graphNode : nodeMap.keySet()) {
            UndirectedGraphNode newCur = nodeMap.get(graphNode);
            ArrayList<UndirectedGraphNode> newNeighbors = new ArrayList<UndirectedGraphNode>();
            for (UndirectedGraphNode node1 : graphNode.neighbors) {
                UndirectedGraphNode newNei = nodeMap.get(node1);
                newNeighbors.add(newNei);
            }
            newCur.neighbors = newNeighbors;
        }
        return nodeMap.get(node);
    }

    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<ArrayList<Integer>>();

        }
        ArrayList<ArrayList<Integer>> rst = new ArrayList<ArrayList<Integer>>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while (!queue.isEmpty()) {

            int size = queue.size();
            ArrayList<Integer> row = new ArrayList<Integer>();

            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                row.add(cur.val);
                if (cur.left != null) {
                    queue.offer(cur.left);
                }

                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }
            rst.add(row);

        }
        return rst;
    }

    public ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph) {
        // write your code here
        if (graph==null){
            return null;
        }
        Map<DirectedGraphNode, Integer> map = new HashMap<DirectedGraphNode, Integer>();
        for (DirectedGraphNode node : graph){
            for (DirectedGraphNode nei : node.neighbors){
                if (map.containsKey(nei)){
                    map.put(nei, map.get(nei)+1);
                } else{
                    map.put(nei, 1);
                }
            }
        }
        Queue<DirectedGraphNode> queue = new LinkedList<DirectedGraphNode>();
        ArrayList<DirectedGraphNode> rst = new ArrayList<DirectedGraphNode>();
        for (DirectedGraphNode node: map.keySet()){
            if (!map.containsKey(node)){
                rst.add(node);
                queue.offer(node);
            }
        }
        while(!queue.isEmpty()){
            DirectedGraphNode cur = queue.poll();
            rst.add(cur);
            for (DirectedGraphNode nei : cur.neighbors){

                map.put(nei, map.get(nei)-1);
                if (map.get(nei) == 0){
                    queue.offer(nei);

                }
            }
        }
        return rst;


    }

    public static void main(String[] args){
        String x = new String("123");
        String y=new String("123");
        System.out.println(x.equals(y));
        System.out.println(x==y);

    }
}
