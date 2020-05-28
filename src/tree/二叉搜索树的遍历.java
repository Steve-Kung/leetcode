package tree;

import java.util.ArrayList;
import java.util.List;

public class 二叉搜索树的遍历 {
    public boolean order(TreeNode root, int target){
        if (root == null){
            return false;
        }
        if (root.val == target){
            return true;
        }
        else if (root.val > target){
            return order(root.left, target);
        } else {
            return order(root.right, target);
        }

    }

}
