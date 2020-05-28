package stackQueue;

import java.util.Stack;

public class P232用栈实现队列 {
    class MyQueue {

        Stack<Integer> stack1;
        Stack<Integer> stack2;

        public MyQueue() {
            stack1 = new Stack<>();
            stack2 = new Stack<>();
        }

        // 存入数据都比较直接
        public void push(int x) {
            stack1.push(x);

        }

        public int pop() {
            if (stack2.isEmpty()){
                while (!stack1.isEmpty()){
                    stack2.push(stack1.pop());
                }
            }
            if (!stack2.isEmpty()){
                return stack2.pop();
            }
            throw new RuntimeException("队列里没有元素");
        }


        public int peek() {
            if (stack2.isEmpty()){
                while (!stack1.isEmpty()){
                    stack2.push(stack1.pop());
                }
            }
            if (!stack2.isEmpty()){
                return stack2.peek();
            }
            throw new RuntimeException("队列里没有元素");
        }

        public boolean empty() {
            return stack1.isEmpty() && stack2.isEmpty();
        }
    }

}
