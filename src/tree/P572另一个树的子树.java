package tree;

/**
 * 给定两个非空二叉树 s 和 t，检验 s 中是否包含和 t 具有相同结构和节点值的子树。
 * s 的一个子树包括 s 的一个节点和这个节点的所有子孙。s 也可以看做它自身的一棵子树。
 */
public class P572另一个树的子树 {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null){
            return false;
        }
        boolean res1 = isSameTree(s, t);
        boolean res2 = isSubtree(s.left, t);
        boolean res3 = isSubtree(s.right, t);
        return res1 || res2 || res3;
    }

    // 判断两棵树是否相等
    public boolean isSameTree(TreeNode root1, TreeNode root2){
        if (root1 == null && root2 == null){
            return true;
        }
        if (root1 == null || root2 == null){
            return false;
        }
        if (root1.val != root2.val){
            return false;
        }
        return isSameTree(root1.left, root2.left)&& isSameTree(root1.right, root2.right);
    }


}
