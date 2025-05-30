package ed.lab.ed1final.entity;

import com.fasterxml.jackson.annotation.JsonTypeId;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

public class TrieEntity {
    private long id;

    private TrieEntity[] children;
    private int wordCount;    //
    private int prefixCount;  //
    public TrieEntity() {
        children = new TrieEntity[26];
        wordCount = 0;
        prefixCount = 0;
    }

    public TrieEntity[] getChildren() {
        return children;
    }

    public void setChildren(TrieEntity[] children) {
        this.children = children;
    }

    public int getWordCount() {
        return wordCount;
    }

    public void setWordCount(int wordCount) {
        this.wordCount = wordCount;
    }

    public int getPrefixCount() {
        return prefixCount;
    }

    public void setPrefixCount(int prefixCount) {
        this.prefixCount = prefixCount;
    }
}
