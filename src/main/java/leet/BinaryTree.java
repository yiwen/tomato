package leet;


import java.util.*;

public class BinaryTree {


    public ArrayList<Integer> preorderTraversal(TreeNode root) {
        // write your code here

        if (root == null) {
            return null;
        }
        ArrayList<Integer> rst = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        while (!stack.empty()) {
            TreeNode cur = stack.pop();

            rst.add(cur.val);

            if (cur.right != null) {
                stack.add(cur.right);
            }
            if (cur.left != null) {
                stack.add(cur.left);
            }


        }
        return rst;
    }

    public ArrayList<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> rst = new ArrayList<Integer>();

        // write your code here
        if (root == null) {
            return rst;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        while (!stack.empty()) {
            TreeNode cur = stack.pop();
            rst.add(cur.val);
            if (cur.left != null) {
                stack.push(cur.left);
            }
            if (cur.right != null) {
                stack.push(cur.right);
            }
        }

        Collections.reverse(rst);
        return rst;


    }

    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        // write your code here

        ArrayList<Integer> rst = new ArrayList<Integer>();
        if (root == null) {
            return rst;
        }

        if (root == null) {
            return null;
        }
        TreeNode cur = root;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while (cur != null || !stack.isEmpty()) {
            if (cur.left != null) {
                stack.push(cur.left);
                cur = cur.left;
            } else {
                cur = stack.pop();
                rst.add(cur.val);
                cur = cur.right;
            }
        }
        return rst;
    }

    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> rst = new ArrayList<ArrayList<Integer>>();

        if (root == null) {
            return rst;
        }
        // write your code here
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);

        while (!queue.isEmpty()) {
            ArrayList<Integer> level = new ArrayList<Integer>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode item = queue.poll();
                level.add(item.val);

                if (item.left != null) {
                    queue.offer(item.left);

                }
                if (item.right != null) {
                    queue.offer(item.right);
                }
            }
            rst.add(level);

        }
        return rst;
    }

    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
        // write your code here
        ArrayList<ArrayList<Integer>> rst = new ArrayList<ArrayList<Integer>>();
        if (root == null) {
            return rst;
        }
        Queue<TreeNode> stack = new LinkedList<TreeNode>();
        stack.add(root);

        boolean reverse = true;
        while (!stack.isEmpty()) {
            ArrayList<Integer> level = new ArrayList<Integer>();
            int size = stack.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = stack.poll();
                level.add(cur.val);

                if (cur.right != null) {
                    stack.add(cur.right);
                }

                if (cur.left != null) {
                    stack.add(cur.left);

                }
            }


            if (!reverse) {
                rst.add(level);
            } else {
                Collections.reverse(level);
                rst.add(level);
            }
            reverse = !reverse;


        }
        return rst;
    }

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        int depth = 0;
        while (!queue.isEmpty()) {
            int count = queue.size();
            depth++;
            for (int i = 0; i < count; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }

        }
        return depth;

    }

    public int minDepth_recur(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return mindepth(root);

    }

    int mindepth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        if (node.left == null && node.right == null) {
            return 1;
        }
        int left = minDepth(node.left);
        int right = minDepth(node.right);
        return Math.min(left, right) + 1;
    }

    public int minDepth(TreeNode root) {
        // write your code here
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);


        int depth = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            depth++;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left == null && node.right == null) {
                    return depth;
                } else {
                    if (node.left != null) {
                        queue.add(node.left);
                    }
                    if (node.right != null) {
                        queue.add(node.right);
                    }
                }
            }
        }
        return depth;
    }

    public void flatten(TreeNode root) {
        // write your code here
        if (root == null) {
            return;
        }
        TreeNode node = new TreeNode(0);
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        TreeNode cur = null;
        TreeNode prev = node;

        while (!stack.isEmpty()) {
            cur = stack.pop();
            prev.right = cur;
            prev.left = null;
            prev = cur;
            if (cur.right != null) {
                stack.push(cur.right);

            }
            if (cur.left != null) {
                stack.push(cur.left);

            }


        }

    }

    public boolean isIdentical(TreeNode a, TreeNode b) {
        // Write your code here
        if (a == null && b != null) {
            return false;
        }

        if (a != null && b == null) {
            return false;
        }

        return (a.val == b.val) && isIdentical(a.left, b.left) && isIdentical(a.right, b.right);

    }

    public boolean isSubtree(TreeNode T1, TreeNode T2) {
        // write your code here
        if (T1 == null) {
            return false;
        }
        if (T2 == null) {
            return false;
        }

        return (isIdentical(T1, T2)) || isSubtree(T1.left, T2) || isSubtree(T1.right, T2);
    }

    public void invertBinaryTree(TreeNode root) {
        // write your code here
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();

                if (node.left != null) {
                    queue.add(node.left);

                }

                if (node.right != null) {
                    queue.add(node.right);
                }
                TreeNode tmp = node.left;
                node.left = node.right;
                node.right = tmp;
            }

        }
    }

    public List<String> binaryTreePaths(TreeNode root) {
        // Write your code here
        List<String> rst = new ArrayList<String>();

        if (root == null) {
            return rst;
        }
        dfs(root, String.valueOf(root.val), rst);
        return rst;


    }

    private void dfs(TreeNode node, String cur, List<String> rst) {
        if (node.left == null && node.right == null) {
            cur = cur + String.valueOf(node.val);
            rst.add(cur);
            return;
        }

        if (node.left != null) {
            cur = cur + String.valueOf(node.left.val) + "->";
            dfs(node.left, cur, rst);
        }
        if (node.right != null) {
            cur = cur + String.valueOf(node.right.val) + "->";
            dfs(node.right, cur, rst);
        }


    }

    public TreeNode sortedArrayToBST(int[] A) {
        // write your code here
        if (A == null) {
            return null;
        }
        return buildTree(A, 0, A.length - 1);
    }

    private TreeNode buildTree(int[] A, int start, int end) {
        if (start > end) {
            return null;
        }
        if (start == end) {
            return new TreeNode(A[start]);

        }
        int mid = (end + start) / 2;
        TreeNode node = new TreeNode(A[mid]);
        node.left = buildTree(A, start, mid - 1);
        node.right = buildTree(A, mid + 1, end);
        return node;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode A, TreeNode B) {
        if (root == null) {
            return null;

        }
        if (A == null) {
            return B;
        }
        if (B == null) {
            return A;
        }


        // write your code here
        if (root.val == A.val) {
            return A;
        }

        if (root.val == B.val) {
            return B;
        }
        TreeNode node1 = lowestCommonAncestor(root.left, A, B);
        TreeNode node2 = lowestCommonAncestor(root.right, A, B);
        if (node1 != null && node2 != null) {
            return root;
        }
        return node1 != null ? node1 : node2;

    }


    public boolean isBalanced(TreeNode root) {
        // write your code here
        if (root == null) {
            return true;

        }
        return getMaxDepth(root).isBalance;
    }

    Balance getMaxDepth(TreeNode node) {
        if (node == null) {
            return new Balance(true, 0);
        }
        Balance left = getMaxDepth(node.left);
        Balance right = getMaxDepth(node.right);
        if (!left.isBalance || !right.isBalance) {
            return new Balance(false, 0);
        }
        if (Math.abs(left.depth - right.depth) <= 1) {
            return new Balance(true, Math.max(left.depth, right.depth) + 1);
        } else {
            return new Balance(false, 0);

        }

    }

    public class Balance {
        private boolean isBalance;
        private int depth;

        public Balance(boolean isBalance, int depth) {
            this.isBalance = isBalance;
            this.depth = depth;
        }
    }

    public int maxDepthRec(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left, right) + 1;
    }

    public int maxPathSum2(TreeNode root) {
        // Write your code here
        if (root == null) {
            return 0;
        }

        int sumleft = maxPathSum2(root.left);
        int sumright = maxPathSum2(root.right);
        return Math.max(sumleft, sumright) + root.val;

    }

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null || p == null) {
            return null;
        }
        // write your code here
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode cur = root;
        TreeNode prev = null;
        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                cur = stack.pop();
                prev = cur;
                if (cur.val == p.val) {
                    return prev;
                }
                cur = cur.right;
            }
        }
        return null;
    }

    public int maxPathSum(TreeNode root) {
        // write your code here
        if (root == null) {
            return 0;
        }
        return getMaxPathRst(root).internal;
    }

    private MaxPathRst getMaxPathRst(TreeNode node) {
        if (node == null) {
            return new MaxPathRst(0, Integer.MIN_VALUE);
        }
        MaxPathRst left = getMaxPathRst(node.left);
        MaxPathRst right = getMaxPathRst(node.right);

        int maxFromRoot = Math.max(Math.max(left.fromRoot, right.fromRoot) + node.val, 0);


        int maxInternal = Math.max(left.internal, right.internal);
        int newMaxInternal = Math.max(maxInternal, left.fromRoot + right.fromRoot + node.val);
        return new MaxPathRst(maxFromRoot, newMaxInternal);

    }

    public class MaxPathRst {
        int fromRoot;
        int internal;

        public MaxPathRst(int fromRoot, int internal) {
            this.fromRoot = fromRoot;
            this.internal = internal;
        }
    }


    void binaryTreePathSumHelper(TreeNode root, int target) {
        if (root == null) {

        }

    }


    class TDclass {
        int fromRoot;
        int dia;

        public TDclass(int fromRoot, int dia) {
            this.fromRoot = fromRoot;
            this.dia = dia;
        }
    }

    TDclass longestPathHelper(TreeNode node) {
        if (node == null) {
            return new TDclass(0, 0);
        }


        TDclass left = longestPathHelper(node.left);
        TDclass right = longestPathHelper(node.right);


        int maxDia = Math.max(left.dia, right.dia);
        int fromRoot = Math.max(left.fromRoot, right.fromRoot) + 1;
        int maxDiaFinal = Math.max(fromRoot, maxDia);
        return new TDclass(fromRoot, maxDia);
    }

    public List<List<Integer>> binaryTreePathSum(TreeNode root, int target) {
        if (root == null) {
            return null;
        }
        List<List<Integer>> rst = new ArrayList<List<Integer>>();
        List<Integer> row = new ArrayList<Integer>();
        row.add(root.val);
        toLeaf(root, rst, row);
        return rst;
    }

    void toLeaf(TreeNode node, List<List<Integer>> rst, List<Integer> row) {

        if (node.left == null || node.right == null) {
            List<Integer> cp = new ArrayList<Integer>(row);
            rst.add(cp);
            return;
        }
        if (node.left != null) {
            row.add(node.left.val);
            toLeaf(node.left, rst, row);
            row.remove(node.left);

        }

        if (node.right != null) {
            row.add(node.right.val);
            toLeaf(node.right, rst, row);
            row.remove(node.right);
        }
    }


    Compete getComplete(TreeNode root) {
        if (root == null) {
            return new Compete(true, -1, true);
        }

        Compete left = getComplete(root.left);
        Compete right = getComplete(root.right);
        if (!left.isComplete) {
            return new Compete(false, -1, false);
        }
        if (left.depth == right.depth) {
            if (left.isFull && right.isComplete) {

                return new Compete(true, left.depth + 1, right.isFull);
            } else {
                return new Compete(false, left.depth + 1, false);
            }
        } else if (left.depth - right.depth == 1) {
            if (left.isFull && right.isFull) {
                return new Compete(true, left.depth + 1, false);
            } else {
                return new Compete(false, -1, false);
            }
        } else {
            return new Compete(false, left.depth + 1, false);
        }

    }

    class Compete {
        boolean isComplete;
        int depth;
        boolean isFull;

        public Compete(boolean isComplete, int depth, boolean isFull) {
            this.isComplete = isComplete;
            this.depth = depth;
            this.isFull = isFull;
        }
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0 || inorder == null || inorder.length == 0) {
            return null;
        }

        Map<Integer, Integer> inorderMap = new HashMap<Integer, Integer>();

        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        return getNode(inorderMap, 0, inorder.length-1, preorder, 0, preorder.length-1);
    }

    TreeNode getNode(Map<Integer, Integer> inorderMap,  int inLef, int inRight, int[] preoder, int preLef, int preRight){
        if (preLef >=preRight && inLef>=inRight){
            return null;
        }
        TreeNode root = new TreeNode(preoder[preLef]);
        int rootIndex= inorderMap.get(preoder[preLef]);
        root.left= getNode(inorderMap, inLef, rootIndex-1,preoder, preLef+1,  preLef+rootIndex-inLef);
        root.right= getNode(inorderMap, rootIndex+1, inRight,preoder, preLef+rootIndex-inLef+1,  preRight);
        return root;
    }

}
