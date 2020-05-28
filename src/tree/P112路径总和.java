package tree;

/**
 * 给定一个二叉树和一个目标和，
 * 判断该树中是否存在根节点到叶子节点的路径，
 * 这条路径上所有节点值相加等于目标和。
 */

// 因为递归终止条件不一致，所以制造了一个辅助函数
// 递归的时候需要区分左右子树是否都存在的情况，分情况讨论;
public class P112路径总和 {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null){
            return false;
        }
        return hasPathSumHelper(root, sum);

    }

    private boolean hasPathSumHelper(TreeNode root, int sum) {
        if (root == null){
            return sum == 0;
        }
        if (root.left == null && root.right == null){
            return root.val == sum;
        }
        else if (root.left == null){
            return hasPathSumHelper(root.right, sum - root.val);
        }
        else if (root.right == null){
            return hasPathSumHelper(root.left, sum - root.val);
        }
        else {
            return hasPathSumHelper(root.left, sum - root.val) || hasPathSumHelper(root.right, sum - root.val);
        }
    }
}
