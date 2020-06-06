package backtracking;

import java.util.ArrayList;
import java.util.List;

/*
给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
示例:
输入: n = 4, k = 2
输出:
[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]
 */
public class P77组合 {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        if (k <= 0){
            return res;
        }
        List<Integer> track = new ArrayList<>();
        backtrack(1, n, track, k);
        return res;
    }

    private void backtrack(int start, int n, List<Integer> track, int k) {
        if (track.size() == k){
            res.add(new ArrayList<>(track));
            return;
        }
        for (int i = start; i <= n; i++){
            track.add(i);
            backtrack(i + 1, n, track, k);
            track.remove(track.size() - 1);
        }
    }
}
