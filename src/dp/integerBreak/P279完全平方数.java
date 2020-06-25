package dp.integerBreak;
/*
给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。
你需要让组成和的完全平方数的个数最少。

示例 1:

输入: n = 12
输出: 3
解释: 12 = 4 + 4 + 4.

 */
public class P279完全平方数 {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        for (int i = 0; i <= n ; i++){
            dp[i] = i;
            for (int j = 1; i-j*j > 0; j++){
                dp[i] = Math.min(dp[i], dp[i - j*j] + 1);
            }
        }
        return dp[n];
    }
}
