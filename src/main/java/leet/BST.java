package leet;

import java.util.*;

/**
 * Created by yiwengao on 1/22/16.
 */
public class BST {

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return false;
        }

        // write your code here
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode cur = root;
        TreeNode prev;
        stack.push(cur);
        while (cur != null || !stack.isEmpty()) {

            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                prev = cur;
                cur = stack.pop();
                if (prev != null && prev.val >= cur.val) {
                    return false;
                }
                cur = cur.right;
            }

        }
        return true;

    }

    public boolean isValidBSTRec(TreeNode root) {
        if (root == null) {
            return true;
        }

        return bstValidation(root).isValid;

    }

    BSTValidation bstValidation(TreeNode node) {
        if (node == null) {
            return new BSTValidation(true, null, Integer.MIN_VALUE, Integer.MAX_VALUE);
        }
        BSTValidation leftRst = bstValidation(node.left);
        BSTValidation rightRst = bstValidation(node.right);

        if (!leftRst.isValid) {
            return new BSTValidation(false, node.left, 0, 0);
        }
        if (!rightRst.isValid) {
            return new BSTValidation(false, node.right, 0, 0);
        }
        if ((node.left != null && node.val <= leftRst.max) || (node.right != null && node.val >= rightRst.min)) {
            return new BSTValidation(false, node, 0, 0);

        } else {
            return new BSTValidation(true, node, Math.max(node.val, rightRst.max), Math.min(node.val, leftRst.min));


        }

    }

    public class BSTValidation {
        private boolean isValid;
        private TreeNode node;
        private int max;
        private int min;

        public BSTValidation(boolean isValid, TreeNode node, int max, int min) {
            this.isValid = isValid;
            this.node = node;
            this.max = max;
            this.min = min;
        }
    }

    public ArrayList<Integer> searchRange(TreeNode root, int k1, int k2) {
        if (root == null) {
            return new ArrayList<Integer>();
        }
        // write your code here
        if (k1 > root.val && k2 > root.val) {
            searchRange(root.right, k1, k2);

        } else if (k1 < root.val && k2 < root.val) {
            searchRange(root.left, k1, k2);

        } else {
            return Inorder(root, k1, k2);

        }
        return new ArrayList<Integer>();


    }

    ArrayList<Integer> Inorder(TreeNode node, int lower, int upper) {
        ArrayList<Integer> rst = new ArrayList<Integer>();

        if (node == null) {
            return rst;
        }
        TreeNode cur = node;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while (cur != null || !stack.empty()) {
            if (cur != null) {
                if (cur.val >= lower && cur.val <= upper) {
                    stack.push(cur);
                }

                if (cur.val > upper) {
                    break;
                }
                cur = cur.left;
            } else {
                cur = stack.pop();
                rst.add(cur.val);
                cur = cur.right;
            }
        }
        return rst;
    }

    ArrayList<Integer> searchRangeRst = new ArrayList<Integer>();


    private void searchRangeHelper(TreeNode root, int k1, int k2) {
        if (root == null) {
            return;
        }
        if (root.val > k1) {
            searchRangeHelper(root.left, k1, k2);
        }

        if (root.val >= k1 && root.val <= k2) {

            searchRangeRst.add(root.val);


        }

        if (root.val < k2) {
            searchRangeHelper(root.right, k1, k2);
        }
    }


}
