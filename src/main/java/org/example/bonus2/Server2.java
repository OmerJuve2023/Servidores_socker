package org.example.bonus2;

import java.net.ServerSocket;
import java.net.Socket;

public class Server2 {
    private int CLIENT_NUMBER = 1;

    public Server2() throws Exception {
        ServerSocket serverSocket = new ServerSocket(2020);
        System.out.println("puerto 2020 abierto");
        while (true) {
            Socket socket = serverSocket.accept();
            Thread2 thread2 = new Thread2(socket, this);
            Thread thread = new Thread(thread2);
            thread.start();
        }
    }

    public int getCLIENT_NUMBER() {
        return CLIENT_NUMBER++;
    }

    public static void main(String[] args) {
        try {
            new Server2();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
