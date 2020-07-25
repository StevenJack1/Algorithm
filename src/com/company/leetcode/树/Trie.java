package com.company.leetcode.树;

/**
 * 208. 实现 Trie (前缀树)
 * 实现一个 Trie (前缀树)，包含 insert, search, 和 startsWith 这三个操作。
 *
 * 示例:
 *
 * Trie trie = new Trie();
 *
 * trie.insert("apple");
 * trie.search("apple");   // 返回 true
 * trie.search("app");     // 返回 false
 * trie.startsWith("app"); // 返回 true
 * trie.insert("app");
 * trie.search("app");     // 返回 true
 * 说明:
 *
 * 你可以假设所有的输入都是由小写字母 a-z 构成的。
 * 保证所有输入均为非空字符串。
 */
public class Trie {
    Trie[] next = new Trie[26];
    boolean isEnd = false;

    public Trie() {
    }

    public void insert(String word) {
        Trie curr = this;
        for (char c : word.toCharArray()) {
            if (curr.next[c - 'a'] == null) {
                curr.next[c - 'a'] = new Trie();
            }
            curr = curr.next[c - 'a'];
        }
        curr.isEnd = true;
    }

    public boolean search(String word) {
        Trie curr = this;
        for (char c : word.toCharArray()) {
            if (curr.next[c - 'a'] == null) return false;
            curr = curr.next[c - 'a'];
        }
        return curr.isEnd;
    }

    public boolean startsWith(String prefix) {
        Trie curr = this;
        for (char c : prefix.toCharArray()) {
            if (curr.next[c - 'a'] == null) return false;
            curr = curr.next[c - 'a'];
        }
        return true;
    }
}
