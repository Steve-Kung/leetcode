package list;

/**
 * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
 */
public class P83删除排序链表中的重复元素 {
    public static ListNode deleteDuplicates1(ListNode head) {
        if (head == null){
            return null;
        }
        ListNode p1 = head;
        while (p1 != null && p1.next != null){
            if (p1.val == p1.next.val){
                p1.next = p1.next.next;
            }else {
                p1 = p1.next;
            }

        }
        return head;
    }

    public static ListNode deleteDuplicates(ListNode head) {
        ListNode p1 = head;
        // 递归终止条件
        if (p1 == null || p1.next == null){
            return p1;
        }
        // 递归式
        if (p1.val == p1.next.val){
            p1.next = deleteDuplicates(p1.next);
            return p1.next;
        } else {
            p1.next = deleteDuplicates(p1.next);
            return p1;
        }

    }

    // 返回值都是没有重复元素的排序列表的头结点。

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode p2 = new ListNode(1);
        ListNode p3 = new ListNode(1);
        head.next = p2;
        p2.next = p3;
        ListNode node = deleteDuplicates(head);
        while (node != null){
            System.out.println(node.val);
            node = node.next;
        }
    }
}
