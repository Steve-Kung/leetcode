package backtracking;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/*
找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。
说明：
所有数字都是正整数。
解集不能包含重复的组合。 
示例 1:
输入: k = 3, n = 7
输出: [[1,2,4]]
 */
public class P216组合总和III {
    List<List<Integer>> res= new ArrayList<>();
    public List<List<Integer>> combinationSum3(int k, int n) {
        if (k == 0 || n == 0){
            return res;
        }
        Deque<Integer> track = new ArrayDeque<>();
        backtrack(1, k, n, track);
        return res;
    }

    private void backtrack(int start, int k, int n, Deque<Integer> track) {
        // 递归终止条件
        if (k == 0 && n == 0){
            res.add(new ArrayList<>(track));
            return;
        }
        if (k == 0 || n <= 0){
            return;
        }
        // 循环递归
        for (int i = start; i <= 9 ;i++){
            // 无需剪枝
            // 做出选择
            track.addLast(i);
            backtrack(i + 1,k - 1, n - i, track);
            track.removeLast();
        }
    }
}
