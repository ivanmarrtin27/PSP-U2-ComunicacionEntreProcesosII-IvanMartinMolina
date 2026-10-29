package org.example.Argumentos;

import java.io.*;

public class ValidarArgumentos {
    public static void main(String[] args) {
        if (args.length < 1) {
            System.exit(1);
        }

        try {
            int numero = Integer.parseInt(args[0]);

            if (numero < 0) {
                System.exit(3);
            } else {
                System.exit(4);
            }

        } catch (NumberFormatException e) {
            System.exit(2);
        }
    }
}
