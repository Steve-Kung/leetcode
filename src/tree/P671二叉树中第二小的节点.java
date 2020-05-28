package tree;

public class P671二叉树中第二小的节点 {
    public int findSecondMinimumValue(TreeNode root) {
        if (root == null){
            return -1;
        }
        if (root.left == null && root.right == null){
            return -1;
        }

        int left = root.left.val;
        int right = root.right.val;

        if (left == root.val){
            left = findSecondMinimumValue(root.left);
        }
        if (right == root.val){
            right = findSecondMinimumValue(root.right);
        }

        if (left != -1 && right != -1){
            return Math.min(left , right);
        }
        if (left == -1){
            return right;
        }
        else {
            return left;
        }

    }

    public int findSecondMinimumValue1(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return -1;
        }

        int left = root.left.val;
        int right = root.right.val;

        if (left == root.val) {
            left = findSecondMinimumValue(root.left);
        }

        if (right == root.val) {
            right = findSecondMinimumValue(root.right);
        }

        if (left != -1 && right != -1) {
            return Math.min(left, right);
        }
        if (left != -1) {
            return left;
        }
        return right;

    }
}
