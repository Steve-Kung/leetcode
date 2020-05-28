package list;

import java.util.ArrayList;
import java.util.Stack;

public class 从尾到头打印链表 {

    class ListNode {
        int val;
        ListNode next = null;

        public ListNode(int val){
            this.val = val;
        }
    }
    public static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        Stack<Integer> stack = new Stack<>();
        while (listNode != null){
            stack.push(listNode.val);
            listNode = listNode.next;
        }
        ArrayList<Integer> ans = new ArrayList<Integer>();
        while(!stack.isEmpty()){
            ans.add(stack.pop());
        }
        return ans;
    }

}
