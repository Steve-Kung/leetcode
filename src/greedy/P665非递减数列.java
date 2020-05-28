package greedy;
/*
给你一个长度为 n 的整数数组，请你判断在 最多 改变 1 个元素的情况下，该数组能否变成一个非递减数列。
我们是这样定义一个非递减数列的： 对于数组中所有的 i (1 <= i < n)，总满足 array[i] <= array[i + 1]。
示例 1:
输入: nums = [4,2,3]
输出: true
解释: 你可以通过把第一个4变成1来使得它成为一个非递减数列。

i i+1 i+2
1    5   3
3    5   3
4    5   3
6    5   3

 */
public class P665非递减数列 {
    public boolean checkPossibility1(int[] nums) {
        int len = nums.length;
        if (len < 3){
            return true;
        }
        int count = 0;
        for (int i = 0; i < len-2; i++){
            // 特殊情况特殊处理一下
            if (i == 0){
                if (nums[i] > nums[i+1]){
                    nums[i] = nums[i+1];
                    count++;
                }
            }
            if (nums[i+1] > nums[i+2]){
                if (nums[i] > nums[i+1]){
                    return false;
                }
                else if (nums[i] > nums[i+2]){
                    nums[i+2] = nums[i+1];
                    count++;
                }
                else if (nums[i] <= nums[i+2]){
                    nums[i+1] = nums[i+2];
                    count++;
                }
            }
        }
        return count <= 1;
    }

    public boolean checkPossibility(int[] nums) {
        int len = nums.length;
        if (len < 3){
            return true;
        }
        int count = 0;
        for (int i = 0; i < len-1; i++){
            if (nums[i] > nums[i+1]){
                count++;
                if (count > 1){
                    return false;
                }
                if (i-1 >= 0 && nums[i-1] > nums[i+1]){
                    nums[i+1] = nums[i];
                }else {
                    nums[i] = nums[i+1];
                }
            }
        }
        return count <= 1;
    }

    /*
     public boolean checkPossibility(int[] nums) {
        if(nums.length < 3){
            return true;
        }
        int count = 0;
        for(int i=0;i<nums.length-1;i++){
            if(nums[i] > nums[i+1]){
                count++;
                if(count > 1){
                    break;
                }
                if(i-1 >=0&&nums[i-1] > nums[i+1]){
                    nums[i+1] = nums[i];
                }else{
                    nums[i] = nums[i+1];
                }
            }
        }
        return count <= 1;
    }
     */
}
