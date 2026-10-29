package org.example.Visualizador;

public class Visualizador {
    public static void main(String[] args) {

        // COmprobamos si no hay cadena o viene vacía
        if (args.length < 1 || args[0].isEmpty()) {
            System.out.println("Cadena introducida vacía");
            System.exit(1);
        }

        String cadena = args[0];
        int veces = 5; // por defecto como en el ejemplo

        // si nos pasan el segundo argumento, lo usamos
        if (args.length >= 2) {
            veces = Integer.parseInt(args[1]);
        }

        // hacemos un bucle for que lo imprima
        for (int i = 1; i <= veces; i++) {
            System.out.println(i + ". " + cadena);
        }

        System.exit(0);
    }
}
