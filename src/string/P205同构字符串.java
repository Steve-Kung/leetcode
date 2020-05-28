package string;

import java.util.Arrays;
import java.util.HashMap;

public class P205同构字符串 {
    // 判断s字符串到t字符串的字母映射关系
    // 双向单映射
    public boolean isIsomorphic(String s, String t) {
        return isIsomorphicHelper(s, t) && isIsomorphicHelper(t, s);
    }

    private boolean isIsomorphicHelper(String s, String t) {
        int len = s.length();
        HashMap<Character, Character> mapS = new HashMap<>();
        for (int i = 0; i< len; i++){
            char cs = s.charAt(i);
            char ct = t.charAt(i);
            if (!mapS.keySet().contains(cs)){
                mapS.put(cs, ct);
            } else {
                if (mapS.get(cs) != ct){
                    return false;
                }
            }
        }
        return true;
    }


    public boolean isIsomorphic1(String s, String t) {
        if (s == null && t == null){
            return true;
        }
        if (s == null || s == null){
            return false;
        }
        int len = s.length();
        int[] mapS = new int[128];
        int[] mapT = new int[128];
        for (int i = 0; i < len; i++) {
            char cs = s.charAt(i);
            char ct = t.charAt(i);
            // cs字符之前还未出现过
            if (mapS[cs] == 0){
                mapS[cs] = i + 1;
            }
            if (mapT[ct] == 0){
                mapT[ct] = i + 1;
            }
            if (mapS[cs] != 0){
                if (mapS[cs] != mapT[ct]){
                    return false;
                }
            }
        }
        return true;
    }

//    解法一 双向映射
//    // s->t    t-> s 双向映射才符合
//    public boolean isIsomorphic(String s, String t) {
//        return isIsomorphicHelper(s, t) && isIsomorphicHelper(t, s);
//
//    }
//
//    // 判断s字符串到t字符串的字母映射关系
//    private boolean isIsomorphicHelper(String s, String t) {
//        int n = s.length();
//        HashMap<Character, Character> map = new HashMap<>();
//        for (int i = 0; i < n; i++) {
//            char c1 = s.charAt(i);
//            char c2 = t.charAt(i);
//            if (map.containsKey(c1)) {
//                if (map.get(c1) != c2) {
//                    return false;
//                }
//            } else {
//                map.put(c1, c2);
//            }
//        }
//        return true;
//    }

//    解法二 翻译成第三种语言
//    public boolean isIsomorphic(String s, String t) {
//        int n = s.length();
//        int[] mapS = new int[128];
//        int[] mapT = new int[128];
//        for (int i = 0; i < n; i++) {
//            char c1 = s.charAt(i);
//            char c2 = t.charAt(i);
//            //当前的映射值是否相同
//            if (mapS[c1] != mapT[c2]) {
//                return false;
//            } else {
//                //是否已经修改过，修改过就不需要再处理
//                if (mapS[c1] == 0) {
//                    // 当前字母第一次出现,赋值
//                    mapS[c1] = i + 1;
//                    mapT[c2] = i + 1;
//                }
//            }
//        }
//        return true;
//    }

}
