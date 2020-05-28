package twopoint;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
编写一个函数，以字符串作为输入，反转该字符串中的元音字母。

示例 1:

输入: "hello"
输出: "holle"
 */
public class P345反转字符串中的元音字母 {
    public String reverseVowels(String s) {
        char[] strToArrays = s.toCharArray();
        Set<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        set.add('A');
        set.add('E');
        set.add('I');
        set.add('O');
        set.add('U');
        int left = 0;
        int right = s.length() -1;
        while (left < right){
            while (left < right && !set.contains(strToArrays[left])){
                left++;
            }
            while (left < right && !set.contains(strToArrays[right])){
                right--;
            }
            char tmp = strToArrays[left];
            strToArrays[left] = strToArrays[right];
            strToArrays[right] = tmp;
            left++;
            right--;
        }
        return new String(strToArrays);
    }
}
