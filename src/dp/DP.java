package dp;
/*
    // 确定状态X
    // 确定状态dp[x]的含义
    // 确定base case
    // 迭代自底向上
    // 选择择优
 */
public class DP {
    // conis金额有 1 2 5
    int coinchange(int[] coins, int amount){
        // dp[x] 代表是达到金额x的最少硬币数
        int[] dp = new int[amount + 1];
        // 初始化dp数组的值为“最大值” 择优取最少值
        for (int i = 0; i < dp.length; i++) {
            dp[i] = amount + 1;
        }
        // base case
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;
        // 自底向上迭代
        for (int i = 0; i < dp.length; i++) {
            // 内层for循环 择优
            for (int coin : coins){
                dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }
        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }
}
