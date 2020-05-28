package list;

import java.util.ArrayList;

public class P234回文链表 {
    // 转换为数组，然后利用双指针进行回文判断
    public boolean isPalindrome1(ListNode head) {
        ArrayList<Integer> list = new ArrayList<>();
        while (head != null){
            list.add(head.val);
            head = head.next;
        }
        int len = list.size();
        int left = 0;
        int right = len - 1;
        while (left < right){
            if (!list.get(left).equals(list.get(right))){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
    // 计算链表节点的数量，然后遍历链表找到前半部分的尾节点
    // 先链表进行对半拆分，（注意奇偶区别）
    // 再反转后半链表，
    // 再进行相等比较
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null){
            return true;
        }
        // 先链表进行对半拆分，（注意奇偶区别）
        int len = 0;
        ListNode p1 = head;
        while (p1 != null){
            len++;
            p1 = p1.next;
        }
        int halfNum = len / 2;
        p1 = head;
        while (--halfNum > 0){
            p1 = p1.next;
        }
        ListNode p2 = p1.next;
        p1.next = null;
        // 再反转后半链表，
        ListNode node = reverse(p2);
        // 再进行相等比较
        // 因为前半段的长度会 小于等于 后半段的长度（在奇偶的情况下）
        // 所以以前半段为准即可
        while (head != null){
            if (head.val != node.val){
                return false;
            }
            head = head.next;
            node = node.next;
        }
        return true;
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

    public static void main(String[] args) {
        P234回文链表 p234回文链表 = new P234回文链表();
        ListNode head = new ListNode(1);
        head.next = new ListNode(0);
        head.next.next = new ListNode(1);
//        ListNode reverse = p234回文链表.reverse(head);
//        while (reverse != null){
//            System.out.print(reverse.val + " ");
//            reverse = reverse.next;
//        }
        boolean palindrome = p234回文链表.isPalindrome(head);
        System.out.println(palindrome);
    }
}
