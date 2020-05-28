package tree;

/**
 * 给定一棵二叉树，你需要计算它的直径长度。
 * 一棵二叉树的直径长度是任意两个结点路径长度中的最大值。
 * 这条路径可能穿过也可能不穿过根结点。
 */
public class P543二叉树的直径 {
    // 要求每个节点的左子树和右子树的高度和
    static int maxDiameter = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null){
            return 0;
        }
        maxDepth(root);
        return maxDiameter;

    }

    private int maxDepth(TreeNode root) {
        if (root == null){
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);

        maxDiameter = Math.max(left + right, maxDiameter);

        return Math.max(left , right) + 1;
    }

    public static void main(String[] args) {
        P543二叉树的直径 p543二叉树的直径 = new P543二叉树的直径();
        TreeNode root = new TreeNode(1);
        int i = p543二叉树的直径.diameterOfBinaryTree(root);
        System.out.println(i);
    }

}
