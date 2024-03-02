package JsonParser.model;

import JsonParser.Token;

import java.io.File;
import java.io.Reader;

public class TokenLex {

    private Reader reader;
    private File file;

    public TokenLex(File file) {
        //read file throgh here call function
        this.file = file;
    }

    public TokenLex(Reader reader) {
        this.reader = reader;
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
