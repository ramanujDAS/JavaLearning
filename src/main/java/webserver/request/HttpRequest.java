package webserver.request;

import webserver.HttpBody;
import webserver.RequestMethod;

public class HttpRequest {
    protected RequestMethod method;
    protected HttpBody requestBody;

    public RequestMethod getMethod() {
        return method;
    }

    public void setMethod(RequestMethod method) {
        this.method = method;
    }

    public HttpBody getRequestBody() {
        return requestBody;
    }

    public void setRequestBody(HttpBody requestBody) {
        this.requestBody = requestBody;
    }
}
