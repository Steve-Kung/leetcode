package tree;

import java.util.ArrayList;

//给你一棵所有节点为非负值的二叉搜索树，
// 请你计算树中任意两节点的差的绝对值的最小值。
public class P530二叉搜索树的最小绝对差 {

    // 中序遍历
    // 相邻之间最小值
    public void inOrder(TreeNode root, ArrayList<Integer> list){
        if (root == null){
            return;
        }
        inOrder(root.left, list);
        list.add(root.val);
        inOrder(root.right, list);
    }
    public int getMinimumDifference1(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        inOrder(root, list);
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < list.size() - 1; i++) {
            int sub = Math.abs(list.get(i) - list.get(i+1));
            if (sub < res){
                res = sub;
            }
        }
        return res;
    }


    // 在中序遍历的过程中进行大小比较
    int minsub = Integer.MAX_VALUE;
    TreeNode pre = null;
    public void inOrder(TreeNode root){
        if (root == null){
            return;
        }
        inOrder(root.left);
        if (pre != null){
            minsub = Math.min(minsub, root.val - pre.val);
        }
        pre = root;
        inOrder(root.right);
    }
    public int getMinimumDifference(TreeNode root) {
        if (root == null){
            return 0;
        }
        inOrder(root);
        return minsub;
    }





}
