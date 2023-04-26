package io.javabrains.reactiveworkshop;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TaskExecution_6_1Sequence {

    public static void main(String[] args) throws IOException, InterruptedException {
        int loopEnd = 10;
        TaskExecution_6_1Sequence obj = new TaskExecution_6_1Sequence();
        ServerSocket serverSocket = new ServerSocket(80);

        while (true) {
            //Sequentialyy request only main thread live
            Socket connection = serverSocket.accept();

            obj.handleRequest();
            System.out.println("current Active : " + Thread.activeCount() + " : " + loopEnd);
            connection.getOutputStream();
        }
        //obj.handleRequest();
    }

    public void handleRequest() throws InterruptedException {

        int x = 0;
        // System.out.println("handle request called");


        System.out.println("handle request finished : value " + ++x);
    }

    private void test() {

    }
}
