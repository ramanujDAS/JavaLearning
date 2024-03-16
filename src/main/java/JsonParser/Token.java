package JsonParser;

public enum Token {
    OPEN("{"), CLOSE("}"), QUOTES("\""), COMA(","), WHITESPACE(""), COLON(":");

    private String symbol;

    private Token(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }
}
