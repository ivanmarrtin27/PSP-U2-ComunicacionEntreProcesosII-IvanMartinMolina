package org.example.Aleatorios;

import java.io.*;
import org.iesalandalus.programacion.utilidades.Entrada;

public class GeneraAleatorios {
    public static void main(String[] args) {
        // Siempre es lo mismo try/catch y la diireccion de ProcessBuilder con la ruta
        try {
            ProcessBuilder pb = new ProcessBuilder(
                    "java", "-cp",
                    System.getProperty("java.class.path"),
                    "org.example.Aleatorios.Aleatorios"); // "Carpeta.Archivo"(Hijo)
            Process proceso = pb.start();

            // escribirle al hijo
            BufferedWriter escribirAlHijo = new BufferedWriter(
                    new OutputStreamWriter(proceso.getOutputStream()));

            // lee lo que responde el hijo
            BufferedReader leerDelHijo = new BufferedReader(
                    new InputStreamReader(proceso.getInputStream()));

            while (true) {
                String texto = Entrada.cadena();

                if (texto.equalsIgnoreCase("fin")) { // si pone fin, paramos
                    escribirAlHijo.close();
                    proceso.destroy();
                    break;
                }

                // mandamos la línea
                escribirAlHijo.write(texto);
                escribirAlHijo.newLine();
                escribirAlHijo.flush(); // EL flush MUY IMPORTANTE

                String respuesta = leerDelHijo.readLine();
                System.out.println(respuesta);
            }

            leerDelHijo.close();

        } catch (IOException e) {
            System.out.println("Error... " + e.getMessage());
        }
    }
}
