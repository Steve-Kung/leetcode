package list;

import java.util.Stack;

public class P445两数相加II {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        while (l1 != null){
            stack1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null){
            stack2.push(l2.val);
            l2 = l2.next;
        }
        int carry = 0;
        ListNode head = null;
        while (!stack1.isEmpty() || !stack2.isEmpty() || carry != 0){
            int p1 = 0;
            int p2 = 0;
            if (!stack1.isEmpty()){
                p1 = stack1.pop();
            }
            if (!stack2.isEmpty()){
                p2 = stack2.pop();
            }
            int sum = p1 + p2 + carry;
            int res = sum%10;
            carry = sum/10;
            // 头插法反转顺序
            ListNode node = new ListNode(res);
            node.next = head;
            head = node;
        }
        return head;
    }
}
