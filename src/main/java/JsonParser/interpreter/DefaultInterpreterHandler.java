package JsonParser.interpreter;

import java.util.Stack;

public abstract class DefaultInterpreterHandler {

    Stack<String> tokenStack;

    public DefaultInterpreterHandler() {
        tokenStack = new Stack<>();
    }

    public boolean isPreviousJsonElement() {


        return false;
    }


}
