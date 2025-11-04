package org.example;
import java.io.IOException;
import java.net.Socket;

import java.util.List;

public class EscaneoPuertos {

    private static final int timeout = 3000;
    public static boolean puertoAbierto(String host, int port) {
        try (Socket socket = new Socket()) {
            socket.connect(new java.net.InetSocketAddress(host, port), timeout);
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    public static void escanearYMostrar(String host, List<Integer> puertos) {
        System.out.println("\nESCANEANDO " + host + " EN LOS PUERTOS: " + puertos);
        for (int puerto : puertos) {
            System.out.print("PUERTO " + puerto + ": ");
            if (puertoAbierto(host, puerto)) {
                System.out.println("ABIERTO");
            } else {
                System.out.println("CERRADO/NO ACCESIBLE");
            }
        }
    }
}