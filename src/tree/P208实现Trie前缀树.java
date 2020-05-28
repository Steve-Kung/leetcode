package tree;

public class P208实现Trie前缀树 {

    class Trie {
        class TrieNode{
            boolean isEnd;
            TrieNode[] next;

            TrieNode(){
                this.isEnd = false;
                this.next = new TrieNode[26];
            }
        }
        TrieNode root;
        public Trie() {
            this.root = new TrieNode();
        }

        public void insert(String word) {
            TrieNode node = root;
            char[] chars = word.toCharArray();
            for (char c : chars) {
                if (node.next[c-'a'] == null){
                    node.next[c-'a'] = new TrieNode();
                }
                node = node.next[c-'a'];
            }
            node.isEnd = true;
        }


        public boolean search(String word) {
            TrieNode node = root;
            char[] chars = word.toCharArray();
            for (char c : chars) {
                if (node.next[c - 'a'] == null){
                    return false;
                }
                node = node.next[c - 'a'];
            }
            return node.isEnd;
        }

        public boolean startsWith(String prefix) {
            TrieNode node = root;
            char[] chars = prefix.toCharArray();
            for (char c : chars) {
                if (node.next[c - 'a'] == null){
                    return false;
                }
                node = node.next[c - 'a'];
            }
            return true;
        }
    }

}
