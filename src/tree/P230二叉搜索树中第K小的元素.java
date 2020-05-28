package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个二叉搜索树，编写一个函数 kthSmallest 来查找其中第 k 个最小的元素。
 */
public class P230二叉搜索树中第K小的元素 {
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> list = inOrder(root);
        return list.get(k-1);

    }

    public List<Integer> inOrder(TreeNode root){
        ArrayList<Integer> res = new ArrayList<>();
        if (root == null){
            return res;
        }
        inOrder(root, res);
        return res;
    }

    private void inOrder(TreeNode root, ArrayList<Integer> res) {
        if (root == null){
            return;
        }
        inOrder(root.left, res);
        res.add(root.val);
        inOrder(root.right, res);
    }
}
