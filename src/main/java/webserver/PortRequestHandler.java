package webserver;

import webserver.headers.HeadersKey;
import webserver.headers.HeadersValue;
import webserver.request.HttpRequestHandler;
import webserver.response.HttpResponse;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class PortRequestHandler {
    private String COLON = ": ";

    public void startListener(List<ServerSocket> socketList) {
        for (ServerSocket socket : socketList) {
            listen(socket);
        }
    }

    private void listen(ServerSocket serverSocket) {
        try {
            startThread(serverSocket);

        } catch (Exception e) {
            System.out.println("error in port accept PortRequestHandler::listen  " + e.getMessage());

        }
    }

    private void startThread(ServerSocket serverSocket) {
        Runnable task = new Runnable() {
            public void run() {
                Socket connection;
                try {
                    while (true) {
                        connection = serverSocket.accept();
                        sendToOutputStream(connection);
                        connection.shutdownOutput();

                    }
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        };
        new Thread(task).start();
    }

    private HttpResponse handleRequest(Socket connection) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        List<String> parseString = new ArrayList<>();
        String line;
        HttpResponse response = null;
        ParseHttpRequest parser = new ParseHttpRequest();
        HttpRequestHandler requestHandler = new HttpRequestHandler();
        while ((line = bf.readLine()) != null && !line.isEmpty()) {
            parseString.add(line);
        }
        if (!parseString.isEmpty()) {
            response = requestHandler.processRequest(parser.parsePlainRequest(parseString));
        }

        return response;
    }

    private void sendToOutputStream(Socket connection) throws IOException {

        try {
            HttpResponse response = handleRequest(connection);
            String finalResposne = DefaultResponse.HTTPPROTOCOL + getHttpCode(response) + getHeaders(response);
            System.out.println(finalResposne);
            connection.getOutputStream().write(((DefaultResponse.HTTPPROTOCOL
                    + getHttpCode(response)
                    + getHeaders(response)).getBytes()));
            connection.getOutputStream().write(getBody(response));
        } catch (Exception e) {
            System.out.println("some error :: " + e.getMessage());
        }

        System.out.println("connection ::" + connection.getPort() + " " + Thread.currentThread().getName());
    }

    private String getHttpCode(HttpResponse response) {
        if (response.getHttpStatus() == null) {
            return ResponseHttpStatus.INTERNAL_SERVER_ERROR + System.lineSeparator();
        }
        return response.getHttpStatus().toString() + System.lineSeparator();
    }

    private String getHeaders(HttpResponse response) {
        String headers = HeadersKey.CONTENT_TYPE + COLON;
        if (response.getBody().getFile() != null) {
            headers = headers + HeadersValue.HTML;
        } else headers = headers + HeadersValue.TEXT;

        headers += System.lineSeparator() + System.lineSeparator();
        return headers;
    }

    private byte[] getBody(HttpResponse response) throws IOException {
        byte[] responseBody;
        if (response.getBody().getFile() != null)
            responseBody = Files.readAllBytes(response.getBody().getFile().toPath());
        else {
            responseBody = response.getBody().getBody().getBytes();
        }
        return responseBody;
    }


}
