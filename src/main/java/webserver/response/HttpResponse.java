package webserver.response;

import webserver.HttpBody;
import webserver.ResponseHttpStatus;

public class HttpResponse {
    protected ResponseHttpStatus httpStatus;
    protected HttpBody body;

    public ResponseHttpStatus getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(ResponseHttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }

    public HttpBody getBody() {
        return body;
    }

    public void setBody(HttpBody body) {
        this.body = body;
    }
}
