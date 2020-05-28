package sort;

import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Set;

/*
给定一个字符串，请将字符串里的字符按照出现的频率降序排列。
示例 1:
输入:
"tree"
输出:
"eert"
解释:
'e'出现两次，'r'和't'都只出现一次。
因此'e'必须出现在'r'和't'之前。此外，"eetr"也是一个有效的答案。

 */
public class P451根据字符出现频率排序 {
    public String frequencySort0(String s) {
        int[] letters = new int[128];
        for (char c : s.toCharArray()) {
            letters[c]++;
        }
        // 大顶堆
        PriorityQueue<Character> heap = new PriorityQueue<>(128, (a, b) -> Integer.compare(letters[b], letters[a]));
        StringBuilder res = new StringBuilder();

        for (int i = 0; i < letters.length; ++i) {
            if (letters[i] != 0) heap.offer((char)i);
        }

        while (!heap.isEmpty()) {
            char c = heap.poll();
            while (letters[c]-- > 0)
                res.append(c);
        }
        return res.toString();
    }

    public String frequencySort(String s) {
        char[] chars = s.toCharArray();
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : chars) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        PriorityQueue<Character> maxHeap = new PriorityQueue<>((a, b) -> map.get(b) - map.get(a));
        Set<Character> keySet = map.keySet();
        for (Character character : keySet) {
            maxHeap.add(character);
        }
        StringBuilder sb = new StringBuilder();
        while (!maxHeap.isEmpty()){
            Character poll = maxHeap.poll();
            for (int i = 0; i < map.get(poll); i++){
                sb.append(poll);
            }
        }
        return sb.toString();
    }
}
