package org.example.servers;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public Server() throws Exception {

        ServerSocket serverSocket = new ServerSocket(2020);
        System.out.println("Port 2020 esta abierto");
        Socket socket = serverSocket.accept();

        System.out.println("Cliente " + socket.getInetAddress() + " esta conectado");
        BufferedReader in_socket = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out_socket = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);
        String message;

        int secret_number = (int) (Math.random() * 10 + 1);
        do {
            out_socket.println("Guess un número [1-10]: ");
            message = in_socket.readLine();
        } while (!(Integer.parseInt(message) == secret_number));

        out_socket.println("Adivinaste!!");
        System.out.println("El número secreto esta fuera. Existe en la aplicación");

        socket.close();
        System.out.println("el cliente se desconecto");
    }

    public static void main(String[] args) {
        try {
            new Server();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
