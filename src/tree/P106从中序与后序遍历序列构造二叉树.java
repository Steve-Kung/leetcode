package tree;

public class P106从中序与后序遍历序列构造二叉树 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int inStart = 0;
        int inEnd = inorder.length;
        int postStart = 0;
        int postEnd = postorder.length;
        return buildTree(inorder, inStart, inEnd, postorder, postStart, postEnd);
    }

    private TreeNode buildTree(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd) {
        if (inStart == inEnd){
            return null;
        }
        TreeNode root = new TreeNode(postorder[postEnd - 1]);
        int mid = 0;
        for (int i = inStart; i < inEnd; i++) {
            if (inorder[i] == root.val){
                mid = i;
                break;
            }
        }
        root.left = buildTree(inorder, inStart, mid, postorder, postStart, postStart + mid-inStart);
        root.right = buildTree(inorder, mid +1, inEnd, postorder, mid-inEnd+postEnd,postEnd-1);
        return root;
    }
}
