package greedy;
/*
给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。

设计一个算法来计算你所能获取的最大利润。你最多可以完成 两笔 交易。

注意: 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。

示例 1:

输入: [3,3,5,0,0,3,1,4]
输出: 6
解释: 在第 4 天（股票价格 = 0）的时候买入，在第 6 天（股票价格 = 3）的时候卖出，这笔交易所能获得利润 = 3-0 = 3 。
     随后，在第 7 天（股票价格 = 1）的时候买入，在第 8 天 （股票价格 = 4）的时候卖出，这笔交易所能获得利润 = 4-1 = 3 。

 */
public class P123买卖股票的最佳时机III {
    public int maxProfit(int[] prices) {
        if (prices== null || prices.length <= 1){
            return 0;
        }
        // 状态：持有股票 和 卖出股票
        // 进行的最大交易次数
        int K = 2;
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
