package greedy;
/*
给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。

设计一个算法来计算你所能获取的最大利润。你最多可以完成 k 笔交易。

注意: 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。

示例 1:

输入: [2,4,1], k = 2
输出: 2
解释: 在第 1 天 (股票价格 = 2) 的时候买入，
在第 2 天 (股票价格 = 4) 的时候卖出，这笔交易所能获得利润 = 4-2 = 2 。

 */
public class P188买卖股票的最佳时机IV {
    public int maxProfit(int ki, int[] prices) {
        if (prices== null || prices.length <= 1){
            return 0;
        }

        // 超出内存限制
        // 采用二维数组
        if (ki > prices.length / 2){
            int len = prices.length;
            int[][] dp = new int[len][2];
            for (int i = 0; i < prices.length; i++){
                if (i ==0){
                    dp[i][0] = 0;
                    dp[i][1] = -prices[0];
                }
                else {
                    dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + prices[i]);
                    dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0] - prices[i]);
                }
            }
            return dp[len - 1][0];
        }



        // 状态：持有股票 和 卖出股票
        // 进行的最大交易次数
        int K = ki;
        // 天数
        int len = prices.length;
        int[][][] dp = new int[len][K + 1][2];
        for (int i = 0; i < prices.length; i++){
            for (int k = K ; k >= 1; k--){
                if (i ==0){
                    dp[i][k][0] = 0;
                    dp[i][k][1] = -prices[0];
                }
                else {
                    dp[i][k][0] = Math.max(dp[i-1][k][0], dp[i-1][k][1] + prices[i]);
                    dp[i][k][1] = Math.max(dp[i-1][k][1], dp[i-1][k-1][0] - prices[i]);
                }

            }
        }
        return dp[len - 1][K][0];
    }
}
