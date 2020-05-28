package twopoint;
/*
给定一个非空字符串 s，最多删除一个字符。判断是否能成为回文字符串。

示例 1:

输入: "aba"
输出: True
 */
public class P680验证回文字符串Ⅱ {
    public boolean validPalindrome(String s) {
        // 判断字符串是否是回文 ,给予一次删除机会
        for (int i = 0, j = s.length() -1 ; i < j; i++, j--){
            if (s.charAt(i) != s.charAt(j)){
                return isPalindrome(s, i+1, j) || isPalindrome(s, i, j-1);
            }
        }
        return true;
    }
    // 判断字符串是否是回文
    public boolean isPalindrome(String s, int start, int end){
        for (int i = start, j = end ; i < j; i++, j--){
            if (s.charAt(i) != s.charAt(j)){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new P680验证回文字符串Ⅱ().validPalindrome("eeccccbebaeeabebccceea"));
    }
}
