package org.example.Txt;

import java.io.*;
import org.iesalandalus.programacion.utilidades.Entrada;

public class LectorTxt {
    public static void main(String[] args) {
        // Siempre es lo mismo: try/catch + ProcessBuilder con la ruta del hijo
        try {
            ProcessBuilder pb = new ProcessBuilder(
                    "java", "-cp",
                    System.getProperty("java.class.path"),
                    "org.example.Txt.TransformatorTxt"); // "Carpeta.Archivo"
            Process proceso = pb.start(); // arrancamos al hijo

            //buffer le escribe al hijo
            BufferedWriter escribirAlHijo = new BufferedWriter(
                    new OutputStreamWriter(proceso.getOutputStream()));

            // eL buffer lee lo que el hijo responde
            BufferedReader leerDelHijo = new BufferedReader(
                    new InputStreamReader(proceso.getInputStream()));

            while (true) {
                String texto = Entrada.cadena(); // leemos del teclado

                if (texto.equalsIgnoreCase("fin")) { // si pone fin, paramos todo
                    escribirAlHijo.close(); // cerramos el "tubo" hacia el hijo
                    proceso.destroy(); // matamos el proceso hijo
                    break;
                }

                // Le mandamos la línea al hijo
                escribirAlHijo.write(texto);
                escribirAlHijo.newLine();
                escribirAlHijo.flush(); // EL flush ES MUY IMPORTANTE (si no, a veces no le llega)

                // El hijo nos devuelve la mayúscula y la enseñamos
                String respuesta = leerDelHijo.readLine();
                System.out.println(respuesta);
            }

            leerDelHijo.close(); // cerramos lo de leer

        } catch (IOException e) {
            System.out.println("Error... " + e.getMessage());
        }
    }
}
