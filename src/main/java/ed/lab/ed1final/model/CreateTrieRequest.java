package ed.lab.ed1final.model;

public class CreateTrieRequest {
    private String word;

    public CreateTrieRequest() {}

    public CreateTrieRequest(String word) {
        this.word = word;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }
}
