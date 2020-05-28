package greedy;
/*
给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
如果你最多只允许完成一笔交易（即买入和卖出一支股票一次），
设计一个算法来计算你所能获取的最大利润。
注意：你不能在买入股票前卖出股票。
示例 1:
输入: [7,1,5,3,6,4]
输出: 5
解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
     注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
 */
public class P121买卖股票的最佳时机 {
    public int maxProfit(int[] prices) {
        if (prices== null || prices.length <= 1){
            return 0;
        }
        // 状态：持有股票 和 卖出股票
        // 进行的最大交易次数
        int K = 1;
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
