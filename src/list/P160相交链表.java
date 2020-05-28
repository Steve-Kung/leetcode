package list;

public class P160相交链表 {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x){
            val = x;
            next = null;
        }
    }

    // a+c+b = b+c+a
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null)
            return null;
        // 标记两个链表头，方便跳转
        ListNode p1 = headA;
        ListNode p2 = headB;
        while (p1 != p2){
            p1 = (p1 != null) ?  p1.next : headB;
            p2 = (p2 != null) ? p2.next : headA;
        }
        // 相等即为相交点
        // 如果不相交的话，最终也都会停在都为null的时候，也可以直接返回
        return p1;
    }
}
