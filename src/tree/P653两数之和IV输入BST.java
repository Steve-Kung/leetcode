package tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/**
 * 给定一个二叉搜索树和一个目标结果，
 * 如果 BST 中存在两个元素且它们的和等于给定的目标结果，则返回 true。
 */
public class P653两数之和IV输入BST {
    // 1. hashset 方法
    // 先遍历数组，放入hashset
    public void inOrder(TreeNode root, HashSet<Integer> set){
        if (root == null){
            return;
        }
        inOrder(root.left, set);
        set.add(root.val);
        inOrder(root.right, set);
    }
    public boolean findTarget1(TreeNode root, int k) {
        if (root == null){
            return false;
        }
        HashSet<Integer> set = new HashSet<>();
        inOrder(root, set);
        for (Integer sub : set) {
            if (set.contains(k - sub) && (k-sub)!=(sub)){
                return true;
            }
        }
        return false;
    }
    // 2. 双指针法
    // 中序遍历 从小到大 放入链表 再双指针移动
    public void inOrder(TreeNode root, ArrayList<Integer> list){
        if (root == null){
            return;
        }
        inOrder(root.left, list);
        list.add(root.val);
        inOrder(root.right, list);
    }
    public boolean findTarget2(TreeNode root, int k) {
        if (root == null){
            return false;
        }
        ArrayList<Integer> list = new ArrayList<>();
        inOrder(root, list);

        int left = 0;
        int right = list.size() - 1;
        while (left < right){
            int sum = list.get(left) + list.get(right);
            if ( sum > k ){
                right--;
            } else if (sum < k){
                left++;
            } else {
                return true;
            }
        }
        return false;
    }
    // 3. BST查找法
    // 查找是否存在指定节点
    public TreeNode findTreeNode(TreeNode root, int target){
        if (root == null){
            return null;
        }
        if (root.val == target){
            return root;
        }
        if (root.val < target){
            return findTreeNode(root.right, target);
        }
        else {
            return findTreeNode(root.left, target);
        }
    }

    public boolean preOrder(TreeNode root, TreeNode node, int target){
        if (root == null){
            return false;
        }
        TreeNode treeNode = findTreeNode(node, target - root.val);
        if (treeNode != null && treeNode != root){
            return true;
        }
        return preOrder(root.left, node, target) || preOrder(root.right, node, target);
    }

    // 前序遍历
    public boolean findTarget(TreeNode root, int k) {
        if (root == null){
            return false;
        }
        return preOrder(root, root, k);
    }
}
