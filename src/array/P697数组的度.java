package array;

import java.util.*;

/**
 * 给定一个非空且只包含非负数的整数数组 nums, 数组的度的定义是指数组里任一元素出现频数的最大值。

 你的任务是找到与 nums 拥有相同大小的度的最短连续子数组，返回其长度。
 */
public class P697数组的度 {
    public int findShortestSubArray1(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        Set<Integer> keySet = map.keySet();
        int maxCount = 0;
        ArrayList<Integer> indexList = new ArrayList();
        for (Integer key : keySet) {
            maxCount = Math.max(maxCount, map.get(key));
        }
        for (Integer key : keySet){
            if (map.get(key) == maxCount){
                indexList.add(key);
            }
        }
        int len = nums.length;
        for (Integer index : indexList) {
            int left= 0;
            int right = nums.length - 1;
            while (nums[left] != index){
                left++;
            }
            while (nums[right]!= index){
                right--;
            }
            len = Math.min(len, right-left+1);
        }
        return len;
    }



    // 利用hashmap来存次数和第一次出现的索引和最后一次出现的索引
    public int findShortestSubArray(int[] nums) {
        HashMap<Integer, Integer> countMap = new HashMap<>();
        HashMap<Integer, Integer> leftMap = new HashMap<>();
        HashMap<Integer, Integer> rightMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            countMap.put(nums[i], countMap.getOrDefault(nums[i], 0) + 1);
            if (!leftMap.containsKey(nums[i])){
                leftMap.put(nums[i], i);
            }
            rightMap.put(nums[i], i);
        }
        int max = Collections.max(countMap.values());
        int ans = nums.length;
        for (Integer key : countMap.keySet()) {
            if (countMap.get(key) == max){
                ans = Math.min(rightMap.get(key) - leftMap.get(key) + 1, ans);
            }
        }
        return ans;
    }
}
