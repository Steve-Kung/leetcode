package dp.integerBreak;
/*
给定一个正整数 n，将其拆分为至少两个正整数的和，
并使这些整数的乘积最大化。 返回你可以获得的最大乘积。

示例 1:

输入: 2
输出: 1
解释: 2 = 1 + 1, 1 × 1 = 1。

 */
public class P343整数拆分 {
    // 暴力解法
    public int integerBreak0(int n) {

        if (n <= 1){
            return 0;
        }
        int res = 0;
        for (int i = 1; i < n; i++){
            res = Math.max(res, Math.max(i * (n - i), i * integerBreak0(n - i)));
        }
        return res;
    }

    // 记忆化搜索-自顶向下
    int[] memory;

    public int integerBreak(int n) {
        memory = new int[n + 1];
        return integerBreakHelper(n);
    }

    public int integerBreakHelper(int n) {
        if (n == 2) {
            return 1;
        }
        // memory的初始值为0，如果它不为0，说明已经计算过了，直接返回即可
        if (memory[n] != 0) {
            return memory[n];
        }
        int res = -1;
        for (int i = 1; i <= n - 1; i++) {
            res = Math.max(res, Math.max(i * integerBreakHelper(n - i), i * (n - i)));
        }
        // 将每次计算的结果保存到备忘录数组中
        memory[n] = res;
        return res;
    }
}
