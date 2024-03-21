package webserver.request;

import webserver.HttpBody;

public interface IMethodExecutor {

    HttpBody processRequest(HttpBody body);


}
