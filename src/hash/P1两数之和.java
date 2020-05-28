package hash;

import java.util.HashMap;

/*
给定一个整数数组 nums 和一个目标值 target，
请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 */

//没问题哦，因为先put进去的值被更新了，
// 如果答案是两个重复的数相加，由于只有唯一答案，数组从头遍历的话，
// 会先遇到被覆盖更新的第一个数字，那么从map中判断取出后面更新的数，
// 那么返回的结果是不会错的。
// 如果答案不是两个重复的数相加，那么那个重复的数丢掉也无所谓的。

public class P1两数之和 {
    // 双指针法 适用于有序数组,这里是无序数组

    // 方法一：暴力法
    public int[] twoSum(int[] nums, int target) {
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            for (int j = i+1; j < len; j++) {
                if (nums[j] == target - nums[i]){
                    return new int[]{i, j};
                }
            }
        }
        throw new RuntimeException("No two sum solution");
    }

    // 方法二：两遍哈希表
    public int[] twoSum1(int[] nums, int target) {
        int len = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < len; i++){
            if (map.containsKey(target - nums[i]) && map.get(target - nums[i]) != i){
                return new int[]{i, map.get(target - nums[i])};
            }
        }
        throw new RuntimeException("No two sum solution");
    }

    // 方法三：一遍哈希表
    public int[] twoSum2(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            int sub = target - nums[i];
            if (!map.isEmpty() && map.containsKey(sub)){
                return new int[]{i, map.get(sub)};
            }
            map.put(nums[i], i);
        }
        throw new RuntimeException("No two sum solution");
    }
}
