package tree;

public class P687最长同值路径 {

    /*
    最长的路径可能有三种情况：
1.在左子树内部
2.在右子树内部
3.在穿过左子树，根节点，右子树的一条路径中

设计一个递归函数，返回以该节点为根节点，向下走的最长同值路径
知道这个值以后
以某个节点为根节点的最长同值路径就是，
如果该节点的值等于其左子树的值，则最长同值路径要加上左子树的最长同值路径，如果不等，左子树的路径为0
如果该节点的值等于其右子树的值，则最长同值路径要加上右子树的最长同值路径，如果不等，右子树的路径为0
我们用一个全局变量记录这个最大值，不断更新
     */

    int res = 0;
    public int longestUnivaluePath(TreeNode root) {
        helper(root);
        return res;
    }

    // 后序遍历模板
    int helper(TreeNode root){
        if(root == null) return 0;

        int left = helper(root.left);
        int right = helper(root.right);

        left = (root.left != null && root.left.val == root.val) ? left + 1 : 0;
        right = (root.right != null && root.right.val == root.val) ? right + 1 : 0;

        res = Math.max(res, left + right);
        return Math.max(left, right);
    }
}
