package Presentation;

import Data.Check;
import java.util.Scanner;

public class Main {
    static Scanner read = new Scanner(System.in);
    static Check check = new Check();

    public static void main(String[] args) {
        boolean flag = true;

        System.out.print("""
                
                ===========================================
                           CONVERSOR DE MONEDAS
                ===========================================
                
                """);

        while(flag){
            System.out.print("""
                --- Qué deseas realizar? -----
                
                1) Usar el conversor
                2) Ver el historial de conversiones
                3) Salir
                
                Opción:\s""");

            switch ( check.option(read.nextLine()) ){
                case 1: check.start(); break;
                case 2: check.showHistory(); break;
                case 3:
                    System.out.println("Perfecto! Nos vemos luego :]");
                    flag = false; break;
            }
        }
    }
}