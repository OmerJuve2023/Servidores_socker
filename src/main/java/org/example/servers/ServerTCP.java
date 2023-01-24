package org.example.servers;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerTCP {

    private int NUMBER_CLIENT = 1;

    public ServerTCP() throws IOException {
        ServerSocket serverSocket = new ServerSocket(2020);
        System.out.println("Port 2020 open");
        while (true) {
            Socket socket = serverSocket.accept();
            ServerThread serverThread = new ServerThread(socket, this);
            Thread thread = new Thread(serverThread);
            thread.start();
        }
    }

    public int getNUMBER_CLIENT() {
        return NUMBER_CLIENT++;
    }

    public static void main(String[] args) {
        try {
            new ServerTCP();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
