package tree;

import java.util.ArrayList;

public class P501二叉搜索树中的众数 {
    int curTimes = 0;
    int maxTimes = 0;
    TreeNode pre = null;
    ArrayList<Integer> res = new ArrayList<>();
    public int[] findMode(TreeNode root) {
        if (root == null){
            return new int[0];
        }
        inOrder(root);
        int size = res.size();
        int[] ans = new int[size];
        for (int i = 0; i < size; i++) {
            ans[i] = res.get(i);
        }
        return ans;
    }

    public void inOrder(TreeNode root){
        if (root == null){
            return;
        }
        inOrder(root.left);
        if (pre != null && pre.val == root.val){
            curTimes++;
        }else {
            curTimes = 1;
        }
        if (curTimes == maxTimes){
            res.add(root.val);
        }
        if (curTimes > maxTimes){
            res.clear();
            res.add(root.val);
            maxTimes = curTimes;
        }
        pre = root;
        inOrder(root.right);
    }
}
