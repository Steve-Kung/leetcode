package twoDivided;
/*
给你一个排序后的字符列表 letters ，列表中只包含小写英文字母。另给出一个目标字母 target，请你寻找在这一有序列表里比目标字母大的最小字母。

在比较时，字母是依序循环出现的。举个例子：

如果目标字母 target = 'z' 并且字符列表为 letters = ['a', 'b']，则答案返回 'a'
 

示例：

输入:
letters = ["c", "f", "j"]
target = "a"
输出: "c"
 */
public class P744寻找比目标字母大的最小字母 {

    public char nextGreatestLetter(char[] letters, char target) {
        int left = 0;
        int right = letters.length;
        while (left < right){
            int mid = (left + right) >>> 1;
            if (letters[mid] > target){
                right = mid;
            } else if (letters[mid] <= target){
                left = mid + 1;
            }
        }
        // 在比较时，字母是依序循环出现的
        return letters[left % letters.length];
    }
}
