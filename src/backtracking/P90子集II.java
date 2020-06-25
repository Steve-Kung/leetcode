package backtracking;

import java.util.*;

/*
给定一个可能包含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
说明：解集不能包含重复的子集。
示例:
输入: [1,2,2]
输出:
[
  [2],
  [1],
  [1,2,2],
  [2,2],
  [1,2],
  []
]
 */
public class P90子集II {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        if (nums == null || nums.length == 0){
            return res;
        }
        Arrays.sort(nums);
        List<Integer> track = new ArrayList<>();
        backtrack(0, nums, track);
        return res;
    }

    private void backtrack(int start, int[] nums, List<Integer> track) {
        res.add(new ArrayList<>(track));
        if (start == nums.length){
            return;
        }
        for (int i = start; i < nums.length; i++){
            if (i > start && nums[i] == nums[i - 1]){
                continue;
            }
            track.add(nums[i]);
            backtrack(i + 1, nums, track);
            track.remove(track.size() - 1);
        }
    }
}
