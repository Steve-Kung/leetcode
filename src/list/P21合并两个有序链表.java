package list;

/**
 * 将两个升序链表合并为一个新的升序链表并返回。
 * 新链表是通过拼接给定的两个链表的所有节点组成的。
 */
public class P21合并两个有序链表 {
    // 比较大小然后尾插
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode header = null;
        ListNode tailer = null;
        while (l1 != null && l2 != null){
            if (l1.val <= l2.val){
                ListNode node = new ListNode(l1.val);
                if (header == null){
                    header = tailer = node;
                } else {
                    tailer.next = node;
                    tailer = node;
                }
                l1 = l1.next;
            }else {
                ListNode node = new ListNode(l2.val);
                if (header == null){
                    header = tailer = node;
                } else {
                    tailer.next = node;
                    tailer = node;
                }
                l2 = l2.next;
            }
        }
        if (l1 == null){
            while (l2 != null){
                ListNode node = new ListNode(l2.val);
                if (header == null){
                    header = tailer = node;
                } else {
                    tailer.next = node;
                    tailer = node;
                }
                l2 = l2.next;
            }
        }
        if (l2 == null){
            while (l1 != null){
                ListNode node = new ListNode(l1.val);
                if (header == null){
                    header = tailer = node;
                } else {
                    tailer.next = node;
                    tailer = node;
                }
                l1 = l1.next;
            }
        }
        return header;
    }

    // 递归解法
    // 每一层调用都返回排序好的链表头
    // 如果 l1 的 val 值更小，则将 l1.next 与排序好的链表头相接
    public ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
        if(l1 == null) {
            return l2;
        }
        if(l2 == null) {
            return l1;
        }

        if(l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }

    // 1.终止条件
    // 2.递归式
    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        if (l1 == null){
            return l2;
        }
        if (l2 == null){
            return l1;
        }
        if (l1.val < l2.val){
            l1.next = mergeTwoLists2(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists2(l1, l2.next);
            return l2;
        }

    }


}
