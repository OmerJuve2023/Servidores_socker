package org.example.bonus1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class Thread1 implements Runnable {
    private final Socket socket;
    private final Server1 server1;

    public Thread1(Socket socket, Server1 server1) {
        this.socket = socket;
        this.server1 = server1;
    }

    @Override
    public void run() {
        try {
            int CLIENT_NUMBER = server1.getCLIENT_NUMBER();
            System.out.println("Cliente conectado por : " + CLIENT_NUMBER + " vez");

            BufferedReader in_socket = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out_socket = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);
            String message = "message";

            while (!(message.equalsIgnoreCase("exit"))) {
                message = in_socket.readLine();
                out_socket.println(message.toUpperCase());
            }
            socket.close();
            System.out.println("Cliente se desconecto");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
