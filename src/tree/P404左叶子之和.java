package tree;

public class P404左叶子之和 {
    int sum = 0;
    public int sumOfLeftLeaves1(TreeNode root) {
        if (root == null){
            return 0;
        }
        if (root.left != null){
            if (root.left.left == null && root.left.right == null){
                sum = sum + root.left.val;
            }
        }
        sumOfLeftLeaves(root.left);
        sumOfLeftLeaves(root.right);
        return sum;
    }

    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null){
            return 0;
        }
        int sum = 0;
        if (root.left != null){
            if (root.left.left == null && root.left.right == null){
                sum = sum + root.left.val;
            }
        }
        return sum + sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        P404左叶子之和 p404左叶子之和 = new P404左叶子之和();
        int i = p404左叶子之和.sumOfLeftLeaves(root);
        System.out.println(i);
    }
}
