package bit;
/*
给定一个整数数组 nums，其中恰好有两个元素只出现一次，
其余所有元素均出现两次。 找出只出现一次的那两个元素。

示例 :

输入: [1,2,1,3,2,5]
输出: [3,5]
注意：

结果输出的顺序并不重要，对于上面的例子， [5, 3] 也是正确答案。
你的算法应该具有线性时间复杂度。你能否仅使用常数空间复杂度来实现？
 */
public class P260只出现一次的数字III {
    public int[] singleNumber1(int[] nums) {
        // difference between two numbers (x and y) which were seen only once
        int bitmask = 0;
        for (int num : nums) bitmask ^= num;

        // rightmost 1-bit diff between x and y
        int diff = bitmask & (-bitmask);

        int x = 0;
        // bitmask which will contain only x
        for (int num : nums) if ((num & diff) != 0) x ^= num;

        return new int[]{x, bitmask^x};
    }


    public int[] singleNumber(int[] nums) {
        int mask = 0;
        for (int num : nums) {
            mask ^= num;
        }
        // 得到最右边的1,来区分两个不同的数
        int diff = mask & (-mask);
        // 把问题分解只有一个不同数的情况
        int x = 0;
        for (int num : nums) {
            if ((num & diff) != 0){
                x ^= num;
            }
        }
        return new int[]{x, x^mask};
    }
}
