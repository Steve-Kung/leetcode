package array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Set;

public class P645错误的集合 {
    /**
     * 集合 S 包含从1到 n 的整数。不幸的是，因为数据错误，
     * 导致集合里面某一个元素复制了成了集合里面的另外一个元素的值，
     * 导致集合丢失了一个整数并且有一个元素重复。

     给定一个数组 nums 代表了集合 S 发生错误后的结果。
     你的任务是首先寻找到重复出现的整数
     ，再找到丢失的整数，将它们以数组的形式返回。

     输入: nums = [1,2,2,4]
     输出: [2,3]

     *
     */
    public int[] findErrorNums(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int dup = -1;
        int miss = -1;
        Set<Integer> keySet = map.keySet();
        for (int i = 1; i <= nums.length; i++){
//            if (dup == -1 || miss == -1){
                if (keySet.contains(i)){
                    if (map.get(i) == 2){
                        dup = i;
                    }
                } else {
                    miss = i;
//                }
//            }else {
//                break;
            }

        }
        return new int[]{dup, miss};
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3,2,3,4,6,5};
        P645错误的集合 p645错误的集合 = new P645错误的集合();
        int[] errorNums = p645错误的集合.findErrorNums(nums);
        for (int errorNum : errorNums) {
            System.out.println(errorNum);
        }
    }
}
