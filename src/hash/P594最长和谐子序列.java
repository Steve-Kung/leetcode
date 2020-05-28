package hash;

import java.util.*;

public class P594最长和谐子序列 {
    public int findLHS(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        Set<Integer> keySet = map.keySet();
        int max = 0;
        for (Integer key : keySet) {
            if (keySet.contains(key + 1)){
                max = Math.max(map.get(key) + map.get(key + 1), max);
            }
        }
        return max;
    }
}
