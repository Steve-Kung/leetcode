package greedy;
/*
给定一个整数数组，其中第 i 个元素代表了第 i 天的股票价格 。​

设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:

你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
示例:

输入: [1,2,3,0,2]
输出: 3
解释: 对应的交易状态为: [买入, 卖出, 冷冻期, 买入, 卖出]
 */
public class P309最佳买卖股票时机含冷冻期 {
    public int maxProfit(int[] prices) {
        if (prices== null || prices.length <= 1){
            return 0;
        }
        // 状态：持有股票 和 卖出股票
        // 进行的最大交易次数
        // 天数
        int len = prices.length;
        int[][] dp = new int[len][2];
        for (int i = 0; i < prices.length; i++){
            if (i ==0){
                dp[i][0] = 0;
                dp[i][1] = -prices[0];
            }
            else if (i == 1){
                dp[i][0] = Math.max(0, -prices[0] + prices[1]);
                dp[i][1] = Math.max(-prices[0], -prices[1]);
            }
            else {
                dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + prices[i]);
                dp[i][1] = Math.max(dp[i-1][1], dp[i-2][0] - prices[i]);
            }
        }
        return dp[len - 1][0];
    }
}
