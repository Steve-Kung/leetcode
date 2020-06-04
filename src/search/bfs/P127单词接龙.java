package search.bfs;

import javafx.util.Pair;

import java.util.*;

/*
给定两个单词（beginWord 和 endWord）和一个字典，
找到从 beginWord 到 endWord 的最短转换序列的长度。转换需遵循如下规则：

每次转换只能改变一个字母。
转换过程中的中间单词必须是字典中的单词。
说明:

如果不存在这样的转换序列，返回 0。
所有单词具有相同的长度。
所有单词只由小写字母组成。
字典中不存在重复的单词。
你可以假设 beginWord 和 endWord 是非空的，且二者不相同。
示例 1:

输入:
beginWord = "hit",
endWord = "cog",
wordList = ["hot","dot","dog","lot","log","cog"]

输出: 5

解释: 一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog",
     返回它的长度 5。
 */
public class P127单词接龙 {


    private int L;
    private Map<String, List<String>> allComboDict;

    P127单词接龙() {
        this.L = 0;

        // Dictionary to hold combination of words that can be formed,
        // from any given word. By changing one letter at a time.
        this.allComboDict = new HashMap<>();
    }

    private int visitWordNode(
            Queue<Pair<String, Integer>> Q,
            Map<String, Integer> visited,
            Map<String, Integer> othersVisited) {

        Pair<String, Integer> node = Q.remove();
        String word = node.getKey();
        int level = node.getValue();

        for (int i = 0; i < this.L; i++) {

            // 当前词的通配词
            String newWord = word.substring(0, i) + '*' + word.substring(i + 1, L);

            // 拥有相同通配词的词
            for (String adjacentWord : this.allComboDict.getOrDefault(newWord, new ArrayList<>())) {
                // 找到目标词汇 返回结果
                if (othersVisited.containsKey(adjacentWord)) {
                    return level + othersVisited.get(adjacentWord);
                }

                if (!visited.containsKey(adjacentWord)) {

                    // 添加新的数据
                    visited.put(adjacentWord, level + 1);
                    Q.add(new Pair(adjacentWord, level + 1));
                }
            }
        }
        return -1;
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        if (!wordList.contains(endWord)) {
            return 0;
        }

        // 词汇长度一致
        this.L = beginWord.length();

        wordList.forEach(
                word -> {
                    for (int i = 0; i < L; i++) {
                        // 键 是通用词
                        // 值 是对应的词汇
                        String newWord = word.substring(0, i) + '*' + word.substring(i + 1, L);
                        List<String> transformations =
                                this.allComboDict.getOrDefault(newWord, new ArrayList<>());
                        transformations.add(word);
                        this.allComboDict.put(newWord, transformations);
                    }
                });

        // Queues for 双向 BFS
        // BFS starting from beginWord 开始词
        Queue<Pair<String, Integer>> Q_begin = new LinkedList<>();
        // BFS starting from endWord 结束词
        Queue<Pair<String, Integer>> Q_end = new LinkedList<>();
        Q_begin.add(new Pair(beginWord, 1));
        Q_end.add(new Pair(endWord, 1));

        // 避免重复访问
        Map<String, Integer> visitedBegin = new HashMap<>();
        Map<String, Integer> visitedEnd = new HashMap<>();
        visitedBegin.put(beginWord, 1);
        visitedEnd.put(endWord, 1);

        // 双向搜索的结束条件是找到一个单词被两边搜索都访问过了。
        while (!Q_begin.isEmpty() && !Q_end.isEmpty()) {

            // One hop from begin word
            int ans = visitWordNode(Q_begin, visitedBegin, visitedEnd);
            if (ans > -1) {
                return ans;
            }

            // One hop from end word
            ans = visitWordNode(Q_end, visitedEnd, visitedBegin);
            if (ans > -1) {
                return ans;
            }
        }

        return 0;
    }


    public int ladderLength0(String beginword, String endword, List<String> wordList){
        // 前期准备
        int len= beginword.length();
        Map<String, List<String>> map = new HashMap<>();
        for (String word : wordList) {
            for (int i=0; i< len; i++){
                String newWord = word.substring(0, i) + "*" + word.substring(i+1, len);
                List<String> value = map.getOrDefault(newWord, new ArrayList<>());
                value.add(word);
                map.put(newWord, value);
            }
        }
        // 队列
        Queue<Pair<String, Integer>> queue = new LinkedList<>();
        queue.add(new Pair<>(beginword, 1));
        //记录，防止重复访问
        Map<String, Boolean> visited = new HashMap<>();
        visited.put(beginword, true);
        while (!queue.isEmpty()){
            Pair<String, Integer> pair = queue.poll();
            String word = pair.getKey();
            int level = pair.getValue();
            for (int i = 0; i < len; i++){
                String newWord = word.substring(0, i) + "*" + word.substring(i+1, len);
                List<String> words = map.getOrDefault(newWord, new ArrayList<>());
                for (String wordItem : words) {
                    if (wordItem.equals(endword)){
                        return level + 1;
                    }
                    else if (!visited.containsKey(wordItem)){
                        queue.offer(new Pair<>(wordItem, level + 1));
                        visited.put(wordItem, true);
                    }
                }
            }
        }
        return 0;
    }






    public int ladderLength1(String beginWord, String endWord, List<String> wordList) {
        // 所有单词同样长度
        int L = beginWord.length();
        // 从任何给定的单词. 一次改变一个字母.包含任何可能结果的字典
        Map<String, List<String>> allComboDict = new HashMap<>();
        wordList.forEach(
                word -> {
                    for (int i = 0; i < L; i++) {
                        // 键是通用单词
                        // 值是可能的单词集合
                        String newWord = word.substring(0, i) + '*' + word.substring(i + 1, L);
                        List<String> transformations = allComboDict.getOrDefault(newWord, new ArrayList<>());
                        transformations.add(word);
                        allComboDict.put(newWord, transformations);
                    }
                });

        // BFS队列
        Queue<Pair<String, Integer>> Q = new LinkedList<>();
        Q.add(new Pair(beginWord, 1));
        //记录，防止重复访问
        Map<String, Boolean> visited = new HashMap<>();
        visited.put(beginWord, true);
        while (!Q.isEmpty()) {
            Pair<String, Integer> node = Q.remove();
            String word = node.getKey();
            int level = node.getValue();
            for (int i = 0; i < L; i++) {

                // 当前词的中间词
                String newWord = word.substring(0, i) + '*' + word.substring(i + 1, L);

                // 拥有当前中间词的其他词
                for (String adjacentWord : allComboDict.getOrDefault(newWord, new ArrayList<>())) {
                    //找到我们的目标词汇，返回结果
                    if (adjacentWord.equals(endWord)) {
                        return level + 1;
                    }
                    // 否则添加到队列，并标记为已访问
                    if (!visited.containsKey(adjacentWord)) {
                        visited.put(adjacentWord, true);
                        Q.add(new Pair(adjacentWord, level + 1));
                    }
                }
            }
        }

        return 0;
    }
}
