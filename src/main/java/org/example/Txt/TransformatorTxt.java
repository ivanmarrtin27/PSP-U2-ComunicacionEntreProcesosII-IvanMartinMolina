package org.example.Txt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TransformatorTxt {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // preparo el lector de líneas
            String texto;

            while ((texto = br.readLine()) != null) { // Bucle de lectura
                System.out.println(texto.toUpperCase());
            }

        } catch (IOException e) {
            System.out.println("Error... " + e.getMessage());
        }
    }
}
