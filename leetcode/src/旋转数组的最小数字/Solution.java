package 旋转数组的最小数字;

import java.util.Arrays;

/**
 * @Author: congyuyang
 * @Date: 2020/7/22 上午11:07
 *
 *      API法（排序法）：
 *      快速排序：时间复杂度的平均情况是O(nlogn)
 *
 *
 */
public class Solution {
    public int minArray(int[] numbers) {
        Arrays.sort(numbers);
        return numbers[0];
    }
}
