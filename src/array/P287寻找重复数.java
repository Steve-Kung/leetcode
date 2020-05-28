package array;

import java.util.Arrays;

/**
 * 给定一个包含 n + 1 个整数的数组 nums，
 * 其数字都在 1 到 n 之间（包括 1 和 n），
 * 可知至少存在一个重复的整数。
 * 假设只有一个重复的整数，找出这个重复的数。
 */
public class P287寻找重复数 {
    // 个数 二分法 ,满足个数情况 分别选择左边 和 右边
    public int findDuplicate(int[] nums) {
        int len = nums.length;
        int left = 1; // 代表数字1
        int right = len -1; // 代表数字n
        while (left < right){
            int count = 0;
            int mid = (left + right) >>> 1; // 取中位数
            for (Integer i : nums){
                if (i <= mid){
                    count++;
                }
            }
            if (count >mid){
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
