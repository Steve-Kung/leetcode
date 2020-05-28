package tree;

import java.util.ArrayList;
import java.util.List;

public class P145二叉树的后序遍历 {
    public List<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        if (root == null){
            return res;
        }
        postorderTraversal(root, res);
        return res;
    }

    private void postorderTraversal(TreeNode root, ArrayList<Integer> res) {
        if (root == null){
            return;
        }
        postorderTraversal(root.left, res);
        postorderTraversal(root.right, res);
        res.add(root.val);
    }

}
