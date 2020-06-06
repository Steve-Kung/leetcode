package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/*
给定一个可包含重复数字的序列，返回所有不重复的全排列。

示例:

输入: [1,1,2]
输出:
[
  [1,1,2],
  [1,2,1],
  [2,1,1]
]

 */
public class P47全排列II {
    List<List<Integer>> res= new ArrayList<>();
    // 也可以直接使用一个布尔数组进行记录是否使用过
    boolean[] used;
    public List<List<Integer>> permuteUnique(int[] nums) {
        if (nums == null || nums.length == 0){
            return res;
        }
        List<Integer> track = new ArrayList<>();
        Arrays.sort(nums);
        used = new boolean[nums.length];
        backtrack(nums, track);
        return res;
    }

    private void backtrack(int[] nums, List<Integer> track) {
        if (track.size() == nums.length){
            res.add(new ArrayList<>(track));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
//            写 !used[i - 1] 是因为 nums[i - 1] 在遍历的过程中刚刚被撤销选择
            if (i > 0 && nums[i] == nums[i-1] && !used[i - 1]){
                continue;
            }
            if (!isVaild(nums, i)){
                continue;
            }
            track.add(nums[i]);
            used[i] = true;
            backtrack(nums, track);
            track.remove(track.size() - 1);
            used[i] = false;

        }
    }

    private boolean isVaild(int[] nums, int i) {
        return !used[i];
    }

    public static void main(String[] args) {
        int[] nums = {1,1,2};
        P47全排列II p47全排列II = new P47全排列II();
        List<List<Integer>> lists = p47全排列II.permuteUnique(nums);
        System.out.println(lists);
    }

    class ans1{
        List<List<Integer>> res= new ArrayList<>();
        // 也可以直接使用一个布尔数组进行记录是否使用过
        HashMap<Integer, Integer> map = new HashMap<>();
        public List<List<Integer>> permuteUnique(int[] nums) {
            if (nums == null || nums.length == 0){
                return res;
            }
            List<Integer> track = new ArrayList<>();
            Arrays.sort(nums);
            for (int i=0; i < nums.length; i++){
                map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            }
            backtrack(nums, track);
            return res;
        }

        private void backtrack(int[] nums, List<Integer> track) {
            if (track.size() == nums.length){
                res.add(new ArrayList<>(track));
                return;
            }
            for (int i = 0; i < nums.length; i++) {
                if (i > 0 && nums[i] == nums[i-1]){
                    continue;
                }
                if (!isVaild(nums, i)){
                    continue;
                }
                track.add(nums[i]);
                map.put(nums[i], map.getOrDefault(nums[i], 0) - 1);
                backtrack(nums, track);
                track.remove(track.size() - 1);
                map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);

            }
        }

        private boolean isVaild(int[] nums, int i) {
            return map.get(nums[i]) > 0;
        }
    }

}
