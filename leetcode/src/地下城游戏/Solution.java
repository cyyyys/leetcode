package 地下城游戏;

import java.util.Arrays;

/**
 * @Author: congyuyang
 * @Date: 2020/7/12 上午10:49
 */
public class Solution {
    public static int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length;
        int n = dungeon[0].length;
        // 1. 开数组
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        // 3. 数组的边界
        dp[m - 1][n] = dp[m][n - 1] = 1;
        // 2. 确定状态转移方程
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0 ; j--) {
                dp[i][j] = Math.max(Math.min(dp[i + 1][j], dp[i][j + 1]) - dungeon[i][j], 1);
            }
        }
        return dp[0][0];
    }

    public static void main(String[] args) {
        System.out.println(calculateMinimumHP(new int[][]{{-2, -3, 3}, {-5, -10, 1}, {10, 30, -5}}));
    }
}
