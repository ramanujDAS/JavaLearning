package io.javabrains.reactiveworkshop;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class TaskExecutionWebServer {
    private static final int NTHREADS = 50;

    private static final Executor exec
            = Executors.newFixedThreadPool(10);

    public static void main(String[] args) throws IOException {
        TaskExecutionWebServer taskExecutionWebServer = new TaskExecutionWebServer();
        ServerSocket socket = new ServerSocket(80);
        while (true) {
            Socket connection = socket.accept();
            Runnable task = new Runnable() {
                public void run() {
                    try {
                        taskExecutionWebServer.handleRequest(connection);
                        connection.getOutputStream().write(("HTTP/1.1 412  OK\r\n" + "Content-Type: text/html\r\n\r\n" + "<html><head></head><body><h1>Hello</h1></body></html>").getBytes());

                        connection.shutdownOutput();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            };
            exec.execute(task);
        }
    }

    public void handleRequest(Socket connection) throws InterruptedException {

        int x = 0;
        Thread.sleep(1000);
        System.out.println(" socket  : " + connection.toString() + " thread : " + Thread.currentThread().getName());
        System.out.println("handle request finished : value " + ++x);
    }
}


