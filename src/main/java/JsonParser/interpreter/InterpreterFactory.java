package JsonParser.interpreter;

import JsonParser.Token;
import JsonParser.exception.JsonFormatException;

public class InterpreterFactory {

    public DefaultInterpreterHandler getHandler(Token token) throws JsonFormatException {

        switch (token) {
            case CLOSE: {
                return new CloseHandler();
            }
            case OPEN: {
                return new OpenHandler();
            }
            case COMA: {
                return new ComaHandler();
            }
            case QUOTES: {
                return new QuotesHandler();
            }
            case COLON: {
                return new ColonHandler();
            }
            default:
                throw new JsonFormatException("wrong token");
        }
    }

}
