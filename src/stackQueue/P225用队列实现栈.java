package stackQueue;

import java.util.LinkedList;
import java.util.Queue;

public class P225用队列实现栈 {
    class MyStack {

        // 用一个额外的变量来保存栈顶元素
        Queue<Integer> queue1;
        Queue<Integer> queue2;
        private int top;

        public MyStack() {
            queue1 = new LinkedList<>();
            queue2 = new LinkedList<>();
        }

        // 存入数据都比较直接
        public void push(int x) {
            queue1.offer(x);
            top = x;

        }

        // 通过把 q1 和 q2 互相交换的方式来避免把 q2 中的元素往 q1 中拷贝
        public int pop() {
            while (queue1.size() > 1){
                top = queue1.poll();
                queue2.offer(top);
            }
            int ans = queue1.poll();
            Queue<Integer> temp = queue1;
            queue1 = queue2;
            queue2 = temp;
            return ans;
        }

        // 栈顶元素被保存在 top 变量里，每次我们 压入 或者 弹出 一个元素的时候都会随之更新这个变量。
        public int top() {
            return top;
        }

        // q1 中存有 全部的数据
        public boolean empty() {
            return queue1.isEmpty();
        }
    }
}
