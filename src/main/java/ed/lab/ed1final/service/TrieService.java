package ed.lab.ed1final.service;

import ed.lab.ed1final.entity.TrieEntity;
import org.springframework.stereotype.Service;

@Service
public class TrieService {

    private final TrieEntity root = new TrieEntity();

    public void insertWord(String word) {
        if (word == null || word.isEmpty()) {
            throw new IllegalArgumentException("No entregar nulos");
        }

        TrieEntity current = root;
        for (char c : word.toCharArray()) {
            int idx = c - 'a';
            if (idx < 0 || idx >= 26) {
                throw new IllegalArgumentException("No entregar nulos");
            }
            if (current.getChildren()[idx] == null) {
                current.getChildren()[idx] = new TrieEntity();
            }
            current = current.getChildren()[idx];
            current.setPrefixCount(current.getPrefixCount() + 1);
        }
        current.setWordCount(current.getWordCount() + 1);
    }

    public int countWordsEqualTo(String word) {
        if (word == null || word.isEmpty()) return 0;

        TrieEntity current = root;
        for (char c : word.toCharArray()) {
            int idx = c - 'a';
            if (idx < 0 || idx >= 26) return 0;
            if (current.getChildren()[idx] == null) return 0;
            current = current.getChildren()[idx];
        }
        return current.getWordCount();
    }

    public int countWordsStartingWith(String prefix) {
        if (prefix == null || prefix.isEmpty()) return 0;

        TrieEntity current = root;
        for (char c : prefix.toCharArray()) {
            int idx = c - 'a';
            if (idx < 0 || idx >= 26) return 0;
            if (current.getChildren()[idx] == null) return 0;
            current = current.getChildren()[idx];
        }
        return current.getPrefixCount();
    }

    public void erase(String word) {
        if (word == null || word.isEmpty()) return;
        if (!exists(word)) return;

        TrieEntity current = root;
        for (char c : word.toCharArray()) {
            int idx = c - 'a';
            TrieEntity next = current.getChildren()[idx];
            next.setPrefixCount(next.getPrefixCount() - 1);
            current = next;
        }
        current.setWordCount(current.getWordCount() - 1);
    }

    public boolean exists(String word) {
        if (word == null || word.isEmpty()) return false;

        TrieEntity current = root;
        for (char c : word.toCharArray()) {
            int idx = c - 'a';
            if (idx < 0 || idx >= 26) return false;
            if (current.getChildren()[idx] == null) return false;
            current = current.getChildren()[idx];
        }
        return current.getWordCount() > 0;
    }
}
