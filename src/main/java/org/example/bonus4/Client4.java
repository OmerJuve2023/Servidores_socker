package org.example.bonus4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client4 {
    public Client4() throws Exception {
        Socket var1 = new Socket("127.0.0.1", 2020);
        System.out.println("conexiÃ³n establecida");
        BufferedReader var2 = new BufferedReader(new InputStreamReader(var1.getInputStream()));
        PrintWriter var3 = new PrintWriter(new OutputStreamWriter(var1.getOutputStream()), true);
        Scanner var4 = new Scanner(System.in);
        String var5 = var2.readLine();
        System.out.println("SERVIDOR: " + var5);
        String var6 = var4.nextLine();
        var3.println(var6);
        String var8 = "USUARIO: " + var6;

        while(true) {
            var5 = var2.readLine();
            if (!var5.startsWith("ADIVINE")) {
                if (var5.startsWith(var8)) {
                    System.out.println("ADIVINASTE EL NUMERO");
                    var1.close();
                    System.out.println("SE CERRO LA PUERTA");
                } else {
                    System.out.println(var5);
                    var1.close();
                    System.out.println("SE CERRO LA PUERTA");
                }

                return;
            }

            System.out.println("SERVIDOR: ADIVINE UN NUMERO [1-20]");
            String var7 = var4.nextLine();
            var3.println(var7);
        }
    }

    public static void main(String[] var0) {
        try {
            new Client4();
        } catch (Exception var2) {
            var2.printStackTrace();
        }

    }
}