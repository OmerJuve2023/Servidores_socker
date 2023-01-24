package org.example.clients;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ClientTCP {
    public ClientTCP() throws Exception {
        Socket socket = new Socket("127.0.0.1", 2020);
        System.out.println("Successful connection!!");

        BufferedReader in_socket = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out_socket = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()),true);
        Scanner keyboard = new Scanner(System.in);
        String message = in_socket.readLine();
        System.out.println("Servidor:\t" + message);
        message = keyboard.nextLine();
        out_socket.println(message);

        socket.close();
        System.out.println("Socket Cerrado desde Cliente");
    }

    public static void main(String[] args) {
        try {
            new ClientTCP();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
