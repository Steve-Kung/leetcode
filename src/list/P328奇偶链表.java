package list;

public class P328奇偶链表 {
    // 两倍速奇偶选择， 尾插法
    public ListNode oddEvenList(ListNode head) {
        if (head == null){
            return null;
        }
        ListNode cur = head;
        int x = 0;
        ListNode root = new ListNode(0);
        ListNode tailer = root;
        while (cur != null){
            ListNode node = new ListNode(cur.val);
            tailer.next = node;
            tailer = node;
            if (cur.next == null){
                break;
            }
            cur = cur.next.next;
        }
        cur = head.next;
        while (cur != null){
            ListNode node = new ListNode(cur.val);
            tailer.next = node;
            tailer = node;
            if (cur.next == null){
                break;
            }
            cur = cur.next.next;
        }
        return root.next;
    }
}
