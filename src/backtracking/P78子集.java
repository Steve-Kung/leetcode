package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
说明：解集不能包含重复的子集。
示例:
输入: nums = [1,2,3]
输出:
[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]
 */
public class P78子集 {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        if (nums == null || nums.length == 0){
            return res;
        }
        List<Integer> track = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(0, nums, track);
        return res;
    }

    private void backtrack(int start, int[] nums, List<Integer> track) {
        // 递归终止条件
        res.add(new ArrayList<>(track));
        if (start == nums.length){
            return;
        }
        // 循环递归
        for (int i = start; i < nums.length; i++){
            // 无枝可减
            track.add(nums[i]);
            backtrack(i + 1, nums, track);
            track.remove(track.size() - 1);
        }
    }
}
