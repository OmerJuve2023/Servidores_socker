package org.example.clients;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public Client() throws Exception {
        Socket socket = new Socket("127.0.0.1", 2020);
        System.out.println("conexión establecida con el servidor");

        BufferedReader in_socket = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out_socket = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);
        Scanner keyboard = new Scanner(System.in);
        String user_number;

        while ((in_socket.readLine().startsWith("Guess"))) {
            System.out.println("Servidor: Guess un numero [1-10]");
            user_number = keyboard.nextLine();
            out_socket.println(user_number);
        }

        System.out.println("Ya lo tienes!!");
        socket.close();
        System.out.println("cliente cerrado");
    }

    public static void main(String[] args) {
        try {
            new Client();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
