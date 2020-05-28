package list; /**
 * 请实现一个函数，将一个字符串中的每个空格替换成“%20”。
 * 例如，当字符串为We Are Happy.
 * 则经过替换之后的字符串为We%20Are%20Happy。
 */

/**
 *
 解法一：用Java自带的函数str.toString().replace(" ","%20")。
 解法二：在当前字符串上进行替换。
 先计算替换后的字符串需要多大的空间，并对原字符串空间进行扩容；
 从后往前替换字符串的话，每个字符串只需要移动一次；
 如果从前往后，每个字符串需要多次移动，效率较低。


 解法三：开辟一个新的字符串。遇到空格添加‘%20’；

 */

public class 空格替换 {

    public String replaceSpace0(StringBuffer str) {
        if (str == null){
            return null;
        }
        return str.toString().replace(" ", "%20");
    }

    public String replaceSpace1(StringBuffer str) {
        if (str == null){
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' '){
                sb.append("%20");
            } else {
                sb.append(str.charAt(i));
            }
        }
        return sb.toString();
    }

    public static String replaceSpace2(StringBuffer str) {
        if (str == null){
            return null;
        }
        int oldLength = str.length();
        int newLength = oldLength;
        for (int i = 0; i<oldLength; i++){
            if (str.charAt(i) == ' '){
                newLength += 2;
            }
        }
        str.setLength(newLength);
        int p1 = oldLength -1;
        int p2 = newLength -1;
        while ( p1 < p2 && p1 >= 0){
            if (str.charAt(p1) != ' '){
                str.setCharAt(p2--, str.charAt(p1--));
            } else {
                str.setCharAt(p2--, '0');
                str.setCharAt(p2--, '2');
                str.setCharAt(p2--, '%');
                p1--;
            }
        }
        return str.toString();
    }

    public static void main(String[] args) {
        String str = "   ";
        StringBuffer sb = new StringBuffer(str);
        String s = replaceSpace2(sb);
        System.out.println(s);
    }

}
