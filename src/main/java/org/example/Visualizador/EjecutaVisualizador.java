package org.example.Visualizador;

import java.io.*;
import org.iesalandalus.programacion.utilidades.Entrada;

public class EjecutaVisualizador {
    public static void main(String[] args) {
        // Siempre es lo mismo: leer teclado + ProcessBuilder + waitFor
        System.out.print("Introduce una cadena: ");
        String texto = Entrada.cadena(); // lo que mandaremos al hijo

        ProcessBuilder pb = new ProcessBuilder(
                "java", "-cp",
                System.getProperty("java.class.path"),
                "org.example.Visualizador.Visualizador", // "Carpeta.Archivo"(Hijo)
                texto, // el texto ES MUY IMPORTANTE
                "5"); // número de veces (como en el ejemplo)

        try {
            // para ver lo que imprime el hijo
            pb.redirectErrorStream(true);
            Process proceso = pb.start();

            // leemos la salida del hijo y la enseñamos
            BufferedReader br = new BufferedReader(
                    new InputStreamReader(proceso.getInputStream()));
            String linea;
            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
            }

            int codigo = proceso.waitFor();
            // comprobamos el codigo con el if
            System.out.println("Valor de salida: " + codigo);
            if (codigo == 0) {
                System.out.println("Final Correcto");
            } else {
                System.out.println("Final Incorrecto");
            }

        } catch (IOException | InterruptedException e) {
            System.out.println("Error... " + e.getMessage());
        }
    }
}
