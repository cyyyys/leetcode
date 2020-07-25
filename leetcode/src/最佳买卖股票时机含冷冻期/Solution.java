package 最佳买卖股票时机含冷冻期;

/**
 * @Author: congyuyang
 * @Date: 2020/7/10 上午9:53
 */
public class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int len = prices.length;

        // dp[i]: 表示第i天结束后的最大收益值

        // dp[i][0]: 手上持有股票的最大收益
        // dp[i][1]: 手上不持有股票，并处于冷冻期的最大收益
        // dp[i][2]: 手上不持有股票，并且不处于冷冻期的最大收益

        int[][] dp = new int[len][3];

        dp[0][0] = -prices[0];

        for (int i = 1; i < len; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][2] - prices[i]);
            dp[i][1] = dp[i - 1][0] + prices[i];
            dp[i][2] = Math.max(dp[i - 1][1], dp[i - 1][2]);
        }
        //如果最后一天手上仍有股票没有任何意义，因此我们只比表状态1、2
        return Math.max(dp[len - 1][1], dp[len - 1][2]);

    }
}
