package string;

import java.util.HashMap;

public class P409最长回文串 {
    public int longestPalindrome(String s) {
        if (s == null){
            return 0;
        }
        HashMap<Character, Integer> map = new HashMap<>();
        for (Character c : s.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int length = 0;
        for (Character c : map.keySet()){
            Integer count = map.get(c);
            // 只加向下取得偶数
            length += (count - (count & 1));
        }
        // 说明出现过奇数次的字符
        return   (length < s.length()) ? length + 1 : length;
    }
}
