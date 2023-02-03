package org.example.bonus4;

import java.net.ServerSocket;
import java.net.Socket;

public class Server4 {
    private int SECRET_NUMBER = (int) (Math.random() * 20 + 1);
    private boolean ADIVINA = false;
    private String USER;

    public Server4() throws Exception {
        ServerSocket serverSocket = new ServerSocket(2020);
        System.out.println("PUERTO 2020 ABIERTO");
        while (true) {
            Socket socket = serverSocket.accept();
            Thread4 thread4 = new Thread4(socket, this);
            Thread thread = new Thread(thread4);
            thread.start();
        }
    }

    public void setADIVINA() {
        this.ADIVINA = true;
    }

    public int getSECRET_NUMBER() {
        return SECRET_NUMBER;
    }

    public boolean getADIVINA() {
        return ADIVINA;
    }

    public void setUSER(String USER) {
        this.USER = USER;
    }

    public String getUSER() {
        return USER;
    }

    public static void main(String[] args) {
        try {
            new Server4();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
