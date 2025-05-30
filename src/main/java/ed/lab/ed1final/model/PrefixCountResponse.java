package ed.lab.ed1final.model;

public class PrefixCountResponse {
    private String prefix;
    private int prefixesCount;

    public PrefixCountResponse() {}

    public PrefixCountResponse(String prefix, int prefixesCount) {
        this.prefix = prefix;
        this.prefixesCount = prefixesCount;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public int getPrefixesCount() {
        return prefixesCount;
    }

    public void setPrefixesCount(int prefixesCount) {
        this.prefixesCount = prefixesCount;
    }
}
