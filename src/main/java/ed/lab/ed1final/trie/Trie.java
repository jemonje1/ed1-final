package ed.lab.ed1final.trie;

import org.springframework.stereotype.Component;

@Component
public class Trie {

    private final Node root;

    public Trie() {
        root = new Node();
    }

    public void insert(String word) {
        Node current = root;
        for (char c : word.toCharArray()) {
            int idx = c - 'a';
            if (current.children[idx] == null) {
                current.children[idx] = new Node();
            }
            current = current.children[idx];
            current.prefixCount++;
        }
        current.wordCount++;
    }

    public int countWordsEqualTo(String word) {
        Node current = root;
        for (char c : word.toCharArray()) {
            int idx = c - 'a';
            if (current.children[idx] == null) {
                return 0;
            }
            current = current.children[idx];
        }
        return current.wordCount;
    }

    public int countWordsStartingWith(String prefix) {
        Node current = root;
        for (char c : prefix.toCharArray()) {
            int idx = c - 'a';
            if (current.children[idx] == null) {
                return 0;
            }
            current = current.children[idx];
        }
        return current.prefixCount;
    }

    public void erase(String word) {
        if (!exists(word)) return;

        Node current = root;
        for (char c : word.toCharArray()) {
            int idx = c - 'a';
            Node next = current.children[idx];
            next.prefixCount--;
            current = next;
        }
        current.wordCount--;
    }

    public boolean exists(String word) {
        Node current = root;
        for (char c : word.toCharArray()) {
            int idx = c - 'a';
            if (current.children[idx] == null) {
                return false;
            }
            current = current.children[idx];
        }
        return current.wordCount > 0;
    }

    private static class Node {
        public Node[] children;
        public int wordCount;
        public int prefixCount;

        public Node() {
            children = new Node[26];
            wordCount = 0;
            prefixCount = 0;
        }
    }
}
