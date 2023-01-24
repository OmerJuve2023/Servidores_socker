package org.example.bonus1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client1 {
    public Client1() throws Exception {
        Socket socket = new Socket("127.0.0.1", 2020);
        System.out.println("conexión con exito");

        BufferedReader in_socket = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out_socket = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);
        Scanner keyboard = new Scanner(System.in);

        String message = "message";
        System.out.println("para salir escriba exit");

        while (!(message.equalsIgnoreCase("exit"))) {
            System.out.println("escriba");
            message = keyboard.nextLine();
            out_socket.println(message);
            message = in_socket.readLine();
            System.out.println(message);
        }
        socket.close();
        System.out.println("Socket cerrado");
    }

    public static void main(String[] args) {
        try {
            new Client1();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
