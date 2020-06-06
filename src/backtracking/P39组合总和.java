package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
给定一个无重复元素的数组 candidates 和一个目标数 target ，
找出 candidates 中所有可以使数字和为 target 的组合。
candidates 中的数字可以无限制重复被选取。
说明：

所有数字（包括 target）都是正整数。
解集不能包含重复的组合。 
示例 1:
输入: candidates = [2,3,6,7], target = 7,
所求解集为:
[
  [7],
  [2,2,3]
]
 */
public class P39组合总和 {
    List<List<Integer>> res;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        res = new ArrayList<>();
        if (candidates == null || candidates.length == 0){
            return res;
        }
        List<Integer> temp = new ArrayList<>();
        // 排序
        // 为剪枝做准备
        Arrays.sort(candidates);
        backtrack(0, candidates, target, temp);
        return res;
    }

    private void backtrack(int start, int[] candidates, int target, List<Integer> temp) {
        // 递归结束条件
        if (target == 0){
            // 注意这里需要重新new对象，否则res存入的temp在后面也会被修改
            res.add(new ArrayList<>(temp));
            return;
        }
        if (target < 0){
            return;
        }
//        为什么会有重复的组合呢？因为每次递归我们都是从 0 开始，
// 所有数字都遍历一遍。所以会出现重复的组合。改进一下，只需加一个 start 变量即可
        for (int i= start; i < candidates.length; i++){
            // 排除不合法的选择
            // 相当于剪枝 break
            if (!isVaild(candidates, i, target)){
//                continue;
                break;
            }
            // 做出选择
            int choose = candidates[i];
            temp.add(choose);
            // 递归
            // 因为每个数字都可以使用无数次，所以递归还可以从当前元素开始
            backtrack(i,candidates, target - choose, temp);
            // 撤销选择
            temp.remove(temp.size() - 1);
        }

    }

    private boolean isVaild(int[] candidates, int i, int target) {
        return candidates[i] <= target;
    }

    public static void main(String[] args) {
        int[] candidates = {2,3,6,7};
        int target = 7;
        P39组合总和 p39组合总和 = new P39组合总和();
        List<List<Integer>> lists = p39组合总和.combinationSum(candidates, target);
        System.out.println(lists);
    }
}
