package tree;

public class P617合并二叉树 {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null || t2 == null){
            return (t1 == null)?t2:t1;
        }
        // 遍历二叉树
        return dfs(t1, t2);

    }

    private TreeNode dfs(TreeNode t1, TreeNode t2) {
        if (t1 == null || t2 == null){
            return (t1 == null) ? t2 : t1;
        }
        t1.val = t1.val + t2.val;
        t1.left = dfs(t1.left, t2.left);
        t1.right = dfs(t1.right, t2.right);
        return t1;
    }
}
