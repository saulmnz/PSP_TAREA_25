# TAREA 25 PSP 👀


> **Esta tarea consta de dos clases, la clase Main, se encargará de ejecutar el programa y la clase EscaneoPuertos, la cual contiene los métodos que necesita la Main para llevar a cabo el las tareas solicitadas en el enunciado. 💣💣** 

---

```java
public class EscaneoPuertos {

    private static final int TIMEOUT_MS = 3000; // 2 segundos

    /**
     * COMPRUEBA SI UN PUERTO ESTÁ ABIERTO SEGÚN EL HOST INDICADO
     * 
     * @param host DIRECCIÓN IP O NOMBRE DEL HOST
     * @param port NÚMERO DEL PUERTO
     * @return TRUE SI EL PUERTO SE ENCUENTRA ABIERTO, FALSE EN EL CASO CONTRARIO
     */
    private static final int timeout = 3000;
    public static boolean puertoAbierto(String host, int port) {
        try (Socket socket = new Socket()) {
            socket.connect(new java.net.InetSocketAddress(host, port), timeout);
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    /**
     * ESCANEA UNA LISTA DE PUERTOS Y MUESTRA EL RESULTADO POR PANTALLA
     * 
     * @param host    DIRECCIÓN IP O NOMBRE DEL HOST
     * @param puertos LISTA DE PUERTOS A ESCANEAR
     */
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
```
