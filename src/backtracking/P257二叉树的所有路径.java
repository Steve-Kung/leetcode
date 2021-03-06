package backtracking;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/*
给定一个二叉树，返回所有从根节点到叶子节点的路径。
说明: 叶子节点是指没有子节点的节点。
示例:
输入:

   1
 /   \
2     3
 \
  5

输出: ["1->2->5", "1->3"]
解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3

 */
public class P257二叉树的所有路径 {
    List<String> res = new ArrayList<>();
    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null){
            return res;
        }
        Deque<String> track = new ArrayDeque<>();
        backtrack(root, track);
        return res;
    }

    private void backtrack(TreeNode root, Deque<String> track) {
        if (root == null){
            return;
        }

        // 做出选择
        track.addLast(String.valueOf(root.val));

        if (root.left == null && root.right == null){
            res.add(String.join("->", track));
        }
        backtrack(root.left, track);
        backtrack(root.right,track);
        track.removeLast();

    }
}
