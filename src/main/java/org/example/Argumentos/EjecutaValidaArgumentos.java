package org.example.Argumentos;

import java.io.*;

import org.iesalandalus.programacion.utilidades.Entrada;

public class EjecutaValidaArgumentos {

    public static void main(String[] args) {
        // Siempre es lo mismo, hacemos un tryCatch y añadimos la ruta que es

        ProcessBuilder pb; // Creamos el ProcessBuilder antes de a comprobación

        while (true) {
            String texto = Entrada.cadena(); // Creamos cadena

            if (texto == null || texto.isEmpty()) {// comprobamos si está vacio
                pb = new ProcessBuilder(
                        "java", "-cp",
                        System.getProperty("java.class.path"),
                        "org.example.Argumentos.ValidarArgumentos");// "Carpeta.Archivo"(Hijo)
            } else {
                pb = new ProcessBuilder(
                        "java", "-cp",
                        System.getProperty("java.class.path"),
                        "org.example.Argumentos.ValidarArgumentos", texto);// EL texto ES MUY IMPORTANTE
            }

            try {
                Process proceso = pb.start();
                int codigo = proceso.waitFor();
                switch (codigo) {
                    case 1:
                        System.out.println("Valor de salida: " + codigo);
                        System.out.println("No hay argumentos...");
                        break;
                    case 2:
                        System.out.println("Valor de salida: " + codigo);
                        System.out.println("Es una cadena ");
                        break;
                    case 3:
                        System.out.println("Valor de salida: " + codigo);
                        System.out.println("Número menos que 0...");
                        break;
                    case 4:
                        System.out.println("Valor de salida: " + codigo);
                        System.out.println("Número mayor o igual que 0");
                        break;
                    default:
                        break;
                }

            } catch (IOException | InterruptedException e) {
                System.out.println("Error... " + e.getMessage());
            }

        }
    }
}
