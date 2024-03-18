package webserver;

import webserver.request.HttpRequest;

import java.io.IOException;
import java.util.Arrays;

public class ParseHttpRequest {

    public HttpRequest parsePlainRequest(StringBuilder sb) throws IOException {
        String requestLine;
        requestLine = sb.toString();
        // Split the request line into parts
        String[] parts = requestLine.split(" \r");
        System.out.println("array" + Arrays.toString(parts));
        // Get the HTTP method
//        String method = parts[0];
//
//        // Get the request URI
//        String uri = parts[1];
//
//        // Print the request method and URI
//        System.out.println("Method: " + method);
//        System.out.println("URI: " + uri);

//        // Read the request headers
//        String header;
//        while ((header = bufferedReader.readLine()) != null && header.length() != 0) {
//            System.out.println(header);
//        }
//
//        // Read the request body
//        String body = "";
//        while ((header = bufferedReader.readLine()) != null) {
//            body += header;
//        }
//
//        // Print the request body
//        System.out.println("Body: " + body);
//
//        // Close the socket


        return new HttpRequest();
    }
}
