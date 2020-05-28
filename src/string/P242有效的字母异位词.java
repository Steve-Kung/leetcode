package string;

import java.util.HashMap;

public class P242有效的字母异位词 {
    public boolean isAnagram(String s, String t) {
        if (s == null && t == null){
            return true;
        }
        if (s == null){
            return false;
        }
        HashMap<Character, Integer> map = new HashMap<>();
        for (Character c : s.toCharArray() ){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (Character c : t.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) - 1);
        }
        for (Character c : map.keySet()){
            if (map.get(c) != 0){
                return false;
            }
        }
        return true;
    }
}
