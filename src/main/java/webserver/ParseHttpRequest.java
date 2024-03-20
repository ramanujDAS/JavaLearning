package webserver;

import webserver.request.HttpRequest;

import java.io.IOException;
import java.util.List;

public class ParseHttpRequest {

    public void parsePlainRequest(List<String> reqList) throws IOException {
        String requestLine;
        String[] httpParam = reqList.get(0).split(" ");
        // Split the request line into parts\
        String body = "";
        HttpRequest httpRequest = HttpRequest
                .builder()
                .method(RequestMethod.valueOf(httpParam[0]))
                .uri(httpParam[1])
                .body(new HttpBody(body))
                .build();

        System.out.println(httpRequest);


    }


}
