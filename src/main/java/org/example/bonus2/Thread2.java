package org.example.bonus2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class Thread2 implements Runnable {
    private final Socket socket;
    private final Server2 server2;

    public Thread2(Socket socket, Server2 server2) {
        this.socket = socket;
        this.server2 = server2;
    }

    @Override
    public void run() {
        try {

            int CLIENT_NUMBER = server2.getCLIENT_NUMBER();
            System.out.println("Cliente conectado por " + CLIENT_NUMBER + " vez");
            BufferedReader in_socket = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out_socket = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);
            String message = "message";
            String backwards = "message";

            while (!(message.equalsIgnoreCase("salir"))) {
                message = in_socket.readLine();
                out_socket.println(backwards = new StringBuffer(message).reverse().toString());
            }

            socket.close();
            System.out.println("Cliente se desconecto");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
