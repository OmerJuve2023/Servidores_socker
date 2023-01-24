package org.example.servers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class
ServerThread implements Runnable {
    private final Socket socket;
    private final ServerTCP serverTCP;

    public ServerThread(Socket socket, ServerTCP serverTCP) {
        this.socket = socket;
        this.serverTCP = serverTCP;
    }

    @Override
    public void run() {
        try {
            int CLIENT_NUMBER = serverTCP.getNUMBER_CLIENT();

            System.out.println("numero de conexiones: " + CLIENT_NUMBER);
            BufferedReader in_socket = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out_Socket = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);

            out_Socket.println("Welcome! What's your name?");
            String message = in_socket.readLine();
            System.out.println("Cliente: " + message);

            socket.close();
            System.out.println(message + " se desconecto.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
