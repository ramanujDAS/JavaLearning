package webserver;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
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
        Runnable task = () -> {
            Socket connection;
            try {
                serverSocket.setReuseAddress(true);
                while (true) {
                    connection = serverSocket.accept();
                    ClientHandler handler = new ClientHandler(connection);
                    new Thread(handler).start();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        };
        new Thread(task).start();
    }


}
