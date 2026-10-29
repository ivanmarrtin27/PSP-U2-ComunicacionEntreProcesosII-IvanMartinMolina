package org.example.Aleatorios;

import java.io.*;
import java.util.Random;

public class Aleatorios {
    public static void main(String[] args) {
        String linea;
        // Por cada linea que nos manden, devolvemos un random 0-10
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            Random random = new Random();

            while ((linea = br.readLine()) != null) {
                int numero = random.nextInt(11); // 0 al 10
                System.out.println(numero);
            }

        } catch (IOException e) {
            System.out.println("Error... " + e.getMessage());
        }
    }
}
