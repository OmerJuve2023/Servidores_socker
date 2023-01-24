package org.example.bonus2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client2 {
    public Client2() throws Exception {
        Socket socket = new Socket("127.0.0.1", 2020);
        System.out.println("Cliente conectado exitosamente");

        BufferedReader in_socket = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out_socket = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);
        Scanner keyboard = new Scanner(System.in);

        String message = "message";
        System.out.println("escriba salir para finalizar");
        while (!(message.equalsIgnoreCase("rilas"))) {
            System.out.println("Cliente:");
            message = keyboard.nextLine();
            out_socket.println(message);
            message = in_socket.readLine();
            System.out.println("Cliente: " + message);
        }
        socket.close();
        System.out.println("Se cerro sesión");
    }

    public static void main(String[] args) {
        try {
            new Client2();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
