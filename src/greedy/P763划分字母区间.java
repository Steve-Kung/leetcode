package greedy;

import java.util.ArrayList;
import java.util.List;

/*
字符串 S 由小写字母组成。我们要把这个字符串划分为尽可能多的片段，
同一个字母只会出现在其中的一个片段。返回一个表示每个字符串片段的长度的列表。

示例 1:

输入: S = "ababcbacadefegdehijhklij"
输出: [9,7,8]
解释:
划分结果为 "ababcbaca", "defegde", "hijhklij"。
每个字母最多出现在一个片段中。
像 "ababcbacadefegde", "hijhklij" 的划分是错误的，因为划分的片段数较少。
 */
public class P763划分字母区间 {
    /*
    定义数组 last[char] 来表示字符 char 最后一次出现的下标。
    定义 anchor 和 j 来表示当前区间的首尾。如果遇到的字符最后一次出现的位置下标大于 j，
     就让 j=last[c] 来拓展当前的区间。当遍历到了当前区间的末尾时(即 i==j )，
     把当前区间加入答案，同时将 start 设为 i+1 去找下一个区间。
     */
    /*
     public List<Integer> partitionLabels(String S) {
        int[] last = new int[26];
        for (int i = 0; i < S.length(); ++i)
            last[S.charAt(i) - 'a'] = i;

        int j = 0, anchor = 0;
        List<Integer> ans = new ArrayList();
        for (int i = 0; i < S.length(); ++i) {
            j = Math.max(j, last[S.charAt(i) - 'a']);
            if (i == j) {
                ans.add(i - anchor + 1);
                anchor = i + 1;
            }
        }
        return ans;
    }
     */
    public List<Integer> partitionLabels(String s) {
        List<Integer> ans = new ArrayList<>();
        int len = s.length();
        if (len < 2){
            ans.add(len);
            return ans;
        }
        // 记录每个元素出现的最后一次的位置
        int[] record = new int[26];
        for (int i = 0; i< len; i++){
            record[s.charAt(i) - 'a'] = i;
        }
        // 当前区间的首位
        int start = 0;
        int end = 0;
        for (int i =0; i < len; i++){
            end = Math.max(record[s.charAt(i) - 'a'], end);
            if (i == end){
                ans.add(end - start + 1);
                start = end + 1;
            }
        }
        return ans;
    }
}
