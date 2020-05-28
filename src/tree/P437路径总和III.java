package tree;

/**
 * 给定一个二叉树，它的每个结点都存放着一个整数值。

 找出路径和等于给定数值的路径总数。

 路径不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。

 二叉树不超过1000个节点，且节点数值范围是 [-1000000,1000000] 的整数。

 */
public class P437路径总和III {
    int res = 0;
    public int pathSum(TreeNode root, int sum) {
        if (root == null){
            return 0;
        }
        pathSumHelper(root, sum);
        // 以根节点的左右子树的根节点为起点，计算可能的路径数
        // 第一层二叉树的遍历
        pathSum(root.left, sum);
        pathSum(root.right, sum);
        return res;
    }

    // 以根节点为起始点，计算可能的路径数
    private void pathSumHelper(TreeNode root, int sum) {
        if (root == null){
            return;
        }
        if (root.val == sum){
            res++;
//            注意这里不能立即返回，因为后面可能会加上一个为0的等式
//            return;
        }
        // 第二层二叉树的遍历
        pathSumHelper(root.left, sum - root.val);
        pathSumHelper(root.right, sum - root.val);
    }


    // 参考题解
    /*
     public int pathSum(TreeNode root, int sum) {
        if(root == null){
            return 0;
        }
        int result = countPath(root,sum);
        int a = pathSum(root.left,sum);
        int b = pathSum(root.right,sum);
        return result+a+b;

    }
    public int countPath(TreeNode root,int sum){
        if(root == null){
            return 0;
        }
        sum = sum - root.val;
        int result = sum == 0 ? 1:0;
        return result + countPath(root.left,sum) + countPath(root.right,sum);
    }
     */

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(-2);
        root.right = new TreeNode(-3);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.right = new TreeNode(-2);
        root.left.left.right = new TreeNode(-1);
        P437路径总和III p437路径总和III = new P437路径总和III();
        int i = p437路径总和III.pathSum(root, -1);
        System.out.println(i);
    }

}
