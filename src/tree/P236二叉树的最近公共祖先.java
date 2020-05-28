package tree;

public class P236二叉树的最近公共祖先 {
    // 从底向上 推算出最近公共祖先 因此采用后序遍历
    // 需要根据左右子树返回的值判断root改返回的值
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null){
            return null;
        }
        if (root.val == p.val || root.val == q.val){
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right =  lowestCommonAncestor(root.right, p, q);
        if (left == null){
            return right;
        }
        if (right == null){
            return left;
        }
        return root;
    }
}
