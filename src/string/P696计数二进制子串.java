package string;

/**
 * 给定一个字符串 s，计算具有相同数量0和1的非空(连续)子字符串的数量，
 *
 * 并且这些子字符串中的所有0和所有1都是组合在一起的。

 重复出现的子串要计算它们出现的次数。

 */
public class P696计数二进制子串 {
    public int countBinarySubstrings(String s) {
        int len = s.length();
        int[] sub = new int[len];
        int t = 0;
        // 设置头一个先为1
        sub[0] = 1;
        for (int i = 1; i < len; i++) {
            if (s.charAt(i) == s.charAt(i-1)){
                sub[t]++;
            } else {
                sub[++t] = 1;
            }
        }
        int ans = 0;
        for (int i = 1; i <= t; i++) {
            ans += Math.min(sub[i], sub[i-1]);
        }
        return ans;

    }

    public static void main(String[] args) {
        P696计数二进制子串 p696计数二进制子串 = new P696计数二进制子串();
        int i = p696计数二进制子串.countBinarySubstrings("00110");
        System.out.println(i);
    }

//    public int countBinarySubstrings1(String s) {
//        int[] groups = new int[s.length()];
//        int t = 0;
//        groups[0] = 1;
//        for (int i = 1; i < s.length(); i++) {
//            if (s.charAt(i-1) != s.charAt(i)) {
//                groups[++t] = 1;
//            } else {
//                groups[t]++;
//            }
//        }
//
//        int ans = 0;
//        for (int i = 1; i <= t; i++) {
//            ans += Math.min(groups[i-1], groups[i]);
//        }
//        return ans;
//    }
}
