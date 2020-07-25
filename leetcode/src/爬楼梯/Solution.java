package 爬楼梯;

/**
 * @Author: congyuyang
 * @Date: 2020/7/4 下午4:20
 *
 */
public class Solution {
    public static int climbStairs(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= n; i++) {
            // 建立状态转移方程
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(climbStairs(3));
    }
}
