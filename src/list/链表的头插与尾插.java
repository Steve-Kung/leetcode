package list;

public class 链表的头插与尾插 {
    // 头插法
    public ListNode create1(ListNode head){
        ListNode newNode = new ListNode(0);
        newNode.next = head;
        head = newNode;
        return head;
    }
    // 尾插法
    // header永远存储第一个节点的地址，tailer永远存储最后一个节点的地址
    public ListNode create2(ListNode head, ListNode tailer){
        if (head == null){
            head = tailer = new ListNode(0);
        } else {
            ListNode newNode = new ListNode(1);
            tailer.next = newNode;
            tailer = newNode;
        }
        return head;
    }

    // 迭代法反转链表
    public ListNode reverse(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null){
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    // 迭代反转 上面的简化变量版
    public ListNode reverseList2(ListNode head) {
        ListNode newHead = new ListNode(-1);
        while (head != null) {
            ListNode next = head.next;
            head.next = newHead.next;
            newHead.next = head;
            head = next;
        }
        return newHead.next;
    }

    // 利用快慢指针，平分链表
    // 返回链表的中间节点属于前半段
    public ListNode halfList(ListNode head){
        ListNode fast = head;
        ListNode slow = head;
        if (fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    // 利用快慢指针，平分链表
    // 返回链表的中间节点属于后半段
    public ListNode halfList1(ListNode head){
        ListNode fast = head;
        ListNode slow = head;
        if (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    // 利用快慢指针，平分链表
    // 返回链表的中间节点属于后半段
    // 并将链表分成两半
    public ListNode halfList2(ListNode head){
        if(head == null){
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        ListNode pre = null;
        while (fast != null && fast.next != null){
            pre = slow;
            fast = fast.next.next;
            slow = slow.next;
        }
        if(pre != null){
            pre.next = null;
        }
        return slow;
    }
}
