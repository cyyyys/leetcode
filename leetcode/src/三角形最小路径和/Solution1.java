package 三角形最小路径和;

import java.util.List;

/**
 * @Author: congyuyang
 * @Date: 2020/7/14 下午5:07
 */
public class Solution1 {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] dp = new int[n + 1];
        for (int i = n - 1; i >= 0; i++) {
            for (int j = 0; j <= i; j++) {
                dp[j] = Math.min(dp[j], dp[j + 1]) + triangle.get(i).get(j);
            }
        }
        return dp[0];
    }
}
