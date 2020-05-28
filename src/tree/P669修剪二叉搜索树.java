package tree;

public class P669修剪二叉搜索树 {
    public TreeNode trimBST1(TreeNode root, int L, int R) {
        if (root == null){
            return null;
        }
        root.left = trimBST(root.left, L, R);
        root.right = trimBST(root.right, L, R);
        if (root.val < L || root.val > R){
            if (root.right != null){
                root = root.right;
            }
            else if (root.left != null){
                root = root.left;
            }
            else{
                root = null;
            }
        }
        return root;
    }

    /**
     * 当 node.val > R，
     * 那么修剪后的二叉树必定出现在节点的左边。

     类似地，当 node.val < L，
     那么修剪后的二叉树出现在节点的右边。

     否则，我们将会 修剪树的两边 。

     */

    public TreeNode trimBST(TreeNode root, int L, int R) {
        if (root == null) return root;
        if (root.val > R) return trimBST(root.left, L, R);
        if (root.val < L) return trimBST(root.right, L, R);

        root.left = trimBST(root.left, L, R);
        root.right = trimBST(root.right, L, R);
        return root;
    }

}
