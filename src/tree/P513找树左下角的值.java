package tree;

import java.util.LinkedList;
import java.util.Queue;

public class P513找树左下角的值 {
    // 层序 的最后一行的第一个
    public int findBottomLeftValue(TreeNode root) {
        int left = 0;
        if (root == null){
            return left;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (i == 0){
                    left = node.val;
                }
                if (node.left != null){
                    queue.offer(node.left);
                }
                if (node.right != null){
                    queue.offer(node.right);
                }
            }
        }
        return left;
    }
}
