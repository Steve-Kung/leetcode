package tree;

public class P226翻转二叉树 {
    // 先交换左右节点，再递归调用左子树和右子树
    public TreeNode invertTree(TreeNode root) {
        if (root == null){
            return null;
        }
        // 先交换左右节点
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        // 再递归调用左子树和右子树
        invertTree(root.left);
        invertTree(root.right);

        return root;
    }
}
