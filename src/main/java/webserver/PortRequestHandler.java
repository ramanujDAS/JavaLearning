package webserver;

import webserver.request.HttpRequest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;
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
                        handleRequest(connection);
                        connection.getOutputStream().write(DefaultResponse.defaultResponse.getBytes());
                        connection.shutdownOutput();

                    }
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        };
        new Thread(task).start();
    }

    private void handleRequest(Socket connection) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        //  int read;

        List<String> parseString = new ArrayList<>();
        String line;

        while ((line = bf.readLine()) != null && !line.isEmpty()) {
            parseString.add(line);
        }
        if (!parseString.isEmpty()) {
            ParseHttpRequest parser = new ParseHttpRequest();
            parser.parsePlainRequest(parseString);
        }
        System.out.println("connection ::" + connection.getPort() + " " + Thread.currentThread().getName());
    }

    private void processLine(String str) {
        String[] parts = str.split(" ");


        System.out.println("method ::" + Arrays.toString(parts));
    }

    private void processHeaders(String str) {
        String[] parts = str.split(" ");
        System.out.println("headers ::" + Arrays.toString(parts));
    }

    private void processMethod(String[] parts) {
        HttpRequest request = new HttpRequest();
    }
}
