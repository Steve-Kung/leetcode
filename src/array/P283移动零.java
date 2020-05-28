package array;

/**
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，
 * 同时保持非零元素的相对顺序。

 示例:

 输入: [0,1,0,3,12]
 输出: [1,3,12,0,0]
 */
public class P283移动零 {
    // 第一次遍历的时候，j指针记录非0的个数，只要是非0的统统都赋给nums[j]
    //非0元素统计完了，剩下的都是0了
    //所以第二次遍历把末尾的元素都赋为0即可
    public void moveZeroes1(int[] nums) {
        if (nums == null){
            return;
        }
        int len  = nums.length;
        int j = 0;
        for (int i = 0; i < len; i++) {
            if (nums[i] != 0){
                nums[j++] = nums[i];
            }
        }
        for (int i = j; i < len; i++) {
            nums[i] = 0;
        }
    }

    //两个指针i和j
    //当前元素!=0，就把其交换到左边，相当于0的交换到右边
    public void moveZeroes(int[] nums) {
        if (nums == null){
            return;
        }
        int len = nums.length;
        int j = 0;
        for (int i = 0; i < len; i++) {
            if (nums[i] != 0){
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j++] = tmp;
            }
        }
    }

}
