package string;

/**
 * 给定一个字符串，你的任务是计算这个字符串中有多少个回文子串。

 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被计为是不同的子串。
 */
public class P647回文子串 {
    // 暴力解法
    public int countSubstrings(String s) {
        int len = s.length();
        int count = 0;
        for (int i = 0; i < len; i++) {
            for (int j = i+1; j < len+1; j++) {
                if (isHuiWen(s.substring(i, j))){
                    count++;
                }
            }
        }
        return count;
    }
    // 判断一个字符串是否是回文字符串
    public boolean isHuiWen(String s){
        int left = 0;
        int right = s.length() -1;
        while (left < right){
            if (s.charAt(left) != s.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        P647回文子串 p647回文子串 = new P647回文子串();
        System.out.println(p647回文子串.countSubstrings1("aaa"));
    }


    public int countSubstrings1(String s){
        int res= 0;
        // dp[i][j]是子字符串在i到j之间是不是回文子串
        int len = s.length();
        boolean dp[][] = new boolean[len][len];
        for (int j = 0; j < len; j++){
            for (int i = j; i >= 0; i--) {
                // 判断dp[i][j]是否是回文子串
                // 在ij两处的字符相等的前提下 分两种情况
                // 一是 ij相距距离小于2
                // 二是 ij之间内部的子串也是回文子串
                if (s.charAt(i) == s.charAt(j) && ((j - i < 2) || dp[i+1][j-1])){
                    dp[i][j] = true;
                    res++;
                }
            }
        }
        return res;
    }


}
