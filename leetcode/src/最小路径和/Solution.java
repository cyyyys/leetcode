package 最小路径和;

/**
 * @Author: congyuyang
 * @Date: 2020/7/23 下午12:19
 *
 *
 *
 */
public class Solution {
    public static int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        if (grid == null || m == 0 || n == 0) {
            return 0;
        }

        // 1.开数组
        int[][] dp = new int[m][n];

        // 3.确定边界
        //确定初始点
        dp[0][0] = grid[0][0];

        //当列为0时dp边界
        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }

        //当行为0时dp边界
        for (int i = 1; i < n; i++) {
            dp[0][i] = dp[0][i - 1] + grid[0][i];
        }

        // 2.状态转移方程
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }
        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        System.out.println(minPathSum(new int[][]{{1, 3, 1}, {1, 5, 1}, {4, 2, 1}}));
    }
}
