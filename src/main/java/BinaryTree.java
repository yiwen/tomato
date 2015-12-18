import java.util.*;

/**
 * Created by yiwengao on 5/5/15.
 */


public class BinaryTree {
    public void flatten(TreeNode root) {
            Stack<TreeNode> stack = new Stack<TreeNode>();
            List<TreeNode> nodeList = new ArrayList<TreeNode>();
            if (root ==null){
                return ;
            }
            TreeNode pre = null;
            stack.push(root);
                    stack.push(root);
        while(!stack.isEmpty()){
                TreeNode node =  stack.pop();
                if (pre == null){
                    pre = node;
                }else{
                    pre.right = node;
                    pre = node;
                }
                if (node.right!=null) {
                    stack.push(node.right);
                }
                if (node.left !=null){
                    stack.push(node.left);
                }
            }

        }

    public List<TreeNode> inorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        List<TreeNode> nodeList = new ArrayList<TreeNode>();
        if (root ==null){
            return nodeList;
        }

        TreeNode curr = null;
        stack.push(root);
        curr=root;
        while(!stack.isEmpty() && curr!=null) {
            if (curr.left!=null) {
                stack.push(curr.left);
                curr= curr.left;
            } else {
                TreeNode node = stack.pop();
                nodeList.add(node);
                curr = node.right;
            }
        }

        return nodeList;

    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> rst = new ArrayList<List<Integer>>();
        if (root!=null){
           Stack<TreeNode> level = new Stack<TreeNode>();
           level.push(root);
            addTreeLevel(rst, level);
            boolean withNode = true;
            boolean rightFirst=true;
            while(withNode) {
                withNode = false;
               Stack<TreeNode> newLevel = new Stack<TreeNode>();

               while(!level.isEmpty()){
                   TreeNode node =level.pop();
                   if (node!=null ){
                       if (rightFirst){
                            if (node.right!=null ) {
                               withNode = true;
                                newLevel.push(node.right);
                           }
                             if (node.left!=null){
                               withNode = true;
                                 newLevel.push(node.left);
                           }


                       }else{
                           if (node.left!=null){
                               withNode = true;
                               newLevel.push(node.left);
                           }
                           if (node.right!=null ) {
                               withNode = true;
                               newLevel.push(node.right);
                           }

                       }
                   }
               }
                rightFirst=!rightFirst;
               level = newLevel;
               addTreeLevel(rst, level);

            }
        }
        return rst;

    }



    private void addTreeLevel(List<List<Integer>> rst, Stack<TreeNode> nodeList){
        List<Integer> integerList = new ArrayList<Integer>();
        while (nodeList!=null && !nodeList.isEmpty()) {

            integerList.add(nodeList.pop().val);
        }
        rst.add(integerList);
    }

    public List<List<Integer>> permute(int[] nums) {
        if (nums == null){
            return null;
        }

        List<List<Integer>> rst = new ArrayList<List<Integer>>();
        List<Integer> list = new ArrayList<Integer>();
        for (int i=0; i <nums.length ; i++) {
            int currentPos = nums[i];
            int toSwapPos = currentPos ++ ;
            while(toSwapPos < nums.length) {
                swap(currentPos, toSwapPos, nums);
                toSwapPos ++;

            }
        }
        return  null;

    }

    private void swap(int currentPos, int toSwapPos, int[] nums) {
        int a = nums[currentPos];
        int tmp = a;
        nums[currentPos]=nums[toSwapPos];
        nums[toSwapPos] = tmp;

    }

    private void convertToString(int[] nums) {

    }

    public static void main(String[] args){
            System.out.println(findFirsNonRepeat("stress"))  ;
        }
   public static Character findFirsNonRepeat(String s){
        if (s == null ){
            return null;
        }
        if (s.length() == 0) {
            return  null;
        }
        if (s.trim().length() == 0){
            return ' ';
        }
        Map<Character, Boolean> map = new HashMap<Character, Boolean>();
        Character rst = null;
        for (Character c: s.toCharArray()){
            if (map.containsKey(c)){
                map.put(c, Boolean.FALSE) ;
                if (c.equals(rst)){
                    rst = null;
                }
            } else {
               if (rst == null){
                   rst = c;
               }
                map.put(c,Boolean.TRUE);
            }
        }
        return rst;
    }

}



