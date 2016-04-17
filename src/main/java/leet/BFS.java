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
        while(!queue.isEmpty()){
            UndirectedGraphNode cur = queue.poll();
            if(!nodeMap.containsKey(cur)){
                nodeMap.put(cur, new UndirectedGraphNode(cur.label));
            }
            for(UndirectedGraphNode nei: cur.neighbors){
                queue.offer(nei);
            }
        }
        for(UndirectedGraphNode oldNode: nodeMap.keySet()){
            ArrayList<UndirectedGraphNode> neis = oldNode.neighbors;
            UndirectedGraphNode newNode = nodeMap.get(oldNode);
            ArrayList<UndirectedGraphNode> newNeis = new ArrayList<UndirectedGraphNode>();
            for(UndirectedGraphNode nei : neis){
                newNeis.add(nodeMap.get(nei));
            }
            newNode.neighbors = newNeis;

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

    public  void main1(String[] args){
        String x = new String("123");
        String y=new String("123");
        System.out.println(x.equals(y));
        System.out.println(x==y);

    }

    public List<List<String>> findLadders(String start, String end, Set<String> dict) {
        // write your code here
        List<List<String>> rst = new ArrayList<List<String>>();
        if (dict==null || dict.size()==0){
            return rst;
        }
        Set<String> visited = new HashSet<String>();
        visited.add(start);
        dict.add(end);
        List<String> oneRst = new ArrayList<String>();
        dfs(dict, visited, rst, oneRst, end, start);

        return rst;


    }
    void dfs( Set<String> dict, Set<String> visited ,List<List<String>> rst,  List<String> oneRst,String end, String word){
        oneRst.add(word);
        visited.add(word);
        if (word.equals(end)){
            rst.add(oneRst);
            return;
        }
        if (!visited.contains(word)){

            for (String nextW: getRelated(dict, word)) {
                dfs(dict,visited, rst, new ArrayList<String>(oneRst), end, nextW);
            }
        }
    }
    public int ladderLength(String start, String end, Set<String> dict) {
        // write your code here

        if (dict==null || dict.size()==0){
            return -1;
        }

        dict.add(end);
        Queue<String> wq = new LinkedList<String>();
        Set<String> visited = new HashSet<String>();
        wq.add(start);
        visited.add(start);
        int len=1;
        while(!wq.isEmpty()){
            int qSize = wq.size();
            len++;
            for (int i=0;i<qSize;i++){
                String cur = wq.poll();

                for(String word : getRelated(dict, cur)){

                    if(word.equals(end)){
                        return len;
                    }
                    if (!visited.contains(word))  {


                        visited.add(word);


                        wq.offer(word);
                    }

                }
            }




        }

        return -1;
    }

    List<String> getRelated(Set<String> dict, String word){
        System.out.println(word + " can change to: ");

        List<String> related = new ArrayList<String>();
        for (String wIndict :  dict){
            if (canChangeTo(word, wIndict)){
                related.add(wIndict);
                System.out.print(wIndict + ",");
            }
        }
        System.out.println();
        return related;
    }
    boolean canChangeTo(String from, String to){
        boolean changed=false;
        for (int i=0; i <from.length() ;i++){
            if (from.charAt(i)!=to.charAt(i)){
                if (!changed) {
                    changed = true;
                }else{
                    return false;
                }
            }
        }
        return true;

    }

    public static void main(String[] args){
        BFS p = new BFS();
        Set<String> dict = new HashSet<String>();
        dict.add("frye");
        dict.add("heat");
        dict.add("tree");
        dict.add("thee");
        dict.add("game");
        dict.add("free");
        dict.add("hell");
        dict.add("fame");
        dict.add("faye");
        p.ladderLength("game", "thee", dict);
    }

    public List<List<Integer>> connectedSet(ArrayList<UndirectedGraphNode> nodes) {
        List<List<Integer>> rst = new ArrayList<List<Integer>>();

        Set<UndirectedGraphNode> visited = new HashSet<UndirectedGraphNode>();
        for (UndirectedGraphNode node : nodes) {
            if (!visited.contains(node)) {
                bfs(rst, visited, node);
            }
        }
        return rst;

    }

    void bfs(List<List<Integer>> rst , Set<UndirectedGraphNode> visited , UndirectedGraphNode node ){
        List<Integer> oneRst = new ArrayList<Integer>();
        Queue<UndirectedGraphNode> graphNodeQueue = new LinkedList<UndirectedGraphNode>();
        graphNodeQueue.offer(node);
        visited.add(node);

        while(!graphNodeQueue.isEmpty()){
            UndirectedGraphNode cur = graphNodeQueue.poll();
            oneRst.add(cur.label);

            for(UndirectedGraphNode nei : cur.neighbors){
                if(!visited.contains(nei)) {
                    graphNodeQueue.offer(nei);
                    visited.add(nei);
                }
            }
        }
        Collections.sort(oneRst);
        rst.add(oneRst);
    }
}
