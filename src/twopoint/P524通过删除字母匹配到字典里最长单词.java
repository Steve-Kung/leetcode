package twopoint;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/*
给定一个字符串和一个字符串字典，找到字典里面最长的字符串，
该字符串可以通过删除给定字符串的某些字符来得到。如果答案不止一个，
返回长度最长且字典顺序最小的字符串。如果答案不存在，则返回空字符串。

示例 1:

输入:
s = "abpcplea", d = ["ale","apple","monkey","plea"]

输出:
"apple"
//
jdk官方默认是升序，是基于：

< return -1
= return 0
> return 1
1
2
3
官方的源码就是基于这个写的；可以理解为硬性规定。
也就是说，排序是由这三个参数同时决定的。

如果要降序就必须完全相反：

< return 1
= return 0
> return -1

 //
 */
public class P524通过删除字母匹配到字典里最长单词 {
    public String findLongestWord(String s, List < String > d) {
        Collections.sort(d, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() != o2.length() ? o2.length() - o1.length() : o1.compareTo(o2);
            }
        });
        for (String s1 : d) {
            if(isSubString(s1, s)){
                return s1;
            }
        }
        return "";
    }

    private boolean isSubString(String s1, String s) {
        int i = 0;
        for (int j = 0; j < s.length() && i < s1.length(); j++) {
            if (s1.charAt(i) == s.charAt(j)){
                i++;
            }
        }
        return i==s1.length();
    }
}





/*
 // 判断x是否是y的子串
    public boolean isSubsequence(String x, String y) {
        int j = 0;
        for (int i = 0; i < y.length() && j < x.length(); i++)
            if (x.charAt(j) == y.charAt(i))
                j++;
        return j == x.length();
    }
    // 优先匹配长度长的，长度按降序排列
    // 再匹配字典序的。字典序按升序排列
    public String findLongestWord(String s, List < String > d) {
        Collections.sort(d, new Comparator< String >() {
            public int compare(String s1, String s2) {
                return s2.length() != s1.length() ? s2.length() - s1.length() : s1.compareTo(s2);
            }
        });
        for (String str: d) {
            if (isSubsequence(str, s))
                return str;
        }
        return "";
    }
 */
