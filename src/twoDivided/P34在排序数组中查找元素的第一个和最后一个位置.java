package twoDivided;

import sort.P347前K个高频元素;

/*
给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。

你的算法时间复杂度必须是 O(log n) 级别。

如果数组中不存在目标值，返回 [-1, -1]。

示例 1:

输入: nums = [5,7,7,8,8,10], target = 8
输出: [3,4]
 */
public class P34在排序数组中查找元素的第一个和最后一个位置 {
    public int[] searchRange(int[] nums, int target) {
        int left = findLeftTarget(nums, target);
        int right = findRightTarget(nums, target);
        return new int[]{left, right};
    }

    // 查找最左边的值
    public int findLeftTarget(int[] nums, int target){
        int left  = 0;
        int right = nums.length;
        while (left < right){
            int mid = (left + right) >>> 1;
            if (nums[mid] == target){
                right = mid;
            }else if (nums[mid] > target){
                right = mid;
            }else if (nums[mid] < target){
                left = mid + 1;
            }
        }
        if (left == nums.length){
            // 没有
            return -1;
        }
        return nums[left] == target ? left : -1;
    }

    // 查找最右边的值
    public int findRightTarget(int[] nums, int target){
        int left = 0;
        int right = nums.length;
        while (left < right){
            int mid = (left + right) >>> 1;
            if (nums[mid] == target){
                left = mid + 1;
            }else if (nums[mid] > target){
                right = mid;
            }else if (nums[mid] < target){
                left = mid + 1;
            }
        }
        // 没有找到
        if (right == 0){
            return -1;
        }
        return nums[right - 1] == target ? right - 1 : -1;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 4, 5};
        P34在排序数组中查找元素的第一个和最后一个位置 p34在排序数组中查找元素的第一个和最后一个位置 = new P34在排序数组中查找元素的第一个和最后一个位置();
        int leftTarget = p34在排序数组中查找元素的第一个和最后一个位置.findLeftTarget(nums, 4);
        System.out.println(leftTarget);
    }

    /*
    public int[] searchRange(int[] nums, int target) {
        int left = findLeftTarget(nums, target);
        int right = findLeftTarget(nums, target + 1) - 1;
        if (left > right){
            return new int[]{-1, -1};
        }
        return new int[]{left, right};
    }

    // 查找最左边的值
    public int findLeftTarget(int[] nums, int target){
        int left  = 0;
        int right = nums.length;
        while (left < right){
            int mid = (left + right) >>> 1;
            if (nums[mid] == target){
                right = mid;
            }else if (nums[mid] > target){
                right = mid;
            }else if (nums[mid] < target){
                left = mid + 1;
            }
        }
        return left;
    }
     */
}
