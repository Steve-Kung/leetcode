package list;

public class P19删除链表的倒数第N个节点 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = head;
        // 快指针先抢跑
        // 先抢跑n步，最后慢指针指向了倒数第n个的前一个
        while (n-- > 0){
            fast = fast.next;
        }
        if (fast == null){
            return head.next;
        }

        // 慢指针
        ListNode slow = head;
        // 快指针已经指向了最后一个
        while (fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }
        // 根据倒数第n个的前一个 来删除 倒数第n个
        slow.next = slow.next.next;
        return head;
    }
}
