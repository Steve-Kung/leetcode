package tree;

import java.util.ArrayList;

/**
 * 给定一个二叉树，检查它是否是镜像对称的。
 */
public class P101对称二叉树 {

    // 对称二叉树 它的中序遍历得到的数组是一个对称数组
    public boolean isSymmetric1(TreeNode root) {
        ArrayList<Integer> list = inOrder(root);
        int left = 0;
        int right = list.size() -1;
        while (left < right){
            if (!list.get(left).equals(list.get(right))){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
    // 二叉树的中序遍历
    ArrayList<Integer> list = new ArrayList<>();
    public ArrayList<Integer> inOrder(TreeNode root){
        if (root == null){
            list.add(Integer.MAX_VALUE);
            return list;
        }
        inOrder(root.left);
        list.add(root.val);
        inOrder(root.right);
        return list;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.right = new TreeNode(3);
        root.right.right = new TreeNode(3);

        P101对称二叉树 p101对称二叉树 = new P101对称二叉树();
        boolean symmetric = p101对称二叉树.isSymmetric1(root);
        System.out.println(symmetric);

        ArrayList<Integer> list = p101对称二叉树.inOrder(root);
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
    }

    // 递归实现 这个递归的方向是按树的对称方向走的
    public boolean isSymmetric(TreeNode left, TreeNode right) {
        if (left == null && right == null){
            return true;
        }
        if (left == null || right == null){
            return false;
        }
        if (left.val != right.val){
            return false;
        }
        return isSymmetric(left.right,right.left) && isSymmetric(left.left, right.right);
    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null){
            return true;
        }
        // 把一棵树镜像对称转换为两颗树镜像对称
        return isSymmetric(root.left, root.right);
    }
}
