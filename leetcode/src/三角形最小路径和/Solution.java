package 三角形最小路径和;

import java.util.List;

/**
 * @Author: congyuyang
 * @Date: 2020/7/14 下午4:51
 *
 * 与(i, j)相邻的节点为(i + 1, j)和(i + 1, j + 1)
 *
 * dp[i][j] = min(dp[i - 1][j - 1], dp[i - 1][j]) + tri[i][j]
 * dp[i][0] = dp[i - 1][0] + tri[i][0]
 * dp[i][j] = dp[i - 1][i - 1] + tri[i][i]
 *
 */
public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int len = triangle.size();
        // 开数组
        int[][] dp = new int[len][len];
        // 边界
        dp[0][0] = triangle.get(0).get(0);
        for (int i = 1; i < len; i++) {
            dp[i][0] = dp[i - 1][0] + triangle.get(i).get(0);
            for (int j = 0; j < i; j++) {
                dp[i][j] = Math.min(dp[i - 1][j - 1], dp[i - 1][j]) + triangle.get(i).get(j);
            }
            dp[i][i] = dp[i - 1][i - 1] + triangle.get(i).get(i);
        }

        // 三角形最后一行的起始位置
        int ans = dp[len - 1][0];

        // 遍历最后一行所有位置进行比较，求解最小值
        for (int i = 0; i < len; i++) {
            ans = Math.min(ans, dp[len - 1][i]);
        }

        return ans;

    }
}
