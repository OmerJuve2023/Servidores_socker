package org.example.bonus3;

import java.net.ServerSocket;
import java.net.Socket;

public class Server3 {
    private int CLIENT_NUMBER = 1;

    public Server3() throws Exception {

        ServerSocket serverSocket = new ServerSocket(2020);
        System.out.println("Puerto 2020 abierto");
        while (true) {
            Socket socket = serverSocket.accept();
            Thread3 thread3 = new Thread3(socket, this);
            Thread thread = new Thread(thread3);
            thread.start();
        }
    }

    public int getCLIENT_NUMBER() {
        return CLIENT_NUMBER++;
    }

    public static void main(String[] args) {
        try {
            new Server3();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
