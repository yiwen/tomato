package leet;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class BinaryTree {
    
    
      public class TreeNode {
          public int val;
          public TreeNode left, right;
          public TreeNode(int val) {
              this.val = val;
              this.left = this.right = null;
          }
      }

    public ArrayList<Integer> preorderTraversal(TreeNode root) {
         // write your code here

        if (root == null) {
            return null;
        }
        ArrayList<Integer> rst = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>() ;
        stack.push(root);
        while(!stack.empty()){
            TreeNode cur = stack.pop() ;

            rst.add(cur.val);

            if (cur.right!=null) {
                stack.push(cur.right);
            }

            if (cur.left!=null) {
                stack.push(cur.left);
            }



        }
        return rst;
     }

    public ArrayList<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> rst = new ArrayList<Integer>();

        // write your code here
        if (root ==  null){
            return rst;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>() ;
        stack.push(root);
        while (!stack.empty()){
            TreeNode cur = stack.pop() ;
            rst.add(cur.val);
            if (cur.left!=null){
                stack.push(cur.left);
            }
            if (cur.right!=null){
                stack.push(cur.right);
            }
        }

         Collections.reverse(rst);
        return rst;


    }

    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        // write your code here

        ArrayList<Integer> rst =  new ArrayList<Integer>();
        if (root == null){
            return rst;
        }

        Stack<TreeNode> stack = new Stack<TreeNode>() ;
        TreeNode cur= root;
        while(cur!=null|| !stack.empty()){
            if(cur!=null){
                stack.push(cur) ;
                cur = cur.left;
            }  else {
               cur = stack.pop();
                rst.add(cur.val);
                cur = cur.right;


            }
        }
        return rst;
    }
}