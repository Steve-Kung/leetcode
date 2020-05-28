package tree;

import java.util.Arrays;

public class P105从前序与中序遍历序列构造二叉树 {
    // 拷贝数组 这时候的mid索引，上下两个数组可以相等
    public TreeNode buildTree1(int[] preorder, int[] inorder) {
        int len = inorder.length;
        if (len == 0){
            return null;
        }
        // 根据前序找到根节点
        TreeNode root = new TreeNode(preorder[0]);
        // 遍历中序找到左右两边的子树。
        // 再进行递归
        int mid = 0;
        for (int i = 0; i < len; i++) {
            if (root.val == inorder[i]){
                mid = i;
            }
        }
        root.left = buildTree(Arrays.copyOfRange(preorder, 1, mid+1), Arrays.copyOfRange(inorder, 0, mid));
        root.right = buildTree(Arrays.copyOfRange(preorder, mid + 1, len), Arrays.copyOfRange(inorder, mid + 1, len));
        return root;
    }

    // 传递数组 这时候的mid索引，上下两个数组错位了！！！
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int preStart =0;
        int preEnd = preorder.length;
        int inStart = 0;
        int inEnd = inorder.length;
        return buildTree(preorder,preStart, preEnd, inorder, inStart, inEnd);
    }

    private TreeNode buildTree(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
        if (preStart == preEnd){
            return null;
        }
        TreeNode root = new TreeNode(preorder[preStart]);
        int mid = 0;
        for (int i = inStart; i < inEnd; i++) {
            if (root.val == inorder[i]){
                mid = i;
                break;
            }
        }

        root.left = buildTree(preorder, preStart + 1, mid-inStart+preStart+1, inorder, inStart, mid);
        root.right = buildTree(preorder, preEnd+mid+1-inEnd, preEnd, inorder, mid + 1, inEnd);
        return root;
    }

    public static void main(String[] args) {
        P105从前序与中序遍历序列构造二叉树 p105从前序与中序遍历序列构造二叉树 = new P105从前序与中序遍历序列构造二叉树();
        int[] preOrder = {3,9,20,15,7};
        int[] inOrder = {9,3,15,20,7};
        TreeNode treeNode = p105从前序与中序遍历序列构造二叉树.buildTree(preOrder, inOrder);
        System.out.println(treeNode);
    }

}
