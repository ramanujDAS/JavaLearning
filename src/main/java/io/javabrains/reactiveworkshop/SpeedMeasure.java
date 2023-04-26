package io.javabrains.reactiveworkshop;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SpeedMeasure {

    public static void main(String[] args) throws InterruptedException, IOException {

        Long sum = 0L;
        Thread.sleep(5000);
        long startTime = System.currentTimeMillis();
        for (long i = 0; i <= Integer.MAX_VALUE; i++)
            sum += i;

        long total = (System.currentTimeMillis() - startTime) / 1000;

        System.out.println(sum + " time :" + total);

        ServerSocket socket = new ServerSocket(80);
        final Socket connection = socket.accept();

    }
}
