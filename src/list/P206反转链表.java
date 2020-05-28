package list;

import java.util.ArrayList;
import java.util.Stack;

public class P206反转链表 {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x){
            val = x;
            next = null;
        }
    }
    // 利用栈结构 链表尾插 或者 新建链表进行头插
    // 尾插
    public ListNode reverseList(ListNode head) {
        ListNode p1 = head;
        Stack<Integer> stack = new Stack<>();
        while (p1 != null){
            stack.push(p1.val);
            p1 = p1.next;
        }
        ListNode header = null;
        ListNode tailer = null;
        while (!stack.isEmpty()){
            ListNode node = new ListNode(stack.pop());
            if (header == null){
                header = tailer = node;
            } else {
                tailer.next = node;
                tailer = node;
            }
        }
        return header;
    }

    // 头插
    public ListNode reverseList1(ListNode head) {
        ListNode p1 = head;
        ListNode header = null;
        while (p1 != null){
            // 这里的node必须是新建的ListNode
            ListNode node = new ListNode(p1.val);
            if (header == null){
                header = node;
            } else {
                node.next = header;
                header = node;
            }
            p1 = p1.next;
        }
        return header;
    }

    // 迭代反转
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
}
