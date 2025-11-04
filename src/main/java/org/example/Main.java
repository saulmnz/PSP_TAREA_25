package org.example;
import java.util.Scanner;
import java.util.Arrays;
import java.util.List;

public class Main {
    private static final List<Integer> puertos = Arrays.asList(21, 22, 80, 443);

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("INTRODUCE IP ('localhost') O  'salir' PARA TERMINAR: ");
            String entrada = scanner.nextLine().trim();

            if ("salir".equalsIgnoreCase(entrada)) {
                System.out.println("SALIENDOOO...");
                break;
            }

            if (entrada.isEmpty()) {
                System.out.println("NO METISTE NA, MÉTELE ALGO.");
                continue;
            }

            String host = entrada;

            System.out.print("¿QUIERES ESCANEAR LOS PUERTOS (21, 22, 80, 443)? (S/N): ");
            String respuesta = scanner.nextLine().trim().toLowerCase();

            if (respuesta.equals("s") || respuesta.equals("si")) {
                EscaneoPuertos.escanearYMostrar(host, puertos);
            } else {
                System.out.print("INTRODUCE EL PUERTO PERSONALIZADO: ");
                try {
                    int puertoPersonalizado = Integer.parseInt(scanner.nextLine().trim());
                    EscaneoPuertos.escanearYMostrar(host, Arrays.asList(puertoPersonalizado));
                } catch (NumberFormatException e) {
                    System.out.println("PUERTO INVÁLIDO.");
                }
            }
        }

        scanner.close();
    }
}