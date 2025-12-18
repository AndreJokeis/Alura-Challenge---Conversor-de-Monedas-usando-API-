package Presentation;

import Data.API;
import Data.Check;

import java.util.Scanner;

public class Main {
    static Scanner read = new Scanner(System.in);
    static Check check = new Check();

    public static void start(){
        String base_code, target_code;
        float base_amount;

        System.out.print("""
                
                 - Elija la base a convertir:
                
                1) Dolar (USD)
                2) Pesos mexicanos (MXN)
                3) Pesos argentinos (ARS)
                4) Pesos colombianos (COP)
                5) Reales brasileños (BRL)
                
                Opcion a elegir:\s""");

        int base_option = check.isOption(read.nextLine());
        base_code = switch (base_option){
            case 1 -> "USD";
            case 2 -> "MXN";
            case 3 -> "ARS";
            case 4 -> "COP";
            case 5 -> "BRL";
            default -> "";
        };

        System.out.print("Elija la el monto de la base a convertir: ");
        base_amount = check.isNum(read.nextLine());

        System.out.print("""
                
                 - Elija el objetivo a convertir (excepto el numero\s""" + base_option + """
                ):
                
                1) Dolar (USD)
                2) Pesos mexicanos (MXN)
                3) Pesos argentinos (ARS)
                4) Pesos colombianos (COP)
                5) Reales brasileños (BRL)
                
                Opcion a elegir:\s""");
        int target_option = check.isOption(read.nextLine());

        while(target_option == base_option){
            System.out.print("""
                    El tipo de cambio debe de ser diferente a la base!
                    Elija otra opción:\s
                    """);
            target_option = check.isOption(read.nextLine());
        }

        target_code = switch (target_option){
            case 1 -> "USD";
            case 2 -> "MXN";
            case 3 -> "ARS";
            case 4 -> "COP";
            case 5 -> "BRL";
            default -> "";
        };

        System.out.println("\nEspere un momento...");

        API api = new API(base_code, target_code, base_amount);

        System.out.println(api);
    }

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
                2) Salir
                
                Respuesta:\s""");

            switch ( check.option(read.nextLine()) ){
                case 1: start(); break;
                case 2:
                    System.out.println("Perfecto! Nos vemos luego :]");
                    flag = false; break;
            }
        }
    }
}