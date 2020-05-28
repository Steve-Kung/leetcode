package tree;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 二叉树遍历 {
    // 层序遍历
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null){
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            LinkedList<Integer> tmp = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                tmp.add(node.val);
                if (node.left != null){
                    queue.offer(node.left);
                }
                if (node.right != null){
                    queue.offer(node.right);
                }
            }
            res.add(tmp);
        }
        return res;
    }

    // 前序遍历
    public List<Integer> preOrder(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        preOrder(root, res);
        return res;
    }

    private void preOrder(TreeNode root, List<Integer> res) {
        if (root == null){
            return ;
        }
        res.add(root.val);
        preOrder(root.left, res);
        preOrder(root.right, res);
    }

    // 中序遍历
    public List<Integer> inOrder1(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inOrder(root, res);
        return res;
    }

    private void inOrder(TreeNode root, List<Integer> res) {
        if (root == null){
            return ;
        }
        inOrder(root.left, res);
        res.add(root.val);
        inOrder(root.right, res);
    }

    // 后序遍历
    public List<Integer> postOrder(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        postOrder(root, res);
        return res;
    }

    private void postOrder(TreeNode root, List<Integer> res) {
        if (root == null){
            return;
        }
        postOrder(root.left,res);
        postOrder(root.right,res);
        res.add(root.val);
    }


    //
    // 在中序遍历的过程中进行大小比较
    int minsub = Integer.MAX_VALUE;
    TreeNode pre = null;
    public void inOrder(TreeNode root){
        if (root == null){
            return;
        }
        inOrder(root.left);
        if (pre != null){
            minsub = Math.min(minsub, root.val - pre.val);
        }
        // 用pre节点记录前一个遍历的节点, 方便与现在节点比较
        pre = root;
        inOrder(root.right);
    }
    public int getMinimumDifference(TreeNode root) {
        if (root == null){
            return 0;
        }
        inOrder(root);
        return minsub;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        二叉树遍历 hello = new 二叉树遍历();
//        List<List<Integer>> lists = hello.levelOrder(root);
//        for (List<Integer> list : lists) {
//            for (Integer li : list) {
//                System.out.print(li + " ");
//            }
//            System.out.println();
//        }

        List<Integer> list = hello.postOrder(root);
        for (Integer integer : list) {
            System.out.print(integer + " ");
        }

    }


}
