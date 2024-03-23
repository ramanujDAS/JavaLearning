package webserver;

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
        HttpResponse response = handleRequest(connection);

        connection.getOutputStream().write((Files.readAllBytes(response.getBody().getFile().toPath())));
        System.out.println("connection ::" + connection.getPort() + " " + Thread.currentThread().getName());
    }
}
