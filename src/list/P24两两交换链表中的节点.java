package list;

public class P24两两交换链表中的节点 {
    public ListNode swapPairs(ListNode head) {
        // 递归实现
        if (head == null || head.next == null){
            return head;
        }
        ListNode next = head.next;
        // 交换两个相邻的结点
        head.next = swapPairs(next.next);
        next.next = head;
        return next;
    }
}
