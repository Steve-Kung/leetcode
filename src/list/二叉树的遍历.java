package list;

public class 二叉树的遍历 {
    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val){
            this.val = val;
        }
    }
    public void preOrder(TreeNode root){
        while (root != null){
            System.out.println(root.val);
            preOrder(root.left);
            preOrder(root.right);
        }
    }
    public void inOrder(TreeNode root){
        while (root != null){
            inOrder(root.left);
            System.out.println(root.val);
            inOrder(root.right);
        }
    }

    public void postOrder(TreeNode root){
        while (root != null){
            postOrder(root.left);
            postOrder(root.right);
            System.out.println(root.val);
        }
    }
}
