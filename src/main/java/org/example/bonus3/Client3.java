package org.example.bonus3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client3 {
    public Client3() throws Exception {
        Socket socket = new Socket("127.0.0.1", 2020);
        System.out.println("conexión exitosa");
        BufferedReader inSocket = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter outSocket = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);
        String USER_NUMBER;
        Scanner keyboard = new Scanner(System.in);
        while ((inSocket.readLine().startsWith("ESCRIBE"))) {
            System.out.println("SERVIDOR DICE: ESCRIBE UN NUMERO [1-20]");
            USER_NUMBER = keyboard.nextLine();
            outSocket.println(USER_NUMBER);
        }
        System.out.println("ACERTASTE");
        socket.close();
        System.out.println("puerta cerrada");
    }

    public static void main(String[] args) {
        try {
            new Client3();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
