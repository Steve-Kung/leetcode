package twopoint;
/*
给定一个非负整数 c ，你要判断是否存在两个整数 a 和 b，使得 a2 + b2 = c。

示例1:

输入: 5
输出: True
解释: 1 * 1 + 2 * 2 = 5
 */
public class P633平方数之和 {
    public boolean judgeSquareSum(int c) {
        int left = 0;
        int right = (int)Math.sqrt(c);
        while (left < right){
            int sum = left * left + right * right;
            if (sum > c){
                right--;
            }else if (sum < c){
                left++;
            } else {
                return true;
            }
        }
        return false;
    }
}
