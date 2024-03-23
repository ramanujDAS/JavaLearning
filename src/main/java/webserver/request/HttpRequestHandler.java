package webserver.request;

import webserver.HttpBody;
import webserver.ResponseHttpStatus;
import webserver.request.method.IMethodExecutor;
import webserver.request.method.MethodFactory;
import webserver.response.HttpResponse;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class HttpRequestHandler implements IHttpRequestHandler {


    @Override
    public HttpResponse processRequest(HttpRequest request) {
        MethodFactory factory = MethodFactory.getInstance();
        HttpResponse response = null;
        IMethodExecutor methodExecutor = factory.getExecutor(request.getMethod());
        try {
            HttpBody body = methodExecutor.processRequest(request);
            response = HttpResponse.builder().body(body).status(ResponseHttpStatus.ACCEPTED).build();
        } catch (Exception e) {
            System.out.println("got some exception");
            response = HttpResponse.builder().status(ResponseHttpStatus.BAD_REQUEST).build();
            //set the proper response and httpCode
        }
        return response;
    }

    private boolean isActionValid(HttpRequest action) {


        return false;
    }

    private byte[] getByte(File file) throws IOException {
        return Files.readAllBytes(file.toPath());
    }
}
