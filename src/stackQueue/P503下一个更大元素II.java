package stackQueue;

import java.util.Stack;

/*
输入: [1,2,1]
输出: [2,-1,2]
解释: 第一个 1 的下一个更大的数是 2；
数字 2 找不到下一个更大的数；
第二个 1 的下一个最大的数需要循环搜索，结果也是 2。

 */
// 一般是通过 % 运算符求模（余数），获得环形特效
// 将原始数组 “翻倍”，就是在后面再接一个原始数组，
// 这样的话，按照之前“比身高”的流程，每个元素不仅可以比较自己右边的元素，
// 而且也可以和左边的元素比较了。
public class P503下一个更大元素II {

    public int[] nextGreaterElements(int[] nums) {
        int len = nums.length;
        int[] res = new int[len];
        Stack<Integer> stack = new Stack<>();
        // 假装这个数组长度翻倍了
        for (int i = 2 * len -1 ; i>=0; i--){
            while (!stack.isEmpty() && nums[i % len] >= stack.peek()){
                stack.pop();
            }
            res[i % len] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(nums[i % len]);
        }
        return res;
    }
}
