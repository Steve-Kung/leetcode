package stackQueue;

import java.util.Stack;

public class P155最小栈 {
    // 方法一：使用辅助栈
    class MinStack1 {
        Stack<Integer> stack;
        Stack<Integer> minStack;
        public MinStack1() {
            stack = new Stack<>();
            minStack = new Stack<>();
        }

        public void push(int x) {
            stack.push(x);
            if (minStack.isEmpty() || x <= minStack.peek()){
                minStack.push(x);
            }
        }

        public void pop() {
            int tmp = stack.pop();
            if (tmp == minStack.peek()){
                minStack.pop();
            }
        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            return minStack.peek();
        }
    }

    // 方法二：使用 Stack<Node>
    class MinStack2 {

        class Node{
            int val;
            int min;
            Node(int val, int min){
                this.val = val;
                this.min = min;
            }
        }
        Stack<Node> stack;
        public MinStack2() {
            stack = new Stack<>();
        }

        public void push(int x) {
            if (stack.isEmpty()){
                stack.push(new Node(x, x));
            } else {
                stack.push(new Node(x, Math.min(x, stack.peek().min)));
            }
        }

        public void pop() {
            stack.pop();
        }

        public int top() {
            return stack.peek().val;
        }

        public int getMin() {
            return stack.peek().min;
        }
    }
    // 方法三：自定义 Stack
    class MinStack {

        class Node{
            int val;
            int min;
            Node next;
            Node(int val, int min, Node next){
                this.val = val;
                this.min = min;
                this.next = next;
            }
            Node(int val, int min){
                this(val, min, null);
            }
        }

        Node head;

        public MinStack() {
        }

        // 新建节点插入链表头部，作为新的头节点，存储当前的元素值和最小值，并且指向之前的头节点。
        public void push(int x) {
            if (head == null){
                head = new Node(x,x);
            } else {
                head = new Node(x, Math.min(x, head.min), head);
            }
        }

        public void pop() {
            head = head.next;
        }

        public int top() {
            return head.val;
        }

        public int getMin() {
            return head.min;
        }
    }
}
