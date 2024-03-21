package webserver;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.LinkedList;
import java.util.List;

public class MyWebServer {
    public static void main(String[] args) throws IOException {
        startApp();

    }

    public static void startApp() throws IOException {
        List<ServerSocket> socketList = new LinkedList<>();
        for (Port port : Port.values()) {
            socketList.add(new ServerSocket((port.getPortNo())));
        }
        PortRequestHandler handler = new PortRequestHandler();
        handler.startListener(socketList);
    }


}