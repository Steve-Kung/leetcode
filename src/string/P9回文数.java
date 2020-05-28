package string;

// 判断一个整数是否是回文数。回文数是指正序（从左向右）
// 和倒序（从右向左）读都是一样的整数。
public class P9回文数 {
    public boolean isPalindrome(int x) {
        String s = String.valueOf(x);
        int left = 0;
        int right = s.length()-1;
        while (left < right){
            if (s.charAt(left) != s.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
