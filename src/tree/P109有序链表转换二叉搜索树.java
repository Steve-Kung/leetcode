package tree;

public class P109有序链表转换二叉搜索树 {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null){
            return null;
        }
        ListNode half = halfList(head);
        TreeNode root = new TreeNode(half.val);
        // 当最后只有一个节点的时候
        if (half == head){
            return root;
        }
        ListNode halfNext = half.next;
        root.left = sortedListToBST(head);
        root.right = sortedListToBST(halfNext);
        return root;
    }

    // 通过快慢指针找到链表的中间值
    public ListNode halfList(ListNode head){
        if (head == null){
            return null;
        }
        ListNode pre = null;
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null){
            pre = slow; // 记录slow的前一个节点为pre
            fast = fast.next.next;
            slow = slow.next;
        }
        if (pre != null){
            pre.next = null;
        }
        return slow;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(-10);
        head.next = new ListNode(-3);
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(5);
        head.next.next.next.next = new ListNode(9);
        P109有序链表转换二叉搜索树 p109有序链表转换二叉搜索树 = new P109有序链表转换二叉搜索树();
//        ListNode listNode = p109有序链表转换二叉搜索树.halfList(head);
//        System.out.println(listNode.val);
        TreeNode treeNode = p109有序链表转换二叉搜索树.sortedListToBST(head);
        System.out.println(treeNode.val);
    }

}
