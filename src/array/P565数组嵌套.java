package array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/*
索引从0开始长度为N的数组A，包含0到N - 1的所有整数。找到最大的集合S并返回其大小，
其中 S[i] = {A[i], A[A[i]], A[A[A[i]]], ... }且遵守以下的规则。

假设选择索引为i的元素A[i]为S的第一个元素，S的下一个元素应该是A[A[i]]，
之后是A[A[A[i]]]... 以此类推，不断添加直到S出现重复的元素。


示例 1:

输入: A = [5,4,0,3,1,6,2]
输出: 4
解释:
A[0] = 5, A[1] = 4, A[2] = 0, A[3] = 3, A[4] = 1, A[5] = 6, A[6] = 2.

其中一种最长的 S[K]:
S[0] = {A[0], A[5], A[6], A[2]} = {5, 6, 2, 0}

 */
public class P565数组嵌套 {
    /*
    如果从一个位置开始嵌套查找直到找到一个重复元素，
    这个过程中所找过的所有元素会形成一个闭环，
    也就是闭环之外不会有索引指向环内元素
     */
    // 每个数据只会遍历一次
    public int arrayNesting(int[] nums) {
        int ans = 0;
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++){
            int count = 0;
            int k = i;
            while (!set.contains(nums[k])){
                set.add(nums[k]);
                count++;
                k = nums[k];
            }
            ans = Math.max(count, ans);
        }
        return ans;
    }
}
