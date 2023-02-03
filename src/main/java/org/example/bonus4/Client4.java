package org.example.bonus4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client4 {

    public Client4() throws Exception {
        Socket socket = new Socket("127.0.0.1", 2020);
        System.out.println("conexión establecida");

        BufferedReader inSocket = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter outSocket = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);
        Scanner scanner = new Scanner(System.in);

        String message;
        String user;
        String USER_NUMBER;

        message = inSocket.readLine();
        System.out.println("SERVIDOR: " + message);
        user = scanner.nextLine();
        outSocket.println(user);

        String WINNING_MESSAGE = "USUARIO: " + user;

        while (true) {
            message = inSocket.readLine();

            if (message.startsWith("ADIVINE")) {
                System.out.println("SERVIDOR: ADIVINE UN NUMERO [1-20]");
                USER_NUMBER = scanner.nextLine();
                outSocket.println(USER_NUMBER);
            } else if (message.startsWith(WINNING_MESSAGE)) {
                System.out.println("ADIVINASTE EL NUMERO");
                socket.close();
                System.out.println("SE CERRO LA PUERTA");
                break;
            } else {
                System.out.println(message);
                socket.close();
                System.out.println("SE CERRO LA PUERTA");
                break;
            }
        }
    }

    public static void main(String[] args) {
        try {
            new Client4();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
