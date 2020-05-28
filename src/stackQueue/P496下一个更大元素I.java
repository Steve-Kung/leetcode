package stackQueue;
/*
输入: nums1 = [4,1,2], nums2 = [1,3,4,2].
输出: [-1,3,-1]
解释:
    对于num1中的数字4，你无法在第二个数组中找到下一个更大的数字，因此输出 -1。
    对于num1中的数字1，第二个数组中数字1右边的下一个较大数字是 3。
    对于num1中的数字2，第二个数组中没有下一个更大的数字，因此输出 -1。
 */

import java.util.HashMap;
import java.util.Stack;

/**
 * 单调栈 解决  Next Greater Number 一类问题
  */

public class P496下一个更大元素I {
    // 重后往前 的 单调栈 解决 下一个更大元素 问题
    public int[] nextGreaterElement(int[] nums) {
        int length = nums.length;
        int[] res = new int[length];
        Stack<Integer> stack = new Stack<>();
        for (int i = length - 1; i >= 0; i--){ // 倒着往栈里放
            while (!stack.isEmpty() && stack.peek() <= nums[i]){ // 判定个子高矮
                stack.pop(); // 矮个起开，反正也被挡着了。。。
            }
            res[i] = stack.isEmpty() ? -1 : stack.peek(); // 这个元素身后的第一个高个
            stack.push(nums[i]); // 每个元素从后往前都得接受检验,消除中间小的和等于的数据
        }
        return res;
    }
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int len1 =nums1.length;
        int len2 = nums2.length;
        int[] subRes = nextGreaterElement(nums2);
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < len2; i++) {
            map.put(nums2[i], subRes[i]);
        }
        int[] res = new int[len1];
        for (int i = 0; i < len1; i++) {
            res[i] = map.get(nums1[i]);
        }
        return res;
    }



}
