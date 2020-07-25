package 旋转数组的最小数字;

/**
 * @Author: congyuyang
 * @Date: 2020/7/22 上午11:12
 */
public class Solution1 {
    public int minArray(int[] numbers) {
        int start = 0;
        int end = numbers.length - 1;
        while (start < end) {
//            int mid = (start + end) / 2;
//            int mid = (start + end) >>> 2;
            int mid = start + (end - start) / 2;
            if (numbers[mid] > numbers[end]) {
                start = mid + 1;
            } else if (numbers[mid] < numbers[start]) {
                end = mid;
            } else {
                end--;
            }
        }
        return numbers[start];
    }
}
