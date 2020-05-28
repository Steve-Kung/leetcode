package tree;

public class P104二叉树的最大深度 {
    // 二叉树的遍历 递归
    public int maxDepth(TreeNode root) {
        if (root == null){
            return 0;
        }else {
            int left = maxDepth(root.left);
            int right = maxDepth(root.right);
            return Math.max(left, right) + 1;
        }
    }
}
