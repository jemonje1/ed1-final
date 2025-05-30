package ed.lab.ed1final.model;

public class PrefixCountResponse {
    private String word;
    private int wordsStartingWith;

    public PrefixCountResponse() {}

    public PrefixCountResponse(String word, int wordsStartingWith) {
        this.word = word;
        this.wordsStartingWith = wordsStartingWith;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public int getWordsStartingWith() {
        return wordsStartingWith;
    }

    public void setWordsStartingWith(int wordsStartingWith) {
        this.wordsStartingWith = wordsStartingWith;
    }
}
