package hash;

import java.util.HashSet;

public class P217存在重复元素 {
    public boolean containsDuplicate(int[] nums) {
        int len = nums.length;
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        return set.size() != len;
    }
}
