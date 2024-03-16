package JsonParser;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

public class TokenLex {

    private Reader reader;
    private File file;

    private List<TokenValue> tokenList;

    public TokenLex(File file) throws FileNotFoundException {
        this(new FileReader(file));
    }

    public TokenLex(Reader reader) {
        this.reader = reader;
        tokenList = new LinkedList<>();
    }

    public List<TokenValue> getTokenValueList() {

        return tokenList;
    }

    public TokenValue getNextToken() throws IOException {
        if (reader == null) {
            throw new FileNotFoundException("file not found");

        }
        if (tokenList.isEmpty()) {
            throw new FileNotFoundException("not token found");
        }

        int ch = getToken();
        if (ch < 0) return null;
        Character token = (char) ch;
        switch (ch) {
            case '{': {
                TokenValue tokenValue = new TokenValue(Token.OPEN);
                return tokenValue;
            }
            case '}': {
                TokenValue tokenValue = new TokenValue(Token.CLOSE);
                return tokenValue;
            }
            case ':': {
                TokenValue tokenValue = new TokenValue(Token.COLON);
                return tokenValue;
            }
            case '"': {

            }
            default:
                throw new IOException("invalid charactor");
        }

    }

    public String peekNextToken() {

        return "";
    }

    private int getToken() throws IOException {
        int ch = reader.read();
        return ch;
    }

    private String readString() {
        return "";
    }

    public static class TokenValue {
        public final Token token;
        public final Object value;

        public TokenValue(Token token) {
            this(token, null);
        }

        public TokenValue(Token token, Object value) {
            this.token = token;
            this.value = value;
        }
    }
}
