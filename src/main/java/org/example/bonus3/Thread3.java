package org.example.bonus3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class Thread3 implements Runnable {
    private final Socket socket;
    private Server3 server3;

    public Thread3(Socket socket, Server3 server3) {
        this.socket = socket;
        this.server3 = server3;
    }

    @Override
    public void run() {
        try {
            int CLIENT_NUMBER = server3.getCLIENT_NUMBER();
            System.out.println("Conectado por " + CLIENT_NUMBER + " vez");
            BufferedReader inSocket = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter outSocket = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);
            String message;
            int SECRET_NUMBER = (int) (Math.random() * 20 + 1);
            do {
                outSocket.println("ESCRIBE UN NUMERO [1-20]");
                message = inSocket.readLine();
            } while (!(Integer.parseInt(message) == SECRET_NUMBER));
            outSocket.println("Acertaste");
            socket.close();
            System.out.println("Se desconecto el cliente");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
