package array;
// 给定一个二进制数组， 计算其中最大连续1的个数。
public class P485最大连续1的个数 {
    public int findMaxConsecutiveOnes(int[] nums) {
        int len = nums.length;
        int count = 0;
        int maxCount = 0;
        for (int i = 0; i < len; i++) {
            if (nums[i] == 1){
                count++;
                maxCount = Math.max(maxCount, count);
            }
            if (nums[i] == 0){
                maxCount = Math.max(maxCount, count);
                count = 0;
            }
        }
        return maxCount;
    }
}
