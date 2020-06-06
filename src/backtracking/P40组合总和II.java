package backtracking;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。

candidates 中的每个数字在每个组合中只能使用一次。

说明：

所有数字（包括目标数）都是正整数。
解集不能包含重复的组合。 
示例 1:

输入: candidates = [10,1,2,7,6,1,5], target = 8,
所求解集为:
[
  [1, 7],
  [1, 2, 5],
  [2, 6],
  [1, 1, 6]
]

 */
public class P40组合总和II {
    List<List<Integer>> res;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        // 边界条件
        res = new ArrayList<>();
        if (candidates == null || candidates.length == 0){
            return res;
        }
        // 排序,以便提前break
        Arrays.sort(candidates);
        // 记录轨迹
        List<Integer> track = new ArrayList<>();
        // 开始回溯
        backtrack(0, candidates, target, track);
        return res;
    }

    private void backtrack(int start, int[] candidates, int target, List<Integer> track) {
        // 递归终止条件
        if (target < 0){
            return;
        }
        if (target == 0){
            res.add(new ArrayList<Integer>(track));
            return;
        }

        // 循环递归
        int len = candidates.length;
        for (int i = start; i < len; i++) {
            // 这种写法比前面考虑更加完善
            if (i > start && candidates[i] == candidates[i - 1]){
                continue;
            }
            // 以下注释写法不可取
            // if (i < len - 1 && candidates[i] == candidates[i + 1]){
            //     continue;
            // }
            // 剪枝
            if (!isVaild(candidates, target, i)){
                break;
            }
            track.add(candidates[i]);
            backtrack(i+1, candidates, target - candidates[i], track);
            track.remove(track.size() - 1);
        }
    }

    private boolean isVaild(int[] candidates, int target, int i) {
        return candidates[i] <= target;
    }
}
