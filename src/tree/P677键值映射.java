package tree;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 实现一个 MapSum 类里的两个方法，insert 和 sum。

 对于方法 insert，你将得到一对（字符串，整数）的键值对。字符串表示键，整数表示值。

 如果键已经存在，那么原来的键值对将被替代成新的键值对。

 对于方法 sum，你将得到一个表示前缀的字符串，你需要返回所有以该前缀开头的键的值的总和。

 */
public class P677键值映射 {
    // 字典树
    class MapSum {

        class TrieNode{
            int value;
            HashMap<Character, TrieNode> next;
            TrieNode(){
                this.value = 0;
                next = new HashMap<>();
            }
        }

        TrieNode root;

        public MapSum() {
            root = new TrieNode();
        }

        public void insert(String key, int val) {
            TrieNode node = root;
            char[] chars = key.toCharArray();
            for (char c : chars) {
                if (node.next.get(c) == null){
                    TrieNode trieNode = new TrieNode();
                    node.next.put(c, trieNode);
                }
                node = node.next.get(c);
            }
            node.value = val;
        }

        public int sum(String prefix) {
            TrieNode node = root;
            char[] chars = prefix.toCharArray();
            for (char c : chars) {
                if (node.next.get(c) == null){
                    return 0;
                }
                node = node.next.get(c);
            }
            return dfs(node);
        }

        private int dfs(TrieNode node) {
            int sum = 0;
            Set<Character> keySet = node.next.keySet();
            for (Character key : keySet) {
                sum += dfs(node.next.get(key));
            }
            return sum + node.value;
        }

    }



    class MapSum1 {
        // 哈希表
        HashMap<String, Integer> map;
        public MapSum1() {
            map = new HashMap<>();
        }

        public void insert(String key, int val) {
            map.put(key, val);
        }

        public int sum(String prefix) {
            Set<String> strings = map.keySet();
            int sum = 0;
            for (String string : strings) {
                if(string.indexOf(prefix) == 0){
                    sum += map.get(string);
                }
            }
            return sum;
        }
    }

}
