package tree;

import java.util.HashMap;

public class P337打家劫舍III {
    // 递归 非动态规划
    public int rob1(TreeNode root) {
        if (root == null){
            return 0;
        }
        int money = root.val;
        if (root.left != null){
            money += (rob(root.left.left) + rob(root.left.right));
        }
        if (root.right != null){
            money += (rob(root.right.left) + rob(root.right.right));
        }

        return Math.max(money, (rob(root.left) + rob(root.right)));
    }

    // 递归 动态规划
    public int rob2(TreeNode root) {
        HashMap<TreeNode, Integer> memo = new HashMap<>();
        return rob(root, memo);
    }

    private int rob(TreeNode root, HashMap<TreeNode, Integer> memo) {
        if (root == null){
            return 0;
        }
        if (memo.containsKey(root)){
            return memo.get(root);
        }
        int money = root.val;
        if (root.left != null){
            money += (rob(root.left.left, memo) + rob(root.left.right, memo));
        }
        if (root.right != null){
            money += (rob(root.right.left, memo) + rob(root.right.right, memo));
        }

        int result = Math.max(money, (rob(root.left, memo) + rob(root.right, memo)));
        memo.put(root, result);
        return result;
    }

    // 使用一个大小为 2 的数组来表示 int[] res = new int[2] 0 代表不偷，1 代表偷
    /*
    任何一个节点能偷到的最大钱的状态可以定义为

当前节点选择不偷：当前节点能偷到的最大钱数 = 左孩子能偷到的钱 + 右孩子能偷到的钱
当前节点选择偷：当前节点能偷到的最大钱数 = 左孩子选择自己不偷时能得到的钱 + 右孩子选择不偷时能得到的钱 + 当前节点的钱数
     */
    public int rob(TreeNode root) {
        if (root == null){
            return 0;
        }
        int[] result = robInter(root);
        return Math.max(result[0], result[1]);
    }

    private int[] robInter(TreeNode root) {
        int[] result = new int[2];
        if (root == null){
            return result;
        }
        int[] left = robInter(root.left);
        int[] right = robInter(root.right);

        result[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        result[1] = root.val + left[0] + right[0];

        return result;
    }

}
