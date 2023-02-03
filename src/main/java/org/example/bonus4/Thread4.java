package org.example.bonus4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class Thread4 implements Runnable {
    private final Socket socket;
    private final Server4 server4;

    public Thread4(Socket socket, Server4 server4) {
        this.socket = socket;
        this.server4 = server4;
    }

    @Override
    public void run() {
        try {
            int CLIENT_NUMBER = server4.getCLIENT_NUMBER();
            System.out.println("CLIENTE CONECTADO POR " + CLIENT_NUMBER + " VEZ");
            BufferedReader inSocket = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter outSocket = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);

            String message;
            int SECRET_NUMBER = server4.getSECRET_NUMBER();

            outSocket.println("ESCRIBE TU NOMBRE: ");
            String username = inSocket.readLine();

            while (true) {
                outSocket.println("ADIVINE UN NUMERO [1-20]: ");
                message = inSocket.readLine();

                if ((Integer.parseInt(message) == SECRET_NUMBER) && (!server4.getADIVINA())) {
                    server4.setADIVINA();
                    server4.setUSER(username);
                    outSocket.println("USUARIO:" + server4.getUSER().toUpperCase() + " HAS ADIVINADO EL NUMERO");
                    System.out.println("USUARUI: " + server4.getUSER().toUpperCase() + " HA ADIVINADO ESTE NUMERO");
                    socket.close();
                    System.out.println("CLIENTE SE DESCONECTO");
                    break;
                } else if ((Integer.parseInt(message) == SECRET_NUMBER) && (server4.getADIVINA())) {
                    outSocket.println("USUARIO: " + server4.getUSER().toUpperCase() + " YA HA ADIVINADO EL NUMERO");
                    socket.close();
                    System.out.println("CLIENTE SE DESCONECTO");
                    break;
                } else if (server4.getADIVINA()) {
                    outSocket.println("USUARIO: " + server4.getUSER().toUpperCase() + " YA HA ADIVINADO ESTE NUMERO");
                    socket.close();
                    System.out.println("CLIENTE SE DESCONECTO");
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
