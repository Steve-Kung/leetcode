package stackQueue;

import java.util.Stack;

public class P739每日温度 {
    //  递减栈。入栈的都是比栈顶小的  从前往后
    public int[] dailyTemperatures1(int[] T) {
        int size = T.length;
        int[] res = new int[size];
        // 递减栈。入栈的都是比栈顶小的
        Stack<Integer> stack = new Stack<>();

        for (int i= 0; i < size; i++){
            while (!stack.isEmpty() && T[i] > T[stack.peek()]){
                int pre = stack.pop();
                res[pre] = i - pre;
            }
            stack.push(i);
        }
        return res;
    }

    //  单调栈。从后往前
    public int[] dailyTemperatures(int[] T) {
        int len = T.length;
        int[] res= new int[len];
        Stack<Integer> stack = new Stack<>(); // 这里放元素索引，而不是元素
        for (int i = len - 1; i >= 0; i--){
            while (!stack.isEmpty() && T[stack.peek()] <= T[i]){
                stack.pop();
            }
            res[i] = stack.isEmpty() ? 0 : (stack.peek() - i); // 得到索引间距
            stack.push(i); // 加入索引，而不是元素
        }
        return res;
    }


    public static void main(String[] args) {
        P739每日温度 p739每日温度 = new P739每日温度();
        int[] t = {73, 74, 75, 71, 69, 72, 76, 73};
        int[] ints = p739每日温度.dailyTemperatures(t);
        for (int i : ints) {
            System.out.print(i + " ");
        }
    }
}
