package org.example.bonus1;

import java.net.ServerSocket;
import java.net.Socket;

public class Server1 {
    private int CLIENT_NUMBER = 1;

    public Server1() throws Exception {
        ServerSocket serverSocket = new ServerSocket(2020);
        System.out.println("Puerto abierto");

        while (true) {
            Socket socket = serverSocket.accept();
            Thread1 server1 = new Thread1(socket, this);
            Thread thread1 = new Thread(server1);
            thread1.start();
        }
    }

    public int getCLIENT_NUMBER() {
        return CLIENT_NUMBER;
    }

    public static void main(String[] args) {
        try {
            new Server1();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
